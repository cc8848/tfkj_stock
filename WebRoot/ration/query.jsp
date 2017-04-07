<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>快速开发框架演示项目</title>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="ration/ration.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="rationList.do">
		<bean:define id="xiaoquList" name="rationForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					设备配给
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								起始时间：
							</td>
							<td>
								<html:text name="rationForm" property="stateDate" styleId="stateDate" size="12" />
								<img onclick="WdatePicker({el:'stateDate'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 		
							</td>
							<td>
								截止时间：
							</td>
							<td>
								<html:text name="rationForm" property="endDate" styleId="endDate" size="12" />
								<img onclick="WdatePicker({el:'endDate'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 		
							</td>
							<td>
								小区名称：
							</td>
							<td>
								<!--<html:text name="rationForm" property="xiaoqu" size="12" />-->
								<html:select name="rationForm" property="xiaoqu"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							</td>
							<td>
								联系电话：
							</td>
							<td>
								<html:text name="rationForm" property="userTel" size="12" />
							</td>
							<!-- <td>
								派工单状态：
							</td>
							<td>
								<html:select name="rationForm" property="state"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:option value="1">已录入</html:option>
								<html:option value="2">已制定</html:option>
								<html:option value="3">已回单</html:option>
						</html:select>
							</td>-->
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('rationList.do?act=query')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- 查询结果 start -->
				<div name="result" class="conten_result">
					<!-- 分页头 -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- 结果一览 start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="98%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine">
									状态
								</td>
								<td class="tableTitleLine">
									小区名称
								</td>
								<td class="tableTitleLine">
									用户地址
								</td>
								<!-- <td class="tableTitleLine" weight="20%">
									联系电话
								</td> -->
								<td class="tableTitleLine">
									OUMMAC
								</td>
								<td class="tableTitleLine">
									STBMAC
								</td>
								<td class="tableTitleLine">
									天房宽带
								</td>
								<td class="tableTitleLine">
									IP电视
								</td>
								<td class="tableTitleLine">
									其他业务
								</td>
								<td class="tableTitleLine">
									电话号码
								</td>
							<!-- 	<td class="tableTitleLine">
									用户要求
								</td> -->
								<td class="tableTitleLine">
									ONU
								</td>
								<td class="tableTitleLine">
									机顶盒
								</td>
								<td class="tableTitleLine">
									派工日期
								</td>
								<td class="tableTitleLine">
									备注
								</td>
							
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine">
										<input name="pgdUUID" type="radio" value="${line.id}" />
									</td>
									<!-- <td class="tableContentLine">
										<bean:write name="line" field="PK_ID" />
									</td> -->
									<td class="tableContentLine">
										<bean:write name="line" field="stateName" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="xiaoquname" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="userplace" />
									</td>
									<!-- <td class="tableContentLine">
										<bean:write name="line" field="usertel" />
									</td> -->
									<td class="tableContentLine">
										<bean:write name="line" field="OUMMAC" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="STBMAC" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="tfkuandaidaikuan" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="tfiptv" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="qtye" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="telhaoma1" />&nbsp;<bean:write name="line" field="telhaoma2" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="onu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="jidinghe" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="paigongriqi" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="beizhu" />
									</td>

								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- 结果一览 end-->
					<div name="page_down" class="page_down">
						<div align="right">
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- 查询结果 end -->
				<!-- button -->
				<div name="button" class="content_button">
	
		<html:button property="btnSave" value="绑定" styleClass="commonButton" onclick="commonCheckSubmit('rationEdit.do?act=initEdit','pgdUUID','请选择待绑定的派工单')"/>
		<html:button property="btnSave" value="Ip分配" styleClass="commonButton" onclick="commonCheckSubmit('fenPeiIpEdit.do?act=PGDipInit','pgdUUID','请选择待编辑派工单')"/>
		<!--				<html:button property="btnSave" value="编辑" styleClass="commonButton" onclick="commonCheckSubmit('rationEdit.do?act=initEdit','UUID','请选择待编辑的派工单')"/>
						<html:button property="btnSave" value="删除" styleClass="commonButton" onclick="removeData()"/>-->
				</div>
			</div>
			<html:hidden name="rationForm" property="stateDateHidden" />
			<html:hidden name="rationForm" property="endDateHidden" />
			<html:hidden name="rationForm" property="xiaoquHidden" />
			<html:hidden name="rationForm" property="userTelHidden" />
			<html:hidden name="rationForm" property="stateHidden" value="1"/>
		</html:form>
		<!--
			<html:form action="rationList.do?act=upload&class_uuidCond=${class_uuidCond}" method="post" enctype="multipart/form-data" >
				<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
					<tr>
						<td>派工单上传：</td>
						<td><input name="formFile" type="file" size="60"
							class="commonTextFieldHover" 
							onfocus="this.className='commonTextFieldMove'" 
							onblur="this.className='commonTextFieldHover'" />
						
						<html:submit property="btnUpload" value="上传" styleClass="commonButton"></html:submit>
						<a href="./tclassstudent/studentuploadtemplate.xls">模板下载</a>
						</td>
						</tr>
					</table>
			</html:form>-->
	</body>
</html>
