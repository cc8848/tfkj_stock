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
		<script src="yonghushuju/yonghuData.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="yonghuDataList.do">
		<bean:define id="xiaoquList" name="yonghuDataForm" property="xiaoquList"></bean:define>
		<bean:define id="statusList" name="yonghuDataForm" property="statusList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					���񱨱�
				</div>
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result1">
					<!-- ��ҳͷ -->
					<div name="page_up" class="page_up">
						<!-- <jsp:include page="/common/paginationHeader.jsp" /> -->
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
								
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUIDS" type="checkbox" value="${line.id}" />
										<%-- <input name="zmUUID" type="radio" value="${line.id}" />  --%>
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
								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- ���һ�� end-->
					<div name="page_down" class="page_downuser">
						<div align="right">
							<!-- <jsp:include page="/common/paginationFooter.jsp" /> -->
						</div>
					</div>
				</div>
				<!-- ��ѯ��� end -->
				<!-- button -->
				<div id="buttonC" name="button" class="content_button" >

				  <html:button property="btnSave" value="�ύ����ʷ��Ŀ" styleClass="commonButton4" onclick="commonCheckSubmit('reportformsList.do?act=subAccount','UUIDS','��ѡ��Ҫ�ύ����Ŀ')"/>
				  <html:button property="btnSave" value="����ͳ�Ʊ�" styleClass="commonButton3" onclick="commonCheckSubmit('zhangmuDataInsert.do?act=downHuiZongTongJi','UUIDS','��ѡ��Ҫ��������ͳ�Ʊ����Ŀ��')"/>
				  <html:button property="btnSave" value="�շѴ����ϸ" styleClass="commonButton3" onclick="commonCheckSubmit('zhangmuDataInsert.do?act=downCunKuanMingXi','UUIDS','��ѡ��Ҫ���������ϸ�����Ŀ��')"/>
				  <html:button property="btnSave" value="���Ŵ�����ϸ" styleClass="commonButton3" onclick="commonCheckSubmit('zhangmuDataInsert.do?act=downDianXinShouFei','UUIDS','��ѡ��Ҫ�������Ŵ��շѴ����ϸ�����Ŀ��')"/>
				  <html:button property="btnSave" value="��������ռ���" styleClass="commonButton4" onclick="commonCheckSubmit('zhangmuDataInsert.do?act=downYHRiJiZhang', 'UUIDS', '��ѡ��Ҫ�����Ĵ�������ռ��ˣ�')"/>
				
				  <html:button property="btnSave" value="�����˻�" styleClass="commonButton2" onclick="commonCheckSubmit('reportformsList.do?act=backAccount','UUIDS','��ѡҪ���˵���Ŀ���ݣ�')"/>
			  <!--<html:button property="btnSave" value="ɾ��" styleClass="commonButton" onclick="removeData()"/>-->
			  <!--<html:button property="btnSave" value="���" styleClass="commonButton" onclick="commonSubmit('paigongdanEdit.do?act=initInsert')"/>	-->
			  <!--<html:button property="btnSave" value="���" styleClass="commonButton" onclick="removeData1()"/>	-->
			    </div>
			</div>
			<html:hidden name="yonghuDataForm" property="quyuCodeHidden" />
			<html:hidden name="yonghuDataForm" property="addressCodeHidden" />
			<html:hidden name="yonghuDataForm" property="stateCodeHidden" />
			<html:hidden name="yonghuDataForm" property="kaijisHidden" />
			<html:hidden name="yonghuDataForm" property="kaijieHidden" />
			<html:hidden name="yonghuDataForm" property="tingjisHidden" />
			<html:hidden name="yonghuDataForm" property="tingjieHidden" />
			<html:hidden name="yonghuDataForm" property="sen1Hidden" />
			<html:hidden name="yonghuDataForm" property="senValue1Hidden" />
			<html:hidden name="yonghuDataForm" property="sen2Hidden" />
			<html:hidden name="yonghuDataForm" property="senValue2Hidden" />
			<html:hidden name="yonghuDataForm" property="sen3Hidden" />
			<html:hidden name="yonghuDataForm" property="senValue3Hidden" />
			
		</html:form>
	</div>
	</body>
	<script type="text/javascript"  language="javascript">
		function  hiddenEditDiv() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			switch (roleCode) {         
			         case '5': 
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
			          	document.getElementById("buttonC").style.display="";  
			            break;        
			} 
		}
		hiddenEditDiv();	
	</script>
</html>
