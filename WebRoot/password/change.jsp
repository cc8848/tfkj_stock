<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>����������ҵ��ʱ���ϵͳ</title>
		<a:base />
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/common.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="password.do">
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					�����޸�
				</div>
				
				<div name="result" class="conten_result">
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="2" width="960px">
							<tr height="35px">
								<td class="editTableTitle" >
									ԭ���룺
								</td>
								<td class="editTableContent" >
									<html:password name="passwordForm" property="oldPassword"
										styleClass="commonTextFieldHover" 
										onfocus="this.className='commonTextFieldMove'" 
										onblur="this.className='commonTextFieldHover'" />
									<a:need />
								</td>
							</tr>
							<tr height="35px">
								<td class="editTableTitle" >
									�����룺
								</td>
								<td class="editTableContent" >
									<html:password name="passwordForm" property="newPassword"
										styleClass="commonTextFieldHover" 
										onfocus="this.className='commonTextFieldMove'" 
										onblur="this.className='commonTextFieldHover'" />
									<a:need />
								</td>
							</tr>
							<tr height="35px">
								<td class="editTableTitleLast" >
									������ȷ�ϣ�
								</td>
								<td class="editTableContentLast" >
									<html:password name="passwordForm" property="newPasswordConfirm"
										styleClass="commonTextFieldHover" 
										onfocus="this.className='commonTextFieldMove'" 
										onblur="this.className='commonTextFieldHover'" />
									<a:need />
								</td>
							</tr>
						</table>
					</div>
				</div>
				
				<div name="button" class="content_button">
					<html:button property="btnSave" value="����" styleClass="commonButton" onclick="commonSubmit('password.do?act=change')"/>&nbsp;&nbsp;
				</div>
			</div>
		</html:form>
	</body>
</html>
