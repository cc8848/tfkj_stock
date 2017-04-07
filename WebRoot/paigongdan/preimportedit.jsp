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
		<script src="js/Calendar3.js" language="javascript"></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		
		<script src="js/common.js" language="javascript"></script>
		
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="paigongdan/paigongdan.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		
		<script type="text/javascript">
	function changelevel1(){
	var URL = "paigongdanEdit.do?act=changekd"; 
	var tfkdnianxian = document.forms[0].tfkdnianxian.value;
		$.ajax({
			url:URL,
			cache:false,
			data:{'tfkdnianxian':encodeURI(tfkdnianxian)},
			success: function(result0){
				if (result0=="null"||result0==""){
				
					result0=0;
				}
				var beishu = document.getElementById("beishuselect").value;
					result0 = result0 * beishu;
					document.getElementById("tfkuandaifei").value = result0;
					document.getElementById("kuaidaifei").value = result0;
					
						}
				});
	}
	function changelevel2(){
	var URL = "paigongdanEdit.do?act=changekdsc"; 
	var tfkdnianxian = document.forms[0].tfkdnianxian.value;
		$.ajax({
			url:URL,
			cache:false,
			data:{'tfkdnianxian':encodeURI(tfkdnianxian)},
			success: function(result0){
				if (result0=="null"||result0==""){
					result0=0;
				}
					document.getElementById("shichangleixing").value = result0;
						}
				});
	}
	function changelevel3(){
	var URL = "paigongdanEdit.do?act=changekddk"; 
	var tfkdnianxian = document.forms[0].tfkdnianxian.value;
		$.ajax({
			url:URL,
			cache:false,
			data:{'tfkdnianxian':encodeURI(tfkdnianxian)},
			success: function(result0){
				if (result0=="null"||result0==""){
					result0=0;
				}
					document.getElementById("tfkuandaidaikuan").value = result0;
						}
				});
	}
	function changelevel4(){
	var URL = "paigongdanEdit.do?act=changekdshichang"; 
	var tfkdnianxian = document.forms[0].tfkdnianxian.value;
		$.ajax({
			url:URL,
			cache:false,
			data:{'tfkdnianxian':encodeURI(tfkdnianxian)},
			success: function(result0){
				if (result0=="null"||result0==""){
					result0=0;
				}
				var beishu = document.getElementById("beishuselect").value;
					result0 = result0 * beishu;
					document.getElementById("tfkuandaishichang").value = result0;
						}
				});
	}
function selectdevice() {
			var selectxiaoqu = document.getElementById("xiaoquname").value;
			selectxiaoqu = encodeURI(encodeURI(selectxiaoqu));
			window.open('<%=basePath%>shebeichukuList.do?act=init&selectkbn=1&selectxiaoqu='+selectxiaoqu,'newwindow','height=500px,width=880px,top=150,left=300,toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no'); 
		}
		function afterselect() {
			document.getElementById("selectxiaoquhidden").value = document.getElementById("xiaoquname").value;
			document.getElementById("xiaoquname").disabled = "disabled";
			document.getElementById("selectxiaoquhidden").disabled = "";
		}
		function initxiaoqu() {
			var communityPID = document.getElementById("selectCommunityPileID").value;
			var communityPID2 = document.getElementById("selectCommunityPileID2").value;
			if(communityPID!=""||communityPID2!="") {
				afterselect();
			}
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
						if(document.getElementById("fenguangID").value=="") {
							document.getElementById("fenguang").value = " ";
						}
						document.getElementById("onumac").value = " ";
						document.getElementById("stbmcid").value = " ";
						document.getElementById("dianshiip").value = " ";
						document.getElementById("eqboxnum").value = "";
						document.getElementById("eqboxnum2").value = "";
						document.getElementById("xiaoquname").disabled = "";
						document.getElementById("selectxiaoquhidden").disabled = "disabled";
						subs();
					} else {
						alert(data);
						return false;
					}
				}
			});
		}
	function installCompare() {
		if(check()){
				docompare();
			}
	}
	//点击测试时 触发校验
	function check(){
		var xq = trim(document.getElementById("xiaoquname").value);
		var dz = trim(document.getElementById("userplace").value);
		if(xq==''||xq==null){
			alert("小区不能为空，请选择小区！");
			document.getElementById("xiaoquname").focus();
			return false;
			}
		if(dz==''||dz==null){
			alert("地址不能为空，请输入地址！");
			document.getElementById("userplace").focus();
			return false;
			}
		return true;
		}
	var beforequickvalue="";
	var initshichangoption;
	function changeshichang() {
		var quickvalue = document.getElementById("scquickselect").value;
		if(beforequickvalue=="") {
			initshichangoption = document.getElementById("tfkdnianxian").innerHTML;
		}else{
			document.getElementById("tfkdnianxian").innerHTML = initshichangoption;
		}
		beforequickvalue = quickvalue;
		var allopt = document.getElementById("tfkdnianxian");
		for(var i = allopt.length-1;i>=0;i--) {
			var optval = $("#tfkdnianxian option[index="+i+"]").val();
			if(quickvalue=="0"||optval=="0"||optval.indexOf("------")!=-1) {
				continue;
			}
			if(optval.indexOf("带"+quickvalue+"M")==-1&&optval.indexOf(")"+quickvalue+"M")==-1&&optval.indexOf("）"+quickvalue+"M")==-1&&optval.indexOf("】"+quickvalue+"M")==-1) {
				$("#tfkdnianxian option[index="+i+"]").remove();
			}
		}
		changelevel1();
		changelevel2();
		changelevel3();
		changelevel4();
	}
	
	var beforequickvalue2="";
	var initshichangoption2;
	function changeshichang2() {
		var quickvalue = document.getElementById("scquickselect2").value;
		if(beforequickvalue2=="") {
			initshichangoption2 = document.getElementById("qtye").innerHTML;
		}else{
			document.getElementById("qtye").innerHTML = initshichangoption2;
		}
		beforequickvalue2 = quickvalue;
		var allopt = document.getElementById("qtye");
		for(var i = allopt.length-1;i>=0;i--) {
			var optval = $("#qtye option[index="+i+"]").val();
			if(quickvalue=="0"||optval=="0"||optval.indexOf("------")!=-1) {
				continue;
			}
			if(optval.indexOf("品"+quickvalue+"M")==-1&&optval.indexOf("享"+quickvalue+"M")==-1&&optval.indexOf("餐"+quickvalue+"M")==-1) {
				$("#qtye option[index="+i+"]").remove();
			}
		}
		changedainxin();
	}
	function changedainxin(){
	var URL = "paigongdanEdit.do?act=changedianxin"; 
	var tfkdnianxian = document.forms[0].qtye.value;
		$.ajax({
			url:URL,
			cache:false,
			data:{'tfkdnianxian':encodeURI(tfkdnianxian)},
				success: function(result0){
						var resultelement = result0.split("|");
						document.getElementById("chuzhuangfei").value = resultelement[1];
						document.getElementById("dxchuzhuangfei").value = resultelement[1];
						document.getElementById("nianfei").value = resultelement[2];
						document.forms[0].fufei.value = resultelement[2];
						document.getElementById("buzuyue").value = resultelement[3];
						document.getElementById("qtbuzuyue").value = resultelement[3];
						document.getElementById("onu").value = resultelement[4];
						}
				});
	}
	function initCompareBtn() {
		var selectxiangmu =document.getElementById("xiangmu").value;
		if(selectxiangmu=="安装") {
			document.getElementById("btnCompare").disabled= "";
		}else{
			document.getElementById("btnCompare").disabled= "true";
		}
	}
	function docompare() {
		var xiaoquz = document.getElementById("xiaoquname").value;
		var dizhiz = document.getElementById("userplace").value;
		xiaoquz = encodeURI(encodeURI(xiaoquz));
		window.open('<%=basePath%>anzhuangbiduiList.do?act=init&selectkbn=1&selectxiaoqu='+xiaoquz+'&selectdizhi='+dizhiz,'newwindow','height=500px,width=880px,top=150,left=300,toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
		}
		function aftercompareselect() {
			
		}
		function initFenguang() {
			if(document.getElementById("fenguangID").value!="") {
				$("#fenguang").attr("readonly","readonly");
			}
		}
	function changebeishu() {
		changelevel1();
		changelevel4();
	}
	function initKaijishijian() {
		$("#kaijishijian").val($("#paigongriqi").val());
		initTingjishijian();
	}
	function initTingjishijian() {
		changelevel5();
	}
	function changelevel5(){
					var URL = "shenqingDataEdit.do?act=changekdsj"; 
					var shichang = document.forms[0].tfkdnianxian.value;
						$.ajax({
							url:URL,
							cache:false,
							data:{'shichang':encodeURI(shichang)},
							success: function(result0){
								if (result0=="null"){
									result0=0;
								}
									document.forms[0].yewushijian.value = result0;
									changeshijian();
										}
								});
					}
		function changeshijian(){
					var URL = "shenqingDataEdit.do?act=changetjsj"; 
					var yewushijian = document.forms[0].yewushijian.value;
					var kaijishijian = document.forms[0].kaijishijian.value;
					var beishu = document.forms[0].beishuselect.value;
						$.ajax({
							url:URL,
							cache:false,
							data:{'yewushijian':encodeURI(yewushijian),'kaijishijian':encodeURI(kaijishijian),'beishu':encodeURI(beishu)},
							success: function(result0){
								if (result0=="null"){
									result0=0;
								}
								if(result0!="") {
									document.getElementById("tingjishijian").value = result0;
										}
										}
								});
					}
		</script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init();initxiaoqu();initCompareBtn();initFenguang();">
		<html:form action="paigongdanEdit.do">
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">
				回单预导入编辑
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="940px">
					<tr height="35px">
						<td class="editTableTitle" width="30px">用户信息：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						用户姓名：
						<html:text name="paiGongDanEntiyForm" property="username"size="12" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
							<a:need />
							<html:hidden name="paiGongDanEntiyForm" styleId="biduikbn" property="biduikbn"></html:hidden>
							身份证号：
								<html:text name="paiGongDanEntiyForm" property="shenfenzheng"size="12" maxlength="20"
									styleClass="commonTextFieldHover"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" style="width: 200px"/>
							<a:need />
						</td>
						</tr>
						<tr>
						<td>
						小区名称：
							<html:select name="paiGongDanEntiyForm" property="xiaoquname" styleId="xiaoquname"  disabled="true"
								styleClass="commonTextFieldHover"  onchange="selectxiaoqu(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
						<a:need />
						<html:hidden name="paiGongDanEntiyForm" property="xiaoquname" styleId="selectxiaoquhidden"/>  
						用户地址：
						<html:text name="paiGongDanEntiyForm" property="userplace" styleId="userplace" size="12" maxlength="20" 
								styleClass="commonTextFieldHover"	onchange="isture(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
							<a:need />
						联系电话：
							<html:text name="paiGongDanEntiyForm" property="usertel" size="12" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
							<a:need />	
							</td>
						</tr>
							</table>
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">派工日期：</td>
						<td class="editTableContent" >
						
						派工日期：
							<html:text name="paiGongDanEntiyForm" property="paigongriqi"  styleId="paigongriqi"size="12"
								styleClass="commonTextFieldHover"  readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						<a:need />
						上门时间：
						<html:select name="paiGongDanEntiyForm" property="anzhuangshijian" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">请选择</html:option>
								<html:option value="上午">上午</html:option>
								<html:option value="下午">下午</html:option>
							</html:select>			
							<a:need />
						业务：
							<html:text name="paiGongDanEntiyForm" property="yewutype"  styleId="yewutype"size="12"
								styleClass="commonTextFieldHover"  readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<html:hidden styleId="xiangmu" name="paiGongDanEntiyForm" property="xiangmu"/>
							<a:need />	
							<html:button styleId="btnCompare" property="btnCompare" value="安装比对" disabled="true" styleClass="commonButton2" onclick="installCompare();"/>
							<font color="blue">预约安装必点</font>	
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">单证：</td>
						<td class="editTableContent" >
						已见电信返单：
							<html:checkbox name="paiGongDanEntiyForm" property="dxfandan" value="1"></html:checkbox>
						证件齐全：
							<html:checkbox name="paiGongDanEntiyForm" property="zhengjian" styleId="zhengjian" value="1"></html:checkbox>
							具体业务描述：
									<html:text name="paiGongDanEntiyForm" property="qtye" size="50" maxlength="50"
									styleClass="commonTextFieldHover" styleId="qtye"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
					<tr >
						<td class="editTableTitle" width="30px">天房宽带：</td>
						<td class="editTableContent" >
						<table>
						<tr>
							<td>
								网络：
									<html:text name="paiGongDanEntiyForm" property="tfkuandaidaikuan"size="12" maxlength="20"
									styleClass="commonTextFieldHover" styleId="tfkuandaidaikuan"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" />
							</td>
						</tr>
						</table>
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">天房IPTV：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						电视：
								
								<html:text name="paiGongDanEntiyForm" property="tfiptv" 
								styleClass="commonTextFieldHover"  styleId="tfiptvshuliang" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								</html:text>
						</td>
						</tr>
						</table>		
						</td>
					</tr>
						<tr height="35px">
						<td class="editTableTitle" width="30px">其他运营商业务：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						天房三方业务：
								<html:text name="paiGongDanEntiyForm" property="tfsfyewu"  styleId="tfsfyewu"
								styleClass="commonTextFieldHover"  
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								</html:text>
						</td>
						</tr>
						</table>
						</td>
					</tr>
<tr >
						<td class="editTableTitle" >设备信息：</td>
							<td class="editTableContentLast" >
							分光：
							<html:text styleId="fenguang" name="paiGongDanEntiyForm" property="fenguang" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<html:hidden styleId="fenguangID" name="paiGongDanEntiyForm" property="fenguangID" />	
							<html:hidden styleId="selectCommunityPileID" name="paiGongDanEntiyForm" property="selectCommunityPileID" />
							<html:hidden styleId="selectCommunityPileID2" name="paiGongDanEntiyForm" property="selectCommunityPileID2" />
							<input type="hidden" name="oldCPID" value="<bean:write name='paiGongDanEntiyForm' property='selectCommunityPileID' />"/>
							<input type="hidden" name="oldCPID2" value="<bean:write name='paiGongDanEntiyForm' property='selectCommunityPileID2' />"/>
							<html:hidden styleId="eqboxnum" name="paiGongDanEntiyForm" property="eqboxnum" />	
							<html:hidden styleId="eqboxnum2" name="paiGongDanEntiyForm" property="eqboxnum2" />		
							<html:hidden styleId="bdfenguang" name="paiGongDanEntiyForm" property="bdfenguang" />
							<html:hidden styleId="bdonumac" name="paiGongDanEntiyForm" property="bdonumac" />
							<html:hidden styleId="bdstbmcid" name="paiGongDanEntiyForm" property="bdstbmcid" />
							<html:hidden styleId="bddianshiip" name="paiGongDanEntiyForm" property="bddianshiip" />
							onu mac：
							<html:text styleId="onumac" name="paiGongDanEntiyForm" property="onumac" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<br/>
							STB MCID：
							<html:text styleId="stbmcid" name="paiGongDanEntiyForm" property="stbmcid" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							电视IP：
							<html:text styleId="dianshiip" name="paiGongDanEntiyForm" property="dianshiip" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
							<html:button property="btnSelectDevice" value="挑选设备" styleClass="commonButton2" onclick="selectdevice();"/>
							<html:button styleId="btnDeviceBack" property="btnDeviceBack" value="设备回库" styleClass="commonButton2" onclick="backtodept();"/>
						<br/>
							网络IP：
							<html:text styleId="wangluoip" name="paiGongDanEntiyForm" property="wangluoip" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							电话IP/电视账号：
							<html:text styleId="dianhuaip" name="paiGongDanEntiyForm" property="dianhuaip" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
							电话VLAN：
							<html:text styleId="dianhuavlan" name="paiGongDanEntiyForm" property="dianhuavlan" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							网络VLAN：
							<html:text styleId="wangluovlan" name="paiGongDanEntiyForm" property="wangluovlan" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
						</td>
								
					</tr>
						<tr height="35px">
						<td class="editTableTitle" width="30px">所选号码：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						号码1&nbsp;
							<html:text name="paiGongDanEntiyForm" property="telhaoma1" size="12" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						号码2&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma2" size="12" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>		
						</tr>	
						<tr>
						<td>	
						号码3&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma3" size="12" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						号码4&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma4" size="12" maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>		
						</table>		
						</td>
					</tr>
					
						
					
					<tr height="35px">
						<td class="editTableTitle" width="30px">应收费用：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td id="onutd">
						ONU押金：
							<!--<html:text name="paiGongDanEntiyForm" property="onu" size="8"
								styleClass="commonTextFieldHover"  styleId="onu"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />-->
								<html:text name="paiGongDanEntiyForm" property="onu" size="8" maxlength="20"
								styleClass="commonTextFieldHover"  styleId="onu" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
							</html:text>
						</td>	
						<td>		
						宽带费：&nbsp;&nbsp;&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="kuaidaifei" size="8"maxlength="20"
								styleClass="commonTextFieldHover" styleId="kuaidaifei"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>	
						收视费：
						<html:text name="paiGongDanEntiyForm" property="shoushifei" size="8" maxlength="20"
								styleClass="commonTextFieldHover"  styleId="shoushifei"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>
						机顶盒押金：
						<html:text name="paiGongDanEntiyForm" property="jidinghe" size="8" maxlength="20"
								styleClass="commonTextFieldHover"  styleId="jidinghe"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>	
						年费：
						<html:text name="paiGongDanEntiyForm" property="nianfei" size="8" maxlength="20"
								styleClass="commonTextFieldHover" styleId="nianfei"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td>		
						不足月：&nbsp;
						<html:text name="paiGongDanEntiyForm" property="buzuyue" size="8"maxlength="20"
								styleClass="commonTextFieldHover"  styleId="buzuyue"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						初装费：
						<html:text name="paiGongDanEntiyForm" property="chuzhuangfei" size="8"maxlength="20"
								styleClass="commonTextFieldHover"  styleId="chuzhuangfei"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						设备销售费：
						<html:text name="paiGongDanEntiyForm" property="shebeixiaoshou" size="8"maxlength="20"
								styleClass="commonTextFieldHover" styleId="shebeixiaoshou"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						材料费：
						<html:text name="paiGongDanEntiyForm" property="cailiaofei" size="8"maxlength="20"
								styleClass="commonTextFieldHover" styleId="cailiaofei"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<html:text name="paiGongDanEntiyForm" property="jiaohuanji" size="8" maxlength="20"
								styleClass="commonTextFieldHover"  styleId="jiaohuanji" style="display:none;" value="0"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
							</html:text>
						</tr>
						<tr>
						<td>		
						<a href="javascript:heji()">合计</a>：
						<html:text name="paiGongDanEntiyForm" property="heji" size="8"maxlength="20"readonly="true"
								styleClass="commonTextFieldHover" styleId="heji"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />	
						</td>		
						</tr>		
						</table>		
						</td>
						</tr>
					<tr >
						<td class="editTableTitleLast" >备注：</td>
						<td class="editTableContentLast" >
							<html:textarea name="paiGongDanEntiyForm" property="beizhu"  
								rows="5" cols="70"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
							</html:textarea>
						</td>
					</tr>
					
				</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="保存" styleClass="commonButton" onclick="subs();"/>
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('huidanPreImportList.do?act=init')"/>
				运营商：
				<html:select name="paiGongDanEntiyForm" property="yuyingshang" 
								styleClass="commonTextFieldHover"  styleId="yuyingshang"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--请选择--</html:option>
								<html:option value="电信">电信</html:option>
								<html:option value="联通">联通</html:option>
								<html:option value="广电">广电</html:option>
								<html:option value="铁通">铁通</html:option>
								<html:option value="天房">天房</html:option>
							</html:select>	<a:need />
				<input type="hidden" id="yewushijian" name="yewushijian"/>
				开机时间：
				<html:text name="paiGongDanEntiyForm" property="kaijishijian"  styleId="kaijishijian"size="12"
								styleClass="commonTextFieldHover" onclick="new Calendar().show(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover';"/><a:need />
				停机时间：
				<html:text name="paiGongDanEntiyForm" property="tingjishijian"  styleId="tingjishijian"size="12"
								styleClass="commonTextFieldHover"  onclick="new Calendar().show(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
				（可手动指定开机时间）
			</div>
		</div>
		<html:hidden name="paiGongDanEntiyForm" property="UUID" />
		</html:form>
	</body>
<script type="text/javascript">	
function subs(){
	heji();
	var kaijishijiannew = jQuery("#kaijishijian").val();
			if(kaijishijiannew == "") {
				alert("开机时间必须输入！");
				return false;
			}
		commonSubmit('huidanPreImportListEdit.do?act=update');
}
	</script>
</html>