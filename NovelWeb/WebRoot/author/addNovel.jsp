<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录</title>
<link rel="stylesheet" type="text/css" href="css/Iframe.css" />

</head>

<body style="background:#fff">
	<form  action="AddNovelServlet" method="post">
		<div class="FORM_Content">
			<span class="FORM_title">添加小说</span>
			<hr class="FORM_HR" />
			<div>
				<table>
					<tr>
						<td>小说名</td>
						<td><input class="FORM_input" type="text" placeholder="小说名"
							name="novelName" /></td>
					</tr>
					<tr>
						<td>类别</td>
						<td><select name="category" class="FORM_input">
								<option value="玄幻">玄幻</option>
								<option value="武侠">武侠</option>
								<option value="修真">修真</option>
								<option value="爱情">爱情</option>
						</select></td>
					</tr>
					<tr>
						<td>内容简介</td>
						<td><textarea class="FORM_Area" name="content"></textarea></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="submit" value="添加" class="FORM_button" /> <input
							type="reset" value="重置" class="FORM_button" /></td>
					</tr>
				</table>
				<p>${message}</p>
			</div>

		</div>
	</form>
</body>
</html>
