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
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
		%>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
				<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker1.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="yonghushuju/yonghuData.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}

		</style>
		<script type="application/javascript">
			function tuiding(){
				alert("1");
			}

		</script>
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="yonghuDataList.do">
		<bean:define id="xiaoquList" name="yonghuDataForm" property="xiaoquList"></bean:define>
		<bean:define id="statusList" name="yonghuDataForm" property="statusList"></bean:define>
		<bean:define id="senList" name="yonghuDataForm" property="senList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					用户数据导入
				</div>
				<!-- 查询条件 -->
				<div id="conten_query2">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td width="35px">
								小区
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
							<td width="30px">
								地址
							</td>
							<td>
								<html:text name="yonghuDataForm" property="addressCode" size="12"/>
							</td>
							<td width="55px">
								时间类型
							</td>
							<td>
								<html:select name="yonghuDataForm" property="shijianleixing" onclick="check(this)"
									styleClass="commonTextFieldHover"  
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value=""  >-请选择-</html:option>
									<html:option value="1">开机时间</html:option>
									<html:option value="2">停机时间</html:option>
									<html:option value="3">收款日期</html:option>
									<html:option value="4">有效时间</html:option>
								</html:select>
							  
							</td>
							<td>
								开始时间
							</td>
							<td>
								<html:text name="yonghuDataForm" property="kaijis" styleId="kaijis" size="10" onclick="WdatePicker({el:'kaijis'})" readonly="true"/>
								<img onclick="WdatePicker({el:'kaijis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							    
							</td>
							<td>
								结束时间
							</td>
							<td>
								<html:text name="yonghuDataForm" property="kaijie" styleId="kaijie" size="10" onclick="WdatePicker({el:'kaijie'})" readonly="true"/>
								<img onclick="WdatePicker({el:'kaijie'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							    
							</td>
							  <script language="javascript" type="text/javascript">
							    	function check(v){
							    			
							    			if(v.value!=""){
							    					document.forms[0].kaijis.readOnly = false;
													document.forms[0].kaijie.readOnly = false;
							    			}else{
							    					document.forms[0].kaijis.readOnly = true;
													document.forms[0].kaijie.readOnly = true;
							    			}
							    	}
							    </script>
							<td>
								状态
							</td>
							<td>
								<html:select name="yonghuDataForm" property="stateCode"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:option value="退单">退单</html:option>
								<html:option value="已修改">已修改</html:option>
								<html:options collection="statusList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								<!-- 停机2 -->
							</td>
							<td>
							<!--<html:text name="yonghuDataForm" property="tingjis" styleId="tingjis" size="10" onclick="WdatePicker({el:'tingjis'})" />
								<img onclick="WdatePicker({el:'tingjis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							    <html:text name="yonghuDataForm" property="tingjie" styleId="tingjie" size="10" onclick="WdatePicker({el:'tingjie'})" />
								<img onclick="WdatePicker({el:'tingjie'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">--> 
							</td>
						</tr>
						<tr>
							<td>
								查询1
							</td>
							<td>
								<html:select name="yonghuDataForm" property="sen1"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:options collection="senList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								等于
							</td>
							<td>
								<html:text name="yonghuDataForm" property="senValue1" size="12" />
							</td>
							<td>
								查询2
							</td>
							<td>
								<html:select name="yonghuDataForm" property="sen2"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:options collection="senList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								等于
							</td>
							<td>
								<html:text name="yonghuDataForm" property="senValue2" size="12" />
							</td>
							<td>
								查询3
							</td>
							<td>
								<html:select name="yonghuDataForm" property="sen3"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:options collection="senList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								等于
							</td>
							<td>
								<html:text name="yonghuDataForm" property="senValue3" size="12" />
							</td>
							
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('yonghuDataList.do?act=query')" />
							</td>
							<td align="right">
								<input type="button" value="生成退订" class="commonButton tuiding" onclick="commonCheckSubmit2('yonghuDataEdit.do?act=initTuiding2','UUID','请选择待编辑的用户数据')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- 查询结果 start -->
				<div name="result" class="conten_result2">
					<!-- 分页头 -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- 结果一览 start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="140%">
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
									宽带帐号&nbsp;
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
								<td class="tableTitleLine" nowrap="nowrap">
									维修类型&nbsp;
								</td>
							</tr>
							<logic:iterate id="line"
								           name="com.takucin.aceeci.frame.pagination"
								           property="result"
								           type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
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
										<bean:write name="line" field="youxiaoshijian" />
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
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="weixiuleixing" />
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
				<div id="buttonC" name="button" class="content_button" >

				  <html:button property="btnSave" value="编辑" styleClass="commonButton" onclick="commonCheckSubmit('yonghuDataEdit.do?act=initEdit','UUID','请选择待编辑的用户数据')"/>
				  <!--<html:button property="btnSave" value="更换设备" styleClass="commonButton2" onclick="commonCheckSubmit('yonghuDataEdit.do?act=initShebeiEdit','UUID','请选择待编辑的用户数据')"/>-->
				  <html:button property="btnSave" value="查看详情" styleClass="commonButton2" onclick="commonCheckSubmit('yonghuDataEdit.do?act=showInfo','UUID','请选择待查看的用户数据')"/>
				  <html:button property="btnViewPhoto" value="查看照片" styleClass="commonButton" onclick="viewphoto('photouploadEdit.do?act=showPhotoFTP','UUID','请单选择待查看的数据')"/>
				<!--<html:button property="btnSave" value="删除" styleClass="commonButton" onclick="removeData()"/>-->
					<!-- 	<html:button property="btnSave" value="添加" styleClass="commonButton" onclick="commonSubmit('paigongdanEdit.do?act=initInsert')"/>
						<html:button property="btnSave" value="解绑" styleClass="commonButton" onclick="removeData1()"/>
			 	-->
			 	<html:button styleId="tietongExport" property="btnSave" value="铁通数据导出" styleClass="commonButton4" onclick="sub()" />
			 
			 	日期：
			 	 <html:text name="yonghuDataForm" property="daochuriqiStart" styleId="daochuriqiStart" size="10" onclick="WdatePicker1({el:'daochuriqiStart'})" />
				 <img onclick="WdatePicker1({el:'daochuriqiStart'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
			           
			 <%-- 	 <html:button property="btnSave" value="生成铁通对账" styleClass="commonButton4" onclick="sub()"/>
			 	 
			 	 开始：
			 	 <html:text name="yonghuDataForm" property="daochuriqiStart" styleId="daochuriqiStart" size="10" onclick="WdatePicker1({el:'daochuriqiStart'})" readonly="true"/>
				 <img onclick="WdatePicker1({el:'daochuriqiStart'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
			            结束：
			     <html:text name="yonghuDataForm" property="daochuriqiEnd" styleId="daochuriqiEnd" size="10" onclick="WdatePicker1({el:'daochuriqiEnd'})" readonly="true"/>
				 <img onclick="WdatePicker1({el:'daochuriqiEnd'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>  
				  --%>
			    </div>
			</div>
			<html:hidden name="yonghuDataForm" property="quyuCodeHidden" />
			<html:hidden name="yonghuDataForm" property="shijianleixingHidden" />
			<html:hidden name="yonghuDataForm" property="addressCodeHidden" />
			<html:hidden name="yonghuDataForm" property="stateCodeHidden" />
			<html:hidden name="yonghuDataForm" property="kaijisHidden" />
			<html:hidden name="yonghuDataForm" property="kaijieHidden" />
			<html:hidden name="yonghuDataForm" property="senValue1Hidden" />
			<html:hidden name="yonghuDataForm" property="sen2Hidden" />
			<html:hidden name="yonghuDataForm" property="senValue2Hidden" />
			<html:hidden name="yonghuDataForm" property="sen3Hidden" />
			<html:hidden name="yonghuDataForm" property="senValue3Hidden" />
			
		</html:form>
	</div>
	<div id="yonghushangchuan" name="yonghushangchuan" >
		<html:form action="dataUpload.do?act=upload" method="post" enctype="multipart/form-data" >
			<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
				<tr>
					<td>用户数据上传：</td>
					<td><input name="formFile" type="file" size="60"
						class="commonTextFieldHover" 
						onfocus="this.className='commonTextFieldMove'" 
						onblur="this.className='commonTextFieldHover'" />
					
					<html:submit property="telUpload" value="上传" styleClass="commonButton"></html:submit>
					
					<a href="./yonghushuju/yonghudata.xls">模板下载</a>
					</td>
					</tr>
				</table>
		</html:form>
	</div>
		<html:form action="dataUpload.do?act=comparison" method="post" enctype="multipart/form-data" >
			<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
				<tr>
					<td>用户数据比对：</td>
					<td><input name="formFile" type="file" size="60"
						class="commonTextFieldHover" 
						onfocus="this.className='commonTextFieldMove'" 
						onblur="this.className='commonTextFieldHover'" />
					
					<html:submit property="telUpload" value="比对" styleClass="commonButton"></html:submit>		
				<!-- 	<a href="./yonghushuju/yonghudata.xls">模板下载</a> -->
					</td>
					</tr>
				</table>
		</html:form>
			</body>
	<script type="text/javascript"  language="javascript">
		/*
		*	查看照片
		*/
		function viewphoto(action,code,msg){
			if(checkSelect(code,msg)){
				var group = $("[name='UUID']").filter(":checked");
				var uuid = group.val();
				window.open('<%=basePath%>'+action+'&uuid='+uuid,'newwindow','height='+(window.screen.availHeight-30)+',width='+(window.screen.availWidth-10)+',top=0,left=0,toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
			}
		}
		function  hiddenEditDiv() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			switch (roleCode) {         
			        case '5': 
			 			break;               
			    	 case '4':               
			            document.getElementById("buttonC").style.display="none";  
			            break;  
			         case '8': 
			         		document.getElementById("tietongExport").style.display="none";  
			        	  //document.getElementById("yonghushangchuan").style.display="none";  
			 		    break;   
			} 
		}
		hiddenEditDiv();	
		
		
		function sub() {
			if (checkInput()) {
				commonSubmit('tietongimport.do?act=importTietong');
				//commonSubmit('tietongduizhangimport.do?act=tietongduizhangimport');
			}
	    }
	    
	    checkInput =  function(){
	    	var daochuriqiStart = document.forms[0].daochuriqiStart.value;
			if (daochuriqiStart == null || trim(daochuriqiStart) == "") {
				alert("请选择要导出的日期！");
				document.forms[0].daochuriqiStart.focus();// 设置焦点
				return false;
			}
			
			/* var daochuriqiEnd = document.forms[0].daochuriqiEnd.value;
			if (daochuriqiEnd == null || trim(daochuriqiEnd) == "") {
				alert("请选择要导出的结束日期！");
				document.forms[0].daochuriqiEnd.focus();// 设置焦点
				return false;
			}
			
			if (daochuriqiEnd < daochuriqiStart){
				alert("结束日期不能大于开始日期");
				document.forms[0].daochuriqiEnd.focus();// 设置焦点
				return false;
			} */
			return true;
	    };
	</script>
</html>
