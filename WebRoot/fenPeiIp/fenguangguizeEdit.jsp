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
	<body onload="init()">
		<html:form action="fenguangguizeEdit.do">
		<bean:define id="xiaoquList" name="fenPeiFenGuangGuiZeForm" property="xiaoquList"></bean:define>
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">
				�ֹ�������༭
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="2" width="940px">
							<tr height="35px">
								<td class="editTableTitle" width="30px">С�����ƣ�</td>
								<td class="editTableContent" >
								<html:select name="fenPeiFenGuangGuiZeForm" property="xiaoqu" styleId="xiaoquname" 
								styleClass="commonTextFieldHover"  onchange="selectxiaoqu(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							<a:need />
							</td>
						</tr>
						<tr >
						<td class="editTableTitleLast" >¥�ţ�</td>
						<td class="editTableContentLast" >
							<html:text name="fenPeiFenGuangGuiZeForm" property="louhao" ></html:text>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >¥�ţ�</td>
						<td class="editTableContentLast" >
							<html:text name="fenPeiFenGuangGuiZeForm" property="loumen" ></html:text>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >¥�㣺</td>
						<td class="editTableContentLast" >
							<html:text name="fenPeiFenGuangGuiZeForm" property="louceng" ></html:text>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >��Ԫ��</td>
						<td class="editTableContentLast" >
							<html:text name="fenPeiFenGuangGuiZeForm" property="danyuan" ></html:text>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >�ֹ�ID��</td>
						<td class="editTableContentLast" >
							<html:text name="fenPeiFenGuangGuiZeForm" property="fenguangID" ></html:text>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >��ע��</td>
						<td class="editTableContentLast" >
							<html:textarea name="fenPeiFenGuangGuiZeForm" property="beizhu"  
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
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('fenguangguizeList.do?act=init')"/>
			</div>
		</div>
		<html:hidden name="fenPeiFenGuangGuiZeForm" property="UUID" />
		</html:form>
	</body>
	<script type="text/javascript">

		function checkInput() {
			var xiaoqu = document.forms[0].xiaoqu.value;
			if (xiaoqu == null || trim(xiaoqu) == "") {
				alert("С������Ϊ��");
				document.forms[0].xiaoqu.focus();//���ý���
				return false;
			}
			var louhao = document.forms[0].louhao.value;
			if (louhao == null || trim(louhao) == "") {
				alert("¥�Ų���Ϊ��");
				document.forms[0].louhao.focus();//���ý���
				return false;
			}
			var loumen = document.forms[0].loumen.value;
			if (loumen == null || trim(loumen) == "") {
				alert("¥�Ų���Ϊ��");
				document.forms[0].loumen.focus();//���ý���
				return false;
			}
			var louceng = document.forms[0].louceng.value;
			if (louceng == null || trim(louceng) == "") {
				alert("¥�㲻��Ϊ��");
				document.forms[0].louceng.focus();//���ý���
				return false;
			}
			var danyuan = document.forms[0].danyuan.value;
			if (danyuan == null || trim(danyuan) == "") {
				alert("��Ԫ����Ϊ��");
				document.forms[0].danyuan.focus();//���ý���
				return false;
			}
			var fenguangID = document.forms[0].fenguangID.value;
			if (fenguangID == null || trim(fenguangID) == "") {
				alert("�ֹ�ID����Ϊ��");
				document.forms[0].fenguangID.focus();//���ý���
				return false;
			}
			return true;
		}
		function subs() {
			if (checkInput()) {
				commonSubmit('fenguangguizeEdit.do?act=updateFenguangGuize');
			}
		}
	</script>
</html>