package org.yjh.classes.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.yjh.classes.domain.CrmClass;
import org.yjh.classes.domain.CrmClassExample;

public interface CrmClassMapper {
    int countByExample(CrmClassExample example);

    int deleteByExample(CrmClassExample example);

    int deleteByPrimaryKey(String classid);

    int insert(CrmClass record);

    int insertSelective(CrmClass record);

    List<CrmClass> selectByExample(CrmClassExample example);

    CrmClass selectByPrimaryKey(String classid);

    int updateByExampleSelective(@Param("record") CrmClass record, @Param("example") CrmClassExample example);

    int updateByExample(@Param("record") CrmClass record, @Param("example") CrmClassExample example);

    int updateByPrimaryKeySelective(CrmClass record);

    int updateByPrimaryKey(CrmClass record);
}