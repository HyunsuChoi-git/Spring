<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/spring/resources/style.css" rel="stylesheet" type="text/css">
	<script>
		// 유효성 검사
		function check(){
			var inputs = document.inputForm;

			if(!inputs.pwCh.value){
				alert("비밀번호 확인란을 입력하세요.");
				return false;
			}
			if(inputs.pw.value != inputs.pwCh.value){
				alert("비밀번호를 동일하게 입력하세요");
				return false;
			}
		}

	</script>
</head>
<c:if test="${sessionScope.memId == null}">
	<c:redirect url="/member/main.do" />
</c:if>

<c:if test="${sessionScope.memId != null}">
<body>
	<br />
	<h1 align="center">회원정보 수정</h1>
	<form action="/spring/member/modifyPro.do" method="post" name="inputForm" >
		<input type="hidden" name="id" value="${vo.id }" />
		<table>
			<tr>
				<td>아이디 * </td>
				<td>${vo.id }</td>
			</tr>
			<tr>
				<td>비밀번호 * </td>
				<td><input type="password" name="pw" value="${vo.pw }"/></td>
			</tr>
			<tr>
				<td>비밀번호 확인 * </td>
				<td><input type="password" name="pwCh" /></td>
			</tr>
			<tr>
				<td>이름 * </td>
				<td><input type="ptext" name="name" value="${vo.name }"/></td>
			</tr>
			<tr>
				<td>나이 </td>
				<td><input type="text" name="age" value="${vo.age }"/></td>
			</tr>
			<tr>
				<td>Email </td>
				<td><input type="text" name="email" value="${vo.email }"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정" />
					<input type="reset" value="재입력" /> 
					<input type="button" value="취소" onclick="window.location.href='/spring/member/main.do'" /> 
				</td>
			</tr>
		</table>
	</form>
</body>
</c:if>
</html>