<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>论坛管理</title>
<%@include file="../public/common.jspf" %>
<style type="text/css">
    	.disabled{
    		color: gray;
    		cursor: pointer;
    	}
</style>
</head>
<body>
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 版块管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="250px">版块名称</td>
                <td width="300px">版块说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" >
        
        <s:iterator value="#forumList" status="status">
			<tr class="TableDetail1 template">
				<td>${forumName}&nbsp;</td>
				<td>${description}&nbsp;</td>
				<td>
					<s:a action="forumManage_delete?forumId=%{forumId}" onclick="return delConfirm()">删除</s:a>
					<s:a action="forumManage_editUI?forumId=%{forumId}">修改</s:a>
					
					<!-- 最上面的不能上移 -->
					<s:if test="#status.first">
						<span class="disabled">上移</span>
					</s:if>
					<s:else>
						<s:a action="forumManage_moveUp?forumId=%{forumId}">上移</s:a>
					</s:else>
					
					<!-- 最下面的不能下移 -->
					<s:if test="#status.last">
						<span class="disabled">下移</span>
					</s:if>
					<s:else>
						<s:a action="forumManage_moveDown?forumId=%{forumId}">下移</s:a>
					</s:else>
					
				</td>
			</tr>
        </s:iterator>

        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a action="forumManage_addUI"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></s:a>
        </div>
    </div>
</div>

<div class="Description">
	说明：<br />
	1，显示的列表按其位置排列。<br />
	2，可以通过上移与下移功能调整顺序。最上面的不能上移，最下面的不能下移。<br />
</div>

</body>
</html>