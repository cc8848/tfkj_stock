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
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/common.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="paigongdan/paigongdan.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="userinfoEdit.do">
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">
				�ͻ���Ϣ�༭
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="740px">
					
						<tr>
						<td class="editTableTitle" width="30px">
									С������
								:
						</td><td class="editTableContent" >
						<bean:write name="userInfoForm" property="xiaoquname"/>
						<html:hidden name="userInfoForm" property="xiaoquname"/>
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									����
						:</td>
						<td class="editTableContent" >
						<bean:write name="userInfoForm" property="yonghu"/>
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									֤����
						:</td><td class="editTableContent" ><html:text name="userInfoForm" property="zhenjianno" size="20" maxlength="20" 
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									�վݺ�
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="shoujuno" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									�ֹ����ߺ�
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="fenguang" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									onuע��λ��
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="onuzcwz" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									����
						:</td>
					
						<td class="editTableContent" >
						<bean:write name="userInfoForm" property="dizi"/>
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									����ʱ��
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="kaijishijian" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									ͣ��ʱ��
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="tijishijian" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									���
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="daikuan" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									����
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="tv" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									�绰
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="tel" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									�û���
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="username" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									����
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="passwords" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									�̶��绰����
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="guhuahaoma" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									��ϵ�绰
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="usertel" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									����λ��
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="jiguiweizhi" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									ONU��Ϣ���ͺ�/MAC��
						:</td>
						<td class="editTableContent" >
						<bean:write property="onumac" name="userInfoForm"/>
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									������MCID:
						</td>
						<td class="editTableContent" >
						<bean:write property="stbmac" name="userInfoForm"/>&nbsp;
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									����IP
						:</td><td class="editTableContent" ><html:text name="userInfoForm" property="tvip" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									���IP
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="netip" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									�绰IP
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="telip" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									�绰vlan
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="telvaln" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									����vlan
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="netvaln" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									����vlan
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="tvvaln" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									������Ӫ������vlan
								:</td><td class="editTableContent" ><html:text name="userInfoForm" property="qtvaln" size="20" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						
						</tr>
						<tr>
						<td class="editTableTitle" width="30px">
									��ע
								:</td><td class="editTableContent" >
								<html:textarea name="userInfoForm" onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)"
								 property="beizhu" rows="5"  cols="70" ></html:textarea>
						</td>
						
						</tr>
						
						
					
										
				</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="commonSubmit('userinfoEdit.do?act=update');"/>
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('userInfomactonList.do?act=init')"/>
			</div>
		</div>
		<html:hidden name="userInfoForm" property="UUID" />
		</html:form>
	</body>

</html>