<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#viewcontent{
		height:700px;
	}
</style>
</head>
<body>
	<div id="viewcontent">
		<br>
		#${param.no }<br>
		등록시간: ${vo.getRegDate()}<br><br><br> 제목:
		${vo.getTitle()}<br>
		<br> 내용:
		${vo.getContent()}<br>
		<br>
		<br>
		<form>
			<input type="button" onclick="window.location.href='boardReg.bo?btype=${param.btype}&pg=${param.pg }&no=${param.no}'" value="수정">
			<input type="button" onclick="window.location.href='boardDel.bo?btype=${param.btype}&pg=${param.pg }&no=${param.no}'" value="삭제">
			<input type="button" onclick="history.back()"	value="목록으로">
		</form>
		<br>
	</div>
</body>
</html>