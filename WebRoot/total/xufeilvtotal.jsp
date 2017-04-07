<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>快速开发框架演示项目</title>
		<script language="javascript" type="text/javascript"
			src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js">
</script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript">
</script>
		<script src="js/validate.js" language="javascript">
</script>
		<script src="js/jquery.js" language="javascript">
</script>
		<script src="js/popupBox.js" language="javascript">
</script>
		<script src="js/business.js" language="javascript">
</script>
		<jsp:include page="/common/commonMessage.jsp" />

	</head>
	<body onload="init()">
		<html:form action="xufeilv.do" method="post">
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top">
					明细统计
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">

					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td width="400px">
								<script>
var arrayObj = new Array();
</script>
								<logic:iterate id="xiaoquList" name="xufeilvForm"  property="xiaoquList">
									<script>
var temp = '<bean:write  name="xiaoquList"  property="key" />';
arrayObj.push(temp);
</script>
								</logic:iterate>
								<input type="button" value="小区选择" onclick="show_child();" />
								<html:textarea name="xufeilvForm" property="xiaoqutext" rows="1"
									cols="30" readonly="true"></html:textarea>
								<script>
function show_child() {
	var child = window.showModalDialog('total/modal.htm', arrayObj,
			'dialogWidth=760px ; dialogHeight=500px');
	if (!child.closed) {
		if (!window.close()) {
			//document.getElementById("txt0").value = child;
			//alert(child);
			document.forms[0].xiaoqutext.value = child;
		} else {
			window.close();
			child.close();
		}
	}
}
</script>
							</td>
							<td>
								
								开始时间
								<html:text name="xufeilvForm" property="kaijis" styleId="kaijis"
									size="10" onclick="WdatePicker({el:'kaijis'})" />
								<img onclick="WdatePicker({el:'kaijis'})"
									src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif"
									width="16" height="22" align="absmiddle" />

								结束时间
								<html:text name="xufeilvForm" property="kaijie" styleId="kaijie"
									size="10" onclick="WdatePicker({el:'kaijie'})" />
								<img onclick="WdatePicker({el:'kaijie'})"
									src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif"
									width="16" height="22" align="absmiddle" />

							</td>
							<td align="right">
								<input type="button" value="统计" class="commonButton"
									onclick="sub();" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display: none;">
					</div>
				</div>
				<!-- 查询结果 start -->
				<div class="conten_result">
					<!-- 分页头 -->
					
					<div class="result_table">
					<table border="0" cellspacing="0" cellpadding="1" width="100%">
						  <tr bgcolor="#EEF5FA" align="center">
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%" rowspan="3">小区</td>
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" colspan="6"><bean:write name="xufeilvForm" property="kaijis" />到<bean:write name="xufeilvForm" property="kaijie" /></td>
						  </tr>
						  <tr bgcolor="#EEF5FA" align="center">
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" colspan="3">宽带业务</td>
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" colspan="3">电视业务</td>
						  </tr>
						  <tr bgcolor="#EEF5FA" align="center">
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%">续费数</td>
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%">到费数</td>
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%">续费率(%)</td>
						   	<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%">续费数</td>
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%">到费数</td>
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%">续费率(%)</td>
						  </tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xufeishuwangluo" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="hejizhiwangluo" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xufeilvwangluo" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xufeishudianshi" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="hejizhidianshi" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xufeilvdianshi" />
									</td>
								</tr>
							</logic:iterate>
						</table>
					</div>
					<!-- 结果一览 end-->
					</div>
				</div>
			</div>
			<html:hidden name="xufeilvForm" property="xiaoqutextHidden" />
			<html:hidden name="xufeilvForm" property="kaijisHidden" />
			<html:hidden name="xufeilvForm" property="kaijieHidden" />

		</html:form>
		<script type="text/javascript">
//导出excle
function exportNoBind(){
	document.forms[0].action = 'mingxitotalListDaochu.do?act=export';
 	document.forms[0].submit();
}		
function sub() {
	var xiaoquname = document.forms[0].xiaoqutext.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("用户小区不能为空！");
		document.forms[0].xiaoqutext.focus();// 设置焦点
		return false;
	}
	var kaijis = document.forms[0].kaijis.value;
	if (kaijis == null || trim(kaijis) == "") {
		alert("开始时间不能为空！");
		document.forms[0].kaijis.focus();// 设置焦点
		return false;
	}
	var kaijie = document.forms[0].kaijie.value;
	if (kaijie == null || trim(kaijie) == "") {
		alert("结束时间不能为空！");
		document.forms[0].kaijie.focus();// 设置焦点
		return false;
	}
		commonSubmit('xufeilv.do?act=query');
	
}

checkInput = function() {
	 		var kaijis = document.forms[0].kaijis.value;
		var tingjis = document.forms[0].kaijie.value;
	var type=document.forms[0].shijianleixing.value;
	if(type!=""){
		
		if((kaijis!=null||trim(kaijis)!="") &&(tingjis==null||trim(tingjis)==""))
			{
				alert("结束时间不能为空！");
				document.forms[0].kaijis.focus();//设置焦点
				return false;
			}
			
		if((kaijis==null||trim(kaijis)=="") &&(tingjis!=null||trim(tingjis)!=""))
			{
				alert("开始时间不能为空！");
				document.forms[0].kaijis.focus();//设置焦点
				return false;
			} 

	 if(tingjis<kaijis)
	{
		alert("结束时间请大于开始时间！");
		return false;
	}  
	 var d = DateDiff(kaijis, tingjis);
			if (d > 370) {
				alert("时间跨度大于370天，请重新选择结束时间！");
				return false;
			}
	}
	return true;
};
function DateDiff(sDate1,sDate2) { 
		    var arrDate,objDate1,objDate2,intDays;
		    arrDate=sDate1.split("-");
		    objDate1=new Date(arrDate[1]+'-'+arrDate[2]+'-'+arrDate[0]);
		    arrDate=sDate2.split("-");
		    objDate2=new Date(arrDate[1] + '-'+arrDate[2]+'-'+arrDate[0]);
		    intDays=parseInt(Math.abs(objDate1-objDate2)/1000/60/60/24);
		    return intDays;
		}
function autoSubimit() {
	if (event.keyCode == 13) {
		sub();
	}
}
</script>
	</body>
</html>
