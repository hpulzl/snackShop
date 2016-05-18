package hpu.zyf.mapper;

import hpu.zyf.entity.ProductType;

import java.util.List;

/**
 * 商品类型表的操作DAO方法
 * 查询菜单
 * @author admin
 *
 */
public interface ProductTypeMapper {
	public List<ProductType> selectAllPtType() throws Exception;
}
