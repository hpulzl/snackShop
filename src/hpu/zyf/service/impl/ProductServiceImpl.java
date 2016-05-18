package hpu.zyf.service.impl;

import hpu.zyf.entity.Discountproduct;
import hpu.zyf.entity.ProductType;
import hpu.zyf.entity.Productdetail;
import hpu.zyf.entity.ProductdetailExample;
import hpu.zyf.entity.ProductdetailExample.Criteria;
import hpu.zyf.exception.CustomException;
import hpu.zyf.mapper.DiscountproductMapper;
import hpu.zyf.mapper.ProductTypeMapper;
import hpu.zyf.mapper.ProductdetailMapper;
import hpu.zyf.service.ProductService;
import hpu.zyf.util.MyRowBounds;
import hpu.zyf.util.UUIDUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 商品接口的实现类
 * @author admin
 *
 */
public class ProductServiceImpl implements ProductService{
	//设置每页显示10条数据
	public final int pageCount = 10;
	//设置数据库中总记录数
	public int totalCount = 0;
	@Autowired
	private ProductdetailMapper pdm;
	@Autowired
	private DiscountproductMapper dpm;
	@Autowired
	private ProductTypeMapper ptm;
	/**
	 * 添加商品
	 */
	@Override
	public boolean inserProduct(Productdetail pd) throws Exception {
		if(pd==null){
			throw new CustomException("插入-->商品信息不能为空");
		}
		pd.setPdid(UUIDUtil.getUUId());
		pd.setCreatetime(new Date());
		if(pdm.insert(pd)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProduct(Productdetail pd) throws Exception {
		if(pd==null){
			throw new CustomException("更新--->商品信息不能为空");
		}
		//如果某个属性为空，你们就不用更新
		if(pdm.updateByPrimaryKeySelective(pd)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteProduct(String pdid) throws Exception {
		if(pdm.deleteByPrimaryKey(pdid)>0){
			dpm.deleteByPdid(pdid);
			return true;
		}
		return false;
	}

	@Override
	public Productdetail selectByPdid(String pdid) throws Exception {
		Productdetail pd = pdm.selectByPrimaryKey(pdid);
		if(pd == null){
			throw new CustomException("查询的商品为空");
		}
		return pd;
	}

	@Override
	public List<Productdetail> selectByPdExample(String example, int pageNo)
			throws Exception {
		ProductdetailExample pdExample = new ProductdetailExample();
		//设置分页限制
		pdExample.setRowBounds(new MyRowBounds(pageNo, pageCount));
		if(example !=null){ 
			//接下来是类别查询
			Criteria critetia = pdExample.createCriteria();
			critetia.andPdtypeLike("%"+example+"%");
			totalCount = pdm.countByExample(pdExample);
		} 
		 //如果查询条件为空，设置为查询全部
		return pdm.selectByExample(pdExample);
	}

	@Override
	public int pageTotal(String example) throws Exception {
		ProductdetailExample pdExample = new ProductdetailExample();
		int total = 0;
		if(example ==null || "".equals(example)){  //如果查询条件为空，设置为查询全部
			total = pdm.countByExample(pdExample);
		}else{
			//接下来是类别查询
			Criteria critetia = pdExample.createCriteria();
			critetia.andPdtypeLike("%"+example+"%");
			total = pdm.countByExample(pdExample);
		} 
		return MyRowBounds.pageTotal(total, pageCount);
	}

	@Override
	public List<ProductType> selectAllType() throws Exception {
		return ptm.selectAllPtType();
	}
}
