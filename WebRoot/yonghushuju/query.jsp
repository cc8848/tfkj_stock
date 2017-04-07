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
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
		%>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
				<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker1.js" ></script>
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
		<script type="application/javascript">
			function tuiding(){
				alert("1");
			}

		</script>
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="yonghuDataList.do">
		<bean:define id="xiaoquList" name="yonghuDataForm" property="xiaoquList"></bean:define>
		<bean:define id="statusList" name="yonghuDataForm" property="statusList"></bean:define>
		<bean:define id="senList" name="yonghuDataForm" property="senList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					�û����ݵ���
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query2">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td width="35px">
								С��
							</td>
							<td>
								<html:select name="yonghuDataForm" property="quyuCode"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td width="30px">
								��ַ
							</td>
							<td>
								<html:text name="yonghuDataForm" property="addressCode" size="12"/>
							</td>
							<td width="55px">
								ʱ������
							</td>
							<td>
								<html:select name="yonghuDataForm" property="shijianleixing" onclick="check(this)"
									styleClass="commonTextFieldHover"  
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value=""  >-��ѡ��-</html:option>
									<html:option value="1">����ʱ��</html:option>
									<html:option value="2">ͣ��ʱ��</html:option>
									<html:option value="3">�տ�����</html:option>
									<html:option value="4">��Чʱ��</html:option>
								</html:select>
							  
							</td>
							<td>
								��ʼʱ��
							</td>
							<td>
								<html:text name="yonghuDataForm" property="kaijis" styleId="kaijis" size="10" onclick="WdatePicker({el:'kaijis'})" readonly="true"/>
								<img onclick="WdatePicker({el:'kaijis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							    
							</td>
							<td>
								����ʱ��
							</td>
							<td>
								<html:text name="yonghuDataForm" property="kaijie" styleId="kaijie" size="10" onclick="WdatePicker({el:'kaijie'})" readonly="true"/>
								<img onclick="WdatePicker({el:'kaijie'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							    
							</td>
							  <script language="javascript" type="text/javascript">
							    	function check(v){
							    			
							    			if(v.value!=""){
							    					document.forms[0].kaijis.readOnly = false;
													document.forms[0].kaijie.readOnly = false;
							    			}else{
							    					document.forms[0].kaijis.readOnly = true;
													document.forms[0].kaijie.readOnly = true;
							    			}
							    	}
							    </script>
							<td>
								״̬
							</td>
							<td>
								<html:select name="yonghuDataForm" property="stateCode"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--��ѡ��--</html:option>
								<html:option value="�˵�">�˵�</html:option>
								<html:option value="���޸�">���޸�</html:option>
								<html:options collection="statusList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								<!-- ͣ��2 -->
							</td>
							<td>
							<!--<html:text name="yonghuDataForm" property="tingjis" styleId="tingjis" size="10" onclick="WdatePicker({el:'tingjis'})" />
								<img onclick="WdatePicker({el:'tingjis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							    <html:text name="yonghuDataForm" property="tingjie" styleId="tingjie" size="10" onclick="WdatePicker({el:'tingjie'})" />
								<img onclick="WdatePicker({el:'tingjie'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">--> 
							</td>
						</tr>
						<tr>
							<td>
								��ѯ1
							</td>
							<td>
								<html:select name="yonghuDataForm" property="sen1"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:options collection="senList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								����
							</td>
							<td>
								<html:text name="yonghuDataForm" property="senValue1" size="12" />
							</td>
							<td>
								��ѯ2
							</td>
							<td>
								<html:select name="yonghuDataForm" property="sen2"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:options collection="senList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								����
							</td>
							<td>
								<html:text name="yonghuDataForm" property="senValue2" size="12" />
							</td>
							<td>
								��ѯ3
							</td>
							<td>
								<html:select name="yonghuDataForm" property="sen3"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:options collection="senList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								����
							</td>
							<td>
								<html:text name="yonghuDataForm" property="senValue3" size="12" />
							</td>
							
							<td align="right">
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('yonghuDataList.do?act=query')" />
							</td>
							<td align="right">
								<input type="button" value="�����˶�" class="commonButton tuiding" onclick="commonCheckSubmit2('yonghuDataEdit.do?act=initTuiding2','UUID','��ѡ����༭���û�����')" />
							</td>
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
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�û�״̬&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ƥ��״̬&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�տ�ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���֤��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�վݺ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�ֹ��ߺ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����λ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ͣ��ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��Чʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									С��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ַ&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ϵ�绰&nbsp;
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
									�ֹ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									Onu mac&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									STB MCID&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����ʺ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�绰IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�绰VLAN&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����VLAN&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��֤&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ѡ�绰����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ONUѺ��&nbsp;
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
									�豸���۷�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���Ϸ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��Ӫ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����¹���&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ע&nbsp;
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
									�����豸ʹ�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����Ĳ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									������&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									RJ11&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									RJ45&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ģ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����&nbsp;
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
								<td class="tableTitleLine" nowrap="nowrap">
									ά������&nbsp;
								</td>
							</tr>
							<logic:iterate id="line"
								           name="com.takucin.aceeci.frame.pagination"
								           property="result"
								           type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yonghuzhuangtai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="pipeizhuangtai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoukuanshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xingming" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shenfensheng" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoujuhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="fenguangxianhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="jiexuweizhi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaijishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="tingjishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="youxiaoshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="lianxidianhua" />
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
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="fenguang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="onumac" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="stbmcid" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianshiip" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangluoip" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianhuaip" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianhuavlan" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangluovlan" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shangmenshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="danzheng" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="sxdhhm" />
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
										<bean:write name="line" field="shebeixiaoshou" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cailiaofei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yunyingshang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="bzygf" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="nianfei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="beizhu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="zongshoufei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoujubenhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaipiaoxinxi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="qtsbsyqk" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="qitahaocai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="jiexianzi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="rj11" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="rj45" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="mokuai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="mianban" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangxian" />
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
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="weixiuleixing" />
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

				  <html:button property="btnSave" value="�༭" styleClass="commonButton" onclick="commonCheckSubmit('yonghuDataEdit.do?act=initEdit','UUID','��ѡ����༭���û�����')"/>
				  <!--<html:button property="btnSave" value="�����豸" styleClass="commonButton2" onclick="commonCheckSubmit('yonghuDataEdit.do?act=initShebeiEdit','UUID','��ѡ����༭���û�����')"/>-->
				  <html:button property="btnSave" value="�鿴����" styleClass="commonButton2" onclick="commonCheckSubmit('yonghuDataEdit.do?act=showInfo','UUID','��ѡ����鿴���û�����')"/>
				  <html:button property="btnViewPhoto" value="�鿴��Ƭ" styleClass="commonButton" onclick="viewphoto('photouploadEdit.do?act=showPhotoFTP','UUID','�뵥ѡ����鿴������')"/>
				<!--<html:button property="btnSave" value="ɾ��" styleClass="commonButton" onclick="removeData()"/>-->
					<!-- 	<html:button property="btnSave" value="���" styleClass="commonButton" onclick="commonSubmit('paigongdanEdit.do?act=initInsert')"/>
						<html:button property="btnSave" value="���" styleClass="commonButton" onclick="removeData1()"/>
			 	-->
			 	<html:button styleId="tietongExport" property="btnSave" value="��ͨ���ݵ���" styleClass="commonButton4" onclick="sub()" />
			 
			 	���ڣ�
			 	 <html:text name="yonghuDataForm" property="daochuriqiStart" styleId="daochuriqiStart" size="10" onclick="WdatePicker1({el:'daochuriqiStart'})" />
				 <img onclick="WdatePicker1({el:'daochuriqiStart'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
			           
			 <%-- 	 <html:button property="btnSave" value="������ͨ����" styleClass="commonButton4" onclick="sub()"/>
			 	 
			 	 ��ʼ��
			 	 <html:text name="yonghuDataForm" property="daochuriqiStart" styleId="daochuriqiStart" size="10" onclick="WdatePicker1({el:'daochuriqiStart'})" readonly="true"/>
				 <img onclick="WdatePicker1({el:'daochuriqiStart'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
			            ������
			     <html:text name="yonghuDataForm" property="daochuriqiEnd" styleId="daochuriqiEnd" size="10" onclick="WdatePicker1({el:'daochuriqiEnd'})" readonly="true"/>
				 <img onclick="WdatePicker1({el:'daochuriqiEnd'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>  
				  --%>
			    </div>
			</div>
			<html:hidden name="yonghuDataForm" property="quyuCodeHidden" />
			<html:hidden name="yonghuDataForm" property="shijianleixingHidden" />
			<html:hidden name="yonghuDataForm" property="addressCodeHidden" />
			<html:hidden name="yonghuDataForm" property="stateCodeHidden" />
			<html:hidden name="yonghuDataForm" property="kaijisHidden" />
			<html:hidden name="yonghuDataForm" property="kaijieHidden" />
			<html:hidden name="yonghuDataForm" property="senValue1Hidden" />
			<html:hidden name="yonghuDataForm" property="sen2Hidden" />
			<html:hidden name="yonghuDataForm" property="senValue2Hidden" />
			<html:hidden name="yonghuDataForm" property="sen3Hidden" />
			<html:hidden name="yonghuDataForm" property="senValue3Hidden" />
			
		</html:form>
	</div>
	<div id="yonghushangchuan" name="yonghushangchuan" >
		<html:form action="dataUpload.do?act=upload" method="post" enctype="multipart/form-data" >
			<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
				<tr>
					<td>�û������ϴ���</td>
					<td><input name="formFile" type="file" size="60"
						class="commonTextFieldHover" 
						onfocus="this.className='commonTextFieldMove'" 
						onblur="this.className='commonTextFieldHover'" />
					
					<html:submit property="telUpload" value="�ϴ�" styleClass="commonButton"></html:submit>
					
					<a href="./yonghushuju/yonghudata.xls">ģ������</a>
					</td>
					</tr>
				</table>
		</html:form>
	</div>
		<html:form action="dataUpload.do?act=comparison" method="post" enctype="multipart/form-data" >
			<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
				<tr>
					<td>�û����ݱȶԣ�</td>
					<td><input name="formFile" type="file" size="60"
						class="commonTextFieldHover" 
						onfocus="this.className='commonTextFieldMove'" 
						onblur="this.className='commonTextFieldHover'" />
					
					<html:submit property="telUpload" value="�ȶ�" styleClass="commonButton"></html:submit>		
				<!-- 	<a href="./yonghushuju/yonghudata.xls">ģ������</a> -->
					</td>
					</tr>
				</table>
		</html:form>
			</body>
	<script type="text/javascript"  language="javascript">
		/*
		*	�鿴��Ƭ
		*/
		function viewphoto(action,code,msg){
			if(checkSelect(code,msg)){
				var group = $("[name='UUID']").filter(":checked");
				var uuid = group.val();
				window.open('<%=basePath%>'+action+'&uuid='+uuid,'newwindow','height='+(window.screen.availHeight-30)+',width='+(window.screen.availWidth-10)+',top=0,left=0,toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
			}
		}
		function  hiddenEditDiv() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			switch (roleCode) {         
			        case '5': 
			 			break;               
			    	 case '4':               
			            document.getElementById("buttonC").style.display="none";  
			            break;  
			         case '8': 
			         		document.getElementById("tietongExport").style.display="none";  
			        	  //document.getElementById("yonghushangchuan").style.display="none";  
			 		    break;   
			} 
		}
		hiddenEditDiv();	
		
		
		function sub() {
			if (checkInput()) {
				commonSubmit('tietongimport.do?act=importTietong');
				//commonSubmit('tietongduizhangimport.do?act=tietongduizhangimport');
			}
	    }
	    
	    checkInput =  function(){
	    	var daochuriqiStart = document.forms[0].daochuriqiStart.value;
			if (daochuriqiStart == null || trim(daochuriqiStart) == "") {
				alert("��ѡ��Ҫ���������ڣ�");
				document.forms[0].daochuriqiStart.focus();// ���ý���
				return false;
			}
			
			/* var daochuriqiEnd = document.forms[0].daochuriqiEnd.value;
			if (daochuriqiEnd == null || trim(daochuriqiEnd) == "") {
				alert("��ѡ��Ҫ�����Ľ������ڣ�");
				document.forms[0].daochuriqiEnd.focus();// ���ý���
				return false;
			}
			
			if (daochuriqiEnd < daochuriqiStart){
				alert("�������ڲ��ܴ��ڿ�ʼ����");
				document.forms[0].daochuriqiEnd.focus();// ���ý���
				return false;
			} */
			return true;
	    };
	</script>
</html>
