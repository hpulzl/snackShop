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
 * ��Ʒ�ӿڵ�ʵ����
 * @author admin
 *
 */
public class ProductServiceImpl implements ProductService{
	//����ÿҳ��ʾ10������
	public final int pageCount = 10;
	//�������ݿ����ܼ�¼��
	public int totalCount = 0;
	@Autowired
	private ProductdetailMapper pdm;
	@Autowired
	private DiscountproductMapper dpm;
	@Autowired
	private ProductTypeMapper ptm;
	/**
	 * �����Ʒ
	 */
	@Override
	public boolean inserProduct(Productdetail pd) throws Exception {
		if(pd==null){
			throw new CustomException("����-->��Ʒ��Ϣ����Ϊ��");
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
			throw new CustomException("����--->��Ʒ��Ϣ����Ϊ��");
		}
		//���ĳ������Ϊ�գ����ǾͲ��ø���
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
			throw new CustomException("��ѯ����ƷΪ��");
		}
		return pd;
	}

	@Override
	public List<Productdetail> selectByPdExample(String example, int pageNo)
			throws Exception {
		ProductdetailExample pdExample = new ProductdetailExample();
		//���÷�ҳ����
		pdExample.setRowBounds(new MyRowBounds(pageNo, pageCount));
		if(example !=null){ 
			//������������ѯ
			Criteria critetia = pdExample.createCriteria();
			critetia.andPdtypeLike("%"+example+"%");
			totalCount = pdm.countByExample(pdExample);
		} 
		 //�����ѯ����Ϊ�գ�����Ϊ��ѯȫ��
		return pdm.selectByExample(pdExample);
	}

	@Override
	public int pageTotal(String example) throws Exception {
		ProductdetailExample pdExample = new ProductdetailExample();
		int total = 0;
		if(example ==null || "".equals(example)){  //�����ѯ����Ϊ�գ�����Ϊ��ѯȫ��
			total = pdm.countByExample(pdExample);
		}else{
			//������������ѯ
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
