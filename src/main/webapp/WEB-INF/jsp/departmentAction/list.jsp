<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>部门管理</title>
	<%@include file="../public/common.jspf" %>
</head>
<body>
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/>部门管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
	<table class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="20%">部门名称</td>
            	<td width="20%">上级部门</td>
            	<td width="20%">部门描述</td>
                <td width="20%">创建时间</td>
                <td>相关操作</td>
            </tr>
        </thead>
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer">
        
        <s:iterator value="#deptList">
			<tr class="TableDetail1 template">
				<td>
				<s:a action="dept_list?parentId=%{deptId}">${deptName}</s:a>
				&nbsp;
				</td>
				<td>${parent.deptName}&nbsp;</td>
				<td>${description}&nbsp;</td>
				<td>${createTime}&nbsp;</td>
				<td>
					<s:a action="dept_delete?deptId=%{deptId}" onclick="return confirm('确定要删除吗？')">删除</s:a>
					<s:a action="dept_editUI?deptId=%{deptId}">修改</s:a>
					&nbsp;
				</td>
			</tr>
        </s:iterator>

        </tbody>
    </table>
     <!-- 其他功能超链接 -->
    <div id="TableTail">
		<div id="TableTail_inside">
			<s:a action="dept_addUI"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></s:a>
			<s:a action="dept_list?parentId=%{#parent.parent.id}"><img src="${pageContext.request.contextPath}/style/blue/images/button/ReturnToPrevLevel.png" /></s:a>
        </div>
    </div>
   </div>

<div class="Description">
	说明：<br />
	1，上级部门的列表是有层次结构的（树形）。<br/>
	2，如果是修改：上级部门列表中不能显示当前修改的部门及其子孙部门。因为不能选择自已或自已的子部门作为上级部门。<br />
</div>
</body>
</html>
