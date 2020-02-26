<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판</title>
	<link href="/spring/resources/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<br />
	<h1 align="center"> 게시판 </h1>
	<br/>
	<div align="center"><button onclick="window.location.href='/spring/member/main.do'">메인으로</button></div>
	<br/>
	<%-- 게시글 없을때 --%>
	<c:if test="${count == 0}">
	<table>
		<c:if test="${sessionScope.memId != null}">
			<tr>
				<td><button onclick="window.location='/spring/board/writeForm.do'" > 글쓰기 </button></td>
			</tr>
		</c:if>
		<tr>
			<td align="center"> 게시글이 없습니다. </td>
		</tr>
	</table>
	</c:if>
	<%-- 게시글 있을때 --%>
	<c:if test="${count >= 0}">
	<table>
		<c:if test="${sessionScope.memId != null}">
			<tr>
				<td colspan="6" align="right">
					<button onclick="window.location='/spring/board/writeForm.do'" > 글쓰기 </button>
				</td>
			</tr>	
		</c:if>
		<tr>
			<td>No.</td>
			<td>제   목</td>
			<td>작성자</td>
			<td>시   간</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="article" items="${articleList}">
			<tr>
				<td>${number}
					<c:set var="number" value="${number-1}" />
				</td>
				<td align="left">
					<c:set var="wid" value="0" />
					<c:if test="${article.re_level > 0}">
						<img src="/spring/resources/img/tabImg.PNG" width="${wid}" /> <%--배경색으로 들여쓰기 효과 --%>
						<img src="/spring/resources/img/replyImg.png" width="10" />		
					</c:if>
					<a href="/spring/board/content.do?num=${article.num}&pageNum=${currentPage}">${article.subject}</a>
				</td>
				<td>${article.id}</a></td>
				<td>${article.reg}</td>
				<td>${article.readcount}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<br />
	<%-- 목록의 페이지 번호 뷰어 설정 --%>
	<div align="center">
	<c:if test="${count > 0}">
		<fmt:parseNumber var="res" value="${count/pageSize}" integerOnly="true"  />
		<c:set var="pageCount" value="${res + (count % pageSize == 0 ? 0 : 1)}" />
		<c:set var="pageBlock" value="10" />
		<fmt:parseNumber var="result" value="${currentPage/pageBlock}" integerOnly="true" />
		<fmt:parseNumber var="startPage" value="${result * pageBlock +1}" />
		<fmt:parseNumber var="endPage" value="${startPage + pageBlock - 1}" />
		<c:if test="${endPage > pageCount}" >
			<c:set var="endPage" value="${pageCount}" />
		</c:if>
		
		<c:if test="${startPage > pageBlock}">
			<a href="/spring/board/list.peng?pageNum=${startPage-pageBlock}" > &lt; </a>		
		</c:if>
		
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
			<a href="/spring/board/list.peng?pageNum=${i}" class="nums"> &nbsp; ${i} &nbsp; </a>
		</c:forEach>
		
		
		<c:if test="${endPage < pageCount}">
			<a href="/spring/board/list.peng?pageNum=${startPage+pageBlock}" > &gt; </a>		
		</c:if>
	</c:if>
	</div>

</body>
</html>









