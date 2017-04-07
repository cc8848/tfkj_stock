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

		</script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="fenguangguizeEdit.do">
		<bean:define id="xiaoquList" name="fenPeiFenGuangGuiZeForm" property="xiaoquList"></bean:define>
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">
				分光分配规则编辑
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="2" width="940px">
							<tr height="35px">
								<td class="editTableTitle" width="30px">小区名称：</td>
								<td class="editTableContent" >
								<html:select name="fenPeiFenGuangGuiZeForm" property="xiaoqu" styleId="xiaoquname" 
								styleClass="commonTextFieldHover"  onchange="selectxiaoqu(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							<a:need />
							</td>
						</tr>
						<tr >
						<td class="editTableTitleLast" >楼号：</td>
						<td class="editTableContentLast" >
							<html:text name="fenPeiFenGuangGuiZeForm" property="louhao" ></html:text>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >楼门：</td>
						<td class="editTableContentLast" >
							<html:text name="fenPeiFenGuangGuiZeForm" property="loumen" ></html:text>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >楼层：</td>
						<td class="editTableContentLast" >
							<html:text name="fenPeiFenGuangGuiZeForm" property="louceng" ></html:text>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >单元：</td>
						<td class="editTableContentLast" >
							<html:text name="fenPeiFenGuangGuiZeForm" property="danyuan" ></html:text>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >分光ID：</td>
						<td class="editTableContentLast" >
							<html:text name="fenPeiFenGuangGuiZeForm" property="fenguangID" ></html:text>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >备注：</td>
						<td class="editTableContentLast" >
							<html:textarea name="fenPeiFenGuangGuiZeForm" property="beizhu"  
								rows="5" cols="70"  onkeyup="if(this.value.length>200)this.value=this.value.substr(0,200)">
							</html:textarea>
						</td>
					</tr>
					
				</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="保存" styleClass="commonButton" onclick="subs();"/>
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('fenguangguizeList.do?act=init')"/>
			</div>
		</div>
		<html:hidden name="fenPeiFenGuangGuiZeForm" property="UUID" />
		</html:form>
	</body>
	<script type="text/javascript">

		function checkInput() {
			var xiaoqu = document.forms[0].xiaoqu.value;
			if (xiaoqu == null || trim(xiaoqu) == "") {
				alert("小区不能为空");
				document.forms[0].xiaoqu.focus();//设置焦点
				return false;
			}
			var louhao = document.forms[0].louhao.value;
			if (louhao == null || trim(louhao) == "") {
				alert("楼号不能为空");
				document.forms[0].louhao.focus();//设置焦点
				return false;
			}
			var loumen = document.forms[0].loumen.value;
			if (loumen == null || trim(loumen) == "") {
				alert("楼门不能为空");
				document.forms[0].loumen.focus();//设置焦点
				return false;
			}
			var louceng = document.forms[0].louceng.value;
			if (louceng == null || trim(louceng) == "") {
				alert("楼层不能为空");
				document.forms[0].louceng.focus();//设置焦点
				return false;
			}
			var danyuan = document.forms[0].danyuan.value;
			if (danyuan == null || trim(danyuan) == "") {
				alert("单元不能为空");
				document.forms[0].danyuan.focus();//设置焦点
				return false;
			}
			var fenguangID = document.forms[0].fenguangID.value;
			if (fenguangID == null || trim(fenguangID) == "") {
				alert("分光ID不能为空");
				document.forms[0].fenguangID.focus();//设置焦点
				return false;
			}
			return true;
		}
		function subs() {
			if (checkInput()) {
				commonSubmit('fenguangguizeEdit.do?act=updateFenguangGuize');
			}
		}
	</script>
</html>