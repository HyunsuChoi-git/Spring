package test.spring.bean;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import test.spring.model.TestDTO;
import test.spring.model.TvDTO;

@Controller
public class Hellobean2{
	
	//의존성 자동 주입
	@Autowired
	private Date day = null;
	
	@Autowired
	private TestDTO dto = null;

	@Autowired
	private TestDTO dto2 = null;
	
	@RequestMapping("hello2.do")
	public String hello() {
		
		//dto.setId("hello");
		//dto.setPw("hahaha");
		
		System.out.println("===dto===");
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		System.out.println(dto.getReg());
		
		System.out.println("===dto2===");
		System.out.println(dto2.getId());
		System.out.println(dto2.getPw());
		System.out.println(dto2.getReg());
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}
	
	
	
	
	@RequestMapping("signup")
	public String signup() {
		return "/WEB-INF/views/spring02/signup.jsp";
	}
	//모델이 있으면 view에 데이터 전달가능
	//단 requestmapping이 설정된 메서드만 사용가능
	@RequestMapping("pro")
	public String pro(TestDTO dto,Model model) {
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		model.addAttribute("id", dto.getId());
		
		return "/WEB-INF/views/spring02/pro.jsp";
	}
	
//	@RequestMapping("pro")
//	public ModelAndView pro(TestDTO dto) {
//		
//		//객체생성
//		ModelAndView mv = new ModelAndView();
//		//데이터 저장
//		mv.addObject("id", dto.getId());
//		mv.addObject("pw", dto.getPw());
//		//뷰 경로 저장
//		mv.setViewName("/WEB-INF/views/spring02/pro.jsp");
//		return mv;
//	}
	
	
	
	@RequestMapping("hello3.do")
	public String hello3(@RequestParam("test") String tost){ 
		
		System.out.println(tost);
		
	    return "/WEB-INF/views/spring01/hello.jsp";
	}
	
	
	//일반메소드에 @ModelAttribute 어노테이션 추가
//	@ModelAttribute
//	public void getTv(String col, Model model) {
//		System.out.println("getTv 호출");
//		
//		TvDTO tv = new TvDTO();
//		tv.setPower(true);
//		tv.setCh(10);
//		tv.setCol(col);
//		
//		model.addAttribute("tv", tv);
//	}
	
	//맵핑 메소드
	
	@RequestMapping("hello4.do")
	public String hello4() {
		
		System.out.println("hello4 맵핑 메소드 호출!");
		
		return "/WEB-INF/views/spring02/helloTv.jsp";
	}
	
	//매개변수에 @ModelAttribute 지정
	@RequestMapping("form2.do")
	public String sendMsg() {
		
		return "/WEB-INF/views/spring02/signup.jsp";
	}
	@RequestMapping("pro2.do")
	public String viewMsg(@ModelAttribute("dto") TestDTO dto) {
		//매개변수 TestDTO dto 라고 지정하면 set 메소드로 자동 바인딩 됨.
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		return "/WEB-INF/views/spring02/pro.jsp";
	}	
	
	
	
	
}
