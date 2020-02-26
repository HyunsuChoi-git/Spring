package member.controller.bean;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import member.model.dao.MemberDAO;
import member.model.vo.MemberVO;

@Controller
@RequestMapping("/member/")
public class MemberBean {
	//dao 불러다 해당 메서드 호출 
	
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping("main.do")
	public String main() {
		return "member/main";
	}
	
	@RequestMapping("signupForm.do")
	public String signupForm() {
		return "member/signupForm";
	}
	@RequestMapping("signupPro.do")
	public String signupPro(MemberVO vo) throws Exception{
		//회원가입 처리 후 메인으로 이동 (pro 페이지 필요X)
 		memberDAO.insertMember(vo);
 		
		return "member/main";
	}
	
	
	
	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "member/loginForm";
	}
	@RequestMapping("loginPro.do")
	public String loginPro(MemberVO vo, String auto, HttpSession session , Model model) throws Exception {
			
		int check = memberDAO.idPwCheck(vo);	
		
		if(check == 1) {
			session.setAttribute("memId", vo.getId());
		}
		model.addAttribute("check", check);

		return "member/loginPro";
	}
	
	
	
	@RequestMapping("modify.do")
	public String modify(Model model, HttpSession session) throws Exception {
		
		String id = (String)session.getAttribute("memId");
		
		if(id != null) {
			MemberVO vo = memberDAO.selectMember(id);
			model.addAttribute("vo", vo);
		}
		
		return "member/modify";
	}
	@RequestMapping("modifyPro.do")
	public void modifyPro(MemberVO vo, HttpServletResponse response) throws Exception {
		
	    response.setContentType("text/html; charset=utf-8");
	    PrintWriter out=response.getWriter();
	    memberDAO.updateMember(vo);
      
        out.println("<script>");
        out.println("alert('수정이 완료되었습니다.');");
        out.println("window.location.href='/spring/member/main.do';");
        out.println("</script>");
		
	}
	
	
	@RequestMapping("logout.do")
	public void logout(HttpSession session, HttpServletResponse res) throws Exception {
		
		String id = (String)session.getAttribute("memId");
		
		if(id != null) {
			session.invalidate();
		}
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('로그아웃 되었습니다.')");
		out.println("window.location.href='/spring/member/main.do'");
		out.println("</script>");
		
	}
	
	
	@RequestMapping("delete.do")
	public String delete() {
		
		return "member/delete";
	}
	@RequestMapping("deleteP.do")
	public void deletePro(String pw, HttpSession se, HttpServletResponse res) throws Exception {
		
		String id = (String)se.getAttribute("memId");
		if(id != null) {
			memberDAO.deleteMember(id);
			se.invalidate();
		}
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('탈퇴가 완료되었습니다.')");
		out.println("window.location.href='/spring/member/main.do'");
		out.println("</script>");
		
	}
	
	
	@RequestMapping("ajaxIdAvail.do")
	@ResponseBody
	//public String ajaxIdAvail(String id) throws Exception { //영어로 리턴할 때는 기본
	public ResponseEntity<String> ajaxIdAvail(String id) throws Exception { //한글을 리턴할 때 리턴타입
		String result = "";
		System.out.println("ajax!!");
		System.out.println("id : " + id);
		
		int check = memberDAO.idAvailCheck(id);
		
		if(check == 1) {
			result = "이미 존재하는 아이디";
		}else if(check == 0){
			result = "사용가능한 아이디";
		}
		System.out.println(check);
		
		HttpHeaders responseHeaders = new HttpHeaders();  //헤더객체를 만들어서 
		responseHeaders.add("Content-Type", "text/html; charset=utf-8"); //헤더정보 추가
		
		
		//return result;
		return new ResponseEntity<String>(result, responseHeaders, HttpStatus.CREATED);
		                                                          //상태정보status : 
		 														// Created(201) - 어떠한 생성작업을 요청받았고, 성공했다.
		                                                        // 혹은 ok(200) - 요청 성공
		
	}
	
	
}
