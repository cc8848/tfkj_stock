<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2013-3-29     Zhang,Dong-Yu     Create
   
  -->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<title>快速开发框架演示项目</title>
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
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">回单编辑</div>
			<div class="conten_query" name="query"></div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
					<table border="0" cellspacing="0" cellpadding="2" width="940px">
						<tr height="35px">
							<td valign="top" class="editTableTitle" width="80px">回单信息：</td>
							<td class="editTableContent">
								<table>
											    </br> 开机时间： <html:text readonly="true" name="HuidanForm"
												property="kaijis" size="20" />
												</br> 停机时间： <html:text readonly="true" name="HuidanForm"
												property="tingjis" size="20" />
												</br> &nbsp;&nbsp;&nbsp;&nbsp小区： <html:text readonly="true" name="HuidanForm"
												property="xiaoqu" size="20" />
												<tr><td> &nbsp;&nbsp;&nbsp;&nbsp;地址： <html:text readonly="true" name="HuidanForm"
												property="dizhi" size="20" />
												</br> 联系电话： <html:text readonly="true" name="HuidanForm"
												property="telNoCode" size="20" />
												</br> &nbsp;&nbsp;&nbsp;&nbsp;网络： <html:text readonly="true" name="HuidanForm"
												property="wangluo" size="20" />
												</br> &nbsp;&nbsp;&nbsp;&nbsp;电视： <html:text readonly="true" name="HuidanForm"
												property="dianshi" size="20" />
												</br> &nbsp;&nbsp;&nbsp;&nbsp;电话： <html:text readonly="true" name="HuidanForm"
												property="dianhua" size="20" />
												</br> &nbsp;&nbsp;&nbsp;&nbsp;业务： <html:text readonly="true" name="HuidanForm"
												property="yewu" size="20" />
												</br> &nbsp;&nbsp;&nbsp;&nbsp;分光： <html:text readonly="true" name="HuidanForm"
												property="fenguang" size="20" />
												</br> &nbsp;onu MAC： <html:text readonly="true" name="HuidanForm"
												property="onuCode" size="20" />
												</br> stb MCID： <html:text readonly="true" name="HuidanForm"
												property="mcidCode" size="20" />
												</br> &nbsp;&nbsp;电视ip： <html:text readonly="true" name="HuidanForm"
												property="dianshiip" size="20" />
												</br> &nbsp;&nbsp;网络ip： <html:text readonly="true" name="HuidanForm"
												property="wangluoip" size="20" />
												</br> &nbsp;&nbsp;电话ip： <html:text readonly="true" name="HuidanForm"
												property="dianhuaip" size="20" />
												</br> 电话vlan： <html:text readonly="true" name="HuidanForm"
												property="dianhuavlan" size="20" />
												</br> 网络vlan： <html:text readonly="true" name="HuidanForm"
												property="wangluovlan" size="20" />
												</br> 上门时间： <html:text readonly="true" name="HuidanForm"
												property="shangmenshijian" size="20" />
												</br> &nbsp;&nbsp;&nbsp;&nbsp;单证： <html:text readonly="true" name="HuidanForm"
												property="danzheng" size="20" />
												</br> 所选电话： <html:text readonly="true" name="HuidanForm"
												property="sxdhhm" size="20" />
												</br> &nbsp;onu押金： <html:text readonly="true" name="HuidanForm"
												property="onuyj" size="20" />
												</br> 机顶盒押金:<html:text readonly="true" name="HuidanForm"
												property="jidingheyj" size="20" />
												</br> &nbsp;&nbsp;收视费： <html:text readonly="true" name="HuidanForm"
												property="shoushifei" size="20" />
												</br> &nbsp;&nbsp;宽带费： <html:text readonly="true" name="HuidanForm"
												property="kuandaifei" size="20" />
												</br> &nbsp;&nbsp;初装费： <html:text readonly="true" name="HuidanForm"
												property="chuzhuangfei" size="20" />
												</br> 设备销售费:<html:text readonly="true" name="HuidanForm"
												property="shebeixiaoshoufei" size="20" />
												</br> &nbsp;&nbsp;材料费： <html:text readonly="true" name="HuidanForm"
												property="cailiaofei" size="20" />
												</br> &nbsp;&nbsp;运营商： <html:text readonly="true" name="HuidanForm"
												property="yunyingshang" size="20" />
												</br> 不足月够费:<html:text readonly="true" name="HuidanForm"
												property="bzygf" size="20" />
												</br> &nbsp;&nbsp;&nbsp;&nbsp;年费： <html:text readonly="true" name="HuidanForm"
												property="nianfei" size="20" />
												</br> 备注汇总（onu箱号/机顶盒箱号）： <html:text readonly="true" name="HuidanForm"
												property="beizhuhuizong" size="20" />
											</td>
									</tr>
									<tr>
									    <td>备注： 
											  <html:textarea readonly="true" name="HuidanForm" property="beizhu" rows="5" cols="70">
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
				<html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('huidandaoruList.do?act=init')" />
			</div>
		</div>
	</html:form>
</body>
</html>