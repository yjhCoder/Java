package org.yjh.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.yjh.staff.domain.CrmStaff;

public class LoginHandlerIntercepter implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
	    throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
	    throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
	
	String requestURL = request.getRequestURI();
	if(requestURL.indexOf("login")<=0){
	    //不在登录页面
	    HttpSession session = request.getSession();
	    CrmStaff staff = (CrmStaff) session.getAttribute("loginStaff");
	    if (staff!=null) {
		//在session中  所以放行
		return true;
	    }else {
		//session中没有 staff  将友好提示存入
		request.setAttribute("error", "请重新登录");
		request.getRequestDispatcher("index.jsp").forward(request, arg1);
		return false;
	    }
	}
	//在登录界面 --放行
	return true;
    }

}
