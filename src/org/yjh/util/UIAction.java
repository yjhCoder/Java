package org.yjh.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIAction {
    //UIAction 统一登录  供frame 访问jsp
    
    @RequestMapping("uiAction")
    public String uiAction(String uri){
	return uri;
    }
    
    
}
