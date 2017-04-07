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
		<script src="js/business.js" language="javascript"></script>
		<script src="xufei/xufei.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<div style="height:480px;">
		<html:form action="chulidaijiaofeiDataList.do">
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					������ɷ�
				</div>
				<!-- ��ѯ���� 
				<div id="conten_query2">
					<div id="query2_div" style="display:none;">
					</div>
				</div>-->
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result1">
					<!-- ��ҳͷ -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- ���һ�� start-->
					<div name="result_table" class="result_table1">
						<table border="0" cellspacing="0" cellpadding="1" width="140%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine" nowrap="nowrap">
									&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�û�״̬
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�տ�ʱ��
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									С��
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ַ
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��Ӫ��
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����ʱ��
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ͣ��ʱ��
								</td>
								<td class="tableTitleLine" >
									����
								</td>
								<td class="tableTitleLine" >
									�����˺�
								</td>
								<td class="tableTitleLine">
									����
								</td>
								
								<td class="tableTitleLine">
									�����˺�
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���շ�
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ҵ��
								</td>
								
								<td class="tableTitleLine" nowrap="nowrap">
									onuѺ��
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									������Ѻ��
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���ӷ�
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���
								</td>
								
								<td class="tableTitleLine" nowrap="nowrap">
									�վݺ�
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��Ʊ��Ϣ
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ʩ����
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ע����
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�绰
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center" style="<bean:write name='line' field='linkcolor' />;">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yonghuzhuangtai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoukuanshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yunyingshang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaijishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="tingjishijian" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="wangluo" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="wangluoip" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="dianshi" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="dianhuaip" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="zongshoufei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yewu" />
									</td>
									
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="onuyj" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="jidingheyj" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoushifei" />
									</td>
									
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kuandaifei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="nianfei" />
									</td>
									
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoujubenhao" />
									</td>
									
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaipiaoxinxi" />
									</td>
									
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shigongren" />
									</td>
									
									<td class="tableContentLine" >
										<bean:write name="line" field="beizhuhuizong" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianhua" />
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
				<div id="buttonC" name="button" class="content_button" >
				  <html:button styleId="btnSave" property="btnSave" value="¼��" styleClass="commonButton2" onclick="shenhe();"/>
				  <html:button styleId="btnSaveEdit" property="btnSaveEdit" style="display: none" value="�༭" styleClass="commonButton2" onclick="commonCheckSubmit('shenqingDataEdit.do?act=initEditDaijiaofei','UUID','��ѡ����༭�Ĵ��ɷ�����')"/>
				  <html:button styleId="btnSave" property="btnSave" value="ɾ��" styleClass="commonButton2" onclick="removeData2()"/>
				<!--   <html:button property="btnSave" value="�鿴����" styleClass="commonButton2" onclick="commonCheckSubmit('yonghuDataEdit.do?act=showInfo','UUID','��ѡ����鿴���û�����')"/> -->
			    </div>
			</div>
<!-- 			<html:hidden name="yonghuDataForm" property="quyuCodeHidden" /> -->
		</html:form>
		</div>
	
		
			</body>
	<script type="text/javascript"  language="javascript">
		function  hiddenEditDiv() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			switch (roleCode) {         
			        case '5': 
			        	document.getElementById("btnSaveEdit").style.display="";  
			 			break;  
			 		case '8': 
			        	document.getElementById("btnSaveEdit").style.display="";  
			 			break; 
			    	case '4':               
			            document.getElementById("buttonC").style.display="none";  
			            break;       
			} 
		}
		function deletecheck(uuid) {
			return false;	
		}
		hiddenEditDiv();	
	</script>
</html>
