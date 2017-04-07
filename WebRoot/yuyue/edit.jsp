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
		<html:form action="yuyueEdit.do">
		<bean:define id="xiaoquList" name="yuyueEidtForm" property="xiaoquList"></bean:define>
		<bean:define id="quyuList" name="yuyueEidtForm" property="quyuList"></bean:define>
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">
				�޸�ԤԼ�ƻ�
			</div>
			<!--  �����༭ start -->
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="960px">
				<tr height="35px">
						<td class="editTableTitle" >ԤԼ���ڣ�</td>
						<td class="editTableContent" >
							<html:text name="yuyueEidtForm" property="riqi" styleId="riqi" disabled="true"
								styleClass="commonTextFieldHover" onclick="WdatePicker({el:'riqi'})" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" maxlength="20"/>
								<img onclick="WdatePicker({el:'riqi'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 		
							<a:need /> 
							
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >�������ƣ�</td>
						<td class="editTableContent" >
						<html:select name="yuyueEidtForm" property="xiaoqu" disabled="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:options collection="quyuList" property="key" labelProperty="value" />
							</html:select>  
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >ʱ�䣺</td>
						<td class="editTableContent" >
						<html:select name="yuyueEidtForm" property="shijian" disabled="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="����">����</html:option>
								<html:option value="����">����</html:option>
							</html:select>  
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >�ƻ���װ������</td>
						<td class="editTableContent" >
							<html:text name="yuyueEidtForm" property="azjh" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >�ƻ�ȡ��������</td>
						<td class="editTableContent" >
							<html:text name="yuyueEidtForm" property="qjjh" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />���������ޣ��ɲ���д��
						</td>
					</tr>
					 <tr height="35px">
						<td class="editTableTitleLast" >��ע��</td>
						<td class="editTableContentLast" >
							<html:text name="yuyueEidtForm" property="yujing" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
						<html:hidden name="yuyueEidtForm" styleId="qjsy" property="qjsy"/>
						<html:hidden name="yuyueEidtForm" styleId="azsy" property="azsy"/>
						<html:hidden name="yuyueEidtForm" styleId="UUID" property="UUID"/>
					</tr> 
				</table>
				</div>
			</div>
			<!--  �����༭ end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="subs();"/>
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('yuyueList.do?act=init')"/>
			</div>
		</div>
		</html:form>
	</body>
	<script type="text/javascript">
function subs(){
	if(checkInput()){
		commonSubmit('yuyueEdit.do?act=update')
		//alert("ok");
		}
}
checkInput = function(){
	var riqi = document.forms[0].riqi.value;
	if(riqi==null||trim(riqi)==""){
		alert("ԤԼ���ڲ���Ϊ�գ�");
		document.forms[0].riqi.focus();//���ý���
		return false;
		}

	var xiaoqu = document.forms[0].xiaoqu.value;
	if(xiaoqu==null||trim(xiaoqu)==""){
		alert("ԤԼС������Ϊ�գ�");
		document.forms[0].xiaoqu.focus();//���ý���
		return false;
		}

	var shijian = document.forms[0].shijian.value;
	if(shijian==null||trim(shijian)==""){
		alert("ԤԼʱ�䲻��Ϊ�գ�");
		document.forms[0].shijian.focus();//���ý���
		return false;
		}

	var azjh = document.forms[0].azjh.value;
	if(azjh==null||trim(azjh)==""){
		alert("�ƻ���װ��������Ϊ�գ�");
		document.forms[0].azjh.focus();//���ý���
		return false;
		}else if(!isDigit(azjh)){
		alert("�ƻ���װ�������������֣�");
		document.forms[0].azjh.focus();//���ý���
		return false;
		}
	 var azsy = document.getElementById("azsy").value;
	// alert("azsy:"+azsy);
	 if(parseInt(azjh)<parseInt(azsy)){
		 alert("�Ѱ�װ"+azsy+"�ƻ���װ��������С���Ѱ�װ����");
		 document.forms[0].azjh.focus();//���ý���
			return false;
		 }
	var qjjh = document.forms[0].qjjh.value;
	if(qjjh!=null&&trim(qjjh)!=""){
		if(!isDigit(qjjh)){
			alert("�ƻ�ȡ���������������֣�");
			document.forms[0].qjjh.focus();//���ý���
			return false;
			}
		}else{
			document.forms[0].qjjh.value=9999;
			}
	var qjsy = document.getElementById("qjsy").value;
//	alert("qjsy:"+qjsy);
	if(parseInt(qjjh)<parseInt(qjsy)){
		 alert("�ƻ�ȡ����������С����ȡ������");
		 document.forms[0].qjjh.focus();//���ý���
			return false;
		}
	return true;
}
isDigit = function (str) {
	var patrn=/^\d+$/;
	return patrn.test(str);
	}
</script>
</html>