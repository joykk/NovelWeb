<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录</title>
<link rel="stylesheet" type="text/css" href="css/Iframe.css" />
<script type="text/javascript" src="js/nicEdit.js"></script>
</head>
<body style="background:#fff">
	<form action="UpdateChapter" method="post">
		<div class="FORM_Content">
			<span class="FORM_title">更新章节---</span>
			<hr class="FORM_HR" />
			<div>
				<table>
					<tr>
						<td>章节名</td>
						<td><input class="FORM_input" type="text" placeholder="章节名"
							name="chapterName" value="${chapter.chapterName}"/></td>
					</tr>
					<tr>
						<td>章节内容</td>
						<td><textarea class="FORM_Area" name="chapterContent" style="width:980px;height: 570px">${chapter.chapterContent}</textarea></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="上传更新" class="FORM_button" /> <input
							type="reset" value="重置" class="FORM_button" /></td>
					</tr>
				</table>
				<p>${message}</p>
			</div>
		</div>
	</form>
</body>
</html>
