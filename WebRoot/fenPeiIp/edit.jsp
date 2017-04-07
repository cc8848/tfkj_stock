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
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="paigongdanEdit.do">
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">
				IP����
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="940px">
					<tr height="35px">
						<td class="editTableTitle" >С�����ƣ�</td>
						<td class="editTableContent" >
						<bean:write name="fenPeiIpForm" property="xiaoquname"/>	&nbsp;	
						<html:hidden name="fenPeiIpForm" property="xiaoquname"/>
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >�û���ַ��</td>
						<td class="editTableContent" >
						<bean:write name="fenPeiIpForm" property="userplace"/>&nbsp;
						</td>
					</tr>
					
					<tr height="35px">
						<td class="editTableTitle" >�����</td>
						<td class="editTableContent" >
						<bean:write name="fenPeiIpForm" property="kuadnai"/>&nbsp;	
						</td>
					</tr>
					
					<tr height="35px">
						<td class="editTableTitle" >���ӣ�</td>
						<td class="editTableContent" >
						<bean:write name="fenPeiIpForm" property="tv"/>&nbsp;	
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >�绰��</td>
						<td class="editTableContent" >
						<bean:write name="fenPeiIpForm" property="tel"/>&nbsp;	
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >�ֹ⣺</td>
						<td class="editTableContent" >
							<html:text name="fenPeiIpForm" property="fenguang"  maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >����Ip��</td>
						<td class="editTableContent" >
							<html:text name="fenPeiIpForm" property="tvip" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >����Ip��</td>
						<td class="editTableContent" >
							<html:text name="fenPeiIpForm" property="netIp" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >�绰Ip��</td>
						<td class="editTableContent" >
							<html:text name="fenPeiIpForm" property="telIp" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >�绰VALN��</td>
						<td class="editTableContent" >
							<html:text name="fenPeiIpForm" property="telValn" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >����VALN��</td>
						<td class="editTableContent" >
							<html:text name="fenPeiIpForm" property="netValn" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
				<!-- 	<tr height="35px">
						<td class="editTableTitle" >ҵ��</td>
						<td class="editTableContent" >
							<html:text name="fenPeiIpForm" property="yeWu" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr> -->
					
				</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="commit()"/>
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('rationList.do?act=init')"/>
			</div>
		</div>
		<html:hidden name="fenPeiIpForm" property="pgdUUID" />
		</html:form>
	</body>
	<script type="text/javascript">
	commit=function(){
		if(isnull()){
			alert("ok");
			commonSubmit('fenPeiIpEdit.do?act=update');
			}
		}
	
	isnull = function(){

		var  fenguang= document.forms[0].fenguang.value;
		if(fenguang==null||trim(fenguang)==""){
			alert("�ֹ�Ų���Ϊ�գ�");
			document.forms[0].fenguang.focus();//���ý���
			return false;
			}
		var  tvip= document.forms[0].tvip.value;
		if(tvip==null||trim(tvip)==""){
			alert("TVIP����Ϊ��û������0��");
			document.forms[0].tvip.focus();//���ý���
			return false;
			}
		var  netIp= document.forms[0].netIp.value;
		if(netIp==null||trim(netIp)==""){
			alert("����IP����Ϊ��û������0��");
			document.forms[0].netIp.focus();//���ý���
			return false;
			}
		var  telIp= document.forms[0].telIp.value;
		if(telIp==null||trim(telIp)==""){
			alert("�绰IP����Ϊ��û������0��");
			document.forms[0].telIp.focus();//���ý���
			return false;
			}
		var  telValn= document.forms[0].telValn.value;
		if(telValn==null||trim(telValn)==""){
			alert("�绰valn����Ϊ��û������0��");
			document.forms[0].telValn.focus();//���ý���
			return false;
			}
		var  netValn= document.forms[0].netValn.value;
		if(netValn==null||trim(netValn)==""){
			alert("����valn����Ϊ��û������0��");
			document.forms[0].netValn.focus();//���ý���
			return false;
			}
		return true;
		}
	
	</script>
</html>