package com.boot.bootlanuch.dao.master;

import com.boot.bootlanuch.entity.master.UserToken;
import com.boot.bootlanuch.entity.master.UserTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTokenDao {
    long countByExample(UserTokenExample example);

    int deleteByExample(UserTokenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserToken record);

    int insertSelective(UserToken record);

    List<UserToken> selectByExample(UserTokenExample example);

    UserToken selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserToken record, @Param("example") UserTokenExample example);

    int updateByExample(@Param("record") UserToken record, @Param("example") UserTokenExample example);

    int updateByPrimaryKeySelective(UserToken record);

    int updateByPrimaryKey(UserToken record);
}