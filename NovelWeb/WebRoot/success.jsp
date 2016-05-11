<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>${message}成功</title>
    <meta http-equiv="refresh" content="3;url=${pageContext.request.contextPath}/index.jsp">
  </head>
  <body>
  <p style="text-align: center;margin-top: 50px;">${message}成功,3秒后自动跳转首页</p>
  </body>
</html>
