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
<link href="css/common.css" type="text/css" rel="stylesheet" />
<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
<script src="js/validate.js" language="javascript"></script>
<script src="js/common.js" language="javascript"></script>
<script src="js/jquery.js" language="javascript"></script>
<script src="js/popupBox.js" language="javascript"></script>
<script src="kucun/kucun.js" language="javascript"></script>
<script src="js/business.js" language="javascript"></script>
<script src="js/Calendar3.js" language="javascript"></script>
<jsp:include page="/common/commonMessage.jsp" />
</head>
<body onload="init()">
	<html:form action="shebeirukuList.do">
	<bean:define id="xiaoquList" name="zongkufangInfoForm" property="xiaoquList"></bean:define>
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">修改条目</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr>
							<td valign="top" class="editTableTitle" width="80px">操作类型：</td>
							<td class="editTableContent">
							<html:select name="zongkufangInfoForm" property="operateType"
									styleClass="commonTextFieldHover"  
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value=""  >-请选择-</html:option>
									<html:option value="入库">入库</html:option>
									<html:option value="出库">出库</html:option>
								</html:select>
							</td>
						</tr>
						<tr>
							<td valign="top" class="editTableTitle" width="80px">出入库时间：</td>
							<td class="editTableContent">
							<html:text name="zongkufangInfoForm" property="operateTime" styleId="operateTime" size="10" onclick="new Calendar().show(this)" /><a:need />
							</td>
						</tr>
						<tr>
							<td valign="top" class="editTableTitle" width="80px">数量：</td>
							<td class="editTableContent">
							<html:text name="zongkufangInfoForm" property="operateSuu" size="20" maxlength="30"/><a:need /><br/></br>
							</td>
						</tr>
						<tr>
							<td valign="top" class="editTableTitle" width="80px">出入库库房：</td>
							<td class="editTableContent">
							<html:select style="width:80px" name="zongkufangInfoForm" property="operateStore"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove';"
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select>
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
	<html:hidden name="zongkufangInfoForm" property="UUID" />
	</html:form>
	
</body>
<script language="javascript" type="text/javascript">
	function sub_update() {
		if(checkInput()){
			commonSubmit('zongkufangInfoEdit.do?act=insert_zongkufanglog');
		}
	}
	checkInput = function() {
			var operateType = document.forms[0].operateType.value;
			if (operateType == null || trim(operateType) == "") {
				alert("请选择操作类型！");
				document.forms[0].operateType.focus();//设置焦点
				return false;
			}
			
			var operateTime = document.forms[0].operateTime.value;
			if (operateTime == null || trim(operateTime) == "") {
				alert("请选择出入库时间！");
				document.forms[0].operateTime.focus();//设置焦点
				return false;
			}
			
			var operateSuu = document.forms[0].operateSuu.value;
			if (operateSuu == null || trim(operateSuu) == "") {
				alert("请选择出入库数量！");
				document.forms[0].operateSuu.focus();//设置焦点
				return false;
			}
			
			var remark = document.forms[0].remark.value;
			if (remark == null || trim(remark) == "") {
				alert("请输入备注信息！");
				document.forms[0].remark.focus();//设置焦点
				return false;
			}
			return true;
		}
</script>
</html>