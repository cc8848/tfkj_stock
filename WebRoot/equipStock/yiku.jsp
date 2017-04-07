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
		<a:base />
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/common.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="equipStock/equipStock.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="equipStockEdit.do">
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">
				�豸�ƿ�
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="940px">
					<tr height="35px">
						<td class="editTableTitleLast">��ѡ��Ҫת�ƵĿ��أ�</td>
						<td class="editTableContentLast">
							<html:select name="equipStockEntiyForm" property="chukuplaceString" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="������">������</html:option>
								<html:option value="����һ��">����һ��</html:option>
								<html:option value="�������">�������</html:option>
								<html:option value="����һ��">����һ��</html:option>
							</html:select>   
						</td>
					<tr>
					
				</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="yiku();"/>
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('equipStockList.do?act=init')"/>
			</div>
		</div>
	<!-- 	<html:hidden name="equipStockEntiyForm" property="UUIDS" /> -->
		  <input type="hidden" id="UUIDSS" value="${UUIDSS}"/>
		  </html:form>
	</body>
	
	<script type="text/javascript">
	function yiku(){
		var UUIDSS = document.getElementById("UUIDSS").value;
		
		commonSubmit('equipStockEdit.do?act=yiku&UUIDS='+UUIDSS);
		}
	
	</script>
	
</html>