<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,cn.edu.jxnu.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
.mask {
	position: absolute;
	top: 0px;
	filter: alpha(opacity = 60);
	background-color: #777;
	z-index: 1002;
	left: 0px;
	opacity: 0.5;
	-moz-opacity: 0.5;
}

.model {
	position: absolute;
	z-index: 1003;
	width: 320px;
	height: 320px;
	background-color: #ddd;
	display: none;
}

#header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
}

#nav {
	line-height: 30px;
	background-color: #eeeeee;
	height: 600px;
	width: 100px;
	float: left;
	padding: 5px;
}

#content {
	width: 350px;
	float: left;
	padding: 10px;
}

#footer {
	background-color: black;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">   
 
//兼容火狐、IE8
function showMask(){
	$("#mask").css("height",$(document).height());
	$("#mask").css("width",$(document).width());
	$("#mask").show();
}
//让指定的DIV始终显示在屏幕正中间
function letDivCenter(divName){ 
	var top = ($(window).height() - $(divName).height())/2; 
	var left = ($(window).width() - $(divName).width())/2; 
	var scrollTop = $(document).scrollTop(); 
	var scrollLeft = $(document).scrollLeft(); 
	$(divName).css( { position : 'absolute', 'top' : top + scrollTop, left : left + scrollLeft } ).show();
}
function showAll(divName){
	showMask();
	letDivCenter(divName);
} 

	$(document).ready(function (){ 
		
		$("#deleteButton").click(function(){
			var chk_value =[];
			$('input[type="checkbox"]:checked').each(function(){ 
				chk_value.push($(this).val());				
			}); 
			alert(chk_value.length==0 ?'你还没有选择任何内容！':chk_value); 
			$.get("delete",{'id[]':chk_value},function(){
				alert("返回200状态");
				$('input[type="checkbox"]:checked').each(function(){
					$(this).parent().parent().remove(); 
				});
			}); 
		});
		$("#content").load("ListContactServlet");
	 	$("#addform").hide();
	 	$("#addButton").click(function(){
 			 $("#addform").toggle();
 			$("#name")[0].value ="";
 			$("#phone")[0].value = "";
 			$("#addr")[0].value = "";
 			$("#email")[0].value = "";
 			$("#c_id")[0].value="";
 			 return false;
 		 });
	 	});
		function update(id,ln){
			showAll('#model'); 		 
			$("#name")[0].value = $("#contact_list tr").eq(ln).children().eq(0).text();
			$("#phone")[0].value = $("#contact_list tr").eq(ln).children().eq(1).text();
			$("#addr")[0].value = $("#contact_list tr").eq(ln).children().eq(2).text();
			$("#email")[0].value = $("#contact_list tr").eq(ln).children().eq(3).text();
			$("#c_id")[0].value=id;
		}
		function commit(){  
			$("#mask").hide();
			$("#model").hide();
			 
			if($("#c_id")[0].value)
			{  
				$("#content").load("UpdateContactServlet",{
				    name:$("#name")[0].value,
				    phone:$("#phone")[0].value,
				    addr:$("#addr")[0].value,
				    email:$("#email")[0].value ,
				    id:$("#c_id")[0].value
				  }); 
				return false;
			} else{
				return true;
			}			
		}
</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div id="header">
		<h1>联系人</h1>
	</div>

	<div id="nav">
		<div id="mask" class="mask"></div>
	  <input type="button" onclick = "showAll('#model')" value="添加" id="addButton" /> 
	  <input type="button" 	value="删除" id="deleteButton" />
	</div>

	<div id="content">
	
	</div>
	<div id="model" class="model">
	<form action="AddContactServlet"  method="post" enctype="multipart/form-data">
	<input name="id" id="c_id" type="hidden" />
	<table width="200" border="1" align="center">
	  	<tr>
	    <td nowrap="nowrap">姓名：</td>
	    <td> <input	id="name" name="name" type="text" /> </td>
	  </tr>
	   <tr>
	    <td nowrap="nowrap">电话：</td>
	    <td> <input	id="phone" name="phone" type="text" /></td>
	  </tr>
	   <tr>
	    <td nowrap="nowrap">联系地址：</td>
	    <td> <input id="addr" name="addr" type="text" /> </td>
	  </tr>
	   <tr>
	    <td nowrap="nowrap">邮件地址：</td>
	    <td><input id="email" name="email" type="text" /></td>
	  </tr> 
	   <tr>
	    <td nowrap="nowrap">上传头像：</td>
	    <td><input name="head_img" type="file" /></td>
	  </tr>
	   <tr>
	   	
	     <td colspan="2" align="center" nowrap="nowrap"><input name="submit" type="submit" id="add" onclick="return commit();"value="确定" />       <input id="reset" value="重置" type="reset" /> </td>
	  </tr>
  
	</table>
	</form>
	</div>
	<div id="footer">Copyright ? www.jxnu.edu.cn</div>

</body>
</html>