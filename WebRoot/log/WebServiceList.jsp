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
		<html:form action="webServiceLog.do">
		<bean:define id="xiaoquList" name="webServiceLogForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					���Žӿ���־
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query2">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td >
								С��
							</td>
							<td>
							
						       <html:select name="webServiceLogForm" property="xiaoqu"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select> 
								
							
							</td>
							<td >
								��ַ
							</td>
							<td>
								<html:text name="webServiceLogForm" property="dizhi" size="11"></html:text>
							</td>
							<td >
								�ӿ�����
							</td>
							<td>
								<html:select name="webServiceLogForm" property="yonghuzhuangtai"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:option value="��װ">��װ</html:option>
									<html:option value="�˶�">�˶�</html:option>
									<html:option value="�޸�����">�޸�����</html:option>
									<html:option value="����">����</html:option>
									<html:option value="ͣ��">ͣ��</html:option>
									<html:option value="����">����</html:option>
								</html:select>
							</td>
							<td >
								���ý��
							</td>
							<td>
								<html:select name="webServiceLogForm" property="interfaceResult"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:option value="1">���ͳɹ�</html:option>
									<html:option value="����ʧ�ܣ�">����ʧ��</html:option>
								</html:select>
							</td>
							<td>
								��������
							</td>
							<td>
									<html:text name="webServiceLogForm" property="createDt" styleId="createDt" size="10" onclick="WdatePicker()" />
							</td>
							
							<td>
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('webServiceLog.do?act=query');" />
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
						<table border="0" cellspacing="0" cellpadding="1"  width="100%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine"nowrap="nowrap">
									ҵ����
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									С����ַ
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									���ƺ�
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									ҵ���˺�
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									ҵ������
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									����
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									�ӿ�����
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									�ӿڵ�������
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									�ӿڵ��ý��
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									��������
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									��ˮ��
								</td >
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center" class="colorRow" id="<bean:write name="line" field="xmlState" />">
								
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="uuid" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="tradeAccount" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="tradeDetail" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="daikuan" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="yonghuzhuangtai" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="InterfaceDetail" />
									</td>
									<!--  -->
									<td class="tableContentLine edit" height="20"nowrap="nowrap" id="<bean:write name="line" field="id" />">
										<bean:write name="line" field="yonghuzhuangtai" />
										<script type="text/javascript">
											var str = '<bean:write name="line" field="InterfaceResult" />';
											var uuid = '<bean:write name="line" field="id" />';
											
											if(str == '1') {
												$(".edit[id=" + uuid + "]").append("���ķ��ͳɹ���");
												//$(".edit[id=" + uuid + "]").append("<a href='#' class='resend' name='" + uuid + "' > �ط�</a>");
											} else if(str == '2') {
												$(".edit[id=" + uuid + "]").append("���ݲ����ɹ���");
												//$(".edit[id=" + uuid + "]").append("<a href='#' class='resend' name='" + uuid + "' > �ط�</a>");
											} else if (str == '3') {
												$(".edit[id=" + uuid + "]").append("���ķ���ʧ�ܣ�");
												//$(".edit[id=" + uuid + "]").append("<a href='#' class='resend' name='" + uuid + "' > �ط�</a>");
											} else if (str == '4') {
												$(".edit[id=" + uuid + "]").append("���ݲ���ʧ�ܣ�");
												//$(".edit[id=" + uuid + "]").append("<a href='#' class='resend' name='" + uuid + "' > �ط�</a>");
											} else {
												$(".edit[id=" + uuid + "]").append("δ֪�������");
											}
										</script>
									</td>
									<td class="tableContentLine" height="20" nowrap="nowrap">
										<bean:write name="line" field="createDt" />
									</td>
									<td class="tableContentLine" height="20" nowrap="nowrap">
										<bean:write name="line" field="xmlId" />
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
			</div>
		</html:form>
	</body>
	<script type="text/javascript">
		$().ready(function() {
			$(".colorRow[id='1']").css("color", "red");
			
			$(".resend").live("click", function() {
				var uuid = ($(this).attr("name"));
				$.ajax({
					url:"reSendXml.do?act=reSend",
					type : "POST",
					cache:false,
					data:{
						'uuid':uuid
					},
					success: function(data){
						if(data == '0') {
							alert("���ͳɹ�����ˢ���б�");
							
						} else {
							alert(data);
							return false;
						}
						
					}
				});
			});
			
		});
	
	</script>
</html>
