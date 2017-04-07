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
		<html:form action="incometotalList.do?act=query" method="post" >
		<bean:define id="xiaoquList" name="totalForm" property="xiaoquList"></bean:define>
		<bean:define id="stateList" name="totalForm" property="stateList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					ͳ������
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">
			
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								С�����ƣ�
							</td>
							<td>
								<html:select name="totalForm" property="xiaoqu" styleId="xiaoqu"
									styleClass="commonTextFieldHover"  onkeydown="autoSubimit()"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">--��ѡ��--</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								״̬
							</td>
							<td>
								<html:select name="totalForm" property="stateCode" styleId="stateCode"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:options collection="stateList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								��ʼʱ��
							</td>
							<td>
							    <html:text name="totalForm" property="kaijis" styleId="kaijis" size="10" onclick="WdatePicker({el:'kaijis'})" />
								<img onclick="WdatePicker({el:'kaijis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							</td>
							
						   <td>
								����ʱ��
							</td>
							<td>
							    <html:text name="totalForm" property="tingjis" styleId="tingjis" size="10" onclick="WdatePicker({el:'tingjis'})" />
								<img onclick="WdatePicker({el:'tingjis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							</td> 
							
							<td align="right">
								<input type="button" value="ͳ��" class="commonButton" onclick="sub();" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				
				<!-- ��ѯ��� start -->
				<div  class="conten_result">
					<!-- ��ҳͷ -->
					<div  class="page_up">
					</div>
					
					<div  class="result_table">
					<bean:define id="size" name="totalForm" property="wideSize"></bean:define>
					<bean:define id="pathA" name="totalForm" property="pathA"></bean:define>
					<bean:define id="pathB" name="totalForm" property="pathB"></bean:define>
						<img width="<bean:write name="size"/>" height="190" src="<bean:write name="pathA"/>" alt="total"  /> 
						<hr width="<bean:write name="size"/>"/>
						<img width="<bean:write name="size"/>" height="190" src="<bean:write name="pathB"/>" alt="total"  /> 
					<!-- ���һ�� start-->
						<table border="0" cellspacing="0" cellpadding="1"  width="100%">
						</table>
					</div>
					
					<!-- ���һ�� end-->
					<div name="page_down" class="page_down">
						<div align="right">
						</div>
					</div>
				</div>
			<html:hidden name="totalForm" property="xiaoquHidden" />
			<html:hidden name="totalForm" property="kaijisHidden" />
			<html:hidden name="totalForm" property="tingjisHidden" />
			<html:hidden name="totalForm" property="stateCodeHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	
		function sub(){
			if(checkInput())
				{
					commonSubmit('incometotalList.do?act=query');
				}
			}
			
		checkInput = function()
		{
			var kaijis = document.forms[0].kaijis.value;
			if(kaijis==null||trim(kaijis)=="")
				{
					alert("��ʼʱ�䲻��Ϊ�գ�");
					document.forms[0].kaijis.focus();//���ý���
					return false;
				}
		
			var tingjis = document.forms[0].tingjis.value;
			if(tingjis==null||trim(tingjis)=="")
				{
					alert("����ʱ�䲻��Ϊ�գ�");
					document.forms[0].tingjis.focus();//���ý���
					return false;
				}
			
			if(tingjis<kaijis)
			{
				alert("����ʱ������ڿ�ʼʱ�䣡");
				return false;
			}
				return true;
		 } ;
		 
		  function autoSubimit(){
				if (event.keyCode == 13) {
					sub();
				}
			}
	</script>
</html>
