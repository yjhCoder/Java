package org.yjh.department.domain;

import java.util.HashSet;
import java.util.Set;

import org.yjh.post.domain.CrmPost;

public class CrmDepartment {
    private String depid;

    private String depname;
    
    private Set<CrmPost> postSet = new HashSet<CrmPost>(); //一个部门有多个职务

    
    public Set<CrmPost> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<CrmPost> postSet) {
        this.postSet = postSet;
    }

    public String getDepid() {
        return depid;
    }

    public void setDepid(String depid) {
        this.depid = depid == null ? null : depid.trim();
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname == null ? null : depname.trim();
    }
}