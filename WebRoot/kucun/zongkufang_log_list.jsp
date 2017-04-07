<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2015-12-15   Dai-Zhen           Create
   
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
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<script src="js/Calendar3.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="zongkufangLogList.do">
		<bean:define id="xiaoquList" name="zongkufangInfoForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					总库房日志
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
					<tr>
							<td width="60px">
								操作类型
							</td>
							<td>
								<html:select name="zongkufangInfoForm" property="operateType"
									styleClass="commonTextFieldHover"  
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value=""  >-请选择-</html:option>
									<html:option value="入库">入库</html:option>
									<html:option value="出库">出库</html:option>
								</html:select>
							</td>
							<td width="65px">
								出入库时间
							</td>
							<td>
								<html:text name="zongkufangInfoForm" property="operateTime" styleId="operateTime" size="10" onclick="new Calendar().show(this)" />
							</td>
							<td width="65px">
								出入库库房
							</td>
							<td>
								<html:select style="width:80px" name="zongkufangInfoForm" property="operateStore"
										styleClass="commonTextFieldHover" 
										onfocus="this.className='commonTextFieldMove';"
										onblur="this.className='commonTextFieldHover'">
										<html:option value="">-请选择-</html:option>
										<html:options collection="xiaoquList" property="key" labelProperty="value" />
									</html:select>	
								</td>
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('zongkufangLogList.do?act=init')" />
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
									操作类型
								</td>
								<td class="tableTitleLine">
									总库房ID
								</td>
								<td class="tableTitleLine">
									出入库时间
								</td>
								<td class="tableTitleLine">
									数量
								</td>
								<td class="tableTitleLine">
									出入库库房
								</td>
								<td class="tableTitleLine">
									备注信息
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine">
										<bean:write name="line" field="OperateType" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="OperateinfoId" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="OperateTime" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="OperateSuu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="OperateStore" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="Remark" />
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
			</div>
		</html:form>
		</div>
	</body>
<script>
</script>
</html>
