<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">   
function checkform(){
	var ret =true;
	 uname = $("#uname").val();
	 if(uname.length<8){
		 alert("用户必须大于等于8位");
		 ret = false;
	 }
	 pwd = $("#upwd").val();
	return ret;
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action='register'   method="post">
	user:<input name="username" id="uname"  value='${cookie["usname"].value}' type="text"/><br/>
	passwrod:<input id="upwd" name="password" value="${cookie.pwd.value}" type="password"/> <br/>
	passwrod again:<input name="password2" value="${cookie.pwd.value}" type="password"/> <br/> 
	<input type="submit" onclick="return checkform();"/>
</form>
</body>
</html>