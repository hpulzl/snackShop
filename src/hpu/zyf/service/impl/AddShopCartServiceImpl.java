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
 * ��ӹ��ﳵ�ӿڵľ����ʵ��
 * ��ӡ�ɾ������ѯ
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
		//�����Ʒ�����ﳵ�����Ȼ�ȡ��Ʒ��id���û�id�͹��ﳵ��ϸ
		String odid = UUIDUtil.getUUId();  //������ϸid
		String orderid = UUIDUtil.getUUId(); //����id
		if(userid !=null){
			//����������Ϣ
			Userorder userOrder = new Userorder(orderid, userid,null, new Date(), false);
			//����������ϸ��Ϣ
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
		//ͨ���û�idɾ���������Լ�������ϸ�е���Ϣ
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
	//ͨ���û���id��ȥ��ѯ�������Լ����������顣
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
		//����ʱ��д�ɹ̶��ģ���Ϊ�ڽ�����Ҳû����ʾ��
		p.setPurchasetime("2016-05-12");
		pm.insert(p);
		Userorder userorder = new Userorder();
		userorder.setIspay(true);
		userorder.setOrderid(orderid);
		um.updateByPrimaryKeySelective(userorder);
		return true;
	}
}
