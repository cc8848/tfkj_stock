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
<title>备注填写</title>
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
				<td>用户状态:<html:text name="HuidanForm" property="yonghuzhuangtai" size="20" disabled="true" />
				</td>
				<td>开机时间:<html:text name="HuidanForm" property="kaijis" size="20" disabled="true" />
				<td>停机时间:<html:text name="HuidanForm" property="tingjis" size="20" disabled="true" />
				<td>小区:<html:text name="HuidanForm" property="xiaoqu" size="20" disabled="true" />
				</td>
			</tr>
			<tr align="right">
			    <td>地址: <html:text name="HuidanForm" property="dizhi" size="20" disabled="true" />
				</td>
				<td>联系电话： <html:text name="HuidanForm" property="telNoCode" size="20" disabled="true" />
				</td>
				<td>网络:<html:text name="HuidanForm" property="wangluo" size="20" disabled="true" />
				</td>
				<td>电视:<html:text name="HuidanForm" property="dianshi" size="20" disabled="true" />
				</td>
			</tr>
			<tr align="right">
			    <td>电话： <html:text name="HuidanForm" property="dianhua" size="20" disabled="true" />
				</td>
				<td>业务： <html:text name="HuidanForm" property="yewu" size="20" disabled="true" />
				</td>
				<td>分光:<html:text name="HuidanForm" property="fenguang" size="20" disabled="true" />
				</td>
				<td>Onu MAC:<html:text name="HuidanForm" property="onuCode" size="20" disabled="true" />
				</td>
			</tr>
			<tr align="right">
			    <td>STB MCID: <html:text name="HuidanForm" property="mcidCode" size="20" disabled="true" />
				</td>
				<td>电视IP:<html:text name="HuidanForm" property="dianshiip" size="20" disabled="true" />
				</td>
				<td>网络IP:<html:text name="HuidanForm" property="wangluoip" size="20" disabled="true" />
				</td>
				<td>电话IP:<html:text name="HuidanForm" property="dianhuaip" size="20" disabled="true" />
				</td>
			</tr>
			<tr align="right">
			    <td>电话VLAN: <html:text name="HuidanForm" property="dianhuavlan" size="20" disabled="true" />
				</td>
				<td>网络VLAN:<html:text name="HuidanForm" property="wangluovlan" size="20" disabled="true" />
				</td>
				<td>上门时间:<html:text name="HuidanForm" property="shangmenshijian" size="20" disabled="true" />
				<td>单证:<html:text name="HuidanForm" property="danzheng" size="20" disabled="true" />
				</td>
			</tr>
			<tr align="right">
				<td>所选电话号码:<html:text name="HuidanForm" property="sxdhhm" size="20" disabled="true" />
				</td>
				<td>ONU押金:<html:text name="HuidanForm" property="onuyj" size="20" disabled="true" />
				<html:checkbox property="checks" name="HuidanForm" value="1" />
				</td>
				<td>机顶盒押金:<html:text name="HuidanForm" property="jidingheyj" size="20" disabled="true" />
				<html:checkbox property="checks" name="HuidanForm" value="2" />
				</td>
				<td>收视费:<html:text name="HuidanForm" property="shoushifei" size="20" disabled="true" />
				<html:checkbox property="checks" name="HuidanForm" value="3" />
				</td>
			</tr>
			<tr align="right">
			    <td>宽带费:<html:text name="HuidanForm" property="kuandaifei" size="20" disabled="true" />
			    <html:checkbox property="checks" name="HuidanForm" value="4" />
				</td>
				<td>初装费:<html:text name="HuidanForm" property="chuzhuangfei" size="20" disabled="true" />
				<html:checkbox property="checks" name="HuidanForm" value="5" />
				</td>
				<td>设备销售费:<html:text name="HuidanForm" property="shebeixiaoshoufei" size="20" disabled="true" />
				<html:checkbox property="checks" name="HuidanForm" value="6" />
				</td>
				<td>材料费:<html:text name="HuidanForm" property="cailiaofei" size="20" disabled="true" />
				<html:checkbox property="checks" name="HuidanForm" value="7" />
				</td>
			</tr>
			<tr align="right">
			        
				    <td>运营商:<html:text name="HuidanForm" property="yunyingshang" size="20" disabled="true" />
				    </td>
				    <td>不足月够费:<html:text name="HuidanForm" property="bzygf" size="20" disabled="true" />
				    <html:checkbox property="checks" name="HuidanForm" value="8" />
				    </td>
				    <td>年费: <html:text name="HuidanForm" property="nianfei" size="20" disabled="true" />
				    <html:checkbox property="checks" name="HuidanForm" value="9" />
				    </td>
				    <td>施工人:<html:text name="HuidanForm" property="shigongren" size="20" disabled="true" />
					</td>
			    </tr>
				<tr align="right">
				    <td>收款时间:<html:text name="HuidanForm" property="shoukuanshijian" size="20" disabled="true" />
					<td>用户姓名:<html:text name="HuidanForm" property="xingming" size="20" disabled="true" />
					</td>
					<td>身份证号:<html:text name="HuidanForm" property="shenfenzheng" size="20" disabled="true" />
					</td>
					<td>分光线号:<html:text name="HuidanForm" property="fenguangxianhao" size="20" disabled="true" />
					</td>
				</tr>
				<tr align="right">
				    <td>接续位置:<html:text name="HuidanForm" property="jiexuweizhi" size="20" disabled="true" />
					</td>
					<td>总收费:<html:text name="HuidanForm" property="zongshoufei" size="20" disabled="true" />
					</td>
					<td>收据本号/收据号:<html:text name="HuidanForm" property="shoujubenhao" size="20" disabled="true" />
					</td>
					<td>开票信息:<html:text name="HuidanForm" property="kaipiaoxinxi" size="20" disabled="true" />
					</td>
				</tr>
				<tr align="right">
					<td>其他设备使用情况:<html:text name="HuidanForm" property="qtsbsyqk" size="20" disabled="true" />
					</td>
					<td>其他耗材:<html:text name="HuidanForm" property="qitahaocai" size="20" disabled="true" />
					</td>
					<td>接线子:(请填写数字) <html:text name="HuidanForm" property="jiexianzi" size="20" disabled="true" />
					</td>
					<td>RJ11:(请填写数字) <html:text name="HuidanForm" property="rj11" size="10" disabled="true" />
					</td>
				</tr>
				<tr align="right">
				    <td>RJ45:(请填写数字) <html:text name="HuidanForm" property="rj45" size="20" disabled="true" />
					</td>
					<td>模块:(请填写数字) <html:text name="HuidanForm" property="mokuai" size="20" disabled="true" />
					</td>
					<td>面板:(请填写数字) <html:text name="HuidanForm" property="mianban" size="20" disabled="true" />
					</td>
					<td>网线:(请填写数字) <html:text name="HuidanForm" property="wangxian" size="10" disabled="true" />
					</td>
				</tr>
				<tr>	
					<td>现场备注:<html:textarea name="HuidanForm" property="xianchangbeizhu" rows="6" cols="30" disabled="true" />
					</td>
					<td>备注:<html:textarea name="HuidanForm" property="beizhu" rows="6" cols="30" disabled="true" />
					</td>
					<td>备注汇总:<html:textarea name="HuidanForm" property="beizhuhuizong" rows="6" cols="30" disabled="true" />
					</td>
				</tr>
				<tr align="right">
				   <td>开票收据号:<html:text styleId="kaipiao" name="HuidanForm" property="kaipiaoshouju" size="20" /><a:need />
				   </td>
				</tr>
				<tr align="right">
				   <td>非开票收据号:<html:text styleId="feikaipiao" name="HuidanForm" property="feikaipiaoshouju" size="20" /><a:need />
				   </td>
				   <td>
					    <input type="button" value="确认拆分" onclick="check_querenchaifen();" /> 
			            <input type="button" value="返回" onclick="commonSubmit('huidanerrorList.do?act=init')" />
				   </td>
				</tr>
				<html:hidden name="HuidanForm" property="UUIDHidden" />
			</table>
		</html:form>
	</div>