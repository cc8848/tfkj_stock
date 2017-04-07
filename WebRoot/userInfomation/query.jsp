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
		<script src="userInfomation/userInfomation.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="userInfomactonList.do">
		<bean:define id="xiaoquList" name="userInfomacton" property="xiaoquList"></bean:define>
			<div id="content_all" >
				<!-- ���� -->
				<div class="conten_top" name="top">
					�ͻ����Ϲ���
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								С�����ƣ�
							</td>
							<td>
								<html:select name="userInfomacton" property="xiaoquname"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--��ѡ��--</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							</td>
							<td>
								�û�
							</td>
							<td>
								<html:text name="userInfomacton" property="yonghu" size="12" />
							</td>
							<td>
								����
							</td>
							<td>
								<html:text name="userInfomacton" property="dizhi" size="12" />
							</td>
							<td align="right">
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('userInfomactonList.do?act=query')" />
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
						<table border="0" cellspacing="0" cellpadding="1" width="198%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine">
									С������
								</td>
								<td class="tableTitleLine">
									����
								</td>
								<td class="tableTitleLine">
									֤����
								</td>
								<td class="tableTitleLine">
									�վݺ�
								</td>
								<td class="tableTitleLine">
									�ֹ����ߺ�
								</td>
								<td class="tableTitleLine">
									onuע��λ��
								</td>
								
								<td class="tableTitleLine">
									����
								</td>
								<td class="tableTitleLine">
									����ʱ��
								</td>
								
								<td class="tableTitleLine">
									ͣ��ʱ��
								</td>
								<td class="tableTitleLine">
									���
								</td>
								<td class="tableTitleLine">
									����
								</td>
								<td class="tableTitleLine">
									�绰
								</td>
								<td class="tableTitleLine">
									�û���
								</td>
								<td class="tableTitleLine">
									����
								</td>
								<td class="tableTitleLine">
									�̶��绰����
								</td>
								<td class="tableTitleLine">
									��ϵ�绰
								</td>
								<td class="tableTitleLine">
									����λ��
								</td>
								<td class="tableTitleLine">
									ONU��Ϣ���ͺ�/MAC��
								</td>
								<td class="tableTitleLine">
									������MCID
								</td>
								<td class="tableTitleLine">
									����IP
								</td>
								<td class="tableTitleLine">
									���IP
								</td>
								<td class="tableTitleLine">
									�绰IP
								</td>
								<td class="tableTitleLine">
									�绰vlan
								</td>
								<td class="tableTitleLine">
									����vlan
								</td>
								<td class="tableTitleLine">
									����vlan
								</td>
								<td class="tableTitleLine">
									������Ӫ������vlan
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
					<html:button property="btnSave" value="�޸�" styleClass="commonButton" onclick="commonCheckSubmit('userinfoEdit.do?act=initEdit','UUID','��ѡ����༭�Ŀͻ�')"/>
					<html:button property="btnSave" value="����ONU" styleClass="commonButton2" onclick="commonCheckSubmit('changeEquipList.do?act=init&equtype=1','UUID','��ѡ����鿴�Ŀͻ�')"/>
					<html:button property="btnSave" value="����������" styleClass="commonButton2" onclick="changeJidinghe();"/>
					<html:button property="btnSave" value="�鿴����" styleClass="commonButton2" onclick="commonCheckSubmit('userinfoEdit.do?act=showInfo','UUID','��ѡ����鿴�Ŀͻ�')"/>
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
						<td>�ϴ���</td>
						<td><input name="formFile" type="file" size="60"
							class="commonTextFieldHover" 
							onfocus="this.className='commonTextFieldMove'" 
							onblur="this.className='commonTextFieldHover'" />
						<html:submit property="btnUpload" value="�ϴ�" styleClass="commonButton"></html:submit>
						
						<a href="./userInfomation/moban.xls">ģ������</a>
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
			infoMessage("������¼û�л������豸��¼��������ѡ��");
			}
		else{
			commonCheckSubmit('changeEquipList.do?act=init&equtype=2','UUID','��ѡ����鿴�Ŀͻ�')
			}
		}
	</script>
		
</html>
