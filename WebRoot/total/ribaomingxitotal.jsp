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
		<html:form action="mingxitotalList.do" method="post">
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top">
					明细统计
 <a href="shuliangtotalList.do?act=init" target="content">数量统计</a>
  <a href="shourutotalList.do?act=init" target="content">收入统计</a>
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">

					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td width="400px">
								<script>
var arrayObj = new Array();
</script>
								<logic:iterate id="xiaoquList" name="totalForm"  property="xiaoquList">
									<script>
var temp = '<bean:write  name="xiaoquList"  property="key" />';
arrayObj.push(temp);
</script>
								</logic:iterate>
								<input type="button" value="小区选择" onclick="show_child();" />
								<html:textarea name="totalForm" property="xiaoqutext" rows="1"
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
							<td width="450px">
								<script>
var arraygzlb = new Array();
</script>
								<logic:iterate id="gzlb" name="totalForm"  property="gongzuoleibieList">
									<script>
var temp = '<bean:write  name="gzlb"  property="key" />';
arraygzlb.push(temp);
</script>
								</logic:iterate>
								<input type="button" value="工作类别" onclick="show_gzlb();" />
								<html:textarea name="totalForm" property="gongzuoleibie"
									rows="1" cols="30" readonly="true"></html:textarea>
								<script>
function show_gzlb() {
	var child = window.showModalDialog('total/gongzuoleibie.htm', arraygzlb,
			'dialogWidth=760px ; dialogHeight=500px');
	if (!child.closed) {
		if (!window.close()) {
			//document.getElementById("txt0").value = child;
			//alert(child);
			document.forms[0].gongzuoleibie.value = child;
		} else {
			window.close();
			child.close();
		}
	}
}
</script>
							</td>
						</tr>
						<tr>
							<td width="400px">
								<script>
var arrayyys = new Array();
arrayyys.push('天房');
arrayyys.push('电信');
arrayyys.push('联通');
arrayyys.push('铁通');
arrayyys.push('广电');
</script>
								<input type="button" value="运营商" onclick="show_yys();" />
								<html:textarea name="totalForm" property="yunyingshang" rows="1"
									cols="30" readonly="true"></html:textarea>
								<script>
function show_yys() {
	var child = window.showModalDialog('total/yunyingshang.htm', arrayyys,
			'dialogWidth=760px ; dialogHeight=500px');
	if (!child.closed) {
		if (!window.close()) {
			//document.getElementById("txt0").value = child;
			//alert(child);
			document.forms[0].yunyingshang.value = child;
		} else {
			window.close();
			child.close();
		}
	}
}
</script>
							</td>
							<td>
								时间类型
								<html:select name="totalForm" property="shijianleixing"
									styleClass="commonTextFieldHover"
									onfocus="this.className='commonTextFieldMove'"
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:option value="1">开机时间</html:option>
									<html:option value="2">停机时间</html:option>
									<html:option value="3">收款日期</html:option>
									<html:option value="4">有效时间</html:option>
								</html:select>
								开始时间
								<html:text name="totalForm" property="kaijis" styleId="kaijis"
									size="10" onclick="WdatePicker({el:'kaijis'})" />
								<img onclick="WdatePicker({el:'kaijis'})"
									src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif"
									width="16" height="22" align="absmiddle" />

								结束时间
								<html:text name="totalForm" property="kaijie" styleId="kaijie"
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
					<div class="page_up">
					<jsp:include page="/common/paginationHeader.jsp" />
					</div>

					<!-- 结果一览 start-->
					<div class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="200%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine" nowrap="nowrap" colspan="8">
									基本信息
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap"
									colspan="3">
									业务类型
								</td>
								<td bgcolor="#afdfe4" class="tableTitleLine" nowrap="nowrap"
									colspan="10">
									费用
								</td>
								<td bgcolor="#FFFF00" class="tableTitleLine" nowrap="nowrap"
									colspan="2">
									财务记录
								</td>
							</tr>
							<tr bgcolor="#EEF5FA" align="center">
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									开机时间
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									停机时间
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									收款时间
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									小区
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									小区地址
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									运营商
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									工作类别
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									施工人
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									宽带
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									电视
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									电话
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									ONU押金
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									机顶盒押金
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									收视费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									宽带费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									初装费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									设备销售费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									材料费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									不足月够费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									年费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									合计费用
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									收据账本号/收据号
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									开票信息
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="kaijishijian" format="yyyy-MM-dd" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="tingjishijian" format="yyyy-MM-dd"/>
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="shoukuanshijian" format="yyyy-MM-dd"/>
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="yunyingshang" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="gongzuoleibie" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="shigongren" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="wangluo" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="dianshi" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="dianhua" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="onuyj" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="jidingheyj" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="shoushifei" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="kuandaifei" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="chuzhuangfei" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="shebeixiaoshou" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="cailiaofei" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="bzygf" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="nianfei" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="hejifeiyong" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="shoujubenhao" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="kaipiaoxinxi" />
									</td>
								</tr>
							</logic:iterate>
						</table>
					</div>

					<!-- 结果一览 end-->
					<div class="page_down">
						<div align="right">
						<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<div name="button" class="content_button">
					<input type="button" class="commonButton2" value="导出报表" onclick="exportNoBind();"/>
				</div>
			</div>
			<html:hidden name="totalForm" property="xiaoqutextHidden" />
			<html:hidden name="totalForm" property="gongzuoleibiehidden" />
			<html:hidden name="totalForm" property="yunyingshanghidden" />
			<html:hidden name="totalForm" property="xiaoquHidden" />
			<html:hidden name="totalForm" property="shijianleixingHidden" />
			<html:hidden name="totalForm" property="kaijisHidden" />
			<html:hidden name="totalForm" property="kaijieHidden" />

		</html:form>
		<script type="text/javascript">
//导出excle
function exportNoBind(){
	document.forms[0].action = 'mingxitotalListDaochu.do?act=export';
 	document.forms[0].submit();
}		
function sub() {
	if (checkInput()) {
		commonSubmit('mingxitotalList.do?act=query');
	}
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
