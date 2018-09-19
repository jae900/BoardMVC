<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	html{
		box-sizing: border-box;
	}
	body, html {
		width: 100%;
	}
	
	body {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	
	form {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	
	.buutonlist {
		display:flex;
	}
	textarea{
		display:flex;
		align-items:flex-start;
		width: 550px;
		height:400px;
	}
	input {
		width: 550px;
	}
	.button{
		width:50px;
	}
</style>
</head>

<body>
	<h1>글쓰기</h1>
	<form action="boardReg.bo?btype=${param.btype}" method="post">
		<div>제목<br><input type="text" name="title"></div><br>
		<div class="content">내용<textarea name="content"></textarea></div><br>
		<div class="buttonlist">
			<input type="submit" value="확인" class="button">
			<input type="reset"	value="취소" class="button">
			<input type="hidden" name="flag" value="1">
			<input type="hidden" name="no" value="0">
		</div>
	</form>
</body>
</html>