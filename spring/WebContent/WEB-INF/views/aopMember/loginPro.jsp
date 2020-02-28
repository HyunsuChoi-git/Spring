<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/spring/resources/style.css" rel="stylesheet" type="text/css" >
</head>

<c:if test="${check == 1}" >
	<c:redirect url="/aopMember/main.do"/>
</c:if>
<c:if test="${check != 1}" >
	<script>
		alert("아이디 또는 비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
		history.go(-1);
	</script>
</c:if>

<body>

</body>
</html>