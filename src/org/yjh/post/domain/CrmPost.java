package org.yjh.post.domain;

import java.util.HashSet;
import java.util.Set;

import org.yjh.department.domain.CrmDepartment;
import org.yjh.staff.domain.CrmStaff;

public class CrmPost {
    private String postid;

    private String postname;

    private String depid;
    
    private CrmDepartment department;  //多个职务 属性一个部门
    
    private Set<CrmStaff> staffSet = new HashSet<CrmStaff>();   //一对多：一个职务有多个员工  选择集合Set 不重复，无序
    
    public CrmDepartment getDepartment() {
        return department;
    }

    public void setDepartment(CrmDepartment department) {
        this.department = department;
    }

    public Set<CrmStaff> getLiStaffs() {
        return staffSet;
    }

    public void setLiStaffs(Set<CrmStaff> staffSet) {
        this.staffSet = staffSet;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid == null ? null : postid.trim();
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname == null ? null : postname.trim();
    }

    public String getDepid() {
        return depid;
    }

    public void setDepid(String depid) {
        this.depid = depid == null ? null : depid.trim();
    }
}