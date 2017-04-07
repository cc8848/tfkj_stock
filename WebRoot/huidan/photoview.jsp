<!---->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>С����<bean:write name="PhotoUploadForm" property="xiaoqu" /> | ��ַ��<bean:write name="PhotoUploadForm" property="dizhi" /> | �տ�ʱ�䣺<bean:write name="PhotoUploadForm" property="shoukuanshijian" /> | ���磺<bean:write name="PhotoUploadForm" property="wangluo" /> | ���ӣ�<bean:write name="PhotoUploadForm" property="dianshi" /></title>
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
		%>
		<script src="js/Calendar3.js" language="javascript"></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/common.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="paigongdan/paigongdan.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<script type="text/javascript">
			function initimg() {
				var xiaoqu = encodeURIComponent(document.forms[0].xiaoqu.value);
					var dizhi = encodeURIComponent(document.forms[0].dizhi.value);
					var bigsize = window.screen.availWidth-200;
				$.ajax({
							url:"photouploadEdit.do?act=getAllPhotos",
							type : "POST",
							cache:false,
							data:{
								'xiaoqu':xiaoqu,
								'dizhi':dizhi							
							},
							success: function(data){
								if(data!="") {
								var countNumArray = data.split("|");
								if(countNumArray.length >0) {
									var str = "";
									for(var i=0; i<countNumArray.length; i++) {
										str += "<img id=photo"+i+"></br>";
									}
									$("#imgcontent").html(str);
									for(var i=0; i<countNumArray.length; i++) {
										$("#photo"+i).attr("src","data:image/jpeg;base64,"+countNumArray[i]);  
										
										$("#photo"+i).attr("width","100");
										$("#photo"+i).click(function() {
											if(this.width=="100") {
											this.width=bigsize;
											}else{
											this.width="100";
											}
										});
										i++
										$("#photo"+i).attr("alt",countNumArray[i]);  
									}
								}
							}else{
							$("#imgcontent").html("��ǰ�û�û���ϴ���Ƭ");
							}
							}
						});
			}
			function zoomimg(index) {
				alert(index);
			}
			function initbtn() {
				var gamen = window.opener.document.getElementById("gamenKbn").value;
				if(gamen!="AUDIT") {
					document.getElementById("auditphotobtn").style.display="none";  
				}
			}
			function auditnext() {
				if($("#imgcontent").html()=="��ǰ�û�û���ϴ���Ƭ") {
					wrongMessage("����δ�ϴ�ͼƬ�����ݣ��ύʧ�ܣ�");
					return false;
				}
				document.forms[0].action = "photouploadEdit.do?act=auditAndNext";
				disableAll(document);
				 document.forms[0].submit();
			}
		</script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init();initbtn();initimg();">
		<html:form action="paigongdanEdit.do">
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">
				�ϴ���Ƭ
			</div>
			<div name="result" class="conten_result" style="height:98%">
				<div name="result_table" class="result_table" style="height:98%">
				<table border="0" cellspacing="0" cellpadding="2" width="98%">
					<tr height="35px">
						<td class="editTableTitle" style="width:5px">С����</td>
						<td class="editTableContent" >
							<bean:write name="PhotoUploadForm" property="xiaoqu" />
							<html:hidden styleId="xiaoqu" name="PhotoUploadForm" property="xiaoqu" />
							<input id="auditphotobtn" type="button" class="commonButton3" value="��˲��鿴��һ��" onclick="auditnext()"/>
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" style="width:5px">��ַ��</td>
						<td class="editTableContent" >
							<bean:write name="PhotoUploadForm" property="dizhi" />
							<html:hidden styleId="dizhi" name="PhotoUploadForm" property="dizhi" />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" style="width:5px">�տ�ʱ�䣺</td>
						<td class="editTableContent" >
						<bean:write name="PhotoUploadForm" property="shoukuanshijian" />
						</td>
						</tr>
					<tr >
						<td class="editTableTitle" style="width:5px">���磺</td>
						<td class="editTableContent" >
							<bean:write name="PhotoUploadForm" property="wangluo" />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" style="width:5px">���ӣ�</td>
						<td class="editTableContent" >
							<bean:write name="PhotoUploadForm" property="dianshi" />
						</td>
					</tr>
						<tr height="35px">
						<td class="editTableTitle" style="width:5px">ҵ��</td>
						<td class="editTableContent" >
						<bean:write name="PhotoUploadForm" property="yewu" />
						</td>
					</tr>
					</tr>
						<tr height="35px">
						<td class="editTableTitle" style="width:5px">�ϴ�ͼƬ��</td>
						<td id="imgcontent" class="editTableContent" >
								
						</td>
					</tr>
				</table>
				</div>
			</div>
		</div>
		<html:hidden name="PhotoUploadForm" property="UUID" />
		</html:form>
	</body>
</html>