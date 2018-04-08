package org.yjh.department.service;

import java.util.List;

import org.yjh.department.domain.CrmDepartment;
import org.yjh.staff.domain.CrmStaff;

public interface DepartementService {

    CrmDepartment findById(String depId);

    List<CrmDepartment> findAll();

    void save(CrmDepartment department);

}
