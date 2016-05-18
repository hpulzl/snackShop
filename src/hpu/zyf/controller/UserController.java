package hpu.zyf.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import hpu.zyf.entity.Orderdetail;
import hpu.zyf.entity.Productdetail;
import hpu.zyf.entity.User;
import hpu.zyf.entity.vo.UserCustom;
import hpu.zyf.exception.CustomException;
import hpu.zyf.service.AddShopCartService;
import hpu.zyf.service.ProductService;
import hpu.zyf.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.ws.policy.sourcemodel.ModelNode;
/**
 * �û��Ĵ�����������
 * ��Ҫ�ǿ����û��ĵ�¼��ע��
 * �޸��û���Ϣ
 * �Զ����Ĳ���ɾ������ѯ
 * @author admin
 */
//��������ע��
@Controller
//����user·���£�urlע��
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService us;
	@Autowired
	private AddShopCartService ascs;
	@Autowired
	private ProductService ps;
	/**
	 * �û���¼
	 * @param session ��¼�û�����session��
	 * @param user ����ĵ�¼��Ϣ
	 * @return
	 */
	//@ResponseBody��java����ת����json����@RequestBody��json��ת����java����
	//���ó��������java���󣬷��ص���json��
	@RequestMapping(value="/userLogin",method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody boolean userLogin(User user,HttpSession session){
		boolean flag = false;
		try {
			User u = us.userLogin(user.getUserphone(), user.getUserpassword());
			if(u != null){
				flag = true;
				session.setAttribute("userId", u.getUserid());
				session.setAttribute("userName", u.getUsername());
				session.setAttribute("user", u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//response��java����ת����json����
		return flag;
	}
	/**
	 * �û�ע��
	 * @param user ע����Ϣ
	 * @return
	 * @throws Exception �ǿ��쳣��Ϣ
	 */
	@RequestMapping("/userRegister")
	public @ResponseBody boolean userRegister(User user){
		boolean flag = false;
		if(user!=null){
			try {
				flag = us.userRegister(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	/**
	 * �û��˳���¼������session
	 * @param session
	 * @return
	 */
	@RequestMapping("/userLogout")
	public String userLogout(HttpSession session){
		session.invalidate();
		return "redirect:/jsp/user/userLogin.jsp";
	}
	/**
	 * �޸��û�����Ϣ
	 * �������Ҫ�޸ĵ��û���Ϣ
	 * @param nowUser
	 */
	@RequestMapping("/updateUserInfo")
	public @ResponseBody boolean updateUserInfo(String password)throws Exception{
		User user = (User) this.getSession().getAttribute("user");
		user.setUserpassword(password);
		return us.updateUser(user);
	}
	/**
	 * ��ѯ��������ϸ��Ϣ
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findOrderInfo")
	public ModelAndView findOrderInfo()throws Exception{
		String userid = (String) this.getSession().getAttribute("userId");
		ModelAndView mv = new ModelAndView();
		if(userid==null){
			mv.setViewName("user/userLogin");
			return mv;
		}
		UserCustom userCustom = ascs.selectByUserid(userid);
		mv.addObject("userCustom", userCustom);
		mv.setViewName("user/findOrderInfo");
		return mv;
	}
	@RequestMapping("/findUserInfo")
	public ModelAndView findUserInfo()throws Exception{
		User user = (User) this.getSession().getAttribute("user");
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("user/findUserInfo");
		return mv;
	}
	/**
	 * ɾ����������Ϣ
	 * @param orderid
	 * @param odid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteOrderInfo")
	public @ResponseBody boolean deleteOrderInfo(String orderid,String odid)throws Exception{
		return ascs.deleteShopCartByOrderid(orderid, odid);
	}
	
	/**
	 * ��ѯ������Ʒ��View
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addComment",method={RequestMethod.POST,
			RequestMethod.GET})
	public ModelAndView selectByPdid(String id)throws Exception{
		Productdetail productdetail = ps.selectByPdid(id);
		if(productdetail ==null){
			throw new CustomException("������ѯ����Ʒ������");
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("productdetail", productdetail);
		mv.setViewName("user/addComment");
		return mv;
	}
	
	@RequestMapping("/payerOrder")
	public @ResponseBody boolean payerOrder(String orderid)throws Exception{
		return ascs.payByUser(orderid);
	}
	/**
	 * ��ת���������ĵĽ���
	 * @param pdid
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userHomePage")
	private String userHomePage()throws Exception{
		String userid = (String) this.getSession().getAttribute("userId");
		if(userid == null || userid==""){
			return "user/userLogin";
		}
		return "user/userHomePage";
	}
	public static HttpSession getSession() { 
		  HttpSession session = null; 
		  try { 
		    session = getRequest().getSession(); 
		  } catch (Exception e) {} 
		    return session; 
		} 
		  
	public static HttpServletRequest getRequest() { 
	  ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
	  return attrs.getRequest(); 
	} 
}
