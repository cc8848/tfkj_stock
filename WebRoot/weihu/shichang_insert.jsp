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
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()" id="body1">  
		<html:form action="shenqingDataEdit.do">
		<div id="content_all">
			
			<div class="conten_top" name="top">新增时长类型</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="960px">
					<tr >
						<td valign="top" class="editTableTitleLast" width="80px">时长信息：</td>
						<td class="editTableContentLast">
						时长名称：
							<html:text name="shichangEidtForm" property="shichang" maxlength="160" size="80"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
							
						排序位置：
							<html:text name="shichangEidtForm" property="seq" maxlength="4" size="10"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
							
						时长类型：
							<html:select name="shichangEidtForm" property="leixing" 
								styleClass="commonTextFieldHover" styleId="tfkuandaidaikuan"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:option value="个人">个人</html:option>
								<html:option value="政企">政企</html:option>
								<html:option value="其他">其他</html:option>
							</html:select>	
							<a:need /><br/>
						带宽：
							<html:select name="shichangEidtForm" property="daikuan" 
								styleClass="commonTextFieldHover" styleId="tfkuandaidaikuan"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:option value="1M">1M</html:option>
								<html:option value="2M">2M</html:option>
								<html:option value="3M">3M</html:option>
								<html:option value="4M">4M</html:option>
								<html:option value="6M">6M</html:option>
								<html:option value="10M">10M</html:option>
								<html:option value="12M">12M</html:option>
								<html:option value="20M">20M</html:option>
								<html:option value="50M">50M</html:option>
								<html:option value="100M">100M</html:option>
								
							</html:select>	
							<a:need />
							<br/>
							时长(月)：
							<html:text name="shichangEidtForm" property="shichangyue" maxlength="3" size="3"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need /><br/>
							
							金额：
							<html:text name="shichangEidtForm" property="jine" maxlength="12" size="10"
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
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('shichangList.do?act=init')"/> 
			</div>
		</div>
		<html:hidden name="jiaofeiDataFrom" property="nowdataHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	function sub(){
		if(checkInput()){
			commonSubmit('shichangList.do?act=insertShichang');
		}
	}
	checkInput = function(){
	
		var shichang = document.forms[0].shichang.value;
		if(shichang==null||trim(shichang)=="") {
			alert("时长类型必须填写！");
			document.forms[0].shichang.focus();//设置焦点
			return false;
		}
		
		var seq = document.forms[0].seq.value;
		if(seq==null||trim(seq)=="") {
			alert("时长位置必须填写！");
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
		
		var leixing = document.forms[0].leixing.value;
		if(leixing == null || trim(leixing) == "") {
			alert("类型必须选择！");
			document.forms[0].leixing.focus();//设置焦点
			return false;
		}
		
		var daikuan = document.forms[0].daikuan.value;
		if(daikuan == null || trim(daikuan)=="") {
			alert("带宽必须选择！");
			document.forms[0].daikuan.focus();//设置焦点
			return false;
		}
		var shichangyue = document.forms[0].shichangyue.value;
		if(shichangyue == null || trim(shichangyue)=="") {
			alert("时长(月)必须填写！");
			document.forms[0].shichangyue.focus();//设置焦点
			return false;
		}
		var   type="^[0-9]*[1-9][0-9]*$"; 
        var   re   =   new   RegExp(type); 
        if(shichangyue.match(re)==null) {
       	    alert("时长(月)格式不正确！");
			document.forms[0].shichangyue.focus();//设置焦点
			return false;
        }
		/* if(!b.test(shichangyue)) {
			alert("时长(月)格式不正确！");
			document.forms[0].shichangyue.focus();//设置焦点
			return false;
		} */
		
		var a=/^[0-9]*(\.[0-9]{1,2})?$/;
		var jine = document.forms[0].jine.value;
		if(jine == null || trim(jine)=="") {
			alert("金额必须填写！");
			document.forms[0].jine.focus();//设置焦点
			return false;
		}
		if(!a.test(jine)) {
			alert("金额格式不正确！");
			document.forms[0].jine.focus();//设置焦点
			return false;
		}
		return true;
	};
	
	
	</script>
		
</html>