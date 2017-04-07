<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2015-12-15   Dai-Zhen           Create
   
  -->
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
	<div style="height:440px;">
		<html:form action="selectTelNumberList.do">
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					�ܿⷿ��Ϣ
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query"  style="display:none;">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0" style="display:none;">
						
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
									�ܿⷿID
								</td>
								<td class="tableTitleLine">
									�豸����
								</td>
								<td class="tableTitleLine">
									�豸�ͺ�
								</td>
								<td class="tableTitleLine">
									�������
								</td>
								<td class="tableTitleLine">
									��ע��Ϣ
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine">
										<input name="UUID" type="radio" value="<bean:write name="line" field="UUID" />"/>
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="UUID" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="EqType" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="EqVersion" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="kucunSuu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="Remark" />
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
				 <html:button property="btnSave" value="������Ŀ" styleClass="commonButton" onclick="commonSubmit('zongkufangInfoEdit.do?act=initInsert')"/>
				 <html:button property="btnSave" value="��������" styleClass="commonButton" onclick="commonCheckSubmit('zongkufangInfoEdit.do?act=initInsert2','UUID','��ѡ����������Ŀ')"/>
				</div>
			</div>
		</html:form>
		</div>
	</body>
<script>
</script>
</html>
