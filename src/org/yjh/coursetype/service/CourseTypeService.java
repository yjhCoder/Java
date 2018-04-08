package org.yjh.coursetype.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.yjh.coursetype.dao.CrmCourseTypeMapper;
import org.yjh.coursetype.domain.CrmCourseType;

@Service
public class CourseTypeService {
    
    @Resource
    private CrmCourseTypeMapper mapper;

    public List<CrmCourseType> findAll() {

	return mapper.selectByExample(null);
    }

    
    
}
