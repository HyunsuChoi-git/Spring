package test.hyunsu.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignupProBean {
	
	@RequestMapping("signupPro.ss")
	public String signup() {
		
		
		
		
		
		return "/WEB-INF/views/hyunsu/signupPro.jsp";
	}
}
