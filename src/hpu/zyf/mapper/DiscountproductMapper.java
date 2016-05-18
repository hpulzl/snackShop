package hpu.zyf.mapper;

import hpu.zyf.entity.Discountproduct;
import hpu.zyf.entity.DiscountproductExample;
import hpu.zyf.entity.ProductdetailExample;
import hpu.zyf.entity.vo.ProductCustom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DiscountproductMapper {
    int countByExample(ProductdetailExample example);
    int deleteByPdid(String pdid);

    int deleteByExample(DiscountproductExample example);

    int deleteByPrimaryKey(String disid);

    int insert(Discountproduct record);

    int insertSelective(Discountproduct record);

    List<ProductCustom> selectByExample(ProductdetailExample example);

    ProductCustom selectByPrimaryKey(String disid);

    int updateByExampleSelective(@Param("record") Discountproduct record, @Param("example") DiscountproductExample example);

    int updateByExample(@Param("record") Discountproduct record, @Param("example") DiscountproductExample example);

    int updateByPrimaryKeySelective(Discountproduct record);

    int updateByPrimaryKey(Discountproduct record);
}