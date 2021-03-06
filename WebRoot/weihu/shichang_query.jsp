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
		<script src="weihu/weihu.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="shichangList.do">
				
				<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					时长信息
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
									时长名称&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									时长类型&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									带宽&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									时长(月)&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									金额&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									序号&nbsp;
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shichangName" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="leixing" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="daikuan" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shichangyue" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="jine" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="seq" />
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
				<div id="buttonC"  class="content_button" style="display: none" >

				  <html:button property="btnSave" value="新增" styleClass="commonButton2" onclick="commonSubmit('shichangEdit.do?act=insert')"/>
				  <html:button property="btnSave" value="编辑" styleClass="commonButton2" onclick="commonCheckSubmit('shichangEdit.do?act=edit','UUID','请选择要编辑的时长类型！')"/>
				  <html:button property="btnSave" value="删除" styleClass="commonButton2" onclick="removeData1()"/>
				
			  <!--<html:button property="btnSave" value="删除" styleClass="commonButton" onclick="removeData()"/>-->
			  <!--<html:button property="btnSave" value="添加" styleClass="commonButton" onclick="commonSubmit('paigongdanEdit.do?act=initInsert')"/>	-->
			  <!--<html:button property="btnSave" value="解绑" styleClass="commonButton" onclick="removeData1()"/>	-->
			    </div>
			</div>
		
			
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
				} 
			}
			hiddenEditDiv();
	</script>
</html>
