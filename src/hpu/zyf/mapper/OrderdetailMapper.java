package hpu.zyf.mapper;

import hpu.zyf.entity.Orderdetail;
import hpu.zyf.entity.OrderdetailExample;
import hpu.zyf.entity.User;
import hpu.zyf.entity.vo.UserCustom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderdetailMapper {
    int countByExample(OrderdetailExample example);

    int deleteByExample(OrderdetailExample example);

    int deleteByPrimaryKey(String odid);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    List<Orderdetail> selectByExample(OrderdetailExample example);

    Orderdetail selectByPrimaryKey(String odid);

    int updateByExampleSelective(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByExample(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
    
    UserCustom selectAllByUserid(String userid);
}