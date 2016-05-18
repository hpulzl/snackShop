package hpu.zyf.service;

import hpu.zyf.entity.Productdetail;
import hpu.zyf.entity.vo.ProductCustom;
import hpu.zyf.entity.vo.ProductdetailVo;

import java.util.List;

/**
 * 打折商品信息的接口
 * 商品的添加、删除、查询()等
 * @author admin
 *
 */
public interface DisCountProductService {
	public boolean inserDisProduct(ProductdetailVo pd)throws Exception;
	public boolean deleteDisProduct(String pdid)throws Exception;
	public ProductCustom selectDisByPdid(String disid)throws Exception;
	//通过条件进行分页查询,只需要传入页码，每页显示的数据时固定的。
	public List<ProductCustom> selectByDisPdExample(String example,int pageNo)throws Exception;
	//总共的页数
	public int pageTotal(String example)throws Exception;
}
