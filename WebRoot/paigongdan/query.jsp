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
		<script src="js/Calendar3.js" language="javascript"></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="paigongdan/paigongdan.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		
	<script type="text/javascript"  language="javascript">
		function  hiddenEditDiv2() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			if(roleCode!='5'&&roleCode!='8') {
				document.getElementById("deviceedit").style.display="none";
				document.getElementById("btnfenguangpipei").style.display="none";
				document.getElementById("btnfenguangback").style.display="none";
			}
			if(roleCode!='5'&&roleCode!='8'&&roleCode!='2') {
				document.getElementById("btnEdit").style.display="none";
			}
		}
		function deletecheck(uuid) {
			var uuids = document.getElementsByName(uuid);
			var fenguangs = document.getElementsByName("fenguangD");
			var onumacs = document.getElementsByName("onumacD");
			var stbmcids = document.getElementsByName("stbmcidD");
			var dianshiips = document.getElementsByName("dianshiipD");
			var fenguangid = document.getElementsByName("fenguangID");
			for(var i=0;i<uuids.length;i++){
				if(uuids[i].checked){
					if(!checkValue(fenguangs[i].value)&&!checkValue(fenguangid[i].value)){
						alert("所选派工单关联有分光，请先执行【分光回收】操作，再进行删除!");
						return true;
					}else if(checkValue(onumacs[i].value)&&checkValue(stbmcids[i].value)&&checkValue(dianshiips[i].value)) {
						//return true;
					}else{
						alert("所选派工单关联有设备，请先执行【设备回库】操作，再进行删除!");
						return true;
					}
				}
			}
			return false;	
		}
		function checkValue(val) {
			if(val==""||val=="0"||val=="　"||val==" ") {
				return true;
			}
		}
		</script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init();hiddenEditDiv2()">
		<html:form action="paigongdanList.do">
		<bean:define id="xiaoquList" name="paiGongDanForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					派工单管理
				</div>
				<!-- 查询条件 -->
				<div id="conten_query2" >
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								派工日期
							</td>
							<td>
								<html:text name="paiGongDanForm" property="paigongriqis" styleId="paigongriqis" size="10" onclick="new Calendar().show(this)" />		
							</td>
							<td>
								项目
							</td>
							<td>
								<html:select name="paiGongDanForm" property="xiangmus"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">-请选择-</html:option>
								<html:option value="安装">安装</html:option>
								<html:option value="收件">收件</html:option>
								<html:option value="续费">续费</html:option>
								<html:option value="退户">退户</html:option>
								<html:option value="维修">维修</html:option>
							</html:select>
							</td>
							<td>
								小区名称
							</td>
							<td>
								<html:select name="paiGongDanForm" property="xiaoqu"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">-请选择-</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							</td>
							<td>
								地址
							</td>
							<td>
								<html:text name="paiGongDanForm" property="userplaces" size="10" />
							</td>
							<td>
								联系电话
							</td>
							<td>
								<html:text name="paiGongDanForm" property="userTel" size="10" />
							</td>
							<td>
								
							</td>
							<td>
								
							</td>
							</tr>
							<tr>
							<td>
								派工单状态
							</td>
							<td>
							<html:select name="paiGongDanForm" property="state"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">-请选择-</html:option>
								<html:option value="1">已预约</html:option>
								<html:option value="5">数据完工</html:option>
								<html:option value="6">施工中</html:option>
								<html:option value="7">工毕</html:option>
								<html:option value="8">结单</html:option>
							</html:select>
							</td>
							<td>电话号码</td>
							<td><html:text name="paiGongDanForm" property="telnumber" size="10" /></td>
							<td>创建人</td>
							<td><html:text name="paiGongDanForm" property="createbyCode" size="10" /></td>
							<td>
								创建日期
							</td>
							<td>
								<html:text name="paiGongDanForm" property="createdtCode" styleId="createdtCode" size="10" onclick="new Calendar().show(this)" />
								-<html:text name="paiGongDanForm" property="createdtCode2" styleId="createdtCode2" size="10" onclick="new Calendar().show(this)"/>
							</td>
							<td>
								业务
							</td>
							<td>
								<html:select name="paiGongDanForm" property="busi"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">-请选择-</html:option>
								<html:option value="1">天房宽带</html:option>
								<html:option value="2">IP电视</html:option>
								<html:option value="3">其他业务</html:option>
							</html:select>
							</td>
							<td></td>
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('paigongdanList.do?act=query')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- 查询结果 start -->
				<div name="result" class="conten_result2"  >
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
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									状态
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									提交状态
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									安装比对
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									创建人
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									创建时间
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									项目
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									派工日期
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									时间
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									小区名称
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									用户姓名
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									用户地址
								</td>
								<td class="tableTitleLine" weight="20%"nowrap="nowrap">
									联系电话
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									天房宽带
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									IP电视
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									三方业务
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									其他业务
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									分光
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									onu mac
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									STB MCID
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电视IP
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电话号码
								</td>
								<!-- <td class="tableTitleLine">
									用户要求
								</td> -->
								<td class="tableTitleLine"nowrap="nowrap">
									ONU押金
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									机顶盒押金
								</td>
								<td class="tableTitleLine">
									备注
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine">
										<input name="UUIDS" type="checkbox" value="${line.id}" />
									</td>
									<td class="tableContentLine">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<!-- <td class="tableContentLine">
										<bean:write name="line" field="PK_ID" />
									</td> -->
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="stateName" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="importstate" /><input type="hidden" name="importstatehidden" value="<bean:write name="line" field="importstate" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<font color="blue"><bean:write name="line" field="biduikbn" /></font>									
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="createby" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="createdt" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="xiangmu" /><input type="hidden" name="xiangmu" value="<bean:write name="line" field="xiangmu" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="paigongriqi" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="anzhuangshijian" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="xiaoquname" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="username" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="userplace" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="usertel" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tfkuandaidaikuan" />/<bean:write name="line" field="tfkdnianxian" />
									</td>
									
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tfiptv" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tfsfyewu" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="qtye" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="bdfenguang" filter="false"/>
										<input type="hidden" name="fenguangD" value="<bean:write name='line' field='fenguangD' />"/>
										<input type="hidden" name="fenguangID" value="<bean:write name='line' field='fenguangID' />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="bdonumac"  filter="false"/>
										<input type="hidden" name="onumacD" value="<bean:write name='line' field='onumacD' />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="bdstbmcid"  filter="false"/>
										<input type="hidden" name="stbmcidD" value="<bean:write name='line' field='stbmcidD' />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="bddianshiip"  filter="false"/>
										<input type="hidden" name="dianshiipD" value="<bean:write name='line' field='dianshiipD' />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="telhaoma1" />&nbsp;<bean:write name="line" field="telhaoma2" />
									</td>
									<!-- <td class="tableContentLine">
										<bean:write name="line" field="useryaoqiu" />
									</td> -->
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="onu" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="jidinghe" />
									</td>
									<td class="tableContentLine" width="29%" nowrap="nowrap">
										<bean:write name="line" field="beizhu" />
									</td>
								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- 结果一览 end-->
					<div name="page_down" class="page_down">
						<div align="right">
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- 查询结果 end -->
				<!-- button -->
				<div name="button" class="content_button" style="width:50%">
						<html:button property="btnSave" value="添加" styleClass="commonButton" onclick="commonSubmit('paigongdanEdit.do?act=initInsert')"/>
						 <html:button styleId="btnEdit" property="btnSave" value="编辑" styleClass="commonButton" onclick="if(checkjti('UUID')) {commonCheckSubmit('paigongdanEdit.do?act=initEdit','UUID','请选择待编辑的派工单');}"/>
						<html:button property="btnSave" value="删除" styleClass="commonButton" onclick="if(checkjti('UUID')) {removeData();}"/>
					<!-- <html:button property="btnSave" value="解绑" styleClass="commonButton" onclick="removeData1()"/> -->	
						<html:button property="btnSave" value="查看详情" styleClass="commonButton2" onclick="commonCheckSubmit('paigongdanEdit.do?act=showInfo','UUID','请选择待查看的派工单')"/>
					<!--<html:button styleId="deviceedit" property="btnSave" value="设备编辑" styleClass="commonButton2" onclick="if(checkjti('UUID')) {commonCheckSubmit('paigongdanEdit.do?act=initEdit&devicekbn=1','UUID','请选择待编辑的派工单');}"/>
						<html:button styleId="btnfenguangpipei" property="btnfenguangpipei" value="匹配分光"  style="color:white;background-color:green;height: 21px;"  onclick="if(checkjti('UUIDS')) {pipeifenguang();}"/>
						<html:button styleId="btnfenguangback" property="btnfenguangback" value="分光回收"  style="color:black;background-color:rgb(255, 110, 0);height: 21px;"  onclick="if(checkjti('UUIDS')) {commonCheckSubmit('paigongdanEdit.do?act=recyclepgd','UUIDS','请选择待回收的记录');}"/>
					<div id="buttonC" name="button" class="content_button" >
						<input type="button" class="commonButton2" value="导出报表" onclick="exportNoBind();"/>
					</div>-->	
				</div>
			</div>
			<html:hidden name="paiGongDanForm" property="stateDateHidden" />
			<html:hidden name="paiGongDanForm" property="endDateHidden" />
			<html:hidden name="paiGongDanForm" property="xiaoquHidden" />
			<html:hidden name="paiGongDanForm" property="userTelHidden" />
			<html:hidden name="paiGongDanForm" property="stateHidden" />
			<html:hidden name="paiGongDanForm" property="paigongriqisHidden" />
			<html:hidden name="paiGongDanForm" property="xiangmusHidden" />
			<html:hidden name="paiGongDanForm" property="busiHidden" />
			<html:hidden name="paiGongDanForm" property="telnumbeHidden" />
			<html:hidden name="paiGongDanForm" property="createbyCodeaHidden" />
			<html:hidden name="paiGongDanForm" property="createdtHiddenCode" />
			<html:hidden name="paiGongDanForm" property="createdtHiddenCode2" />
		</html:form>
			<!--<html:form action="paigongdanUpload.do?act=upload" method="post" enctype="multipart/form-data" >
				<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
					<tr>
						<td>派工单日期：</td>
						<td>
							<html:text name="importPGDForm" property="dateString" size="12"styleId="dateString" />
							<img onclick="WdatePicker({el:'dateString'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 		
						</td>
						<td>派工单上传：</td>
						<td><input name="formFile" type="file" size="60"
							class="commonTextFieldHover" 
							onfocus="this.className='commonTextFieldMove'" 
							onblur="this.className='commonTextFieldHover'" />
						
						<html:submit property="btnUpload" value="上传" disabled="true" styleClass="commonButton"></html:submit>
						
						<a href="./paigongdan/paigongdan.xls">模板下载</a>
						</td>
						</tr>
					</table>
			</html:form>-->
	<script type="text/javascript">
		function exportNoBind() {
			//var classUUID = document.getElementById("classUUID").value;
			var createdtCode = document.getElementById("createdtCode").value;
			//	alert(createdtCode);
			var paigongriqi = document.getElementById("paigongriqis").value;
			if (trim(paigongriqi) == "" && trim(createdtCode) == "") {
				infoMessage("请输入派工日期或者创建日期");
				document.getElementById("paigongriqis").focus();
				return false;
			}
			window.open("pgdReport.do?act=export&paigongriqi=" + paigongriqi + "&createdtCode=" + encodeURI(encodeURI(createdtCode)));
		}

		function hiddenEditDiv() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getEmployeeName()%>';
			if (roleCode != 'admin' && roleCode != '828') {
				document.getElementById("buttonC").style.display="none";  
			}
		}
		function pipeifenguang() {
			var c = document.getElementsByName('UUIDS');
			var xiangmu = document.getElementsByName('xiangmu');
			var checkkbn = true;
			var anzhuangkbn = true;
			for(var i=0;i<c.length;i++){
				if(c[i].checked){
					checkkbn = false;
					if(xiangmu[i].value=='安装') {
						//commonSubmit('paigongdanEdit.do?act=pipeipgd');
					}else{
						anzhuangkbn = false;
						break;
					}
				}
			}
			if(anzhuangkbn) {
				commonSubmit('paigongdanEdit.do?act=pipeipgd');
			}else{
				infoMessage("只有安装项目才能进行匹配分光");
			}
			if(checkkbn) {
				infoMessage('请选择待匹配的记录');
			}
			return false;
		}
		function checkjti(name) {
			var c = document.getElementsByName(name);
			var zhuangtai = document.getElementsByName('importstatehidden');
			for(var i=0;i<c.length;i++){
				if(c[i].checked){
					if(zhuangtai[i].value=='已提交') {
						infoMessage('提交状态为【已提交】的派工单不能操作！');
						return false;
					}else{
						return true;
					}
				}
			}	
		}
		//hiddenEditDiv();	
	</script>
</body>
</html>
