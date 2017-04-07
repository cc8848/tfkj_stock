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
		<html:form action="editeAccountsMateList.do">
		<bean:define id="xiaoquList" name="zhangmuForm" property="xiaoquList"></bean:define>
		<bean:define id="statusList" name="zhangmuForm" property="statusList"></bean:define>
		<bean:define id="senList" name="zhangmuForm" property="senList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					�༭��Ŀ
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">
					<table id="quert_table"  align="center" cellpadding="1" cellspacing="1" border="1">
						<tr  align="center">
							<td width="60px">
								<font style="font-weight: bold;">�����:</font>
							</td>
							<td>
							<html:text name="zhangmuForm" property="cunkuanren" readonly="true" size="8"/>
							</td >
							
							<td width="60px">
								<font style="font-weight: bold;">���ʱ��:</font>
							</td>
							<td >
								<html:text name="zhangmuForm" property="cunkuanshijian" readonly="true" size="10"/>
							</td>
							
							<td width="60px">
								<font style="font-weight: bold;">�������:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="cunkuanyinhang" readonly="true" size="8"/>
							</td >
							
							<td width="60px">
								<font style="font-weight: bold;">�����:</font>
							</td >
							<td>
								<html:text name="zhangmuForm" property="wangdianhao" readonly="true" size="8"/>
							</td>
							
							<td width="60px">
								<font style="font-weight: bold;">�����:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="cunkuanjine" readonly="true" size="6"/>
							</td>
							<td width="100px">
								<font style="font-weight: bold;">���շѺϼƽ��:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="zongshoufeiheji" readonly="true" size="6"/>
							</td>
							<td width="45px">
								<font style="font-weight: bold;">��ֵ:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="chazhi" readonly="true" size="6"/>
							</td>
							<td width="60px">
								<font style="font-weight: bold;">��Ϣ����:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="xinxishuliang" readonly="true" size="4"/>
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
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="140%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�˶�״̬&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�տ�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�û�״̬&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�տ�ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									С��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ַ&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ͣ��ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�绰&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ҵ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���շ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�վݱ���/�վݺ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��Ʊ��Ϣ&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									onuѺ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									������Ѻ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���ӷ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��װ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����·�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�豸���۷�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���Ϸ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ע&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ʩ����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�ֳ���ע&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ע����&nbsp;
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap" id="${line.id}">
										<bean:write name="line" field="hedui" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="zhifuleixing" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yonghuzhuangtai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoukuanshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xingming" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaijishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="tingjishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangluo" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianshi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianhua" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yewu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap" >
										<bean:write name="line" field="zongshoufei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoujubenhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaipiaoxinxi" />
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
										<bean:write name="line" field="chuzhuangfei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="bzygf" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="mianban" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shebeixiaoshou" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cailiaofei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="beizhu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shigongren" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xianchangbeizhu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="beizhuhuizong" />
									</td>
								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- ���һ�� end-->
					<div name="page_down" class="page_downuser">
						<div align="right"  >
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- ��ѯ��� end -->
				<!-- button -->
				<div id="buttonC" name="button" class="content_button" >
				 <!--  <html:button property="btnSave" value="����" styleClass="commonButton" onclick="commonCheckSubmit('zhangMuEdit.do?act=insertPipeiZhangmu','UUIDS','��ѡ���ƥ�������')"/> -->
				  <html:button styleId="buttonA" property="btnSave" value="ɾ��" styleClass="commonButton" onclick="removeData2();"/>
				  <html:button styleId="buttonB" property="btnSave" value="����" styleClass="commonButton" onclick="commonSubmit('moneymateList.do?act=init&zhuangtai=0')"/>
			    </div>
			</div>
			<html:hidden name="zhangmuForm" property="quyuCodeHidden" />
			<html:hidden name="zhangmuForm" property="addressCodeHidden" />
			<html:hidden name="zhangmuForm" property="stateCodeHidden" />
			<html:hidden name="zhangmuForm" property="kaijisHidden" />
			<html:hidden name="zhangmuForm" property="sen1Hidden" />
			<html:hidden name="zhangmuForm" property="senValue1Hidden" />
			<html:hidden name="zhangmuForm" property="zhangmuUUIDHidden" />
			<html:hidden name="zhangmuForm" property="zongshoufeiHidden" />
			<html:hidden name="zhangmuForm" property="UUIDHidden" />
			<html:hidden name="zhangmuForm" property="zhifuleixingHidden" />

		</html:form>
	</div>
	</body>
	<script type="text/javascript"  language="javascript">
		function  hiddenEditDiv() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			switch (roleCode) {         
			        case '5': 
			 			break;              
		             default:               
		                document.getElementById("buttonA").style.display="none";  
		                break;        
			} 
		}
		hiddenEditDiv();	
		
	</script>
</html>
