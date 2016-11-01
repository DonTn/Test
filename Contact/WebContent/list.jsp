<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 
 <table id="contact_list" width="200" border="1" align="center">
  <tr>
    <th scope="col">姓名</th>
    <th scope="col">电话</th>
    <th scope="col">地址</th>
    <th scope="col">email</th>
    <th scope="col">头像</th>
    <th scope="col">&nbsp;</th>
  </tr>
  <c:forEach items="${contacts }" var="it" varStatus="state">
	  <tr id="${it.id }">
	    <td  nowrap="nowrap"><a onclick=update(${it.id},${state.count}) href="#">${it.name}</a></td>
	    <td  nowrap="nowrap">${it.phone }</td>
	    <td  nowrap="nowrap">${it.addr }</td>
	    <td  nowrap="nowrap">${it.email }</td>
	    <td  nowrap="nowrap"><img height="20" src='upload/${it.imgPath}'/> </td>
	    <td> 
	      <input type="checkbox" name="id" value="${it.id }"  />
	    </td>
	  </tr>
  </c:forEach> 
 
</table>
 </form>
 