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
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="equipStockChuKuList.do">
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					���ȷ��
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								�豸���ͣ�
							</td>
							<td>
								<html:select name="equipStockChuKuForm" property="type"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">--��ѡ��--</html:option>
									<html:option value="ONU">ONU</html:option>
									<html:option value="������">������</html:option>
								</html:select>
							</td>
							<td>
								�豸�ͺţ�
							</td>
							<td>
								<html:text name="equipStockChuKuForm" property="xinghao" size="12" />
							</td>
							<td>
								�豸��ţ�
							</td>
							<td>
								<html:text name="equipStockChuKuForm" property="mac" size="12" />
							</td>
							<td>
								�豸״̬��
							</td>
							<td>
								<html:select name="equipStockChuKuForm" property="state"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">--��ѡ��--</html:option>
									<html:option value="2">����δȷ��</html:option>
									<html:option value="5">�ѽ��</html:option>
								</html:select>
							</td>
							<td align="right">
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('equipStockChuKuList.do?act=query')" />
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
					<html:button property="btnSave" value="����ȷ��" styleClass="commonButton2" onclick="commonCheckSubmit('equipStockChuKu.do?act=chuku','UUIDS','��ѡ���ȷ�ϳ�����豸')"/>
					<html:button property="btnSave" value="�����" styleClass="commonButton2" onclick="commonCheckSubmit('equipStockChuKu.do?act=ruku','UUIDS','��ѡ����������豸')"/>
					<html:button property="btnSave" value="����" styleClass="commonButton2" onclick="commonCheckSubmit('equipStockChuKu.do?act=sunhuai','UUIDS','��ѡ���ȷ���𻵵��豸')"/>
				</div>
			</div>
			<html:hidden name="equipStockChuKuForm" property="typeHidden" />
			<html:hidden name="equipStockChuKuForm" property="stateHidden" />
			<html:hidden name="equipStockChuKuForm" property="xinghaoHidden" />
			<html:hidden name="equipStockChuKuForm" property="macHidden" />
		</html:form>
	</body>
	
	<script type="text/javascript">
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
