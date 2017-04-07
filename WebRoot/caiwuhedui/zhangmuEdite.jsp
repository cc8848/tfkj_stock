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
		<script src="caiwuhedui/caiwu.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="editeAccountsMateList.do">
		<bean:define id="xiaoquList" name="zhangmuForm" property="xiaoquList"></bean:define>
		<bean:define id="statusList" name="zhangmuForm" property="statusList"></bean:define>
		<bean:define id="senList" name="zhangmuForm" property="senList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					编辑账目
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table"  align="center" cellpadding="1" cellspacing="1" border="1">
						<tr  align="center">
							<td width="60px">
								<font style="font-weight: bold;">存款人:</font>
							</td>
							<td>
							<html:text name="zhangmuForm" property="cunkuanren" readonly="true" size="8"/>
							</td >
							
							<td width="60px">
								<font style="font-weight: bold;">存款时间:</font>
							</td>
							<td >
								<html:text name="zhangmuForm" property="cunkuanshijian" readonly="true" size="10"/>
							</td>
							
							<td width="60px">
								<font style="font-weight: bold;">存款银行:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="cunkuanyinhang" readonly="true" size="8"/>
							</td >
							
							<td width="60px">
								<font style="font-weight: bold;">网点号:</font>
							</td >
							<td>
								<html:text name="zhangmuForm" property="wangdianhao" readonly="true" size="8"/>
							</td>
							
							<td width="60px">
								<font style="font-weight: bold;">存款金额:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="cunkuanjine" readonly="true" size="6"/>
							</td>
							<td width="100px">
								<font style="font-weight: bold;">总收费合计金额:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="zongshoufeiheji" readonly="true" size="6"/>
							</td>
							<td width="45px">
								<font style="font-weight: bold;">差值:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="chazhi" readonly="true" size="6"/>
							</td>
							<td width="60px">
								<font style="font-weight: bold;">信息数量:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="xinxishuliang" readonly="true" size="4"/>
							</td>
						</tr>
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
						<table border="0" cellspacing="0" cellpadding="1" width="140%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									核对状态&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收款类型&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									用户状态&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收款时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									姓名&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									小区&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									地址&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									开机时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									停机时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									网络&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									电视&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									电话&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									业务&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									总收费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收据本号/收据号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									开票信息&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									onu押金&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									机顶盒押金&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收视费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									宽带费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									初装费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									不足月费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									年费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									设备销售费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									材料费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									备注&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									施工人&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									现场备注&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									备注汇总&nbsp;
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap" id="${line.id}">
										<bean:write name="line" field="hedui" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="zhifuleixing" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yonghuzhuangtai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoukuanshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xingming" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaijishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="tingjishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangluo" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianshi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianhua" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yewu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap" >
										<bean:write name="line" field="zongshoufei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoujubenhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaipiaoxinxi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="onuyj" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="jidingheyj" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoushifei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kuandaifei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="chuzhuangfei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="bzygf" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="mianban" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shebeixiaoshou" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cailiaofei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="beizhu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shigongren" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xianchangbeizhu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="beizhuhuizong" />
									</td>
								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- 结果一览 end-->
					<div name="page_down" class="page_downuser">
						<div align="right"  >
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- 查询结果 end -->
				<!-- button -->
				<div id="buttonC" name="button" class="content_button" >
				 <!--  <html:button property="btnSave" value="保存" styleClass="commonButton" onclick="commonCheckSubmit('zhangMuEdit.do?act=insertPipeiZhangmu','UUIDS','请选择待匹配的数据')"/> -->
				  <html:button styleId="buttonA" property="btnSave" value="删除" styleClass="commonButton" onclick="removeData2();"/>
				  <html:button styleId="buttonB" property="btnSave" value="返回" styleClass="commonButton" onclick="commonSubmit('moneymateList.do?act=init&zhuangtai=0')"/>
			    </div>
			</div>
			<html:hidden name="zhangmuForm" property="quyuCodeHidden" />
			<html:hidden name="zhangmuForm" property="addressCodeHidden" />
			<html:hidden name="zhangmuForm" property="stateCodeHidden" />
			<html:hidden name="zhangmuForm" property="kaijisHidden" />
			<html:hidden name="zhangmuForm" property="sen1Hidden" />
			<html:hidden name="zhangmuForm" property="senValue1Hidden" />
			<html:hidden name="zhangmuForm" property="zhangmuUUIDHidden" />
			<html:hidden name="zhangmuForm" property="zongshoufeiHidden" />
			<html:hidden name="zhangmuForm" property="UUIDHidden" />
			<html:hidden name="zhangmuForm" property="zhifuleixingHidden" />

		</html:form>
	</div>
	</body>
	<script type="text/javascript"  language="javascript">
		function  hiddenEditDiv() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			switch (roleCode) {         
			        case '5': 
			 			break;              
		             default:               
		                document.getElementById("buttonA").style.display="none";  
		                break;        
			} 
		}
		hiddenEditDiv();	
		
	</script>
</html>
