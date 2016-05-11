<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>${novelName}目录</title>
<link rel="stylesheet" type="text/css" href="novelCss/index.css">
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />
	<div id="content">
		<h2>${novelName}目录</h2>
		<table>
			<tr>
				<c:forEach items="${Catalog}" var="catalogItem" varStatus="count">
					<td><c:if test="${count.index%3==0&&count.index!=0}">
							<tr>
							</tr>
							<td>
						</c:if> <a href="ReadChapterServlet?ChapterID=${catalogItem.chapterID}&ChapterName=${catalogItem.chapterName}&NovelID=${novelID}">${catalogItem.chapterName}</a>
					</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	<jsp:include page="footer.jsp" flush="true" />
</body>
</html>
