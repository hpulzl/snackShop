package hpu.zyf.mapper;

import hpu.zyf.entity.ProductType;

import java.util.List;

/**
 * ��Ʒ���ͱ�Ĳ���DAO����
 * ��ѯ�˵�
 * @author admin
 *
 */
public interface ProductTypeMapper {
	public List<ProductType> selectAllPtType() throws Exception;
}
