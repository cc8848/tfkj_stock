<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>���ٿ��������ʾ��Ŀ</title>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/selectOption.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="caiwuhedui/caiwu.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init();initNotselect();initselect();">
	<div style="height:540px;">
		<html:form action="accountsmateList.do">
			<div id="content_all">
				<!-- ���� -->
			<div class="conten_top" name="top">С��IPTVҵ�����</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table" style="height:440px;">
					<table border="0" cellspacing="0" cellpadding="2" width="100%">
					<tr >
						<td valign="top" class="editTableTitleLast" width="80px">С�����ƣ�</td>
						<td class="editTableContentLast">
							<bean:write name="xiaoquForm" property="name"/><html:hidden name="xiaoquForm" property="name" /><html:hidden name="xiaoquForm" property="UUID" />
							</tr>
							<tr >
						<td valign="top" class="editTableTitleLast" width="80px">����IPTVҵ��</td>
						<td class="editTableContentLast">
							<table align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					��ѡ��ҵ��
				</td>
				<td></td>
				<td>
					��ѡ��ҵ��<font color="blue">��ѡ�м����ɼ���</font>
				</td>
			</tr>
			<tr>
				<td>
					<select multiple="multiple" id="leftselect" name="leftselect"
						style="width: 400px; height: 360px;">
					</select>

				</td>
				<td>
					<input type="button" class="button" id="add" value="ѡ������" width="6">
					<br>
					<input type="button" class="button" id="remove" value="ѡ������">
					<br>
					<input type="button" class="button" id="alladd" value="ȫ������">
					<br>
					<input type="button" class="button" id="allremove" value="ȫ������">
				</td>
				<td>
					<select multiple="multiple" id="rightselect" name="rightselect"
						style="width: 400px; height: 360px;">
					</select>
				</td>
			</tr>
		</table>
					</tr>
					</table>
				</div>
			</div>
				<!-- ��ѯ��� end -->
				<!-- button -->
				<div id="buttonC" name="button" class="content_button" style="top:490px;">
					 <html:button property="btnSave" value="����" styleClass="commonButton" onclick="sub();"/> 
					 
				 	 <html:button property="btnSave" value="����" styleClass="commonButton" onclick="commonSubmit('xiaoquList.do?act=init')"/>
			    </div>
			</div>
		</html:form>
	</div>
	</body>
	<script type="text/javascript"  language="javascript">
		function sub(){
			$('#rightselect option').attr("selected",true);
			commonSubmit('xiaoquList.do?act=saveDianshi');
	}
	function initNotselect() {
	var xiaoqu = document.forms[0].name.value;
		var URL = "shenqingDataEdit.do?act=getDianshi"; 
		$.ajax({
			url:URL,
			cache:false,
			data:{'xiaoqu':encodeURI(xiaoqu),'idkbn':true,'allkbn':true},
			success: function(result0){
				var countNumArray = result0.split("|");
					if(countNumArray.length >0) {
						var str = "";
						for(var i=0; i<countNumArray.length; i++) {
							var countNumStr = countNumArray[i];
								if(countNumStr!="") {
									var countNumStrArr = countNumStr.split(":");
									str += "<option value=" + countNumStrArr[0] + ">" + countNumStrArr[1] + "</option>"; 
								}
						}
						$("#rightselect").html(str);
				}
			}
		});
	}
	function initselect() {
	var xiaoqu = document.forms[0].name.value;
		var URL = "shenqingDataEdit.do?act=getDianshi"; 
		$.ajax({
			url:URL,
			cache:false,
			data:{'xiaoqu':encodeURI(xiaoqu),'idkbn':true,'allkbn':false},
			success: function(result0){
				var countNumArray = result0.split("|");
					if(countNumArray.length >0) {
						var str = "";
						for(var i=0; i<countNumArray.length; i++) {
							var countNumStr = countNumArray[i];
								if(countNumStr!="") {
									var countNumStrArr = countNumStr.split(":");
									str += "<option value=" + countNumStrArr[0] + ">" + countNumStrArr[1] + "</option>";
								}
						}
						$("#leftselect").html(str);
				}
			}
		});
	}
		
	</script>
</html>
