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
		<script type="text/javascript">
		//创建XMLHttpRequest对象   
		function createXMLHttpRequest() {
			if (window.XMLHttpRequest) { //Mozilla 浏览器
				XMLHttpReq = new XMLHttpRequest();
			} else {
				if (window.ActiveXObject) { // IE浏览器			
					try {
							XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
						} 
					catch (e) {
							try {
								XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
							} 
							catch (e){}
						}
				}
			}
		}
		//发送请求
		function sendRequest(url, params, method) {
			if (method) {
				if (method.toLowerCase("post")) {
					sendRequestPost(url, params);
				} else {
					if (method.toLowerCase("get")) {
						sendRequestGet(url + "?" + params);
					} else {
					}
				}
			} else {
				alert("\u63d0\u4ea4\u65b9\u5f0f\u4e0d\u80fd\u4e3a\u7a7a\uff01");
			}
		}
		//post发送请求函数
		function sendRequestPost(url, params) {
			params=encodeURI(params); 
	        params=encodeURI(params);  
			createXMLHttpRequest();
			XMLHttpReq.open("POST", url, true);
			XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
			XMLHttpReq.setRequestHeader("Content-Type" , "application/x-www-form-urlencoded ; charset=GBK");
			XMLHttpReq.send(params); // 发送请求
		}
		//get发送请求函数
		function sendRequestGet(url) {
			createXMLHttpRequest();
			XMLHttpReq.open("GET", url, true);
			XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
			XMLHttpReq.send(null); // 发送请求
		}
		//post发送请求函数(无需传递参数时)
		function sendRequestPostwihtnoArgs(url) {
			createXMLHttpRequest();
			XMLHttpReq.open("POST", url, true);
			XMLHttpReq.onreadystatechange = processResponse;//指定回调函数
			XMLHttpReq.send(null); // 发送请求
		}
		// 处理返回信息函数
		function processResponse() {
			if (XMLHttpReq.readyState == 4) { // 判断对象状态
				if (XMLHttpReq.status == 200) { //信息已经成功返回，开始处理信息
				//返回1文件不存在。返回0文件存在。
					var res = XMLHttpReq.responseText;
					var isres = res.slice(0, 1);
					if(isres == 1) {
						alert("数据导出异常！");
					} 
					if(isres == 0) {
						res = res.slice(1, res.length);
						window.location.href='http://'+res+':8080/tfkj_stock/excel/gongzuoliang.xls';
					}
				} else { 
					
				}
			}
		}
		//commonSubmit('importExcelList.do?act=downExcel')
		function findStubyClasslId() {
				var sURL = "importExcelList.do?act=downExcel";
				var method = "post";
				var sParams = "";
				sendRequest(sURL, sParams, method);
	}
	</script>
	</head>
	<body onload="init()">
		<html:form action="gongzuoliangList.do" >
		<bean:define id="xiaoquList" name="totalForm" property="xiaoquList"></bean:define>
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
								<script >
								var  arrayObj = new Array();
								</script>
								<logic:iterate  id="xiaoquList" name="totalForm"  property="xiaoquList" >
								 	<script  >
									 var temp = '<bean:write  name="xiaoquList"  property="key" />' ;
									 arrayObj.push(temp);
									</script> 
								 </logic:iterate> 
								<input type="button" value="小区选择" onclick="show_child();"/>
								<html:textarea name="totalForm" property="xiaoqutext" rows="1" cols="30"  readonly="true"></html:textarea>
								 <script> 
								function show_child() 
								{ 
								var child=window.showModalDialog('total/modal.htm',arrayObj,'dialogWidth=760px ; dialogHeight=500px');
									 if(!child.closed) 
									 { 
										if(!window.close()) 
										{ 
											//document.getElementById("txt0").value = child;
											//alert(child);
											document.forms[0].xiaoqutext.value = child;
										} 
										else 
										{ 
											window.close(); 
											child.close(); 
										} 
									}
								} 
								</script> 
							</td>
							<td width="60px">
								时间类型
							</td>
							<td>
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
							    
							</td>
							<td>
								开始时间
							</td>
							<td>
								<html:text name="totalForm" property="kaijis" styleId="kaijis" size="10" onclick="WdatePicker({el:'kaijis'})" />
								<img onclick="WdatePicker({el:'kaijis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
							    
							</td>
							<td>
								结束时间
							</td>
							<td>
								<html:text name="totalForm" property="kaijie" styleId="kaijie" size="10" onclick="WdatePicker({el:'kaijie'})" />
								<img onclick="WdatePicker({el:'kaijie'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
							    
							</td>
						
							
							<td align="right">
								<input type="button" value="统计" class="commonButton" onclick="sub();" />
								  <html:button property="btnSave" value="下载" styleClass="commonButton" onclick="findStubyClasslId();"/>
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				
				<!-- 查询结果 start -->
				<div  class="conten_result4">
					<!-- 分页头 -->
					<div  class="page_up">
						<!--  <jsp:include page="/common/paginationHeader.jsp" />  -->
					</div>
					
					<!-- 结果一览 start-->
					<div  class="result_table3">
					
						<table border="0" cellspacing="0" cellpadding="1"  width="100%">
						<tr bgcolor="#EEF5FA" align="center">
							<td class="tableTitleLine" nowrap="nowrap" colspan="1" rowspan="2" >
								日期
							</td >
							<td class="tableTitleLine" nowrap="nowrap" colspan="1"  rowspan="2">
								小区名称
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1" rowspan="2">
								开户人姓名
							</td >
							
							<td class="tableTitleLine"nowrap="nowrap" colspan="7" rowspan="1">
								安装数
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1" rowspan="2" >
								维修数(包括收件）
							</td >
							<td class="tableTitleLine"nowrap="nowrap" rowspan="2" colspan="1" >
								续费
							</td >
							<td class="tableTitleLine"nowrap="nowrap" rowspan="2" colspan="1">
								退订
							</td >
							
						</tr>
						<tr bgcolor="#EEF5FA" align="center">
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								电视
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								宽带
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								电话
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								单宽
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								套餐
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								入户数
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								首次入户数
							</td >
						</tr>
						

						<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="riqi" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="shigongren" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="dianshi" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="kuandai" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="dianhua" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="dankuan" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="taocan" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="ruhushu" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="shoucirujushu" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="weixiushu" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="xufei" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="tuiding" /> 
									</td >
									
								</tr>
						</logic:iterate>
						</table>
					</div>
					
					<!-- 结果一览 end-->
					<div name="page_down" class="page_down">
						<div align="right">
						 <!-- 	<jsp:include page="/common/paginationFooter.jsp" />  -->
						</div>
					</div>
				</div>
			</div>
			<html:hidden name="totalForm" property="xiaoquHidden" />
			<html:hidden name="totalForm" property="kaijisHidden" />
			<html:hidden name="totalForm" property="kaijieHidden" />
			<html:hidden name="totalForm" property="shijianleixingHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	function sub(){
			if(checkInput()) {
					commonSubmit('gongzuoliangList.do?act=query');
				}
			}
			
		checkInput = function()
		{
	  		var kaijis = document.forms[0].kaijis.value;
			var kaijie = document.forms[0].kaijie.value;
			if ((kaijis != null || trim(kaijis) != "") && (kaijie == null || trim(kaijie) == "")) {
					alert("结束时间不能为空！");
					document.forms[0].kaijis.focus();//设置焦点
					return false;
			}
				
			if ((kaijis == null || trim(kaijis) == "") && (kaijie != null || trim(kaijie) != "")) {
					alert("开始时间不能为空！");
					document.forms[0].kaijis.focus();//设置焦点
					return false;
			} 
		    var shijianleixing = document.forms[0].shijianleixing.value;
		    if (trim(shijianleixing) == "") {
					alert("请选择时间类型！");
					document.forms[0].shijianleixing.focus();//设置焦点
					return false;
			} 
			
			var d = DateDiff(kaijis, kaijie);
			if (d > 40) {
				alert("时间跨度大于40天，请重新选择结束时间！");
				return false;
			}
			/* if(tingjis<kaijis)
			{
				alert("结束时间请大于开始时间！");
				return false;
			}  */
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
		 
		  function autoSubimit(){
				if (event.keyCode == 13) {
					sub();
				}
			}
	</script>
</html>
