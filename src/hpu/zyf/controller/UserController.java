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
 * 用户的处理器控制器
 * 主要是控制用户的登录和注册
 * 修改用户信息
 * 对订单的操作删除、查询
 * @author admin
 */
//控制器的注解
@Controller
//属于user路径下，url注解
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService us;
	@Autowired
	private AddShopCartService ascs;
	@Autowired
	private ProductService ps;
	/**
	 * 用户登录
	 * @param session 登录用户存入session中
	 * @param user 传入的登录信息
	 * @return
	 */
	//@ResponseBody将java对象转换成json串，@RequestBody将json串转换成java对象
	//设置成请求的是java对象，返回的是json串
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
		//response将java对象转换成json数据
		return flag;
	}
	/**
	 * 用户注册
	 * @param user 注册信息
	 * @return
	 * @throws Exception 非空异常信息
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
	 * 用户退出登录，消除session
	 * @param session
	 * @return
	 */
	@RequestMapping("/userLogout")
	public String userLogout(HttpSession session){
		session.invalidate();
		return "redirect:/jsp/user/userLogin.jsp";
	}
	/**
	 * 修改用户的信息
	 * 传入的是要修改的用户信息
	 * @param nowUser
	 */
	@RequestMapping("/updateUserInfo")
	public @ResponseBody boolean updateUserInfo(String password)throws Exception{
		User user = (User) this.getSession().getAttribute("user");
		user.setUserpassword(password);
		return us.updateUser(user);
	}
	/**
	 * 查询订单的详细信息
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
	 * 删除订单的信息
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
	 * 查询单个商品的View
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addComment",method={RequestMethod.POST,
			RequestMethod.GET})
	public ModelAndView selectByPdid(String id)throws Exception{
		Productdetail productdetail = ps.selectByPdid(id);
		if(productdetail ==null){
			throw new CustomException("你所查询的商品不存在");
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
	 * 跳转至个人中心的界面
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
