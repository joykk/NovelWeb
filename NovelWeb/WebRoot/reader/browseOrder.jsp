<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>小说管理</title>
<link rel="stylesheet" type="text/css" href="css/Iframe.css" />
<link rel="stylesheet" href="utilLib/bootstrap.min.css" type="text/css"
	media="screen" />
</head>

<body>
	<span class="cp_title">订单浏览</span>
	<div class="table_con">
		<table>
			<tr class="tb_title">
				<td width="10%">序号</td>
				<td width="25%">日期</td>
				<td width="12%">金额</td>
				<td width="12%">操作</td>
			</tr>
			<c:forEach items="${orderlist}" var="order" varStatus="status">
				<tr class="tb_title">
					<td width="10%">${status.index+1}</td>
					<td width="25%">${order.orderDatetime}</td>
					<td width="12%">${order.orderTotalPrice}</td>
					<td width="21%"><a href="BrowseOrderDetailServlet?readerOrderID=${order.readerOrderID}">查看详单</a>
				</tr>
			</c:forEach>
		</table>
		<p>${message}</p>
	</div>
</body>
</html>
