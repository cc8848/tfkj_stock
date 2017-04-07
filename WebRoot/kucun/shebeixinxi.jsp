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
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="shebeiyichangkuList.do">
	
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					设备历史信息
				</div>
				<!-- 查询条件 -->
				<!-- <div id="conten_query2">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div> -->
				<!-- 查询结果 start -->
				<div name="result" class="conten_result1">
					<!-- 分页头 -->
					<div name="page_up" class="page_up">
						 <jsp:include page="/common/paginationHeader.jsp" /> 
					</div>
					<!-- 结果一览 start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="140%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine" nowrap="nowrap">
									箱号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									设备状态&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									入库日期&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									入库人&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									设备类型&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									设备型号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									小区入库日期&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									入库小区&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									领取人&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									安装地点&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									安装时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									注册位置&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									MAC&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									MCID&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									数据IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									产品库备注&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									小区库备注&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									创建人&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									创建时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									更新人&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									更新时间&nbsp;
								</td>
				
							</tr>
							<logic:iterate id="line"
								           name="com.takucin.aceeci.frame.pagination"
								           property="result"
								           type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="EqBoxNum" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="EqSta_ID" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="EqInTime" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="EqInPerson" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="EqType" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="EqVersion" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="CpInTime" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="CpInName" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="Get_Person" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="Install_site" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="Install_time" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="EqRegister" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="EqMAC" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="EqMCID" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="EqIp" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="rRemark" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="EqRemark" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="Create_person" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="Create_time" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="Update_person" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="Update_time" />
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
					<html:button property="btnSave" value="返回" styleClass="commonButton" onclick="switchPage();"/>
			    </div>
			</div>
			
				<html:hidden name="kucunForm" property="zhuangtaiHidden" styleId="zhuangtai" />
		</html:form>
	</div>
	
	
	</body>
	<script type="text/javascript"  language="javascript">
		function switchPage(){
		
		var zhuangtai = document.getElementById("zhuangtai").value;
		if (zhuangtai == 3){
			commonSubmit('shebeiyichangkuList.do?act=init');
		}
		if (zhuangtai == 2){
			commonSubmit('shebeianzhuangkuList.do?act=init');
		}
		if (zhuangtai == 1){
			commonSubmit('shebeichukuList.do?act=init');
		}
	}
		
	</script>
</html>
