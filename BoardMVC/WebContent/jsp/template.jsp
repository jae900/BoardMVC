<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		box-sizing:border-box;
	}
	html, body{
		margin:0;
		padding:0;
	}
	body{
		display:flex;
		flex-direction:column;
		justify-content:center;
		align-items:center;
	}
	.login{
		color:white;
		background-color:darkgray;
		width:100%;		
	}	
	.logintop, .join{
		float:right;
		padding-right:30px;
	}
	.head{
		text-decoration:none;
		background-color:#F897CB;
		width:100%;
		flex:0 0 150px;
		display:flex;
		justify-content:center;
		align-items:center;
	}
	
	.navi{
		color:white;
		background-color:#767272;
		width:100%;
		flex:0 0;
	}
	.con{
		background-color:#F897CB;
		width:100%;
		display:flex;
		flex-direction:column;
		align-items:center;
	}
	.foot{
		width:100%;
		background-color:black;
		color:white;
		height:80px
	}
</style>
</head>
<body>
	<div class="login"><jsp:include page="login.jsp"></jsp:include></div>
	<div class="head"><jsp:include page="header.jsp"></jsp:include></div>
	<div class="navi"><jsp:include page="nav.jsp"></jsp:include></div>
	<div class="con"><jsp:include page="${page}.jsp"></jsp:include></div>
	<div class="foot"><jsp:include page="footer.jsp"></jsp:include></div>
</body>
</html>