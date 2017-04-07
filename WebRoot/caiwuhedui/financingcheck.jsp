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
		<script src="js/Calendar3.js" language="javascript"></script>
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
		<html:form action="financingcheckList.do">
		<bean:define id="senList" name="zhangmuForm" property="senList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					存款金额核对
				</div>
				<!-- 查询条件 -->
				<div id="conten_query" >
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<td>
								开始时间
							</td>
							<td>
								    <html:text name="zhangmuForm" property="kaijis" styleId="sen1" size="10" onclick="new Calendar().show(this)"/>
							</td>
							<td>
								结束时间
							</td>
							<td>
								    <html:text name="zhangmuForm" property="kaijie" styleId="sen2" size="10" onclick="new Calendar().show(this)" />
							</td>
							<td>
								查询1
							</td>
							<td>
								<html:select name="zhangmuForm" property="sen1"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:options collection="senList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								等于
							</td>
							<td>
								<html:text name="zhangmuForm" property="senValue1" size="12" />
							</td>
							<td>
								核对金额零值
							</td>
							<td>
								<html:checkbox name="zhangmuForm" property="chazhi" ></html:checkbox>
							</td>
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('financingcheckList.do?act=query&zhuangtai=1')" />
							</td>
					</table>
				</div>
				<!-- 查询结果 start -->
				<div name="result" class="conten_result">
					<!-- 分页头 -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- 结果一览 start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="100%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
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
								<td class="tableTitleLine" nowrap="nowrap">
									总金额与已核对的差值&nbsp;
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="zmUUIDS" type="checkbox" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<input name="zmUUID" type="radio" value="${line.id}" />
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
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="chazhi1" />
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

				  <html:button property="btnSave" value="存款核对" styleClass="commonButton2" onclick="commonCheckSubmit('depositVerifyList.do?act=init','zmUUID','请选择要核对的账目！')"/>
				  <html:button property="btnSave" value="提交已核对" styleClass="commonButton3" onclick="commonCheckSubmit('financingcheckList.do?act=subAccount','zmUUIDS','请选择要提交的已核对账目！')"/>
				  <html:button property="btnSave" value="错误退回" styleClass="commonButton2" onclick="commonCheckSubmit('financingcheckList.do?act=backAccount','zmUUID','请选择要退回的账目！')"/>
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
			 			break;               
			    	 case '4':               
			            document.getElementById("buttonC").style.display="none";  
			            break;       
			} 
		}
		hiddenEditDiv();	
	</script>
</html>
