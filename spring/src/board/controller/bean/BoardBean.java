package board.controller.bean;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import board.model.dao.BoardDAOImpl;
import board.model.vo.BoardVO;

@Controller
@RequestMapping("/board/")
public class BoardBean {
	
	@Autowired
	private BoardDAOImpl boardDAO = null;
	
	@RequestMapping("list.do")
	public String list(String pageNum, Model model) throws Exception {
		
		//Controller -> XxxService(inter) -> (XxxxServiceImpl -> XxxDAO ->) XxxDAOImpl -> SQL -> DB
		
		if(pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1)*pageSize + 1;
		int endRow = currentPage*pageSize;
		int count = 0;
		int number = 0;
		
		List articleList = null;
		count = boardDAO.getArticleCount();
		if(count > 0) {
			articleList = boardDAO.getArticles(startRow, endRow);
		}else {
			articleList = Collections.EMPTY_LIST; //null 대신처리. 에러메세지가 다름
		}
		number = count - (currentPage - 1) * pageSize;
		
		model.addAttribute("currentPage", new Integer(currentPage));
											//자바가 권장하는 스타일
 		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("count", count);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("articleList", articleList);
		model.addAttribute("number", number);
		
		return "board/list";
	}
	
	@RequestMapping("writeForm.do")
	public String writeForm(BoardVO vo, Model model) {
		
//		int num = 0, ref = 0, re_step = 0, re_level = 0;
//		
//		if(req.getParameter("num") != null) num = Integer.parseInt(req.getParameter("num")); 
//		if(req.getParameter("ref") != null) ref = Integer.parseInt(req.getParameter("ref")); 
//		if(req.getParameter("re_step") != null) re_step = Integer.parseInt(req.getParameter("re_step")); 
//		if(req.getParameter("re_level") != null) re_level = Integer.parseInt(req.getParameter("re_level")); 
//		
//		model.addAttribute("num", num);
//		model.addAttribute("ref", ref);
//		model.addAttribute("re_step", re_step);
//		model.addAttribute("re_level", re_level);
		
		model.addAttribute("vo", vo);
		
		return "board/writeForm";
	}
	@RequestMapping("writePro.do")
	public void writePro(BoardVO vo, HttpServletResponse res) throws Exception {
		
		BoardVO newVO = boardDAO.insertArticle(vo);
		int num = boardDAO.getArticleNum(newVO);
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('글이 작성되었습니다.');");
		out.println("window.location.href='/spring/board/content.do?num="+num+"';");
		out.println("</script>");
		
	}
	
	@RequestMapping("content.do")
	public String getArticle(int num, String pageNum, Model model) throws Exception {
		
		if(pageNum == null) {
			pageNum = "1";
		}
		BoardVO vo = null;
		if(num != 0) {
			vo = boardDAO.getArticle(num);
		}
		model.addAttribute("vo", vo);
		model.addAttribute("pageNum", pageNum);
		
		return "board/content";
	}
	
	@RequestMapping("modify.do")
	public String modifyArticle(String num, String pageNum, String id, Model model, HttpSession se) throws Exception {

		if(se.getAttribute("memId") != null && se.getAttribute("memId").equals(id)) {
			if(pageNum == null) {
				pageNum = "1";
			}
			BoardVO vo = null;
			if(num != null) {
				vo = boardDAO.getArticleForUpdate(Integer.parseInt(num));
			}
			
			model.addAttribute("vo",vo);
			model.addAttribute("pageNum",pageNum);
		}
		
		return "board/modify";
	}
	
	@RequestMapping("modifyPro.do")
	public void modifyPro(BoardVO vo, String pageNum, HttpServletResponse res) throws Exception {
		
		if(pageNum == null) {
			pageNum = "1";
		}	
		
		int check = boardDAO.updateArticle(vo);	
		
		res.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = res.getWriter();
		
		if(check == 0) {
			out.println("<script>");
			out.println("alert('수정을 실패하였습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
		}else if(check == 1) {
			out.println("<script>");
			out.println("alert('수정이 완료되었습니다.');");
			out.println("window.location.href='/spring/board/content.do?num="+vo.getNum()+"&pageNum="+pageNum+"';");
			out.println("</script>");
		}
		
	}
	
	@RequestMapping("delete.do")
	public void deleteArticle(String num,String id, HttpServletResponse res, HttpSession se) throws Exception{
		int check = 0;
		res.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = res.getWriter();

		if(se.getAttribute("memId") != null && se.getAttribute("memId").equals(id)) {
			if(num != null) check = boardDAO.deleteArticle(Integer.parseInt(num));
			
			if(check == 0) {
				out.println("<script>");
				out.println("alert('삭제를 실패하였습니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
			}else if(check == 1) {
				out.println("<script>");
				out.println("alert('삭제가 완료되었습니다.');");
				out.println("window.location.href='/spring/board/list.do';");
				out.println("</script>");
			}
		}else {
			out.println("<script>");
			out.println("alert('접근오류');");
			out.println("window.location.href='/spring/member/main.do';");
			out.println("</script>");
		}
		
	} 
	
}
