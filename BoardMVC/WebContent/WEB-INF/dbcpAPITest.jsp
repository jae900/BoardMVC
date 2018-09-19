<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<% Connection conn = null;
try {
	 Context init = new InitialContext();
	 DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	 conn = ds.getConnection();
	 out.println("되냐");
} catch (Exception e) {
	 out.println("응 안됨");
	 e.printStackTrace();
}



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>