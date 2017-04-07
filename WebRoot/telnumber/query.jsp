<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>���ٿ��������ʾ��Ŀ</title>
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
				<!-- ���� -->
				<div class="conten_top" name="top">�绰���뵼��</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>״̬��</td>
							<td><html:select name="telNumberForm" property="stateCode" styleClass="commonTextFieldHover" onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'">
									<html:option value="">--��ѡ��--</html:option>
									<html:option value="0">δѡ</html:option>
									<html:option value="1">��ѡ</html:option>
								</html:select>
							</td>
							<td>����</td>
							<td><html:select name="telNumberForm" property="quyuCode" styleClass="commonTextFieldHover" onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
									<html:option value="����">����</html:option>
								</html:select>
							</td>
							<td>���룺</td>
							<td><html:text name="telNumberForm" property="telNoCode" size="12" onkeypress="if(event.keyCode==13||event.which==13){return false}" />
							</td>
							<td align="right"><input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('telNumberList.do?act=query')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;"></div>
				</div>
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result">
					<!-- ��ҳͷ -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- ���һ�� start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="98%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">&nbsp;</td>
								<td class="tableTitleLine">����</td>
								<td class="tableTitleLine">����</td>
								<td class="tableTitleLine">ʹ��״̬</td>
								<td class="tableTitleLine">С������</td>
								<td class="tableTitleLine">�û���ַ</td>
								<td class="tableTitleLine">��ע</td>
								<td class="tableTitleLine">ѡ����</td>
								<td class="tableTitleLine">ѡ��ʱ��</td>
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
											document.getElementById("sta" + id).innerHTML = "��ʹ��";
										} else {
											document.getElementById("sta" + id).innerHTML = "��ʹ��";
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
					<!-- ���һ�� end-->
					<div name="page_down" class="page_down">
						<div align="right">
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- ��ѯ��� end -->
				<!-- button -->
				<div name="button" class="content_button">
					<html:button property="btnSave" value="���" styleClass="commonButton" onclick="removeData111()" />
					<html:button property="btnSave" value="��" styleClass="commonButton" onclick="lockData()" />
					<html:button property="btnSave" value="�༭" styleClass="commonButton" onclick="commonCheckSubmit('telNumEdit.do?act=initEdit','UUID','��ѡ����༭�ĵ绰����')" />
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
				<td>�绰�����ϴ���</td>
				<td><input name="formFile" type="file" size="60" class="commonTextFieldHover" onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'" /> <html:submit property="telUpload" value="�ϴ�" styleClass="commonButton"></html:submit> <a href="./telnumber/telUpload.xls">ģ������</a>
				</td>
			</tr>
		</table>
	</html:form>
</body>
<script>
	function removeData111() {
		if (checkSelect("UUID", "��ѡ��Ҫ���ĺ��룡")) {
			confirmRemove1();
		}
	}
	function confirmRemove1() {
		showConfirm('ȷ��Ҫ�ָ��˺��룿', removeCallback1);
	}
	function removeCallback1(v, m, f) {
		if (v) {
			document.forms[0].action = "telNumEdit.do?act=update";
			disableAll(document);
			document.forms[0].submit();
		}
	}

	function lockData() {
		if (checkSelect("UUID", "��ѡ��Ҫ�󶨵ĺ��룡")) {
			lockRemove1();
		}
	}
	function lockRemove1() {
		showConfirm('ȷ��Ҫ�󶨴˺��룿', lockCallback1);
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
