package org.yjh.coursetype.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yjh.coursetype.domain.CrmCourseType;
import org.yjh.coursetype.service.CourseTypeService;

@Controller
@RequestMapping("/courseType")
public class CourseTypeController {

    @Resource
    private CourseTypeService courseTypeService;
    
    @RequestMapping("list")
    public String findAll(Model model){
	List<CrmCourseType> list = courseTypeService.findAll();
	model.addAttribute("list", list);
	return "/coursetype/listCourse";
    }
    
}
