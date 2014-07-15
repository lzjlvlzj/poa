<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>岗位设置</title>
<%@include file="../public/common.jspf"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/script/3rd/jquery_treeview/jquery.treeview.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/blue/file.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/script/3rd/jquery_treeview/jquery.treeview.css" />
<script type="text/javascript">
	function selectAll(obj) {
		var value = obj.checked;
		var checkBoxs = jQuery('[name=privilegeIds]');
		checkBoxs.each(function() {
			this.checked = value;
		});
	}
	$(function() {
		doChecked();
	});
	function doChecked() {
		var checkBoxs = jQuery('[name=privilegeIds]');
		checkBoxs.each(function() {
			var ck = jQuery(this);
			ck.click(function() {
				selectSub(ck[0]);
				selectParent(ck[0]);
			});
		});
	}
	
	function selectParent(obj){
		var value = obj.checked;
		var ul = jQuery(obj).parents("ul");
		ul.each(function(){
			var inputs = $(this).siblings("input");
			inputs.each(function(){
				if(this){
					this.checked = value;
				}
			});
		});
	}
	
	function selectSub(obj) {
		var subs = $(obj).siblings("ul").find("input");
		subs.each(function() {
			this.checked = obj.checked;
		});
	}
</script>
</head>
<body>
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				设置岗位
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
	<!--显示表单内容-->
	<div id=MainArea>

		<s:form action="role_setPrivilege">
			<s:hidden name="id"></s:hidden>

			<div class="ItemBlock_Title1">
				<!-- 信息说明 -->
				<div class="ItemBlock_Title1">
					<img border="0" width="4" height="7"
						src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
					正在为【${roleName}】配置权限
				</div>
			</div>

			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">

					<table class="mainForm">
						<!--表头-->
						<thead>
							<tr align="LEFT" valign="MIDDLE" id="TableTitle">
								<td width="300px" style="padding-left: 7px;">
									<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
									<input type="checkbox" id="cbSelectAll"
									onClick="selectAll(this);" /> <label for="cbSelectAll">全选</label>
								</td>
							</tr>
						</thead>

						<!--显示数据列表-->
						<tbody id="TableData">
							<tr class="TableDetail1">
								<!-- 显示权限树 -->
								<td>
									<ul id='tree'>
										<s:iterator value="#application.topPrivilegeList">
											<li><input type='checkbox' name='privilegeIds'
												value="${prid}" id='cb_${prid}' <s:property value="%{prid in privilegeIds ? 'checked' : ''}"/>/> 
												<label for='cb_${prid}'>
													<span class='folder' id='sp_${prid}'>${privilegeName}</span>
												</label>
												<ul>
													<s:iterator value="children">
														<li id='li_${prid}'>
															<input type='checkbox'
																name='privilegeIds' value="${prid}" id='cb_${prid}' 
																<s:property value="%{prid in privilegeIds ? 'checked' : ''}"/>/> 
															<label for='cb_${prid}'>
																<span class='folder' id='sp_${prid}'>${privilegeName}</span>
														    </label>
															<ul>
																<s:iterator value="children">
																	<li id='li_${prid}'>
																		<input type='checkbox'
																			name='privilegeIds' value="${prid}" id='cb_${prid}' 
																			<s:property value="%{prid in privilegeIds ? 'checked' : ''}"/>/>
																		<label for='cb_${prid}'>
																			<span class='folder' id='sp_${prid}'>${privilegeName}</span>
																		</label>
																	</li>
																</s:iterator>
															</ul>
														</li>
													</s:iterator>
												</ul></li>
										</s:iterator>
									</ul>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<script type="text/javascript">
				$("#tree").treeview();
			</script>
			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="image"
					src="${pageContext.request.contextPath}/style/images/save.png" />
				<a href="javascript:history.go(-1);"><img
					src="${pageContext.request.contextPath}/style/images/goBack.png" /></a>
			</div>
		</s:form>
	</div>

	<div class="Description">
		说明：<br /> 1，选中一个权限时：<br /> &nbsp;&nbsp;&nbsp;&nbsp; a，应该选中他的所有直系上级。<br />
		&nbsp;&nbsp;&nbsp;&nbsp; b，应该选中他的所有直系下级。<br /> 2，取消选择一个权限时：<br />
		&nbsp;&nbsp;&nbsp;&nbsp; a，应该取消选择他的所有直系下级。<br />
		&nbsp;&nbsp;&nbsp;&nbsp; b，如果同级的权限都是未选择状态，就应该取消选中他的直接上级，并向上做这个操作。<br />

		3，全选/取消全选。<br /> 4，默认选中当前岗位已有的权限。<br />
	</div>


</body>
</html>

