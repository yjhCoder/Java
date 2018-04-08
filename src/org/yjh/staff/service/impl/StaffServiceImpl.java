package org.yjh.staff.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.tomcat.util.http.mapper.Mapper;
import org.springframework.stereotype.Service;
import org.yjh.staff.dao.CrmStaffMapper;
import org.yjh.staff.domain.CrmStaff;
import org.yjh.staff.domain.CrmStaffExample;
import org.yjh.staff.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
    
    @Resource
    private CrmStaffMapper mapper;
    
    @Override
    public List<CrmStaff> findAll(String depId, String postId, String staffName) {
	return mapper.findAll(depId,postId,staffName);
    }

    @Override
    public CrmStaff login(Map<String, String> staffMap) {
	return mapper.login(staffMap);
    }

    @Override
    public void insert(CrmStaff staff) {
	mapper.insert(staff);
    }

    @Override
    public CrmStaff findById(String staffid) {
	return mapper.selectByPrimaryKey(staffid);
    }

    @Override
    public void update(CrmStaff staff) {
	mapper.updateByPrimaryKey(staff);
    }


}
