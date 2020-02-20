package test.spring.bean;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloBean3 {
	
	@RequestMapping("pikachu.do")
	public String pika(String name, Model model) {
		System.out.println(name);
		model.addAttribute("name", name);
		
		return "spring03/pikachu";
	}
	
	@RequestMapping("download.do")
	public ModelAndView down() {
		// 개발자가 원하는 것을 사용자가 다운받을 수 있게 파일 연결 시켜주기
		File f = new File("D:\\save\\5555.jpg");
		
		ModelAndView mv = new ModelAndView("fileDown", "downloadFile", f);
					// FileDown : DownloadView 의 Bean객체 id
		         	// ModelAndView가 받는 매개변수 View view 는 페이지이동이 아닌 
		 			// DownloadView.java를 실행하겠다라는 의미의 연결.
		
					// downloadFile  :  DownloadView.java 에서 필요한 정보를 뺄 때 쓰는 매개변수.
		return mv;
	}
}
