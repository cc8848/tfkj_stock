<!---->
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
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="employee/employee.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="employeeList.do">
		<bean:define id="roleList" name="employeeConditionForm" property="roleList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					登陆账号管理
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								登陆账号：
							</td>
							<td>
								<html:text name="employeeConditionForm" property="employeeCodeCond" size="12" />
							</td>
							<td>
								用户姓名：
							</td>
							<td>
								<html:text name="employeeConditionForm" property="employeeNameCond" size="12" />
							</td>
							<td>
								所属用户组：
							</td>
							<td>
								
							<html:select name="employeeConditionForm" property="departmentCodeCond"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">-请选择-</html:option>
								<html:options collection="roleList" property="key" labelProperty="value" />
							</html:select>
							</td>
							
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('employeeList.do?act=query')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- 查询结果 start -->
				<div name="result" class="conten_result">
					<!-- 分页头 -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- 结果一览 start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="98%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine">
									登陆账号
								</td>
								<td class="tableTitleLine">
									用户名称
								</td>
								<td class="tableTitleLine" weight="20%">
									密码
								</td>
								<td class="tableTitleLine">
									权限组
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine">
										<input name="employeeCode" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="PK_ID" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="EMP_NAME" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="employeePassword" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="ROLE_NAME" />
									</td>
								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- 结果一览 end-->
					<div name="page_down" class="page_down">
						<div align="right">
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- 查询结果 end -->
				<!-- button -->
				<div name="button" class="content_button">
						<html:button property="btnSave" value="添加" styleClass="commonButton" onclick="commonSubmit('employeeEdit.do?act=initInsert')"/>
						<html:button property="btnSave" value="编辑" styleClass="commonButton" onclick="commonCheckSubmit('employeeEdit.do?act=initEdit','employeeCode','请选择待编辑的人员')"/>
						<html:button property="btnSave" value="删除" styleClass="commonButton" onclick="removeData()"/>
				</div>
			</div>
			<html:hidden name="employeeConditionForm" property="employeeCodeHidden" />
			<html:hidden name="employeeConditionForm" property="employeeNameHidden" />
			<html:hidden name="employeeConditionForm" property="departmentCodeHidden" />
			<html:hidden name="employeeConditionForm" property="departmentNameHidden" />
		</html:form>
	</body>
</html>
