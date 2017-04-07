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
		<script src="yuyue/yuyue.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="yuyuequeryList.do">
		<bean:define id="xiaoquList" name="yuyuequeryForm" property="xiaoquList"></bean:define>
		<bean:define id="quyulist" name="yuyuequeryForm" property="quyulist"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					预约查询
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								预约日期：
							</td>
							<td>
								<html:text name="yuyuequeryForm" property="starriqicode" styleId="starriqicode" size="12" onclick="WdatePicker({el:'starriqicode'})" />
								<img onclick="WdatePicker({el:'starriqicode'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
								到
								<html:text name="yuyuequeryForm" property="endriqicode" styleId="endriqicode" size="12" onclick="WdatePicker({el:'endriqicode'})" />
								<img onclick="WdatePicker({el:'endriqicode'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 		
							</td>
							<td>
								区域名称：
							</td>
							<td>
								<html:select name="yuyuequeryForm" property="xiaoqucode"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:options collection="quyulist" property="key" labelProperty="value" />
							</html:select>
							</td>
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('yuyuequeryList.do?act=query')" />
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
									&nbsp;
								</td>
								<td class="tableTitleLine">
									预约日期
								</td>
								<td class="tableTitleLine">
									小区名称
								</td>
								<td class="tableTitleLine">
									时间
								</td>
								<td class="tableTitleLine">
									安装计划户数
								</td>
								<td class="tableTitleLine" weight="20%">
									安装剩余户数
								</td>
								<td class="tableTitleLine">
									取件计划户数
								</td>
								<td class="tableTitleLine">
									取件剩余户数
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
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<!-- <td class="tableContentLine">
										<bean:write name="line" field="PK_ID" />
									</td> -->
									<td class="tableContentLine">
										<bean:write name="line" field="riqi" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="xiaoqu" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="shijian" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="azjh" />
									</td>
									<td class="tableContentLine">
										<div class="azshengyu">
										<a href="javascript:azpgd('<bean:write name="line" field="riqi" />',
										'<bean:write name="line" field="shijian" />','<bean:write name="line" field="azsy" />','<bean:write name="line" field="xiaoqu" />','0')" >
										<bean:write name="line" field="azsy" />
										</a>
										</div>
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="qjjh" />
									</td>
									<td class="tableContentLine">
										<div class="qjshengyu">
										<a href="javascript:azpgd('<bean:write name="line" field="riqi" />',
										'<bean:write name="line" field="shijian" />','<bean:write name="line" field="qjsy" />','<bean:write name="line" field="xiaoqu" />','1')" >
										<bean:write name="line" field="qjsy" />
										</a>
										</div>
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="yujing" />
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
				<!-- 	<html:button property="btnSave" value="添加" styleClass="commonButton" onclick="commonSubmit('yuyueEdit.do?act=initInsert')"/>
					 <html:button property="btnSave" value="编辑" styleClass="commonButton" onclick="commonCheckSubmit('yuyueEdit.do?act=initEdit','UUID','请选择待编辑的预约项')"/>
					<html:button property="btnSave" value="删除" styleClass="commonButton" onclick="removeData()"/>
				 --></div>
			</div>
			<html:hidden name="yuyuequeryForm" property="riqicodeHidden" />
			<html:hidden name="yuyuequeryForm" property="xiaoqucodeHidden" />
			<html:hidden name="yuyuequeryForm" property="starriqicodeHidden" />
			<html:hidden name="yuyuequeryForm" property="endriqicodeHidden" />
		</html:form>
		</div>
	</body>
	<script>
	azpgd = function(riqi,shijian,num,xiaoqu,qujian){
		//alert(shijian);
		document.forms[0].action = "paigongdanEdit.do?act=azinsertEidt&riqi="+riqi+"&shijian="+encodeURI(encodeURI(shijian))+"&num="+num+"&xiaoqu="+encodeURI(encodeURI(xiaoqu))+"&qujian="+qujian;
		disableAll(document);
		document.forms[0].submit();
		
		}
$("div.azshengyu").each(function(){
	if($(this).text().indexOf("0")==0)
		$(this).css("color","red");
		
});
$("div.qjshengyu").each(function(){
	if($(this).text().indexOf("0")==0)
		$(this).css("color","red");
		
});
</script>
</html>
