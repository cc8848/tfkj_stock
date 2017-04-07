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
		<html:form action="incometotalList.do?act=query" method="post" >
		<bean:define id="xiaoquList" name="totalForm" property="xiaoquList"></bean:define>
		<bean:define id="stateList" name="totalForm" property="stateList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					统计数据
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
			
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								小区名称：
							</td>
							<td>
								<html:select name="totalForm" property="xiaoqu" styleId="xiaoqu"
									styleClass="commonTextFieldHover"  onkeydown="autoSubimit()"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">--请选择--</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								状态
							</td>
							<td>
								<html:select name="totalForm" property="stateCode" styleId="stateCode"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:options collection="stateList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								开始时间
							</td>
							<td>
							    <html:text name="totalForm" property="kaijis" styleId="kaijis" size="10" onclick="WdatePicker({el:'kaijis'})" />
								<img onclick="WdatePicker({el:'kaijis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							</td>
							
						   <td>
								结束时间
							</td>
							<td>
							    <html:text name="totalForm" property="tingjis" styleId="tingjis" size="10" onclick="WdatePicker({el:'tingjis'})" />
								<img onclick="WdatePicker({el:'tingjis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							</td> 
							
							<td align="right">
								<input type="button" value="统计" class="commonButton" onclick="sub();" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				
				<!-- 查询结果 start -->
				<div  class="conten_result">
					<!-- 分页头 -->
					<div  class="page_up">
					</div>
					
					<div  class="result_table">
					<bean:define id="size" name="totalForm" property="wideSize"></bean:define>
					<bean:define id="pathA" name="totalForm" property="pathA"></bean:define>
					<bean:define id="pathB" name="totalForm" property="pathB"></bean:define>
						<img width="<bean:write name="size"/>" height="190" src="<bean:write name="pathA"/>" alt="total"  /> 
						<hr width="<bean:write name="size"/>"/>
						<img width="<bean:write name="size"/>" height="190" src="<bean:write name="pathB"/>" alt="total"  /> 
					<!-- 结果一览 start-->
						<table border="0" cellspacing="0" cellpadding="1"  width="100%">
						</table>
					</div>
					
					<!-- 结果一览 end-->
					<div name="page_down" class="page_down">
						<div align="right">
						</div>
					</div>
				</div>
			<html:hidden name="totalForm" property="xiaoquHidden" />
			<html:hidden name="totalForm" property="kaijisHidden" />
			<html:hidden name="totalForm" property="tingjisHidden" />
			<html:hidden name="totalForm" property="stateCodeHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	
		function sub(){
			if(checkInput())
				{
					commonSubmit('incometotalList.do?act=query');
				}
			}
			
		checkInput = function()
		{
			var kaijis = document.forms[0].kaijis.value;
			if(kaijis==null||trim(kaijis)=="")
				{
					alert("开始时间不能为空！");
					document.forms[0].kaijis.focus();//设置焦点
					return false;
				}
		
			var tingjis = document.forms[0].tingjis.value;
			if(tingjis==null||trim(tingjis)=="")
				{
					alert("结束时间不能为空！");
					document.forms[0].tingjis.focus();//设置焦点
					return false;
				}
			
			if(tingjis<kaijis)
			{
				alert("结束时间请大于开始时间！");
				return false;
			}
				return true;
		 } ;
		 
		  function autoSubimit(){
				if (event.keyCode == 13) {
					sub();
				}
			}
	</script>
</html>
