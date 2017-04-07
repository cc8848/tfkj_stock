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
		<script src="equipStock/equipStock.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="equipStockList.do">
			<div id="content_all" >
				<!-- 标题 -->
				<div class="conten_top" name="top">
					库存管理
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								设备类型：
							</td>
							<td>
								<html:select name="equipStockForm" property="type"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">--请选择--</html:option>
									<html:option value="ONU">ONU</html:option>
									<html:option value="机顶盒">机顶盒</html:option>
								</html:select>
							</td>
							<td>
								设备状态：
							</td>
							<td>
								<html:select name="equipStockForm" property="state" 
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="1" >已入库</html:option>
									<html:option value="2">出库未确认</html:option>
									<html:option value="3">出库已确认</html:option>
									<html:option value="5">已解绑</html:option>
									<html:option value="4">已损坏</html:option>
								</html:select>
							</td>
							<td>
								设备型号：
							</td>
							<td>
								<html:text name="equipStockForm" property="xinghao" size="12" />
							</td>
							<td>
								设备箱号：
							</td>
							<td>
								<html:text name="equipStockForm" property="xianghao" size="12" />
							</td>
							<td>
								设备mac/mcid：
							</td>
							<td>
								<html:text name="equipStockForm" property="mac" size="12" />
							</td>
							<td>库存地：
							</td>
							<td>
							<html:select name="equipStockForm" property="chukuplaceStrings"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:option value="环渤海">环渤海</html:option>
								<html:option value="东丽一库">东丽一库</html:option>
								<html:option value="西青二库">西青二库</html:option>
								<html:option value="河西一库">河西一库</html:option> 
								<html:option value="海景雅苑">海景雅苑</html:option> 
								<html:option value="海景公寓">海景公寓</html:option> 
								<html:option value="新尚园">新尚园</html:option> 
								<html:option value="美域豪庭">美域豪庭</html:option> 
								<html:option value="美域兰庭">美域兰庭</html:option> 
								<html:option value="美域华庭">美域华庭</html:option> 
								<html:option value="昆俞家园">昆俞家园</html:option>
								<html:option value="昆俞欣园">昆俞欣园</html:option> 
								<html:option value="天欣花园">天欣花园</html:option>
								<html:option value="翠海红山">翠海红山</html:option> 
								<html:option value="泰安道五大院">泰安道五大院</html:option>  
							</html:select>
							</td>
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('equipStockList.do?act=query')" />
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
								<td class="tableTitleLine">
									操作
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine">
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
									<td class="tableContentLine" nowrap="nowrap" width="120px">
										<a href="equipStockEdit.do?act=initEdit&EQUUID=<bean:write name="line" field="PK_ID" />&STATE=<bean:write name="line" field="state" />">修改</a>
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
				<table>
					<tr>
					<td><html:button property="btnSave" value="添加" styleClass="commonButton" onclick="commonSubmit('equipStockEdit.do?act=initInsert')"/>
					 </td>
						<td><html:button property="btnSave" value="删除" styleClass="commonButton" onclick="removeData()"/>
						</td>
					<td>
					<select id="chukuplaceString" name="chukuplaceString"> 
							 	<option value="环渤海">环渤海</option>
								<option value="东丽一库">东丽一库</option>
								<option value="西青二库">西青二库</option>
								<option value="河西一库">河西一库</option> 
								
								<option value="海景雅苑">海景雅苑</option> 
								<option value="海景公寓">海景公寓</option> 
								<option value="新尚园">新尚园</option> 
								<option value="美域豪庭">美域豪庭</option> 
								<option value="美域兰庭">美域兰庭</option> 
								<option value="美域华庭">美域华庭</option> 
								<option value="昆俞家园">昆俞家园</option>
								<option value="昆俞欣园">昆俞欣园</option> 
								<option value="天欣花园">天欣花园</option>
								 <option value="翠海红山">翠海红山</option> 
								<option value="泰安道五大院">泰安道五大院</option>  
						</select>		
						</td>
						<td><html:button property="btnSave" value="移库" styleClass="commonButton" onclick="commonCheckSubmit('equipStockEdit.do?act=yiku','UUIDS','请选择待移库的设备')"/>
						</td>
				</tr>
				</table>
				</div>
			</div>
			<html:hidden name="equipStockForm" property="typeHidden" />
			<html:hidden name="equipStockForm" property="stateHidden" />
			<html:hidden name="equipStockForm" property="xinghaoHidden" />
			<html:hidden name="equipStockForm" property="macHidden" />
			<html:hidden name="equipStockForm" property="chukuplaceStringsHidden" />
			
		</html:form>
		</div>
		<div >
		<table>
		<tr>
		<td>
		<html:form action="equUpload.do?act=upload" method="post" enctype="multipart/form-data" >
				<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
					<tr>
						<td>设备上传：</td>
						<td><input name="formFile" type="file" size="60"
							class="commonTextFieldHover" 
							onfocus="this.className='commonTextFieldMove'" 
							onblur="this.className='commonTextFieldHover'" />
						<html:submit property="btnUpload" value="上传" styleClass="commonButton"></html:submit>
						
						<a href="./equipStock/shebeidaoru.xls">模板下载</a>
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
		function yiku(){
		var UUIDSS = document.getElementById("UUIDSS").value;
		
		commonSubmit('equipStockEdit.do?act=yiku&UUIDS='+UUIDSS);
		}

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
