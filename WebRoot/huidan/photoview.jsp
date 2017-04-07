<!---->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>小区：<bean:write name="PhotoUploadForm" property="xiaoqu" /> | 地址：<bean:write name="PhotoUploadForm" property="dizhi" /> | 收款时间：<bean:write name="PhotoUploadForm" property="shoukuanshijian" /> | 网络：<bean:write name="PhotoUploadForm" property="wangluo" /> | 电视：<bean:write name="PhotoUploadForm" property="dianshi" /></title>
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
							$("#imgcontent").html("当前用户没有上传照片");
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
				if($("#imgcontent").html()=="当前用户没有上传照片") {
					wrongMessage("存在未上传图片的数据，提交失败！");
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
			<!-- 标题 -->
			<div class="conten_top" name="top">
				上传照片
			</div>
			<div name="result" class="conten_result" style="height:98%">
				<div name="result_table" class="result_table" style="height:98%">
				<table border="0" cellspacing="0" cellpadding="2" width="98%">
					<tr height="35px">
						<td class="editTableTitle" style="width:5px">小区：</td>
						<td class="editTableContent" >
							<bean:write name="PhotoUploadForm" property="xiaoqu" />
							<html:hidden styleId="xiaoqu" name="PhotoUploadForm" property="xiaoqu" />
							<input id="auditphotobtn" type="button" class="commonButton3" value="审核并查看下一张" onclick="auditnext()"/>
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" style="width:5px">地址：</td>
						<td class="editTableContent" >
							<bean:write name="PhotoUploadForm" property="dizhi" />
							<html:hidden styleId="dizhi" name="PhotoUploadForm" property="dizhi" />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" style="width:5px">收款时间：</td>
						<td class="editTableContent" >
						<bean:write name="PhotoUploadForm" property="shoukuanshijian" />
						</td>
						</tr>
					<tr >
						<td class="editTableTitle" style="width:5px">网络：</td>
						<td class="editTableContent" >
							<bean:write name="PhotoUploadForm" property="wangluo" />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" style="width:5px">电视：</td>
						<td class="editTableContent" >
							<bean:write name="PhotoUploadForm" property="dianshi" />
						</td>
					</tr>
						<tr height="35px">
						<td class="editTableTitle" style="width:5px">业务：</td>
						<td class="editTableContent" >
						<bean:write name="PhotoUploadForm" property="yewu" />
						</td>
					</tr>
					</tr>
						<tr height="35px">
						<td class="editTableTitle" style="width:5px">上传图片：</td>
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