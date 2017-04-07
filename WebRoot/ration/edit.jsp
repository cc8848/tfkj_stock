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
		<script src="ration/ration.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="rationEdit.do">
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					�豸��
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">
				
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<!-- <tr>
							<td>
								�ɹ����ţ�
							</td>
							<td>
								<bean:write name="rationSecondForm" property="pgdUUID"/>
							</td>
						</tr>
						 -->
						<tr>
							<td>
								�豸���
							</td>
							<td>
								<html:select name="rationSecondForm" property="type"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">--��ѡ��--</html:option>
									<html:option value="ONU">ONU</html:option>
									<html:option value="������">������</html:option>
								</html:select>
								<html:hidden name="rationSecondForm" property="pgdUUID"/>
							</td>
							<td>
								�豸���
							</td>
							<td>
								<html:text name="rationSecondForm" property="xianghao" size="12"></html:text>
							</td>
							<td>
								�豸�ͺ�
							</td>
							<td>
								<html:text name="rationSecondForm" property="xinghao" size="12"></html:text>
							</td>
							<td>
								MAC/MCID
							</td>
							<td>
								<html:text name="rationSecondForm" property="mac" size="12"></html:text>
							</td>
							<td>
								���ص�
							</td>
							<td>
								<html:select name="rationSecondForm" property="chukuplace"
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
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('rationEdit.do?act=query')" />
							</td>
						</tr>
					</table>
				</div>
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result">
					<!-- ��ҳͷ -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- ���һ�� start-->
					<div name="result_table" class="result_table" style="height:50%" >
						<table border="0" cellspacing="0" cellpadding="1"  width="98%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
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
										<input name="UUIDS" type="checkbox" value="${line.id}" />
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
			
					<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="�����豸" styleClass="commonButton2" onclick="removeData()"/>
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="commonSubmit('rationList.do?act=init')"/>
			</div>
			
			<html:hidden name="rationSecondForm" property="typeHidden" />
			<html:hidden name="rationSecondForm" property="stateHidden" />
			<html:hidden name="rationSecondForm" property="xinghaoHidden" />
			<html:hidden name="rationSecondForm" property="macHidden" />
			<html:hidden name="rationSecondForm" property="xianghaoHidden" />
			<html:hidden name="rationSecondForm" property="pgdUUIDHidden" />
			<html:hidden name="rationSecondForm" property="chukuplaceHidden" />
		</html:form>
	</body>
</html>
