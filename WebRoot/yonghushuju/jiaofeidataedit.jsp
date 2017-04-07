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
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
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
		<html:form action="jiaofeiTXEdit.do">
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">用户数据编辑</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td class="editTableTitle" width="30px">用户信息：</td>
							<td class="editTableContent">
								<table>
									<tr>
										<td>
											小区名称： 
											<!-- <html:select name="yonghuDataEntityForm"
												property="xiaoqu" styleId="xiaoqu"
												styleClass="commonTextFieldHover"
												onchange="selectxiaoqu(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'">
												<html:options collection="xiaoquList" property="key"
													labelProperty="value" />
											</html:select> <a:need /> -->
											<html:text name="yonghuDataEntityForm"
												property="xiaoqu" size="12" maxlength="20"  readonly="true"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											用户地址： <html:text name="yonghuDataEntityForm"
												property="dizhi" size="12" maxlength="20"  readonly="true"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>
											用户姓名： <html:text name="yonghuDataEntityForm"
												property="xingming" size="12" maxlength="20"
												styleClass="commonTextFieldHover" readonly="true"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											联系电话： <html:text name="yonghuDataEntityForm"
												property="lianxidianhua" size="12" maxlength="20"
												styleClass="commonTextFieldHover" readonly="true"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>身份证号： <html:text name="yonghuDataEntityForm"
												property="shenfensheng" size="30" maxlength="20"
												styleClass="commonTextFieldHover"  readonly="true"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td class="editTableTitle" width="30px">服务信息：</td>
							<td class="editTableContent">
								<table>
									<tr>
										<td>用户状态：<html:text name="yonghuDataEntityForm"
												property="yonghuzhuangtai" size="20" maxlength="20"
												styleClass="commonTextFieldHover"  readonly="true"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											<!--  <html:select name="yonghuDataEntityForm" property="yonghuzhuangtai" 
														styleClass="commonTextFieldHover" 
														onfocus="this.className='commonTextFieldMove'" 
														onblur="this.className='commonTextFieldHover'">
														<html:option value="已安装">已安装</html:option>
														<html:option value="已维修">已维修</html:option>
														<html:option value="已续费">已续费</html:option>
													</html:select>	
													<a:need /> -->
											收据号：<html:text name="yonghuDataEntityForm"
												property="shoujuhao" size="20" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									
									<tr>
										<td>开机时间： <html:text name="yonghuDataEntityForm" property="kaijishijian" styleId="kaijishijians" size="10" onclick="WdatePicker({el:'kaijishijians'})" />
								<img onclick="WdatePicker({el:'kaijishijians'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">  <a:need />
											停机时间： <html:text name="yonghuDataEntityForm" property="tingjishijian" styleId="tingjishijians" size="10" onclick="WdatePicker({el:'tingjishijians'})" />
								<img onclick="WdatePicker({el:'tingjishijians'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">  <a:need />
										</td>
									</tr>
									<tr>
									<td>网络： <html:text name="yonghuDataEntityForm"
												property="wangluo" size="12" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											电视： <html:text name="yonghuDataEntityForm"
												property="dianshi" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											电话： <html:text name="yonghuDataEntityForm"
												property="dianhua" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
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
				<html:button property="btnSave" value="保存" styleClass="commonButton" onclick="subs();"/>
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('jiaofeiTXList.do?act=init')"/>
			</div>
		</div>
		<html:hidden name="yonghuDataEntityForm" property="UUID" />
		</html:form>
	</body>
	<script type="text/javascript">	
	function subs() {
		if(checkInputForJiaofei()) {
			commonSubmit('jiaofeiTXEdit.do?act=update');
		}
	}
	</script>
</html>