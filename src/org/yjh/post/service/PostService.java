package org.yjh.post.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.yjh.department.domain.CrmDepartment;
import org.yjh.post.dao.CrmPostMapper;
import org.yjh.post.domain.CrmPost;
import org.yjh.util.MyStringUtils;

@Service
public class PostService {
    @Resource
    private CrmPostMapper mapper;

    public CrmPost findById(String postid) {
	return mapper.findById(postid);
    }

    public List<CrmPost> findAll() {
	List<CrmPost> list = mapper.findAll();
	return list;
    }

    public void save(CrmPost post) {
	// 如果id不为空 表示更新
	String postid = post.getPostid();
	if (postid != null && postid != "") {
	    mapper.updateByPrimaryKey(post);
	} else {
	    // 如果id为空，那么就是插入
	    post.setPostid(MyStringUtils.getUUID());
	    mapper.insert(post);
	}
    }

}
