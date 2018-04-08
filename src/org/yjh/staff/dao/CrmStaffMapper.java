package org.yjh.staff.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.yjh.staff.domain.CrmStaff;
import org.yjh.staff.domain.CrmStaffExample;

public interface CrmStaffMapper {
    int countByExample(CrmStaffExample example);

    int deleteByExample(CrmStaffExample example);

    int deleteByPrimaryKey(String staffid);

    int insert(CrmStaff record);

    int insertSelective(CrmStaff record);

    List<CrmStaff> selectByExample(CrmStaffExample example);

    CrmStaff selectByPrimaryKey(String staffid);

    int updateByExampleSelective(@Param("record") CrmStaff record, @Param("example") CrmStaffExample example);

    int updateByExample(@Param("record") CrmStaff record, @Param("example") CrmStaffExample example);

    int updateByPrimaryKeySelective(CrmStaff record);

    int updateByPrimaryKey(CrmStaff record);

    List<CrmStaff> findAll(@Param("depId")String depId, @Param("postId")String postId, @Param("staffName")String staffName);

    CrmStaff login(Map<String, String> staffMap);
}