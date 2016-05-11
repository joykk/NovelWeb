<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册页面</title>
<link href="resources/style/style.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='js/jquery-1.8.2.js'></script>
<script type='text/javascript' src="js/RegistercheckErrorCode.js"></script>
</head>
<body class="loginbody">
	<div class="dataEye">
		<div class="loginbox registbox">
			<div class="logo-a">
				<a href="index.jsp" title="NovaBook">
					<h1>NovaBook</h1>
				</a>
			</div>
			<div class="login-content reg-content">
				<div class="loginbox-title">
					<h3>注册</h3>
				</div>
				<form id="signupForm" action="RegisterServlet" method="post">
					<div class="login-error"></div>
					<div class="row">
						<label>用户名</label> <label id="message" style="color:red">提示</label><input type="text"
						 class="input-text-user noPic input-click"
							name="username" id="username" value="${user.userName}">
					</div>
					<div class="row">
						<label>密码</label> <label id="message2" style="color:red">提示</label> <input
							type="password" value=""
							class="input-text-password noPic input-click" name="password"
							id="password">
					</div>
					<div class="row">
						<label>确认密码</label> <input
							type="password" value=""
							class="input-text-password noPic input-click"
							name="passwordAgain" id="passwordAgain">
					</div>
					<div style="margin: 20px 30px -10px 30px"><input type="radio" name="man" value="reader" checked="checked" />读者 <input
					type="radio" name="man" value="author" />作者</div>
					<div class="row tips">
						<input type="checkbox" id="checkBox" name="checkBox" checked="checked" style="margin-top: 30px"> <label>
							我已阅读并同意 <a href="#" target="_blank">隐私政策、服务条款</a>
						</label>
					</div>
					<div class="row btnArea">
					<input type="submit" value="注册" id="submi" class="login-btn">
					</div>
				</form>
			</div>
			<div class="go-regist">
				已有帐号,请<a href="login.jsp" class="link">登录</a>
			</div>
		</div>
	</div>
</body>
</html>


