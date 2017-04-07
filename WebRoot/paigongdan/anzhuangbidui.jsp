<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2015-07-06   Dai-Zhen           Create
   
  -->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>�췿�Ƽ���������ϵͳ</title>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<script src="kucun/kucun.js" language="javascript"></script>
		<script type="text/javascript">
		function initchange() {
			var uuids = document.getElementsByName("UUID").length;
			if(uuids==0) {
				alert("�ޱȶ���Ϣ");
				window.opener.aftercompareselect();
					window.close();
			}
			var check = window.opener.document.getElementById("selectCommunityPileID");
			if(check==undefined) {
				document.getElementById("buttonC").style.display = "none";
			}
			var selectkbn = document.getElementById("selectkbn").value;
			if(selectkbn=="2") {
				document.getElementById("qiegaibtn").style.display = "none";
				$("#selecbtn").removeClass("commonButton2");
				$("#selecbtn").css('color','black').css('background-color','rgb(81, 255, 0)').css('height','21px');
			}
			if(window.opener.document.getElementById("falseyiji")==undefined) {
				document.getElementById("qiegaibtn").style.display = "none";
			}
		}
			function selectdeviceCheck() {
					selectdevice();
			}
			function selectdevice() {
				var uuids = document.getElementsByName("UUID");
				var uuids1 = document.getElementsByName("UUID1");
				var eqregisters = document.getElementsByName("fenguang");
				var eqmacs = document.getElementsByName("onumac");
				var eqmcids = document.getElementsByName("stbmcid");
				var eqips = document.getElementsByName("dianshiip");
				var youxiaoshijians = document.getElementsByName("youxiaoshijian");
				var wangluos = document.getElementsByName("wangluo");
				var dianshis = document.getElementsByName("dianshi");
				var qtyes = document.getElementsByName("qtyes");
				var successkbn = true;
				var tingjishijian = "";
				var tingjishijian1 = "";
				var tingjishijian2 = "";
				var tingjishijian3 = "";
				var tingjishijiansize = 0;
				for(var i=0;i<uuids.length;i++){
					if(uuids[i].checked){
						var eqmacVal = eqmacs[i].value;
						//if(eqmacVal==""||eqmacVal=="��"||eqmacVal=="0") {
							//window.opener.document.getElementById("stbmcid").value = eqmcids[i].value;
							//window.opener.document.getElementById("dianshiip").value = eqips[i].value;
							//window.opener.document.getElementById("eqboxnum2").value = eqboxnums[i].value;
						//}else{
						var onuid = window.opener.document.getElementById("selectCommunityPileID").value;
							if(onuid!=""&&onuid!="0") {
								alert("��������ѡ��ONU�豸������ִ�С��豸�ؿ⡿������");
								successkbn = false;
							}else{
								window.opener.document.getElementById("fenguang").value = eqregisters[i].value;
								window.opener.document.getElementById("onumac").value = eqmacVal;
								var selectkbn = document.getElementById("selectkbn").value;
								if(selectkbn!="2") {
									window.opener.document.getElementById("bdfenguang").value = eqregisters[i].value;
									window.opener.document.getElementById("bdonumac").value = eqmacVal;
								}else{
									window.opener.document.getElementById("yjfenguang").value = eqregisters[i].value;
									window.opener.document.getElementById("yjonumac").value = eqmacVal;
									if(wangluos[i].value!=""&&wangluos[i].value!="0") {
											window.opener.document.getElementById("yichutingjishijian").value = youxiaoshijians[i].value;
											tingjishijian1 = youxiaoshijians[i].value;
											tingjishijian = youxiaoshijians[i].value;
											tingjishijiansize++;
											window.opener.document.getElementById("yichuyewu").value = wangluos[i].value;
										}else{
											window.opener.document.getElementById("yichuqita").value = qtyes[i].value;
											window.opener.document.getElementById("yichutingjishijianqt").value = youxiaoshijians[i].value;
											tingjishijian2 = youxiaoshijians[i].value;
											tingjishijian = youxiaoshijians[i].value;
											tingjishijiansize++;
									}
								}
							}
							//window.opener.document.getElementById("eqboxnum").value = eqboxnums[i].value;
						//}
					}
				}
				for(var i=0;i<uuids1.length;i++){
					if(uuids1[i].checked){
						var eqmacVal = eqmacs[i].value;
						//if(eqmacVal==""||eqmacVal=="��"||eqmacVal=="0") {
						var boxid = window.opener.document.getElementById("selectCommunityPileID2").value;
							if(boxid!=""&&boxid!="0") {
								alert("��������ѡ�Ļ������豸������ִ�С��豸�ؿ⡿������");
								successkbn = false;
							}else{
								window.opener.document.getElementById("stbmcid").value = eqmcids[i].value;
								window.opener.document.getElementById("dianshiip").value = eqips[i].value;
								if(selectkbn!="2") {
									window.opener.document.getElementById("bdstbmcid").value = eqmcids[i].value;
									window.opener.document.getElementById("bddianshiip").value = eqips[i].value;
								}else{
									window.opener.document.getElementById("yjstbmcid").value = eqmcids[i].value;
									window.opener.document.getElementById("yjdianshiip").value = eqips[i].value;
									window.opener.document.getElementById("yichudianshi").value = dianshis[i].value;
									window.opener.document.getElementById("yichutingjishijiands").value = youxiaoshijians[i].value;
									tingjishijian3 = youxiaoshijians[i].value;
									tingjishijian = youxiaoshijians[i].value;
									tingjishijiansize++;
								}
							}
							//window.opener.document.getElementById("eqboxnum2").value = eqboxnums[i].value;
						//}else{
							//window.opener.document.getElementById("fenguang").value = eqregisters[i].value;
							//window.opener.document.getElementById("onumac").value = eqmacVal;
							//window.opener.document.getElementById("eqboxnum").value = eqboxnums[i].value;
						//}
					}
				}
				if(successkbn) {
					if(selectkbn!="2") {
						window.opener.document.getElementById("biduikbn").value = "������Ϣ";
						window.opener.aftercompareselect();
					}
					if(tingjishijiansize==1) {
						window.opener.document.forms[0].tingjishijian.value = tingjishijian;
					}else{
						
					} 
				}
				window.close();
			}
			function notbangding() {
				window.opener.document.getElementById("biduikbn").value = "������Ϣ";
				window.opener.aftercompareselect();
				window.close();
			}
			function qiegai() {
				var uuids = document.getElementsByName("UUID");
				var youxiaoshijians = document.getElementsByName("youxiaoshijian");
				var wangluos = document.getElementsByName("wangluo");
				for(var i=0;i<uuids.length;i++){
					if(uuids[i].checked){
						if(wangluos[i].value==""||wangluos[i].value=="��"||wangluos[i].value=="0") {
							alert("�����и�����Ϊ�յ���·��");
							return  false;
						}
						window.opener.document.forms[0].qiegaidaikuan.value = wangluos[i].value;
						window.opener.document.forms[0].qiegaitingjishijian.value = youxiaoshijians[i].value;
						window.opener.document.forms[0].tingjishijian.value = youxiaoshijians[i].value;
						window.opener.document.forms[0].tfkdnianxian.disabled = "disabled";
						window.opener.document.getElementById("falseyiji").checked = "true";
						window.opener.enableyiji(false);
						window.opener.document.getElementById("tfkdnianxian").disabled = "disabled";
						window.opener.document.getElementById("trueqiegai").checked = "true";
						window.opener.document.forms[0].qiegaidaikuan.disabled = "";
						window.opener.document.forms[0].qiegaitingjishijian.disabled = "";
						selectdeviceCheck();
					}
				}
			}
		</script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init();initchange();">
	<div style="height:440px;">
		<html:form action="shebeichukuList.do">
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					��װ�ȶ�
				</div>
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result" style="padding-top: 0px; ">
					<!-- ��ҳͷ -->
					<div name="page_up" class="page_up">
						 <jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- ���һ�� start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="140%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine" nowrap="nowrap">
									ONU&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									������&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�û�״̬&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ƥ��״̬&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�տ�ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���֤��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�վݺ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�ֹ��ߺ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����λ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ͣ��ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��Чʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									С��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ַ&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ϵ�绰&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�绰&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ҵ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�ֹ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									Onu mac&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									STB MCID&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�绰IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�绰VLAN&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����VLAN&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��֤&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ѡ�绰����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ONUѺ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									������Ѻ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���ӷ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��װ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�豸���۷�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���Ϸ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��Ӫ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����¹���&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ע&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���շ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�վݱ���/�վݺ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��Ʊ��Ϣ&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����豸ʹ�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����Ĳ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									������&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									RJ11&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									RJ45&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ģ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ʩ����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�ֳ���ע&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ע����&nbsp;
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID1" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yonghuzhuangtai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="pipeizhuangtai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoukuanshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xingming" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shenfensheng" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoujuhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="fenguangxianhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="jiexuweizhi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaijishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="tingjishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="youxiaoshijian" />
										<input type="hidden" name="youxiaoshijian" value="<bean:write name="line" field="youxiaoshijian" />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="lianxidianhua" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangluo" />
										<input type="hidden" name="wangluo" value="<bean:write name="line" field="wangluo" />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianshi" />
										<input type="hidden" name="dianshi" value="<bean:write name="line" field="dianshi" />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianhua" />
										<input type="hidden" name="qtyes" value="<bean:write name="line" field="dianhua" />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yewu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="fenguang" />
										<input type="hidden" name="fenguang" value="<bean:write name="line" field="fenguang" />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="onumac" />
										<input type="hidden" name="onumac" value="<bean:write name="line" field="onumac" />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="stbmcid" />
										<input type="hidden" name="stbmcid" value="<bean:write name="line" field="stbmcid" />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianshiip" />
										<input type="hidden" name="dianshiip" value="<bean:write name="line" field="dianshiip" />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangluoip" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianhuaip" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianhuavlan" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangluovlan" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shangmenshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="danzheng" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="sxdhhm" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="onuyj" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="jidingheyj" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoushifei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kuandaifei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="chuzhuangfei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shebeixiaoshou" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cailiaofei" />
									</td>
									
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yunyingshang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="bzygf" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="nianfei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="beizhu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="zongshoufei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoujubenhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaipiaoxinxi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="qtsbsyqk" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="qitahaocai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="jiexianzi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="rj11" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="rj45" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="mokuai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="mianban" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangxian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shigongren" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xianchangbeizhu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap"><br />
										<bean:write name="line" field="beizhuhuizong" />
									</td>
								</tr>
							</logic:iterate>
						</table>
					</div>
					<!-- ���һ�� end-->
					<div name="page_down" class="page_downuser">
						<div align="right">
						<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- ��ѯ��� end -->
				<!-- button -->
				<div id="buttonC" name="button" class="content_button1" >
					<html:hidden property="busi" name="paiGongDanForm" styleId="selectkbn" />
			    	<html:button styleId="selecbtn" property="btnSelect" value="ָ��ѡȡ�豸" styleClass="commonButton2" onclick="selectdeviceCheck()"/>
			    	<html:button property="btnSelect2" value="����" styleClass="commonButton2" onclick="notbangding()"/>
			    	<html:button styleId="qiegaibtn" property="btnSelect2" value="�и���·" style="color:black;background-color:rgb(81, 255, 0);height: 21px;"  onclick="qiegai()"/>
			    </div>
			</div>
		</html:form>
	</div>
	</body>
</html>
