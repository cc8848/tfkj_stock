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
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()" id="body1">  
		<html:form action="shenqingDataEdit.do">
		<bean:define id="quyuList" name="xiaoquForm" property="quyuList"></bean:define>
		<bean:define id="kufangList" name="xiaoquForm" property="kufangList"></bean:define>
		<div id="content_all">
			
			<div class="conten_top" name="top">����С��</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="960px">
					<tr >
						<td valign="top" class="editTableTitleLast" width="80px">С����Ϣ��</td>
						<td class="editTableContentLast">
						С�����ƣ�&nbsp;&nbsp;
							<html:text name="xiaoquForm" property="name" maxlength="40" size="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
						С����ַ��
							<html:text name="xiaoquForm" property="address" maxlength="40" size="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>		
						С��ǰ׺(����)��
							<html:text name="xiaoquForm" property="netcode" maxlength="15" size="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
							
						С��ǰ׺(����)��
							<html:text name="xiaoquForm" property="tvcode" maxlength="15" size="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<br/>
						��������վ��
							<html:select name="xiaoquForm" property="quyu" 
								styleClass="commonTextFieldHover" styleId="tfkuandaidaikuan"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--��ѡ��--</html:option>
								<html:options collection="quyuList" property="key" labelProperty="value" />
								
							</html:select>	
							<a:need />
							<br/>
						�����ⷿ��
							<html:select name="xiaoquForm" property="kufang" 
								styleClass="commonTextFieldHover" styleId="tfkuandaidaikuan"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--��ѡ��--</html:option>
								<html:options collection="kufangList" property="key" labelProperty="value" />
								
							</html:select>	
							<a:need />
							<br/>
						���ǻ�����
							<html:text name="xiaoquForm" property="costumeCount" maxlength="40" size="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
						����λ�ã�
						<html:text name="xiaoquForm" property="seq"  maxlength="4" size="10"
							styleClass="commonTextFieldHover" 
							onfocus="this.className='commonTextFieldMove'" 
							onblur="this.className='commonTextFieldHover'"/>
						<br/>
						��ע��
						<html:text name="xiaoquForm" property="remark"  maxlength="500" size="40"
							styleClass="commonTextFieldHover" 
							onfocus="this.className='commonTextFieldMove'" 
							onblur="this.className='commonTextFieldHover'"/>
						<br/>
						<br/>
						</td>
					</tr>								
				</table>
				</div>
			</div>
			<!--  �����༭ end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="sub();"/>
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('xiaoquList.do?act=init')"/> 
			</div>
		</div>
		<html:hidden name="jiaofeiDataFrom" property="nowdataHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	function sub(){
		if(checkInput()){
			var quyu = document.forms[0].quyu;
			var str = quyu.options[quyu.selectedIndex].innerHTML;
			commonSubmit('xiaoquList.do?act=insert&quyuName='+str);
		}
	}
	checkInput = function(){
	
		var name = document.forms[0].name.value;
		if(name == null || trim(name)=="") {
			alert("С����������д��");
			document.forms[0].name.focus();//���ý���
			return false;
		}
		
		var netcode = document.forms[0].netcode.value;
		if(netcode == null || trim(netcode)=="") {
			alert("С��ǰ׺(����)������д��");
			document.forms[0].netcode.focus();//���ý���
			return false;
		}
		
		var seq = document.forms[0].seq.value;
		if(seq == null || trim(seq)=="") {
			alert("����λ�ñ�����д��");
			document.forms[0].seq.focus();//���ý���
			return false;
		}
		
		if(seq!="") {
			if(isNaN(seq)) {
				alert("λ�����������֣�");
				document.forms[0].seq.focus();//���ý���
				return false;
			}
		}
		var cc = document.forms[0].costumeCount.value;
		if(cc == null || trim(cc)=="") {
			alert("���ǻ���������д��");
			document.forms[0].cc.focus();//���ý���
			return false;
		}
		
		if(cc!="") {
			if(isNaN(cc)) {
				alert("���ǻ������������֣�");
				document.forms[0].cc.focus();//���ý���
				return false;
			}
		}
		var address = document.forms[0].address.value;
		if(address == null || trim(address) == "") {
			alert("С����ַ����ѡ��");
			document.forms[0].address.focus();//���ý���
			return false;
		}
		
		var quyu = document.forms[0].quyu.value;
		if(quyu == null || trim(quyu) == "") {
			alert("�������ѡ��");
			document.forms[0].quyu.focus();//���ý���
			return false;
		}
		return true;
	};
	
	
	</script>
		
</html>