<%@page import="entity.Good"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'GoodList.jsp' starting page</title>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
</head>

<body>
<%-- 	<%
		List<Good> goodList= (List<Good>)request.getAttribute("goodList"); 
		
	 %> --%>
	<div class="container-fluid">
  		<table class="table table-bordered">
  			<tr>
  				<td>商品名称</td>
  				<td>商品数量</td>
  				<td>商品价格</td> 				
  			</tr>
  			<c:forEach items="${goodList}" var="good">
  				<td>${good.goodName}</td>
  				<td>${good.goodNum}</td>
  				<td>${good.goodPrice}</td>
  			</c:forEach>
		</table>
	</div>
	<script src="./js/bootstrap.js" type="text/javascript"></script>
	<script src="./js/jquery-2.1.1.js" type="text/javascript"></script>
</body>
</html>
