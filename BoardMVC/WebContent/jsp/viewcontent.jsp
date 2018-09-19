<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	#${param.no }<br>
	등록시간: ${vo.getRegDate()}<br><br><br> 제목:
	${vo.getTitle()}<br>
	<br> 내용:
	${vo.getContent()}<br>
	<br>
	<br>
	<form>
		<input type="button" onclick="window.location.href='#this'" value="수정">
		<input type="button" onclick="window.location.href='#this'" value="삭제">
		<input type="button" onclick="window.location.href='template.jsp?page=BoardList&btype='"
			value="목록으로">
	</form>
</body>
</html>