<!--�ɹ�������У��δͨ�� ��ת��insert3-->
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
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/common.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="paigongdan/paigongdan.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<script type="text/javascript">
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
			var presskbn = 0;
	function installCompare() {
		if(check()){
				docompare();
			}
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
		var selectxiangmu = document.forms[0].xiangmu.value
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
			presskbn = 1;
		}
		</script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init();">  
		<html:form action="equipStockEdit.do">
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">
				����ɹ���
			</div>
			<!--  �����༭ start -->
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="960px">
				<!-- ������ start -->
				<tr height="35px">
						<td class="editTableTitle" width="30px">�û���Ϣ��</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						�û�������
						<html:text name="paiGongDanEntiyForm" property="username"size="12" maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
								<html:hidden name="paiGongDanEntiyForm" styleId="biduikbn" property="biduikbn"></html:hidden>
							<a:need />
						С�����ƣ�
							<html:select name="paiGongDanEntiyForm" property="xiaoquname"
								styleClass="commonTextFieldHover"  onchange="selectxiaoqu(this)" styleId="xiaoquname"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value=" ">��ѡ��</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
						<a:need />
						<html:hidden name="paiGongDanEntiyForm" property="xiaoquname" styleId="selectxiaoquhidden"/>  
						</td>
						</tr>
						<tr>
						<td>
						�û���ַ��
						<html:text name="paiGongDanEntiyForm" property="userplace"size="12"maxlength="20"
								styleClass="commonTextFieldHover"	onchange="isture(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
							<a:need />
						��ϵ�绰��
							<html:text name="paiGongDanEntiyForm" property="usertel" size="12"maxlength="20"
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
						<td class="editTableTitle" width="30px" rowSpan="3">�ɹ����ڣ�</td>
						<td class="editTableContent" >
						
						�ɹ����ڣ�
							<html:text name="paiGongDanEntiyForm" property="paigongriqi"  styleId="paigongriqi"size="12"
								styleClass="commonTextFieldHover"  onclick="new Calendar().show(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						<a:need />
						����ʱ�䣺
						<html:select name="paiGongDanEntiyForm" property="anzhuangshijian" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">��ѡ��</html:option>
								<html:option value="����">����</html:option>
								<html:option value="����">����</html:option>
							</html:select>			
							<a:need />
						��Ŀ��
						<html:select name="paiGongDanEntiyForm" property="xiangmu" 
								styleClass="commonTextFieldHover"   onchange="initCompareBtn()"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">��ѡ��</html:option>
								<html:option value="��װ">��װ</html:option>
								<html:option value="�ռ�">�ռ�</html:option>
								<html:option value="����">����</html:option>
								<html:option value="�˻�">�˻�</html:option>
								<html:option value="ά��">ά��</html:option>
							</html:select>	
							<a:need />	
							<html:button styleId="btnCompare" property="btnCompare" value="��װ�ȶ�" styleClass="commonButton2" onclick="installCompare();"/>
							<font color="blue">ԤԼ��װ�ص�</font>	
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableContent" >�Ƿ��ƻ���
						<html:radio name="paiGongDanEntiyForm"  property="isYiji" value="0" onclick="enableyiji(false);">��</html:radio><html:radio name="paiGongDanEntiyForm" property="isYiji" value="1" onclick="enableyiji(true);">��</html:radio><a:need /></td>
					</tr>
					<tr height="35px">
						<td class="editTableContent" style="width:auto;">
						�Ƴ�С����
								<html:select name="paiGongDanEntiyForm" property="yichuxiaoqu" styleId="yichuxiaoqu"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value=" ">��ѡ��</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select>
								<font id="yichumust1" color="#ff0000">*</font>
						�Ƴ���ַ��
						<html:text name="paiGongDanEntiyForm" property="yichudizhi"size="12"maxlength="20" styleId="yichudizhi"
								styleClass="commonTextFieldHover"	onchange="isture2(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
								<font id="yichumust2" color="#ff0000">*</font>
						�Ƴ�ҵ��
						<html:text name="paiGongDanEntiyForm" property="yichuyewu"size="12"maxlength="20" styleId="yichuyewu"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> 
						<font id="yichumust" color="#ff0000">*</font>
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">��֤��</td>
						<td class="editTableContent" >
						�Ѽ����ŷ�����
							<html:checkbox name="paiGongDanEntiyForm" property="dxfandan" value="1"></html:checkbox>
						֤����ȫ��
							<html:checkbox name="paiGongDanEntiyForm" property="zhengjian" styleId="zhengjian" value="1"></html:checkbox>
						</td>
						</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">�췿�����</td>
						<td class="editTableContent" >
						<table>
						<tr>
							<td>
								ʱ�����ͣ�
								<html:select name="paiGongDanEntiyForm" property="shichangleixing" 
									styleClass="commonTextFieldHover" styleId="shichangleixing"
									onfocus="this.className='commonTextFieldMove'" onchange="findStubyClasslId()"
									onblur="this.className='commonTextFieldHover'"> <!-- onchange="clearKuandai()" -->
									<html:option value="">--��ѡ��--</html:option>
									<html:option value="����">����</html:option>
									<html:option value="����">����</html:option>
									<html:option value="����">����</html:option>
								</html:select>
							</td>
							<td>
								����
								<html:select name="paiGongDanEntiyForm" property="tfkuandaidaikuan" 
									styleClass="commonTextFieldHover" styleId="tfkuandaidaikuan"
									onfocus="this.className='commonTextFieldMove'" onchange="findStubyClasslId()"
									onblur="this.className='commonTextFieldHover'"> <!-- onchange="clearKuandai()" -->
									<html:option value="0">--��ѡ��--</html:option>
									<html:option value="1M">1M</html:option>
									<html:option value="2M">2M</html:option>
									<html:option value="3M">3M</html:option>
									<html:option value="4M">4M</html:option>
									<html:option value="6M">6M</html:option>
									<html:option value="10M">10M</html:option>
									<html:option value="12M">12M</html:option>
									<html:option value="20M">20M</html:option>
									<html:option value="50M">50M</html:option>
									<html:option value="100M">100M</html:option>
								</html:select>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								ʱ��:
								<html:select name="paiGongDanEntiyForm" property="tfkdnianxian" styleId="tfkdnianxian"
									styleClass="commonTextFieldHover"  
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="0">--��ѡ��--</html:option>
									<html:options collection="shichangList" property="key" labelProperty="value" />
								</html:select>
								<select id="scquickselect" onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'" onchange="changeshichang()">
									<option value="0">--��ѡ��--</option>
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
							</td>
						</tr>
						<tr>
							<td>
						����ѣ�
						<html:text name="paiGongDanEntiyForm" property="tfkuandaifei"size="12" maxlength="20"
								styleClass="commonTextFieldHover" styleId="tfkuandaifei" onchange="setvalues(this,'kuaidaifei')"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						<!-- ONUѺ��
						<html:text name="paiGongDanEntiyForm" property="anzhuangshijian"size="12"
								styleClass="commonTextFieldHover" styleId="tfkuandaionu"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						 -->			
						</td>
						</tr>
						</table>
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">�췿IPTV��</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						������
								
								<html:select name="paiGongDanEntiyForm" property="tfiptv" 
								styleClass="commonTextFieldHover"  styleId="tfiptvshuliang" onchange="cleartfiptv()"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--��ѡ��--</html:option>
								<html:option value="����">����</html:option>
								<html:option value="��������">��������</html:option>
								<!--
								<html:option value="��������">��������</html:option>
								<html:option value="�ĸ�����">�ĸ�����</html:option>
								<html:option value="����">����</html:option>
								<html:option value="��������">��������</html:option>
								<html:option value="��������">��������</html:option>
								<html:option value="�ĸ�����">�ĸ�����</html:option>
								<html:option value="һ��������һ������">һ��������һ������</html:option>
								-->s
								<html:option value="�ߵ�">�ߵ�</html:option>
								</html:select>
						</td>
						<td>
						ʱ����
						<html:select name="paiGongDanEntiyForm" property="tfiptvnianxian" 
								styleClass="commonTextFieldHover"  styleId="tfiptvshichang" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--��ѡ��--</html:option>
								<html:option value="1">1��</html:option><html:option value="2">2��</html:option>
								<html:option value="3">3��</html:option><html:option value="4">4��</html:option>
								<html:option value="5">5��</html:option>	
						</html:select>		
						</td>
						</tr>
						<tr>
						<td>		
						���ӷѣ�
						<html:text name="paiGongDanEntiyForm" property="tfiptvshoushifei" size="12"
								styleClass="commonTextFieldHover" styleId="tfiptvshoushifei" onchange="setvalues(this,'shoushifei')"
								onfocus="this.className='commonTextFieldMove'"  maxlength="20"
								onblur="this.className='commonTextFieldHover'" />��Ԫ��		
						</td>
						<td>
						������Ѻ��
						<html:text name="paiGongDanEntiyForm" property="tfjidingheyajin" size="12"maxlength="20"
								styleClass="commonTextFieldHover" styleId="tfjidingheyajin" onchange="setvalues(this,'jidinghe')"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />��Ԫ��
						</td>
						
						</tr>
						</table>		
						</td>
					</tr>
						<tr height="35px">
						<td class="editTableTitle" width="30px">������Ӫ��ҵ��</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						��Ӫ�̣�
							<html:select name="paiGongDanEntiyForm" property="yuyingshang" 
								styleClass="commonTextFieldHover"  styleId="yuyingshang"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--��ѡ��--</html:option>
								<html:option value="����">����</html:option>
								<html:option value="��ͨ">��ͨ</html:option>
								<html:option value="���">���</html:option>
									<html:option value="��ͨ">��ͨ</html:option>
							</html:select>	
						�ײͣ�
							
								<html:select name="paiGongDanEntiyForm" property="qtye"  styleId="qtye"
								styleClass="commonTextFieldHover"   onchange="changedainxin()"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--��ѡ��--</html:option>
								<html:options collection="dianxintaocan" property="key" labelProperty="value" />
								</html:select>
								<select id="scquickselect2" onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'" onchange="changeshichang2()">
									<option value="0">--��ѡ��--</option>
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
						��װ�ѣ�
								<html:select name="paiGongDanEntiyForm" property="dxchuzhuangfei" 
								styleClass="commonTextFieldHover"  styleId="dxchuzhuangfei" onchange="dxchuzhuangfeichange(this)"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">-��ѡ��-</html:option>
								<!--<html:option value="0">���0Ԫ</html:option>-->
								<html:option value="205">һ��205Ԫ</html:option>
								<html:option value="410">����410Ԫ</html:option>
								<html:option value="615">����615Ԫ</html:option>
								<html:option value="820">�ĸ�820Ԫ</html:option>
								</html:select>		
						</td>
						</tr>
						<tr>
						<td>		
						���ã�&nbsp;
						<html:text name="paiGongDanEntiyForm" property="fufei" size="12"
								styleClass="commonTextFieldHover"  onchange="setvalues(this,'nianfei')"
								onfocus="this.className='commonTextFieldMove'" maxlength="20"
								onblur="this.className='commonTextFieldHover'" />
						
						�����£�
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
						<td class="editTableTitle" >�豸��Ϣ��</td>
							<td class="editTableContentLast" >
							�ֹ⣺
							<html:text styleId="fenguang" name="paiGongDanEntiyForm" property="fenguang" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<html:hidden styleId="selectCommunityPileID" name="paiGongDanEntiyForm" property="selectCommunityPileID" />
							<html:hidden styleId="eqboxnum" name="paiGongDanEntiyForm" property="eqboxnum" />	
							<html:hidden styleId="selectCommunityPileID2" name="paiGongDanEntiyForm" property="selectCommunityPileID2" />
							<html:hidden styleId="eqboxnum2" name="paiGongDanEntiyForm" property="eqboxnum2" />	
							<html:hidden styleId="bdfenguang" name="paiGongDanEntiyForm" property="bdfenguang" />
							<html:hidden styleId="bdonumac" name="paiGongDanEntiyForm" property="bdonumac" />
							<html:hidden styleId="bdstbmcid" name="paiGongDanEntiyForm" property="bdstbmcid" />
							<html:hidden styleId="bddianshiip" name="paiGongDanEntiyForm" property="bddianshiip" />
							onu mac��
							<html:text styleId="onumac" name="paiGongDanEntiyForm" property="onumac" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<br/>
							STB MCID��
							<html:text styleId="stbmcid" name="paiGongDanEntiyForm" property="stbmcid" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							����IP��
							<html:text styleId="dianshiip" name="paiGongDanEntiyForm" property="dianshiip" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
							<html:button property="btnSelectDevice" value="��ѡ�豸" styleClass="commonButton2" onclick="selectdevice();"/>
							<html:button styleId="btnDeviceBack" property="btnDeviceBack" value="�豸�ؿ�" styleClass="commonButton2" onclick="backtodept();"/>
						<br/>
						</td>
								
					</tr>
						<tr height="35px">
						<td class="editTableTitle" width="30px">��ѡ���룺</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						����1&nbsp;
							<html:text name="paiGongDanEntiyForm" property="telhaoma1" size="12"maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						����2&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma2" size="12"maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>		
						</tr>	
						<tr>
						<td>	
						����3&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma3" size="12"maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						����4&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma4" size="12"maxlength="20"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>		
						</table>		
						</td>
					</tr>
					
						
					
					<tr height="35px">
						<td class="editTableTitle" width="30px">Ӧ�շ��ã�</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td id="onutd">
						ONUѺ��
							<!--<html:text name="paiGongDanEntiyForm" property="onu" size="8"
								styleClass="commonTextFieldHover" value="0" styleId="onu"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />-->
								
							<html:select name="paiGongDanEntiyForm" property="onu" 
								styleClass="commonTextFieldHover"  styleId="onu" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">0Ԫ</html:option>
								<html:option value="200">200Ԫ</html:option>
								<html:option value="800">800Ԫ</html:option>		
							</html:select>
						</td>	
						<td id="jiaohuanjiid">
						��������&nbsp;
						<!-- 	<html:text name="paiGongDanEntiyForm" property="jiaohuanji" size="8"
								styleClass="commonTextFieldHover"  styleId="jiaohuanji" value="0"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> -->
								<html:select name="paiGongDanEntiyForm" property="jiaohuanji" 
								styleClass="commonTextFieldHover"  styleId="jiaohuanji" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">0Ԫ</html:option>
								<html:option value="50">50Ԫ</html:option>	
							</html:select>
						</td>
						<td>	
						���ӷѣ�
						<html:text name="paiGongDanEntiyForm" property="shoushifei" size="8"
								styleClass="commonTextFieldHover"  styleId="shoushifei"maxlength="20"readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>
						������Ѻ��
						<html:text name="paiGongDanEntiyForm" property="jidinghe" size="8"
								styleClass="commonTextFieldHover"  styleId="jidinghe"maxlength="20"readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>	
						��ѣ�
						<html:text name="paiGongDanEntiyForm" property="nianfei" size="8"
								styleClass="commonTextFieldHover"  styleId="nianfei"maxlength="20"readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td>		
						�����£�&nbsp;
						<html:text name="paiGongDanEntiyForm" property="buzuyue" size="8"
								styleClass="commonTextFieldHover"  styleId="buzuyue"maxlength="20"readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						��װ�ѣ�
						<html:text name="paiGongDanEntiyForm" property="chuzhuangfei" size="8"maxlength="20"readonly="true"
								styleClass="commonTextFieldHover" styleId="chuzhuangfei"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						�豸���۷ѣ�
						<html:text name="paiGongDanEntiyForm" property="shebeixiaoshou" size="8"maxlength="20"readonly="false"
								styleClass="commonTextFieldHover" value="0" styleId="shebeixiaoshou"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						���Ϸѣ�
						<html:text name="paiGongDanEntiyForm" property="cailiaofei" size="8"maxlength="20"readonly="false"
								styleClass="commonTextFieldHover" value="0" styleId="cailiaofei"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td>		
						����ѣ�&nbsp;&nbsp;&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="kuaidaifei" size="8" readonly="true"
								styleClass="commonTextFieldHover"  styleId="kuaidaifei"maxlength="20"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						<a href="javascript:heji()">�ϼ�</a>��
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
						<td class="editTableTitleLast" >��Ʊ��Ϣ��</td>
						<td class="editTableContentLast" >
							<html:textarea name="paiGongDanEntiyForm" property="kaipiaoxinxi"  onkeyup="if(this.value.length>200)this.value=this.value.substr(0,200)"
								rows="5" cols="70" ></html:textarea>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >��ע��</td>
						<td class="editTableContentLast" >
							<html:textarea name="paiGongDanEntiyForm" property="beizhu"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)"
								rows="5" cols="70"  ></html:textarea>
						</td>
					</tr>
				</table>
				</div>
			</div>
			<!--  �����༭ end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="sub();"/>
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('selectTelNumberList.do?act=init')"/>
			</div>
		</div>
		</html:form>
	</body>
	<script type="text/javascript">
	
//function showInfo(){
	//alert(document.forms[0].xiaoquname.value);
//	 if(document.forms[0].xiaoquname.value=="������Ԣ"||
//			 document.forms[0].xiaoquname.value=="������԰"||document.forms[0].xiaoquname.value=="������"){
//		 document.getElementById("jiaohuanjiid").style.display="";
//			document.getElementById("onu").value="0";
//			document.getElementById("onutd").style.display="none";
//		 }
//}
//showInfo();
function sub(){
	heji();
	if(checkInput1()){
		commonSubmit('paigongdanEdit.do?act=insert')
		}
}
function isture2(obj){
		if(!ismenhao(obj.value)){
			alert("��������ȷ�ĵ�ַ��ʽ�����磺11-1-1111 ���� 11-11");
			//document.getElementById("userplace").focus();
			document.forms[0].yichudizhi.focus();
			return false;
			}
		}
	function enableyiji(obj) {
		if(!obj) {
			document.forms[0].yichuxiaoqu.disabled = "disabled";
			document.forms[0].yichudizhi.disabled = "disabled";
			document.forms[0].yichuyewu.disabled = "disabled";
			document.getElementById("yichumust").style.display="none";
			document.getElementById("yichumust1").style.display="none";
			document.getElementById("yichumust2").style.display="none";
		}else{
			document.forms[0].yichuxiaoqu.disabled = "";
			document.forms[0].yichudizhi.disabled = "";
			document.forms[0].yichuyewu.disabled = "";
			document.getElementById("yichumust").style.display="";
			document.getElementById("yichumust1").style.display="";
			document.getElementById("yichumust2").style.display="";
		}
	}	
	
</script>
</html>