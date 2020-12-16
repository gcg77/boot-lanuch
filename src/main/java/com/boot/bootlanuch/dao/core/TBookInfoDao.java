package com.boot.bootlanuch.dao.core;

import com.boot.bootlanuch.entity.core.TBookInfo;
import com.boot.bootlanuch.entity.core.TBookInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TBookInfoDao {
    long countByExample(TBookInfoExample example);

    int deleteByExample(TBookInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBookInfo record);

    int insertSelective(TBookInfo record);

    List<TBookInfo> selectByExample(TBookInfoExample example);

    TBookInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBookInfo record, @Param("example") TBookInfoExample example);

    int updateByExample(@Param("record") TBookInfo record, @Param("example") TBookInfoExample example);

    int updateByPrimaryKeySelective(TBookInfo record);

    int updateByPrimaryKey(TBookInfo record);
}