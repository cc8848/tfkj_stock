<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>快速开发框架演示项目</title>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="caiwuhedui/caiwu.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="accountsmateList.do">
		<bean:define id="quyuList" name="xiaoquForm" property="quyuList"></bean:define>
		<bean:define id="kufangList" name="xiaoquForm" property="kufangList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
			<div class="conten_top" name="top">小区编辑</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
					<tr >
						<td valign="top" class="editTableTitleLast" width="80px">小区信息：</td>
						<td class="editTableContentLast">
						小区名称：
							<html:text name="xiaoquForm" property="name" maxlength="40" size="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
						小区地址：
							<html:text name="xiaoquForm" property="address" maxlength="40" size="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>	
						小区前缀(网络)：
							<html:text name="xiaoquForm" property="netcode" maxlength="15" size="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
							
						小区前缀(电视)：
							<html:text name="xiaoquForm" property="tvcode" maxlength="15" size="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<br/>
						所属服务站：
							<html:select name="xiaoquForm" property="quyu" 
								styleClass="commonTextFieldHover" styleId="tfkuandaidaikuan"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:options collection="quyuList" property="key" labelProperty="value" />
							</html:select>	
							<a:need />
							<br/>
							所属库房：
							<html:select name="xiaoquForm" property="kufang" 
								styleClass="commonTextFieldHover" styleId="tfkuandaidaikuan"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:options collection="kufangList" property="key" labelProperty="value" />
								
							</html:select>	
							<a:need />
							<br/>
						覆盖户数：
							<html:text name="xiaoquForm" property="costumeCount" maxlength="40" size="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
						排序位置：
						<html:text name="xiaoquForm" property="seq"  maxlength="4" size="10"
							styleClass="commonTextFieldHover" 
							onfocus="this.className='commonTextFieldMove'" 
							onblur="this.className='commonTextFieldHover'"/>
						<br/>
						备注：
						<html:text name="xiaoquForm" property="remark"  maxlength="500" size="40"
							styleClass="commonTextFieldHover" 
							onfocus="this.className='commonTextFieldMove'" 
							onblur="this.className='commonTextFieldHover'"/>
						<br/>
						</td>
					</tr>		
					</table>
				</div>
			</div>
				<!-- 查询结果 end -->
				<!-- button -->
				<span style="color: red;">(编辑小区名会导致设备存放的小区名变更,请谨慎编辑！)</span><br/>
				<span style="color: red;">(编辑小区前缀(网络)会导致处理续费不能审核通过,请填写正确的小区前缀名称！)</span>
				<div id="buttonC" name="button" class="content_button" >
					 <html:button property="btnSave" value="保存" styleClass="commonButton" onclick="sub();"/> 
					 
				 	 <html:button property="btnSave" value="返回" styleClass="commonButton" onclick="commonSubmit('xiaoquList.do?act=init')"/>
			    </div>
			</div>

		<html:hidden name="xiaoquForm" property="uuidHidden" />
		<html:hidden name="xiaoquForm" property="nameHidden" />
		</html:form>
	</div>
	</body>
	<script type="text/javascript"  language="javascript">
		function sub(){
		if(checkInput()){
			var quyu = document.forms[0].quyu;
			var str = quyu.options[quyu.selectedIndex].innerHTML;
			commonSubmit('xiaoquList.do?act=update&quyuName='+str);
		}
	}
		checkInput = function(){
	
		var name = document.forms[0].name.value;
		if(name == null || trim(name)=="") {
			alert("小区名必须填写！");
			document.forms[0].name.focus();//设置焦点
			return false;
		}
		
		var netcode = document.forms[0].netcode.value;
		if(netcode == null || trim(netcode)=="") {
			alert("小区前缀(网络)必须填写！");
			document.forms[0].netcode.focus();//设置焦点
			return false;
		}
		
		var seq = document.forms[0].seq.value;
		if(seq == null || trim(seq)=="") {
			alert("排序位置必须填写！");
			document.forms[0].seq.focus();//设置焦点
			return false;
		}
		
		if(seq!="") {
			if(isNaN(seq)) {
				alert("位置请输入数字！");
				document.forms[0].seq.focus();//设置焦点
				return false;
			}
		}
		var cc = document.forms[0].costumeCount.value;
		if(cc == null || trim(cc)=="") {
			alert("覆盖户数必须填写！");
			document.forms[0].cc.focus();//设置焦点
			return false;
		}
		
		if(cc!="") {
			if(isNaN(cc)) {
				alert("覆盖户数请输入数字！");
				document.forms[0].cc.focus();//设置焦点
				return false;
			}
		}
		var address = document.forms[0].address.value;
		if(address == null || trim(address) == "") {
			alert("小区地址必须选择！");
			document.forms[0].address.focus();//设置焦点
			return false;
		}
		var quyu = document.forms[0].quyu.value;
		if(quyu == null || trim(quyu) == "") {
			alert("区域必须选择！");
			document.forms[0].quyu.focus();//设置焦点
			return false;
		}
		return true;
	};
		
	</script>
</html>
