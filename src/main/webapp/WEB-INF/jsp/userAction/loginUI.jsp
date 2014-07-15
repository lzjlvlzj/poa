<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK HREF="style/blue/login.css" type=text/css rel=stylesheet />
<title>用户登录</title>
<%@include file="../public/common.jspf" %>
	<script type="text/javascript">
		$(function(){
			document.forms[0].loginName.focus();
		});
		
		// 在被嵌套时就刷新上级窗口
		if(window.parent != window){
			window.parent.location.reload(true);
		}
	</script>
</head>
<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody >
	<FORM METHOD="post" NAME="actForm" ACTION="user_login.action">
	    <DIV ID="CenterAreaBg">
	        <DIV ID="CenterArea">
	            <DIV ID="LogoImg">
	            	<IMG BORDER="0" SRC="style/blue/images/logo.png" /> 
	            	<span><font color="red"><s:fielderror escape="false"/></font></span>
	            </DIV>
	            <DIV ID="LoginInfo">
	                <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
	                    <TR>
	                        <TD width=45 CLASS="Subject"><IMG BORDER="0" SRC="style/blue/images/login/userId.gif" /></TD>
	                        <TD><INPUT SIZE="20" CLASS="TextField" TYPE="text" NAME="loginName" /></TD>
	                        <TD ROWSPAN="2" STYLE="padding-left:10px;"><INPUT TYPE="image" SRC="style/blue/images/login/userLogin_button.gif"/></TD>
	                    </TR>
	                    <TR>
	                        <TD CLASS="Subject"><IMG BORDER="0" SRC="style/blue/images/login/password.gif" /></TD>
	                        <TD><INPUT SIZE="20" CLASS="TextField" TYPE="password" NAME="password" /></TD>
	                    </TR>
	                </TABLE>
	            </DIV>
	            <DIV ID="CopyRight"><A HREF="javascript:void(0)">&copy; 2010 版权所有 p</A></DIV>
	        </DIV>
	    </DIV>
	</FORM>
</BODY>
</html>