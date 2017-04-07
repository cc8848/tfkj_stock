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
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="equipStockChuKuList.do">
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					库存确认
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								设备类型：
							</td>
							<td>
								<html:select name="equipStockChuKuForm" property="type"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">--请选择--</html:option>
									<html:option value="ONU">ONU</html:option>
									<html:option value="机顶盒">机顶盒</html:option>
								</html:select>
							</td>
							<td>
								设备型号：
							</td>
							<td>
								<html:text name="equipStockChuKuForm" property="xinghao" size="12" />
							</td>
							<td>
								设备箱号：
							</td>
							<td>
								<html:text name="equipStockChuKuForm" property="mac" size="12" />
							</td>
							<td>
								设备状态：
							</td>
							<td>
								<html:select name="equipStockChuKuForm" property="state"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">--请选择--</html:option>
									<html:option value="2">出库未确认</html:option>
									<html:option value="5">已解绑</html:option>
								</html:select>
							</td>
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('equipStockChuKuList.do?act=query')" />
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
									<input  type="checkbox" id="selectAll" onclick="checkAll(this,'checkBox');"/>
								</td>
								<td class="tableTitleLine">
									设备类别
								</td>
								<td class="tableTitleLine">
									设备箱号
								</td>
								<td class="tableTitleLine">
									设备型号
								</td>
								<td class="tableTitleLine">
									MAC/MCID
								</td>
								
								<td class="tableTitleLine" weight="20%">
									设备状态
								</td>
								
								<td class="tableTitleLine">
									入库时间
								</td>
								<td class="tableTitleLine">
									入库人
								</td>
								
								<td class="tableTitleLine">
									出库日期
								</td>
								<td class="tableTitleLine">
									库存地点
								</td>
								<td class="tableTitleLine">
									领取人
								</td>
								<td class="tableTitleLine">
									安装地点
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
										<!-- <input name="UUID" type="radio" value="${line.id}" /> -->
										<input name="UUIDS" type="checkbox" id="checkBox"  value="<bean:write name="line" field="PK_ID" />"/>
									</td>
									<!-- <td class="tableContentLine">
										<bean:write name="line" field="PK_ID" />
									</td> -->
									<td class="tableContentLine">
										<bean:write name="line" field="TYPE" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="xianghao" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="xinghao" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="mac" />
									</td>
									
									
									<td class="tableContentLine">
										<bean:write name="line" field="statename" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="rukudate" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="rukuperson" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="chukudate" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="chukuplace" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="lingquren" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="anzhuangplace" />
									</td>
									<td class="tableContentLine">
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
					<html:button property="btnSave" value="出库确认" styleClass="commonButton2" onclick="commonCheckSubmit('equipStockChuKu.do?act=chuku','UUIDS','请选择待确认出库的设备')"/>
					<html:button property="btnSave" value="重入库" styleClass="commonButton2" onclick="commonCheckSubmit('equipStockChuKu.do?act=ruku','UUIDS','请选择待重入库的设备')"/>
					<html:button property="btnSave" value="已损坏" styleClass="commonButton2" onclick="commonCheckSubmit('equipStockChuKu.do?act=sunhuai','UUIDS','请选择待确认损坏的设备')"/>
				</div>
			</div>
			<html:hidden name="equipStockChuKuForm" property="typeHidden" />
			<html:hidden name="equipStockChuKuForm" property="stateHidden" />
			<html:hidden name="equipStockChuKuForm" property="xinghaoHidden" />
			<html:hidden name="equipStockChuKuForm" property="macHidden" />
		</html:form>
	</body>
	
	<script type="text/javascript">
	//全选
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
