<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%//将信息放到不同的范围中
    pageContext.setAttribute("name","test");
    request.setAttribute("req","Request");
    session.setAttribute("sess","Session");
    session.setAttribute("app", "session's value");
    application.setAttribute("app","application");
    %>
    <% out.print("ssss");%>
 
    
    
    <%//从不同的范畴中取出属性注意最后一个
    out.print(pageContext.getAttribute("name")+"<br/>");
    out.print(request.getAttribute("req")+"<br/>");
    out.print(pageContext.getAttribute("req",PageContext.REQUEST_SCOPE)+"<br/>");
    out.print(pageContext.getAttribute("sess",PageContext.SESSION_SCOPE)+"<br/>");
    out.print(pageContext.getAttribute("app",PageContext.APPLICATION_SCOPE)+"<br/>");
    out.print(pageContext.findAttribute("app")+"<br/>");
    %>

</body>
</html>