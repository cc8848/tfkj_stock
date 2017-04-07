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
<script src="yonghushuju/yonghuData.js" language="javascript"></script>
<script src="js/business.js" language="javascript"></script>
<jsp:include page="/common/commonMessage.jsp" />
</head>
<body onload="init()">
	<html:form action="yonghuDataEdit.do">
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">电话数据编辑</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td class="editTableTitle" width="30px">电话信息：</td>
							<td class="editTableContent">
								<table>
									<tr>
										<td>
											区域： 
											<html:text name="telNumEidtForm"
												property="quyu" size="30" maxlength="20"  readonly="true"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											号码： <html:text name="telNumEidtForm"
												property="telNo" size="30" maxlength="20"  readonly="true"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
									</tr>
									<tr>
										<td>备注： 
												<html:textarea name="telNumEidtForm" property="desc"  
										rows="5" cols="70"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
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
				<html:button property="btnSave" value="保存" styleClass="commonButton" onclick="subs();" />
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('telNumberList.do?act=init')" />
			</div>
		</div>
		<html:hidden name="telNumEidtForm" property="UUID" />
	</html:form>
</body>
<script type="text/javascript">
	function subs() {	
			commonSubmit('telNumEdit.do?act=updateTel');
	}
</script>
</html>