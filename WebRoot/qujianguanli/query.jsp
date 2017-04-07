<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
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
		<html:form action="qujianList.do">
		<bean:define id="xiaoquList" name="tongjiForms" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					�ռ�����
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								С�����ƣ�
							</td>
							<td>
								<!--<html:text name="tongjiForms" property="xiaoqu" size="12" styleId="xiaoqu"/>-->
								<html:select name="tongjiForms" property="xiaoqu"styleId="xiaoqu"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--��ѡ��--</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
								
							</td>
							<td>
								���ڣ�
							</td>
							<td>
								<html:text name="tongjiForms" onclick="WdatePicker({el:'paigongriqi'})" property="paigongriqi" size="12" styleId="paigongriqi"/>
								<img onclick="WdatePicker({el:'paigongriqi'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 		
							</td>
							
							<td>
								��ϵ�绰��
							</td>
							<td>
								<html:text name="tongjiForms" property="userTel"  size="12" />
							</td>
							<td>
								�ɹ���״̬��
							</td>
							<td>
							<html:select name="tongjiForms" property="state"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--��ѡ��--</html:option>
								<html:option value="1">��ԤԼ</html:option>
								<html:option value="9">ȡ����</html:option>
								<html:option value="10">��ȡ��</html:option>
								<html:option value="11">�������ϴ�</html:option>
								<html:option value="12">���յ����µ�</html:option>
							</html:select>
							</td>
							<td align="right">
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('qujianList.do?act=query')" />
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
						<table border="0" cellspacing="0" cellpadding="1"  width="130%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td> 
								<td class="tableTitleLine"nowrap="nowrap">
									״̬
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									��Ŀ
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									ʱ��
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									С������
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�û���ַ
								</td>
								<td class="tableTitleLine" weight="20%"nowrap="nowrap">
									��ϵ�绰
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									���
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									����
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�绰
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									ҵ��
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�ֹ�
								</td>
								<!-- <td class="tableTitleLine">
									�û�Ҫ��
								</td> -->
								<td class="tableTitleLine"nowrap="nowrap">
									ONUMAC
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									STBMCID
								</td>
								
								<td class="tableTitleLine"nowrap="nowrap">
									����ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									����ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�绰ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�绰valn
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									����valn
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
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="stateName" />
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
										<bean:write name="line" field="xiaoquname" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="userplace" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="usertel" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tfkuandaidaikuan" />
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
										<bean:write name="line" field="fenguang" />
									</td>
									<!--  <td class="tableContentLine">
										<bean:write name="line" field="useryaoqiu" />
									</td>-->
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="OUMMAC" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="STBMAC" />
									</td>
									
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tvip" />
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
									
									<td class="tableContentLine" width="30%">
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
				<input type="button" class="commonButton2" value="��������" onclick="exportNoBind();"/>
				<!--<html:button property="btnSave" value="�ᵥ" styleClass="commonButton" onclick="commonCheckSubmit('tongjiEdit.do?act=initEdit','UUID','��ѡ����༭�ĳ�����')"/>
				-->
				<html:button property="btnSave" value="ȡ����"  styleClass="commonButton2" onclick="commonCheckSubmit('qujianEdit.do?act=operate&type=1','UUIDS','��ѡ����༭���ɹ���')"/>
				<html:button property="btnSave" value="��ȡ��" styleClass="commonButton" onclick="commonCheckSubmit('qujianEdit.do?act=operate&type=2','UUIDS','��ѡ����༭���ɹ���')"/>
				<html:button property="btnSave" value="�������ϴ�" styleClass="commonButton2" onclick="commonCheckSubmit('qujianEdit.do?act=operate&type=3','UUIDS','��ѡ����༭���ɹ���')"/>
				<html:button property="btnSave" value="���յ����µ�" styleClass="commonButton2" onclick="commonCheckSubmit('qujianEdit.do?act=operate&type=4','UUIDS','��ѡ����༭�ĳ�����')"/>
				<html:button property="btnSave" value="�ϴ��ͷ�������" styleClass="commonButton2" onclick="commonCheckSubmit('qujianEdit.do?act=operate&type=5','UUIDS','��ѡ����༭�ĳ�����')"/>
				<html:button property="btnSave" value="�˵�" styleClass="commonButton" onclick="commonCheckSubmit('qujianEdit.do?act=tuidan','UUIDS','��ѡ����༭�ĳ�����')"/>
					<!-- 	<html:button property="btnSave" value="���" styleClass="commonButton" onclick="commonSubmit('paigongdanEdit.do?act=initInsert')"/>
						 <html:button property="btnSave" value="�༭" styleClass="commonButton" onclick="commonCheckSubmit('paigongdanEdit.do?act=initEdit','UUID','��ѡ����༭���ɹ���')"/>
						<html:button property="btnSave" value="ɾ��" styleClass="commonButton" onclick="removeData()"/>
				--></div>
			</div>
			<html:hidden name="tongjiForms" property="xiaoquHidden" />
			<html:hidden name="tongjiForms" property="userTelHidden" />
			<html:hidden name="tongjiForms" property="stateHidden" />
			<html:hidden name="tongjiForms" property="paigongriqiHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	//����excle
		function exportNoBind(){
		//var classUUID = document.getElementById("classUUID").value;
		var xiaoqu = document.getElementById("xiaoqu").value;
		var paigongriqi = document.getElementById("paigongriqi").value;
			//if(xiaoqu==null||trim(xiaoqu)==""){
			//	infoMessage("������С������");
			//	document.getElementById("xiaoqu").focus();
			//	return false;
			//	}
			if(xiaoqu==null||trim(paigongriqi)==""){
				infoMessage("�������ɹ�����");
				document.getElementById("paigongriqi").focus();
				return false;
				}
			window.open("qujianReport.do?act=export&paigongriqi="+ paigongriqi + "&xiaoqu=" + encodeURI(encodeURI(xiaoqu)));
	}
	</script>
</html>
