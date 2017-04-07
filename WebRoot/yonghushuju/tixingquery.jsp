<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2012-11-23     Zhu,Xiao-Lei     Create
   
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
		<title>快速开发框架演示项目</title>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="yonghushuju/yonghuData.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="jiaofeiTXList.do">
		<bean:define id="xiaoquList" name="yonghuDataForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					缴费数据导入
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								小区：
							</td>
							<td>
								<html:select name="yonghuDataForm" property="quyuCode"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								地址：
							</td>
							<td>
								<html:text name="yonghuDataForm" property="addressCode" size="12" onkeypress="if(event.keyCode==13||event.which==13){'return false';}"/>
							</td>
							<td>
								停机时间：
							</td>
							<td>
							    <html:text name="yonghuDataForm" property="tingjiDate" styleId="paigongriqis" size="10" onclick="WdatePicker({el:'paigongriqis'})" />
								<img onclick="WdatePicker({el:'paigongriqis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							</td>
							
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('jiaofeiTXList.do?act=query')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- 查询结果 start -->
				<div name="result" class="conten_result">
					<!-- 分页头 -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- 结果一览 start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="98%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
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
										<!--<input type="checkbox" id="UUIDSS" onclick="setPK_ID(this.value);" value="<bean:write name="line" field="PK_ID" />"/>
										 onclick="checkAll(this,'checkBox');"-->
										 <input name="UUID" type="radio" value="${line.id}" />
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
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianshi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianhua" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yewu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="fenguang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="onumac" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="stbmcid" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianshiip" />
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
									<td class="tableContentLine" nowrap="nowrap">
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
				<div name="button" class="content_button">
				<!-- 
					<html:button property="btnSave" value="批量更新" styleClass="commonButton2" onclick="commonCheckSubmit('jiaofeiTXEdit.do?act=initEdit&UUIDS=' + arrayObj.join(','),'UUIDSS','请选择待编辑的用户数据')"/>
					 -->
				<!-- 	 <html:button property="btnSave" value="更新" styleClass="commonButton2" onclick="commonCheckSubmit('jiaofeiTXEdit.do?act=initEdit','UUID','请选择待更新的用户缴费数据')"/> -->
				</div>
			</div>
			<html:hidden name="yonghuDataForm" property="quyuCodeHidden" />
			<html:hidden name="yonghuDataForm" property="addressCodeHidden" />
			<html:hidden name="yonghuDataForm" property="tingjiDateHidden" />
		</html:form>
		</div>
		<html:form action="jiaoFeidataUpload.do?act=jiaoFeiUpload" method="post" enctype="multipart/form-data" >
				<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
					<tr>
						<td>缴费上传：</td>
						<td><input name="formFile" type="file" size="60"
							class="commonTextFieldHover" 
							onfocus="this.className='commonTextFieldMove'" 
							onblur="this.className='commonTextFieldHover'" />
						<html:submit property="btnUpload" value="上传" styleClass="commonButton"></html:submit>
						
						<a href="./yonghushuju/yonghudata.xls">模板下载</a>
						</td>
						</tr>
					</table>
			</html:form>
		<script type="text/javascript">
			var arrayObj = new Array();
			
			function setPK_ID(value) {
				var sta = 1;
				//
				//
				//
				for (var i = 0; i < arrayObj.length; i++) {
					if (arrayObj[i] == value) {
						arrayObj.splice(i, 1);
						sta = 0;
					}
				}
				if (sta == 1) {
					arrayObj.push(value);
				}
				//arrayObj.push(value);
				//arrayObj.join(separator); 
				//alert(arrayObj.join(','));
			}
			function updateData() {
				commonSubmit('equipStockEdit.do?act=yiku&UUIDS=' + arrayObj.join(','));
			}
		</script>
	</body>

</html>
