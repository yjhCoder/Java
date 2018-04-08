package org.yjh.staff.domain;

import java.util.Date;

import org.yjh.department.domain.CrmDepartment;
import org.yjh.post.domain.CrmPost;

public class CrmStaff {
    private String staffid;

    private String loginname;

    private String loginpwd;

    private String staffname;

    private String gender;

    private Date ondutydate;

    private String postid;
    
    private CrmPost post; //职员的部门，一个员工一个部门，一个部门多个员工，一对多
    
    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid == null ? null : staffid.trim();
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd == null ? null : loginpwd.trim();
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname == null ? null : staffname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getOndutydate() {
        return ondutydate;
    }

    public void setOndutydate(Date ondutydate) {
        this.ondutydate = ondutydate;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid == null ? null : postid.trim();
    }

    public CrmPost getPost() {
        return post;
    }

    public void setPost(CrmPost post) {
        this.post = post;
    }

    @Override
    public String toString() {
	return "CrmStaff [staffid=" + staffid + ", loginname=" + loginname + ", loginpwd=" + loginpwd + ", staffname="
		+ staffname + ", gender=" + gender + ", ondutydate=" + ondutydate + ", postid=" + postid + ", post="
		+ post + "]";
    }

}