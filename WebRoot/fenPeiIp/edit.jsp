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
			<!-- 标题 -->
			<div class="conten_top" name="top">
				IP分配
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="940px">
					<tr height="35px">
						<td class="editTableTitle" >小区名称：</td>
						<td class="editTableContent" >
						<bean:write name="fenPeiIpForm" property="xiaoquname"/>	&nbsp;	
						<html:hidden name="fenPeiIpForm" property="xiaoquname"/>
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >用户地址：</td>
						<td class="editTableContent" >
						<bean:write name="fenPeiIpForm" property="userplace"/>&nbsp;
						</td>
					</tr>
					
					<tr height="35px">
						<td class="editTableTitle" >宽带：</td>
						<td class="editTableContent" >
						<bean:write name="fenPeiIpForm" property="kuadnai"/>&nbsp;	
						</td>
					</tr>
					
					<tr height="35px">
						<td class="editTableTitle" >电视：</td>
						<td class="editTableContent" >
						<bean:write name="fenPeiIpForm" property="tv"/>&nbsp;	
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >电话：</td>
						<td class="editTableContent" >
						<bean:write name="fenPeiIpForm" property="tel"/>&nbsp;	
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >分光：</td>
						<td class="editTableContent" >
							<html:text name="fenPeiIpForm" property="fenguang"  maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >电视Ip：</td>
						<td class="editTableContent" >
							<html:text name="fenPeiIpForm" property="tvip" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >网络Ip：</td>
						<td class="editTableContent" >
							<html:text name="fenPeiIpForm" property="netIp" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >电话Ip：</td>
						<td class="editTableContent" >
							<html:text name="fenPeiIpForm" property="telIp" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >电话VALN：</td>
						<td class="editTableContent" >
							<html:text name="fenPeiIpForm" property="telValn" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >网络VALN：</td>
						<td class="editTableContent" >
							<html:text name="fenPeiIpForm" property="netValn" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
				<!-- 	<tr height="35px">
						<td class="editTableTitle" >业务：</td>
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
				<html:button property="btnSave" value="保存" styleClass="commonButton" onclick="commit()"/>
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('rationList.do?act=init')"/>
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
			alert("分光号不能为空！");
			document.forms[0].fenguang.focus();//设置焦点
			return false;
			}
		var  tvip= document.forms[0].tvip.value;
		if(tvip==null||trim(tvip)==""){
			alert("TVIP不能为空没有请填0！");
			document.forms[0].tvip.focus();//设置焦点
			return false;
			}
		var  netIp= document.forms[0].netIp.value;
		if(netIp==null||trim(netIp)==""){
			alert("网络IP不能为空没有请填0！");
			document.forms[0].netIp.focus();//设置焦点
			return false;
			}
		var  telIp= document.forms[0].telIp.value;
		if(telIp==null||trim(telIp)==""){
			alert("电话IP不能为空没有请填0！");
			document.forms[0].telIp.focus();//设置焦点
			return false;
			}
		var  telValn= document.forms[0].telValn.value;
		if(telValn==null||trim(telValn)==""){
			alert("电话valn不能为空没有请填0！");
			document.forms[0].telValn.focus();//设置焦点
			return false;
			}
		var  netValn= document.forms[0].netValn.value;
		if(netValn==null||trim(netValn)==""){
			alert("网络valn不能为空没有请填0！");
			document.forms[0].netValn.focus();//设置焦点
			return false;
			}
		return true;
		}
	
	</script>
</html>