package com.boot.bootlanuch.dao.core;

import com.boot.bootlanuch.entity.core.TUserOdsCore;
import com.boot.bootlanuch.entity.core.TUserOdsCoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserOdsCoreDao {
    long countByExample(TUserOdsCoreExample example);

    int deleteByExample(TUserOdsCoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserOdsCore record);

    int insertSelective(TUserOdsCore record);

    List<TUserOdsCore> selectByExample(TUserOdsCoreExample example);

    TUserOdsCore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserOdsCore record, @Param("example") TUserOdsCoreExample example);

    int updateByExample(@Param("record") TUserOdsCore record, @Param("example") TUserOdsCoreExample example);

    int updateByPrimaryKeySelective(TUserOdsCore record);

    int updateByPrimaryKey(TUserOdsCore record);
}