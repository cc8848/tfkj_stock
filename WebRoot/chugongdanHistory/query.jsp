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
		<script src="paigongdan/paigongdan.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="chugongdanHistoryList.do">
		<bean:define id="xiaoquList" name="chugongdanHistoryForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					出工单历史
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								派工日期：
							</td>
							<td>
								<html:text name="chugongdanHistoryForm" property="paigongriqis" styleId="paigongriqis" size="12" onclick="WdatePicker({el:'paigongriqis'})" />
								<img onclick="WdatePicker({el:'paigongriqis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 		
							</td>
							<td>
								项目：
							</td>
							<td>
								<html:select name="chugongdanHistoryForm" property="xiangmus"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:option value="安装">安装</html:option>
								<html:option value="续费">续费</html:option>
								<html:option value="退户">退户</html:option>
								<html:option value="维修">维修</html:option>
							</html:select>
							</td>
							<td>
								小区名称：
							</td>
							<td>
								<html:select name="chugongdanHistoryForm" property="xiaoqu"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							</td>
							<td>
								地址
							</td>
							<td>
								<html:text name="chugongdanHistoryForm" property="userplaces" size="12" />
							</td>
							<td>
								联系电话：
							</td>
							<td>
								<html:text name="chugongdanHistoryForm" property="userTel" size="12" />
							</td>
						<!-- 	<td>
								派工单状态：
							</td>
							<td>
							<html:select name="chugongdanHistoryForm" property="state"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:option value="1">已预约</html:option>
								<html:option value="5">数据完工</html:option>
								<html:option value="6">施工中</html:option>
								<html:option value="7">工毕</html:option>
								<html:option value="8">结单</html:option>
							</html:select>
							</td> -->
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('chugongdanHistoryList.do?act=query')" />
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
						<table border="0" cellspacing="0" cellpadding="1" width="220%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine">
									状态
								</td>
								<td class="tableTitleLine">
									项目
								</td>
								<td class="tableTitleLine">
									派工日期
								</td>
								<td class="tableTitleLine">
									时间
								</td>
								<td class="tableTitleLine">
									小区名称
								</td>
								<td class="tableTitleLine">
									用户姓名
								</td>
								<td class="tableTitleLine">
									用户地址
								</td>
								<td class="tableTitleLine" weight="20%">
									联系电话
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
								<!-- <td class="tableTitleLine">
									用户要求
								</td> -->
								<td class="tableTitleLine">
									ONU<br/>押金
								</td>
								<td class="tableTitleLine">
									机顶盒<br/>押金
								</td>
								
								<td class="tableTitleLine">
									备注
								</td>
							
								<td class="tableTitleLine">
									数据完工<br/>操作人
								</td>
								<td class="tableTitleLine">
									数据完工<br/>日期
								</td>
								<td class="tableTitleLine">
									施工中<br/>操作人
								</td>
								<td class="tableTitleLine">
									施工中<br/>日期
								</td>
								<td class="tableTitleLine">
									工毕<br/>操作人
								</td>
								<td class="tableTitleLine">
									工毕<br/>日期
								</td>
								<td class="tableTitleLine">
									结单<br/>操作人
								</td>
								<td class="tableTitleLine">
									结单<br/>日期
								</td>
								<td class="tableTitleLine">
									结单<br/>备注
								</td>
								<td class="tableTitleLine">
									退单<br/>操作人
								</td>
								<td class="tableTitleLine">
									退单<br/>日期
								</td>
								<td class="tableTitleLine">
									退单<br/>备注
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<!-- <td class="tableContentLine">
										<bean:write name="line" field="PK_ID" />
									</td> -->
									<td class="tableContentLine">
										<bean:write name="line" field="stateName" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="xiangmu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="paigongriqi" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="anzhuangshijian" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="xiaoquname" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="username" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="userplace" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="usertel" />
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
									<!-- <td class="tableContentLine">
										<bean:write name="line" field="useryaoqiu" />
									</td> -->
									<td class="tableContentLine">
										<bean:write name="line" field="onu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="jidinghe" />
									</td>
									<td class="tableContentLine" width="16%">
										<bean:write name="line"  field="beizhu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="shujuupdateby" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="shujuupdatedt" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="shigongzhongby" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="shigongzhongdt" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="gongbiby" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="gongbidt" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="jiedanby" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="jiedandt" />
									</td>
									<td class="tableContentLine" width="10%">
										<bean:write name="line" field="jiedanbeizhu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="tuidanby" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="tuidandt" />
									</td>
									
									<td class="tableContentLine" width="10%">
										<bean:write name="line" field="tuidanbeizhu" />
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
					<!-- 	<html:button property="btnSave" value="添加" styleClass="commonButton" onclick="commonSubmit('paigongdanEdit.do?act=initInsert')"/>
						 <html:button property="btnSave" value="编辑" styleClass="commonButton" onclick="commonCheckSubmit('paigongdanEdit.do?act=initEdit','UUID','请选择待编辑的派工单')"/>
						<html:button property="btnSave" value="删除" styleClass="commonButton" onclick="removeData()"/>
						<html:button property="btnSave" value="解绑" styleClass="commonButton" onclick="removeData1()"/>
						<html:button property="btnSave" value="查看详情" styleClass="commonButton2" onclick="commonCheckSubmit('paigongdanEdit.do?act=showInfo','UUID','请选择待查看的派工单')"/>
			 -->	</div>
			</div>
			<html:hidden name="chugongdanHistoryForm" property="stateDateHidden" />
			<html:hidden name="chugongdanHistoryForm" property="endDateHidden" />
			<html:hidden name="chugongdanHistoryForm" property="xiaoquHidden" />
			<html:hidden name="chugongdanHistoryForm" property="userTelHidden" />
			<html:hidden name="chugongdanHistoryForm" property="stateHidden" />
			<html:hidden name="chugongdanHistoryForm" property="paigongriqisHidden" />
			<html:hidden name="chugongdanHistoryForm" property="xiangmusHidden" />
		</html:form>
		</div>
			<!--<html:form action="paigongdanUpload.do?act=upload" method="post" enctype="multipart/form-data" >
				<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
					<tr>
						<td>派工单日期：</td>
						<td>
							<html:text name="importPGDForm" property="dateString" size="12"styleId="dateString" />
							<img onclick="WdatePicker({el:'dateString'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 		
						</td>
						<td>派工单上传：</td>
						<td><input name="formFile" type="file" size="60"
							class="commonTextFieldHover" 
							onfocus="this.className='commonTextFieldMove'" 
							onblur="this.className='commonTextFieldHover'" />
						
						<html:submit property="btnUpload" value="上传" disabled="true" styleClass="commonButton"></html:submit>
						
						<a href="./paigongdan/paigongdan.xls">模板下载</a>
						</td>
						</tr>
					</table>
			</html:form>-->
	</body>

</html>
