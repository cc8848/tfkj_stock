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
		<bean:define id="xiaoquList" name="kucunForm" property="xiaoquList"></bean:define>
		<bean:define id="userNameList" name="kucunForm" property="userNameList"></bean:define>
		<div id="content_all">
			<div class="conten_top" name="top">
				库存转移
			</div>
			
			<div class="conten_query" name="query">
			</div>
			
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="960px">
					<tr >
						<td class="editTableTitleLast" >库存转移：</td>
						<td class="editTableContentLast">
						小区入库日期:	
						<html:text name="kucunForm" property="rukuriqi" styleId="rukuriqi" size="17" onclick="WdatePicker({el:'rukuriqi'})" />
						<img onclick="WdatePicker({el:'rukuriqi'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> <a:need /><br/>
						
						入&nbsp;库&nbsp;小&nbsp;区&nbsp;:
						<html:select name="kucunForm" property="rukuxiaoqu"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
						</html:select>	<a:need /><br/>
						
						领&nbsp;&nbsp;&nbsp;取&nbsp;&nbsp;&nbsp;人:
						<html:select style="width:80px" name="kucunForm" property="lingquren"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								
								<html:options collection="userNameList" property="key" labelProperty="value" />
						</html:select>	<a:need /><br/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 备注:
							<html:textarea name="kucunForm" property="beizhu"  
								rows="5" cols="60"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
							</html:textarea><br/>
						</td>
					</tr>								
				</table>
				</div>
			</div>
			<!--  新增编辑 end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="确定" styleClass="commonButton" onclick="sub();"/>
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="switchBack();"/> 
			</div>
		</div>
		<html:hidden name="kucunForm" property="UUIDHidden" />
		<html:hidden name="kucunForm" property="zhuangtaiHidden" styleId="zhuangtai" />
		</html:form>
	</body>
	<script type="text/javascript">
		function sub() {
			if(checkInput()) {
				//commonSubmit('shebeirukuList.do?act=shebeitoxiaoquku');
			}
		}
		checkInput = function() {
			var rukuriqi = document.forms[0].rukuriqi.value;
			if (rukuriqi == null || trim(rukuriqi) == "") {
				alert("入库日期不能为空！");
				document.forms[0].rukuriqi.focus();//设置焦点
				return false;
			}
			
			
			var rukuriqi =  /^\d{4}[-](\d{2})[-]\d{2}$/.test(rukuriqi);
			if (rukuriqi == false ) {
					alert("入库日期输入有误！");
					return false;
			}
			var zhuangtai = document.getElementById("zhuangtai").value;
			if(zhuangtai == 2) {
				commonSubmit('shebeirukuList.do?act=shebeitoxiaoquku');
			}
			if(zhuangtai == 3) {
				commonSubmit('shebeichukuList.do?act=yichangkutoxiaoquku');
			}
			if (zhuangtai == 1) {
				commonSubmit('shebeichukuList.do?act=xiaoqukutoxiaoquku');
			}
			
			return true;
		}
		function switchBack(){
			var zhuangtai = document.getElementById("zhuangtai").value;
			if(zhuangtai == 2) {
				commonSubmit('shebeirukuList.do?act=init');
			}
			if (zhuangtai == 1) {
			commonSubmit('shebeichukuList.do?act=init');
			}
			if (zhuangtai == 3) {
			commonSubmit('shebeiyichangkuList.do?act=init');
			}
		}
	
	</script>
</html>