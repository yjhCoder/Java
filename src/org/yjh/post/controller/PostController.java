package org.yjh.post.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yjh.department.domain.CrmDepartment;
import org.yjh.post.domain.CrmPost;
import org.yjh.post.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostService postService;

    @RequestMapping("findById")
    public @ResponseBody CrmPost findById(CrmPost post) {
	String postid = post.getPostid();
	post = postService.findById(postid);
	return post;
    }
    
    @RequestMapping("list")
    public String findAll(Model model){
	List<CrmPost> list = postService.findAll();
	model.addAttribute("list", list);
	return "/post/listPost";
    }
    
    //查找数据库 进入编辑页面
    @RequestMapping("edit")
    public String edit(String postid,Model model){
	CrmPost post =  postService.findById(postid);
	model.addAttribute("post", post);
	return "/post/addOrEditPost";
    }
    
    //保存修改部门
    @RequestMapping("save")
    public String save(CrmPost post){
	postService.save(post);
	return "redirect:/post/list.do";
    }

}
