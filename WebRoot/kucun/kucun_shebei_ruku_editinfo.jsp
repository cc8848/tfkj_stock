<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2012-11-23     Zhu,Xiao-Lei     Create
   
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
	<bean:define id="userNameList" name="kucunForm" property="userNameList"></bean:define>
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">设备编辑</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td valign="top" class="editTableTitle" width="80px">设备信息：</td>
							<td class="editTableContent">
								<table>
									<tr>
										<td>
											设备状态：
											<html:text name="kucunForm" property="shebeizhuangtai" size="20" readonly="true" /><br/></br>
											&nbsp;&nbsp;&nbsp;&nbsp;箱号： 
											<html:text name="kucunForm" property="xianghao" size="20" maxlength="30"/>
											</br></br>
											入库日期：
												<html:text name="kucunForm" property="rukuriqi" styleId="kaijis" size="20" onclick="WdatePicker({el:'kaijis'})" />
								<img onclick="WdatePicker({el:'kaijis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							    
												</img><br/></br>
											&nbsp;&nbsp;入库人：
												<html:select style="width:120px" name="kucunForm" property="rukuren" 
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:options collection="userNameList" property="key" labelProperty="value" />
								    </html:select><br/></br>
											设备类型： 
												<html:text name="kucunForm" property="shebeileixing" size="20" maxlength="30"/><br/></br>
											设备型号： 
												<html:text name="kucunForm" property="shebeixinghao" size="20" maxlength="30"/></br></br>
											注册位置： 
												<html:text name="kucunForm" property="zhuceweizhi" size="20" maxlength="30"/></br></br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MAC：
											    <html:text name="kucunForm" property="mac" size="20" maxlength="30"/></br></br>
				     &nbsp;&nbsp;&nbsp;&nbsp;MCID： 
											    <html:text name="kucunForm" property="mcid" size="20" maxlength="30"/><br/></br>
					           &nbsp;&nbsp; 数据IP：
												<html:text name="kucunForm" property="shujuip" size="20" maxlength="30"/></br></br>
										</td>
									</tr>
									<tr>
									    <td>&nbsp;&nbsp;&nbsp;&nbsp;备注： 
											  <html:textarea name="kucunForm" property="beizhu" rows="5" cols="70" 
											  onkeyup="if(this.value.length>500)this.value=this.value.substr(0,500)">
									          </html:textarea>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="保存" styleClass="commonButton" onclick="sub_updateProduct();" />
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('shebeirukuList.do?act=init')" />
			</div>
		</div>
	<html:hidden name="kucunForm" property="UUIDHidden" />
	<html:hidden name="kucunForm" property="zhuangtaiHidden" />
	</html:form>
	
</body>
<script language="javascript" type="text/javascript">
	function sub_updateProduct() {
		if(checkInput()){
			commonSubmit('shebeiEdite.do?act=update_Product');
		}
	}
	checkInput = function(){
		var rukuriqi = document.forms[0].rukuriqi.value;
		if(rukuriqi==null||trim(rukuriqi)=="") {
			alert("请输入正确入库日期格式！");
			document.forms[0].rukuriqi.focus();//设置焦点
			return false;
		}
		var rukuren = document.forms[0].rukuren.value;
		if(rukuren==null||trim(rukuren)=="") {
			alert("请填写入库人！");
			document.forms[0].rukuren.focus();//设置焦点
			return false;
		}
		rukuriqi = /^\d{4}[-](\d{2})[-](\d{2})$/.test(rukuriqi);
		if (rukuriqi == false ) {
				alert("入库日期输入格式有误！");
				return false;
		}
		return true;
	};
	function switchPage(){
		var zhuangtai = document.getElementById("zhuangtai").value;
		if (zhuangtai == 1){
			commonSubmit('shebeirukuList.do?act=init')
		}
		if (zhuangtai == 2){
			commonSubmit('shebeirukuList.do?act=init')
		}
		if (zhuangtai == 3){
			commonSubmit('shebeiyichangkuList.do?act=init')
		}
	}
</script>
</html>