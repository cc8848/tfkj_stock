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
	<body onload="init()">  
		<html:form action="yuyueEdit.do">
		<bean:define id="xiaoquList" name="yuyueEidtForm" property="xiaoquList"></bean:define>
		<bean:define id="quyuList" name="yuyueEidtForm" property="quyuList"></bean:define>
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">
				添加预约计划
			</div>
			<!--  新增编辑 start -->
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="960px">
				<tr height="35px">
						<td class="editTableTitle" >预约日期：</td>
						<td class="editTableContent" >
							<html:text name="yuyueEidtForm" property="riqi" styleId="riqi"
								styleClass="commonTextFieldHover" onclick="WdatePicker({el:'riqi'})" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" maxlength="20"/>
								<img onclick="WdatePicker({el:'riqi'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 		
							<a:need /> 
							
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >小区名称：</td>
						<td class="editTableContent" >
						<html:select name="yuyueEidtForm" property="xiaoqu" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:options collection="quyuList" property="key" labelProperty="value" />
							</html:select>  
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >时间：</td>
						<td class="editTableContent" >
						<html:select name="yuyueEidtForm" property="shijian" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="上午">上午</html:option>
								<html:option value="下午">下午</html:option>
							</html:select>  
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >计划安装户数：</td>
						<td class="editTableContent" >
							<html:text name="yuyueEidtForm" property="azjh" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitleLast" >计划取件户数：</td>
						<td class="editTableContentLast" >
							<html:text name="yuyueEidtForm" property="qjjh" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />（户数不限，可不填写）
						</td>
					</tr>
					<!-- <tr height="35px">
						<td class="editTableTitleLast" >预警处理办法：</td>
						<td class="editTableContentLast" >
							<html:text name="yuyueEidtForm" property="yujing" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr> -->
				</table>
				</div>
			</div>
			<!--  新增编辑 end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="保存" styleClass="commonButton" onclick="sub();"/>
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('yuyueList.do?act=init')"/>
			</div>
		</div>
		</html:form>
	</body>
	<script type="text/javascript">
function sub(){
	if(checkInput()){
		commonSubmit('yuyueEdit.do?act=insert')
		}
}
checkInput = function(){
	var riqi = document.forms[0].riqi.value;
	if(riqi==null||trim(riqi)==""){
		alert("预约日期不能为空！");
		document.forms[0].riqi.focus();//设置焦点
		return false;
		}

	var xiaoqu = document.forms[0].xiaoqu.value;
	if(xiaoqu==null||trim(xiaoqu)==""){
		alert("预约小区不能为空！");
		document.forms[0].xiaoqu.focus();//设置焦点
		return false;
		}

	var shijian = document.forms[0].shijian.value;
	if(shijian==null||trim(shijian)==""){
		alert("预约时间不能为空！");
		document.forms[0].shijian.focus();//设置焦点
		return false;
		}
	var azjh = document.forms[0].azjh.value;
	if(!isDigit(azjh)){
		alert("计划安装户数请输入数字！");
		document.forms[0].azjh.focus();//设置焦点
		return false;
		}
	var qjjh = document.forms[0].qjjh.value;
	if(qjjh!=null&&trim(qjjh)!=""){
		if(!isDigit(qjjh)){
			alert("计划取件户数请输入数字！");
			document.forms[0].qjjh.focus();//设置焦点
			return false;
			}
		}else{
			document.forms[0].qjjh.value=9999;
			}
	return true;
}
	
</script>
</html>