<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2013-04-02     Zhang,Dong-Yu     Create
   
  -->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>��ע��д</title>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<link href="css/common.css" type="text/css" rel="stylesheet" />
<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
<script src="js/common.js" language="javascript"></script>
<script src="js/validate.js" language="javascript"></script>
<script src="js/jquery.js" language="javascript"></script>
<script src="js/popupBox.js" language="javascript"></script>
<script src="js/business.js" language="javascript"></script>
<script src="huidan/huidan.js" language="javascript"></script>
<jsp:include page="/common/commonMessage.jsp" />
<style>
form {
	padding: 0;
	margin: 0;
	border: 0
}
</style>
</head>
<body onload="init()">
<div style="height:80px;">
	<html:form action="huidanerrorList.do">
	   <bean:define id="xiaoquList" name="HuidanForm" property="xiaoquList"></bean:define>
		<table>
			<tr align="right">
				<td>�û�״̬:<html:text name="HuidanForm" property="yonghuzhuangtai" size="20" readonly="true" />
				</td>
				<td>����ʱ��:<img onclick="WdatePicker({el:'kaijis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
				<html:text name="HuidanForm" property="kaijis" styleId="kaijis" size="10" onclick="WdatePicker({el:'kaijis'})" />
				</td>
				<td>ͣ��ʱ��: <img onclick="WdatePicker({el:'tingjis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
				<html:text name="HuidanForm" property="tingjis" styleId="tingjis" size="10" onclick="WdatePicker({el:'tingjis'})" />
				</td>
				<td>С��:
				<html:select name="HuidanForm" property="xiaoqu"
									styleClass="commonTextFieldHover"
									onfocus="this.className='commonTextFieldMove'"
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:options collection="xiaoquList" property="key"
										labelProperty="value" />
								</html:select>
				</td>
			</tr>
			<tr align="right">
			    <td>��ַ: <html:text name="HuidanForm" property="dizhi" size="20" />
				</td>
				<td>��ϵ�绰�� <html:text name="HuidanForm" property="telNoCode" size="20" />
				</td>
				<td>����:<html:text name="HuidanForm" property="wangluo" size="20" />
				</td>
				<td>����:<html:text name="HuidanForm" property="dianshi" size="20" />
				</td>
			</tr>
			<tr align="right">
			    <td>�绰�� <html:text name="HuidanForm" property="dianhua" size="20" />
				</td>
				<td>ҵ�� <html:text name="HuidanForm" property="yewu" size="20" />
				</td>
				<td>�ֹ�:<html:text name="HuidanForm" property="fenguang" size="20" />
				</td>
				<td>Onu MAC:<html:text name="HuidanForm" property="onuCode" size="20" />
				</td>
			</tr>
			<tr align="right">
			    <td>STB MCID: <html:text name="HuidanForm" property="mcidCode" size="20" />
				</td>
				<td>����IP:<html:text name="HuidanForm" property="dianshiip" size="20" />
				</td>
				<td>����IP:<html:text name="HuidanForm" property="wangluoip" size="20" />
				</td>
				<td>�绰IP:<html:text name="HuidanForm" property="dianhuaip" size="20" />
				</td>
			</tr>
			<tr align="right">
			    <td>�绰VLAN: <html:text name="HuidanForm" property="dianhuavlan" size="20" />
				</td>
				<td>����VLAN:<html:text name="HuidanForm" property="wangluovlan" size="20" />
				</td>
				<td>����ʱ��: 
					<html:text name="HuidanForm" property="shangmenshijian" size="20" />
				</td>
				<td>��֤:<html:text name="HuidanForm" property="danzheng" size="20" />
				</td>
			</tr>
			<tr align="right">
				<td>��ѡ�绰����:<html:text name="HuidanForm" property="sxdhhm" size="20" />
				</td>
				<td>ONUѺ��:<html:text name="HuidanForm" property="onuyj" size="20" />
				</td>
				<td>������Ѻ��:<html:text name="HuidanForm" property="jidingheyj" size="20" />
				</td>
				<td>���ӷ�:<html:text name="HuidanForm" property="shoushifei" size="20" />
				</td>
			</tr>
			<tr align="right">
			    <td>�����:<html:text name="HuidanForm" property="kuandaifei" size="20" />
				</td>
				<td>��װ��:<html:text name="HuidanForm" property="chuzhuangfei" size="20" />
				</td>
				<td>�豸���۷�:<html:text name="HuidanForm" property="shebeixiaoshoufei" size="20" />
				</td>
				<td>���Ϸ�:<html:text name="HuidanForm" property="cailiaofei" size="20" />
			</tr>
			<tr align="right">
			        </td>
				    <td>��Ӫ��:<html:text name="HuidanForm" property="yunyingshang" size="20" />
				    </td>
				    <td>�����¹���:<html:text name="HuidanForm" property="bzygf" size="20" />
				    </td>
				    <td>���: <html:text name="HuidanForm" property="nianfei" size="20" />
				    </td>
				    <td>ʩ����:<html:text name="HuidanForm" property="shigongren" size="20" />
					</td>
			    </tr>
				<tr align="right">
				    <td>�տ�ʱ��:
						<img onclick="WdatePicker({el:'shoukuanshijian'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle" /> 
					    <html:text  name="HuidanForm" property="shoukuanshijian" styleId="shoukuanshijian" size="20" onclick="WdatePicker({el:'shoukuanshijian'})"  />
					</td>
					<td>�û�����:<html:text name="HuidanForm" property="xingming" size="20" />
					</td>
					<td>���֤��:<html:text name="HuidanForm" property="shenfenzheng" size="20" />
					</td>
					<td>�ֹ��ߺ�:<html:text name="HuidanForm" property="fenguangxianhao" size="20" />
					</td>
				</tr>
				<tr align="right">
				    <td>����λ��:<html:text name="HuidanForm" property="jiexuweizhi" size="20" />
					</td>
					<td>���շ�:<html:text name="HuidanForm" property="zongshoufei" size="20" />
					</td>
					<td>�վݱ���/�վݺ�:<html:text name="HuidanForm" property="shoujubenhao" size="20" />
					</td>
					<td>��Ʊ��Ϣ:<html:text name="HuidanForm" property="kaipiaoxinxi" size="20" />
					</td>
				</tr>
				<tr align="right">
					<td>�����豸ʹ�����:<html:text name="HuidanForm" property="qtsbsyqk" size="20" />
					</td>
					<td>�����Ĳ�:<html:text name="HuidanForm" property="qitahaocai" size="20" />
					</td>
					<td>������:(����д����) <html:text name="HuidanForm" property="jiexianzi" size="20" />
					</td>
					<td>RJ11:(����д����) <html:text name="HuidanForm" property="rj11" size="10" />
					</td>
				</tr>
				<tr align="right">
				    <td>RJ45:(����д����) <html:text name="HuidanForm" property="rj45" size="20" />
					</td>
					<td>ģ��:(����д����) <html:text name="HuidanForm" property="mokuai" size="20" />
					</td>
					<td>���:(����д����) <html:text name="HuidanForm" property="mianban" size="20" />
					</td>
					<td>����:(����д����) <html:text name="HuidanForm" property="wangxian" size="10" />
					</td>
				</tr>
				<tr>	
					<td>�ֳ���ע:<html:textarea name="HuidanForm" property="xianchangbeizhu" rows="6" cols="30" />
					</td>
					<td>��ע:<html:textarea name="HuidanForm" property="beizhu" rows="6" cols="30" />
					</td>
					<td>��ע����:<html:textarea name="HuidanForm" property="beizhuhuizong" rows="6" cols="30" />
					</td>
					<td colspan="2">
					    <input type="button" value="����" onclick="checkDate()" /> 
			            <input type="button" value="����" onclick="commonSubmit('huidancheckList.do?act=init')" />
					</td>
				</tr>
				<html:hidden name="HuidanForm" property="UUIDHidden" />
			</table>
		</html:form>
	</div>
	<script language="javascript">
	//��֤���ڵ�������ʽ
	pattern3=/^[1,2][0-9]{3}-[0-9]{2}-[0-9]{2}$/;
	function checkDate() {
		var kaijis = document.getElementById("kaijis").value;
		if(!pattern3.test(kaijis)){
			alert("����ʱ���ʽ�������������룡");
			return false;
		}
		var tingjis = document.getElementById("tingjis").value;
		if(!pattern3.test(tingjis)){
			alert("ͣ��ʱ���ʽ�������������룡");
			return false;
		}
		var shoukuanshijian = document.getElementById("shoukuanshijian").value;
		if(!pattern3.test(shoukuanshijian)){
			alert("�տ�ʱ���ʽ�������������룡");
			return false;
		}
		commonSubmit('huidancheckList.do?act=edit_save');
		return true;
	}
	
	</script>
</body>

</html>