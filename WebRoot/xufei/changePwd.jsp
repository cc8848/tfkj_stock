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
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/common.js" language="javascript"></script>
		
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="paigongdan/paigongdan.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script type="text/javascript">
			var menpaihao = "";
			var tradeType = "";
			$().ready(function() {
				$("#countNum").focus(function() {
					var xiaoqu = encodeURIComponent(document.forms[0].xiaoqu.value);
					var dizhi = encodeURIComponent(document.forms[0].dizhi.value);
					var wangluo = "";
					if(document.forms[0].zhongkuandai[0].checked) {
						wangluo = "1";	
					} else {
						wangluo = "0";	
					}
					if(menpaihao == dizhi) {
						if(tradeType == wangluo) {
							return false;
						} 
						tradeType = wangluo;
					} else {
						menpaihao = encodeURIComponent(document.forms[0].dizhi.value);
						tradeType = wangluo;
					}
					
					if(dizhi.length > 2){
						var sURL = "countNum.do?act=countNum";
						//var sParams = "xiaoqu=" + xiaoqu + "&dizhi=" + dizhi;
						//sendRequest(sURL, sParams, method);
						$(this).html("<option value='0'>--请选择--</option>");
						$.ajax({
							url:sURL,
							type : "POST",
							cache:false,
							data:{
								'xiaoqu':xiaoqu,
								'dizhi':menpaihao
							},
							success: function(data){
								var countNumArray = data.split("|");
								if(countNumArray.length >0) {
									var str = "";
									for(var i=0; i<countNumArray.length; i++) {
										var countNumStr = countNumArray[i];
										var cNArray = countNumStr.split(":");
										if(cNArray.length > 1) {
											if(document.forms[0].zhongkuandai[0].checked && cNArray[0].split("-")[0] == '网络') {
												str += "<option value=" + cNArray[1] + ">" + countNumArray[i] + "</option>";
											} else if(document.forms[0].zhongkuandai[1].checked && cNArray[0].split("-")[0] == '电视') {
												str += "<option value=" + cNArray[1] + ">" + countNumArray[i] + "</option>";
											}
										}
										$("#countNum").html(str);
									}
								} else {
									$(this).html("<option value='0'>--请选择--</option>");
								}
									
							}
						});
				  }	
				});
				$("#countNum").blur(function() {
					if($(this).val() != '0' && $(this).val() != '') {
						$("#xiaoquValue").html($(document.forms[0].xiaoqu).val()).show();
						$(document.forms[0].xiaoqu).hide();
						$("#dizhiValue").html($(document.forms[0].dizhi).val()).show();
						$(document.forms[0].dizhi).hide();
					}
				});
			});
		
					function changelevel1(){
					var URL = "shenqingDataEdit.do?act=changekdf"; 
					var shichang = document.forms[0].shichang.value;
						$.ajax({
							url:URL,
							cache:false,
							data:{'shichang':encodeURI(shichang)},
							success: function(result0){
								if (result0=="null"){
								
									result0=0;
								}
									document.getElementById("kuandaifei").value = result0;
									var kf = result0;
									var sf = document.forms[0].shoushifei.value;
									var oyf = document.forms[0].onuyj.value;
									var jyf = document.forms[0].jidingheyj.value;
									var nf = document.forms[0].nianfei.value;
									document.forms[0].zongshoufei.value = Number(kf) + Number(sf) + Number(oyf) + Number(jyf) + Number(nf);
								}
						});
					}
					function changelevel2(){
					var URL = "shenqingDataEdit.do?act=changekdlx"; 
					var shichang = document.forms[0].shichang.value;
						$.ajax({
							url:URL,
							cache:false,
							data:{'shichang':encodeURI(shichang)},
							success: function(result0){
								if (result0=="null"){
									result0=0;
								}
									document.getElementById("wangluo").value = result0;
										}
								});
					}
					function changelevel3(){
					var URL = "shenqingDataEdit.do?act=changetvf"; 
					var shichangtv = document.forms[0].shichangtv.value;
						$.ajax({
							url:URL,
							cache:false,
							data:{'shichangtv':encodeURI(shichangtv)},
							success: function(result0){
								if (result0=="null"){
									result0=0;
								}
									document.getElementById("shoushifei").value = result0;
									var sf = result0;
									var kf = document.forms[0].kuandaifei.value;
									var oyf = document.forms[0].onuyj.value;
									var jyf = document.forms[0].jidingheyj.value;
									var nf = document.forms[0].nianfei.value;
									document.forms[0].zongshoufei.value = Number(kf) + Number(sf) + Number(oyf) + Number(jyf) + Number(nf);
										}
								});
					}
					function changelevel4(){
					var URL = "shenqingDataEdit.do?act=changetvlx"; 
					var shichangtv = document.forms[0].shichangtv.value;
						$.ajax({
							url:URL,
							cache:false,
							data:{'shichangtv':encodeURI(shichangtv)},
							success: function(result0){
								if (result0=="null"){
									result0=0;
								}
									document.getElementById("dianshi").value = result0;
										}
								});
					}
					
					function changelevel5(){
					var URL = "shenqingDataEdit.do?act=changekdsj"; 
					var shichang = document.forms[0].shichang.value;
						$.ajax({
							url:URL,
							cache:false,
							data:{'shichang':encodeURI(shichang)},
							success: function(result0){
								if (result0=="null"){
									result0=0;
								}
									document.getElementById("yewushijian").value = result0;
										}
								});
					}
					
					function changelevel6(){
					var URL = "shenqingDataEdit.do?act=changetvsj"; 
					var shichangtv = document.forms[0].shichangtv.value;
						$.ajax({
							url:URL,
							cache:false,
							data:{'shichangtv':encodeURI(shichangtv)},
							success: function(result0){
								if (result0=="null"){
									result0=0;
								}
									document.getElementById("yewushijian").value = result0;
										}
								});
					}
					function changeshijian(){
					var URL = "shenqingDataEdit.do?act=changetjsj"; 
					var yewushijian = document.forms[0].yewushijian.value;
					var kaijishijian = document.forms[0].kaijishijian.value;
					
						$.ajax({
							url:URL,
							cache:false,
							data:{'yewushijian':encodeURI(yewushijian),'kaijishijian':encodeURI(kaijishijian)},
							success: function(result0){
								if (result0=="null"){
									result0=0;
								}
									document.getElementById("tingjishijian").value = result0;
										}
								});
					}
		</script>
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
	</script>
	</head>
	<body onload="init()" >  
		<html:form action="shenqingDataEdit.do">
			<bean:define id="xiaoquList" name="jiaofeiDataFrom" property="xiaoquList"></bean:define>
			<bean:define id="shichangList" name="jiaofeiDataFrom" property="shichangList"></bean:define>
			<bean:define id="shichangtvList" name="jiaofeiDataFrom" property="shichangtvList"></bean:define>
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">
				申请密码修改
			</div>
			<!--  新增编辑 start -->
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="960px">
					<tr >
						<td class="editTableTitle" >小区：</td>
						<td class="editTableContent1">小区名称：
						<html:select name="jiaofeiDataFrom" property="xiaoqu" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
						<html:options collection="xiaoquList" property="key" labelProperty="value" /> 
						
							
						</html:select>
						<label id="xiaoquValue" style="display: none;"></label><a:need />
						<a style="margin-right: 30px"></a>
							小区地址(格式：xx-x-xxxx)：
							<html:text name="jiaofeiDataFrom" property="dizhi" maxlength="50" onkeyup="findStubyClasslId();" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<label id="dizhiValue" style="display: none;"></label>
							<a:need />
							<div class="dropDownList">
								 <div id="dropDownList1" class="dropdown" />
								  <ul id="ul1"></ul>
								 </div>
								 </div>
							<!-- <div>
								<textarea rows="20" cols="120"  id="text001" style="visibility: hidden;"></textarea>
							</div> -->
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >运营商：</td>
						<td class="editTableContent">运营商：
						<html:select name="jiaofeiDataFrom" property="yunyingshang" 
								styleClass="commonTextFieldHover"  styleId="yunyingshang"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="天房">天房</html:option>
								<html:option value="电信">电信</html:option>
								<html:option value="联通">联通</html:option>
								<html:option value="广电">广电</html:option>
								<html:option value="铁通">铁通</html:option>
							</html:select>	<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >续费：</td>
						<td class="editTableContent" >
						<html:radio property="zhongkuandai" value="0" onclick="ischeckk0(this);" >网络:</html:radio>
						<script type="text/javascript">
						function ischeckk0(v){
							var asd = v.checked;
								if(asd){
									document.forms[0].wangluo.style.visibility = "";
									document.forms[0].shichang.style.visibility = "";
									document.forms[0].dianshi.style.visibility = "hidden";
									document.forms[0].dianhua.style.visibility = "hidden";
									document.forms[0].shichangtv.style.visibility  = "hidden";
									document.forms[0].shoushifei.value = 0;
									document.forms[0].zongshoufei.value = "";
								}else{
									document.forms[0].wangluo.style.visibility = "hidden";
									document.forms[0].shichang.style.visibility = "hidden";
									document.forms[0].dianhua.style.visibility = "hidden";
								}
							}
						</script>

						<html:text name="jiaofeiDataFrom" property="wangluo"size="12" value="0"maxlength="20" style="visibility: visible;"
									styleClass="commonTextFieldHover" styleId="wangluo" readonly="true"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" readonly="true"/>
						 <br/> 
						时长:
						<html:select name="jiaofeiDataFrom" property="shichang" styleId="shichang" style="visibility: visible;"
								styleClass="commonTextFieldHover"  
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" onchange="changelevel1(),changelevel2(),changelevel5()">
								<html:options collection="shichangList" property="key" labelProperty="value" />
						</html:select>
							
							<br/>
						<html:radio property="zhongkuandai" value="0" onclick="ischeckd1(this);">电视:</html:radio>
						<script type="text/javascript">
						    function ischeckd1(v) {
								var asd = v.checked;
								if(asd) {
									document.forms[0].dianshi.style.visibility  = "";
									document.forms[0].shichangtv.style.visibility  = "";
									document.forms[0].wangluo.style.visibility  = "hidden";
									document.forms[0].shichang.style.visibility = "hidden";
									document.forms[0].dianhua.style.visibility  = "hidden";
									document.forms[0].kuandaifei.value = 0;
									document.forms[0].zongshoufei.value = "";
								} else {
									document.forms[0].dianshi.style.visibility = "hidden";
									document.forms[0].dianhua.style.visibility = "hidden";
								}
							}
						</script>
						
						<html:text name="jiaofeiDataFrom" property="dianshi" style="visibility: hidden; " size="12" value="0"maxlength="20" 
								styleClass="commonTextFieldHover" styleId="dianshi"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" readonly="true"/>
								
					
						<br/> 
						时长:
						<html:select name="jiaofeiDataFrom" property="shichangtv" styleId="shichangtv" style="visibility: hidden;"
								styleClass="commonTextFieldHover"  
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" onchange="changelevel3(),changelevel4(),changelevel6()">
								<html:options collection="shichangtvList" property="key" labelProperty="value" />
						</html:select>
						<!-- 默认选中网络业务  -->
						<script type="text/javascript">
							document.forms[0].zhongkuandai[0].checked=true;
						</script>
						 &nbsp; &nbsp; 
						 
						<br/>
						<html:radio property="zhongkuandai" value="0" onclick="ischeckd2(this);">电话:</html:radio>
						<script type="text/javascript">
						function ischeckd2(v){
							var asd = v.checked;
								if(asd){
									document.forms[0].dianshi.style.visibility = "hidden";
									document.forms[0].shichangtv.style.visibility = "hidden";
									document.forms[0].wangluo.style.visibility = "hidden";
									document.forms[0].shichang.style.visibility = "hidden";
									document.forms[0].dianhua.style.visibility = "";
									document.forms[0].kuandaifei.value = 0;
									document.forms[0].shoushifei.value = 0;
									document.forms[0].zongshoufei.value = "";
								}else{
									document.forms[0].dianshi.style.visibility = "hidden";
									document.forms[0].wangluo.style.visibility = "hidden";
									document.forms[0].shichang.style.visibility = "hidden";
									document.forms[0].shichangtv.style.visibility = "hidden";
								}
							}
						</script>
						<html:select name="jiaofeiDataFrom" property="dianhua" style="visibility: hidden;"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="铁通">铁通</html:option>
						</html:select>
						<br/>
						</td>
					</tr>
					
					<!-- change by 赵兴华 2015-01-15  显示出要续费的账号   start-->
					<tr>
						<td class="editTableTitle" >已有账号：</td>
						<td class="editTableContent">
							<select id="countNum" style="width: 300px">
								<option value="0"> --请选择-- </option>
							</select>
							<span style="color: red">*</span>
						</td>
					</tr>
					<!-- change by 赵兴华 2015-01-15  显示出要续费的账号   end-->
					
					<tr >
						<td class="editTableTitle" >新密码：</td>
						<td class="editTableContent" >
							<html:text name="jiaofeiDataFrom" property="lianxidianhua" maxlength="150" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >再次输入新密码：</td>
						<td class="editTableContent" >
							<html:text name="jiaofeiDataFrom" property="beizhuhuizong" maxlength="150" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >备注：</td>
						<td class="editTableContentLast" >
							<html:textarea name="jiaofeiDataFrom" property="kaipiaoxinxi"  
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
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('operateList.do?act=init')"/> 
			</div>
		</div>
		<html:hidden name="jiaofeiDataFrom" property="nowdataHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	function sub(){
		if(checkInput()){
			commonSubmit('shenqingDataEdit.do?act=insertChangePwd&countNum=' + $("#countNum").val());
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
		
		
		var countNum = ($("#countNum").val());
		if(countNum==null||trim(countNum)=="0"){
			alert("请选择要续费的账号！");
			$("#countNum").focus();
			return false;
		} else {
			var countText = $("option[value=" + countNum + "]").html();
			if(document.forms[0].zhongkuandai[0].checked) {
				if(countText.split("-")[0] != '网络') {
					alert("业务类型与账号不符！");
					return false;
				}
			} else {
				if(countText.split("-")[0] != '电视') {
					alert("业务类型与账号不符！");
					return false;
				}
			}
		}
		
		
		var ischeck0 = document.forms[0].zhongkuandai[0].checked;
		var ischeck1 = document.forms[0].zhongkuandai[1].checked;
		//var ischeck2 = document.forms[0].zhongkuandai[2].checked;
		if(ischeck0){
			 document.forms[0].dianshi.value = "";
			 document.forms[0].dianhua.value = "";
		}else if (ischeck1){
			 document.forms[0].wangluo.value  = "";
			 document.forms[0].shichang.value = "";
			 document.forms[0].dianhua.value  = "";
		} else {
			 document.forms[0].dianshi.value  = "";
			 document.forms[0].wangluo.value  = "";
			 document.forms[0].shichang.value = "";
		}
		
		
		var lianxidianhua = document.forms[0].lianxidianhua.value;
		
		var beizhuhuizong = document.forms[0].beizhuhuizong.value;
		if(lianxidianhua==null||trim(lianxidianhua)==""){
			alert("密码不能为空！");
			document.forms[0].yunyingshang.focus();//设置焦点
			return false;
		} else {
			if(lianxidianhua != beizhuhuizong) {
				alert("两次密码不一致！");
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
		document.forms[0].dizhi.value = currentObj.firstChild.nodeValue;
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