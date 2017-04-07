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
			function selectdeviceCheck(closekbn) {
				if(checkSelect("UUID","请选择要挑选的设备！")){
					selectdevice(closekbn);
				}
			}
			function selectdevice(closekbn) {
				var uuids = document.getElementsByName("UUID");
				var eqboxnums = document.getElementsByName("eqboxnum");
				var eqregisters = document.getElementsByName("eqregister");
				var eqmacs = document.getElementsByName("eqmac");
				var eqmcids = document.getElementsByName("eqmcid");
				var eqips = document.getElementsByName("eqip");
				for(var i=0;i<uuids.length;i++){
					if(uuids[i].checked){
						var eqmacVal = eqmacs[i].value;
						if(eqmacVal==""||eqmacVal=="　"||eqmacVal=="0") {
							var boxid = window.opener.document.getElementById("selectCommunityPileID2").value;
							if(boxid!=""&&boxid!="0") {
								alert("存在已挑选的机顶盒设备，请先执行【设备回库】操作！");
								return false;
							}
							window.opener.document.getElementById("selectCommunityPileID2").value = uuids[i].value;
							window.opener.document.getElementById("stbmcid").value = eqmcids[i].value;
							window.opener.document.getElementById("dianshiip").value = eqips[i].value;
							window.opener.document.getElementById("eqboxnum2").value = eqboxnums[i].value;
						}else{
							var onuid = window.opener.document.getElementById("selectCommunityPileID").value;
							if(onuid!=""&&onuid!="0") {
								alert("存在已挑选的ONU设备，请先执行【设备回库】操作！");
								return false;
							}
							window.opener.document.getElementById("selectCommunityPileID").value = uuids[i].value;
							if(window.opener.document.getElementById("fenguangID").value=="") {
								window.opener.document.getElementById("fenguang").value = eqregisters[i].value;
							}
							window.opener.document.getElementById("onumac").value = eqmacVal;
							window.opener.document.getElementById("eqboxnum").value = eqboxnums[i].value;
						}
					}
				}
				window.opener.afterselect();
				if(closekbn==0) {
					window.close();
				}
			}
		</script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="shebeichukuList.do">
		<bean:define id="statusList" name="kucunForm" property="statusList"></bean:define>
		<bean:define id="xiaoquList" name="kucunForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					挑选设备
				</div>
				<!-- 查询条件 -->
				<div id="conten_query2">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td >
								设备状态
							</td>
							<td>
								<html:select style="width:80px" name="kucunForm" property="status"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<option value="2">出库现场</option>
								</html:select>	
							</td>
							
							<td >
								入库小区
							</td>
							<td>
								<html:select style="width:80px" name="kucunForm" property="quyuCode"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove';this.defaultIndex=this.selectedIndex"
									onchange="this.selectedIndex=this.defaultIndex" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select>	
							</td>
							
							<td >
								安装地点
							</td>
							<td>
								<html:text name="kucunForm" property="install_site" size="12"/>
							</td>
							
							<td>
								MAC
							</td>
							<td>
								<html:text name="kucunForm" property="qmac" size="12"/>
							</td>
							<td >
								MCID
							</td>
							<td>
								<html:text name="kucunForm" property="qmcid" size="12"/>
							</td>
							
						</tr>
						
						<tr>
							<td style="display:none">
								时间类型
							</td>
							<td style="display:none">
								<html:select name="kucunForm" property="shijianleixing" onclick="check(this)"
									styleClass="commonTextFieldHover"  
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value=""  >-请选择-</html:option>
									<html:option value="1">入库日期</html:option>
									<html:option value="2">小区入库日期</html:option>
									<html:option value="3">安装时间</html:option>
								</html:select>
							</td>
							<td style="display:none">
								开始时间：
							</td>
							<td style="display:none">
								<html:text name="kucunForm" property="kaishi" styleId="kaishi" size="10" onclick="WdatePicker({el:'kaishi'})" />
								<img onclick="WdatePicker({el:'kaishi'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
							</td>
							<td style="display:none">
								结束时间：
							</td>
							<td style="display:none">
								<html:text name="kucunForm" property="jieshu" styleId="jieshu" size="10" onclick="WdatePicker({el:'jieshu'})" />
								<img onclick="WdatePicker({el:'jieshu'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
							</td>
							<td>
								设备类型：
							</td>
							<td colSpan="5">
								<html:radio name="kucunForm" property="shebeitype" value="0" >ONU</html:radio>
								<html:radio name="kucunForm" property="shebeitype" value="1">机顶盒</html:radio>
							</td>
							<td>
								综合查询：
							</td>
							<td>
								<html:select name="kucunForm" property="sen"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:option value="1">箱号</html:option>
									<html:option value="2">入库人</html:option>
									<html:option value="3">设备类型</html:option>
									<html:option value="4">设备型号</html:option>
									<html:option value="5">领取人</html:option>
									<html:option value="6">注册位置</html:option>
									<html:option value="7">数据IP</html:option>
									<html:option value="8">备注</html:option>
								</html:select>
							</td>
							<td>
								等于
							</td>
							<td>
								<html:text name="kucunForm" property="senValue" size="12" />
							</td>
							<td>
								<!-- <input type="button" value="查询" class="commonButton" onclick="commonSubmit('shebeichukuList.do?act=query')" /> -->
								 <input type="button" value="查询" class="commonButton" onclick="if(check()){commonSubmit('shebeichukuList.do?act=query');}" />
							</td>
							<!-- <td >
								<input type="button" value="搜寻结果内查询" class="commonButton4" onclick="" />
							</td> -->
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
								<td class="tableTitleLine" nowrap="nowrap">
									编辑&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									箱号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									设备状态&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									入库日期&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									入库人&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									设备类型&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									设备型号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									小区入库日期&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									入库小区&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									领取人&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									安装地点&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									安装时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									注册位置&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									MAC&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									MCID&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									数据IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									备注&nbsp;
								</td>
				
							</tr>
							<logic:iterate id="line"
								           name="com.takucin.aceeci.frame.pagination"
								           property="result"
								           type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="<bean:write name='line' field='PK_ID' />" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqboxnum" />
										<input type="hidden" name="eqboxnum" value="<bean:write name='line' field='eqboxnum' />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqsta_name" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="create_time" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="create_person" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqtype" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqversion" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="FirstEnterDate" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="CommunityName" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="getPerson" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="Install_site" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="Install_time" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqregister" />
										<input type="hidden" name="eqregister" value="<bean:write name='line' field='eqregister' />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqmac" />
										<input type="hidden" name="eqmac" value="<bean:write name='line' field='eqmac' />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqmcid" />
										<input type="hidden" name="eqmcid" value="<bean:write name='line' field='eqmcid' />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqip" />
										<input type="hidden" name="eqip" value="<bean:write name='line' field='eqip' />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">&nbsp;
										<bean:write name="line" field="eqremark" />
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
			    	<html:button property="btnSelect" value="选取设备" styleClass="commonButton2" onclick="selectdeviceCheck(0)"/>
			    	<html:button property="btnSelect" value="保存并继续挑选" styleClass="commonButton2" onclick="selectdeviceCheck(1)"/>
			    </div>
			</div>
			
			<html:hidden name="kucunForm" property="UUIDHidden" />	
		</html:form>
	</div>
	</body>
</html>
