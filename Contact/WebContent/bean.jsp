<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
<jsp:useBean id="book1" scope="session" class="cn.edu.jxnu.Book"></jsp:useBean>
 
<jsp:setProperty  name="book1" property="*" />
<jsp:getProperty name="book1" property="price"/>
<jsp:getProperty name="book1" property="title"/>
<jsp:getProperty name="book1" property="pulisher"/>
<jsp:getProperty name="book1" property="author"/>
</body>
</html>