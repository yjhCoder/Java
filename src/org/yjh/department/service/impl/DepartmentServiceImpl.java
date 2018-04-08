package org.yjh.department.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.lang.model.element.Element;

import org.springframework.stereotype.Service;
import org.yjh.department.dao.CrmDepartmentMapper;
import org.yjh.department.domain.CrmDepartment;
import org.yjh.department.service.DepartementService;
import org.yjh.staff.domain.CrmStaff;
import org.yjh.util.MyStringUtils;

@Service
public class DepartmentServiceImpl implements DepartementService {

    @Resource
    private CrmDepartmentMapper mapper;
    
    @Override
    public CrmDepartment findById(String depId) {
	return mapper.findById(depId);
    }

    @Override
    public List<CrmDepartment> findAll() {
	return mapper.findAll();
    }

    @Override
    public void save(CrmDepartment department) {
	//如果id不为空 表示更新
	String depid = department.getDepid();
	if (depid!=null&&depid!="") {
	    mapper.updateByPrimaryKey(department);
	}else{
	    //如果id为空，那么就是插入
	    department.setDepid(MyStringUtils.getUUID());
	    mapper.insert(department);
	}
    }

}
