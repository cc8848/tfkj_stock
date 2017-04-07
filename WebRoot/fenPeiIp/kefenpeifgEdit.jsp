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
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
		%>
		<script src="js/Calendar3.js" language="javascript"></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		
		<script src="js/common.js" language="javascript"></script>
		
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="paigongdan/paigongdan.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		
		<script type="text/javascript">

		</script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init();inittitle();">
		<html:form action="fenguangguizeEdit.do">
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">
				<span id="title">�ɷ���ֹ�༭</span>
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
					<html:hidden styleId="mask" name="keFenPeiFenGuangForm" property="mask"/>
						<table border="0" cellspacing="0" cellpadding="2" width="940px">
					<tr >
						<td class="editTableTitleLast" >�ֹ�ID��</td>
						<td class="editTableContentLast" >
							<html:text name="keFenPeiFenGuangForm" property="fenguangID" ></html:text>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >�ֹ⣺</td>
						<td class="editTableContentLast" >
							<html:text name="keFenPeiFenGuangForm" property="fenguang" ></html:text>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >��ע��</td>
						<td class="editTableContentLast" >
							<html:textarea name="keFenPeiFenGuangForm" property="remark"  
								rows="5" cols="70"  onkeyup="if(this.value.length>200)this.value=this.value.substr(0,200)">
							</html:textarea>
						</td>
					</tr>
					
				</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="subs();"/>
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('kefenpeifenguangList.do?act=init')"/>
			</div>
		</div>
		<html:hidden name="keFenPeiFenGuangForm" property="UUID" />
		</html:form>
	</body>
	<script type="text/javascript">

		function checkInput() {
			var fenguangID = document.forms[0].fenguangID.value;
			if (fenguangID == null || trim(fenguangID) == "") {
				alert("�ֹ�ID����Ϊ��");
				document.forms[0].fenguangID.focus();//���ý���
				return false;
			}
			var fenguang = document.forms[0].fenguang.value;
			if (fenguang == null || trim(fenguang) == "") {
				alert("�ֹⲻ��Ϊ��");
				document.forms[0].fenguang.focus();//���ý���
				return false;
			}
			return true;
		}
		function subs() {
			if (checkInput()) {
				commonSubmit('kefenpeifenguangEdit.do?act=updateFenguangGuize');
			}
		}
		function inittitle() {
			var mask = document.forms[0].mask.value;
			if(mask=="1") {
				document.getElementById("title").innerHTML="�ѷ���ֹ�༭";
			}
		}
	</script>
</html>