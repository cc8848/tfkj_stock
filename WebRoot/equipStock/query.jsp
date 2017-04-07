<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>���ٿ��������ʾ��Ŀ</title>
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
				<!-- ���� -->
				<div class="conten_top" name="top">
					������
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								�豸���ͣ�
							</td>
							<td>
								<html:select name="equipStockForm" property="type"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">--��ѡ��--</html:option>
									<html:option value="ONU">ONU</html:option>
									<html:option value="������">������</html:option>
								</html:select>
							</td>
							<td>
								�豸״̬��
							</td>
							<td>
								<html:select name="equipStockForm" property="state" 
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="1" >�����</html:option>
									<html:option value="2">����δȷ��</html:option>
									<html:option value="3">������ȷ��</html:option>
									<html:option value="5">�ѽ��</html:option>
									<html:option value="4">����</html:option>
								</html:select>
							</td>
							<td>
								�豸�ͺţ�
							</td>
							<td>
								<html:text name="equipStockForm" property="xinghao" size="12" />
							</td>
							<td>
								�豸��ţ�
							</td>
							<td>
								<html:text name="equipStockForm" property="xianghao" size="12" />
							</td>
							<td>
								�豸mac/mcid��
							</td>
							<td>
								<html:text name="equipStockForm" property="mac" size="12" />
							</td>
							<td>���أ�
							</td>
							<td>
							<html:select name="equipStockForm" property="chukuplaceStrings"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--��ѡ��--</html:option>
								<html:option value="������">������</html:option>
								<html:option value="����һ��">����һ��</html:option>
								<html:option value="�������">�������</html:option>
								<html:option value="����һ��">����һ��</html:option> 
								<html:option value="������Է">������Է</html:option> 
								<html:option value="������Ԣ">������Ԣ</html:option> 
								<html:option value="����԰">����԰</html:option> 
								<html:option value="�����ͥ">�����ͥ</html:option> 
								<html:option value="������ͥ">������ͥ</html:option> 
								<html:option value="����ͥ">����ͥ</html:option> 
								<html:option value="�����԰">�����԰</html:option>
								<html:option value="������԰">������԰</html:option> 
								<html:option value="������԰">������԰</html:option>
								<html:option value="�亣��ɽ">�亣��ɽ</html:option> 
								<html:option value="̩�������Ժ">̩�������Ժ</html:option>  
							</html:select>
							</td>
							<td align="right">
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('equipStockList.do?act=query')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result">
					<!-- ��ҳͷ -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- ���һ�� start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="98%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									<input  type="checkbox" id="selectAll" onclick="checkAll(this,'checkBox');"/>
								</td>
								<td class="tableTitleLine">
									�豸���
								</td>
								<td class="tableTitleLine">
									�豸���
								</td>
								<td class="tableTitleLine">
									�豸�ͺ�
								</td>
								<td class="tableTitleLine">
									MAC/MCID
								</td>
								
								
								<td class="tableTitleLine" weight="20%">
									�豸״̬
								</td>
								
								<td class="tableTitleLine">
									���ʱ��
								</td>
								<td class="tableTitleLine">
									�����
								</td>
								
								<td class="tableTitleLine">
									��������
								</td>
								<td class="tableTitleLine">
									���ص�
								</td>
								<td class="tableTitleLine">
									��ȡ��
								</td>
								<td class="tableTitleLine">
									��װ�ص�
								</td>
								<td class="tableTitleLine">
									��ע
								</td>
								<td class="tableTitleLine">
									����
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
										<a href="equipStockEdit.do?act=initEdit&EQUUID=<bean:write name="line" field="PK_ID" />&STATE=<bean:write name="line" field="state" />">�޸�</a>
									</td>
								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- ���һ�� end-->
					<div name="page_down" class="page_down">
						<div align="right">
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- ��ѯ��� end -->
				<!-- button -->
				<div name="button" class="content_button">
				<table>
					<tr>
					<td><html:button property="btnSave" value="���" styleClass="commonButton" onclick="commonSubmit('equipStockEdit.do?act=initInsert')"/>
					 </td>
						<td><html:button property="btnSave" value="ɾ��" styleClass="commonButton" onclick="removeData()"/>
						</td>
					<td>
					<select id="chukuplaceString" name="chukuplaceString"> 
							 	<option value="������">������</option>
								<option value="����һ��">����һ��</option>
								<option value="�������">�������</option>
								<option value="����һ��">����һ��</option> 
								
								<option value="������Է">������Է</option> 
								<option value="������Ԣ">������Ԣ</option> 
								<option value="����԰">����԰</option> 
								<option value="�����ͥ">�����ͥ</option> 
								<option value="������ͥ">������ͥ</option> 
								<option value="����ͥ">����ͥ</option> 
								<option value="�����԰">�����԰</option>
								<option value="������԰">������԰</option> 
								<option value="������԰">������԰</option>
								 <option value="�亣��ɽ">�亣��ɽ</option> 
								<option value="̩�������Ժ">̩�������Ժ</option>  
						</select>		
						</td>
						<td><html:button property="btnSave" value="�ƿ�" styleClass="commonButton" onclick="commonCheckSubmit('equipStockEdit.do?act=yiku','UUIDS','��ѡ����ƿ���豸')"/>
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
						<td>�豸�ϴ���</td>
						<td><input name="formFile" type="file" size="60"
							class="commonTextFieldHover" 
							onfocus="this.className='commonTextFieldMove'" 
							onblur="this.className='commonTextFieldHover'" />
						<html:submit property="btnUpload" value="�ϴ�" styleClass="commonButton"></html:submit>
						
						<a href="./equipStock/shebeidaoru.xls">ģ������</a>
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

		//ȫѡ
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
