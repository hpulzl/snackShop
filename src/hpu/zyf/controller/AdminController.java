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
 * ����Ա�Ŀ�����������
 * 1����������Ա��¼��ע�ᡢ�޸�����
 * 2������Ա��ѯ��Ʒ
 * 3������Ա����Ʒ�����ӡ�ɾ����
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
	 * ����Ա��¼
	 * @param session  ����session
	 * @param adminname ����Ա���ֻ��ţ�Ҳ��Ψһ��id
	 * @param adminpassword ����
	 * @return
	 * @throws Exception �쳣�׳�
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
	 * �˳�����Ա������session
	 * @return
	 */
	@RequestMapping("/adminLogout")
	public String adminLogout(){
		this.getSession().removeAttribute("admin");
		return "admin/adminLogin";
	}
	/**
	 * ע�����Ա
	 * @param admin ����Ա��Ϣ
	 * @return 
	 * @throws Exception  �쳣�׳�
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
	 * ��ѯ����Ա����Ϣ
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
	 * �����Ʒ
	 * @param pdetail ��Ʒ��ϸ����
	 * @param picFile ͼƬ�Ķ�������
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addProduct")
	public ModelAndView addProduct(Productdetail pdetail,MultipartFile picFile)throws Exception{
		//��ȡͼƬ������
		String picFileName = picFile.getOriginalFilename();
		//���ļ�����
		String newFileName = UUID.randomUUID().toString()+picFileName.substring(picFileName.lastIndexOf("."));
		//�ϴ�ͼƬ
		File uploadPic = new File("F:/upload/tmp/"+newFileName);
		if(!uploadPic.exists()){ //����ļ������ڣ������ļ�Ŀ¼
			uploadPic.mkdirs();
		}
		//�����д�ļ�
		picFile.transferTo(uploadPic);
		//����ͼƬ������
		pdetail.setPdimage(newFileName);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/addProduct");
		if(pdetail.getDisprice()==null||"".equals(pdetail.getDisprice())){
			//������ۼ۸�Ϊ�յĻ���˵����������Ʒ��ֱ����ӵ���������Ʒ��
			if(ps.inserProduct(pdetail)){
				mv.addObject("message", "��ӳɹ�");
				return mv;
			}
		}else{ //�Ǵ�����Ʒ
				ProductdetailVo pvo = new ProductdetailVo();
				pvo.setDisProduct(new Discountproduct());
				pvo.setProDetail(pdetail);
				if(dps.inserDisProduct(pvo)){
					mv.addObject("message", "��ӳɹ�");
					return mv;
				}
			  }
		//���ɹ��Ļ�������仰
		mv.addObject("message", "���ʧ��");
		return mv;
	}
	/**
	 * ��ѯ����Ա����Ϣ
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delProductInfo")
	public @ResponseBody boolean delProductInfo(String pdid)throws Exception{
		return  ps.deleteProduct(pdid);
	}
	/**
	 * ��ѯ����Ա����Ϣ
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
	 * ��Ʒ�Ĳ�ѯ
	 * @param pageNo ҳ��
	 * @param info ������һҳ����һҳ
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findAdminProductInfo")
	public ModelAndView findAdminProductInfo(int pageNo,String info)throws Exception{
		int currentPageNo = pageNo;
		int totalPageNo = ps.pageTotal("");
		if(currentPageNo<1){
			throw new AdminCustomException("ҳ�벻��С��1");
		}
		if(info!=null && info!="" && !"".equals(info)){
			if(info.equals("pre")&&currentPageNo >1){
				//���Խ�����һҳ
				currentPageNo--;
			}
			if(info.equals("next") && currentPageNo < totalPageNo){
				//���Խ�����һҳ
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
