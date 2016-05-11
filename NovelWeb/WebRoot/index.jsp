<%@page import="com.bean.NovelBean" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>NovaBook</title>
<link rel="stylesheet" type="text/css" href="novelCss/index.css">
<script type="text/javascript" src="js/addNovelToShoppingCar.js"></script>
<script type='text/javascript' src='js/jquery-1.8.2.js'></script>
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />
	<hr/>
	<c:if test="${empty novellist}">
	<p>error</p>
	</c:if>

	<c:forEach items="${novellist}" var="novel">
	<div id="content">
		<div id="left">
			<img alt="小说图片" src="${novel.pic}">
		</div>
		<div id="main">
			<table>
				<tr>
					<th colspan="5">${novel.novelName}</th>
				</tr>
				<tr><td>作者：${novel.authorName}</td><td>字数:${novel.wordCount}</td><td>点击量:${novel.clickCount}</td>
				<tr>
					<td colspan="5" class="content">简介：${novel.content}</td>
				</tr>
				<tr><td><a href="ReadChapterServlet?NovelID=${novel.novelID}">开始阅读</a></td>
				<td><a href="ReadNovelcCatalog?novelID=${novel.novelID}&novelName=${novel.novelName}">书籍目录</a></td>
				<td><a href="javascript:void(0);novelID=${novel.novelID}" onclick="addNovelToShoppingCar()">加入购物车</a></td></tr>
			</table>
		</div>
	</div>
	<hr/>
	</c:forEach>
	<jsp:include page="footer.jsp" flush="true" />
</body>
</html>
