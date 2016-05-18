package hpu.zyf.controller;

import javax.servlet.http.HttpSession;

import hpu.zyf.entity.Orderdetail;
import hpu.zyf.service.AddShopCartService;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

/**
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("/shop")
public class ShopCartController {
	@Autowired
	private AddShopCartService ascs;
	/**
	 * 用户加入商品到购物车
	 * @param userid
	 * @param pdid
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/AddShopCartByProId")
	private @ResponseBody boolean AddShopCartByProId(String pdid,Orderdetail detail)throws Exception{
		String userid = (String) UserController.getSession().getAttribute("userId");
		boolean flag = ascs.addShopCart(userid, pdid, detail);
		return flag;
	}
}
