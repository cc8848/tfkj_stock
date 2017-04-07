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
		<script src="yonghushuju/yonghuData.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="yonghuDataList.do">
		<bean:define id="xiaoquList" name="yonghuDataForm" property="xiaoquList"></bean:define>
		<bean:define id="statusList" name="yonghuDataForm" property="statusList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					财务报表
				</div>
				<!-- 查询结果 start -->
				<div name="result" class="conten_result1">
					<!-- 分页头 -->
					<div name="page_up" class="page_up">
						<!-- <jsp:include page="/common/paginationHeader.jsp" /> -->
					</div>
					<!-- 结果一览 start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="100%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									存款人&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									存款时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									存款银行&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									网点号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									存款金额&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									信息数量&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									总收费合计金额&nbsp;
								</td>
								
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUIDS" type="checkbox" value="${line.id}" />
										<%-- <input name="zmUUID" type="radio" value="${line.id}" />  --%>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cunkuanren" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cunkuanshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cunkuanyinhang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangdianhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cunkuanjine" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xinxishuliang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="zongshoufeiheji" />
									</td>
								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- 结果一览 end-->
					<div name="page_down" class="page_downuser">
						<div align="right">
							<!-- <jsp:include page="/common/paginationFooter.jsp" /> -->
						</div>
					</div>
				</div>
				<!-- 查询结果 end -->
				<!-- button -->
				<div id="buttonC" name="button" class="content_button" >

				  <html:button property="btnSave" value="提交到历史账目" styleClass="commonButton4" onclick="commonCheckSubmit('reportformsList.do?act=subAccount','UUIDS','请选择要提交的账目')"/>
				  <html:button property="btnSave" value="汇总统计表" styleClass="commonButton3" onclick="commonCheckSubmit('zhangmuDataInsert.do?act=downHuiZongTongJi','UUIDS','请选择要导出汇总统计表的账目！')"/>
				  <html:button property="btnSave" value="收费存款明细" styleClass="commonButton3" onclick="commonCheckSubmit('zhangmuDataInsert.do?act=downCunKuanMingXi','UUIDS','请选择要导出存款明细表的账目！')"/>
				  <html:button property="btnSave" value="电信代收明细" styleClass="commonButton3" onclick="commonCheckSubmit('zhangmuDataInsert.do?act=downDianXinShouFei','UUIDS','请选择要导出电信代收费存款明细表的账目！')"/>
				  <html:button property="btnSave" value="存款银行日记账" styleClass="commonButton4" onclick="commonCheckSubmit('zhangmuDataInsert.do?act=downYHRiJiZhang', 'UUIDS', '请选择要导出的存款银行日记账！')"/>
				
				  <html:button property="btnSave" value="错误退回" styleClass="commonButton2" onclick="commonCheckSubmit('reportformsList.do?act=backAccount','UUIDS','请选要回退的账目数据！')"/>
			  <!--<html:button property="btnSave" value="删除" styleClass="commonButton" onclick="removeData()"/>-->
			  <!--<html:button property="btnSave" value="添加" styleClass="commonButton" onclick="commonSubmit('paigongdanEdit.do?act=initInsert')"/>	-->
			  <!--<html:button property="btnSave" value="解绑" styleClass="commonButton" onclick="removeData1()"/>	-->
			    </div>
			</div>
			<html:hidden name="yonghuDataForm" property="quyuCodeHidden" />
			<html:hidden name="yonghuDataForm" property="addressCodeHidden" />
			<html:hidden name="yonghuDataForm" property="stateCodeHidden" />
			<html:hidden name="yonghuDataForm" property="kaijisHidden" />
			<html:hidden name="yonghuDataForm" property="kaijieHidden" />
			<html:hidden name="yonghuDataForm" property="tingjisHidden" />
			<html:hidden name="yonghuDataForm" property="tingjieHidden" />
			<html:hidden name="yonghuDataForm" property="sen1Hidden" />
			<html:hidden name="yonghuDataForm" property="senValue1Hidden" />
			<html:hidden name="yonghuDataForm" property="sen2Hidden" />
			<html:hidden name="yonghuDataForm" property="senValue2Hidden" />
			<html:hidden name="yonghuDataForm" property="sen3Hidden" />
			<html:hidden name="yonghuDataForm" property="senValue3Hidden" />
			
		</html:form>
	</div>
	</body>
	<script type="text/javascript"  language="javascript">
		function  hiddenEditDiv() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			switch (roleCode) {         
			         case '5': 
			            document.getElementById("buttonC").style.display="";  
			 			break;               
			    	case '4':               
			            document.getElementById("buttonC").style.display="none";  
			            break;    
			    	case '3':               
			            document.getElementById("buttonC").style.display="none";  
			            break;  
			        case '2':               
			            document.getElementById("buttonC").style.display="none";  
			            break; 
					case '1':               
			            document.getElementById("buttonC").style.display="none";  
			            break;  
			        case '6':               
			          	document.getElementById("buttonC").style.display="";  
			            break;        
			} 
		}
		hiddenEditDiv();	
	</script>
</html>
