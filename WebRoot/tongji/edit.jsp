<!---->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>���ٿ��������ʾ��Ŀ</title>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/common.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
	<body onload="init()">
		<html:form action="tongjiEdit.do">
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">
				�ص�¼��
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="940px">
					<tr>
						<td class="editTableTitle">С�����ƣ�</td>
						<td class="editTableContent">
							<html:text name="chugongdanEditForm" property="xiaoquname" readonly="true"
								styleClass="commonTextFieldHover"  
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" maxlength="6"/>
						</td>
					</tr>
					<tr>
						<td class="editTableTitle" >�û�������</td>
						<td class="editTableContent" >
						<html:text name="chugongdanEditForm" property="xingming" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" maxlength="6"/>
							
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >֤���ţ�</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="zhengjianhao" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >�վݺţ�</td>
						<td class="editTableContent" >
						<html:text name="chugongdanEditForm" property="shoujuhao"  styleId="shoujuhao" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >�ֹ����ţ�</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="fenguangqihao" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >onuע��λ�ã�</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="onuzhuce" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >���ţ�</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="fanghao" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >����ʱ�䣺</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="kaijishijian" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >ͣ��ʱ�䣺</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="tingjishijian" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >�����</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="kandai" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >���ӣ�</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianshi" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >�绰��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianhua" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >�û�����</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="yonghuming" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >���룺</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="mima" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >�̶��绰��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="guhua" maxlength="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr><tr >
						<td class="editTableTitle" >��ϵ�绰��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="lainxidianhua" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >����λ�ã�</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="jiguiweizhi" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >onu��Ϣ��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="onumac" maxlength="18"
								styleClass="commonTextFieldHover" readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >������mcid��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="jidinghemac" maxlength="40"
								styleClass="commonTextFieldHover"  readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						</td>
					</tr>
					
					<tr  id="ip1" style="display: none">
						<td class="editTableTitle" >����ip1��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianshiip" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr  id="ip2" style="display: none">
						<td class="editTableTitle" >����ip2��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianshiip2" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr  id="ip3" style="display: none">
						<td class="editTableTitle" >����ip3��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianshiip3" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr  id="ip4" style="display: none">
						<td class="editTableTitle" >����ip4��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianshiip4" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >���ip��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="kuandaiip" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
						<tr >
						<td class="editTableTitle" >�绰ip��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianhuaip" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >�绰vlan��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianhuavlan" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >����vlan��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="wangluovlan" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr><tr >
						<td class="editTableTitle" >����vlan��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianshivlan" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
						</tr><tr >
						<td class="editTableTitle" >������Ӫ��vlan��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="qitivlan" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
						<tr >
						<td class="editTableTitle" >��ע��</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="beizhu" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
						<html:hidden name="chugongdanEditForm" property="dianshi" styleId="dianshi"/>
					</tr>
				</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="����" styleClass="commonButton" onclick="commonSubmit('tongjiEdit.do?act=insert')"/>
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('tongjiList.do?act=init')"/>
			</div>
		</div>
		<html:hidden name="chugongdanEditForm" property="UUID" />
		</html:form>
	</body>
	<script type="text/javascript">

	
	show = function(){
		dianshiNum = document.getElementById("dianshi").value;
		if(dianshiNum==1){
			document.getElementById("ip1").style.display="";
			}
		else if(dianshiNum==2){
			document.getElementById("ip1").style.display="";
			document.getElementById("ip2").style.display="";
		}
		else if(dianshiNum==3){
			document.getElementById("ip1").style.display="";
			document.getElementById("ip2").style.display="";
			document.getElementById("ip3").style.display="";
		}
		else if(dianshiNum==4){
			document.getElementById("ip1").style.display="";
			document.getElementById("ip2").style.display="";
			document.getElementById("ip3").style.display="";
			document.getElementById("ip4").style.display="";
		}
		}
	show();
	</script>
</html>