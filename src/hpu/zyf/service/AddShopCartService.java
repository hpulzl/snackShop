package hpu.zyf.service;

import hpu.zyf.entity.Orderdetail;
import hpu.zyf.entity.User;
import hpu.zyf.entity.vo.UserCustom;

import java.util.List;

/**
 * 添加购物车提供的接口
 * 关联到订单、商品、用户等
 * @author admin
 */
public interface AddShopCartService {
	//添加正常商品到购物车
	boolean addShopCart(String userid,String pdid,Orderdetail detail)throws Exception;
	//通过用户id删除订单信息
	boolean deleteShopCartByUserid(String userid,String odid,String orderid)throws Exception;
	//通过订单id删除订单信息
	boolean deleteShopCartByOrderid(String orderid,String odid)throws Exception;
	//查询订单，通过用户id查询该用户的所有订单
	UserCustom selectByUserid(String userid)throws Exception;
	//购买商品
	boolean payByUser(String orderId)throws Exception;
}
