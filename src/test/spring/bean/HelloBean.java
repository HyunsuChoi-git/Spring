package test.spring.bean;

import org.springframework.web.bind.annotation.RequestMapping;

public class HelloBean {
	
	@RequestMapping("hello.do")
	public String hello() {
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}

}
