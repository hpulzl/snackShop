package hpu.zyf.service.impl;

import hpu.zyf.entity.Productdetail;
import hpu.zyf.entity.ProductdetailExample;
import hpu.zyf.entity.ProductdetailExample.Criteria;
import hpu.zyf.entity.vo.ProductCustom;
import hpu.zyf.entity.vo.ProductdetailVo;
import hpu.zyf.mapper.DiscountproductMapper;
import hpu.zyf.mapper.ProductdetailMapper;
import hpu.zyf.service.DisCountProductService;
import hpu.zyf.util.MyRowBounds;
import hpu.zyf.util.UUIDUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * 打折商品的实现方法
 * @author admin
 */
public class DiscountProductServiceImpl implements DisCountProductService{
	//每页显示10条数据
	private final int pageCount = 10;
	@Autowired
	private DiscountproductMapper dpm;
	@Autowired
	private ProductdetailMapper pdm;
	@Override
	public boolean inserDisProduct(ProductdetailVo pdVo) throws Exception {
		//插入方法，同时进行商品表和打折表的插入,这里先将数据插入到打折表中，再根据打折表
		//打折表的id
		String disid = UUIDUtil.getUUId();
		pdVo.getDisProduct().setDisid(disid);
		//商品表的id
		String pdid = UUIDUtil.getUUId();
		pdVo.getDisProduct().setPdid(pdid);
		
		pdVo.getProDetail().setPdid(pdid);
		pdVo.getProDetail().setDisid(disid);
		dpm.insertSelective(pdVo.getDisProduct());
		pdm.insertSelective(pdVo.getProDetail());
		return true;
	}

	@Override
	public boolean deleteDisProduct(String disid) throws Exception {
		//删除操作，不同级联其他表
		if(dpm.deleteByPrimaryKey(disid)>0){
			return true;
		}
		return false;
	}

	@Override
	public ProductCustom selectDisByPdid(String disid) throws Exception {
		return dpm.selectByPrimaryKey(disid);
	}

	@Override
	public List<ProductCustom> selectByDisPdExample(String example, int pageNo)
			throws Exception {
		ProductdetailExample pdExample = new ProductdetailExample();
		pdExample.setRowBounds(new MyRowBounds(pageNo,pageCount));
		if(example != null){
			pdExample.setPdType(example.trim());
		}
		return dpm.selectByExample(pdExample);
	}

	@Override
	public int pageTotal(String example) throws Exception {
		//获取总页码
		ProductdetailExample pdExample = new ProductdetailExample();
		pdExample.setPdType(example.trim());
		return MyRowBounds.pageTotal(dpm.countByExample(pdExample), pageCount);
	}

}
