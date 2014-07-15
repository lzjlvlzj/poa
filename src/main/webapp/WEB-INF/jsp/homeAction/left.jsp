<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
<title>导航菜单</title>
<%@include file="../public/common.jspf"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/script/menu/menu.js"></script>
<link type="text/css" rel="stylesheet" href="style/blue/menu.css" />

</head>

<body style="margin: 0">
	<div id="Menu">
		<ul id="MenuUl">
			<s:iterator value="#application.topPrivilegeList">
				<s:if test="#session.user.hasPrivilegeByName(privilegeName)"><!-- 可以调用java类里的方法 -->
					<li class="level1">
						<div onclick="menuClick(this)" class="level1Style">
							<img src="style/images/MenuIcon/FUNC200${prid}.gif" class="Icon" />${privilegeName}
						</div>
						<ul style="display: none;" class="MenuLevel2">
							<s:iterator value="children">
								<s:if test="#session.user.hasPrivilegeByName(privilegeName)">
									<li class="level2">
										<div class="level2Style">
											<img src="style/images/MenuIcon/menu_arrow_single.gif" /> 
											<a target="right" href="${pageContext.request.contextPath}${url}.action" style="cursor: pointer">${privilegeName}</a>
										</div>
									</li>
								</s:if>
							</s:iterator>
						</ul>
					</li>
				</s:if>
			</s:iterator>
		</ul>
	</div>
</body>
</html>