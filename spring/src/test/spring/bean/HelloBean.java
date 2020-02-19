package test.spring.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test/")
public class HelloBean {
	
	@RequestMapping("hello.do")
	public String hello() {
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}

}
