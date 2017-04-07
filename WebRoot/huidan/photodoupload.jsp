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
				function upload() {
					
					window.opener.refreshgamen();
			 		//document.forms[1].submit();
				}
		</script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="paigongdanEdit.do">
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">
				上传照片
			</div>
			<div name="result" class="conten_result" style="z-index:-1">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="98%">
					<tr height="35px">
						<td class="editTableTitle" width="30px">小区：</td>
						<td class="editTableContent" >
							<bean:write name="PhotoUploadForm" property="xiaoqu" />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">地址：</td>
						<td class="editTableContent" >
							<bean:write name="PhotoUploadForm" property="dizhi" />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">收款时间：</td>
						<td class="editTableContent" >
						<bean:write name="PhotoUploadForm" property="shoukuanshijian" />
						</td>
						</tr>
					<tr >
						<td class="editTableTitle" width="30px">网络：</td>
						<td class="editTableContent" >
							<bean:write name="PhotoUploadForm" property="wangluo" />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">电视：</td>
						<td class="editTableContent" >
							<bean:write name="PhotoUploadForm" property="dianshi" />
						</td>
					</tr>
						<tr height="35px">
						<td class="editTableTitle" width="30px">业务：</td>
						<td class="editTableContent" >
						<bean:write name="PhotoUploadForm" property="yewu" />
						</td>
					</tr>
				</table>
				</div>
			</div>
		</div>
		<html:hidden name="PhotoUploadForm" property="UUID" />
		</html:form>
		<form id="fileupload" action="/tfkj_stock/photouploadEdit.do?act=upload" method="POST" enctype="multipart/form-data">
		<html:hidden name="PhotoUploadForm" property="UUID" />
		<html:hidden name="PhotoUploadForm" property="xiaoqu" />
		<html:hidden name="PhotoUploadForm" property="dizhi" />
		<html:hidden name="PhotoUploadForm" property="shoukuanshijian" />
		<html:hidden name="PhotoUploadForm" property="wangluo" />
		<html:hidden name="PhotoUploadForm" property="dianshi" />
		<html:hidden name="PhotoUploadForm" property="yewu" />
			<table id="quert_table2" cellpadding="1" cellspacing="1" border="0">
				<tr>
					<td>相片上传：</td>
					<td><input name="formFile" type="file" size="60"
						class="commonTextFieldHover" 
						onfocus="this.className='commonTextFieldMove'" 
						onblur="this.className='commonTextFieldHover'" />
					
					<html:submit onclick="upload()" property="telUpload" value="上传" styleClass="commonButton"></html:submit>
						</td>
					</tr>
				</table>
		</form>
	</body>
</html>