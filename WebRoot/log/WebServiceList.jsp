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
		<html:form action="webServiceLog.do">
		<bean:define id="xiaoquList" name="webServiceLogForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					电信接口日志
				</div>
				<!-- 查询条件 -->
				<div id="conten_query2">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td >
								小区
							</td>
							<td>
							
						       <html:select name="webServiceLogForm" property="xiaoqu"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select> 
								
							
							</td>
							<td >
								地址
							</td>
							<td>
								<html:text name="webServiceLogForm" property="dizhi" size="11"></html:text>
							</td>
							<td >
								接口类型
							</td>
							<td>
								<html:select name="webServiceLogForm" property="yonghuzhuangtai"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:option value="安装">安装</html:option>
									<html:option value="退订">退订</html:option>
									<html:option value="修改密码">修改密码</html:option>
									<html:option value="续费">续费</html:option>
									<html:option value="停机">停机</html:option>
									<html:option value="复机">复机</html:option>
								</html:select>
							</td>
							<td >
								调用结果
							</td>
							<td>
								<html:select name="webServiceLogForm" property="interfaceResult"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:option value="1">发送成功</html:option>
									<html:option value="发送失败！">发送失败</html:option>
								</html:select>
							</td>
							<td>
								调用日期
							</td>
							<td>
									<html:text name="webServiceLogForm" property="createDt" styleId="createDt" size="10" onclick="WdatePicker()" />
							</td>
							
							<td>
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('webServiceLog.do?act=query');" />
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
						<table border="0" cellspacing="0" cellpadding="1"  width="100%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine"nowrap="nowrap">
									业务编号
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									小区地址
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									门牌号
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									业务账号
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									业务详情
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									带宽
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									接口类型
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									接口调用详情
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									接口调用结果
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									调用日期
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									流水号
								</td >
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center" class="colorRow" id="<bean:write name="line" field="xmlState" />">
								
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="uuid" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="tradeAccount" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="tradeDetail" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="daikuan" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="yonghuzhuangtai" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="InterfaceDetail" />
									</td>
									<!--  -->
									<td class="tableContentLine edit" height="20"nowrap="nowrap" id="<bean:write name="line" field="id" />">
										<bean:write name="line" field="yonghuzhuangtai" />
										<script type="text/javascript">
											var str = '<bean:write name="line" field="InterfaceResult" />';
											var uuid = '<bean:write name="line" field="id" />';
											
											if(str == '1') {
												$(".edit[id=" + uuid + "]").append("报文发送成功！");
												//$(".edit[id=" + uuid + "]").append("<a href='#' class='resend' name='" + uuid + "' > 重发</a>");
											} else if(str == '2') {
												$(".edit[id=" + uuid + "]").append("数据操作成功！");
												//$(".edit[id=" + uuid + "]").append("<a href='#' class='resend' name='" + uuid + "' > 重发</a>");
											} else if (str == '3') {
												$(".edit[id=" + uuid + "]").append("报文发送失败！");
												//$(".edit[id=" + uuid + "]").append("<a href='#' class='resend' name='" + uuid + "' > 重发</a>");
											} else if (str == '4') {
												$(".edit[id=" + uuid + "]").append("数据操作失败！");
												//$(".edit[id=" + uuid + "]").append("<a href='#' class='resend' name='" + uuid + "' > 重发</a>");
											} else {
												$(".edit[id=" + uuid + "]").append("未知操作结果");
											}
										</script>
									</td>
									<td class="tableContentLine" height="20" nowrap="nowrap">
										<bean:write name="line" field="createDt" />
									</td>
									<td class="tableContentLine" height="20" nowrap="nowrap">
										<bean:write name="line" field="xmlId" />
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
	</body>
	<script type="text/javascript">
		$().ready(function() {
			$(".colorRow[id='1']").css("color", "red");
			
			$(".resend").live("click", function() {
				var uuid = ($(this).attr("name"));
				$.ajax({
					url:"reSendXml.do?act=reSend",
					type : "POST",
					cache:false,
					data:{
						'uuid':uuid
					},
					success: function(data){
						if(data == '0') {
							alert("发送成功！请刷新列表！");
							
						} else {
							alert(data);
							return false;
						}
						
					}
				});
			});
			
		});
	
	</script>
</html>
