package org.yjh.department.controller;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yjh.department.domain.CrmDepartment;
import org.yjh.department.service.DepartementService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartementService departmentService;

    //返回json数据格式
    @RequestMapping("findById")
    public @ResponseBody CrmDepartment findById(CrmDepartment department){
	String depId = department.getDepid();
	return  departmentService.findById(depId);
    }
    
    //查找部门
    @RequestMapping("list")
    public String list(Model model){
	List<CrmDepartment> list =  departmentService.findAll();
	model.addAttribute("list", list);
	return "/department/listDepartment";
    }
    
    //查找数据库 进入编辑页面
    @RequestMapping("edit")
    public String edit(String depid,Model model){
	CrmDepartment department =  departmentService.findById(depid);
	model.addAttribute("deparment", department);
	return "/department/addOrEditDepartment";
    }
    
    //保存修改部门
    @RequestMapping("save")
    public String save(CrmDepartment department){
	departmentService.save(department);
	return "redirect:/department/list.do";
    }
    
}
