<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import ="java.text.*"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>快速开发框架演示项目</title>
		<a:base />
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<script language="javascript">
			function init(){
				document.getElementById("lblUserId").innerHTML = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getEmployeeCode()%>';//window.parent.document.getElementById("employeeCode").value;
				document.getElementById("lblUserName").innerHTML = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getEmployeeName()%>';//window.parent.document.getElementById("employeeName").value;
				var code = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getDepartmentCode()%>';//window.parent.document.getElementById("departmentCode").value;
				if (code == null || code == 'null' || code == undefined) {
					
				} else {
					document.getElementById("lblDepartmentCode").innerHTML = code;
				}
				
				document.getElementById("lblDepartmentName").innerHTML ='<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';// window.parent.document.getElementById("departmentName").value;
			}
		</script>
	</head>
	<body onload="init()">
		<html:form action="main.do">
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					登录信息
				</div>
				
				<div name="result" class="conten_result">
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="2" width="98%">
							<tr height="25px">
								<td class="editTableTitle" >
									用户代码：
								</td>
								<td class="editTableContent" >
									<span id="lblUserId">&nbsp;</span>
								</td>
							</tr>
							<tr height="25px">
								<td class="editTableTitle" >
									用户名称：
								</td>
								<td class="editTableContent" >
									<span id="lblUserName">&nbsp;</span>
								</td>
							</tr>
							<tr height="25px">
								<td class="editTableTitle" >
									所属权限组代码：
								</td>
								<td class="editTableContent" >
									<span id="lblDepartmentCode">&nbsp;</span>
								</td>
							</tr>
							<tr height="25px">
								<td class="editTableTitleLast" >
									所属权限组名称：
								</td>
								<td class="editTableContentLast" >
									<span id="lblDepartmentName">&nbsp;</span>
								</td>
							</tr>
							<tr height="25px">
								<td class="editTableTitleLast" >
									服务器时间：
								</td>
								<td class="editTableContentLast" >
									<span><%
									SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									Date d = new Date();
									String mfMonth = format.format(d);
									 %><%=mfMonth %></span>
								</td>
							</tr>
						</table>
					</div>
				</div>
				
				<div name="button" class="content_button">
				</div>
			</div>
		</html:form>
	</body>
</html>
