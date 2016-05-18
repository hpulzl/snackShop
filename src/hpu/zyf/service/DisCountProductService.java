package hpu.zyf.service;

import hpu.zyf.entity.Productdetail;
import hpu.zyf.entity.vo.ProductCustom;
import hpu.zyf.entity.vo.ProductdetailVo;

import java.util.List;

/**
 * ������Ʒ��Ϣ�Ľӿ�
 * ��Ʒ����ӡ�ɾ������ѯ()��
 * @author admin
 *
 */
public interface DisCountProductService {
	public boolean inserDisProduct(ProductdetailVo pd)throws Exception;
	public boolean deleteDisProduct(String pdid)throws Exception;
	public ProductCustom selectDisByPdid(String disid)throws Exception;
	//ͨ���������з�ҳ��ѯ,ֻ��Ҫ����ҳ�룬ÿҳ��ʾ������ʱ�̶��ġ�
	public List<ProductCustom> selectByDisPdExample(String example,int pageNo)throws Exception;
	//�ܹ���ҳ��
	public int pageTotal(String example)throws Exception;
}
