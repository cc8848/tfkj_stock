<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2013-03-29     Zhang,Dong-Yu     Create
   
  -->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<title>���ٿ��������ʾ��Ŀ</title>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<link href="css/common.css" type="text/css" rel="stylesheet" />
<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
<script src="js/validate.js" language="javascript"></script>
<script src="js/common.js" language="javascript"></script>
<script src="js/jquery.js" language="javascript"></script>
<script src="js/popupBox.js" language="javascript"></script>
<script src="huidan/huidan.js" language="javascript"></script>
<script src="js/business.js" language="javascript"></script>
<jsp:include page="/common/commonMessage.jsp" />
</head>
<body onload="init()">
	<html:form action="huidandaoruList.do">
	<bean:define id="xiaoquList" name="HuidanForm" property="xiaoquList"></bean:define>
	<bean:define id="wangluoList" name="HuidanForm" property="wangluoList"></bean:define>
	<bean:define id="radiusXiaoquList" name="HuidanForm" property="radiusXiaoquList"></bean:define>
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">���ӵ��·�</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td valign="top" class="editTableTitle" width="80px">ע��Radius�û���Ϣ��
							<br/>	<br/>
							<span style="color: red;">�����Ϊ����ҵ��,��ֱ���·�</span>
							</td>
							<td class="editTableContent">
								<table>
									<tr>
									    <td></>����ʱ��:(yyyy-MM-dd)
												<html:text name="HuidanForm" property="kaijis" styleId="kaijis" size="20" onclick="WdatePicker({el:'kaijis'})" />
								<img onclick="WdatePicker({el:'kaijis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
												<a:need /></img></td></tr>
										<tr><td></>ͣ��ʱ��:(yyyy-MM-dd)
												<html:text name="HuidanForm" property="tingjis" styleId="tingjis" size="20" onclick="WdatePicker({el:'tingjis'})" />
								<img onclick="WdatePicker({el:'tingjis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
												<a:need /></img></td></tr>
										
										
										<tr>
											<td>
											<br/> 
										        radius�Ʒѹ���
										        <html:select
												 name="HuidanForm" property="radiusShiChang"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'">
												  <html:option value="">-��ѡ��-</html:option>
												  <html:options collection="wangluoList" property="key"
													labelProperty="value" />
											    </html:select> <a:need />
											    
										  <br/>
									  	  </td>
									    </tr>
									    
									    <tr>
											<td>
											<br/> 
										        radiusС����
										        <html:select
												name="HuidanForm" property="iDistID"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'">
												  <html:option value="">-��ѡ��-</html:option>
												  <html:options collection="radiusXiaoquList" property="key"
													labelProperty="value" />
											    </html:select> <a:need />
											    
										  <br/>
									  	  </td>
									    </tr>
											<tr><td> 
												Radius�û����� 
												<html:text name="HuidanForm" property="radiusUserName" size="20" />
												<a:need />
												</br> 
												
												Radius�û����룺 <html:text name="HuidanForm" property="radiusPassword" size="20" />
												<a:need />
												</br> 
												
												��ͨ���ͣ� <html:select
												style="width:120px" name="HuidanForm" property="isLaster"
												styleClass="commonTextFieldHover" onclick="showTime(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'">
												  <html:option value="">-��ѡ��-</html:option>
												  <html:option value="0">��һ�����߿�ͨ</html:option>
												  <html:option value="2">���̿�ͨ </html:option>
												  <html:option value="1" >ָ��ʱ�俪ͨ </html:option>
											    </html:select> 
											       <a:need />
												    <html:text name="HuidanForm" property="laterYMD" styleId="laterYMD" size="20" onclick="WdatePicker({el:'laterYMD'})" style="display: none;"/>
													<img onclick="WdatePicker({el:'laterYMD'})"  id="laterYMD1"
													src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" style="display: none;"
													width="16" height="22" align="absmiddle"/>
												</br> 
												<script type="text/javascript">
													function showTime(s){
														if(s.value == 1) {
															document.getElementById('laterYMD').style.display="";
															document.getElementById('laterYMD1').style.display="";
														} else {
															document.getElementById('laterYMD').style.display="none";
															document.getElementById('laterYMD1').style.display="none";
														}
													}
													
												</script>
												
												&nbsp;&nbsp;&nbsp;&nbsp;���ӣ� <html:text name="HuidanForm"
												property="dianshi" size="20" /><a:need />
												</br> 
												
												&nbsp;&nbsp;&nbsp;&nbsp;�绰�� <html:text name="HuidanForm"
												property="dianhua" size="20" /><a:need />
												</br> 
												
												&nbsp;&nbsp;&nbsp;&nbsp;ҵ�� <html:text name="HuidanForm"
												property="yewu" size="20" /><a:need />
												</br> 
												
												&nbsp;&nbsp;&nbsp;&nbsp;�ֹ⣺ <html:text name="HuidanForm"
												property="fenguang" size="20" /><a:need />
												</br> 
												
												&nbsp;onu MAC�� <html:text name="HuidanForm"
												property="onuCode" size="20" /><a:need />
												</br> stb MCID�� <html:text name="HuidanForm"
												property="mcidCode" size="20" /><a:need />
												</br> 
												
												&nbsp;&nbsp;����ip�� <html:text name="HuidanForm"
												property="dianshiip" size="20" /><a:need />
												</br> 
												
												&nbsp;&nbsp;����ip�� <html:text name="HuidanForm"
												property="wangluoip" size="20" /><a:need />
												</br> 
												
												&nbsp;&nbsp;�绰ip�� <html:text name="HuidanForm"
												property="dianhuaip" size="20" /><a:need />
												</br> �绰vlan�� <html:text name="HuidanForm"
												property="dianhuavlan" size="20" /><a:need />
												</br> ����vlan�� <html:text name="HuidanForm"
												property="wangluovlan" size="20" /><a:need />
												</br> ����ʱ�䣺 <html:text name="HuidanForm"
												property="shangmenshijian" size="20" /><a:need />
												</br> &nbsp;&nbsp;&nbsp;&nbsp;��֤�� <html:text name="HuidanForm"
												property="danzheng" size="20" /><a:need />
												</br> ��ѡ�绰�� <html:text name="HuidanForm"
												property="sxdhhm" size="20" /><a:need />
												</br> &nbsp;onuѺ�� <html:text name="HuidanForm"
												property="onuyj" size="20" /><a:need />
												</br> ������Ѻ��:<html:text name="HuidanForm"
												property="jidingheyj" size="20" /><a:need />
												</br> &nbsp;&nbsp;���ӷѣ� <html:text name="HuidanForm"
												property="shoushifei" size="20" /><a:need />
												</br> &nbsp;&nbsp;����ѣ� <html:text name="HuidanForm"
												property="kuandaifei" size="20" /><a:need />
												</br> &nbsp;&nbsp;��װ�ѣ� <html:text name="HuidanForm"
												property="chuzhuangfei" size="20" /><a:need />
												</br> �豸���۷�:<html:text name="HuidanForm"
												property="shebeixiaoshoufei" size="20" /><a:need />
												</br> &nbsp;&nbsp;���Ϸѣ� <html:text name="HuidanForm"
												property="cailiaofei" size="20" /><a:need />
												</br> &nbsp;&nbsp;��Ӫ�̣� <html:text name="HuidanForm"
												property="yunyingshang" size="20" /><a:need />
												</br> �����¹���:<html:text name="HuidanForm"
												property="bzygf" size="20" /><a:need />
												</br> &nbsp;&nbsp;&nbsp;&nbsp;��ѣ� <html:text name="HuidanForm"
												property="nianfei" size="20" /><a:need />
												</br> ��ע���ܣ�onu���/��������ţ��� <html:text name="HuidanForm"
												property="beizhuhuizong" size="20" /><a:need />
											</td>
									</tr>
									<tr>
									    <td>��ע�� 
											  <html:textarea name="HuidanForm" property="beizhu" rows="5" cols="70">
									          </html:textarea>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="�·�" styleClass="commonButton" onclick="sub_updateHuidan();" />
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('huidandaoruList.do?act=init')" />
			</div>
		</div>
	<html:hidden name="HuidanForm" property="UUIDHidden" />
	</html:form>
	<!-- 
	if(check_huidan()){
	                  commonSubmit('huidandaoruList.do?act=update_Huidan')
	         }else{
	         alert('no');
	         }
	 -->
</body>
</html>