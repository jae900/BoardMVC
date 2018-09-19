<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table, tr, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

body, html {
	width: 100%;
}

body {
	display: flex;
	flex-direction: column;
}

#no {
	text-align: center;
}

#title {
	width: 75%;
}

a {
	color: black;	
	text-decoration: none;
}
</style>
</head>
<body>
	<h1>${title}</h1>
	<br>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>

		<c:forEach items="${data}" var="i">
			<tr>
				<td id="no">${i.getNo()}</td>
				<td id="title"><a href="boardDetail.bo?btype=${param.btype}&no=${i.getNo()}">${i.getTitle()}</a></td>
				<td>${i.getRegDate()}</td>
			</tr>
		</c:forEach>

	</table>
	<br>

	<input type="button" value="글쓰기"
		onclick="location.href='boardReg.bo?btype=${param.btype}&no=0'">
</body>
</html>