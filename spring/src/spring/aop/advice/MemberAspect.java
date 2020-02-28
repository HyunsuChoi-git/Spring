package spring.aop.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
public class MemberAspect {
	
	// advice method의 ()안에는 pointcut 어노테이션이 적용된 메소드명 또는 pointcut 표현식이 바로 올 수 있다.
	@Around("execution(* test*(..))")
	 public Object around(ProceedingJoinPoint j) throws Throwable{
		System.out.println("araoud");
		
//		//로그인 체크
//		//ProceedingJoinPoint 를 이용하여 HttpServletRequest 꺼내기
//		//타켓메소드의 매개변수에도 HttpServletRequest request가 존재해야한다.
//		//리턴타입이 동일해야한다. 현재 타겟메소드의 리턴타입 : String,  
//		Object [] obj = j.getArgs(); // 타켓 메소드로 넘어가는 매개변수를 꺼내줌.
//		for(Object o : obj) {
//			if(o instanceof HttpServletRequest) {
//				HttpServletRequest request = (HttpServletRequest) o;
//				HttpSession session = request.getSession();
//				String memId = (String)session.getAttribute("memId");
//				if(memId == null) {
//					//로그아웃상태
//					System.out.println("비로그인");
//					return "aopMember/loginForm";
//					//리턴형태 : 타겟메소드(핵심메소드)와 동일하게 처리.
//				}
//			}
//		}
		
		
		//로그인체크 : MVC에서 HttpServletRequest꺼내기
		ServletRequestAttributes sa = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sa.getRequest();
		HttpSession session = request.getSession();
		if(session.getAttribute("memId") == null) {
			System.out.println("로그인하세요!!");
			return "aopMember/modify";
		}
		
		return "j.proceed()";
	}
	
	
	
	
	/*
	 * //pointcut & advice method 지정하기
	 * 
	 * @Pointcut("execution(* test*(..))") private void testPC() { //해줄 것은 따로 없음 }
	 * 
	 * @Around("testPC()") //어떤 Pointcut이 걸렸을 때 실행해야할 것, 메소드 이름을 지정해주면 된다. public
	 * Object around(ProceedingJoinPoint j) throws Throwable{ //리턴 타입 Object, 리턴은
	 * j.proceed(), 첫번째 매개변수는 ProceedingJoinPoint 타입의 변수
	 * System.out.println("around aop!!"); //----before---- return j.proceed(); }
	 */
}
