package test.hyunsu.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignupFormBean {
	
	@RequestMapping("signup.ss")
	public String signup() {
		return "/WEB-INF/views/hyunsu/signupForm.jsp";
	}
	
}
