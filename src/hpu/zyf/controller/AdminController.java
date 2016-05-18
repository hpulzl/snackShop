package hpu.zyf.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import hpu.zyf.entity.Admin;
import hpu.zyf.entity.Discountproduct;
import hpu.zyf.entity.Productdetail;
import hpu.zyf.entity.vo.ProductdetailVo;
import hpu.zyf.exception.AdminCustomException;
import hpu.zyf.service.AdminService;
import hpu.zyf.service.DisCountProductService;
import hpu.zyf.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 管理员的控制器处理器
 * 1、包括管理员登录、注册、修改密码
 * 2、管理员查询商品
 * 3、管理员对商品的增加、删除等
 * @author admin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService as;
	@Autowired
	private ProductService ps;
	@Autowired
	private DisCountProductService dps;
	/**
	 * 管理员登录
	 * @param session  引入session
	 * @param adminname 管理员的手机号，也是唯一的id
	 * @param adminpassword 密码
	 * @return
	 * @throws Exception 异常抛出
	 */
	@RequestMapping("/adminLogin")
	public @ResponseBody boolean adminLogin(HttpSession session,String adminname,String adminpassword)throws Exception{
		if(adminname !=null && adminpassword !=null){
			Admin admin = as.adminLogin(adminname, adminpassword);
			if(admin != null){
				session.setAttribute("admin", admin);
				return true;
			}
			return false;
		}
		return false;
	}
	/**
	 * 退出管理员，消除session
	 * @return
	 */
	@RequestMapping("/adminLogout")
	public String adminLogout(){
		this.getSession().removeAttribute("admin");
		return "admin/adminLogin";
	}
	/**
	 * 注册管理员
	 * @param admin 管理员信息
	 * @return 
	 * @throws Exception  异常抛出
	 */
	@RequestMapping("/adminRegister")
	public @ResponseBody boolean adminRegister(Admin admin)throws Exception{
		if(admin!=null){
			boolean flag = as.adminRegister(admin);
			return flag;
		}
		return false;
	}
	/**
	 * 查询管理员的信息
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findAdminInfo")
	public ModelAndView findAdminInfo()throws Exception{
		Admin admin = (Admin) this.getSession().getAttribute("admin");
		ModelAndView mv = new ModelAndView();
		mv.addObject("admin",admin);
		mv.setViewName("admin/findAdminInfo");
		return mv;
	}
	/**
	 * 添加商品
	 * @param pdetail 商品详细内容
	 * @param picFile 图片的二进制流
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addProduct")
	public ModelAndView addProduct(Productdetail pdetail,MultipartFile picFile)throws Exception{
		//获取图片的名称
		String picFileName = picFile.getOriginalFilename();
		//新文件名称
		String newFileName = UUID.randomUUID().toString()+picFileName.substring(picFileName.lastIndexOf("."));
		//上传图片
		File uploadPic = new File("F:/upload/tmp/"+newFileName);
		if(!uploadPic.exists()){ //如果文件不存在，创建文件目录
			uploadPic.mkdirs();
		}
		//向磁盘写文件
		picFile.transferTo(uploadPic);
		//设置图片新名称
		pdetail.setPdimage(newFileName);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/addProduct");
		if(pdetail.getDisprice()==null||"".equals(pdetail.getDisprice())){
			//如果打折价格为空的话，说明是正常商品。直接添加到正常的商品中
			if(ps.inserProduct(pdetail)){
				mv.addObject("message", "添加成功");
				return mv;
			}
		}else{ //是打折商品
				ProductdetailVo pvo = new ProductdetailVo();
				pvo.setDisProduct(new Discountproduct());
				pvo.setProDetail(pdetail);
				if(dps.inserDisProduct(pvo)){
					mv.addObject("message", "添加成功");
					return mv;
				}
			  }
		//不成功的话返回这句话
		mv.addObject("message", "添加失败");
		return mv;
	}
	/**
	 * 查询管理员的信息
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delProductInfo")
	public @ResponseBody boolean delProductInfo(String pdid)throws Exception{
		return  ps.deleteProduct(pdid);
	}
	/**
	 * 查询管理员的信息
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findupdateAdminInfo")
	public @ResponseBody boolean findupdateAdminInfo(String password)throws Exception{
		Admin admin = (Admin) this.getSession().getAttribute("admin");
		admin.setAdminpassword(password);
		boolean flag = as.updateAdmin(admin);
		return flag;
	}
	/**
	 * 商品的查询
	 * @param pageNo 页码
	 * @param info 控制上一页，下一页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findAdminProductInfo")
	public ModelAndView findAdminProductInfo(int pageNo,String info)throws Exception{
		int currentPageNo = pageNo;
		int totalPageNo = ps.pageTotal("");
		if(currentPageNo<1){
			throw new AdminCustomException("页码不能小于1");
		}
		if(info!=null && info!="" && !"".equals(info)){
			if(info.equals("pre")&&currentPageNo >1){
				//可以进行上一页
				currentPageNo--;
			}
			if(info.equals("next") && currentPageNo < totalPageNo){
				//可以进行下一页
				currentPageNo++;
			}
		}
		List<Productdetail> productdetails = ps.selectByPdExample("", currentPageNo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/findAdminProductInfo");
		mv.addObject("productdetails", productdetails);
		mv.addObject("currentPageNo", currentPageNo);
		mv.addObject("totalPageNo", totalPageNo);
		return mv;
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
