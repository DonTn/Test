<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function loadXMLDoc() {
 		$("#myDiv").load("check.jsp");
	}
</script>
</head>
<body>

	<h2>AJAX</h2>
	<button type="button" onclick="loadXMLDoc()">请求数据</button>
	<div id="myDiv"></div>

</body>
</html>