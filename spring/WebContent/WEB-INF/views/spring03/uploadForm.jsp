<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="uploadPro.do" method="post" enctype="multipart/form-data">
		writer : <input type="text" name="writer" /><br/>
		file : <input type="file" name="img" /> <br/>
			   <input type="submit" value="전송" />	
	</form>

</body>
</html>