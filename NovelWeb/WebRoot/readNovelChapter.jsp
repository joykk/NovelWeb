<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>${ChapterName}</title>
<link rel="stylesheet" type="text/css"
	href="novelCss/chapterContent.css">
</head>
<body>
	<div id="content">
		<h2>${ChapterName}</h2>
		<div id="article">
			<pre
				style="word-wrap: break-word; white-space: pre-wrap; white-space: -moz-pre-wrap">
  				${ChapterContent}</pre>
		</div>

	<div>
	<a class="aL" href="ReadChapterServlet?ChapterID=${UpAndDownChapterlist[0].chapterID}&ChapterName=${UpAndDownChapterlist[0].chapterName}&NovelID=${NovelID}">上一章:${UpAndDownChapterlist[0].chapterName }</a>
	<a class="aR" href="ReadChapterServlet?ChapterID=${UpAndDownChapterlist[1].chapterID}&ChapterName=${UpAndDownChapterlist[1].chapterName}&NovelID=${NovelID}">下一章:${UpAndDownChapterlist[1].chapterName }</a>
	
	</div>
	</div>
	<jsp:include page="footer.jsp" flush="true" />
</body>
</html>
