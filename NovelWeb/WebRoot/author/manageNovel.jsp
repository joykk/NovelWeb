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
	<span class="cp_title">小说管理</span>
	<div class="add_cp">
		<a href="addNovel.jsp">+添加小说</a>
	</div>
	<div class="table_con">
		<table>
			<tr class="tb_title">
				<td width="10%">序号</td>
				<td width="25%">小说名</td>
				<td width="12%">类别</td>
				<td width="12%">点击量</td>
				<td width="10%">字数</td>
				<td width="10%">状态</td>
				<td width="21%">操作</td>
			</tr>
			<c:forEach items="${novels}" var="novel" varStatus="status">
				<tr class="tb_title">
					<td width="10%">${status.index+1}</td>
					<td width="25%">${novel.novelName}</td>
					<td width="12%">${novel.category}</td>
					<td width="12%">${novel.clickCount}</td>
					<td width="10%">${novel.wordCount}</td>
					<td width="10%">${novel.progress}</td>
					<td width="21%"><a href="EditNovelServlet?novelID=${novel.novelID}">编辑</a>
					<a style="margin-left: 10px" href="DelNovelServlet?novelID=${novel.novelID}">删除</a>
					<a style="margin-left: 10px" href="UpdateChapter?novelID=${novel.novelID}">更新章节</a></td>
				</tr>
			</c:forEach>
		</table>
		<p>${message}</p>
	</div>
</body>
</html>
