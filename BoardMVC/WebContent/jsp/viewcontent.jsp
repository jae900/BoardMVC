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
		min-height:700px;
	}
	.title{
		font-size:22px;
		font-weight:bold;
	}
	.regtime{
		font-size:15px;
	}
	textarea{
		width: 400px;
		height:60px;
	}
	#regDate{
		font-size:13px;
	}
	#commentReg{
		font-size:13px;
		padding-bottom:5px;
	}
</style>
</head>
<body>
	<div id="viewcontent">
		<br>
		#${param.no }번 글<br><br>
		<div class="title">${vo.getTitle()}</div>
		<div class="regtime">${vo.getRegDate()}</div><hr><br>
		<pre>${vo.getContent()}</pre><br>
		<br>
		<br>
		<form>
			<input type="button" onclick="window.location.href='boardReg.bo?btype=${param.btype}&pg=${param.pg }&no=${param.no}'" value="수정">
			<input type="button" onclick="window.location.href='boardDel.bo?btype=${param.btype}&pg=${param.pg }&no=${param.no}'" value="삭제">
			<input type="button" onclick="history.back()"	value="목록으로">
		</form>
		<br><hr><br>
		<u>${commentCnt} comments</u><br><br>
			
			<c:forEach items = "${cdata}" var = "c">
				<table>
					<tr>
						<td id="regDate">${c.getCregdate()} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href=>삭제</a></td>					
					</tr>
					<tr>
						<td id="title">${c.getT_comment()}</td>
					</tr>
				</table>
				<br>
			</c:forEach>
			<br><br>
		<div id="commentReg">댓글등록</div>
		<form action="commentReg.bo?btype=${param.btype}&pg=${param.pg}&no=${param.no}" method="post">
			<textarea name="t_comment"></textarea>
			<input type="submit" value="등록">
		</form>
	</div>
	<br>
	<br>
	
</body>
</html>