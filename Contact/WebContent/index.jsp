<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>welcome to jxnu...</h1>
<h1>jxnu</h1>
<%
	int abc;
	abc =100;  
%>
<%=abc %>
<a href='<%=response.encodeURL("DownloadServlet")%>' >加勒比海盗</a>
</body>
</html>