package hpu.zyf.service;

import hpu.zyf.entity.ProductType;
import hpu.zyf.entity.Productdetail;

import java.util.List;

/**
 * ��Ʒ��Ϣ�Ľӿ�
 * ��Ʒ����ӡ�ɾ�����޸ġ���ѯ()��
 * @author admin
 *
 */
public interface ProductService {
	public boolean inserProduct(Productdetail pd)throws Exception;
	public boolean updateProduct(Productdetail pd)throws Exception;
	public boolean deleteProduct(String pdid)throws Exception;
	public Productdetail selectByPdid(String pdid)throws Exception;
	//ͨ���������з�ҳ��ѯ,ֻ��Ҫ����ҳ�룬ÿҳ��ʾ������ʱ�̶��ġ�
	public List<Productdetail> selectByPdExample(String example,int pageNo)throws Exception;
	//�ܹ���ҳ��
	public int pageTotal(String example)throws Exception;
	public List<ProductType> selectAllType()throws Exception;
}
