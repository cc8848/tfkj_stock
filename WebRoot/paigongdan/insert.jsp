<!-- 派工单管理添加工单  -->
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
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/Calendar3.js" language="javascript"></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/common.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="paigongdan/paigongdan.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/interface/dwrService.js'></script> 
		<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/util.js'></script> 
		<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/engine.js'></script> 
		
		
		<script type="text/javascript">
		
			//验证身份证号码是否有效
		function checkIdcard(idcard){    
		  var Errors=["ok","身份证号码位数不对!","身份证号码出生日期超出范围或含有非法字符!","身份证号码校验错误!","身份证地区非法!"];
		  var area={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"};
		  var idcard,Y,JYM;    
		  var S,M;    
		  var idcard_array = [];
		  idcard_array = idcard.split("");    
		  if(area[parseInt(idcard.substr(0,2))]==null) return Errors[4];    
		  switch(idcard.length){    
		    case 15:    
		      if ((parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){    
		         ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//测试出生日期的合法性    
		       }    
		      else{    
		         ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//测试出生日期的合法性    
		       }    
		      if(ereg.test(idcard))    
		        return Errors[0];    
		      else   
		        return Errors[2];    
		    break;    
		  case 18:    
		    if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){    
		       ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//闰年出生日期的合法性正则表达式    
		     }    
		    else{    
		     ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//平年出生日期的合法性正则表达式    
		     }    
		    if(ereg.test(idcard)){    
		       S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7 + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9 + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10 + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5 + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8 + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4 + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2 + parseInt(idcard_array[7]) * 1 + parseInt(idcard_array[8]) * 6 + parseInt(idcard_array[9]) * 3 ;    
		       Y = S % 11;    
		       M = "F";    
		       JYM = "10X98765432";    
		       M = JYM.substr(Y,1);    
		      if(M == idcard_array[17])    
		        return Errors[0];    
		      else   
		        return Errors[3];    
		     }    
		    else   
		      return Errors[2];    
		    break;    
		  default:    
		    return Errors[1];    
		    break;    
		   }    
		} 
		function selectdevice() {
			var xiangmu = document.forms[0].xiangmu.value;
			if(xiangmu == "安装"&&presskbn==0) {
				alert("安装项目必须进行安装比对！");
				return false;
			}
			var selectxiaoqu = document.getElementById("xiaoquname").value;
			selectxiaoqu = encodeURI(encodeURI(selectxiaoqu));
			window.open('<%=basePath%>shebeichukuList.do?act=init&selectkbn=1&selectxiaoqu='+selectxiaoqu,'newwindow','height=500px,width=880px,top=150,left=300,toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no'); 
		}
		function afterselect() {
			document.getElementById("selectxiaoquhidden").value = document.getElementById("xiaoquname").value;
			document.getElementById("xiaoquname").disabled = "disabled";
			document.getElementById("selectxiaoquhidden").disabled = "";
		}
		function backtodept() {
			var xiangmu = document.forms[0].xiangmu.value;
			if(xiangmu == "安装"&&presskbn==0) {
				alert("安装项目必须进行安装比对！");
				return false;
			}
			var communityPID = document.getElementById("selectCommunityPileID").value;
			var communityPID2 = document.getElementById("selectCommunityPileID2").value;
			document.getElementById("btnDeviceBack").disable = "disable";
			jQuery.ajax({
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
							document.getElementById("fenguang").value = "";
						}
						document.getElementById("onumac").value = "";
						document.getElementById("stbmcid").value = "";
						document.getElementById("dianshiip").value = "";
						document.getElementById("eqboxnum").value = "";
						document.getElementById("eqboxnum2").value = "";
						document.getElementById("xiaoquname").disabled = "";
						document.getElementById("selectxiaoquhidden").disabled = "disabled";
						sub();
					} else {
						alert(data);
						return false;
					}
				}
			});
		}
		function initFenguang() {
			if(document.getElementById("fenguangID").value!="") {
				jQuery("#fenguang").attr("readonly","readonly");
			}
		}
		</script>
		
		
		<script type="text/javascript">
	function changelevel1(){
	var URL = "paigongdanEdit.do?act=changekd"; 
	var tfkdnianxian = document.forms[0].tfkdnianxian.value;
		jQuery.ajax({
			url:URL,
			cache:false,
			data:{'tfkdnianxian':encodeURI(tfkdnianxian)},
			success: function(result0){
				if (result0=="null"||result0==""||result0.indexOf("|")!=-1){
				
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
		jQuery.ajax({
			url:URL,
			cache:false,
			data:{'tfkdnianxian':encodeURI(tfkdnianxian)},
			success: function(result0){
				if (result0=="null"||result0==""||result0.indexOf("|")!=-1){
					result0=0;
				}
					document.getElementById("shichangleixing").value = result0;
						}
				});
	}
	function changelevel3(){
	var URL = "paigongdanEdit.do?act=changekddk"; 
	var tfkdnianxian = document.forms[0].tfkdnianxian.value;
		jQuery.ajax({
			url:URL,
			cache:false,
			data:{'tfkdnianxian':encodeURI(tfkdnianxian)},
			success: function(result0){
				if (result0=="null"||result0==""||result0.indexOf("|")!=-1){
					result0=0;
				}
					document.getElementById("tfkuandaidaikuan").value = result0;
						}
				});
	}
	function changelevel4(){
	var URL = "paigongdanEdit.do?act=changekdshichang"; 
	var tfkdnianxian = document.forms[0].tfkdnianxian.value;
		jQuery.ajax({
			url:URL,
			cache:false,
			data:{'tfkdnianxian':encodeURI(tfkdnianxian)},
			success: function(result0){
				if (result0=="null"||result0==""||result0.indexOf("|")!=-1){
					result0=0;
				}
					var beishu = document.getElementById("beishuselect").value;
					result0 = result0 * beishu;
					document.forms[0].tfkuandaishichang.value = result0;
						}
				});
	}
	var presskbn = 0;
	function installCompare() {
		if(check()){
				docompare();
			}
	}
		function installCompareYiJi() {
		if(checkYiJi()){
				docompareYiJi();
			}
	}
	function checkYiJi(){
		var xq = trim(document.getElementById("yichuxiaoqu").value);
		var dz = trim(document.getElementById("yichudizhi").value);
		if(xq==''||xq==null){
			alert("小区不能为空，请选择小区！");
			document.getElementById("yichuxiaoqu").focus();
			return false;
			}
		if(dz==''||dz==null){
			alert("地址不能为空，请输入地址！");
			document.getElementById("yichudizhi").focus();
			return false;
			}
		return true;
		}	
	function changebeishu() {
		changelevel1();
		changelevel4();
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
			var optval = jQuery("#tfkdnianxian option[index="+i+"]").val();
			if(quickvalue=="0"||optval=="0"||optval.indexOf("------")!=-1) {
				continue;
			}
			if(optval.indexOf("带"+quickvalue+"M")==-1&&optval.indexOf(")"+quickvalue+"M")==-1&&optval.indexOf("）"+quickvalue+"M")==-1&&optval.indexOf("】"+quickvalue+"M")==-1) {
				jQuery("#tfkdnianxian option[index="+i+"]").remove();
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
			var optval = jQuery("#qtye option[index="+i+"]").val();
			if(quickvalue=="0"||optval=="0"||optval.indexOf("------")!=-1) {
				continue;
			}
			if(optval.indexOf("品"+quickvalue+"M")==-1&&optval.indexOf("享"+quickvalue+"M")==-1&&optval.indexOf("餐"+quickvalue+"M")==-1) {
				jQuery("#qtye option[index="+i+"]").remove();
			}
		}
		changedainxin();
	}
	function changedainxin(){
	var URL = "paigongdanEdit.do?act=changedianxin"; 
	var tfkdnianxian = document.forms[0].qtye.value;
		jQuery.ajax({
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
						dxchuzhuangfeichange(this);
						}
				});
	}
	function initCompareBtn() {
		var selectxiangmu = document.forms[0].xiangmu.value;
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
		dizhiz = encodeURI(encodeURI(dizhiz));
		window.open('<%=basePath%>anzhuangbiduiList.do?act=init&selectkbn=1&selectxiaoqu='+xiaoquz+'&selectdizhi='+dizhiz,'newwindow','height=500px,width=880px,top=150,left=300,toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
		}
		function docompareYiJi() {
		var xiaoquz = document.getElementById("yichuxiaoqu").value;
		var dizhiz = document.getElementById("yichudizhi").value;
		xiaoquz = encodeURI(encodeURI(xiaoquz));
		dizhiz = encodeURI(encodeURI(dizhiz));
		window.open('<%=basePath%>anzhuangbiduiList.do?act=init&selectkbn=2&selectxiaoqu='+xiaoquz+'&selectdizhi='+dizhiz,'newwindow','height=500px,width=880px,top=150,left=300,toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
		}
		function aftercompareselect() {
			presskbn = 1;
			//document.getElementById("selectxiaoquhidden").value = document.getElementById("xiaoquname").value;
			//document.getElementById("xiaoquname").disabled = "disabled";
			//document.getElementById("selectxiaoquhidden").disabled = "";
		}
		function initAllFalse() {
			enableqiegai(false);
			enableyiji(false);
			document.getElementById("falseqiegai").checked = "true";
			document.getElementById("falseyiji").checked = "true";
		}
	function initkuandai() {
		var xiaoqu = trim(document.getElementById("xiaoquname").value);
		var URL = "shenqingDataEdit.do?act=getKuandai"; 
		jQuery.ajax({
			url:URL,
			cache:false,
			data:{'xiaoqu':encodeURI(xiaoqu)},
			success: function(result0){
				var countNumArray = result0.split("|");
					if(countNumArray.length >0) {
						var str = "<option value=0>--请选择--</option>";
						for(var i=0; i<countNumArray.length; i++) {
							var countNumStr = countNumArray[i];
								if(countNumStr!="") {
									str += "<option value=" + countNumStr + ">" + countNumStr + "</option>"; 
								}
						}
						jQuery("#tfkdnianxian").html(str);
						initshichangoption = document.getElementById("tfkdnianxian").innerHTML;
				}
			}
		});
	}
	function initdianshi() {
		var xiaoqu = trim(document.getElementById("xiaoquname").value);
		var URL = "shenqingDataEdit.do?act=getDianshi"; 
		jQuery.ajax({
			url:URL,
			cache:false,
			data:{'xiaoqu':encodeURI(xiaoqu)},
			success: function(result0){
				var countNumArray = result0.split("|");
					if(countNumArray.length >0) {
						var str = "<option value=0>--请选择--</option>";
						for(var i=0; i<countNumArray.length; i++) {
							var countNumStr = countNumArray[i];
								if(countNumStr!="") {
									str += "<option value=" + countNumStr + ">" + countNumStr + "</option>"; 
								}
						}
						jQuery("#shichangtv").html(str);
				}
			}
		});
	}
	function initKaijishijian() {
		jQuery("#kaijishijian").val(jQuery("#paigongriqi").val());
		initTingjishijian();
	}
	function initTingjishijian() {
		changelevel5();
	}
	function changelevel5(){
					var URL = "shenqingDataEdit.do?act=changekdsj"; 
					var shichang = document.forms[0].tfkdnianxian.value;
						jQuery.ajax({
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
						jQuery.ajax({
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
	<body onload="init();initanzhuang();initFenguang();initAllFalse();initkuandai();initKaijishijian();">  
		<html:form action="equipStockEdit.do">
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">
				添加派工单
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table" >
				<table border="0" cellspacing="0" cellpadding="2" width="100%">
				<!-- 检索项 start -->
				<tr >
						<td class="editTableTitle" style="width: 200px">用户信息：</td>
						<td class="editTableContent" style="width: 900px">
						<table>
						<tr >
							<td colspan="2">
							用户姓名：
							<html:text name="paiGongDanEntiyForm" property="username"size="12" maxlength="20"
									styleClass="commonTextFieldHover"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" />
							<html:hidden name="paiGongDanEntiyForm" styleId="biduikbn" property="biduikbn"></html:hidden>
								<a:need />
								身份证号：
								<html:text name="paiGongDanEntiyForm" property="shenfenzheng"size="12" maxlength="20"
									styleClass="commonTextFieldHover"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" style="width: 200px"/>
							<a:need />
							
							</td>
						</tr>
						<tr>
						<td colspan="2">
						小区名称：
								<html:select name="paiGongDanEntiyForm" property="xiaoquname" styleId="xiaoquname"
									styleClass="commonTextFieldHover"  onchange="selectxiaoqu(this);initkuandai();initdianshi();"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value=" ">请选择</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select>
							<a:need />
							<html:hidden name="paiGongDanEntiyForm" property="xiaoquname" styleId="selectxiaoquhidden"/>  
						用户地址：
						<html:text name="paiGongDanEntiyForm" property="userplace"size="12"maxlength="20" styleId="userplace"
								styleClass="commonTextFieldHover"	onchange="isture(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
							<a:need />
						
						
						</td>	
						</tr>
						<tr>
							<td colspan="2">
								联系电话：
							<html:text name="paiGongDanEntiyForm" property="usertel" size="12"maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
							<a:need />	
						<html:button property="btnSave" value="检测" styleClass="commonButton" onclick="testDwr();"/>
							</td>
						</tr>
							</table>
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" style="width: 200px">派工日期：</td>
						<td class="editTableContent" >
						
						派工日期：
							<html:text name="paiGongDanEntiyForm" property="paigongriqi"  styleId="paigongriqi"size="12"
								styleClass="commonTextFieldHover"  onclick="new Calendar().show(this)" onchange="initKaijishijian()"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover';initKaijishijian();"/>
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
						项目：
							<html:select name="paiGongDanEntiyForm" property="xiangmu" 
								styleClass="commonTextFieldHover"  onchange="initCompareBtn()"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">请选择</html:option>
								<html:option value="安装">安装</html:option>
								<html:option value="收件">收件</html:option>
								<html:option value="续费">续费</html:option>
								<html:option value="退户">退户</html:option>
								<html:option value="维修">维修</html:option>
							</html:select>	
							<a:need />	
							<html:button styleId="btnCompare" property="btnCompare" value="安装比对" styleClass="commonButton2" onclick="installCompare();"/>
							<font color="blue">预约安装必点/线路切改必点</font>		
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" style="width: 200px" rowSpan="2">移机&切改：</td>
						<td class="editTableContent" ><font color="blue">是否切改线路（电信）或（铁通）：</font>
						<html:radio name="paiGongDanEntiyForm" styleId="falseqiegai" property="isQiegai" value="0" onclick="enableqiegai(false);">否</html:radio><html:radio name="paiGongDanEntiyForm" styleId="trueqiegai" property="isQiegai" value="1" onclick="enableqiegai(true);">是</html:radio><a:need />
						带宽：
						<html:text name="paiGongDanEntiyForm" property="qiegaidaikuan"  styleId="qiegaidaikuan"size="12"
								styleClass="commonTextFieldHover"  readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
								<font id="qiegaimust1" color="#ff0000">*</font>
						停机时间：
							<html:text name="paiGongDanEntiyForm" property="qiegaitingjishijian"  styleId="qiegaitingjishijian"size="12"
								styleClass="commonTextFieldHover" onclick="new Calendar().show(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
								<font id="qiegaimust2" color="#ff0000">*</font></td>
					</tr>
					<tr height="35px">
						<td class="editTableContent" >是否移机：
						<html:radio name="paiGongDanEntiyForm" styleId="falseyiji" property="isYiji" value="0" onclick="enableyiji(false);">否</html:radio><html:radio name="paiGongDanEntiyForm" property="isYiji" value="1" onclick="enableyiji(true);">是</html:radio><a:need />
						移出小区：
								<html:select name="paiGongDanEntiyForm" property="yichuxiaoqu" styleId="yichuxiaoqu"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value=" ">请选择</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select>
								<font id="yichumust1" color="#ff0000">*</font>
						移出地址：
						<html:text name="paiGongDanEntiyForm" property="yichudizhi"size="12"maxlength="20" styleId="yichudizhi"
								styleClass="commonTextFieldHover"	onchange="isture2(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
								<font id="yichumust2" color="#ff0000">*</font>
						<html:button styleId="btnCompareYiJi" property="btnCompare" value="移机比对" styleClass="commonButton2" onclick="installCompareYiJi();"/>
							<font color="brown">移机必点</font>	
						</br>
						移出宽带：
						<html:text name="paiGongDanEntiyForm" property="yichuyewu"size="12"maxlength="20" styleId="yichuyewu" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> 
						移出电视：
						<html:text name="paiGongDanEntiyForm" property="yichudianshi"size="12"maxlength="20" styleId="yichudianshi" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> 
						移出其他业务：
						<html:text name="paiGongDanEntiyForm" property="yichuqita"size="12"maxlength="20" styleId="yichuqita" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> 
						移机费：
						<input type="text" maxlength="20" id="yijifei" styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" onchange="setvalueschuzhuangfei(this)"/>
						</br>
						网络停机时间：
						<html:text name="paiGongDanEntiyForm" property="yichutingjishijian"size="12"maxlength="20" styleId="yichutingjishijian" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> 
						电视停机时间：
						<html:text name="paiGongDanEntiyForm" property="yichutingjishijiands"size="12"maxlength="20" styleId="yichutingjishijiands" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> 
						其他业务停机时间：
						<html:text name="paiGongDanEntiyForm" property="yichutingjishijianqt"size="12"maxlength="20" styleId="yichutingjishijianqt" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> 
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" style="width: 200px">单证：</td>
						<td class="editTableContent" >
						已见电信返单：
							<html:checkbox name="paiGongDanEntiyForm" property="dxfandan" value="1"></html:checkbox>
						证件齐全：
							<html:checkbox name="paiGongDanEntiyForm" property="zhengjian" styleId="zhengjian" value="1"></html:checkbox>
						</td>
						</tr>
					<tr >
						<td class="editTableTitle" style="width: 200px">天房宽带：</td>
						<td class="editTableContent" >
						<table>
						<tr>
							<td>
								时长类型：
								
								<html:text name="paiGongDanEntiyForm" property="shichangleixing"size="12" value="0"maxlength="20"
									styleClass="commonTextFieldHover" styleId="shichangleixing" readonly="true"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" />
							</td>
							<td>
								带宽：
									<html:text name="paiGongDanEntiyForm" property="tfkuandaidaikuan"size="12" value="0"maxlength="20"
									styleClass="commonTextFieldHover" styleId="tfkuandaidaikuan" readonly="true"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								时长:
								<html:select name="paiGongDanEntiyForm" property="tfkdnianxian" styleId="tfkdnianxian"
									styleClass="commonTextFieldHover"  
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" onchange="changelevel1(), changelevel2(), changelevel3(),changelevel4();initTingjishijian();">
									<html:option value="0">--请选择--</html:option>
								</html:select>
								<select id="scquickselect" onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'" onchange="changeshichang()">
									<option value="0">--请选择--</option>
									<option value="4">4M</option>
									<option value="12">12M</option>
									<option value="20">20M</option>
									<option value="50">50M</option>
									<option value="100">100M</option>
									<option value="2">2M</option>
									<option value="3">3M</option>
									<option value="6">6M</option>
									<option value="10">10M</option>
								</select>
								资费调整倍数：
								<html:select name="paiGongDanEntiyForm"  styleId="beishuselect" property="beishuselect" styleClass="commonTextFieldHover"   onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'" onchange="changebeishu();initTingjishijian();">
									<html:option value="1">X1</html:option><html:option value="2">X2</html:option><html:option value="3">X3</html:option><html:option value="4">X4</html:option><html:option value="5">X5</html:option>
									<html:option value="6">X6</html:option><html:option value="7">X7</html:option><html:option value="8">X8</html:option><html:option value="9">X9</html:option><html:option value="10">X10</html:option>
									<html:option value="11">X11</html:option><html:option value="12">X12</html:option><html:option value="13">X13</html:option><html:option value="14">X14</html:option><html:option value="15">X15</html:option>
									<html:option value="16">X16</html:option><html:option value="17">X17</html:option><html:option value="18">X18</html:option><html:option value="19">X19</html:option><html:option value="20">X20</html:option>
									<html:option value="21">X21</html:option><html:option value="22">X22</html:option><html:option value="23">X23</html:option><html:option value="24">X24</html:option><html:option value="25">X25</html:option>
									<html:option value="26">X26</html:option><html:option value="27">X27</html:option><html:option value="28">X28</html:option><html:option value="29">X29</html:option><html:option value="30">X30</html:option>
									<html:option value="31">X31</html:option><html:option value="32">X32</html:option><html:option value="33">X33</html:option><html:option value="34">X34</html:option><html:option value="35">X35</html:option>
									<html:option value="36">X36</html:option><html:option value="37">X37</html:option><html:option value="38">X38</html:option><html:option value="39">X39</html:option><html:option value="40">X40</html:option>
								</html:select>
							</td>
						</tr>
						<tr>
							<td>
							初装费：
								<html:text name="paiGongDanEntiyForm" property="tfkdczf"size="12"
									styleClass="commonTextFieldHover" styleId="tfkdczf" onchange="setvalueschuzhuangfei(this)"
									onfocus="this.className='commonTextFieldMove'" maxlength="20"
									onblur="this.className='commonTextFieldHover'" />
							</td>
							
							<td>
							宽带费：
							<html:text name="paiGongDanEntiyForm" property="tfkuandaifei"size="12" value="0"maxlength="20"
									styleClass="commonTextFieldHover" styleId="tfkuandaifei" onchange="setvalues(this,'kuaidaifei')"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'"  readonly="true"/>
							<!-- ONU押金：
							<html:text name="paiGongDanEntiyForm" property="anzhuangshijian" size="12"
									styleClass="commonTextFieldHover" styleId="tfkuandaionu"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" />
							 -->		
							 <html:hidden name="paiGongDanEntiyForm" property="tfkuandaishichang"></html:hidden>	
							</td>
						</tr>
						</table>
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" style="width: 200px">天房IPTV：</td>
						<td class="editTableContent" >
						<table>
						<tr>
							<td>
								数量：
								<html:select name="paiGongDanEntiyForm" property="tfiptv" 
								styleClass="commonTextFieldHover"  styleId="tfiptvshuliang" onchange="cleartfiptv()"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--请选择--</html:option>
								<html:option value="标清">标清</html:option>
								<html:option value="两个标清">两个标清</html:option>
								<html:option value="三个标清">三个标清</html:option>
								<html:option value="四个标清">四个标清</html:option>
								<html:option value="高清">高清</html:option>
								<html:option value="两个高清">两个高清</html:option>
								<html:option value="三个高清">三个高清</html:option>
								<html:option value="四个高清">四个高清</html:option>
								<html:option value="一个标清与一个高清">一个标清与一个高清</html:option>
								<html:option value="高点">高点</html:option>
								</html:select>
							</td>
							<td>
							时长：
					<html:select name="paiGongDanEntiyForm" property="tfiptvnianxian"  
								styleClass="commonTextFieldHover"  styleId="tfiptvshichang"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--请选择--</html:option>
								<html:option value="1">1年</html:option><html:option value="2">2年</html:option>
								<html:option value="3">3年</html:option><html:option value="4">4年</html:option>
								<html:option value="5">5年</html:option>	
						</html:select>	 
<!-- 							<html:select name="paiGongDanEntiyForm" property="tfiptvnianxian" styleId="tfiptvshichang"
								styleClass="commonTextFieldHover"  
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" >
									<html:option value="0">--请选择--</html:option>
								<html:options collection="shichangtvList" property="key" labelProperty="value" />
							</html:select>	    -->	
							</td>
						</tr>
						<tr>
						<td>		
						收视费：
						<html:text name="paiGongDanEntiyForm" property="tfiptvshoushifei" size="12"
								styleClass="commonTextFieldHover" styleId="tfiptvshoushifei" onchange="setvalues(this,'shoushifei')"
								onfocus="this.className='commonTextFieldMove'" maxlength="20"
								onblur="this.className='commonTextFieldHover'" />（元）		
						</td>
						<td>
						机顶盒押金：
						<html:text name="paiGongDanEntiyForm" property="tfjidingheyajin" size="12"maxlength="20"
								styleClass="commonTextFieldHover" styleId="tfjidingheyajin" onchange="setvalues(this,'jidinghe')"
								onfocus="this.className='commonTextFieldMove'"
								onblur="this.className='commonTextFieldHover'" />（元）
						</td>
						
						</tr>
						</table>		
						</td>
					</tr>
						<tr >
						<td class="editTableTitle" width="30px">其他运营商业务：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						套餐：
							
								<html:select name="paiGongDanEntiyForm" property="qtye" styleId="qtye"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'"  onchange="changedainxin()"
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--请选择--</html:option>
								<html:options collection="dianxintaocan" property="key" labelProperty="value" />
								</html:select>
								<select id="scquickselect2" onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'" onchange="changeshichang2()">
									<option value="0">--请选择--</option>
									<option value="4">4M</option>
									<option value="12">12M</option>
									<option value="20">20M</option>
									<option value="50">50M</option>
									<option value="100">100M</option>
									<option value="2">2M</option>
									<option value="3">3M</option>
									<option value="6">6M</option>
									<option value="10">10M</option>
								</select>
						初装费：
								<html:select name="paiGongDanEntiyForm" property="dxchuzhuangfei" 
								styleClass="commonTextFieldHover"  styleId="dxchuzhuangfei" onchange="dxchuzhuangfeichange(this)"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">-请选择-</html:option>
								<!--<html:option value="0">零个0元</html:option>-->
								<html:option value="205">一个205元</html:option>
								<html:option value="410">二个410元</html:option>
								<html:option value="615">三个615元</html:option>
								<html:option value="820">四个820元</html:option>
								</html:select>		
						</td>
						</tr>
						<tr>
						<td>	
						费用：&nbsp;
						<html:text name="paiGongDanEntiyForm" property="fufei" size="12"
								styleClass="commonTextFieldHover" onchange="setvalues(this,'nianfei')"
								onfocus="this.className='commonTextFieldMove'" maxlength="20"
								onblur="this.className='commonTextFieldHover'" />
						
						不足月：
						<html:text name="paiGongDanEntiyForm" property="qtbuzuyue" size="12" onchange="setvalues(this,'buzuyue')"
								styleClass="commonTextFieldHover" styleId="qtbuzuyue" maxlength="20"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						</table>
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >设备信息：</td>
							<td class="editTableContentLast" >
							分光：
							<html:text styleId="fenguang" name="paiGongDanEntiyForm" property="fenguang" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<html:hidden styleId="fenguangID" name="paiGongDanEntiyForm" property="fenguangID" />	
							<html:hidden styleId="selectCommunityPileID" name="paiGongDanEntiyForm" property="selectCommunityPileID" />
							<html:hidden styleId="eqboxnum" name="paiGongDanEntiyForm" property="eqboxnum" />	
							<html:hidden styleId="selectCommunityPileID2" name="paiGongDanEntiyForm" property="selectCommunityPileID2" />
							<html:hidden styleId="eqboxnum2" name="paiGongDanEntiyForm" property="eqboxnum2" />	
							<html:hidden styleId="bdfenguang" name="paiGongDanEntiyForm" property="bdfenguang" />
							<html:hidden styleId="bdonumac" name="paiGongDanEntiyForm" property="bdonumac" />
							<html:hidden styleId="bdstbmcid" name="paiGongDanEntiyForm" property="bdstbmcid" />
							<html:hidden styleId="bddianshiip" name="paiGongDanEntiyForm" property="bddianshiip" />
							
							<html:hidden styleId="yjfenguang" name="paiGongDanEntiyForm" property="yjfenguang" />
							<html:hidden styleId="yjonumac" name="paiGongDanEntiyForm" property="yjonumac" />
							<html:hidden styleId="yjstbmcid" name="paiGongDanEntiyForm" property="yjstbmcid" />
							<html:hidden styleId="yjdianshiip" name="paiGongDanEntiyForm" property="yjdianshiip" />
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
							<html:text styleId="dianshiip" name="paiGongDanEntiyForm" property="dianshiip" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
							<html:button property="btnSelectDevice" value="挑选设备" styleClass="commonButton2" onclick="selectdevice();"/>
							<html:button styleId="btnDeviceBack" property="btnDeviceBack" value="设备回库" styleClass="commonButton2" onclick="backtodept();"/>
						<br/>
						</td>
								
					</tr>
						<tr >
						<td class="editTableTitle" width="30px">所选号码：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						号码1&nbsp;
							<html:text name="paiGongDanEntiyForm" property="telhaoma1" size="12"maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						号码2&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma2" size="12"maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>		
						</tr>	
						<tr>
						<td>	
						号码3&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma3" size="12"maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						号码4&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma4" size="12"maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>		
						</table>		
						</td>
					</tr>
					
						
					
					<tr >
						<td class="editTableTitle" width="30px">应收费用：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td id="onutd">
						ONU押金：
							<!--<html:text name="paiGongDanEntiyForm" property="onu" size="8"
								styleClass="commonTextFieldHover" value="0" styleId="onu"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />-->
								
							<html:select name="paiGongDanEntiyForm" property="onu" 
								styleClass="commonTextFieldHover"  styleId="onu" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">0元</html:option>
								<html:option value="200">200元</html:option>
								<html:option value="400">400元</html:option>
							</html:select>
						</td>	
						<td id="jiaohuanjiid">
						交换机：&nbsp;
						<!-- 	<html:text name="paiGongDanEntiyForm" property="jiaohuanji" size="8"
								styleClass="commonTextFieldHover"  styleId="jiaohuanji" value="0"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> -->
								<html:select name="paiGongDanEntiyForm" property="jiaohuanji" 
								styleClass="commonTextFieldHover"  styleId="jiaohuanji" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">0元</html:option>
								<html:option value="50">50元</html:option>	
							</html:select>
						</td>
						<td>	
						收视费：
						<html:text name="paiGongDanEntiyForm" property="shoushifei" size="8"
								styleClass="commonTextFieldHover" styleId="shoushifei"maxlength="20"readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>
						机顶盒押金：
						<html:text name="paiGongDanEntiyForm" property="jidinghe" size="8"
								styleClass="commonTextFieldHover" styleId="jidinghe"maxlength="20"readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>	
						年费：
						<html:text name="paiGongDanEntiyForm" property="nianfei" size="8"
								styleClass="commonTextFieldHover" styleId="nianfei"maxlength="20"readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td>		
						不足月：&nbsp;
						<html:text name="paiGongDanEntiyForm" property="buzuyue" size="8"
								styleClass="commonTextFieldHover" styleId="buzuyue"maxlength="20"readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						初装费：
						<html:text name="paiGongDanEntiyForm" property="chuzhuangfei" size="8"maxlength="20"readonly="true"
								styleClass="commonTextFieldHover" value="0" styleId="chuzhuangfei"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						设备销售费：
						<html:text name="paiGongDanEntiyForm" property="shebeixiaoshou" size="8"maxlength="20"readonly="false"
								styleClass="commonTextFieldHover" styleId="shebeixiaoshou"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						材料费：
						<html:text name="paiGongDanEntiyForm" property="cailiaofei" size="8"maxlength="20"readonly="false"
								styleClass="commonTextFieldHover" styleId="cailiaofei"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td>		
						宽带费：&nbsp;&nbsp;&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="kuaidaifei" size="8" readonly="true"
								styleClass="commonTextFieldHover"  styleId="kuaidaifei"maxlength="20"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
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
						<td class="editTableTitleLast" >开票信息：</td>
						<td class="editTableContentLast" >
							<html:textarea name="paiGongDanEntiyForm" property="kaipiaoxinxi"  onkeyup="if(this.value.length>200)this.value=this.value.substr(0,200)"
								rows="5" cols="70" ></html:textarea>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >备注：</td>
						<td class="editTableContentLast" >
							<html:textarea name="paiGongDanEntiyForm" property="beizhu"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)"
								rows="5" cols="70" ></html:textarea>
						</td>
					</tr>
				</table>
				</div>
			</div>
			<!--  新增编辑 end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="保存" styleClass="commonButton" onclick="sub();"/>
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('paigongdanList.do?act=init')"/>
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
								onblur="this.className='commonTextFieldHover';initTingjishijian();"/><a:need />
				停机时间：
				<html:text name="paiGongDanEntiyForm" property="tingjishijian"  styleId="tingjishijian"size="12"
								styleClass="commonTextFieldHover"  readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
				（可手动指定开机时间）
			</div>
		</div>
		</html:form>
	
	<script type="text/javascript">
	function testDwr(){
		if(check()){
			subDWR("1");
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
	
	function subDWR(type){
	var kaijishijiannew = jQuery("#kaijishijian").val();
			if(kaijishijiannew == "") {
				alert("开机时间必须输入！");
				return false;
			}
		var xiaoquz = document.getElementById("xiaoquname").value;
		var dizhiz = document.getElementById("userplace").value;
		var p ={
				dizhi:dizhiz,
				xiaoqu:xiaoquz	
				};
		if(type=="1"){
		 	dwrService.testDwr(p,callBackCardNo);
		}
		if(type=="2"){
			dwrService.testDwr(p,callBackCardNo1);	
		}
	}
	//dwr回调函数 点击测试时触发 
	callBackCardNo = function(data){
		//alert("11");
		if(data=="N"){
			alert("该用户系统中没有有效记录，可以录入");
			return true;
		}else{
			alert("该用户已经在"+data+"预定过");
			return false;
			}
		};
	//dwr回调函数 点击保存时触发 
	callBackCardNo1 = function(data){
		if(data=="N"){
			commonSubmit('paigongdanEdit.do?act=insert');
		}else{
			if(confirm("该用户已经在"+data+"预定过,是否忽略？")){
				commonSubmit('paigongdanEdit.do?act=insert');
				}
			}
		
		};

	//详细信息查看
	//function showInfo(){
	//	 if(document.forms[0].xiaoquname.value=="海景公寓"||
	//			 document.forms[0].xiaoquname.value=="天欣花园"||document.forms[0].xiaoquname.value=="福悦里"){
	//		 document.getElementById("jiaohuanjiid").style.display="";
	//			document.getElementById("onu").value="0";
	//			document.getElementById("onutd").style.display="none";
	//		 }
	//}
	//showInfo();

	//提交
	function sub(){
		heji();
		if(checkInput1()){
			var kaijishijiannew = jQuery("#kaijishijian").val();
			if(kaijishijiannew == "") {
				alert("开机时间必须输入！");
				return false;
			}
			var xiangmu = document.forms[0].xiangmu.value;
			var yuyingshang = document.forms[0].yuyingshang.value;
			var shenfenzheng = document.forms[0].shenfenzheng.value;
			var tfkuandaidaikuan = document.forms[0].tfkuandaidaikuan.value;
			var yw = document.getElementById("qtye").value;
			var kuandai = document.getElementById("tfkdnianxian").value;
			var dianshi = document.getElementById("tfiptvshuliang").value;
			if(xiangmu == "安装"&&presskbn==0) {
				alert("安装项目必须进行安装比对！");
				return false;
			}
			var qiegaidaikuan = document.getElementById("qiegaidaikuan").value;
			var yichuyewu = document.getElementById("yichuyewu").value;
			var yichudianshi = document.getElementById("yichudianshi").value;
			var yichuqita = document.getElementById("yichuqita").value;
			var isnotyiji = document.getElementById("falseyiji").checked;
			var isnotqiegai = document.getElementById("falseqiegai").checked;
			if(isnotqiegai) {
					if(yw=="0"&&kuandai=="0"&&dianshi==0&&isnotyiji) {
					alert("天房宽带、天房IPTV、其他运营商业务必须选一个！");
					return false;
					}
				}else{
					tfkuandaidaikuan = qiegaidaikuan;
					if(qiegaidaikuan==""||qiegaidaikuan=="0") {
						alert("天房宽带、天房IPTV、其他运营商业务必须选一个！");
						return false;
					}
				}
			if(isnotyiji) {
					if(yw=="0"&&kuandai=="0"&&dianshi==0&&isnotqiegai) {
					alert("天房宽带、天房IPTV、其他运营商业务必须选一个！");
					return false;
					}
				}else{
					tfkuandaidaikuan = yichuyewu;
					if((yichuyewu==""||yichuyewu=="0")&&(yichudianshi==""||yichudianshi=="0")&&(yichuqita==""||yichuqita=="0")) {
						alert("天房宽带、天房IPTV、其他运营商业务必须选一个！");
						return false;
					}
				}
			if(yuyingshang == "电信" && (tfkuandaidaikuan != '0' && tfkuandaidaikuan != '')) {
				if(shenfenzheng==null||trim(shenfenzheng)=="0"){
					alert("办理电信业务身份证号码不能为空！");
					document.forms[0].shenfenzheng.focus();//设置焦点
					return false;
				}
				if(checkIdcard(shenfenzheng) != "ok") {
					alert("身份证有误！请核对！");
					document.forms[0].shenfenzheng.focus();//设置焦点
					return false;
				}
			}
			
			subDWR("2");
			}
	}
	
	function isture2(obj){
		if(!ismenhao(obj.value)){
			alert("请输入正确的地址格式！例如：11-1-1111 或者 11-11");
			//document.getElementById("userplace").focus();
			document.forms[0].yichudizhi.focus();
			return false;
			}
		}
	function enableyiji(obj) {
		if(!obj) {
			document.forms[0].yichuxiaoqu.disabled = "disabled";
			document.forms[0].yichudizhi.disabled = "disabled";
			document.getElementById("btnCompareYiJi").disabled = "disabled";
			document.getElementById("yichumust1").style.display="none";
			document.getElementById("yichumust2").style.display="none";
			document.getElementById("yijifei").value="0";
			document.getElementById("qtye").disabled = "";
			document.getElementById("tfkdnianxian").disabled = "";
			document.getElementById("tfiptvshuliang").disabled = "";
			document.getElementById("yichuyewu").disabled = "disabled";
			document.getElementById("yichudianshi").disabled = "disabled";
			document.getElementById("yichuqita").disabled = "disabled";
			document.getElementById("yichutingjishijian").disabled = "disabled";
			document.getElementById("yichutingjishijiands").disabled = "disabled";
			document.getElementById("yichutingjishijianqt").disabled = "disabled";
		}else{
			document.getElementById("falseqiegai").checked = "true";
			enableqiegai(false);
			document.forms[0].yichuxiaoqu.disabled = "";
			document.forms[0].yichudizhi.disabled = "";
			document.getElementById("btnCompareYiJi").disabled = "";
			document.getElementById("yichumust1").style.display="";
			document.getElementById("yichumust2").style.display="";
			document.getElementById("yijifei").value="150";
			document.getElementById("qtye").disabled = "disabled";
			document.getElementById("tfkdnianxian").disabled = "disabled";
			document.getElementById("tfiptvshuliang").disabled = "disabled";
			document.getElementById("yichuyewu").disabled = "";
			document.getElementById("yichudianshi").disabled = "";
			document.getElementById("yichuqita").disabled = "";
			document.getElementById("yichutingjishijian").disabled = "";
			document.getElementById("yichutingjishijiands").disabled = "";
			document.getElementById("yichutingjishijianqt").disabled = "";
			document.getElementById("chuzhuangfei").value=
			parseInt(document.getElementById("yijifei").value)+parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
		}
	}
	function enableqiegai(obj) {
		if(!obj) {
			document.forms[0].qiegaidaikuan.disabled = "disabled";
			document.forms[0].qiegaitingjishijian.disabled = "disabled";
			document.getElementById("qiegaimust1").style.display="none";
			document.getElementById("qiegaimust2").style.display="none";
		}else{
			document.getElementById("falseqiegai").checked = "true";
			enableqiegai(false);
			document.getElementById("falseyiji").checked = "true";
			enableyiji(false);
			//document.forms[0].qiegaidaikuan.disabled = "";
			//document.forms[0].qiegaitingjishijian.disabled = "";
			//document.getElementById("qiegaimust1").style.display="";
			//document.getElementById("qiegaimust2").style.display="";
		}
	}
	function initanzhuang() {
		changelevel1();
		changelevel2();
		changelevel3();
		changelevel4();
		changedainxin();
		if(document.forms[0].tfkdczf.value=="") {
			document.forms[0].tfkdczf.value="0";
		}
		if(document.forms[0].tfiptvshoushifei.value=="") {
			document.forms[0].tfiptvshoushifei.value="0";
		}
		if(document.forms[0].tfjidingheyajin.value=="") {
			document.forms[0].tfjidingheyajin.value="0";
		}
		if(document.forms[0].telhaoma1.value=="") {
			document.forms[0].telhaoma1.value="00000000";
		}
		if(document.forms[0].telhaoma2.value=="") {
			document.forms[0].telhaoma2.value="00000000";
		}
		if(document.forms[0].telhaoma3.value=="") {
			document.forms[0].telhaoma3.value="00000000";
		}
		if(document.forms[0].telhaoma4.value=="") {
			document.forms[0].telhaoma4.value="00000000";
		}
		if(document.forms[0].shoushifei.value=="") {
			document.forms[0].shoushifei.value="0";
		}
		if(document.forms[0].jidinghe.value=="") {
			document.forms[0].jidinghe.value="0";
		}
		if(document.forms[0].nianfei.value=="") {
			document.forms[0].nianfei.value="0";
		}
		if(document.forms[0].buzuyue.value=="") {
			document.forms[0].buzuyue.value="0";
		}
		if(document.forms[0].shebeixiaoshou.value=="") {
			document.forms[0].shebeixiaoshou.value="0";
		}
		if(document.forms[0].cailiaofei.value=="") {
			document.forms[0].cailiaofei.value="0";
		}
		if(document.forms[0].xiangmu.value=="") {
			document.forms[0].xiangmu.value="安装";
		}
	}
</script>
</body>
</html>