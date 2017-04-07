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
<script src="kucun/kucun.js" language="javascript"></script>
<script src="js/business.js" language="javascript"></script>
<jsp:include page="/common/commonMessage.jsp" />
</head>
<body onload="init()">
	<html:form action="shebeirukuList.do">
	<bean:define id="statusList" name="kucunForm" property="statusList"></bean:define>
	<bean:define id="xiaoquList" name="kucunForm" property="xiaoquList"></bean:define>
	<bean:define id="userNameList" name="kucunForm" property="userNameList"></bean:define>
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">�豸�༭</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td valign="top" class="editTableTitle" width="80px">�豸��Ϣ��</td>
							<td class="editTableContent">
								<table>
									<tr>
										<td>
											�豸״̬��
												<html:select style="width:80px" name="kucunForm" property="shebeizhuangtai"
													styleClass="commonTextFieldHover" 
													onfocus="this.className='commonTextFieldMove'" 
													onblur="this.className='commonTextFieldHover'">
													<html:option value="1">δ����</html:option>
													<html:options collection="statusList" property="key" labelProperty="value" />
												</html:select>	
												<a:need /><br/></br>
											&nbsp;&nbsp;&nbsp;&nbsp;��ţ� 
											<html:text name="kucunForm" property="xianghao" size="20" />
											<a:need /></br></br>
											������ڣ�
												<html:text name="kucunForm" property="rukuriqi" styleId="kaijis" size="20" onclick="WdatePicker({el:'kaijis'})" readonly="true"/>
								<img onclick="WdatePicker({el:'kaijis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							    
												<a:need /><br/></br>
											&nbsp;&nbsp;����ˣ�
												<html:select style="width:120px" name="kucunForm" property="rukuren" 
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:options collection="userNameList" property="key" labelProperty="value" />
								    </html:select> <a:need /><br/></br>
											�豸���ͣ� 
												<html:text name="kucunForm" property="shebeileixing" size="20" /><a:need /><br/></br>
											�豸�ͺţ� 
												<html:text name="kucunForm" property="shebeixinghao" size="20" /><a:need /></br></br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MAC��
											    <html:text name="kucunForm" property="mac" size="20" /><a:need /></br></br>
				     &nbsp;&nbsp;&nbsp;&nbsp;MCID�� 
											    <html:text name="kucunForm" property="mcid" size="20" /><a:need /><br/></br>
										</td>
									</tr>
									<tr>
									    <td>&nbsp;&nbsp;&nbsp;&nbsp;��ע�� 
											  <html:textarea name="kucunForm" property="beizhu" rows="5" cols="70">
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
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="sub_updateProduct();" />
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('shebeiyichangkuList.do?act=init')" />
			</div>
		</div>
	<html:hidden name="kucunForm" property="UUIDHidden" />
	<html:hidden name="kucunForm" property="zhuangtaiHidden" styleId="zhuangtai"/>
	</html:form>
	
</body>
<script language="javascript" type="text/javascript">
	function sub_updateProduct() {
		var zhuangtai = document.getElementById("zhuangtai").value;
		if (zhuangtai == 1){
			commonSubmit('shebeirukuList.do?act=init');
		}
		if (zhuangtai == 2){
			commonSubmit('shebeirukuList.do?act=init');
		}
		if (zhuangtai == 3){
			commonSubmit('shebeiEdite.do?act=update_YichangKu&zhuangtai=3');
		}
		//commonSubmit('shebeiEdite.do?act=update_Product');
	}
	
</script>
</html>