<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2015-12-15   Dai-Zhen           Create
   
  -->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<title>快速开发框架演示项目</title>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<link href="css/common.css" type="text/css" rel="stylesheet" />
<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
<script src="js/validate.js" language="javascript"></script>
<script src="js/common.js" language="javascript"></script>
<script src="js/jquery.js" language="javascript"></script>
<script src="js/popupBox.js" language="javascript"></script>
<script src="kucun/kucun.js" language="javascript"></script>
<script src="js/business.js" language="javascript"></script>
<jsp:include page="/common/commonMessage.jsp" />
</head>
<body onload="init()">
	<html:form action="shebeirukuList.do">
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">增加总库房信息</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr>
							<td valign="top" class="editTableTitle" width="80px">序号：</td>
							<td class="editTableContent">
							<html:text name="zongkufangInfoForm" property="zongkufang_ID" size="20" maxlength="30"/><a:need /><br/></br>
							</td>
						</tr>
						<tr>
							<td valign="top" class="editTableTitle" width="80px">设备类型：</td>
							<td class="editTableContent">
							<html:text name="zongkufangInfoForm" property="eqType" size="20" maxlength="30"/><a:need /><br/></br>
							</td>
						</tr>
						<tr>
							<td valign="top" class="editTableTitle" width="80px">设备型号：</td>
							<td class="editTableContent">
							<html:text name="zongkufangInfoForm" property="eqVersion" size="20" maxlength="30"/><a:need /><br/></br>
							</td>
						</tr>
						<tr>
							<td valign="top" class="editTableTitle" width="80px">库存数量：</td>
							<td class="editTableContent">
							<html:text name="zongkufangInfoForm" property="kucunSuu" size="20" maxlength="12"/><a:need /><br/></br>
							</td>
						</tr>
						<tr>
							<td valign="top" class="editTableTitle" width="80px">备注信息：</td>
							<td class="editTableContent">
							<html:textarea name="zongkufangInfoForm" property="remark" rows="5" cols="70"
											   onkeyup="if(this.value.length>200)this.value=this.value.substr(0,200)"> </html:textarea><a:need />
							</td>
						</tr>
					</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="保存" styleClass="commonButton" onclick="sub_update();" />
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('zongkufangInfoList.do?act=init')" />
			</div>
		</div>
	<html:hidden name="kucunForm" property="UUIDHidden" />
	</html:form>
	
</body>
<script language="javascript" type="text/javascript">
	function sub_update() {
		if(checkInput()){
			commonSubmit('zongkufangInfoEdit.do?act=insert_zongkufang');
		}
	}
	checkInput = function() {
			var xuhao = document.forms[0].zongkufang_ID.value;
			if (xuhao == null || trim(xuhao) == "") {
				alert("序号填写错误！");
				document.forms[0].zongkufang_ID.focus();//设置焦点
				return false;
			}
			
			var eqType = document.forms[0].eqType.value;
			if (eqType == null || trim(eqType) == "") {
				alert("设备类型填写错误！");
				document.forms[0].eqType.focus();//设置焦点
				return false;
			}
			
			var eqVersion = document.forms[0].eqVersion.value;
			if (eqVersion == null || trim(eqVersion) == "") {
				alert("设备型号填写错误！");
				document.forms[0].eqVersion.focus();//设置焦点
				return false;
			}
			
			var kucunSuu = document.forms[0].kucunSuu.value;
			if (kucunSuu == null || trim(kucunSuu) == "") {
				alert("库存数量填写错误！");
				document.forms[0].kucunSuu.focus();//设置焦点
				return false;
			}
			
			var remark = document.forms[0].remark.value;
			if (remark == null || trim(remark) == "") {
				alert("备注信息填写错误！");
				document.forms[0].remark.focus();//设置焦点
				return false;
			}
			return true;
		}
</script>
</html>