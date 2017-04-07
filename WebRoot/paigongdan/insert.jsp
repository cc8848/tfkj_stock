<!-- �ɹ���������ӹ���  -->
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
		
			//��֤���֤�����Ƿ���Ч
		function checkIdcard(idcard){    
		  var Errors=["ok","���֤����λ������!","���֤����������ڳ�����Χ���зǷ��ַ�!","���֤����У�����!","���֤�����Ƿ�!"];
		  var area={11:"����",12:"���",13:"�ӱ�",14:"ɽ��",15:"���ɹ�",21:"����",22:"����",23:"������",31:"�Ϻ�",32:"����",33:"�㽭",34:"����",35:"����",36:"����",37:"ɽ��",41:"����",42:"����",43:"����",44:"�㶫",45:"����",46:"����",50:"����",51:"�Ĵ�",52:"����",53:"����",54:"����",61:"����",62:"����",63:"�ຣ",64:"����",65:"�½�",71:"̨��",81:"���",82:"����",91:"����"};
		  var idcard,Y,JYM;    
		  var S,M;    
		  var idcard_array = [];
		  idcard_array = idcard.split("");    
		  if(area[parseInt(idcard.substr(0,2))]==null) return Errors[4];    
		  switch(idcard.length){    
		    case 15:    
		      if ((parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){    
		         ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//���Գ������ڵĺϷ���    
		       }    
		      else{    
		         ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//���Գ������ڵĺϷ���    
		       }    
		      if(ereg.test(idcard))    
		        return Errors[0];    
		      else   
		        return Errors[2];    
		    break;    
		  case 18:    
		    if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){    
		       ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//����������ڵĺϷ���������ʽ    
		     }    
		    else{    
		     ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//ƽ��������ڵĺϷ���������ʽ    
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
			if(xiangmu == "��װ"&&presskbn==0) {
				alert("��װ��Ŀ������а�װ�ȶԣ�");
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
			if(xiangmu == "��װ"&&presskbn==0) {
				alert("��װ��Ŀ������а�װ�ȶԣ�");
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
						alert("�豸�ؿ�ɹ���");
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
			alert("С������Ϊ�գ���ѡ��С����");
			document.getElementById("yichuxiaoqu").focus();
			return false;
			}
		if(dz==''||dz==null){
			alert("��ַ����Ϊ�գ��������ַ��");
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
			if(optval.indexOf("��"+quickvalue+"M")==-1&&optval.indexOf(")"+quickvalue+"M")==-1&&optval.indexOf("��"+quickvalue+"M")==-1&&optval.indexOf("��"+quickvalue+"M")==-1) {
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
			if(optval.indexOf("Ʒ"+quickvalue+"M")==-1&&optval.indexOf("��"+quickvalue+"M")==-1&&optval.indexOf("��"+quickvalue+"M")==-1) {
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
						var str = "<option value=0>--��ѡ��--</option>";
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
						var str = "<option value=0>--��ѡ��--</option>";
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
			<!-- ���� -->
			<div class="conten_top" name="top">
				����ɹ���
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table" >
				<table border="0" cellspacing="0" cellpadding="2" width="100%">
				<!-- ������ start -->
				<tr >
						<td class="editTableTitle" style="width: 200px">�û���Ϣ��</td>
						<td class="editTableContent" style="width: 900px">
						<table>
						<tr >
							<td colspan="2">
							�û�������
							<html:text name="paiGongDanEntiyForm" property="username"size="12" maxlength="20"
									styleClass="commonTextFieldHover"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" />
							<html:hidden name="paiGongDanEntiyForm" styleId="biduikbn" property="biduikbn"></html:hidden>
								<a:need />
								���֤�ţ�
								<html:text name="paiGongDanEntiyForm" property="shenfenzheng"size="12" maxlength="20"
									styleClass="commonTextFieldHover"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" style="width: 200px"/>
							<a:need />
							
							</td>
						</tr>
						<tr>
						<td colspan="2">
						С�����ƣ�
								<html:select name="paiGongDanEntiyForm" property="xiaoquname" styleId="xiaoquname"
									styleClass="commonTextFieldHover"  onchange="selectxiaoqu(this);initkuandai();initdianshi();"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value=" ">��ѡ��</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select>
							<a:need />
							<html:hidden name="paiGongDanEntiyForm" property="xiaoquname" styleId="selectxiaoquhidden"/>  
						�û���ַ��
						<html:text name="paiGongDanEntiyForm" property="userplace"size="12"maxlength="20" styleId="userplace"
								styleClass="commonTextFieldHover"	onchange="isture(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
							<a:need />
						
						
						</td>	
						</tr>
						<tr>
							<td colspan="2">
								��ϵ�绰��
							<html:text name="paiGongDanEntiyForm" property="usertel" size="12"maxlength="20"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
							<a:need />	
						<html:button property="btnSave" value="���" styleClass="commonButton" onclick="testDwr();"/>
							</td>
						</tr>
							</table>
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" style="width: 200px">�ɹ����ڣ�</td>
						<td class="editTableContent" >
						
						�ɹ����ڣ�
							<html:text name="paiGongDanEntiyForm" property="paigongriqi"  styleId="paigongriqi"size="12"
								styleClass="commonTextFieldHover"  onclick="new Calendar().show(this)" onchange="initKaijishijian()"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover';initKaijishijian();"/>
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
								styleClass="commonTextFieldHover"  onchange="initCompareBtn()"
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
							<font color="blue">ԤԼ��װ�ص�/��·�иıص�</font>		
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" style="width: 200px" rowSpan="2">�ƻ�&�иģ�</td>
						<td class="editTableContent" ><font color="blue">�Ƿ��и���·�����ţ�����ͨ����</font>
						<html:radio name="paiGongDanEntiyForm" styleId="falseqiegai" property="isQiegai" value="0" onclick="enableqiegai(false);">��</html:radio><html:radio name="paiGongDanEntiyForm" styleId="trueqiegai" property="isQiegai" value="1" onclick="enableqiegai(true);">��</html:radio><a:need />
						����
						<html:text name="paiGongDanEntiyForm" property="qiegaidaikuan"  styleId="qiegaidaikuan"size="12"
								styleClass="commonTextFieldHover"  readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
								<font id="qiegaimust1" color="#ff0000">*</font>
						ͣ��ʱ�䣺
							<html:text name="paiGongDanEntiyForm" property="qiegaitingjishijian"  styleId="qiegaitingjishijian"size="12"
								styleClass="commonTextFieldHover" onclick="new Calendar().show(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
								<font id="qiegaimust2" color="#ff0000">*</font></td>
					</tr>
					<tr height="35px">
						<td class="editTableContent" >�Ƿ��ƻ���
						<html:radio name="paiGongDanEntiyForm" styleId="falseyiji" property="isYiji" value="0" onclick="enableyiji(false);">��</html:radio><html:radio name="paiGongDanEntiyForm" property="isYiji" value="1" onclick="enableyiji(true);">��</html:radio><a:need />
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
						<html:button styleId="btnCompareYiJi" property="btnCompare" value="�ƻ��ȶ�" styleClass="commonButton2" onclick="installCompareYiJi();"/>
							<font color="brown">�ƻ��ص�</font>	
						</br>
						�Ƴ������
						<html:text name="paiGongDanEntiyForm" property="yichuyewu"size="12"maxlength="20" styleId="yichuyewu" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> 
						�Ƴ����ӣ�
						<html:text name="paiGongDanEntiyForm" property="yichudianshi"size="12"maxlength="20" styleId="yichudianshi" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> 
						�Ƴ�����ҵ��
						<html:text name="paiGongDanEntiyForm" property="yichuqita"size="12"maxlength="20" styleId="yichuqita" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> 
						�ƻ��ѣ�
						<input type="text" maxlength="20" id="yijifei" styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" onchange="setvalueschuzhuangfei(this)"/>
						</br>
						����ͣ��ʱ�䣺
						<html:text name="paiGongDanEntiyForm" property="yichutingjishijian"size="12"maxlength="20" styleId="yichutingjishijian" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> 
						����ͣ��ʱ�䣺
						<html:text name="paiGongDanEntiyForm" property="yichutingjishijiands"size="12"maxlength="20" styleId="yichutingjishijiands" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> 
						����ҵ��ͣ��ʱ�䣺
						<html:text name="paiGongDanEntiyForm" property="yichutingjishijianqt"size="12"maxlength="20" styleId="yichutingjishijianqt" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" /> 
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" style="width: 200px">��֤��</td>
						<td class="editTableContent" >
						�Ѽ����ŷ�����
							<html:checkbox name="paiGongDanEntiyForm" property="dxfandan" value="1"></html:checkbox>
						֤����ȫ��
							<html:checkbox name="paiGongDanEntiyForm" property="zhengjian" styleId="zhengjian" value="1"></html:checkbox>
						</td>
						</tr>
					<tr >
						<td class="editTableTitle" style="width: 200px">�췿�����</td>
						<td class="editTableContent" >
						<table>
						<tr>
							<td>
								ʱ�����ͣ�
								
								<html:text name="paiGongDanEntiyForm" property="shichangleixing"size="12" value="0"maxlength="20"
									styleClass="commonTextFieldHover" styleId="shichangleixing" readonly="true"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" />
							</td>
							<td>
								����
									<html:text name="paiGongDanEntiyForm" property="tfkuandaidaikuan"size="12" value="0"maxlength="20"
									styleClass="commonTextFieldHover" styleId="tfkuandaidaikuan" readonly="true"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								ʱ��:
								<html:select name="paiGongDanEntiyForm" property="tfkdnianxian" styleId="tfkdnianxian"
									styleClass="commonTextFieldHover"  
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'" onchange="changelevel1(), changelevel2(), changelevel3(),changelevel4();initTingjishijian();">
									<html:option value="0">--��ѡ��--</html:option>
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
								�ʷѵ���������
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
							��װ�ѣ�
								<html:text name="paiGongDanEntiyForm" property="tfkdczf"size="12"
									styleClass="commonTextFieldHover" styleId="tfkdczf" onchange="setvalueschuzhuangfei(this)"
									onfocus="this.className='commonTextFieldMove'" maxlength="20"
									onblur="this.className='commonTextFieldHover'" />
							</td>
							
							<td>
							����ѣ�
							<html:text name="paiGongDanEntiyForm" property="tfkuandaifei"size="12" value="0"maxlength="20"
									styleClass="commonTextFieldHover" styleId="tfkuandaifei" onchange="setvalues(this,'kuaidaifei')"
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'"  readonly="true"/>
							<!-- ONUѺ��
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
						<td class="editTableTitle" style="width: 200px">�췿IPTV��</td>
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
								<html:option value="��������">��������</html:option>
								<html:option value="�ĸ�����">�ĸ�����</html:option>
								<html:option value="����">����</html:option>
								<html:option value="��������">��������</html:option>
								<html:option value="��������">��������</html:option>
								<html:option value="�ĸ�����">�ĸ�����</html:option>
								<html:option value="һ��������һ������">һ��������һ������</html:option>
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
<!-- 							<html:select name="paiGongDanEntiyForm" property="tfiptvnianxian" styleId="tfiptvshichang"
								styleClass="commonTextFieldHover"  
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" >
									<html:option value="0">--��ѡ��--</html:option>
								<html:options collection="shichangtvList" property="key" labelProperty="value" />
							</html:select>	    -->	
							</td>
						</tr>
						<tr>
						<td>		
						���ӷѣ�
						<html:text name="paiGongDanEntiyForm" property="tfiptvshoushifei" size="12"
								styleClass="commonTextFieldHover" styleId="tfiptvshoushifei" onchange="setvalues(this,'shoushifei')"
								onfocus="this.className='commonTextFieldMove'" maxlength="20"
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
						<tr >
						<td class="editTableTitle" width="30px">������Ӫ��ҵ��</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						�ײͣ�
							
								<html:select name="paiGongDanEntiyForm" property="qtye" styleId="qtye"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'"  onchange="changedainxin()"
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
								styleClass="commonTextFieldHover" onchange="setvalues(this,'nianfei')"
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
						<tr >
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
					
						
					
					<tr >
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
								<html:option value="400">400Ԫ</html:option>
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
								styleClass="commonTextFieldHover" styleId="shoushifei"maxlength="20"readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>
						������Ѻ��
						<html:text name="paiGongDanEntiyForm" property="jidinghe" size="8"
								styleClass="commonTextFieldHover" styleId="jidinghe"maxlength="20"readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>	
						��ѣ�
						<html:text name="paiGongDanEntiyForm" property="nianfei" size="8"
								styleClass="commonTextFieldHover" styleId="nianfei"maxlength="20"readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td>		
						�����£�&nbsp;
						<html:text name="paiGongDanEntiyForm" property="buzuyue" size="8"
								styleClass="commonTextFieldHover" styleId="buzuyue"maxlength="20"readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						��װ�ѣ�
						<html:text name="paiGongDanEntiyForm" property="chuzhuangfei" size="8"maxlength="20"readonly="true"
								styleClass="commonTextFieldHover" value="0" styleId="chuzhuangfei"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						�豸���۷ѣ�
						<html:text name="paiGongDanEntiyForm" property="shebeixiaoshou" size="8"maxlength="20"readonly="false"
								styleClass="commonTextFieldHover" styleId="shebeixiaoshou"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						���Ϸѣ�
						<html:text name="paiGongDanEntiyForm" property="cailiaofei" size="8"maxlength="20"readonly="false"
								styleClass="commonTextFieldHover" styleId="cailiaofei"
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
								rows="5" cols="70" ></html:textarea>
						</td>
					</tr>
				</table>
				</div>
			</div>
			<!--  �����༭ end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="sub();"/>
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('paigongdanList.do?act=init')"/>
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
								<html:option value="�췿">�췿</html:option>
							</html:select>	<a:need />
				<input type="hidden" id="yewushijian" name="yewushijian"/>
				����ʱ�䣺
				<html:text name="paiGongDanEntiyForm" property="kaijishijian"  styleId="kaijishijian"size="12"
								styleClass="commonTextFieldHover" onclick="new Calendar().show(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover';initTingjishijian();"/><a:need />
				ͣ��ʱ�䣺
				<html:text name="paiGongDanEntiyForm" property="tingjishijian"  styleId="tingjishijian"size="12"
								styleClass="commonTextFieldHover"  readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
				�����ֶ�ָ������ʱ�䣩
			</div>
		</div>
		</html:form>
	
	<script type="text/javascript">
	function testDwr(){
		if(check()){
			subDWR("1");
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
	
	function subDWR(type){
	var kaijishijiannew = jQuery("#kaijishijian").val();
			if(kaijishijiannew == "") {
				alert("����ʱ��������룡");
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
	//dwr�ص����� �������ʱ���� 
	callBackCardNo = function(data){
		//alert("11");
		if(data=="N"){
			alert("���û�ϵͳ��û����Ч��¼������¼��");
			return true;
		}else{
			alert("���û��Ѿ���"+data+"Ԥ����");
			return false;
			}
		};
	//dwr�ص����� �������ʱ���� 
	callBackCardNo1 = function(data){
		if(data=="N"){
			commonSubmit('paigongdanEdit.do?act=insert');
		}else{
			if(confirm("���û��Ѿ���"+data+"Ԥ����,�Ƿ���ԣ�")){
				commonSubmit('paigongdanEdit.do?act=insert');
				}
			}
		
		};

	//��ϸ��Ϣ�鿴
	//function showInfo(){
	//	 if(document.forms[0].xiaoquname.value=="������Ԣ"||
	//			 document.forms[0].xiaoquname.value=="������԰"||document.forms[0].xiaoquname.value=="������"){
	//		 document.getElementById("jiaohuanjiid").style.display="";
	//			document.getElementById("onu").value="0";
	//			document.getElementById("onutd").style.display="none";
	//		 }
	//}
	//showInfo();

	//�ύ
	function sub(){
		heji();
		if(checkInput1()){
			var kaijishijiannew = jQuery("#kaijishijian").val();
			if(kaijishijiannew == "") {
				alert("����ʱ��������룡");
				return false;
			}
			var xiangmu = document.forms[0].xiangmu.value;
			var yuyingshang = document.forms[0].yuyingshang.value;
			var shenfenzheng = document.forms[0].shenfenzheng.value;
			var tfkuandaidaikuan = document.forms[0].tfkuandaidaikuan.value;
			var yw = document.getElementById("qtye").value;
			var kuandai = document.getElementById("tfkdnianxian").value;
			var dianshi = document.getElementById("tfiptvshuliang").value;
			if(xiangmu == "��װ"&&presskbn==0) {
				alert("��װ��Ŀ������а�װ�ȶԣ�");
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
					alert("�췿������췿IPTV��������Ӫ��ҵ�����ѡһ����");
					return false;
					}
				}else{
					tfkuandaidaikuan = qiegaidaikuan;
					if(qiegaidaikuan==""||qiegaidaikuan=="0") {
						alert("�췿������췿IPTV��������Ӫ��ҵ�����ѡһ����");
						return false;
					}
				}
			if(isnotyiji) {
					if(yw=="0"&&kuandai=="0"&&dianshi==0&&isnotqiegai) {
					alert("�췿������췿IPTV��������Ӫ��ҵ�����ѡһ����");
					return false;
					}
				}else{
					tfkuandaidaikuan = yichuyewu;
					if((yichuyewu==""||yichuyewu=="0")&&(yichudianshi==""||yichudianshi=="0")&&(yichuqita==""||yichuqita=="0")) {
						alert("�췿������췿IPTV��������Ӫ��ҵ�����ѡһ����");
						return false;
					}
				}
			if(yuyingshang == "����" && (tfkuandaidaikuan != '0' && tfkuandaidaikuan != '')) {
				if(shenfenzheng==null||trim(shenfenzheng)=="0"){
					alert("�������ҵ�����֤���벻��Ϊ�գ�");
					document.forms[0].shenfenzheng.focus();//���ý���
					return false;
				}
				if(checkIdcard(shenfenzheng) != "ok") {
					alert("���֤������˶ԣ�");
					document.forms[0].shenfenzheng.focus();//���ý���
					return false;
				}
			}
			
			subDWR("2");
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
			document.forms[0].xiangmu.value="��װ";
		}
	}
</script>
</body>
</html>