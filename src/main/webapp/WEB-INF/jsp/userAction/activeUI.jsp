<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮件注册</title>
<%@include file="../public/common.jspf"%>
<link rel="stylesheet" href="style/email/activate.css">
</head>
<body>
	<!-- HeaderPage -->
	<div class="top">
		<div class="top_left">
			<a>www.tianditu.com</a>
		</div>
		<div class="top_rt"></div>
	</div>
	<div class="clear"></div>
	<!-- Content -->
	<div class="clear"></div>
	<div class="actv_main">
		<div class="actv_tit">
			<img src="style/images/email/activ01.gif">
		</div>
		<p class="user_mail">用户激活邮件已发送到您的邮箱
			
			${email} 您需要点击邮件中的确认链接来完成注册！</p>
		<p>
			请您到邮箱中进行确认<span class="bul">
				（请在48小时内完成验证，48小时后邮件失效您将需要重新填写注册信息）</span>
		</p>
		<p style="height: 48px;">
			<a target="_blank" class="go_mail" id="emailHref"
				style="display: block;" href="http://mail.qq.com"></a>
		</p>
		<p>没收到邮件？请按下述提示操作：</p>
		<p>
			1、<a class="a_underline"
				href="ActiveEmail.html?email=${email}">重新发送</a>
			一次验证邮件；<br> 2、请查看激活邮件是否在垃圾邮件中；<br> 3、更换邮箱，重新 <a
				class="a_underline" href="register.html">注册</a>；<br>
		</p>
	</div>

	<!-- FooterPage -->

	<div id="bottom" class="bottom" style="position: static; top: 603px;">

	</div>

</body>
</html>