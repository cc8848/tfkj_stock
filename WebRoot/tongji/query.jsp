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
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init();hiddenEditDiv2();">
		<html:form action="tongjiList.do">
		<bean:define id="xiaoquList" name="tongjiForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					出工单管理
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								小区名称：
							</td>
							<td>
								<!--<html:text name="tongjiForm" property="xiaoqu" size="12" styleId="xiaoqu"/>-->
								<html:select name="tongjiForm" property="xiaoqu"styleId="xiaoqu"
								styleClass="commonTextFieldHover"  onkeydown="autoSubimit()"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
								
							</td>
							<td>
								日期：
							</td>
							<td>
								<html:text name="tongjiForm" onclick="new Calendar().show(this)"  property="paigongriqi" size="12" styleId="paigongriqi"/>
							</td>
							
							<td>
								联系电话：
							</td>
							<td>
								<html:text name="tongjiForm" property="userTel"  size="12"  onkeydown="autoSubimit()"/>
							</td>
							<td>
								地址：
							</td>
							<td>
								<html:text name="tongjiForm" property="dizhi"  size="12"  onkeydown="autoSubimit()"/>
							</td>
							<td>
								派工单状态：
							</td>
							<td>
							<html:select name="tongjiForm" property="state"
								styleClass="commonTextFieldHover"  onkeydown="autoSubimit()"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:option value="1">已预约</html:option>
								<html:option value="5">数据完工</html:option>
								<html:option value="6">施工中</html:option>
								<html:option value="7">工毕</html:option>
							</html:select>
							</td>
							<td>
								提交状态：
							</td>
							<td>
							<html:select name="tongjiForm" property="importstate"
								styleClass="commonTextFieldHover"  onkeydown="autoSubimit()"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:option value="0">未提交</html:option>
								<html:option value="1">已提交</html:option>
							</html:select>
							</td>
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('tongjiList.do?act=query')" />
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
						<table border="0" cellspacing="0" cellpadding="1"  width="130%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine" nowrap="nowrap">
									<input  type="checkbox" id="selectAll" onclick="checkAll(this,'checkBox');"/>
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									状态
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									提交状态
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									操作
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									项目
								</td>
								<td class="tableTitleLine"nowrap="nowrap" >
									日期
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									时间
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									小区名称
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									用户地址
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									用户姓名
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									身份证号
								</td>
								<td class="tableTitleLine" weight="20%"nowrap="nowrap">
									联系电话
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									宽带
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电视
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电话
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									业务
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									分光
								</td>
								<!-- <td class="tableTitleLine">
									用户要求
								</td> -->
								<td class="tableTitleLine"nowrap="nowrap">
									ONUMAC
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									STBMCID
								</td>
								
								<td class="tableTitleLine"nowrap="nowrap">
									电视ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									网络ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电话ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电话valn
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									网络valn
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
										<input name="UUIDS" type="checkbox" id="checkBox" value="${line.id}" />
									</td>
									<!-- <td class="tableContentLine">
										<bean:write name="line" field="PK_ID" />
									</td> -->
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="stateName" /><input type="hidden" name="statehidden" value="<bean:write name="line" field="stateName" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="importstate" /><input type="hidden" name="importstatehidden" value="<bean:write name="line" field="importstate" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<a href="paigongdanEdit.do?act=showInfo1&UUID=<bean:write name="line" field="PK_ID" />">查看详情</a>
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xiangmu" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="paigongriqi" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="anzhuangshijian" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xiaoquname" /><input type="hidden" name="xiaoquname" value="<bean:write name="line" field="xiaoquname" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="userplace" /><input type="hidden" name="userplace" value="<bean:write name="line" field="userplace" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="username" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="shenfenzheng" />
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
										<bean:write name="line" field="dianhua" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="qtye" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="fenguangD" />
									</td>
									<!--  <td class="tableContentLine">
										<bean:write name="line" field="useryaoqiu" />
									</td>-->
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="onumacD" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="stbmcidD" />
									</td>
									
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="dianshiipD" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="netip" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="telip" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="telvaln" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="netvaln" />
									</td>
									
									<td class="tableContentLine" width="30%" nowrap="nowrap">
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
				<div name="button" class="content_button">
				<html:button property="btnSave" styleId="shujuwangong" value="数据完工" styleClass="commonButton2" onclick="commonCheckSubmit('tongjiEdit.do?act=operate&type=1','UUIDS','请选择待操作的派工单')"/>
				<html:button property="btnSave" value="当日工单" styleClass="commonButton2" onclick="commonSubmit('paigongdanEdit.do?act=dangriGD')"/>	
				&nbsp;&nbsp;&nbsp;&nbsp;
				<html:button property="btnSave" styleId="huidanpre" value="回单预导入" style="color:black;background-color:green;height: 21px;" onclick="commonCheckSubmit('tongjiEdit.do?act=huidanImport','UUIDS','请选择待操作的派工单')"/>
				<html:button property="btnSave" styleId="joufupre" value="重复预导入"   style="color:black;background-color:yellow;height: 21px;" onclick="commonCheckSubmit('tongjiEdit.do?act=huidanImportTwice','UUIDS','请选择待操作的派工单')"/>
				</div>
			</div>
			<html:hidden name="tongjiForm" property="xiaoquHidden" />
			<html:hidden name="tongjiForm" property="userTelHidden" />
			<html:hidden name="tongjiForm" property="stateHidden" />
			<html:hidden name="tongjiForm" property="paigongriqiHidden" />
			<html:hidden name="tongjiForm" property="dizhiHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	//导出excle
		function exportNoBind(){
		//var classUUID = document.getElementById("classUUID").value;
		var xiaoqu = document.getElementById("xiaoqu").value;
		var paigongriqi = document.getElementById("paigongriqi").value;
			//if(xiaoqu==null||trim(xiaoqu)==""){
			//	infoMessage("请输入小区名称");
			//	document.getElementById("xiaoqu").focus();
			//	return false;
			//	}
			if(xiaoqu==null||trim(paigongriqi)==""){
				infoMessage("请输入派工日期");
				document.getElementById("paigongriqi").focus();
				return false;
				}
			window.open("tongjiReport.do?act=export&paigongriqi="+ paigongriqi + "&xiaoqu=" + encodeURI(encodeURI(xiaoqu)));
	}
	function  hiddenEditDiv2() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			if(roleCode!='5'&&roleCode!='8') {
				document.getElementById("huidanpre").style.display="none";
				document.getElementById("joufupre").style.display="none";
				document.getElementById("shujuwangong").style.display="none";
			}
		}
		function autoSubimit() {
			if (event.keyCode == 13) {
				commonSubmit('tongjiList.do?act=query');
			}
		}
		checkAll=function(thisObj,checkId) {
            if(thisObj==undefined||thisObj==null)return false;
            var frm = document.forms[0];
    
            var inputs = eval("frm."+checkId);
            if(inputs==undefined)return false;
            var isSelected=false;
            if(thisObj.checked){
                    isSelected = true;
            }else{
                    isSelected = false;
            }
            if(inputs.length==undefined){
                    inputs.checked=isSelected;
            }else{
                    for(i=0;i<inputs.length;i++){
                            if(inputs[i].type=="checkbox"){
                                    inputs[i].checked=isSelected;
                            }
                    }                
            }

    }
	</script>
</html>
