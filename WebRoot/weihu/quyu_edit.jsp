<!---->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<title>���ٿ��������ʾ��Ŀ</title>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<link href="css/common.css" type="text/css" rel="stylesheet" />
<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
<script src="js/validate.js" language="javascript"></script>
<script src="js/common.js" language="javascript"></script>
<script src="js/jquery.js" language="javascript"></script>
<script src="js/popupBox.js" language="javascript"></script>
<script src="js/business.js" language="javascript"></script>
<jsp:include page="/common/commonMessage.jsp" />
</head>
<body onload="init()" id="body1">
	<html:form action="shenqingDataEdit.do">
		<div id="content_all">
			<div class="conten_top" id="top">����վ�༭</div>
			<div class="conten_query" id="query"></div>
			<div id="result" class="conten_result">
				<div id="result_table" class="result_table">
					<table border="0" cellspacing="0" cellpadding="2" width="960px">
						<tr>
							<td valign="top" class="editTableTitleLast" width="80px">����վ���ƣ�</td>
							<td class="editTableContentLast"><html:text name="xiaoquForm" property="quyu" maxlength="80" size="40" styleClass="commonTextFieldHover" onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'" /> <a:need /> <br />
							</td>
						</tr>
						<tr>
							<td valign="top" class="editTableTitleLast" width="80px">��������</td>
							<td class="editTableContentLast"><html:text name="xiaoquForm" property="suoshuquyu" maxlength="80" size="40" styleClass="commonTextFieldHover" onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'" /> <a:need /> <br />
							</td>
						</tr>
					</table>
				</div>
			</div>
			<!--  �����༭ end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="sub();" />
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('quyuweihuList.do?act=init')" />
			</div>
		</div>
		<html:hidden name="xiaoquForm" property="uuidHidden" />
		<html:hidden name="xiaoquForm" property="nameHidden" />
	</html:form>
	<script type="text/javascript">
		function sub() {
			if (checkInput()) {
				commonSubmit('quyuweihuList.do?act=updateQuyu');
			}
		}
		checkInput = function() {
			var quyu = document.forms[0].quyu.value;
			if (quyu == null || trim(quyu) == "") {
				alert("����վ���Ʊ�����д��");
				document.forms[0].quyu.focus();//���ý���
				return false;
			}
			return true;
		};
	</script>
</body>
</html>