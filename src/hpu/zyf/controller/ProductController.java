package hpu.zyf.controller;

import hpu.zyf.entity.Comment;
import hpu.zyf.entity.ProductType;
import hpu.zyf.entity.Productdetail;
import hpu.zyf.entity.vo.CommentCustom;
import hpu.zyf.entity.vo.ProductCustom;
import hpu.zyf.entity.vo.UserCustom;
import hpu.zyf.exception.CustomException;
import hpu.zyf.service.AddShopCartService;
import hpu.zyf.service.CommentService;
import hpu.zyf.service.DisCountProductService;
import hpu.zyf.service.ProductService;
import hpu.zyf.util.UUIDUtil;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 商品处理器控制器
 * 主要是商品向jsp界面的展示,
 * 查询某个商品的所有评论
 * @author admin
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService ps;
	@Autowired
	private DisCountProductService pds;
	@Autowired
	private CommentService csi;
	@Autowired
	private AddShopCartService ascs;
	/**
	 * 返回主界面的View。
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllByPage",method={RequestMethod.POST,
			RequestMethod.GET})
	public @ResponseBody List<Productdetail> selectAllByPage(int pageNo) throws Exception{
		List<Productdetail> productList = ps.selectByPdExample("", pageNo);
		return productList;
	}
	/**
	 * 查询单个商品的View
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectByPdid",method={RequestMethod.POST,
			RequestMethod.GET})
	public ModelAndView selectByPdid(String id)throws Exception{
		Productdetail productdetail = ps.selectByPdid(id);
		if(productdetail ==null){
			throw new CustomException("你所查询的商品不存在");
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("productdetail", productdetail);
		mv.setViewName("product/selectByPdid");
		return mv;
	}
	/**
	 * 查找所有的菜单项
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllType",method={RequestMethod.POST,
			RequestMethod.GET})
	public @ResponseBody List<ProductType> selectAllType()throws Exception{
		return ps.selectAllType();
	}
	/**
	 * 查询热销食品的信息
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectByHotType",method={RequestMethod.POST,
			RequestMethod.GET})
	public ModelAndView selectByHotType(String pdtype,int pageNo)throws Exception{
		int currentPage = pageNo;
		if(currentPage<1){
			throw new CustomException("页码不对");
		}
		String pdtypes = new String(pdtype.getBytes("iso-8859-1"),"utf-8");
		if(currentPage > ps.pageTotal(pdtypes)){
			currentPage = 1;
		}
		List<Productdetail> productList = ps.selectByPdExample(pdtypes, currentPage++);
		ModelAndView mv = new ModelAndView();
		mv.addObject("productList", productList);
		mv.addObject("currentPage", currentPage);
		mv.setViewName("product/selectByType");
		return mv;
	}
	/**
	 * 查询打折食品的信息
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectByDisType",method={RequestMethod.POST,
			RequestMethod.GET})
	public ModelAndView selectByDisType(String pdtype,int pageNo)throws Exception{
		int currentPage = pageNo;
		if(currentPage<1){
			throw new CustomException("页码不对");
		}
		String pdtypes = new String(pdtype.getBytes("iso-8859-1"),"utf-8");
		if(currentPage > ps.pageTotal(pdtypes)){
			currentPage = 1;
		}
		List<ProductCustom> productCustomList = pds.selectByDisPdExample(pdtypes, currentPage++);
		ModelAndView mv = new ModelAndView();
		mv.addObject("productCustomList", productCustomList);
		mv.addObject("currentPage", currentPage);
		mv.setViewName("product/selectByType");
		return mv;
	}
	/**
	 * 通过pdid来查找该评论的所有的信息
	 * @param pdid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCommentBypdid",method={RequestMethod.POST,
			RequestMethod.GET})
	public @ResponseBody List<CommentCustom> selectCommentBypdid(String pdid)throws Exception{
		return csi.selectCommentBypdid(pdid);
	}
	/**
	 * 查询评论的的相关信息
	 * 根据用户是否购买该商品，来告诉用户是否可以评论。
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findCommentInfo")
	public ModelAndView findCommentInfo()throws Exception{
		String userid = (String) UserController.getSession().getAttribute("userId");
		ModelAndView mv = new ModelAndView();
		if(userid==null){
			mv.setViewName("user/userLogin");
			return mv;
		}
		UserCustom userCustom = ascs.selectByUserid(userid);
		mv.addObject("userCustom", userCustom);
		mv.setViewName("user/findCommentInfo");
		return mv;
	}
	/**
	 * 对某个零食的评论。
	 * @param content 需要评论的内容
	 * @param pdid 商品的id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addComment")
	public @ResponseBody boolean addComment(String content,String pdid)throws Exception{
		Comment com = new Comment();
		String userid = (String) UserController.getSession().getAttribute("userId");
		String commentid = UUIDUtil.getUUId();
		com.setCommentid(commentid);
		com.setPdid(pdid);
		com.setConmmenttime(new Date());
		com.setContent(content);
		com.setUserid(userid);
		com.setCommentscore(5F);
		return csi.addComment(com);
	}
}
