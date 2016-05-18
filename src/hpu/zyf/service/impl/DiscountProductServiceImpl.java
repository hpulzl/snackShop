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
 * ������Ʒ��ʵ�ַ���
 * @author admin
 */
public class DiscountProductServiceImpl implements DisCountProductService{
	//ÿҳ��ʾ10������
	private final int pageCount = 10;
	@Autowired
	private DiscountproductMapper dpm;
	@Autowired
	private ProductdetailMapper pdm;
	@Override
	public boolean inserDisProduct(ProductdetailVo pdVo) throws Exception {
		//���뷽����ͬʱ������Ʒ��ʹ��۱�Ĳ���,�����Ƚ����ݲ��뵽���۱��У��ٸ��ݴ��۱�
		//���۱��id
		String disid = UUIDUtil.getUUId();
		pdVo.getDisProduct().setDisid(disid);
		//��Ʒ���id
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
		//ɾ����������ͬ����������
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
		//��ȡ��ҳ��
		ProductdetailExample pdExample = new ProductdetailExample();
		pdExample.setPdType(example.trim());
		return MyRowBounds.pageTotal(dpm.countByExample(pdExample), pageCount);
	}

}
