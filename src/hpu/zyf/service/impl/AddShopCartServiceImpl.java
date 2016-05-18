package hpu.zyf.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hpu.zyf.entity.Orderdetail;
import hpu.zyf.entity.OrderdetailExample;
import hpu.zyf.entity.OrderdetailExample.Criteria;
import hpu.zyf.entity.Productdetail;
import hpu.zyf.entity.Purchase;
import hpu.zyf.entity.User;
import hpu.zyf.entity.Userorder;
import hpu.zyf.entity.UserorderExample;
import hpu.zyf.entity.vo.OrderdetailVo;
import hpu.zyf.entity.vo.UserCustom;
import hpu.zyf.mapper.OrderdetailMapper;
import hpu.zyf.mapper.ProductdetailMapper;
import hpu.zyf.mapper.PurchaseMapper;
import hpu.zyf.mapper.UserorderMapper;
import hpu.zyf.service.AddShopCartService;
import hpu.zyf.util.UUIDUtil;

/**
 * 添加购物车接口的具体的实现
 * 添加、删除、查询
 * @author admin
 */
public class AddShopCartServiceImpl implements AddShopCartService{
	@Autowired
	private OrderdetailMapper om;
	@Autowired
	private UserorderMapper um;
	@Autowired
	private ProductdetailMapper pdm;
	@Autowired
	private PurchaseMapper pm;
	@Override
	public boolean addShopCart(String userid, String pdid, Orderdetail detail)
			throws Exception {
		//添加商品到购物车，首先获取商品的id和用户id和购物车明细
		String odid = UUIDUtil.getUUId();  //订单明细id
		String orderid = UUIDUtil.getUUId(); //订单id
		if(userid !=null){
			//创建订单信息
			Userorder userOrder = new Userorder(orderid, userid,null, new Date(), false);
			//创建订单详细信息
			Orderdetail orderDetail = detail;
			orderDetail.setOdid(odid);
			orderDetail.setOrderid(orderid);
			orderDetail.setPdid(pdid);
			om.insert(orderDetail);
			um.insert(userOrder);
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteShopCartByUserid(String userid,String odid,String orderid) throws Exception {
		//通过用户id删除订单，以及订单明细中的信息
		UserorderExample example = new UserorderExample();
		hpu.zyf.entity.UserorderExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andOrderidEqualTo(orderid);
		um.deleteByExample(example);
		om.deleteByPrimaryKey(odid);
		return true;
	}

	@Override
	public boolean deleteShopCartByOrderid(String orderid,String odid) throws Exception {
		um.deleteByPrimaryKey(orderid);
		om.deleteByPrimaryKey(odid);
		return true;
	}
	//通过用户的id号去查询订单，以及订单的详情。
	@Override
	public UserCustom selectByUserid(String userid) throws Exception {
		
		return om.selectAllByUserid(userid);
	}
	
	@Override
	public boolean payByUser(String orderid) throws Exception {
		String purchaseid = UUIDUtil.getUUId();
		Purchase p = new Purchase();
		p.setPurchaseid(purchaseid);
		p.setOrderid(orderid);
		//这里时间写成固定的，因为在界面上也没有显示。
		p.setPurchasetime("2016-05-12");
		pm.insert(p);
		Userorder userorder = new Userorder();
		userorder.setIspay(true);
		userorder.setOrderid(orderid);
		um.updateByPrimaryKeySelective(userorder);
		return true;
	}
}
