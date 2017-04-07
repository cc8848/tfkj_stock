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
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="qujianList.do">
		<bean:define id="xiaoquList" name="tongjiForms" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					收件管理
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								小区名称：
							</td>
							<td>
								<!--<html:text name="tongjiForms" property="xiaoqu" size="12" styleId="xiaoqu"/>-->
								<html:select name="tongjiForms" property="xiaoqu"styleId="xiaoqu"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
								
							</td>
							<td>
								日期：
							</td>
							<td>
								<html:text name="tongjiForms" onclick="WdatePicker({el:'paigongriqi'})" property="paigongriqi" size="12" styleId="paigongriqi"/>
								<img onclick="WdatePicker({el:'paigongriqi'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 		
							</td>
							
							<td>
								联系电话：
							</td>
							<td>
								<html:text name="tongjiForms" property="userTel"  size="12" />
							</td>
							<td>
								派工单状态：
							</td>
							<td>
							<html:select name="tongjiForms" property="state"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:option value="1">已预约</html:option>
								<html:option value="9">取件中</html:option>
								<html:option value="10">已取件</html:option>
								<html:option value="11">数据已上传</html:option>
								<html:option value="12">已收电信下单</html:option>
							</html:select>
							</td>
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('qujianList.do?act=query')" />
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
						<table border="0" cellspacing="0" cellpadding="1"  width="130%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td> 
								<td class="tableTitleLine"nowrap="nowrap">
									状态
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									项目
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									日期
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									时间
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									小区名称
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									用户地址
								</td>
								<td class="tableTitleLine" weight="20%"nowrap="nowrap">
									联系电话
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									宽带
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电视
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电话
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									业务
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									分光
								</td>
								<!-- <td class="tableTitleLine">
									用户要求
								</td> -->
								<td class="tableTitleLine"nowrap="nowrap">
									ONUMAC
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									STBMCID
								</td>
								
								<td class="tableTitleLine"nowrap="nowrap">
									电视ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									网络ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电话ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电话valn
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									网络valn
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
										<input name="UUIDS" type="checkbox" value="${line.id}" />
									</td>
									<!-- <td class="tableContentLine">
										<bean:write name="line" field="PK_ID" />
									</td> -->
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="stateName" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xiangmu" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="paigongriqi" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="anzhuangshijian" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xiaoquname" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="userplace" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="usertel" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tfkuandaidaikuan" />
									</td>
									
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tfiptv" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="dianhua" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="qtye" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="fenguang" />
									</td>
									<!--  <td class="tableContentLine">
										<bean:write name="line" field="useryaoqiu" />
									</td>-->
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="OUMMAC" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="STBMAC" />
									</td>
									
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tvip" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="netip" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="telip" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="telvaln" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="netvaln" />
									</td>
									
									<td class="tableContentLine" width="30%">
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
				<input type="button" class="commonButton2" value="导出报表" onclick="exportNoBind();"/>
				<!--<html:button property="btnSave" value="结单" styleClass="commonButton" onclick="commonCheckSubmit('tongjiEdit.do?act=initEdit','UUID','请选择待编辑的出工单')"/>
				-->
				<html:button property="btnSave" value="取件中"  styleClass="commonButton2" onclick="commonCheckSubmit('qujianEdit.do?act=operate&type=1','UUIDS','请选择待编辑的派工单')"/>
				<html:button property="btnSave" value="已取件" styleClass="commonButton" onclick="commonCheckSubmit('qujianEdit.do?act=operate&type=2','UUIDS','请选择待编辑的派工单')"/>
				<html:button property="btnSave" value="数据已上传" styleClass="commonButton2" onclick="commonCheckSubmit('qujianEdit.do?act=operate&type=3','UUIDS','请选择待编辑的派工单')"/>
				<html:button property="btnSave" value="已收电信下单" styleClass="commonButton2" onclick="commonCheckSubmit('qujianEdit.do?act=operate&type=4','UUIDS','请选择待编辑的出工单')"/>
				<html:button property="btnSave" value="上传客服和数据" styleClass="commonButton2" onclick="commonCheckSubmit('qujianEdit.do?act=operate&type=5','UUIDS','请选择待编辑的出工单')"/>
				<html:button property="btnSave" value="退单" styleClass="commonButton" onclick="commonCheckSubmit('qujianEdit.do?act=tuidan','UUIDS','请选择待编辑的出工单')"/>
					<!-- 	<html:button property="btnSave" value="添加" styleClass="commonButton" onclick="commonSubmit('paigongdanEdit.do?act=initInsert')"/>
						 <html:button property="btnSave" value="编辑" styleClass="commonButton" onclick="commonCheckSubmit('paigongdanEdit.do?act=initEdit','UUID','请选择待编辑的派工单')"/>
						<html:button property="btnSave" value="删除" styleClass="commonButton" onclick="removeData()"/>
				--></div>
			</div>
			<html:hidden name="tongjiForms" property="xiaoquHidden" />
			<html:hidden name="tongjiForms" property="userTelHidden" />
			<html:hidden name="tongjiForms" property="stateHidden" />
			<html:hidden name="tongjiForms" property="paigongriqiHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	//导出excle
		function exportNoBind(){
		//var classUUID = document.getElementById("classUUID").value;
		var xiaoqu = document.getElementById("xiaoqu").value;
		var paigongriqi = document.getElementById("paigongriqi").value;
			//if(xiaoqu==null||trim(xiaoqu)==""){
			//	infoMessage("请输入小区名称");
			//	document.getElementById("xiaoqu").focus();
			//	return false;
			//	}
			if(xiaoqu==null||trim(paigongriqi)==""){
				infoMessage("请输入派工日期");
				document.getElementById("paigongriqi").focus();
				return false;
				}
			window.open("qujianReport.do?act=export&paigongriqi="+ paigongriqi + "&xiaoqu=" + encodeURI(encodeURI(xiaoqu)));
	}
	</script>
</html>
