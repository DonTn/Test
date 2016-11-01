 <%@page import="java.util.*,cn.edu.jxnu.Book" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
<form action='checkuser'   method="post">
	user:<input name="username"  value='${cookie["usname"].value}' type="text"/><br/>
	password:<input name="password" value="${cookie.pwd.value}" type="password"/> <br/>
	<select name="lt">
		<option value="0">不保存</option>
		<option value="7">一周</option>
		<option value="30">一月</option>
	</select>
	<input type="submit"/>
</form>
<a href="register.jsp" >注册</a>
 
</body>
</html>