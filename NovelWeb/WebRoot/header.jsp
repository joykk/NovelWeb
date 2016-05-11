<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<link rel="stylesheet" type="text/css" href="novelCss/header.css">
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/search.js"></script>

<div id="header"> 
<br/><a href="index.jsp"><h1>NovaBook</h1></a>
	<div id="headerleft">
	<input class="search" id="search" type="text"/><button type="button" onclick="search()">搜索</button>
	<br/><br/><a href="${ pageContext.request.contextPath}/IndexServlet">刷新</a></div>
	<div id="headerright"> 
	<div><a href=" ${ pageContext.request.contextPath}/login.jsp">登录</a>&nbsp;&nbsp;<a href=" ${pageContext.request.contextPath }/register.jsp">注册</a></div>
	welcome:${user.userName}<br>
	<a href="reader/index.jsp" >个人中心</a><br>
	<div>
	<a href="ReaderOrderServlet" id="ShoppingCar">购物车:${fn:length(ShoppingCar)}</a><br>
	</div>
	</div>
</div>