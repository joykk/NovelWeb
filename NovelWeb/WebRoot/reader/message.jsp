<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
   <title>个人中心</title>
<link rel="stylesheet" type="text/css" href="css/Iframe.css" />
<link rel="stylesheet" href="utilLib/bootstrap.min.css" type="text/css" media="screen" />
</head>

<body>
<span class="title"></span>
<div class="gs_name">
    <p><a href="${pageContext.request.contextPath}/IndexServlet">NovaNovel</a></p>
</div>
<div class="qy_con">
	<span>您的个人信息：</span><br />
	<span>读者名:${user.readerName}</span><br />
   	<span>用户名:${user.userName}</span><br />
   	<span>昵称:${user.nickName}</span><br />
   	<span>性别:${user.sex}</span><br />
   	<span>生日:${user.birthday}</span><br />
   	<span>上次登录时间:${user.lastLoginTime}</span><br />
</div>
</body>
</html>
