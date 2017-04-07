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
<script src="yonghushuju/yonghuData.js" language="javascript"></script>
<script src="js/business.js" language="javascript"></script>
<jsp:include page="/common/commonMessage.jsp" />
</head>
<body onload="init()">
	<html:form action="yonghuDataEdit.do">
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">�û���������</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td class="editTableTitle" width="30px">�û���Ϣ��</td>
							<td class="editTableContent">
								<table>
									<tr>
										<td>
											С�����ƣ� <html:select name="yonghuDataEntityForm"
												property="xiaoqu" styleId="xiaoqu" disabled="true"
												styleClass="commonTextFieldHover"
												onchange="selectxiaoqu(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'">
												<html:options collection="xiaoquList" property="key"
													labelProperty="value" />
											</html:select> <a:need />
											�û���ַ�� <html:text name="yonghuDataEntityForm"
												property="dizhi" size="12" maxlength="20" disabled="true"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>
											�û������� <html:text name="yonghuDataEntityForm"
												property="xingming" size="12" maxlength="20"
												styleClass="commonTextFieldHover" disabled="true"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											��ϵ�绰�� <html:text name="yonghuDataEntityForm"
												property="lianxidianhua" size="12" maxlength="20"
												styleClass="commonTextFieldHover" disabled="true"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>���֤�ţ� <html:text name="yonghuDataEntityForm"
												property="shenfensheng" size="30" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'" disabled="true"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td class="editTableTitle" width="30px">������Ϣ��</td>
							<td class="editTableContent">
								<table>
									<tr>
										<td>�û�״̬�� <html:select name="yonghuDataEntityForm" property="yonghuzhuangtai" 
														styleClass="commonTextFieldHover"  disabled="true"
														onfocus="this.className='commonTextFieldMove'" 
														onblur="this.className='commonTextFieldHover'">
														<html:option value="�Ѱ�װ">�Ѱ�װ</html:option>
														<html:option value="��ά��">��ά��</html:option>
														<html:option value="������">������</html:option>
														<html:option value="���˶�">���˶�</html:option>
														<html:option value="�Ѳ��">�Ѳ��</html:option>
														<html:option value="������">������</html:option>
														<html:option value="ͣ������">ͣ������</html:option>
													</html:select>	
													<a:need />
											ƥ��״̬�� <html:select name="yonghuDataEntityForm" property="pipeizhuangtai" 
												styleClass="commonTextFieldHover"  disabled="true"
												onfocus="this.className='commonTextFieldMove'" 
												onblur="this.className='commonTextFieldHover'">
												<html:option value=""></html:option>
												<html:option value="��ƥ��">��ƥ��</html:option>
												<html:option value="δƥ��">δƥ��</html:option>
											</html:select>	
											<a:need />
											
											 �տ�ʱ�䣺 <html:text name="yonghuDataEntityForm" disabled="true" property="shoukuanshijian" styleId="shoukuanshijian" size="10" onclick="WdatePicker({el:'shoukuanshijian'})" />
								<img onclick="WdatePicker({el:'shoukuanshijian'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">  <a:need />
											</img><br/>
											�վݺţ�<html:text name="yonghuDataEntityForm" disabled="true"
												property="shoujuhao" size="20" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>�ֹ��ߺţ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="fenguangxianhao" size="12" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											����λ�ã� <html:text name="yonghuDataEntityForm" disabled="true"
												property="jiexuweizhi" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>����ʱ�䣺 <html:text name="yonghuDataEntityForm" disabled="true" property="kaijishijian" styleId="paigongriqis" size="10" onclick="WdatePicker({el:'paigongriqis'})" />
								<img onclick="WdatePicker({el:'paigongriqis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">  <a:need />
											ͣ��ʱ�䣺 <html:text name="yonghuDataEntityForm" disabled="true" property="tingjishijian" styleId="paigongriqis" size="10" onclick="WdatePicker({el:'paigongriqis'})" />
								<img onclick="WdatePicker({el:'paigongriqis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">  <a:need />
										</td>
									</tr>
									<tr>
										<td>���磺 <html:text name="yonghuDataEntityForm" disabled="true"
												property="wangluo" size="12" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											���ӣ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="dianshi" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											�绰�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="dianhua" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>ҵ�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="yewu" size="12" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											�ֹ⣺ <html:text name="yonghuDataEntityForm" disabled="true"
												property="fenguang" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
								</table>
								
							</td>
						</tr>
					</table>
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td class="editTableTitle" width="30px">�豸��Ϣ��</td>
							<td class="editTableContent">
								<table>
									<tr>
										<td>Onu mac�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="onumac" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											STB MCID��  <html:text name="yonghuDataEntityForm"
												property="stbmcid" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /><a:need />
										</td>
									</tr>
									<tr>
										<td>����IP�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="dianshiip" size="12" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											����IP�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="wangluoip" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											�绰IP�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="dianhuaip" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>�绰vlan�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="dianhuavlan" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											����vlan�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="wangluovlan" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
										
									</tr>
								</table>
								</td>
						</tr>
					</table>
								<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td class="editTableTitle" width="30px">������Ϣ��</td>
							<td class="editTableContent">
								<table>
									<tr>
										<td>����ʱ�䣺 <html:text name="yonghuDataEntityForm" disabled="true" property="shangmenshijian" styleId="paigongriqis" size="10" onclick="WdatePicker({el:'paigongriqis'})" />
								<img onclick="WdatePicker({el:'paigongriqis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
											��֤��<html:text name="yonghuDataEntityForm" disabled="true"
												property="danzheng" size="12" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" />
												��ѡ�绰���룺<html:text name="yonghuDataEntityForm" disabled="true"
												property="sxdhhm" size="12" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" />
										</td>
									</tr>
									<tr>
										<td>OnuѺ�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="onuyj" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											������Ѻ�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="jidingheyj" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
									</tr>
									<tr>
										<td>���ӷѣ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="shoushifei" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											����ѣ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="kuandaifei" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											��װ�ѣ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="chuzhuangfei" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <br/>
											�豸���۷ѣ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="shebeixiaoshou" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											���Ϸѣ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="cailiaofei" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
										
									</tr>
									<tr>
										<td>��Ӫ�̣� <html:text name="yonghuDataEntityForm" disabled="true"
												property="yunyingshang" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											�����¹��ѣ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="bzygf" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											��ѣ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="nianfei" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
										
									</tr>
									<tr>
										<td>��ע�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="beizhu" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											���շѣ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="zongshoufei" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
										
									</tr>
									<tr>
										<td>�վݱ���/�վݺţ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="shoujubenhao" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											��Ʊ��Ϣ�� 
												<html:textarea name="yonghuDataEntityForm" property="kaipiaoxinxi"   disabled="true"
													rows="5" cols="70"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
												</html:textarea>
										</td>
										
									</tr>
									<tr>
									
										<td>�����豸ʹ������� <html:text name="yonghuDataEntityForm" disabled="true"
												property="qtsbsyqk" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
									                    �����Ĳģ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="qitahaocai" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <br/>
											�����ӣ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="jiexianzi" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											RJ11�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="rj11" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											RJ45�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="rj45" size="15" maxlength="20" 
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
										
									</tr>
									<tr>
										<td>ģ�飺 <html:text name="yonghuDataEntityForm" disabled="true"
												property="mokuai" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											��壺 <html:text name="yonghuDataEntityForm" disabled="true"
												property="mianban" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											���ߣ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="wangxian" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											
										</td>
										
									</tr>
									<tr>
										<td>ʩ���ˣ� <html:text name="yonghuDataEntityForm" disabled="true"
												property="shigongren" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											�ֳ���ע�� <html:text name="yonghuDataEntityForm" disabled="true"
												property="xianchangbeizhu" size="15" maxlength="20"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
										
									</tr>
									<tr>
										<td>��ע���ܣ� 
												<html:textarea name="yonghuDataEntityForm" property="beizhuhuizong"   disabled="true"
										rows="5" cols="70"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
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
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="back();" />
			</div>
		</div>
		<html:hidden name="yonghuDataEntityForm" property="UUID" />
	</html:form>
</body>
<script type="text/javascript"  language="javascript">
		function  back() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			switch (roleCode) {         
			        case '5': 
			            commonSubmit('weixiuDataList.do?act=init');
			 			break;               
			    	 case '4':               
			            commonSubmit('weixiuDataYunweiList.do?act=init');
			            break;       
			} 
}
	</script>
</html>