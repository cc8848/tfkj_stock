<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2015-12-15   Dai-Zhen           Create
   
  -->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<title>���ٿ��������ʾ��Ŀ</title>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<link href="css/common.css" type="text/css" rel="stylesheet" />
<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
<script src="js/validate.js" language="javascript"></script>
<script src="js/common.js" language="javascript"></script>
<script src="js/jquery.js" language="javascript"></script>
<script src="js/popupBox.js" language="javascript"></script>
<script src="kucun/kucun.js" language="javascript"></script>
<script src="js/business.js" language="javascript"></script>
<jsp:include page="/common/commonMessage.jsp" />
</head>
<body onload="init()">
	<html:form action="shebeirukuList.do">
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">�����ܿⷿ��Ϣ</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr>
							<td valign="top" class="editTableTitle" width="80px">��ţ�</td>
							<td class="editTableContent">
							<html:text name="zongkufangInfoForm" property="zongkufang_ID" size="20" maxlength="30"/><a:need /><br/></br>
							</td>
						</tr>
						<tr>
							<td valign="top" class="editTableTitle" width="80px">�豸���ͣ�</td>
							<td class="editTableContent">
							<html:text name="zongkufangInfoForm" property="eqType" size="20" maxlength="30"/><a:need /><br/></br>
							</td>
						</tr>
						<tr>
							<td valign="top" class="editTableTitle" width="80px">�豸�ͺţ�</td>
							<td class="editTableContent">
							<html:text name="zongkufangInfoForm" property="eqVersion" size="20" maxlength="30"/><a:need /><br/></br>
							</td>
						</tr>
						<tr>
							<td valign="top" class="editTableTitle" width="80px">���������</td>
							<td class="editTableContent">
							<html:text name="zongkufangInfoForm" property="kucunSuu" size="20" maxlength="12"/><a:need /><br/></br>
							</td>
						</tr>
						<tr>
							<td valign="top" class="editTableTitle" width="80px">��ע��Ϣ��</td>
							<td class="editTableContent">
							<html:textarea name="zongkufangInfoForm" property="remark" rows="5" cols="70"
											   onkeyup="if(this.value.length>200)this.value=this.value.substr(0,200)"> </html:textarea><a:need />
							</td>
						</tr>
					</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="sub_update();" />
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('zongkufangInfoList.do?act=init')" />
			</div>
		</div>
	<html:hidden name="kucunForm" property="UUIDHidden" />
	</html:form>
	
</body>
<script language="javascript" type="text/javascript">
	function sub_update() {
		if(checkInput()){
			commonSubmit('zongkufangInfoEdit.do?act=insert_zongkufang');
		}
	}
	checkInput = function() {
			var xuhao = document.forms[0].zongkufang_ID.value;
			if (xuhao == null || trim(xuhao) == "") {
				alert("�����д����");
				document.forms[0].zongkufang_ID.focus();//���ý���
				return false;
			}
			
			var eqType = document.forms[0].eqType.value;
			if (eqType == null || trim(eqType) == "") {
				alert("�豸������д����");
				document.forms[0].eqType.focus();//���ý���
				return false;
			}
			
			var eqVersion = document.forms[0].eqVersion.value;
			if (eqVersion == null || trim(eqVersion) == "") {
				alert("�豸�ͺ���д����");
				document.forms[0].eqVersion.focus();//���ý���
				return false;
			}
			
			var kucunSuu = document.forms[0].kucunSuu.value;
			if (kucunSuu == null || trim(kucunSuu) == "") {
				alert("���������д����");
				document.forms[0].kucunSuu.focus();//���ý���
				return false;
			}
			
			var remark = document.forms[0].remark.value;
			if (remark == null || trim(remark) == "") {
				alert("��ע��Ϣ��д����");
				document.forms[0].remark.focus();//���ý���
				return false;
			}
			return true;
		}
</script>
</html>