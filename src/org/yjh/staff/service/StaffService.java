package org.yjh.staff.service;

import java.util.List;
import java.util.Map;

import org.yjh.staff.domain.CrmStaff;

public interface StaffService {

    List<CrmStaff> findAll(String depId, String postId, String staffName);

    CrmStaff login(Map<String, String> staffMap);

    void insert(CrmStaff staff);

    CrmStaff findById(String staffid);

    void update(CrmStaff staff);

}
