package org.yjh.post.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.yjh.post.domain.CrmPost;
import org.yjh.post.domain.CrmPostExample;

public interface CrmPostMapper {
    int countByExample(CrmPostExample example);

    int deleteByExample(CrmPostExample example);

    int deleteByPrimaryKey(String postid);

    int insert(CrmPost record);

    int insertSelective(CrmPost record);

    List<CrmPost> selectByExample(CrmPostExample example);

    CrmPost selectByPrimaryKey(String postid);

    int updateByExampleSelective(@Param("record") CrmPost record, @Param("example") CrmPostExample example);

    int updateByExample(@Param("record") CrmPost record, @Param("example") CrmPostExample example);

    int updateByPrimaryKeySelective(CrmPost record);

    int updateByPrimaryKey(CrmPost record);

    List<CrmPost> findAll();

    CrmPost findById(String postid);
}