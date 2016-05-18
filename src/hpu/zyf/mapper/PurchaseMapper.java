package hpu.zyf.mapper;

import hpu.zyf.entity.Purchase;
import hpu.zyf.entity.PurchaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseMapper {
    int countByExample(PurchaseExample example);

    int deleteByExample(PurchaseExample example);

    int deleteByPrimaryKey(String purchaseid);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    List<Purchase> selectByExample(PurchaseExample example);

    Purchase selectByPrimaryKey(String purchaseid);

    int updateByExampleSelective(@Param("record") Purchase record, @Param("example") PurchaseExample example);

    int updateByExample(@Param("record") Purchase record, @Param("example") PurchaseExample example);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);
}