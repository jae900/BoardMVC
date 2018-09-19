<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a{	
		text-align:center;
		padding:10px;
		display:block;
		text-decoration:none;
		color:white;
		border-bottom: 1px solid white;
	}
	.nav{
   		 position: relative;
   		 display: inline-block;
   		 cursor: pointer;
	}
	.dropdown-content{
		display:none;
		position: absolute;
		width:130px;
	}
	.board{
		display:flex;
		align-items:center;
		justify-content:center;
		font-size:20px;
		height:50px;
		width:130px;
	}
	.nav:hover .board{
		background-color:#2E2E2E;
		border-bottom:1px white solid;
	}
	.nav:hover .dropdown-content{
		display:block;
		background-color:gray;
	}
	
</style>
</head>
<body>
	<div class="nav">
		<div class="board">게시판</div>
		<div class="dropdown-content">
			<a href="boardList.bo?btype=1">공지</a> 
			<a href="boardList.bo?btype=2">자유</a> 
			<a href="boardList.bo?btype=3">유우머</a>
		</div>		
	</div>
	<div class="nav">
		<div class="board">빈칸</div>
		<div class="dropdown-content">
			<a href="">1</a> 
			<a href="">2</a> 
			<a href="">3</a>
		</div>		
	</div>
	<div class="nav">
		<div class="board">빈칸</div>
		<div class="dropdown-content">
			<a href="">1</a> 
			<a href="">2</a> 
			<a href="">3</a>
		</div>		
	</div>

</body>
</html>