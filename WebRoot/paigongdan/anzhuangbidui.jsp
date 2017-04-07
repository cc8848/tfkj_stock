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
		<title>天房科技工单管理系统</title>
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
				alert("无比对信息");
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
						//if(eqmacVal==""||eqmacVal=="　"||eqmacVal=="0") {
							//window.opener.document.getElementById("stbmcid").value = eqmcids[i].value;
							//window.opener.document.getElementById("dianshiip").value = eqips[i].value;
							//window.opener.document.getElementById("eqboxnum2").value = eqboxnums[i].value;
						//}else{
						var onuid = window.opener.document.getElementById("selectCommunityPileID").value;
							if(onuid!=""&&onuid!="0") {
								alert("存在已挑选的ONU设备，请先执行【设备回库】操作！");
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
						//if(eqmacVal==""||eqmacVal=="　"||eqmacVal=="0") {
						var boxid = window.opener.document.getElementById("selectCommunityPileID2").value;
							if(boxid!=""&&boxid!="0") {
								alert("存在已挑选的机顶盒设备，请先执行【设备回库】操作！");
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
						window.opener.document.getElementById("biduikbn").value = "存在信息";
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
				window.opener.document.getElementById("biduikbn").value = "存在信息";
				window.opener.aftercompareselect();
				window.close();
			}
			function qiegai() {
				var uuids = document.getElementsByName("UUID");
				var youxiaoshijians = document.getElementsByName("youxiaoshijian");
				var wangluos = document.getElementsByName("wangluo");
				for(var i=0;i<uuids.length;i++){
					if(uuids[i].checked){
						if(wangluos[i].value==""||wangluos[i].value=="　"||wangluos[i].value=="0") {
							alert("不能切改网络为空的线路！");
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
				<!-- 标题 -->
				<div class="conten_top" name="top">
					安装比对
				</div>
				<!-- 查询结果 start -->
				<div name="result" class="conten_result" style="padding-top: 0px; ">
					<!-- 分页头 -->
					<div name="page_up" class="page_up">
						 <jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- 结果一览 start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="140%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine" nowrap="nowrap">
									ONU&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									机顶盒&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									用户状态&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									匹配状态&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收款时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									姓名&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									身份证号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收据号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									分光线号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									接续位置&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									开机时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									停机时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									有效时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									小区&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									地址&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									联系电话&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									网络&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									电视&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									电话&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									业务&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									分光&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									Onu mac&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									STB MCID&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									电视IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									网络IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									电话IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									电话VLAN&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									网络VLAN&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									上门时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									单证&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									所选电话号码&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ONU押金&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									机顶盒押金&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收视费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									宽带费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									初装费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									设备销售费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									材料费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									运营商&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									不足月够费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									年费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									备注&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									总收费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收据本号/收据号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									开票信息&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									其他设备使用情况&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									其他耗材&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									接线子&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									RJ11&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									RJ45&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									模块&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									面板&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									网线&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									施工人&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									现场备注&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									备注汇总&nbsp;
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
					<!-- 结果一览 end-->
					<div name="page_down" class="page_downuser">
						<div align="right">
						<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- 查询结果 end -->
				<!-- button -->
				<div id="buttonC" name="button" class="content_button1" >
					<html:hidden property="busi" name="paiGongDanForm" styleId="selectkbn" />
			    	<html:button styleId="selecbtn" property="btnSelect" value="指定选取设备" styleClass="commonButton2" onclick="selectdeviceCheck()"/>
			    	<html:button property="btnSelect2" value="不绑定" styleClass="commonButton2" onclick="notbangding()"/>
			    	<html:button styleId="qiegaibtn" property="btnSelect2" value="切改线路" style="color:black;background-color:rgb(81, 255, 0);height: 21px;"  onclick="qiegai()"/>
			    </div>
			</div>
		</html:form>
	</div>
	</body>
</html>
