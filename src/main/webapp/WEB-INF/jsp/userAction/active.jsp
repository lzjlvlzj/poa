<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>邮件激活</title>
<%@include file="../public/common.jspf"%>
</head>
<body>
	
	<s:fielderror escape="false"/>
	<h1>邮箱激活成功</h1>
	<br /> ${emailTimeout}
	<a href="user_login.action">登陆</a>
</body>
</html>