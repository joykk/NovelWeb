<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>订单详细</title>
    <link rel="stylesheet" type="text/css" href="css/Iframe.css" />
<link rel="stylesheet" href="utilLib/bootstrap.min.css" type="text/css"
	media="screen" />
  </head>
 <body>
	<span class="cp_title">订单详细</span>
	<div class="table_con">
		<table>
			<tr class="tb_title">
				<td width="10%">序号</td>
				<td width="25%">书名</td>
				<td width="12%">作者</td>
				<td width="12%">单价</td>
			</tr>
			<c:forEach items="${detaillist}" var="detail" varStatus="status">
				<tr class="tb_title">
					<td width="10%">${status.index+1}</td>
					<td width="25%">${detail.novelName}</td>
					<td width="12%">${detail.novelAuthor}</td>
					<td width="12%">${detail.price}</td>
				</tr>
			</c:forEach>
		</table>
		<p>${message}</p>
	</div>
</body>
</html>
