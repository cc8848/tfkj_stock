<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
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
		<script src="userInfomation/userInfomation.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="userInfomactonList.do">
		<bean:define id="xiaoquList" name="userInfomacton" property="xiaoquList"></bean:define>
			<div id="content_all" >
				<!-- 标题 -->
				<div class="conten_top" name="top">
					客户资料管理
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								小区名称：
							</td>
							<td>
								<html:select name="userInfomacton" property="xiaoquname"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							</td>
							<td>
								用户
							</td>
							<td>
								<html:text name="userInfomacton" property="yonghu" size="12" />
							</td>
							<td>
								房号
							</td>
							<td>
								<html:text name="userInfomacton" property="dizhi" size="12" />
							</td>
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('userInfomactonList.do?act=query')" />
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
						<table border="0" cellspacing="0" cellpadding="1" width="198%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine">
									小区名称
								</td>
								<td class="tableTitleLine">
									姓名
								</td>
								<td class="tableTitleLine">
									证件号
								</td>
								<td class="tableTitleLine">
									收据号
								</td>
								<td class="tableTitleLine">
									分光器线号
								</td>
								<td class="tableTitleLine">
									onu注册位置
								</td>
								
								<td class="tableTitleLine">
									房号
								</td>
								<td class="tableTitleLine">
									开机时间
								</td>
								
								<td class="tableTitleLine">
									停机时间
								</td>
								<td class="tableTitleLine">
									宽带
								</td>
								<td class="tableTitleLine">
									电视
								</td>
								<td class="tableTitleLine">
									电话
								</td>
								<td class="tableTitleLine">
									用户名
								</td>
								<td class="tableTitleLine">
									密码
								</td>
								<td class="tableTitleLine">
									固定电话号码
								</td>
								<td class="tableTitleLine">
									联系电话
								</td>
								<td class="tableTitleLine">
									机柜位置
								</td>
								<td class="tableTitleLine">
									ONU信息（型号/MAC）
								</td>
								<td class="tableTitleLine">
									机顶盒MCID
								</td>
								<td class="tableTitleLine">
									电视IP
								</td>
								<td class="tableTitleLine">
									宽带IP
								</td>
								<td class="tableTitleLine">
									电话IP
								</td>
								<td class="tableTitleLine">
									电话vlan
								</td>
								<td class="tableTitleLine">
									网络vlan
								</td>
								<td class="tableTitleLine">
									电视vlan
								</td>
								<td class="tableTitleLine">
									其他运营商网络vlan
								</td>
								
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine">
										<input name="UUID" type="radio" value="${line.id}" onclick="setvalue('<bean:write name="line" field="stbmac" />')"/>
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="xiaoquname" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="yonghu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="zhenjianno" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="shoujuno" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="fenguang" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="onuzcwz" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="dizi" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="kaijishijian" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="tijishijian" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="daikuan" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="tv" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="tel" />
									</td><td class="tableContentLine">
										<bean:write name="line" field="username" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="passwords" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="guhuahaoma" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="usertel" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="jiguiweizhi" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="onumac" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="stbmac" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="tvip" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="netip" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="telip" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="telvaln" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="netvaln" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="tvvaln" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="qtvaln" />
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
				<div name="button" class="content_button">
					<html:button property="btnSave" value="修改" styleClass="commonButton" onclick="commonCheckSubmit('userinfoEdit.do?act=initEdit','UUID','请选择待编辑的客户')"/>
					<html:button property="btnSave" value="更换ONU" styleClass="commonButton2" onclick="commonCheckSubmit('changeEquipList.do?act=init&equtype=1','UUID','请选择待查看的客户')"/>
					<html:button property="btnSave" value="更换机顶盒" styleClass="commonButton2" onclick="changeJidinghe();"/>
					<html:button property="btnSave" value="查看详情" styleClass="commonButton2" onclick="commonCheckSubmit('userinfoEdit.do?act=showInfo','UUID','请选择待查看的客户')"/>
				</div>
			</div>
			<html:hidden name="userInfomacton" property="xiaoqunameHidden" />
			<html:hidden name="userInfomacton" property="dizhiHidden" />
			<html:hidden name="userInfomacton" property="yonghuHidden" />
			
		</html:form>
		</div>
		<div >
		<table>
		<tr>
		<td>
		<html:form action="userInfomactonUpload.do?act=upload" method="post" enctype="multipart/form-data" >
				<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
					<tr>
						<td>上传：</td>
						<td><input name="formFile" type="file" size="60"
							class="commonTextFieldHover" 
							onfocus="this.className='commonTextFieldMove'" 
							onblur="this.className='commonTextFieldHover'" />
						<html:submit property="btnUpload" value="上传" styleClass="commonButton"></html:submit>
						
						<a href="./userInfomation/moban.xls">模板下载</a>
						</td>
						</tr>
					</table>
			</html:form>
		</td>	
			</tr>
		</table>	
		</div>	
	</body>
	<script type="text/javascript">
	stbMac = null;
	setvalue = function(obj){
	//	alert(obj);
		stbMac = obj;
		}
	changeJidinghe = function(){
		if(stbMac==0){
			infoMessage("该条记录没有机顶盒设备记录！请重新选择");
			}
		else{
			commonCheckSubmit('changeEquipList.do?act=init&equtype=2','UUID','请选择待查看的客户')
			}
		}
	</script>
		
</html>
