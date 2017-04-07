<!---->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>快速开发框架演示项目</title>
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
			<!-- 标题 -->
			<div class="conten_top" name="top">
				回单录入
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="940px">
					<tr>
						<td class="editTableTitle">小区名称：</td>
						<td class="editTableContent">
							<html:text name="chugongdanEditForm" property="xiaoquname" readonly="true"
								styleClass="commonTextFieldHover"  
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" maxlength="6"/>
						</td>
					</tr>
					<tr>
						<td class="editTableTitle" >用户姓名：</td>
						<td class="editTableContent" >
						<html:text name="chugongdanEditForm" property="xingming" readonly="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" maxlength="6"/>
							
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >证件号：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="zhengjianhao" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >收据号：</td>
						<td class="editTableContent" >
						<html:text name="chugongdanEditForm" property="shoujuhao"  styleId="shoujuhao" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >分光器号：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="fenguangqihao" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >onu注册位置：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="onuzhuce" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >房号：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="fanghao" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >开机时间：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="kaijishijian" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >停机时间：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="tingjishijian" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >宽带：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="kandai" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >电视：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianshi" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >电话：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianhua" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >用户名：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="yonghuming" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >密码：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="mima" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >固定电话：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="guhua" maxlength="30"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr><tr >
						<td class="editTableTitle" >联系电话：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="lainxidianhua" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >机柜位置：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="jiguiweizhi" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >onu信息：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="onumac" maxlength="18"
								styleClass="commonTextFieldHover" readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >机顶盒mcid：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="jidinghemac" maxlength="40"
								styleClass="commonTextFieldHover"  readonly="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						</td>
					</tr>
					
					<tr  id="ip1" style="display: none">
						<td class="editTableTitle" >电视ip1：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianshiip" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr  id="ip2" style="display: none">
						<td class="editTableTitle" >电视ip2：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianshiip2" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr  id="ip3" style="display: none">
						<td class="editTableTitle" >电视ip3：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianshiip3" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr  id="ip4" style="display: none">
						<td class="editTableTitle" >电视ip4：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianshiip4" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					
					<tr >
						<td class="editTableTitle" >宽带ip：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="kuandaiip" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
						<tr >
						<td class="editTableTitle" >电话ip：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianhuaip" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >电话vlan：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianhuavlan" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >网络vlan：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="wangluovlan" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr><tr >
						<td class="editTableTitle" >电视vlan：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="dianshivlan" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
						</tr><tr >
						<td class="editTableTitle" >其他运营商vlan：</td>
						<td class="editTableContent" >
							<html:text name="chugongdanEditForm" property="qitivlan" maxlength="18"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
						<tr >
						<td class="editTableTitle" >备注：</td>
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
				<html:button property="btnSave" value="保存" styleClass="commonButton" onclick="commonSubmit('tongjiEdit.do?act=insert')"/>
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('tongjiList.do?act=init')"/>
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