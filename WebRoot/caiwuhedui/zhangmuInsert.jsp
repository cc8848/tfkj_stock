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
	<body onload="init()" id="body1">  
		<html:form action="shenqingDataEdit.do">
			<bean:define id="xiaoquList" name="zhangmuForm" property="xiaoquList"></bean:define>
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">
				������Ŀ
			</div>
			<!--  �����༭ start -->
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="960px">
					<tr >
						<td class="editTableTitleLast" >��Ŀ��Ϣ��</td>
						<td class="editTableContentLast">
						����ˣ�
							<html:text name="zhangmuForm" property="cunkuanren" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
						
						
						���ʱ�䣺
							 <html:text name="zhangmuForm" property="cunkuanshijian" styleId="kaijishijians" size="15" onclick="WdatePicker({el:'kaijishijians'})" />
							 <img onclick="WdatePicker({el:'kaijishijians'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>  
							 <a:need /><br/>
							 
						 ������У�
					 	
						 	<html:select name="zhangmuForm" property="cunkuanyinhang"  
										styleClass="commonTextFieldHover"  
										onfocus="this.className='commonTextFieldMove'" 
										onblur="this.className='commonTextFieldHover'">
							<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							<a:need /><br/>
							
						 ����ţ�
							<html:text name="zhangmuForm" property="wangdianhao" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
							
						 ����
							<html:text name="zhangmuForm" property="cunkuanjine" maxlength="50" 
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
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('moneymateList.do?act=init&zhuangtai=0')"/> 
			</div>
		</div>
		<html:hidden name="jiaofeiDataFrom" property="nowdataHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	function sub(){
		if(checkInput()){
			commonSubmit('zhangmuDataInsert.do?act=insertZhangmu');
			}
	}
	checkInput = function(){
		var dizhi = document.forms[0].cunkuanren.value;
		if(dizhi==null||trim(dizhi)==""){
			alert("����˱�����д��");
			document.forms[0].dizhi.focus();//���ý���
			return false;
			}
	
		var kaijishijian = document.forms[0].cunkuanshijian.value;
		if(kaijishijian==null||trim(kaijishijian)==""){
			alert("���ʱ��ʱ�������д��");
			document.forms[0].kaijishijian.focus();//���ý���
			return false;
			}
	
		var tingjishijian = document.forms[0].cunkuanyinhang.value;
		if(tingjishijian==null||trim(tingjishijian)==""){
			alert("������б�����д��");
			document.forms[0].tingjishijian.focus();//���ý���
			return false;
			}
			
		var shoujuhao = document.forms[0].wangdianhao.value;
		if(shoujuhao==null||trim(shoujuhao)==""){
			alert("����ű�����д��");
			document.forms[0].shoujuhao.focus();//���ý���
			return false;
			}
			
		var shigongren = document.forms[0].cunkuanjine.value;
		if(shigongren==null||trim(shigongren)==""){
			alert("����������д��");
			document.forms[0].shigongren.focus();//���ý���
			return false;
			}
		if(isNaN(shigongren)){
			alert("��������������֣�");
			document.forms[0].cunkuanjine.focus();//���ý���
			return false;
			}
		return true;
	};
	
	</script>
		
</html>