<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function before(){
		
		if(${pg} >1){
			location.href='boardList.bo?btype='+${param.btype}+'&pg='+${pg-1};
		}
	}
	
	function next(){
		
		if(${pg}<${pagenum}){
			location.href='boardList.bo?btype='+${param.btype}+'&pg='+${pg+1};
		}
	}
</script>
<style>
	table, tr, th, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
	
	body, html {
		width: 100%;
	}
	
	
	#boardlist{
		display: flex;
		flex-direction: column;
		align-items:center;
		height:700px;
	}
	th{
		background-color:#F591DC;
	}
	td{
		background-color:#F6D3F3;
		height:30px;
	}
	#no {
		text-align: center;
	}
	
	#title{
		width:500px;
	}
		
	table a {
		color: black;
		text-decoration: none;
	}
	
	#pn {
		display: flex;
		justify-content:center;
	}
	
	#pn a{
		color : black;
		text-decoration: none;
		font-weight:bold;
	}
	
	#buttn{
		width:60px;
	}
	input{
		margin-right:10px;
		margin-left:10px;
	}
	
</style>
</head>
<body>
	<div id="boardlist">
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
					<td id="title"><a
						href="boardDetail.bo?btype=${param.btype}&pg=${pg }&no=${i.getNo()}">${i.getTitle()}</a></td>
					<td>${i.getRegDate()}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div id="pn">
			<input type="button" value="처음으로" onclick="location.href='boardList.bo?btype=${param.btype}&pg=1'">
			<input type="button" value="이전" onclick="before()">
			<c:forEach var="n" begin="1" end="${pagenum}">
				&nbsp;&nbsp;<a href="boardList.bo?btype=${param.btype}&pg=${n}">${n}</a>&nbsp;&nbsp;
			</c:forEach>
			<input type="button" value="다음" onclick="next()">
			<input type="button" value="끝으로" onclick="location.href='boardList.bo?btype=${param.btype}&pg=${pagenum}'">
		</div>
		<br>
	
		<input type="button" value="글쓰기" id="buttn"
			onclick="location.href='boardReg.bo?btype=${param.btype}&no=0'">
		<br>
	</div>
</body>
</html>