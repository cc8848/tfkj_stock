<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>快速开发框架演示项目</title>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<link href="css/common.css" type="text/css" rel="stylesheet" />
<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
<script src="js/common.js" language="javascript"></script>
<script src="js/validate.js" language="javascript"></script>
<script src="js/jquery.js" language="javascript"></script>
<script src="js/popupBox.js" language="javascript"></script>
<script src="telnumber/telnumber.js" language="javascript"></script>
<script src="js/business.js" language="javascript"></script>
<jsp:include page="/common/commonMessage.jsp" />
</head>
<body onload="init()">
	<div style="height:440px;">
		<html:form action="telNumberList.do">
			<bean:define id="xiaoquList" name="telNumberForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">电话号码导入</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>状态：</td>
							<td><html:select name="telNumberForm" property="stateCode" styleClass="commonTextFieldHover" onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'">
									<html:option value="">--请选择--</html:option>
									<html:option value="0">未选</html:option>
									<html:option value="1">已选</html:option>
								</html:select>
							</td>
							<td>区域：</td>
							<td><html:select name="telNumberForm" property="quyuCode" styleClass="commonTextFieldHover" onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
									<html:option value="保留">保留</html:option>
								</html:select>
							</td>
							<td>号码：</td>
							<td><html:text name="telNumberForm" property="telNoCode" size="12" onkeypress="if(event.keyCode==13||event.which==13){return false}" />
							</td>
							<td align="right"><input type="button" value="查询" class="commonButton" onclick="commonSubmit('telNumberList.do?act=query')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;"></div>
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
								<td class="tableTitleLine">&nbsp;</td>
								<td class="tableTitleLine">区域</td>
								<td class="tableTitleLine">号码</td>
								<td class="tableTitleLine">使用状态</td>
								<td class="tableTitleLine">小区名称</td>
								<td class="tableTitleLine">用户地址</td>
								<td class="tableTitleLine">备注</td>
								<td class="tableTitleLine">选号人</td>
								<td class="tableTitleLine">选号时间</td>
							</tr>
							<logic:iterate id="line" name="com.takucin.aceeci.frame.pagination" property="result" type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine"><input name="UUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine"><bean:write name="line" field="quyu" />
									</td>
									<td class="tableContentLine"><bean:write name="line" field="telno" />
									</td>
									<td class="tableContentLine"><label id="sta<bean:write name="line" field="PK_ID" />"></label> <script>
										var id = <bean:write name="line" field="PK_ID" />
										var str = <bean:write name="line" field="state" />;
										if (str == 0) {
											document.getElementById("sta" + id).innerHTML = "可使用";
										} else {
											document.getElementById("sta" + id).innerHTML = "已使用";
										}
									</script>
									</td>
									<td class="tableContentLine"><bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine"><bean:write name="line" field="dizhi" />
									</td>
									<td class="tableContentLine"><bean:write name="line" field="beizhu" />
									</td>
									<td class="tableContentLine"><bean:write name="line" field="xuanhaoby" />
									</td>
									<td class="tableContentLine"><br /> <br /></td>
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
					<html:button property="btnSave" value="解绑" styleClass="commonButton" onclick="removeData111()" />
					<html:button property="btnSave" value="绑定" styleClass="commonButton" onclick="lockData()" />
					<html:button property="btnSave" value="编辑" styleClass="commonButton" onclick="commonCheckSubmit('telNumEdit.do?act=initEdit','UUID','请选择待编辑的电话号码')" />
				</div>
			</div>
			<html:hidden name="telNumberForm" property="quyuCodeHidden" />
			<html:hidden name="telNumberForm" property="telNoCodeHidden" />
			<html:hidden name="telNumberForm" property="stateCodeHidden" />
		</html:form>
	</div>
	<html:form action="telUpload.do?act=upload" method="post" enctype="multipart/form-data">
		<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
			<tr>
				<td>电话号码上传：</td>
				<td><input name="formFile" type="file" size="60" class="commonTextFieldHover" onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'" /> <html:submit property="telUpload" value="上传" styleClass="commonButton"></html:submit> <a href="./telnumber/telUpload.xls">模板下载</a>
				</td>
			</tr>
		</table>
	</html:form>
</body>
<script>
	function removeData111() {
		if (checkSelect("UUID", "请选择要解绑的号码！")) {
			confirmRemove1();
		}
	}
	function confirmRemove1() {
		showConfirm('确定要恢复此号码？', removeCallback1);
	}
	function removeCallback1(v, m, f) {
		if (v) {
			document.forms[0].action = "telNumEdit.do?act=update";
			disableAll(document);
			document.forms[0].submit();
		}
	}

	function lockData() {
		if (checkSelect("UUID", "请选择要绑定的号码！")) {
			lockRemove1();
		}
	}
	function lockRemove1() {
		showConfirm('确定要绑定此号码？', lockCallback1);
	}
	function lockCallback1(v, m, f) {
		if (v) {
			document.forms[0].action = "telNumEdit.do?act=updateLock";
			disableAll(document);
			document.forms[0].submit();
		}
	}
</script>
</html>
