package hpu.zyf.service;

import hpu.zyf.entity.ProductType;
import hpu.zyf.entity.Productdetail;

import java.util.List;

/**
 * 商品信息的接口
 * 商品的添加、删除、修改、查询()等
 * @author admin
 *
 */
public interface ProductService {
	public boolean inserProduct(Productdetail pd)throws Exception;
	public boolean updateProduct(Productdetail pd)throws Exception;
	public boolean deleteProduct(String pdid)throws Exception;
	public Productdetail selectByPdid(String pdid)throws Exception;
	//通过条件进行分页查询,只需要传入页码，每页显示的数据时固定的。
	public List<Productdetail> selectByPdExample(String example,int pageNo)throws Exception;
	//总共的页数
	public int pageTotal(String example)throws Exception;
	public List<ProductType> selectAllType()throws Exception;
}
