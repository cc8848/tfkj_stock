<!---->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>快速开发框架演示项目</title>
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
			<!-- 标题 -->
			<div class="conten_top" name="top">
				新增账目
			</div>
			<!--  新增编辑 start -->
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="960px">
					<tr >
						<td class="editTableTitleLast" >账目信息：</td>
						<td class="editTableContentLast">
						存款人：
							<html:text name="zhangmuForm" property="cunkuanren" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
						
						
						存款时间：
							 <html:text name="zhangmuForm" property="cunkuanshijian" styleId="kaijishijians" size="15" onclick="WdatePicker({el:'kaijishijians'})" />
							 <img onclick="WdatePicker({el:'kaijishijians'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>  
							 <a:need /><br/>
							 
						 存款银行：
					 	
						 	<html:select name="zhangmuForm" property="cunkuanyinhang"  
										styleClass="commonTextFieldHover"  
										onfocus="this.className='commonTextFieldMove'" 
										onblur="this.className='commonTextFieldHover'">
							<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							<a:need /><br/>
							
						 网点号：
							<html:text name="zhangmuForm" property="wangdianhao" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
							
						 存款金额：
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
			<!--  新增编辑 end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="保存" styleClass="commonButton" onclick="sub();"/>
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('moneymateList.do?act=init&zhuangtai=0')"/> 
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
			alert("存款人必须填写！");
			document.forms[0].dizhi.focus();//设置焦点
			return false;
			}
	
		var kaijishijian = document.forms[0].cunkuanshijian.value;
		if(kaijishijian==null||trim(kaijishijian)==""){
			alert("存款时间时间必须填写！");
			document.forms[0].kaijishijian.focus();//设置焦点
			return false;
			}
	
		var tingjishijian = document.forms[0].cunkuanyinhang.value;
		if(tingjishijian==null||trim(tingjishijian)==""){
			alert("存款银行必须填写！");
			document.forms[0].tingjishijian.focus();//设置焦点
			return false;
			}
			
		var shoujuhao = document.forms[0].wangdianhao.value;
		if(shoujuhao==null||trim(shoujuhao)==""){
			alert("网点号必须填写！");
			document.forms[0].shoujuhao.focus();//设置焦点
			return false;
			}
			
		var shigongren = document.forms[0].cunkuanjine.value;
		if(shigongren==null||trim(shigongren)==""){
			alert("存款金额必须填写！");
			document.forms[0].shigongren.focus();//设置焦点
			return false;
			}
		if(isNaN(shigongren)){
			alert("存款金额请输入数字！");
			document.forms[0].cunkuanjine.focus();//设置焦点
			return false;
			}
		return true;
	};
	
	</script>
		
</html>