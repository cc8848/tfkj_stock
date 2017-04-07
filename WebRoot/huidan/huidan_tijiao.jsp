<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2013-04-01     Zhang,Dong-Yu     Create
   
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
	    <h2 id="titlePanel">回单提交(红色星号为必填项)</h2>
	<div style="height:80px;">
	<html:form action="huidansubList.do">
		<table>
			<tr align="right">
				<td>用户状态： <html:text name="HuidanForm" property="yonghuzhuangtai" size="20" disabled="true" />
				</td>
				<td>开机时间： <html:text styleId="kaijishijian" name="HuidanForm" property="kaijis" size="20" disabled="true" />
				</td>
				<td>停机时间： <html:text name="HuidanForm" property="tingjis" size="20" disabled="true" />
				</td>
				<td>小区： <html:text name="HuidanForm" property="xiaoqu" size="20" disabled="true" />
				</td>
				<td>地址： <html:text name="HuidanForm" property="dizhi" size="20" disabled="true" />
				</td>
			</tr>
			<tr align="right">
				<td>联系电话： <html:text name="HuidanForm" property="telNoCode" size="20" disabled="true" />
				</td>
				<td>网络： <html:text name="HuidanForm" property="wangluo" size="20" disabled="true" /><html:hidden name="HuidanForm" property="wangluo" />
				</td>
				<td>电视： <html:text name="HuidanForm" property="dianshi" size="20" disabled="true" /><html:hidden name="HuidanForm" property="dianshi" />
				</td>
				<td>电话： <html:text name="HuidanForm" property="dianhua" size="20" disabled="true" />
				</td>
				<td>业务： <html:text name="HuidanForm" property="yewu" size="20" disabled="true" />
				</td>
			</tr>
			<tr align="right">
				<td>分光： <html:text name="HuidanForm" property="fenguang" size="20" disabled="true" />
				</td>
				<td>Onu MAC： <html:text name="HuidanForm" property="onuCode" size="20" disabled="true" />
				</td>
				<td>STB MCID： <html:text name="HuidanForm" property="mcidCode" size="20" disabled="true" />
				</td>
				<td>电视IP： <html:text name="HuidanForm" property="dianshiip" size="20" disabled="true" />
				</td>
				<td>网络IP： <html:text name="HuidanForm" property="wangluoip" size="20" disabled="true" />
				</td>
			</tr>
			<tr align="right">
				<td>电话IP： <html:text name="HuidanForm" property="dianhuaip" size="20" disabled="true" />
				</td>
				<td>电话VLAN： <html:text name="HuidanForm" property="dianhuavlan" size="20" disabled="true" />
				</td>
				<td>网络VLAN： <html:text name="HuidanForm" property="wangluovlan" size="20" disabled="true" />
				</td>
				<td>上门时间： <html:text name="HuidanForm" property="shangmenshijian" size="20" disabled="true" />
				</td>
				<td>单证:<html:text name="HuidanForm" property="danzheng" size="20" disabled="true" />
				</td>
			</tr>
			<tr align="right">
				<td>所选电话号码： <html:text name="HuidanForm" property="sxdhhm" size="20" disabled="true" />
				</td>
				<td>ONU押金:<html:text styleId="count_1" name="HuidanForm" property="onuyj" size="20" disabled="true" />
				</td>
				<td>机顶盒押金:<html:text styleId="count_2" name="HuidanForm" property="jidingheyj" size="20" disabled="true" />
				</td>
				<td>收视费:<html:text styleId="count_3" name="HuidanForm" property="shoushifei" size="20" disabled="true" />
				</td>
				<td>宽带费:<html:text styleId="count_4" name="HuidanForm" property="kuandaifei" size="20" disabled="true" />
				</td>
			</tr>
			<tr align="right">
				<td>初装费： <html:text styleId="count_5" name="HuidanForm" property="chuzhuangfei" size="20" disabled="true" />
				</td>
				<td>设备销售费： <html:text styleId="count_6" name="HuidanForm" property="shebeixiaoshoufei" size="20" disabled="true" />
				</td>
				<td>材料费:<html:text styleId="count_7" name="HuidanForm" property="cailiaofei" size="20" disabled="true" />
				</td>
				<td>运营商:<html:text name="HuidanForm" property="yunyingshang" size="20" disabled="true" />
				</td>
				<td>不足月够费:<html:text styleId="count_8" name="HuidanForm" property="bzygf" size="20" disabled="true" />
				</td>
			</tr>
			<tr align="right">
				<td>年费： <html:text styleId="count_9" name="HuidanForm" property="nianfei" size="20" disabled="true" />
				</td>
				<td colspan="2">备注： <html:text name="HuidanForm" property="beizhu" size="20" disabled="true" />
				</td>
				<td colspan="2">备注汇总： <html:text name="HuidanForm" property="beizhuhuizong" size="20" readonly="true" />
				</td>
			</tr>
		</table>
	</div>
	</br></br></br></br></br></br>
	<div>
			<table>
				<tr align="left">
					<td colspan="5">上述电子单信息是否与纸质工单有出入：<a:need />
					<html:radio name="HuidanForm" property="youwuchuru" value="无出入" onclick="check_wuchuru()">无出入 </html:radio>
					<html:radio name="HuidanForm" property="youwuchuru" value="有出入" onclick="check_youchuru()">有出入</html:radio>
					<html:radio name="HuidanForm" property="youwuchuru" value="开票金额拆分" onclick="check_kaipiaojinechaifen()">开票金额拆分</html:radio>
					</td>
				</tr>
				<tr align="left">
					<td colspan="3">纸质工单与电子单差异描述： <html:text styleId="check_11" name="HuidanForm" property="chayimiaoshu" size="40" />
					</td>
					<td colspan="2">开票拆分描述： <html:text styleId="check_22" name="HuidanForm" property="kaipiaochaifen" size="40" />
					</td>
				</tr>
				<tr align="right">
					<td>施工人： <a:need /><html:text styleId="sub_4" name="HuidanForm" property="shigongren" size="20" />
					</td>
					<td>收款时间:<a:need />
						<img onclick="WdatePicker({el:'kaishi'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle" /> 
					    <html:text  name="HuidanForm" property="shoukuanshijian" styleId="kaishi" size="10" onclick="WdatePicker({el:'kaishi'})" />
					</td>
					<td>用户姓名：<a:need /> <html:text styleId="sub_6" name="HuidanForm" property="xingming" size="20" />
					</td>
					<td>身份证号：<a:need /> <html:text styleId="sub_7" name="HuidanForm" property="shenfenzheng" size="18" />
					</td>
					<td>分光线号： <html:text name="HuidanForm" property="fenguangxianhao" size="20" />
					</td>
				</tr>
				<tr align="right">
					<td>接续位置：<a:need /> <html:text styleId="sub_8" name="HuidanForm" property="jiexuweizhi" size="10" />
					</td>
					<td>总收费：(<span id="count_qian"></span>)<a:need /><html:text styleId="sub_9" name="HuidanForm" property="zongshoufei" size="10" />
					</td>
					<td>收据本号/收据号:<a:need /><html:text styleId="sub_10" name="HuidanForm" property="shoujubenhao" size="10" />
					</td>
					<td>开票信息： <html:text name="HuidanForm" property="kaipiaoxinxi" size="20" />
					</td>
					<td>其他设备使用情况： <html:text name="HuidanForm" property="qtsbsyqk" size="20" />
					</td>
				</tr>
				<tr align="right">
					<td>其他耗材： <html:text name="HuidanForm" property="qitahaocai" size="20" />
					</td>
					<td>接线子：(请填写数字) <html:text styleId="sub_11" name="HuidanForm" property="jiexianzi" size="5" />
					</td>
					<td>RJ11：(请填写数字) <html:text styleId="sub_12" name="HuidanForm" property="rj11" size="5" />
					</td>
					<td>RJ45：(请填写数字) <html:text styleId="sub_13" name="HuidanForm" property="rj45" size="5" />
					</td>
					<td>模块：(请填写数字) <html:text styleId="sub_14" name="HuidanForm" property="mokuai" size="5" />
					</td>
				</tr>
				<tr align="right">
					<td>面板：(请填写数字) <html:text styleId="sub_15" name="HuidanForm" property="mianban" size="5" />
					</td>
					<td>网线：(请填写数字) <html:text styleId="sub_16" name="HuidanForm" property="wangxian" size="5" />
					</td>
					<td>收据号:<html:text styleId="shouju" name="HuidanForm" property="shoujuhao" size="5" disabled="true"/>
					</td>
				</tr>
				<tr>	
					<td colspan="3">现场备注： <html:textarea name="HuidanForm" property="xianchangbeizhu" rows="5" cols="70" />
					</td>
					<td colspan="2">
					    <span style="float:center">
					        <input id="button_1" disabled="true" type="button" value="正常提交" onclick="check_zhengchangtijiao();" /> 
					        <input id="button_2" disabled="true" type="button" value="开票拆分" onclick="check_kaipiaochaifen();" /> 
					        <input id="button_3" disabled="true" type="button" value="纠错修改" onclick="check_jiucuoxiugai();" /> 
					        <input type="button" value="返回" onclick="commonSubmit('huidansubList.do?act=init')" />
					   </span>
					</td>
				</tr>
			</table>
			<html:hidden name="HuidanForm" property="UUIDHidden" />
		</html:form>
	</div>
</body>