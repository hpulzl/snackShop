package hpu.zyf.mapper;

import hpu.zyf.entity.Userorder;
import hpu.zyf.entity.UserorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserorderMapper {
    int countByExample(UserorderExample example);

    int deleteByExample(UserorderExample example);

    int deleteByPrimaryKey(String orderid);

    int insert(Userorder record);

    int insertSelective(Userorder record);

    List<Userorder> selectByExample(UserorderExample example);

    Userorder selectByPrimaryKey(String orderid);

    int updateByExampleSelective(@Param("record") Userorder record, @Param("example") UserorderExample example);

    int updateByExample(@Param("record") Userorder record, @Param("example") UserorderExample example);

    int updateByPrimaryKeySelective(Userorder record);

    int updateByPrimaryKey(Userorder record);
}