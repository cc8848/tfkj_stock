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
						alert("�豸�ؿ�ɹ���");
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
	//�������ʱ ����У��
	function check(){
		var xq = trim(document.getElementById("xiaoquname").value);
		var dz = trim(document.getElementById("userplace").value);
		if(xq==''||xq==null){
			alert("С������Ϊ�գ���ѡ��С����");
			document.getElementById("xiaoquname").focus();
			return false;
			}
		if(dz==''||dz==null){
			alert("��ַ����Ϊ�գ��������ַ��");
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
			if(optval.indexOf("��"+quickvalue+"M")==-1&&optval.indexOf(")"+quickvalue+"M")==-1&&optval.indexOf("��"+quickvalue+"M")==-1&&optval.indexOf("��"+quickvalue+"M")==-1) {
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
			if(optval.indexOf("Ʒ"+quickvalue+"M")==-1&&optval.indexOf("��"+quickvalue+"M")==-1&&optval.indexOf("��"+quickvalue+"M")==-1) {
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
		if(selectxiangmu=="��װ") {
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
	<body onload="init();initFenguang();check_wuchuru();">
		<html:form action="paigongdanEdit.do">
		<table>
			<tr align="right">
				<td>�û�״̬�� <html:text name="HuidanForm" property="yonghuzhuangtai" size="20" readonly="true"/>
				</td>
				<td>����ʱ�䣺 <html:text name="HuidanForm" property="kaijis"  styleId="kaijishijian"size="12" onclick="new Calendar().show(this)"/>
				</td>
				<td>ͣ��ʱ�䣺 <html:text name="HuidanForm" property="tingjis"  styleId="tingjishijian"size="12" onclick="new Calendar().show(this)"/>
				</td>
				<td>С���� <html:text name="HuidanForm" property="xiaoqu" size="20" readonly="true" />
				</td>
				<td>��ַ�� <html:text name="HuidanForm" property="dizhi" size="20" readonly="true" />
				</td>
			</tr>
			<tr align="right">
				<td>��ϵ�绰�� <html:text name="HuidanForm" property="telNoCode" size="20"/>
				</td>
				<td>���磺 <html:text name="HuidanForm" property="wangluo" size="20"/>
				</td>
				<td>���ӣ� <html:text name="HuidanForm" property="dianshi" size="20"/>
				</td>
				<td>�绰�� <html:text name="HuidanForm" property="dianhua" size="20"/>
				</td>
				<td>ҵ�� <html:text name="HuidanForm" property="yewu" size="20"/>
				</td>
			</tr>
			<tr align="right">
				<td>�ֹ⣺ <html:text styleId="fenguang" name="HuidanForm" property="fenguang" size="20"/><html:hidden styleId="fenguangID" name="HuidanForm" property="fenguangID" />
				</td>
				<td>Onu MAC�� <html:text name="HuidanForm" property="onuCode" size="20" readonly="true"/>
				</td>
				<td>STB MCID�� <html:text name="HuidanForm" property="mcidCode" size="20" readonly="true"/>
				</td>
				<td>����IP�� <html:text name="HuidanForm" property="dianshiip" size="20"/>
				</td>
				<td>����IP�� <html:text name="HuidanForm" property="wangluoip" size="20"/>
				</td>
			</tr>
			<tr align="right">
				<td>�绰IP�������˺ţ��� <html:text name="HuidanForm" property="dianhuaip" size="20"/>
				</td>
				<td>�绰VLAN�� <html:text name="HuidanForm" property="dianhuavlan" size="20"/>
				</td>
				<td>����VLAN�� <html:text name="HuidanForm" property="wangluovlan" size="20"/>
				</td>
				<td>����ʱ�䣺 <html:text name="HuidanForm" property="shangmenshijian" size="20"/>
				</td>
				<td>��֤:<html:text name="HuidanForm" property="danzheng" size="20"/>
				</td>
			</tr>
			<tr align="right">
				<td>��ѡ�绰���룺 <html:text name="HuidanForm" property="sxdhhm" size="20"/>
				</td>
				<td>ONUѺ��:<html:text styleId="count_1" name="HuidanForm" property="onuyj" size="20" onchange="check_wuchuru()"/>
				</td>
				<td>������Ѻ��:<html:text styleId="count_2" name="HuidanForm" property="jidingheyj" size="20" onchange="check_wuchuru()"/>
				</td>
				<td>���ӷ�:<html:text styleId="count_3" name="HuidanForm" property="shoushifei" size="20" onchange="check_wuchuru()"/>
				</td>
				<td>�����:<html:text styleId="count_4" name="HuidanForm" property="kuandaifei" size="20" onchange="check_wuchuru()"/>
				</td>
			</tr>
			<tr align="right">
				<td>��װ�ѣ� <html:text styleId="count_5" name="HuidanForm" property="chuzhuangfei" size="20" onchange="check_wuchuru()"/>
				</td>
				<td>�豸���۷ѣ� <html:text styleId="count_6" name="HuidanForm" property="shebeixiaoshoufei" size="20" onchange="check_wuchuru()"/>
				</td>
				<td>���Ϸ�:<html:text styleId="count_7" name="HuidanForm" property="cailiaofei" size="20" onchange="check_wuchuru()"/>
				</td>
				<td>��Ӫ��:<html:select name="HuidanForm" property="yunyingshang" 
								styleClass="commonTextFieldHover"  styleId="yuyingshang"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--��ѡ��--</html:option>
								<html:option value="����">����</html:option>
								<html:option value="��ͨ">��ͨ</html:option>
								<html:option value="���">���</html:option>
								<html:option value="��ͨ">��ͨ</html:option>
								<html:option value="�췿">�췿</html:option>
							</html:select>
				</td>
				<td>�����¹���:<html:text styleId="count_8" name="HuidanForm" property="bzygf" size="20" onchange="check_wuchuru()"/>
				</td>
			</tr>
			<tr align="right">
				<td>��ѣ� <html:text styleId="count_9" name="HuidanForm" property="nianfei" size="20" onchange="check_wuchuru()"/>
				</td>
			</tr>
		</table>
	</div>
	<div>
			<table>
				<tr align="right">
					<td>ʩ���ˣ� <a:need /><html:text styleId="sub_4" name="HuidanForm" property="shigongren" size="20" />
					</td>
					<td>�տ�ʱ��:<a:need />
					<html:text name="HuidanForm" property="shoukuanshijian"  styleId="shoukuanshijian"size="12"
								styleClass="commonTextFieldHover"  onclick="new Calendar().show(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
					</td>
					<td>�û�������<a:need /> <html:text styleId="sub_6" name="HuidanForm" property="xingming" size="20" />
					</td>
					<td>���֤�ţ�<a:need /> <html:text styleId="sub_7" name="HuidanForm" property="shenfenzheng" size="18" />
					</td>
					<td>�ֹ��ߺţ� <html:text name="HuidanForm" property="fenguangxianhao" size="20" />
					</td>
				</tr>
				<tr align="right">
					<td>����λ�ã�<a:need /> <html:text styleId="sub_8" name="HuidanForm" property="jiexuweizhi" size="10" />
					</td>
					<td>���շѣ�(<span id="count_qian"></span>)<a:need /><html:text styleId="sub_9" name="HuidanForm" property="zongshoufei" size="10" />
					</td>
					<td>�վݱ���/�վݺ�:<a:need /><html:text styleId="sub_10" name="HuidanForm" property="shoujubenhao" size="10" />
					</td>
					<td>��Ʊ��Ϣ�� <html:text name="HuidanForm" property="kaipiaoxinxi" size="20" />
					</td>
					<td>�����豸ʹ������� <html:text name="HuidanForm" property="qtsbsyqk" size="20" />
					</td>
				</tr>
				<tr align="right">
					<td>�����Ĳģ� <html:text name="HuidanForm" property="qitahaocai" size="20" />
					</td>
					<td>�����ӣ�(����д����) <html:text styleId="sub_11" name="HuidanForm" property="jiexianzi" size="5" />
					</td>
					<td>RJ11��(����д����) <html:text styleId="sub_12" name="HuidanForm" property="rj11" size="5" />
					</td>
					<td>RJ45��(����д����) <html:text styleId="sub_13" name="HuidanForm" property="rj45" size="5" />
					</td>
					<td>ģ�飺(����д����) <html:text styleId="sub_14" name="HuidanForm" property="mokuai" size="5" />
					</td>
				</tr>
				<tr align="right">
					<td>��壺(����д����) <html:text styleId="sub_15" name="HuidanForm" property="mianban" size="5" />
					</td>
					<td>���ߣ�(����д����) <html:text styleId="sub_16" name="HuidanForm" property="wangxian" size="5" />
					</td>
				</tr>
				<tr align="right">	
					<td colspan="5">
						��ע�� <html:textarea name="HuidanForm" property="beizhu" rows="5" cols="50" />
						��ע���ܣ� <html:textarea name="HuidanForm" property="beizhuhuizong" rows="5" cols="50"/>
						�ֳ���ע�� <html:textarea name="HuidanForm" property="xianchangbeizhu" rows="5" cols="50" />
					</td>
				</tr>
				<tr>	
					<td colspan="2">
					    <span style="float:center">
					        <html:button property="btnSave" value="����" styleClass="commonButton" onclick="error_edit();"/>
							<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('huidanerrorList.do?act=init')"/>
					   </span>
					</td>
				</tr>
			</table>
			<html:hidden name="HuidanForm" property="UUIDHidden" />
		</html:form>
	</body>
<script type="text/javascript">	
function subs(){
	heji();
	if(checkInput2()){
	var kaijishijiannew = jQuery("#kaijishijian").val();
			if(kaijishijiannew == "") {
				alert("����ʱ��������룡");
				return false;
			}
		commonSubmit('paigongdanEdit.do?act=update');
		}
}
function error_edit(){
	//��֤���ڵ�������ʽ
	var pattern3=/^[1,2][0-9]{3}-[0-9]{2}-[0-9]{2}$/;
	var kai  = document.getElementById('kaijishijian').value;
	var ting = document.getElementById('tingjishijian').value;
	var shou = document.getElementById('shoukuanshijian').value;
	if(!pattern3.test(kai) || !pattern3.test(ting) || !pattern3.test(shou)){
		alert('ʱ���ʽ�������������룡');
	}else{
		commonSubmit('huidanerrorList.do?act=edit_save');
	}
}
function check_wuchuru(){
	document.getElementById('count_qian').innerHTML=
		getInt('count_1')+getInt('count_2')+getInt('count_3')+getInt('count_4')+getInt('count_5')+getInt('count_6')+getInt('count_7')+getInt('count_8')+getInt('count_9');
}
function getInt(id) {
	var result = parseInt(document.getElementById(id).value);
	if(isNaN(result)) {
		alert("������������֣�");
		document.getElementById(id).focus;
		return 0;
	}
	return result;
}
	</script>
</html>