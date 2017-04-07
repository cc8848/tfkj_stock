<!---->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>哈尔滨银行业务时点绑定系统</title>
		<a:base />
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="department/department.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="departmentList.do">
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					部门管理
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								部门代码：
							</td>
							<td>
								<html:text name="departmentConditionForm" property="departmentCodeCond" size="12" />
							</td>
							<td>
								部门名称：
							</td>
							<td>
								<html:text name="departmentConditionForm" property="departmentNameCond" size="12" />
							</td>
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('departmentList.do?act=query')" />
							</td>
						</tr>
					</table>
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
								<td class="tableTitleLine" width="5%">
									&nbsp;
								</td>
								<td class="tableTitleLine">
									部门代码
								</td>
								<td class="tableTitleLine">
									部门名称
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine">
										<input name="departmentCode" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="PK_ID" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="DEPT_NAME" />
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
					<html:button property="btnSave" value="添加" styleClass="commonButton" onclick="commonSubmit('departmentEdit.do?act=initInsert')"/>
					<html:button property="btnSave" value="编辑" styleClass="commonButton" onclick="commonCheckSubmit('departmentEdit.do?act=initEdit','departmentCode','请选择待编辑的部门')"/>
					<html:button property="btnSave" value="删除" styleClass="commonButton" onclick="removeData()"/>
				</div>
			</div>
			<html:hidden name="departmentConditionForm" property="departmentCodeHidden" />
			<html:hidden name="departmentConditionForm" property="departmentNameHidden" />
		</html:form>
	</body>
</html>
