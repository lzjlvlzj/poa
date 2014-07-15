<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>部门设置</title>
<%@include file="../public/common.jspf" %>
</head>
<body>
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				部门设置
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
	
	<!--显示表单内容-->
	<div id="MainArea">
		<s:form action="dept_%{ deptId == null ? 'add' : 'edit' }">
			<s:hidden name="deptId"></s:hidden>
			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table class="mainForm">
						<tr>
							<td width="100">上级部门</td>
							<td>
								<s:select headerKey="" headerValue="--请选择部门--" name="parentId"
								list="#deptList" listKey="deptId" listValue="deptName" cssClass="SelectStyle"
								></s:select>
							</td>
						</tr>
						<%-- <tr>
							<td>密      码</td>
							<td><s:textarea name="password" cssClass="InputStyle"></s:textarea></td>
						</tr>
						<tr>
							<td>确认密 码</td>
							<td><s:textarea name="password_cfm" cssClass="InputStyle"></s:textarea></td>
						</tr> --%>
						<tr>
							<td width="100">部门名称</td>
							<td><s:textfield name="deptName" cssClass="InputStyle" /></td>
						</tr>
						<tr>
							<td width="100">部门值</td>
							<td><s:textfield name="deptValue" cssClass="InputStyle" /></td>
						</tr>
						<tr>
							<td width="100">部门描述</td>
							<td><s:textarea name="description" cssClass="InputStyle" /></td>
						</tr>
					</table>
				</div>
			</div>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<!-- <input type="submit" value="保存"/> -->
				<input type="image"
					src="${pageContext.request.contextPath}/style/images/save.png" /> <a
					href="javascript:history.go(-1);"><img
					src="${pageContext.request.contextPath}/style/images/goBack.png" /></a>
			</div>
		</s:form>
	</div>
	
</body>
</html>

