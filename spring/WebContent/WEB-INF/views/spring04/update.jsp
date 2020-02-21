<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updatePro.do" method="post">
		<input type="hidden" name="id" value="${dto.id }" />
		id : ${dto.id } <br/>
		pw : <input type="password" name="pw" /> <br/>
		age : <input type="text" name="age" /> <br/> 
		<input type="submit" value="수정" /> <br/> 
	</form>
</body>
</html>