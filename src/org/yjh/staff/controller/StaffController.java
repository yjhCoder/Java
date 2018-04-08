package org.yjh.staff.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yjh.staff.domain.CrmStaff;
import org.yjh.staff.service.StaffService;
import org.yjh.util.MyStringUtils;

@Controller
@RequestMapping("/staff")
public class StaffController{
    
    @Resource
    private StaffService staffService;
    
    //查询所有
    @RequestMapping("list")
    public String findAll(String depId,String postId,String staffName,Model model){
	List<CrmStaff> list =  staffService.findAll(depId,postId,staffName);
	model.addAttribute("list", list);
	return "staff/listStaff";
    }
    
    //登录
    @RequestMapping("login")
    public String login(String loginName,String password,Model model,HttpSession session){
	//查询，数据库有 登录成功  否则重定向会登录界面
	Map<String,String> staffMap = new HashMap<String,String>();
	staffMap.put("loginName", loginName);
	staffMap.put("password", password);
	CrmStaff staff = staffService.login(staffMap);
	if (staff!=null) {
	    session.setAttribute("loginStaff", staff);
	    return "frame";
	}
	//失败
	model.addAttribute("error", "用户名 密码不匹配");
	return "login";
    }
    
    //TODO
    
 /*   //登录
    @RequestMapping("login")
    public String login(CrmStaff staff,Model model){
	//查询，数据库有 登录成功  否则重定向会登录界面
	Map<String,String> staffMap = new HashMap<String,String>();
	staffMap.put("loginName", loginName);
	staffMap.put("password", password);
	CrmStaff staff = staffService.login(staffMap);
	
	return "";
    }*/
    
    
    //注销
    @RequestMapping("logout")
    public String logout(HttpSession session){
	session.removeAttribute("loginStaff");
	return "login";
    }
    
    //添加员工
    @RequestMapping("insert")
    public String insert(CrmStaff staff){
	//给staff 设置UUID
	staff.setStaffid(MyStringUtils.getUUID());
	staffService.insert(staff);
	
	//重定向回查询页面
	return "redirect:/staff/list.do";
    }
    
    //编辑员工
    @RequestMapping("editStaff")
    public String editStaff(String staffId,Model model){
	//根据id查询I
	CrmStaff staff = staffService.findById(staffId);
	//存入到model 然后传到jsp页面
	model.addAttribute("staff", staff);
	return "/staff/editStaff";
    }
    
    //更新员工
    @RequestMapping("update")
    public String update(CrmStaff staff){
	staffService.update(staff);
	
	return "redirect:/staff/list.do";
    }

    
    
    
}
