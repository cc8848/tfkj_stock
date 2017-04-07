<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2012-11-23     Zhu,Xiao-Lei     Create
   
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
		<script src="caiwuhedui/caiwu.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="moneymateList.do">
		
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					�����ƥ��
				</div>
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result1">
					<!-- ��ҳͷ -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- ���һ�� start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="100%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�������&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��Ϣ����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���շѺϼƽ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��������շѵĲ�ֵ&nbsp;
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="zmUUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cunkuanren" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cunkuanshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cunkuanyinhang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangdianhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cunkuanjine" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xinxishuliang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="zongshoufeiheji" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="chazhi" />
									</td>
								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- ���һ�� end-->
					<div name="page_down" class="page_downuser">
						<div align="right">
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- ��ѯ��� end -->
				<!-- button -->
				<div id="" name="button" class="content_button" >

				  <html:button property="btnSave" value="������Ŀ" styleClass="commonButton2" onclick="commonSubmit('zhangmuDataInsert.do?act=initInsert')"/>
				  <html:button property="btnSave" value="�ύ��ƥ��" styleClass="commonButton3" onclick="commonCheckSubmit('moneymateList.do?act=subAccount','zmUUID','��ѡ����ύ����Ŀ')"/>
				  <html:button styleId="buttonC" property="btnSave" value="�༭��Ŀ" styleClass="commonButton2" onclick="commonCheckSubmit('editeAccountsMateList.do?act=init','zmUUID','��ѡ����༭����Ŀ')"/>
				  <html:button property="btnSave" value="ƥ����Ŀ" styleClass="commonButton2" onclick="commonCheckSubmit('accountsmateList.do?act=init','zmUUID','��ѡ���ƥ�����Ŀ')"/>
				  <html:button property="btnSave" value="ɾ����Ŀ" styleClass="commonButton2" onclick="removeData1()"/>
				
			  <!--<html:button property="btnSave" value="ɾ��" styleClass="commonButton" onclick="removeData()"/>-->
			  <!--<html:button property="btnSave" value="���" styleClass="commonButton" onclick="commonSubmit('paigongdanEdit.do?act=initInsert')"/>	-->
			  <!--<html:button property="btnSave" value="���" styleClass="commonButton" onclick="removeData1()"/>	-->
			    </div>
			</div>
				<html:hidden name="zhangmuForm" property="UUID" />
				<html:hidden name="zhangmuForm" property="cunkuanren" />
		</html:form>
	</div>
	</body>
	<script type="text/javascript"  language="javascript">
		function  hiddenEditDiv() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			switch (roleCode) {         
			       /*  case '5': 
			            document.getElementById("buttonC").style.display="";  
			 			break;               
			    	case '4':               
			            document.getElementById("buttonC").style.display="none";  
			            break;    
			    	case '3':               
			            document.getElementById("buttonC").style.display="none";  
			            break;  
			        case '2':               
			            document.getElementById("buttonC").style.display="none";  
			            break; 
					case '1':               
			            document.getElementById("buttonC").style.display="none";  
			            break;  
			        case '6':               
			          	document.getElementById("buttonC").style.display="none";  
			            break;    */
			} 
		}
		hiddenEditDiv();	
	</script>
</html>
