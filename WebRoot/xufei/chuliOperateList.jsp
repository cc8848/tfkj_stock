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
		<script src="xufei/xufei.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<div style="height:480px;">
		<html:form action="chulidaiweixiuDataList.do">
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					维修待处理
				</div>
				<!-- 查询结果 start -->
				<div name="result" class="conten_result1">
					<!-- 分页头 -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- 结果一览 start-->
					<div name="result_table" class="result_table1">
						<table border="0" cellspacing="0" cellpadding="1" width="100%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									编辑
								</td>
								<td class="tableTitleLine">
									用户状态
								</td>
								<td class="tableTitleLine">
									申请时间
								</td>
								<td class="tableTitleLine">
									小区
								</td>
								<td class="tableTitleLine">
									地址
								</td>	
								<td class="tableTitleLine">
									运营商
								</td>
								<td class="tableTitleLine">
									网络
								</td>
								<td class="tableTitleLine">
									网络账号
								</td>
								<td class="tableTitleLine">
									电视
								</td>
								<td class="tableTitleLine">
									电视账号
								</td>						
								<td class="tableTitleLine">
									备注汇总
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUIDS" type="checkbox" value="${line.id}" />
										
									</td>
									<%-- <td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="${line.id}" />  
									</td> --%>
									<td class="tableContentLine">
										<bean:write name="line" field="yonghuzhuangtai" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="createdt" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="yunyingshang" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="wangluo" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="wangluoip" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="dianshi" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="dianhuaip" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="beizhuhuizong" />
									</td>
								
								</tr>
							</logic:iterate> 
						</table>

					</div>
					<!-- 结果一览 end-->
					<div name="page_down" class="page_downuser">
						<div align="right">
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- 查询结果 end -->
				<!-- button -->
				<div id="buttonC" name="button" class="content_button" >
					<html:button property="btnSave" value="全选" styleClass="commonButton" onclick="isCheck()"/>
				  <html:button property="btnSave" value="处理" styleClass="commonButton2" onclick="shenhe2();"/>
				  <html:button property="btnSave" value="删除" styleClass="commonButton2" onclick="removeData4()"/>
				<!--   <html:button property="btnSave" value="查看详情" styleClass="commonButton2" onclick="commonCheckSubmit('yonghuDataEdit.do?act=showInfo','UUID','请选择待查看的用户数据')"/> -->
			    </div>
			</div>
<!-- 			<html:hidden name="yonghuDataForm" property="quyuCodeHidden" /> -->
		</html:form>
		</div>
	
		
			</body>
	<script type="text/javascript"  language="javascript">
		function  hiddenEditDiv() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			switch (roleCode) {         
			        case '5': 
			 			break;               
			    	 case '4':               
			            document.getElementById("buttonC").style.display="none";  
			            break;       
			} 
		}
		hiddenEditDiv();	
		var allCheck = false;
		
		function isCheck(){
			if(allCheck == false){
				checkAll();
				allCheck = true;
			}else{
				uncheckAll();
				allCheck = false;
			} 
		}
		
		function checkAll() { 
		var code_Values = document.getElementsByTagName("input"); 
			for(var i = 0;i < code_Values.length;i++) {
				if(code_Values[i].type == "checkbox") {
					code_Values[i].checked = true; 
				}
			}
			//alert(arrayCheckId);
		} 
		function uncheckAll() {
			var code_Values = document.getElementsByTagName("input"); 
			for(var i = 0;i < code_Values.length;i++) {
				if(code_Values[i].type == "checkbox") {
					code_Values[i].checked = false; 
				} 
			}
		}
	</script>
</html>
