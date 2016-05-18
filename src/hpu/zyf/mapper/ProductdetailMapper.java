package hpu.zyf.mapper;

import hpu.zyf.entity.Productdetail;
import hpu.zyf.entity.ProductdetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductdetailMapper {
    int countByExample(ProductdetailExample example);

    int deleteByExample(ProductdetailExample example);

    int deleteByPrimaryKey(String pdid);

    int insert(Productdetail record);

    int insertSelective(Productdetail record);

    List<Productdetail> selectByExampleWithBLOBs(ProductdetailExample example);

    List<Productdetail> selectByExample(ProductdetailExample example);

    Productdetail selectByPrimaryKey(String pdid);

    int updateByExampleSelective(@Param("record") Productdetail record, @Param("example") ProductdetailExample example);

    int updateByExampleWithBLOBs(@Param("record") Productdetail record, @Param("example") ProductdetailExample example);

    int updateByExample(@Param("record") Productdetail record, @Param("example") ProductdetailExample example);

    int updateByPrimaryKeySelective(Productdetail record);

    int updateByPrimaryKeyWithBLOBs(Productdetail record);

    int updateByPrimaryKey(Productdetail record);
}