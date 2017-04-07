<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2015-07-06   Dai-Zhen           Create
   
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
		<title>�췿�Ƽ���������ϵͳ</title>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<script src="kucun/kucun.js" language="javascript"></script>
		<script type="text/javascript">
			function selectdeviceCheck(closekbn) {
				if(checkSelect("UUID","��ѡ��Ҫ��ѡ���豸��")){
					selectdevice(closekbn);
				}
			}
			function selectdevice(closekbn) {
				var uuids = document.getElementsByName("UUID");
				var eqboxnums = document.getElementsByName("eqboxnum");
				var eqregisters = document.getElementsByName("eqregister");
				var eqmacs = document.getElementsByName("eqmac");
				var eqmcids = document.getElementsByName("eqmcid");
				var eqips = document.getElementsByName("eqip");
				for(var i=0;i<uuids.length;i++){
					if(uuids[i].checked){
						var eqmacVal = eqmacs[i].value;
						if(eqmacVal==""||eqmacVal=="��"||eqmacVal=="0") {
							var boxid = window.opener.document.getElementById("selectCommunityPileID2").value;
							if(boxid!=""&&boxid!="0") {
								alert("��������ѡ�Ļ������豸������ִ�С��豸�ؿ⡿������");
								return false;
							}
							window.opener.document.getElementById("selectCommunityPileID2").value = uuids[i].value;
							window.opener.document.getElementById("stbmcid").value = eqmcids[i].value;
							window.opener.document.getElementById("dianshiip").value = eqips[i].value;
							window.opener.document.getElementById("eqboxnum2").value = eqboxnums[i].value;
						}else{
							var onuid = window.opener.document.getElementById("selectCommunityPileID").value;
							if(onuid!=""&&onuid!="0") {
								alert("��������ѡ��ONU�豸������ִ�С��豸�ؿ⡿������");
								return false;
							}
							window.opener.document.getElementById("selectCommunityPileID").value = uuids[i].value;
							if(window.opener.document.getElementById("fenguangID").value=="") {
								window.opener.document.getElementById("fenguang").value = eqregisters[i].value;
							}
							window.opener.document.getElementById("onumac").value = eqmacVal;
							window.opener.document.getElementById("eqboxnum").value = eqboxnums[i].value;
						}
					}
				}
				window.opener.afterselect();
				if(closekbn==0) {
					window.close();
				}
			}
		</script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="shebeichukuList.do">
		<bean:define id="statusList" name="kucunForm" property="statusList"></bean:define>
		<bean:define id="xiaoquList" name="kucunForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					��ѡ�豸
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query2">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td >
								�豸״̬
							</td>
							<td>
								<html:select style="width:80px" name="kucunForm" property="status"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<option value="2">�����ֳ�</option>
								</html:select>	
							</td>
							
							<td >
								���С��
							</td>
							<td>
								<html:select style="width:80px" name="kucunForm" property="quyuCode"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove';this.defaultIndex=this.selectedIndex"
									onchange="this.selectedIndex=this.defaultIndex" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select>	
							</td>
							
							<td >
								��װ�ص�
							</td>
							<td>
								<html:text name="kucunForm" property="install_site" size="12"/>
							</td>
							
							<td>
								MAC
							</td>
							<td>
								<html:text name="kucunForm" property="qmac" size="12"/>
							</td>
							<td >
								MCID
							</td>
							<td>
								<html:text name="kucunForm" property="qmcid" size="12"/>
							</td>
							
						</tr>
						
						<tr>
							<td style="display:none">
								ʱ������
							</td>
							<td style="display:none">
								<html:select name="kucunForm" property="shijianleixing" onclick="check(this)"
									styleClass="commonTextFieldHover"  
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value=""  >-��ѡ��-</html:option>
									<html:option value="1">�������</html:option>
									<html:option value="2">С���������</html:option>
									<html:option value="3">��װʱ��</html:option>
								</html:select>
							</td>
							<td style="display:none">
								��ʼʱ�䣺
							</td>
							<td style="display:none">
								<html:text name="kucunForm" property="kaishi" styleId="kaishi" size="10" onclick="WdatePicker({el:'kaishi'})" />
								<img onclick="WdatePicker({el:'kaishi'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
							</td>
							<td style="display:none">
								����ʱ�䣺
							</td>
							<td style="display:none">
								<html:text name="kucunForm" property="jieshu" styleId="jieshu" size="10" onclick="WdatePicker({el:'jieshu'})" />
								<img onclick="WdatePicker({el:'jieshu'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
							</td>
							<td>
								�豸���ͣ�
							</td>
							<td colSpan="5">
								<html:radio name="kucunForm" property="shebeitype" value="0" >ONU</html:radio>
								<html:radio name="kucunForm" property="shebeitype" value="1">������</html:radio>
							</td>
							<td>
								�ۺϲ�ѯ��
							</td>
							<td>
								<html:select name="kucunForm" property="sen"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:option value="1">���</html:option>
									<html:option value="2">�����</html:option>
									<html:option value="3">�豸����</html:option>
									<html:option value="4">�豸�ͺ�</html:option>
									<html:option value="5">��ȡ��</html:option>
									<html:option value="6">ע��λ��</html:option>
									<html:option value="7">����IP</html:option>
									<html:option value="8">��ע</html:option>
								</html:select>
							</td>
							<td>
								����
							</td>
							<td>
								<html:text name="kucunForm" property="senValue" size="12" />
							</td>
							<td>
								<!-- <input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('shebeichukuList.do?act=query')" /> -->
								 <input type="button" value="��ѯ" class="commonButton" onclick="if(check()){commonSubmit('shebeichukuList.do?act=query');}" />
							</td>
							<!-- <td >
								<input type="button" value="��Ѱ����ڲ�ѯ" class="commonButton4" onclick="" />
							</td> -->
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result2">
					<!-- ��ҳͷ -->
					<div name="page_up" class="page_up">
						 <jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- ���һ�� start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="140%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine" nowrap="nowrap">
									�༭&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�豸״̬&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�������&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�豸����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�豸�ͺ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									С���������&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���С��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ȡ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��װ�ص�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��װʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ע��λ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									MAC&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									MCID&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ע&nbsp;
								</td>
				
							</tr>
							<logic:iterate id="line"
								           name="com.takucin.aceeci.frame.pagination"
								           property="result"
								           type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="<bean:write name='line' field='PK_ID' />" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqboxnum" />
										<input type="hidden" name="eqboxnum" value="<bean:write name='line' field='eqboxnum' />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqsta_name" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="create_time" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="create_person" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqtype" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqversion" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="FirstEnterDate" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="CommunityName" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="getPerson" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="Install_site" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="Install_time" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqregister" />
										<input type="hidden" name="eqregister" value="<bean:write name='line' field='eqregister' />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqmac" />
										<input type="hidden" name="eqmac" value="<bean:write name='line' field='eqmac' />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqmcid" />
										<input type="hidden" name="eqmcid" value="<bean:write name='line' field='eqmcid' />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="eqip" />
										<input type="hidden" name="eqip" value="<bean:write name='line' field='eqip' />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">&nbsp;
										<bean:write name="line" field="eqremark" />
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
				<div id="buttonC" name="button" class="content_button1" >
			    	<html:button property="btnSelect" value="ѡȡ�豸" styleClass="commonButton2" onclick="selectdeviceCheck(0)"/>
			    	<html:button property="btnSelect" value="���沢������ѡ" styleClass="commonButton2" onclick="selectdeviceCheck(1)"/>
			    </div>
			</div>
			
			<html:hidden name="kucunForm" property="UUIDHidden" />	
		</html:form>
	</div>
	</body>
</html>
