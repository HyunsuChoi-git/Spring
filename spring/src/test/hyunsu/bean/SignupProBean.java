package test.hyunsu.bean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import test.hyunsu.model.MemberDAO;
import test.hyunsu.model.MemberDTO;

@Controller
public class SignupProBean {
	
	@RequestMapping("signupPro.ss")
	public String signup(@ModelAttribute("a") MemberDTO dto) {

		ApplicationContext context=new ClassPathXmlApplicationContext("test/hyunsu/bean/zz.xml");
		
		String sql = "insert into member values(?,?,?,?,?,?)";
		List list=new ArrayList();
		list.add(dto);
		MemberDAO dao=MemberDAO.getInstance();
		int result = dao.executeUpdate(sql, list);
		
		return "/WEB-INF/views/hyunsu/signupPro.jsp";
	}
}
