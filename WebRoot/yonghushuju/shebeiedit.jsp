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
			<div class="conten_top" name="top">�û��豸����</div>
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
												property="xiaoqu" styleId="xiaoqu"
												styleClass="commonTextFieldHover"
												onchange="selectxiaoqu(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'">
												<html:options collection="xiaoquList" property="key"
													labelProperty="value" />
											</html:select> <a:need />
											�û���ַ�� <html:text name="yonghuDataEntityForm"
												property="dizhi" size="12" maxlength="20"  readonly="true"
												styleClass="commonTextFieldHover" onchange="isture(this)"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>
											�û������� <html:text name="yonghuDataEntityForm"
												property="xingming" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											��ϵ�绰�� <html:text name="yonghuDataEntityForm"
												property="lianxidianhua" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>���֤�ţ� <html:text name="yonghuDataEntityForm"
												property="shenfensheng" size="30" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<!-- 
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td class="editTableTitle" width="30px">������Ϣ��</td>
							<td class="editTableContent">
								<table>
									<tr>
										<td>�û�״̬�� <html:select name="yonghuDataEntityForm" property="yonghuzhuangtai" 
														styleClass="commonTextFieldHover" 
														onfocus="this.className='commonTextFieldMove'" 
														onblur="this.className='commonTextFieldHover'">
														<html:option value="�Ѱ�װ">�Ѱ�װ</html:option>
														<html:option value="��ά��">��ά��</html:option>
														<html:option value="������">������</html:option>
													</html:select>	
													<a:need />
											�վݺţ�<html:text name="yonghuDataEntityForm"
												property="shoujuhao" size="20" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>�ֹ��ߺţ� <html:text name="yonghuDataEntityForm"
												property="fenguangxianhao" size="12" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											����λ�ã� <html:text name="yonghuDataEntityForm"
												property="jiexuweizhi" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>����ʱ�䣺 <html:text name="yonghuDataEntityForm" property="kaijishijian" styleId="paigongriqis" size="10" onclick="WdatePicker({el:'paigongriqis'})" />
								<img onclick="WdatePicker({el:'paigongriqis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">  <a:need />
											ͣ��ʱ�䣺 <html:text name="yonghuDataEntityForm" property="tingjishijian" styleId="paigongriqis" size="10" onclick="WdatePicker({el:'paigongriqis'})" />
								<img onclick="WdatePicker({el:'paigongriqis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">  <a:need />
										</td>
									</tr>
									<tr>
										<td>���磺 <html:text name="yonghuDataEntityForm"
												property="wangluo" size="12" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											���ӣ� <html:text name="yonghuDataEntityForm"
												property="dianshi" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											�绰�� <html:text name="yonghuDataEntityForm"
												property="dianhua" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>ҵ�� <html:text name="yonghuDataEntityForm"
												property="yewu" size="12" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /><a:need />
											�ֹ⣺ <html:text name="yonghuDataEntityForm"
												property="fenguang" size="12" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /><a:need />
										</td>
									</tr>
								</table>
								
							</td>
						</tr>
					</table> -->
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td class="editTableTitle" width="30px">�豸��Ϣ��</td>
							<td class="editTableContent">
								<table>
									<tr>
										<td>Onu mac�� <html:text name="yonghuDataEntityForm"
												property="onumac" size="12" maxlength="20"
												styleClass="commonTextFieldHover"  readonly="true"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /><a:need />
											STB MCID��  <html:text name="yonghuDataEntityForm"
												property="stbmcid" size="12" maxlength="20"
												styleClass="commonTextFieldHover"  readonly="true"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /><a:need />
										</td>
									</tr>
									<tr>
										<td>����IP�� <html:text name="yonghuDataEntityForm"
												property="dianshiip" size="15" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /><a:need />
											����IP�� <html:text name="yonghuDataEntityForm"
												property="wangluoip" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											�绰IP�� <html:text name="yonghuDataEntityForm"
												property="dianhuaip" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
									</tr>
									<tr>
										<td>�绰vlan�� <html:text name="yonghuDataEntityForm"
												property="dianhuavlan" size="15" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
											����vlan�� <html:text name="yonghuDataEntityForm"
												property="wangluovlan" size="15" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> <a:need />
										</td>
										
									</tr>
								</table>
								</td>
						</tr>
					</table>
					<!-- 
								<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td class="editTableTitle" width="30px">������Ϣ��</td>
							<td class="editTableContent">
								<table>
									<tr>
										<td>����ʱ�䣺 <html:text name="yonghuDataEntityForm" property="shangmenshijian" styleId="paigongriqis" size="10" onclick="WdatePicker({el:'paigongriqis'})" />
								<img onclick="WdatePicker({el:'paigongriqis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
											��֤��<html:text name="yonghuDataEntityForm"
												property="danzheng" size="12" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" />
												��ѡ�绰���룺<html:text name="yonghuDataEntityForm"
												property="sxdhhm" size="12" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" />
										</td>
									</tr>
									<tr>
										<td>OnuѺ�� <html:text name="yonghuDataEntityForm"
												property="onuyj" size="15" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											������Ѻ�� <html:text name="yonghuDataEntityForm"
												property="jidingheyj" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
									</tr>
									<tr>
										<td>���ӷѣ� <html:text name="yonghuDataEntityForm"
												property="shoushifei" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											����ѣ� <html:text name="yonghuDataEntityForm"
												property="kuandaifei" size="15" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											��װ�ѣ� <html:text name="yonghuDataEntityForm"
												property="chuzhuangfei" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
										
									</tr>
									<tr>
										<td>��Ӫ�̣� <html:text name="yonghuDataEntityForm"
												property="yunyingshang" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											�����¹��ѣ� <html:text name="yonghuDataEntityForm"
												property="bzygf" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											��ѣ� <html:text name="yonghuDataEntityForm"
												property="nianfei" size="15" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
										
									</tr>
									<tr>
										<td>��ע�� <html:text name="yonghuDataEntityForm"
												property="beizhu" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											���շѣ� <html:text name="yonghuDataEntityForm"
												property="zongshoufei" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
										
									</tr>
									<tr>
										<td>�վݱ���/�վݺţ� <html:text name="yonghuDataEntityForm"
												property="shoujubenhao" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											�����豸ʹ������� <html:text name="yonghuDataEntityForm"
												property="qtsbsyqk" size="15" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
										
									</tr>
									<tr>
										<td>�����Ĳģ� <html:text name="yonghuDataEntityForm"
												property="qitahaocai" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											�����ӣ� <html:text name="yonghuDataEntityForm"
												property="jiexianzi" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											RJ11�� <html:text name="yonghuDataEntityForm"
												property="rj11" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											RJ45�� <html:text name="yonghuDataEntityForm"
												property="rj45" size="15" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
										
									</tr>
									<tr>
										<td>ģ�飺 <html:text name="yonghuDataEntityForm"
												property="mokuai" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											��壺 <html:text name="yonghuDataEntityForm"
												property="mianban" size="15" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											���ߣ� <html:text name="yonghuDataEntityForm"
												property="wangxian" size="15" maxlength="20"
												styleClass="commonTextFieldHover" 
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											
										</td>
										
									</tr>
									<tr>
										<td>ʩ���ˣ� <html:text name="yonghuDataEntityForm"
												property="mokuai" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
											�ֳ���ע�� <html:text name="yonghuDataEntityForm"
												property="xianchangbeizhu" size="15" maxlength="20"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> 
										</td>
										
									</tr>
									<tr>
										<td>��ע���ܣ� 
												<html:textarea name="yonghuDataEntityForm" property="beizhuhuizong"  
										rows="5" cols="70"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
									</html:textarea>
										</td>
										
									</tr>
								</table>
								 -->
							</td>
						</tr>

					</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="subs();" />
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('yonghuDataList.do?act=init')" />
			</div>
		</div>
		<html:hidden name="yonghuDataEntityForm" property="UUID" />
	</html:form>
</body>
<script type="text/javascript">
	function subs() {
		if (checkInput()) {
			commonSubmit('yonghuDataEdit.do?act=updateShebeiData');
		}
	}
</script>
</html>