package org.yjh.staff.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.yjh.staff.domain.CrmStaff;

public class CrmStaffMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
	// 读取配置文件
	// 全局配置文件路径
	String resource = "config/beans.xml";
//	InputStream inputStream = Resources.getResourceAsStream(resource);

	ApplicationContext context = new FileSystemXmlApplicationContext(resource);
	
	// 创建SqlSessionFactory
//	sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
    }

    @Test
    public void testLogin() {
	// 创建UserMapper对象
	SqlSession sqlSession = sqlSessionFactory.openSession();
	CrmStaffMapper mapper = sqlSession.getMapper(CrmStaffMapper.class);
	
	Map<String,String> staffMap = new HashMap<String,String>();
	staffMap.put("loginName", "jack");
	staffMap.put("password", "1234");
	
	CrmStaff staff = mapper.login(staffMap);
	System.out.println(staff.toString());
	// 由mybatis通过sqlsession来创建
	
	sqlSession.close();

    }

}
