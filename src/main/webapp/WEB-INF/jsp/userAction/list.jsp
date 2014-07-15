<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>用户管理</title>
	<%@include file="../public/common.jspf" %>
</head>
<body>
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/>用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<div id="MainArea">
	<table class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="10%">登陆名称</td>
            	<td width="10%">真实姓名</td>
                <td width="20%">email</td>
                <td width="20%">qq</td>
                <td width="10%">状态</td>
                <td>相关操作</td>
            </tr>
        </thead>
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer">
        
        <s:iterator value="#userList">
			<tr class="TableDetail1 template">
				<td>${loginName}&nbsp;</td>
				<td>${userName}&nbsp;</td>
				<td>${email}&nbsp;</td>
				<td>${qq}&nbsp;</td>
				<td>${status}&nbsp;</td>
				<td>
					<s:a action="user_delete?userId=%{userId}" onclick="return confirm('确定要删除吗？')">删除</s:a>
					<s:a action="user_editUI?userId=%{userId}">修改</s:a>
					<s:a action="user_initPassword?userId=%{userId}" onclick="return confirm('初始化为:123456')">重置密码</s:a>
					&nbsp;
				</td>
			</tr>
        </s:iterator>

        </tbody>
    </table>
     <!-- 其他功能超链接 -->
    <div id="TableTail">
		<div id="TableTail_inside">
			<s:a action="user_addUI"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></s:a>
        </div>
    </div>
   </div>
</body>
</html>
