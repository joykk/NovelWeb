<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>购书清单</title>
    <link rel="stylesheet" type="text/css"
	href="novelCss/readOrder.css">
  </head>
  <body>
  <h2>购书清单</h2>
    <div id="content">
    <table>
    <tr>
    <th>名称</th>
    <th>作者</th>
    <th>售价</th>
    <th>删除</th>
    </tr>
    <c:forEach items="${ShoppingCar}" var="novel">
    <tr>
    <td>${novel.novelName}</td>
    <td>${novel.authorName}</td>
    <td>${novel.price}</td>
    <td><a href="ReaderOrderServlet?delID=${novel.novelID}">删除</a></td>
    </tr>
    </c:forEach>
    </table>
    <div class="DR">总价:${totalPrice}元</div>
    <div class="DR"><a href="ReaderOrderServlet?pay=ok">提交订单</a></div>
    </div>
  </body>
</html>
