<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="${ctx}/static/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="${ctx}/static/system/css/loginStyle.css">
<title><sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
</head>
<body>
<sitemesh:write property='body' />
</body>
</html>