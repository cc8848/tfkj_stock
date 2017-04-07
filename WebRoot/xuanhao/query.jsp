<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>���ٿ��������ʾ��Ŀ</title>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="selectTelNumberList.do">
		<bean:define id="xiaoquList" name="selecttelNumberForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					�绰����ѡ��
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
						
							<td>
								����
							</td>
							<td>
								<html:select name="selecttelNumberForm" property="quyuCode"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
									<html:option value="����">����</html:option>
								</html:select>
								<input name="xiaoquname" type="hidden" id="xiaoquname" /> 
							</td>
							<td>
								���룺
							</td>
							<td>
								<html:text name="selecttelNumberForm" property="telNoCode" size="12" onkeypress="if(event.keyCode==13||event.which==13){return false;}"/>
							</td>
							<td align="right">
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('selectTelNumberList.do?act=query')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
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
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine">
									����
								</td>
								<td class="tableTitleLine">
									����
								</td>
								<td class="tableTitleLine">
									С������
								</td>
								<td class="tableTitleLine">
									�û���ַ
								</td>
								<td class="tableTitleLine">
									��ע
								</td>
								<td class="tableTitleLine">
									ѡ����
								</td>
								<td class="tableTitleLine">
									ѡ��ʱ��
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine">
										<input name="TELUUIDS" type="checkbox" value="<bean:write name="line" field="telno" />" 
										onclick="setxiaoqu('<bean:write name="line" field="quyu" />')"/>
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="quyu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="telno" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="beizhu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="xuanhaoby" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="xuanhaodt" />
									</td>
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
				 <html:button property="btnSave" value="ѡ��" styleClass="commonButton" onclick="commonCheckSubmit('paigongdanEdit.do?act=initselect','TELUUIDS','��ѡ���ѡ��ĺ���')"/>
					<!-- 	<html:button property="btnSave" value="���" styleClass="commonButton" onclick="commonSubmit('paigongdanEdit.do?act=initInsert')"/>
						
						<html:button property="btnSave" value="ɾ��" styleClass="commonButton" onclick="removeData()"/>
						<html:button property="btnSave" value="���" styleClass="commonButton" onclick="removeData1()"/>
						<html:button property="btnSave" value="�鿴����" styleClass="commonButton2" onclick="commonCheckSubmit('paigongdanEdit.do?act=showInfo','UUID','��ѡ����鿴���ɹ���')"/>
			 -->	</div>
			</div>
			<html:hidden name="selecttelNumberForm" property="quyuCodeHidden" />
			<html:hidden name="selecttelNumberForm" property="telNoCodeHidden" />
		</html:form>
		</div>
	</body>
<script>
function setxiaoqu(obj){
	document.getElementById("xiaoquname").value=obj;
	
}
</script>
</html>
