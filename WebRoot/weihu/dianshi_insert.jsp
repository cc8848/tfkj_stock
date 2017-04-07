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
		<div id="content_all">
			
			<div class="conten_top" name="top">����ʱ������</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="960px">
					<tr >
						<td valign="top" class="editTableTitleLast" width="80px">ʱ����Ϣ��</td>
						<td class="editTableContentLast">
						ʱ�����ƣ�
							<html:text name="dianshiEidtForm" property="shichangName" maxlength="160" size="80"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
							
						����λ�ã�
							<html:text name="dianshiEidtForm" property="seq" maxlength="4" size="10"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
							
						ʱ�����
							<html:text name="dianshiEidtForm" property="shichangLeibie" maxlength="80" size="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
						ҵ�����
							<html:text name="dianshiEidtForm" property="yewuLeibie" maxlength="80" size="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							
							<a:need />
							<br/>
							ʱ��(��)��
							<html:text name="dianshiEidtForm" property="shichangyue" maxlength="3" size="3"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
							
							��
							<html:text name="dianshiEidtForm" property="jine" maxlength="12" size="10"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
							
						</td>
					</tr>								
				</table>
				</div>
			</div>
			<!--  �����༭ end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="sub();"/>
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('dianshiList.do?act=init')"/> 
			</div>
		</div>
		</html:form>
	</body>
	<script type="text/javascript">
	function sub(){
		if(checkInput()){
			commonSubmit('dianshiList.do?act=insertDianshi');
		}
	}
	checkInput = function(){
	
		var shichangName = document.forms[0].shichangName.value;
		if(shichangName==null||trim(shichangName)=="") {
			alert("ʱ�����Ʊ�����д��");
			document.forms[0].shichangName.focus();//���ý���
			return false;
		}
		
		var seq = document.forms[0].seq.value;
		if(seq==null||trim(seq)=="") {
			alert("ʱ��λ�ñ�����д��");
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
		
		var shichangLeibie = document.forms[0].shichangLeibie.value;
		if(shichangLeibie == null || trim(shichangLeibie) == "") {
			alert("ʱ��������ѡ��");
			document.forms[0].shichangLeibie.focus();//���ý���
			return false;
		}
		
		var yewuLeibie = document.forms[0].yewuLeibie.value;
		if(yewuLeibie == null || trim(yewuLeibie)=="") {
			alert("ҵ��������ѡ��");
			document.forms[0].daikuan.focus();//���ý���
			return false;
		}
		var shichangyue = document.forms[0].shichangyue.value;
		if(shichangyue == null || trim(shichangyue)=="") {
			alert("ʱ��(��)������д��");
			document.forms[0].shichangyue.focus();//���ý���
			return false;
		}
		var   type="^[0-9]*[1-9][0-9]*$"; 
        var   re   =   new   RegExp(type); 
        if(shichangyue.match(re)==null) {
       	    alert("ʱ��(��)��ʽ����ȷ��");
			document.forms[0].shichangyue.focus();//���ý���
			return false;
        }
		/* if(!b.test(shichangyue)) {
			alert("ʱ��(��)��ʽ����ȷ��");
			document.forms[0].shichangyue.focus();//���ý���
			return false;
		} */
		
		var a=/^[0-9]*(\.[0-9]{1,2})?$/;
		var jine = document.forms[0].jine.value;
		if(jine == null || trim(jine)=="") {
			alert("��������д��");
			document.forms[0].jine.focus();//���ý���
			return false;
		}
		if(!a.test(jine)) {
			alert("����ʽ����ȷ��");
			document.forms[0].jine.focus();//���ý���
			return false;
		}
		return true;
	};
	
	
	</script>
		
</html>