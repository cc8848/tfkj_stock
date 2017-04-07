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
		<script src="yuyue/yuyue.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="yuyueList.do">
		<bean:define id="xiaoquList" name="yuyueForm" property="xiaoquList"></bean:define>
		<bean:define id="quyuList" name="yuyueForm" property="quyuList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					ԤԼ�Ǽ�
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								ԤԼ���ڣ�
							</td>
							<td>
								<html:text name="yuyueForm" property="starriqicode" styleId="starriqicode" size="12" onclick="WdatePicker({el:'starriqicode'})" />
								<img onclick="WdatePicker({el:'starriqicode'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
								��
								<html:text name="yuyueForm" property="endriqicode" styleId="endriqicode" size="12" onclick="WdatePicker({el:'endriqicode'})" />
								<img onclick="WdatePicker({el:'endriqicode'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 		
							</td>
							<td>
								�������ƣ�
							</td>
							<td>
								<html:select name="yuyueForm" property="xiaoqucode"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--��ѡ��--</html:option>
								<html:options collection="quyuList" property="key" labelProperty="value" />
							</html:select>
							</td>
							<td align="right">
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('yuyueList.do?act=query')" />
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
									&nbsp;
								</td>
								<td class="tableTitleLine">
									ԤԼ����
								</td>
								<td class="tableTitleLine">
									С������
								</td>
								<td class="tableTitleLine">
									ʱ��
								</td>
								<td class="tableTitleLine">
									��װ�ƻ�����
								</td>
								<td class="tableTitleLine" weight="20%">
									��װʣ�໧��
								</td>
								<td class="tableTitleLine">
									ȡ���ƻ�����
								</td>
								<td class="tableTitleLine">
									ȡ��ʣ�໧��
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
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<!-- <td class="tableContentLine">
										<bean:write name="line" field="PK_ID" />
									</td> -->
									<td class="tableContentLine">
										<bean:write name="line" field="riqi" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="xiaoqu" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="shijian" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="azjh" />
									</td>
									<td class="tableContentLine">
									<div class="azshengyu">
										<bean:write name="line" field="azsy" />
									</div>	
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="qjjh" />
									</td>
									<td class="tableContentLine">
									<div class="qjshengyu">
										<bean:write name="line" field="qjsy" />
									</div>	
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="yujing" />
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
					<html:button property="btnSave" value="���" styleClass="commonButton" onclick="commonSubmit('yuyueEdit.do?act=initInsert')"/>
					 <html:button property="btnSave" value="�༭" styleClass="commonButton" onclick="commonCheckSubmit('yuyueEdit.do?act=initEdit','UUID','��ѡ����༭��ԤԼ��')"/>
					<html:button property="btnSave" value="ɾ��" styleClass="commonButton" onclick="removeData()"/>
					<html:button property="btnSave" value="����ƻ�" styleClass="commonButton2" onclick="removeData2()"/>
				</div>
			</div>
			<html:hidden name="yuyueForm" property="riqicodeHidden" />
			<html:hidden name="yuyueForm" property="xiaoqucodeHidden" />
			<html:hidden name="yuyueForm" property="starriqicodeHidden" />
			<html:hidden name="yuyueForm" property="endriqicodeHidden" />
		</html:form>
		</div>
	</body>
<script>
$("div.azshengyu").each(function(){
	if($(this).text().indexOf("0")==0)
		$(this).css("color","red");
		
});
$("div.qjshengyu").each(function(){
	if($(this).text().indexOf("0")==0)
		$(this).css("color","red");
		
});
</script>
</html>
