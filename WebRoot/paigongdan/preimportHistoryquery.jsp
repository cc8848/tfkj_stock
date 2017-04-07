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
		<script src="js/Calendar3.js" language="javascript"></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="paigongdan/paigongdan.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		
	<script type="text/javascript"  language="javascript">
		function  hiddenEditDiv2() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			if(roleCode!='5'&&roleCode!='8') {
				document.getElementById("deviceedit").style.display="none";
				document.getElementById("btnfenguangpipei").style.display="none";
				document.getElementById("btnfenguangback").style.display="none";
			}
			if(roleCode!='5'&&roleCode!='8'&&roleCode!='2') {
				document.getElementById("btnEdit").style.display="none";
			}
		}
		//ɾ��
		function removeData(){
			if(checkSelect("UUIDS","��ѡ���ɾ���Ļص�")){
				confirmRemove();
			}
		}
		//ɾ��ȷ��
		function confirmRemove(){
			showConfirm('ȷ��Ҫɾ��ѡ���Ļص���',removeCallback);
		}
		//ɾ������
		function removeCallback(v,m,f){
			if(v){
				document.forms[0].action = "huidanPreImportList.do?act=delete";
				disableAll(document);
				document.forms[0].submit();
			}
		}
		function checkValue(val) {
			if(val==""||val=="0"||val=="��"||val==" ") {
				return true;
			}
		}
		</script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init();">
		<html:form action="huidanPreImportHistoryList.do">
		<bean:define id="xiaoquList" name="paiGongDanPreImportForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					Ԥ������ʷ
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query2" >
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								�ɹ�����
							</td>
							<td>
								<html:text name="paiGongDanPreImportForm" property="paigongriqis" styleId="paigongriqis" size="10" onclick="new Calendar().show(this)" />		
							</td>
							<td>
								����ʱ��
							</td>
							<td>
								<html:text name="paiGongDanPreImportForm" property="kaijishijian" styleId="kaijishijian" size="10" onclick="new Calendar().show(this)" />		
							</td>
							<td>
								ͣ��ʱ��
							</td>
							<td>
								<html:text name="paiGongDanPreImportForm" property="tingjishijian" styleId="tingjishijian" size="10" onclick="new Calendar().show(this)" />		
							</td>
							<td>
								����ʱ��
							</td>
							<td>
								<html:text name="paiGongDanPreImportForm" property="caozuoshijian" styleId="caozuoshijian" size="10" onclick="new Calendar().show(this)" />		
							</td>
							<td>
								С������
							</td>
							<td>
								<html:select name="paiGongDanPreImportForm" property="xiaoqu"
								styleClass="commonTextFieldHover" styleId="xiaoqu"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">-��ѡ��-</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							</td>
							<td>
								��ַ
							</td>
							<td>
								<html:text name="paiGongDanPreImportForm" property="dizhi" size="10" />
							</td>
							<td>
								ҵ������
							</td>
							<td>
								<html:select name="paiGongDanPreImportForm" property="yewutype"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:option value="��װ">��װ</html:option>
									<html:option value="�ƻ�">�ƻ�</html:option>
									<html:option value="��·�и�">��·�и�</html:option>
								</html:select>
							</td>
							<td>
								��ע
							</td>
							<td>
								<html:text name="paiGongDanPreImportForm" property="beizhu" styleId="beizhu" />		
							</td>
							<td align="right">
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('huidanPreImportHistoryList.do?act=query')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result2"  >
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
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									����ʱ��
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									ҵ������
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									��װ�ȶ�
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									��Ӫ��
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�ɹ�����
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									����ʱ��
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									ͣ��ʱ��
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									С��
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									��ַ
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									��ϵ�绰
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									����
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
								<td class="tableTitleLine" weight="20%"nowrap="nowrap">
									�ֹ�
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									onumac
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									STB MCID
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									����ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									����ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�绰ip/�����˺�
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�绰VLAN
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									����VLAN
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									����ʱ��
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�û�����
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									���֤
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									��֤
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									��ѡ�绰����
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									ONUѺ��
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									������Ѻ��
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									���ӷ�
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�����
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									��װ��
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�豸���۷�
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									���Ϸ�
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�����¹���
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									���
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
									<td class="tableContentLine">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="updatedt" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="yewuleixing" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<font color="blue"><bean:write name="line" field="biduikbn" /></font>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="yuyingshang" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="paigongriqi" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="newkaijishijian" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="newtingjishijian" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
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
										<bean:write name="line" field="tfiptv" /><input type="hidden" name="tfiptvhidden" value="<bean:write name="line" field="tfiptv" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tfsfyewu" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="qtye" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="bdfenguang"  filter="false"/><input type="hidden" name="fenguanghidden" value="<bean:write name="line" field="fenguangD" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="bdonumac"  filter="false"/><input type="hidden" name="onumachidden" value="<bean:write name="line" field="onumacD" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="bdstbmcid"  filter="false"/>
									</td>
									
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="bddianshiip" filter="false"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="netip" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="telip" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="telvaln"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="netvaln" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="anzhuangshijian" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="username" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="shenfenzheng" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="danzheng" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="telhaoma" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="onu" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="jidinghe" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="shoushifei" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="kuaidaifei" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="chuzhuangfei" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="shebeixiaoshou" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="cailiaofei" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="buzuyue" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="nianfei" />
									</td>
									<td class="tableContentLine" width="29%" nowrap="nowrap">
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
				<div name="button" class="content_button" style="width:70%">
						<html:button styleId="btnhuitui" property="btnhuitui" value="���ƻ���"  styleClass="commonButton2"  onclick="commonCheckSubmit('huidanPreImportHistoryList.do?act=fuzhihuitui','UUIDS','��ѡ���ƥ��ļ�¼')"/>
				</div>
			</div>
		</html:form>
</body>
</html>
