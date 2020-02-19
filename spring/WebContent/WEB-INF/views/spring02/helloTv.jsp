<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- Bean클래스(HelloBean2)에서 view로 전달되는 커맨드객체(Model 계층에 삽입되는 객체)를 출력
		ModelAttribute 어노테이션에 별칭을 지정하지 않으면, 전달하는 객체의 클래스 타입의 앞글자를 소문자로 바꿔서 속성명으로 전달되므로
		TvDTO => tvDTO 라는 이름으로 객체에 접근이 가능하다
	 --%>

	<h2>hello tv</h2>
	<h2> ${tv.power}</h2>
	<h2> ${tv.ch}</h2>
	<h2> ${tv.col}</h2>
</body>
</html>