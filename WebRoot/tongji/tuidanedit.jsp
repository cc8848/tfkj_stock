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
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/common.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
	<body onload="init()">
		<html:form action="tongjiEdit.do">
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">
				出工单退单备注录入
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr >
						<td class="editTableTitleLast" >备注：</td>
						<td class="editTableContentLast" >
							<html:textarea name="chugongdanEditForm" property="tuidanbeizhu"  styleId="tuidanbeizhu"
								rows="5" cols="70"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
							</html:textarea>
							<a:need />
						</td>
					</tr>
				</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="确认退单" styleClass="commonButton2" onclick="sub()"/>
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('tongjiList.do?act=init')"/>
			</div>
		</div>
		<html:hidden name="chugongdanEditForm" property="UUID" />
		</html:form>
	</body>
	<script type="text/javascript">
	sub = function(){
		var beizhu =  document.getElementById("tuidanbeizhu").value;
		//alert(beizhu);
		if(beizhu==null||trim(beizhu)==""){
				alert("请输入备注内容！");
				return false;
			}
		commonSubmit('tongjiEdit.do?act=tuidan');
			}
	</script>
</html>