package com.boot.bootlanuch.dao.master;

import com.boot.bootlanuch.entity.master.TUserOds;
import com.boot.bootlanuch.entity.master.TUserOdsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserOdsDao {
    long countByExample(TUserOdsExample example);

    int deleteByExample(TUserOdsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserOds record);

    int insertSelective(TUserOds record);

    List<TUserOds> selectByExample(TUserOdsExample example);

    TUserOds selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserOds record, @Param("example") TUserOdsExample example);

    int updateByExample(@Param("record") TUserOds record, @Param("example") TUserOdsExample example);

    int updateByPrimaryKeySelective(TUserOds record);

    int updateByPrimaryKey(TUserOds record);
}