<!---->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>快速开发框架演示项目</title>
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
		%>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/common.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="paigongdan/paigongdan.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<style type="text/css">
		body {
			margin: 20px auto;
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			width: 950px;
			height: 400px;
			border: solid 1px #aaa;
			position: relative;
			padding: 10px;
		}
		
		ul {
			margin: 0;
			padding: 0;
			list-style: none;
		}
		
		.dropDownList {
			position: absolute;
			left: 610px;
			top: 28px;
		}
		
		.dropDownList div.dropdown {
			float: left;
			margin-right: 120px;
			width: 146px;
			height: 200px;
			overflow: auto;
			overFlow-x: hidden;
		}
		
		.dropDownList span {
			display: block;
			width: 146px;
			height: 26px;
			background: url() left top no-repeat;
			line-height: 26px;
			text-indent: 12px;
			border: solid 1px #83BBD9;
			cursor: default;
		}
		
		.dropDownList span.over {
			background-position: left bottom;
			border-color: #B4C91A;
		}
		
		.dropDownList ul {
			background: #eee;
			width: 200px;
			display: none;
			height: 20px;
		}
		
		.dropDownList ul li {
			height: 20px;
			width: 100%;
			padding: 3px 0;
			text-indent: 12px;
			cursor: default;
		}
		
		.dropDownList ul li.over {
			background: #ccc;
		}
		
		.dropDownList ul.show {
			display: block;
		}
		</style>
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
					var res = XMLHttpReq.responseText;
					if(res.length < 1){
						hiddenUI();
						return;
					}
					var content=document.getElementById("ul1");
					for (var i=content.childNodes.length-1 ; i>=0 ; i--) {
						var childNode = content.childNodes[i];
						content.removeChild(childNode);
					} 
					__initDropDownList(res);
				} else { 
					//页面不正常
					var content=document.getElementById("ul1");
					for (var i=content.childNodes.length-1 ; i>=0 ; i--) {
						var childNode = content.childNodes[i];
						content.removeChild(childNode);
					} 
					hiddenUI();
				}
			}
		}
		function findStubyClasslId() {
			var xiaoqu = document.forms[0].xiaoqu.value;
			var dizhi = document.forms[0].dizhi.value;
			if(dizhi.length > 2){
				var sURL = "allStu.do?act=test";
				var method = "post";
				var sParams = "xiaoqu=" + xiaoqu + "&dizhi=" + dizhi;
				sendRequest(sURL, sParams, method);
		 }
	}
	function selectdevice() {
		var selectxiaoqu = document.getElementById("selectxiaoqu").value;
		selectxiaoqu = encodeURI(encodeURI(selectxiaoqu));
		window.open('<%=basePath%>shebeichukuList.do?act=init&selectkbn=1&selectxiaoqu='+selectxiaoqu,'newwindow','height=500px,width=880px,top=150,left=300,toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no'); 
	}
	function afterselect() {
		document.getElementById("selectxiaoquhidden").value = document.getElementById("selectxiaoqu").value;
		document.getElementById("selectxiaoqu").disabled = "disabled";
		document.getElementById("selectxiaoquhidden").disabled = "";
	}
	function backtodept() {
		var communityPID = document.getElementById("selectCommunityPileID").value;
		var communityPID2 = document.getElementById("selectCommunityPileID2").value;
		document.getElementById("btnDeviceBack").disable = "disable";
		$.ajax({
			url:"shebeichukuList.do?act=backtodept",
			type : "POST",
			cache:false,
			data:{
				'uuid':communityPID,
				'uuid2':communityPID2
			},
			success: function(data){
				if(data == '0') {
					alert("设备回库成功！");
					document.getElementById("selectCommunityPileID").value = "0";
					document.getElementById("selectCommunityPileID2").value = "0";
					document.getElementById("fenguang").value = "";
					document.getElementById("onumac").value = "";
					document.getElementById("stbmcid").value = "";
					document.getElementById("dianshiip").value = "";
					document.getElementById("eqboxnum").value = "";
					document.getElementById("eqboxnum2").value = "";
					document.getElementById("selectxiaoqu").disabled = "";
					document.getElementById("selectxiaoquhidden").disabled = "disabled";
					sub();
				} else {
					alert(data);
					return false;
				}
			}
		});
	}
	</script>
	</head>
	<body onload="init()" id="body1">  
		<html:form action="shenqingDataEdit.do">
			<bean:define id="xiaoquList" name="jiaofeiDataFrom" property="xiaoquList"></bean:define>
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">
				新增维修申请
			</div>
			<!--  新增编辑 start -->
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="960px">
					<tr >
						<td class="editTableTitle" >小区：</td>
						<td class="editTableContent1" id="xiaoqutd">小区名称：
						<html:select name="jiaofeiDataFrom" property="xiaoqu" styleId="selectxiaoqu"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
						<html:options collection="xiaoquList" property="key" labelProperty="value" /> 
						</html:select><a:need />
						<html:hidden name="jiaofeiDataFrom" property="xiaoqu" styleId="selectxiaoquhidden"/>  
							 &nbsp; &nbsp; 
							小区地址(格式：xx-x-xxxx)：
							<html:text name="jiaofeiDataFrom" property="dizhi" maxlength="50" onkeyup="findStubyClasslId();" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
							<div class="dropDownList" >
								 <div id="dropDownList1" class="dropdown" />
								  <ul id="ul1"></ul>
								 </div>
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >运营商：</td>
						<td class="editTableContent">运营商：
						<html:select name="jiaofeiDataFrom" property="yunyingshang" 
								styleClass="commonTextFieldHover"  styleId="yunyingshang"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--请选择--</html:option>
								<html:option value="电信">电信</html:option>
								<html:option value="联通">联通</html:option>
								<html:option value="广电">广电</html:option>
								<html:option value="铁通">铁通</html:option>
								<html:option value="天房">天房</html:option>
							</html:select>	<a:need />
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >维修时间：</td>
						<td class="editTableContent">
						维修时间：
						 <html:text name="jiaofeiDataFrom" property="weixiushijian" styleId="weixiushijian" size="10" onclick="WdatePicker({el:'weixiushijian'})" />
						 <img onclick="WdatePicker({el:'weixiushijian'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>  
						 <a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >施工人：</td>
						<td class="editTableContent">
						施工人：
							<html:text name="jiaofeiDataFrom" property="shigongren" maxlength="150" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >维修类型：</td>
						<td class="editTableContent">
						维修类型：
							<html:select name="jiaofeiDataFrom" property="weixiuleixing" style="visibility: visible;"
								styleClass="commonTextFieldHover"  
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="未选择">--请选择--</html:option>
								<html:option value="设备更换">设备更换</html:option>
								<html:option value="平台升级">平台升级</html:option>
								<html:option value="FTTH改造">FTTH改造</html:option>
								<html:option value="费用收缴">费用收缴</html:option>
								<html:option value="其他故障">其他故障</html:option>
								<html:option value="收件">收件</html:option>
						</html:select><a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >维修内容：</td>
						<td class="editTableContentLast" >
							<html:textarea name="jiaofeiDataFrom" property="weixiuneirong"  
							rows="3" cols="70"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
							</html:textarea><a:need /><br/>
						</td>
								
					</tr>
					<tr >
						<td class="editTableTitle" >设备信息：</td>
							<td class="editTableContentLast" >
							分光：
							<html:text styleId="fenguang" name="jiaofeiDataFrom" property="fenguang" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
								<html:hidden styleId="fenguangID" name="jiaofeiDataFrom" property="fenguangID" />
							<html:hidden styleId="selectCommunityPileID" name="jiaofeiDataFrom" property="selectCommunityPileID" />
							<html:hidden styleId="eqboxnum" name="jiaofeiDataFrom" property="eqboxnum" />	
							<html:hidden styleId="selectCommunityPileID2" name="jiaofeiDataFrom" property="selectCommunityPileID2" />
							<html:hidden styleId="eqboxnum2" name="jiaofeiDataFrom" property="eqboxnum2" />		
							
							onu mac：
							<html:text styleId="onumac" name="jiaofeiDataFrom" property="onumac" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<br/>
							STB MCID：
							<html:text styleId="stbmcid" name="jiaofeiDataFrom" property="stbmcid" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							电视IP：
							<html:text styleId="dianshiip" name="jiaofeiDataFrom" property="dianshiip" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
							<html:button property="btnSelectDevice" value="挑选设备" styleClass="commonButton2" onclick="selectdevice();"/>
							<html:button styleId="btnDeviceBack" property="btnDeviceBack" value="设备回库" styleClass="commonButton2" onclick="backtodept();"/>
						<br/>
						</td>
								
					</tr>
					<tr>
						<td class="editTableTitle" >收费：</td>
						<td class="editTableContent" >
							宽带费：
							<html:text name="jiaofeiDataFrom" property="kuandaifei" maxlength="50"  onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
									
							收视费：
							<html:text name="jiaofeiDataFrom" property="shoushifei" maxlength="50"  onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<br/>
							初装费：
							<html:text name="jiaofeiDataFrom" property="chuzhuangfei" maxlength="50"  onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							设备销售费：
							<html:text name="jiaofeiDataFrom" property="shebeixiaoshou" maxlength="50" onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
							材料费：
							<html:text name="jiaofeiDataFrom" property="cailiaofei" maxlength="50" onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							年费：
							<html:text name="jiaofeiDataFrom" property="nianfei" maxlength="50" onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
							ONU押金：
							<html:text name="jiaofeiDataFrom" property="onuyj" maxlength="50" onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							机顶盒押金：
							<html:text name="jiaofeiDataFrom" property="jidingheyj" maxlength="50" onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
									<br/>
							总收费：
							<html:text name="jiaofeiDataFrom" property="zongshoufei" maxlength="70" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<script type="text/javascript">
							function zongfei(){
									var kf = document.forms[0].kuandaifei.value;
									var sf = document.forms[0].shoushifei.value;
									var czf = document.forms[0].chuzhuangfei.value;
									var sbf = document.forms[0].shebeixiaoshou.value;
									var clf = document.forms[0].cailiaofei.value;
									var nf = document.forms[0].nianfei.value;
									var oyf = document.forms[0].onuyj.value;
									var jyf = document.forms[0].jidingheyj.value ;
									document.forms[0].zongshoufei.value = Number(kf) + Number(sf) + Number(czf) + Number(sbf)+ Number(clf)+ Number(nf)+ Number(oyf)+ Number(jyf);
							}
						</script>	
						</td>
					</tr>
						
					<tr >
						<td class="editTableTitle" >耗材：</td>
						<td class="editTableContent" >
						接线子：
							<html:text name="jiaofeiDataFrom" property="jiexianzi" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						RJ11：
							<html:text name="jiaofeiDataFrom" property="rj11" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
						RJ45：
							<html:text name="jiaofeiDataFrom" property="rj45" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						模块：
							<html:text name="jiaofeiDataFrom" property="mokuai" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
						面板：
							<html:text name="jiaofeiDataFrom" property="mianban" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						网线：
							<html:text name="jiaofeiDataFrom" property="wangxian" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
						其它耗材：
							<html:text name="jiaofeiDataFrom" property="qitahaocai" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >业务：</td>
						<td class="editTableContent" >
						收据本号/收据号：
							<html:text name="jiaofeiDataFrom" property="shoujubenhao" maxlength="150" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						开票信息：
							<html:text name="jiaofeiDataFrom" property="kaipiaoxinxi" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						<br/>
						
						填写时间：
 						<html:text name="jiaofeiDataFrom" property="nowdata" styleId="nowdata" size="20" readonly="true" />
						</td>
					</tr>
					
					
					<tr >
						<td class="editTableTitle" >备注汇总：</td>
						<td class="editTableContentLast" >
							<html:textarea name="jiaofeiDataFrom" property="beizhuhuizong"  
							rows="5" cols="70"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
							</html:textarea>
						</td>
								
					</tr>
					
				</table>
				</div>
			</div>
			<!--  新增编辑 end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="提交" styleClass="commonButton" onclick="sub();"/>
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('daiweixiuDataList.do?act=init')"/> 
			</div>
		</div>
		<html:hidden name="jiaofeiDataFrom" property="nowdataHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	function sub(){
		if(checkInput()){
			commonSubmit('shenqingDataEdit.do?act=insertDaiweixiu');
			}
	}
	checkInput = function(){
		var dizhi = document.forms[0].dizhi.value;
		if(dizhi==null||trim(dizhi)==""){
			alert("地址必须填写！");
			document.forms[0].dizhi.focus();//设置焦点
			return false;
			}
		var yunyingshang = document.forms[0].yunyingshang.value;
		if(yunyingshang==null||trim(yunyingshang)=="0"){
			alert("运营商不能为空！");
			document.forms[0].yunyingshang.focus();//设置焦点
			return false;
		}
		var weixiushijian = document.forms[0].weixiushijian.value;
		if (weixiushijian==null||trim(weixiushijian)=="") {
			alert("维修时间必须填写！");
			document.forms[0].weixiushijian.focus();//设置焦点
			return false;
		}
		
		var sta =  /^\d{4}[-](\d{2})[-]\d{2}$/.test(weixiushijian);
		if (sta == false ) {
			alert("维修日期输入有误！");
			return false;
		}
	
			
		var shigongren = document.forms[0].shigongren.value;
		if (shigongren==null||trim(shigongren)=="") {
			alert("施工人必须填写！");
			document.forms[0].shigongren.focus();//设置焦点
			return false;
		}
		var weixiuleixing = document.forms[0].weixiuleixing.value;
		if(weixiuleixing==null||trim(weixiuleixing)=="未选择"){
			alert("维修类型不能为空！");
			document.forms[0].weixiuleixing.focus();//设置焦点
			return false;
		}
		var weixiuneirong = document.forms[0].weixiuneirong.value;
		if (weixiuneirong==null||trim(weixiuneirong)=="") {
			alert("维修内容必须填写！");
			document.forms[0].weixiuneirong.focus();//设置焦点
			return false;
		}
			
			
		var kuandaifei = document.forms[0].kuandaifei.value;
		if(kuandaifei!="") {
			if(isNaN(kuandaifei)) {
				alert("宽带费请输入数字！");
				document.forms[0].kuandaifei.focus();//设置焦点
				return false;
			}	
		}
			
		var shoushifei = document.forms[0].shoushifei.value;
		if (shoushifei!="") {
			if (isNaN(shoushifei)) {
				alert("收视费请输入数字！");
				document.forms[0].shoushifei.focus();//设置焦点
				return false;
			 }
		}
		
		var chuzhuangfei = document.forms[0].chuzhuangfei.value;
		if (chuzhuangfei!="") {
			if (isNaN(chuzhuangfei)) {
				alert("初装费请输入数字！");
				document.forms[0].chuzhuangfei.focus();//设置焦点
				return false;
			}
		}
		
		var shebeixiaoshou = document.forms[0].shebeixiaoshou.value;
		if (shebeixiaoshou!="") {
			if (isNaN(shebeixiaoshou)) {
				alert("初装费请输入数字！");
				document.forms[0].shebeixiaoshou.focus();//设置焦点
				return false;
			}
		}
		
		var cailiaofei = document.forms[0].cailiaofei.value;
		if (cailiaofei!="") {
			if (isNaN(cailiaofei)) {
				alert("材料费请输入数字！");
				document.forms[0].cailiaofei.focus();//设置焦点
				return false;
			}
		}
		
		var nianfei = document.forms[0].nianfei.value;
		if (nianfei!="") {
			if (isNaN(nianfei)) {
				alert("年费请输入数字！");
				document.forms[0].nianfei.focus();//设置焦点
				return false;
			}
		}		
		
		var onuyj = document.forms[0].onuyj.value;
		if(onuyj!="")
		{
			if(isNaN(onuyj)){
				alert("onj押金请输入数字！");
				document.forms[0].onuyj.focus();//设置焦点
				return false;
				}
		}
			
		var jidingheyj = document.forms[0].jidingheyj.value;
		if(jidingheyj!="")
		{
			if(isNaN(jidingheyj)){
				alert("机顶盒押金请输入数字！");
				document.forms[0].jidingheyj.focus();//设置焦点
				return false;
				}
		}
		
		var jiexianzi = document.forms[0].jiexianzi.value;
		if (jiexianzi!="") {
			if (isNaN(jiexianzi)) {
				alert("接线子请输入数字！");
				document.forms[0].jiexianzi.focus();//设置焦点
				return false;
			}
		}
		
		var rj11 = document.forms[0].rj11.value;
		if (rj11!="") {
			if (isNaN(rj11)) {
				alert("rj11请输入数字！");
				document.forms[0].rj11.focus();//设置焦点
				return false;
			}
		}
		
		var rj45 = document.forms[0].rj45.value;
		if(rj45!="")
		{
			if(isNaN(rj45)){
				alert("rj45请输入数字！");
				document.forms[0].rj45.focus();//设置焦点
				return false;
				}
		}
		
		var mokuai = document.forms[0].mokuai.value;
		if(mokuai!="")
		{
			if(isNaN(mokuai)){
				alert("模块输入数字！");
				document.forms[0].mokuai.focus();//设置焦点
				return false;
				}
		}
		
		var mianban = document.forms[0].mianban.value;
		if(mianban!="")
		{
			if(isNaN(mianban)){
				alert("面板请输入数字！");
				document.forms[0].mianban.focus();//设置焦点
				return false;
				}
		}
		
		var wangxian = document.forms[0].wangxian.value;
		if(wangxian!="") {
			if(isNaN(wangxian)) {
				alert("网线请输入数字！");
				document.forms[0].wangxian.focus();//设置焦点
				return false;
			}
		}
		var zongshoufei = document.forms[0].zongshoufei.value;
		if (zongshoufei!="") {
			if (isNaN(zongshoufei)) {
				alert("总收费不为数字！");
				document.forms[0].zongshoufei.focus();//设置焦点
				return false;
			}
		}
		
		return true;
	};
	

	</script>
		<script type="text/javascript">
	var ____configArray;
	function __initDropDownList(configArray) {
		 ____configArray = configArray;
		 var existArray = configArray.split("|");
		 var parentContainer = document.getElementById("dropDownList1");
	 	 var optionLength = existArray.length;
	 	 for(var j=0;j<optionLength;j++){
	  	   //获取ul，以便能够添加项目
		   var ulObj = document.getElementById("ul1");
		   var liObj = document.createElement("li");
		   var textNode=document.createTextNode(existArray[j]);
		   liObj.appendChild(textNode);
		   liObj.setAttribute("currentIndex",j);
		   //给每个liObj添加事件
		   liObj.onclick=function(){
		       selectCurrentItem(this);
		   };
		   liObj.onmouseover=function() {
		       this.className="over";
		   };
		   liObj.onmouseout=function() {
		       this.className="";
		   }; 
		   ulObj.appendChild(liObj);
		 }
		 showUI();
		 parentContainer.onclick = function(event){
		 if (!event) {
		   	event = window.event;
		   }
		    //阻止事件冒泡
		    event.cancelBubble=true;
		    var eventUlObj = document.getElementById("ul1");//this.getElementsByTagName("ul1");
		    bodyClickHiddenUl(eventUlObj);
	 	 }; 
 	}
	 
	function selectCurrentItem(currentObj) {
		 document.getElementById("dizhi").value = currentObj.firstChild.nodeValue;
		 hiddenUI();
	}
	function showHiddenUl(){
		var ulObj = document.getElementById("ul1");
		if(ulObj.className == "") {
			ulObj.className = "show";
		}else{
		    ulObj.className = "";
		}
	}
	function hiddenUI() {
		var ulObj = document.getElementById("ul1");
		ulObj.className = "";

	}
	function showUI() {
		var ulObj = document.getElementById("ul1");
		ulObj.className = "show";

	}
		//点击body区域（非“下拉菜单”）隐藏菜单
	function addBodyClick(func) {
		var bodyObj=document.getElementById("body1");
		var oldBodyClick = bodyObj.onclick;
		if (typeof bodyObj.onclick != 'function') 
		{
			bodyObj.onclick = func;
		} else {
	   		bodyObj.onclick = function() {
	    	oldBodyClick();
	    	func();
	 		};
		}
	}
	//隐藏所有的UL
	function bodyClickHiddenUl(eventUlObj){
		//alert(eventUlObj);
		if (____configArray == undefined || ____configArray==null || ____configArray=="") {
			return;
		} 
		//hiddenUI();
		if (eventUlObj == undefined) {
			hiddenUI();
		}  
	}	
	//添加这个可以确保点击body区域的时候 也可以隐藏菜单
	addBodyClick(bodyClickHiddenUl);
	</script>
</html>