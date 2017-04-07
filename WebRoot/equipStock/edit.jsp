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
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/common.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="equipStock/equipStock.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
	</head>
	<body onload="init()">
		<html:form action="equipStockEdit.do">
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">
				�豸�༭
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="940px">
					<tr height="35px">
						<td class="editTableTitle">�豸���</td>
						<td class="editTableContent">
							<html:select name="equipStockEntiyForm" property="typeString" onchange="showBigUnit(this)"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="������">������</html:option>
								<html:option value="ONU">ONU</html:option>
							</html:select>   
						</td>
					<tr>
					<tr height="35px">
						<td class="editTableTitle" >�豸��ţ�</td>
						<td class="editTableContent" >
						<html:text name="equipStockEntiyForm" property="xianghaoString"maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" maxlength="6"/>
							<a:need />
							
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >�豸�ͺţ�</td>
						<td class="editTableContent" >
							<html:text name="equipStockEntiyForm" property="xinghaoString" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >���ʱ�䣺</td>
						<td class="editTableContent" >
						<html:text name="equipStockEntiyForm" property="rukudateString"  styleId="rukudateString"
								styleClass="commonTextFieldHover" maxlength="20"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						<img onclick="WdatePicker({el:'rukudateString'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 		
							<a:need />
						</td>
					</tr>
					
					<tr height="35px">
						<td class="editTableTitle" >����ˣ�</td>
						<td class="editTableContent" >
							<html:text name="equipStockEntiyForm" property="rukupersonString" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					
					<tr height="35px">
						<td class="editTableTitle" >mac��</td>
						<td class="editTableContent" >
							<html:text name="equipStockEntiyForm" property="macsString" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<!-- <tr height="35px">
						<td class="editTableTitle" >ע�������</td>
						<td class="editTableContent" >
							<html:text name="equipStockEntiyForm" property="zhucejifangString" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >����IP��</td>
						<td class="editTableContent" >
							<html:text name="equipStockEntiyForm" property="tVipString" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr> -->
					<tr height="35px">
						<td class="editTableTitle" >��ע��</td>
						<td class="editTableContent" >
							<html:text name="equipStockEntiyForm" property="beizhuString" maxlength="50"
								styleClass="commonTextFieldHover"  
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
				</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="commonSubmit('equipStockEdit.do?act=update')"/>
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('equipStockList.do?act=init')"/>
			</div>
		</div>
		<html:hidden name="equipStockEntiyForm" property="UUID" />
		</html:form>
	</body>
</html>