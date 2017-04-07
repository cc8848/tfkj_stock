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
		<script src="equipStock/equipStock.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">  
		<html:form action="equipStockEdit.do">
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">
				添加设备
			</div>
			<!--  新增编辑 start -->
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="940px">
				<!-- 检索项 start -->
					<tr height="35px">
						<td class="editTableTitle" >设备类别：</td>
						<td class="editTableContent" >
							<html:select name="equipStockEntiyForm" property="typeString" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="机顶盒">机顶盒</html:option>
								<html:option value="ONU">ONU</html:option>
							</html:select>   
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >设备箱号：</td>
						<td class="editTableContent" >
						<html:text name="equipStockEntiyForm" property="xianghaoString" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" maxlength="20"/>
							<a:need />
							
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >设备型号：</td>
						<td class="editTableContent" >
							<html:text name="equipStockEntiyForm" property="xinghaoString" 
								styleClass="commonTextFieldHover" maxlength="20"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >入库时间：</td>
						<td class="editTableContent" >
						<html:text name="equipStockEntiyForm" property="rukudateString"  styleId="rukudateString"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						<img onclick="WdatePicker({el:'rukudateString'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 		
							<a:need />
						</td>
					</tr>
					
					<tr height="35px">
						<td class="editTableTitle" >入库人：</td>
						<td class="editTableContent" >
							<html:text name="equipStockEntiyForm" property="rukupersonString" 
								styleClass="commonTextFieldHover" maxlength="20"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					
					<tr height="35px">
						<td class="editTableTitle" >mac：</td>
						<td class="editTableContent" >
							<html:text name="equipStockEntiyForm" property="macsString" 
								styleClass="commonTextFieldHover" maxlength="20"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >库存地点：</td>
						<td class="editTableContent" >
						<html:select name="equipStockEntiyForm" property="chukuplaceString"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="环渤海">环渤海</html:option>
								<html:option value="东丽一库">东丽一库</html:option>
								<html:option value="西青二库">西青二库</html:option>
								<html:option value="河西一库">河西一库</html:option> 
								<html:option value="海景雅苑">海景雅苑</html:option> 
								<html:option value="海景公寓">海景公寓</html:option> 
								<html:option value="新尚园">新尚园</html:option> 
								<html:option value="美域豪庭">美域豪庭</html:option> 
								<html:option value="美域兰庭">美域兰庭</html:option> 
								<html:option value="美域华庭">美域华庭</html:option> 
								<html:option value="昆俞家园">昆俞家园</html:option>
								<html:option value="昆俞欣园">昆俞欣园</html:option> 
								<html:option value="天欣花园">天欣花园</html:option>
								<html:option value="翠海红山">翠海红山</html:option> 
								<html:option value="泰安道五大院">泰安道五大院</html:option>  
							</html:select>
							<a:need />
						</td>
					</tr>
					<!-- <tr height="35px">
						<td class="editTableTitle" >电视IP：</td>
						<td class="editTableContent" >
							<html:text name="equipStockEntiyForm" property="tVipString" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr> -->
					<tr height="35px">
						<td class="editTableTitle" >备注：</td>
						<td class="editTableContent" >
							<html:text name="equipStockEntiyForm" property="beizhuString" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
				</table>
				</div>
			</div>
			<!--  新增编辑 end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="保存" styleClass="commonButton" onclick="commonSubmit('equipStockEdit.do?act=insert')"/>
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('equipStockList.do?act=init')"/>
			</div>
		</div>
		</html:form>
	</body>
</html>