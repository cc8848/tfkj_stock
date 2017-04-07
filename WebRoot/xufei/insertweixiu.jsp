<!---->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>���ٿ��������ʾ��Ŀ</title>
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
		//����XMLHttpRequest����   
		function createXMLHttpRequest() {
			if (window.XMLHttpRequest) { //Mozilla �����
				XMLHttpReq = new XMLHttpRequest();
			} else {
				if (window.ActiveXObject) { // IE�����			
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
		//��������
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
		//post����������
		function sendRequestPost(url, params) {
			params=encodeURI(params); 
	        params=encodeURI(params);  
			createXMLHttpRequest();
			XMLHttpReq.open("POST", url, true);
			XMLHttpReq.onreadystatechange = processResponse;//ָ����Ӧ����
			XMLHttpReq.setRequestHeader("Content-Type" , "application/x-www-form-urlencoded ; charset=GBK");
			XMLHttpReq.send(params); // ��������
		}
		//get����������
		function sendRequestGet(url) {
			createXMLHttpRequest();
			XMLHttpReq.open("GET", url, true);
			XMLHttpReq.onreadystatechange = processResponse;//ָ����Ӧ����
			XMLHttpReq.send(null); // ��������
		}
		//post����������(���贫�ݲ���ʱ)
		function sendRequestPostwihtnoArgs(url) {
			createXMLHttpRequest();
			XMLHttpReq.open("POST", url, true);
			XMLHttpReq.onreadystatechange = processResponse;//ָ���ص�����
			XMLHttpReq.send(null); // ��������
		}
		// ��������Ϣ����
		function processResponse() {
			if (XMLHttpReq.readyState == 4) { // �ж϶���״̬
				if (XMLHttpReq.status == 200) { //��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
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
					//ҳ�治����
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
					alert("�豸�ؿ�ɹ���");
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
			<!-- ���� -->
			<div class="conten_top" name="top">
				����ά������
			</div>
			<!--  �����༭ start -->
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="960px">
					<tr >
						<td class="editTableTitle" >С����</td>
						<td class="editTableContent1" id="xiaoqutd">С�����ƣ�
						<html:select name="jiaofeiDataFrom" property="xiaoqu" styleId="selectxiaoqu"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
						<html:options collection="xiaoquList" property="key" labelProperty="value" /> 
						</html:select><a:need />
						<html:hidden name="jiaofeiDataFrom" property="xiaoqu" styleId="selectxiaoquhidden"/>  
							 &nbsp; &nbsp; 
							С����ַ(��ʽ��xx-x-xxxx)��
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
						<td class="editTableTitle" >��Ӫ�̣�</td>
						<td class="editTableContent">��Ӫ�̣�
						<html:select name="jiaofeiDataFrom" property="yunyingshang" 
								styleClass="commonTextFieldHover"  styleId="yunyingshang"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--��ѡ��--</html:option>
								<html:option value="����">����</html:option>
								<html:option value="��ͨ">��ͨ</html:option>
								<html:option value="���">���</html:option>
								<html:option value="��ͨ">��ͨ</html:option>
								<html:option value="�췿">�췿</html:option>
							</html:select>	<a:need />
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >ά��ʱ�䣺</td>
						<td class="editTableContent">
						ά��ʱ�䣺
						 <html:text name="jiaofeiDataFrom" property="weixiushijian" styleId="weixiushijian" size="10" onclick="WdatePicker({el:'weixiushijian'})" />
						 <img onclick="WdatePicker({el:'weixiushijian'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>  
						 <a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >ʩ���ˣ�</td>
						<td class="editTableContent">
						ʩ���ˣ�
							<html:text name="jiaofeiDataFrom" property="shigongren" maxlength="150" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >ά�����ͣ�</td>
						<td class="editTableContent">
						ά�����ͣ�
							<html:select name="jiaofeiDataFrom" property="weixiuleixing" style="visibility: visible;"
								styleClass="commonTextFieldHover"  
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="δѡ��">--��ѡ��--</html:option>
								<html:option value="�豸����">�豸����</html:option>
								<html:option value="ƽ̨����">ƽ̨����</html:option>
								<html:option value="FTTH����">FTTH����</html:option>
								<html:option value="�����ս�">�����ս�</html:option>
								<html:option value="��������">��������</html:option>
								<html:option value="�ռ�">�ռ�</html:option>
						</html:select><a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >ά�����ݣ�</td>
						<td class="editTableContentLast" >
							<html:textarea name="jiaofeiDataFrom" property="weixiuneirong"  
							rows="3" cols="70"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
							</html:textarea><a:need /><br/>
						</td>
								
					</tr>
					<tr >
						<td class="editTableTitle" >�豸��Ϣ��</td>
							<td class="editTableContentLast" >
							�ֹ⣺
							<html:text styleId="fenguang" name="jiaofeiDataFrom" property="fenguang" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
								<html:hidden styleId="fenguangID" name="jiaofeiDataFrom" property="fenguangID" />
							<html:hidden styleId="selectCommunityPileID" name="jiaofeiDataFrom" property="selectCommunityPileID" />
							<html:hidden styleId="eqboxnum" name="jiaofeiDataFrom" property="eqboxnum" />	
							<html:hidden styleId="selectCommunityPileID2" name="jiaofeiDataFrom" property="selectCommunityPileID2" />
							<html:hidden styleId="eqboxnum2" name="jiaofeiDataFrom" property="eqboxnum2" />		
							
							onu mac��
							<html:text styleId="onumac" name="jiaofeiDataFrom" property="onumac" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<br/>
							STB MCID��
							<html:text styleId="stbmcid" name="jiaofeiDataFrom" property="stbmcid" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							����IP��
							<html:text styleId="dianshiip" name="jiaofeiDataFrom" property="dianshiip" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
							<html:button property="btnSelectDevice" value="��ѡ�豸" styleClass="commonButton2" onclick="selectdevice();"/>
							<html:button styleId="btnDeviceBack" property="btnDeviceBack" value="�豸�ؿ�" styleClass="commonButton2" onclick="backtodept();"/>
						<br/>
						</td>
								
					</tr>
					<tr>
						<td class="editTableTitle" >�շѣ�</td>
						<td class="editTableContent" >
							����ѣ�
							<html:text name="jiaofeiDataFrom" property="kuandaifei" maxlength="50"  onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
									
							���ӷѣ�
							<html:text name="jiaofeiDataFrom" property="shoushifei" maxlength="50"  onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<br/>
							��װ�ѣ�
							<html:text name="jiaofeiDataFrom" property="chuzhuangfei" maxlength="50"  onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							�豸���۷ѣ�
							<html:text name="jiaofeiDataFrom" property="shebeixiaoshou" maxlength="50" onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
							���Ϸѣ�
							<html:text name="jiaofeiDataFrom" property="cailiaofei" maxlength="50" onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							��ѣ�
							<html:text name="jiaofeiDataFrom" property="nianfei" maxlength="50" onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
							ONUѺ��
							<html:text name="jiaofeiDataFrom" property="onuyj" maxlength="50" onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							������Ѻ��
							<html:text name="jiaofeiDataFrom" property="jidingheyj" maxlength="50" onchange="zongfei();" value="0"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
									<br/>
							���շѣ�
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
						<td class="editTableTitle" >�Ĳģ�</td>
						<td class="editTableContent" >
						�����ӣ�
							<html:text name="jiaofeiDataFrom" property="jiexianzi" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						RJ11��
							<html:text name="jiaofeiDataFrom" property="rj11" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
						RJ45��
							<html:text name="jiaofeiDataFrom" property="rj45" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						ģ�飺
							<html:text name="jiaofeiDataFrom" property="mokuai" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
						��壺
							<html:text name="jiaofeiDataFrom" property="mianban" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						���ߣ�
							<html:text name="jiaofeiDataFrom" property="wangxian" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
						�����Ĳģ�
							<html:text name="jiaofeiDataFrom" property="qitahaocai" maxlength="50" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >ҵ��</td>
						<td class="editTableContent" >
						�վݱ���/�վݺţ�
							<html:text name="jiaofeiDataFrom" property="shoujubenhao" maxlength="150" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						��Ʊ��Ϣ��
							<html:text name="jiaofeiDataFrom" property="kaipiaoxinxi" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						<br/>
						
						��дʱ�䣺
 						<html:text name="jiaofeiDataFrom" property="nowdata" styleId="nowdata" size="20" readonly="true" />
						</td>
					</tr>
					
					
					<tr >
						<td class="editTableTitle" >��ע���ܣ�</td>
						<td class="editTableContentLast" >
							<html:textarea name="jiaofeiDataFrom" property="beizhuhuizong"  
							rows="5" cols="70"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
							</html:textarea>
						</td>
								
					</tr>
					
				</table>
				</div>
			</div>
			<!--  �����༭ end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="�ύ" styleClass="commonButton" onclick="sub();"/>
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('daiweixiuDataList.do?act=init')"/> 
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
			alert("��ַ������д��");
			document.forms[0].dizhi.focus();//���ý���
			return false;
			}
		var yunyingshang = document.forms[0].yunyingshang.value;
		if(yunyingshang==null||trim(yunyingshang)=="0"){
			alert("��Ӫ�̲���Ϊ�գ�");
			document.forms[0].yunyingshang.focus();//���ý���
			return false;
		}
		var weixiushijian = document.forms[0].weixiushijian.value;
		if (weixiushijian==null||trim(weixiushijian)=="") {
			alert("ά��ʱ�������д��");
			document.forms[0].weixiushijian.focus();//���ý���
			return false;
		}
		
		var sta =  /^\d{4}[-](\d{2})[-]\d{2}$/.test(weixiushijian);
		if (sta == false ) {
			alert("ά��������������");
			return false;
		}
	
			
		var shigongren = document.forms[0].shigongren.value;
		if (shigongren==null||trim(shigongren)=="") {
			alert("ʩ���˱�����д��");
			document.forms[0].shigongren.focus();//���ý���
			return false;
		}
		var weixiuleixing = document.forms[0].weixiuleixing.value;
		if(weixiuleixing==null||trim(weixiuleixing)=="δѡ��"){
			alert("ά�����Ͳ���Ϊ�գ�");
			document.forms[0].weixiuleixing.focus();//���ý���
			return false;
		}
		var weixiuneirong = document.forms[0].weixiuneirong.value;
		if (weixiuneirong==null||trim(weixiuneirong)=="") {
			alert("ά�����ݱ�����д��");
			document.forms[0].weixiuneirong.focus();//���ý���
			return false;
		}
			
			
		var kuandaifei = document.forms[0].kuandaifei.value;
		if(kuandaifei!="") {
			if(isNaN(kuandaifei)) {
				alert("��������������֣�");
				document.forms[0].kuandaifei.focus();//���ý���
				return false;
			}	
		}
			
		var shoushifei = document.forms[0].shoushifei.value;
		if (shoushifei!="") {
			if (isNaN(shoushifei)) {
				alert("���ӷ����������֣�");
				document.forms[0].shoushifei.focus();//���ý���
				return false;
			 }
		}
		
		var chuzhuangfei = document.forms[0].chuzhuangfei.value;
		if (chuzhuangfei!="") {
			if (isNaN(chuzhuangfei)) {
				alert("��װ�����������֣�");
				document.forms[0].chuzhuangfei.focus();//���ý���
				return false;
			}
		}
		
		var shebeixiaoshou = document.forms[0].shebeixiaoshou.value;
		if (shebeixiaoshou!="") {
			if (isNaN(shebeixiaoshou)) {
				alert("��װ�����������֣�");
				document.forms[0].shebeixiaoshou.focus();//���ý���
				return false;
			}
		}
		
		var cailiaofei = document.forms[0].cailiaofei.value;
		if (cailiaofei!="") {
			if (isNaN(cailiaofei)) {
				alert("���Ϸ����������֣�");
				document.forms[0].cailiaofei.focus();//���ý���
				return false;
			}
		}
		
		var nianfei = document.forms[0].nianfei.value;
		if (nianfei!="") {
			if (isNaN(nianfei)) {
				alert("������������֣�");
				document.forms[0].nianfei.focus();//���ý���
				return false;
			}
		}		
		
		var onuyj = document.forms[0].onuyj.value;
		if(onuyj!="")
		{
			if(isNaN(onuyj)){
				alert("onjѺ�����������֣�");
				document.forms[0].onuyj.focus();//���ý���
				return false;
				}
		}
			
		var jidingheyj = document.forms[0].jidingheyj.value;
		if(jidingheyj!="")
		{
			if(isNaN(jidingheyj)){
				alert("������Ѻ�����������֣�");
				document.forms[0].jidingheyj.focus();//���ý���
				return false;
				}
		}
		
		var jiexianzi = document.forms[0].jiexianzi.value;
		if (jiexianzi!="") {
			if (isNaN(jiexianzi)) {
				alert("���������������֣�");
				document.forms[0].jiexianzi.focus();//���ý���
				return false;
			}
		}
		
		var rj11 = document.forms[0].rj11.value;
		if (rj11!="") {
			if (isNaN(rj11)) {
				alert("rj11���������֣�");
				document.forms[0].rj11.focus();//���ý���
				return false;
			}
		}
		
		var rj45 = document.forms[0].rj45.value;
		if(rj45!="")
		{
			if(isNaN(rj45)){
				alert("rj45���������֣�");
				document.forms[0].rj45.focus();//���ý���
				return false;
				}
		}
		
		var mokuai = document.forms[0].mokuai.value;
		if(mokuai!="")
		{
			if(isNaN(mokuai)){
				alert("ģ���������֣�");
				document.forms[0].mokuai.focus();//���ý���
				return false;
				}
		}
		
		var mianban = document.forms[0].mianban.value;
		if(mianban!="")
		{
			if(isNaN(mianban)){
				alert("������������֣�");
				document.forms[0].mianban.focus();//���ý���
				return false;
				}
		}
		
		var wangxian = document.forms[0].wangxian.value;
		if(wangxian!="") {
			if(isNaN(wangxian)) {
				alert("�������������֣�");
				document.forms[0].wangxian.focus();//���ý���
				return false;
			}
		}
		var zongshoufei = document.forms[0].zongshoufei.value;
		if (zongshoufei!="") {
			if (isNaN(zongshoufei)) {
				alert("���շѲ�Ϊ���֣�");
				document.forms[0].zongshoufei.focus();//���ý���
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
	  	   //��ȡul���Ա��ܹ������Ŀ
		   var ulObj = document.getElementById("ul1");
		   var liObj = document.createElement("li");
		   var textNode=document.createTextNode(existArray[j]);
		   liObj.appendChild(textNode);
		   liObj.setAttribute("currentIndex",j);
		   //��ÿ��liObj����¼�
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
		    //��ֹ�¼�ð��
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
		//���body���򣨷ǡ������˵��������ز˵�
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
	//�������е�UL
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
	//����������ȷ�����body�����ʱ�� Ҳ�������ز˵�
	addBodyClick(bodyClickHiddenUl);
	</script>
</html>