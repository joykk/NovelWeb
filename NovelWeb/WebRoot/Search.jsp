<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>查询</title>
    <link rel="stylesheet" type="text/css" href="novelCss/index.css">
  </head>
  <body>
 	 <jsp:include page="header.jsp" flush="true" />
 	 <h2 class="description">查询结果:</h2>
 	 <hr/>
  	<c:if test="${empty searchNovels}">
		抱歉没有查询到你想要的书籍。。
	</c:if>
    <c:forEach items="${searchNovels}" var="novel">
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
  </body>
</html>
