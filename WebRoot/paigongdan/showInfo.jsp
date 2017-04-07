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
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/common.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="paigongdan/paigongdan.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
		<html:form action="paigongdanEdit.do">
		<div id="content_all">
			<!-- 标题 -->
			<div class="conten_top" name="top">
				派工单详情查看
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="940px">
					<tr height="35px">
						<td class="editTableTitle" width="30px">用户信息：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						用户姓名：
						<html:text name="paiGongDanEntiyForm" property="username"size="12"
								styleClass="commonTextFieldHover" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
							<a:need />
						小区名称：
							<html:select name="paiGongDanEntiyForm" property="xiaoquname" styleId="xiaoquname"
								styleClass="commonTextFieldHover"  onchange="selectxiaoqu(this)" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
						<a:need />
						</td>
						</tr>
						<tr>
						<td>
						用户地址：
						<html:text name="paiGongDanEntiyForm" property="userplace"size="12"disabled="true"
								styleClass="commonTextFieldHover"	onchange="isture(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
							<a:need />
						联系电话：
							<html:text name="paiGongDanEntiyForm" property="usertel" size="12"disabled="true"
								styleClass="commonTextFieldHover"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
							<a:need />	
							</td>
						</tr>
							</table>
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">派工日期：</td>
						<td class="editTableContent" >
						
						派工日期：
							<html:text name="paiGongDanEntiyForm" property="paigongriqi"  styleId="paigongriqi"size="12"
								styleClass="commonTextFieldHover" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						<img onclick="WdatePicker({el:'paigongriqi'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 		
						<a:need />
						上门时间：
						<html:select name="paiGongDanEntiyForm" property="anzhuangshijian" 
								styleClass="commonTextFieldHover" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">请选择</html:option>
								<html:option value="上午">上午</html:option>
								<html:option value="下午">下午</html:option>
								<html:option value="全天">下午</html:option>
							</html:select>			
							<a:need />
						项目：
							<html:select name="paiGongDanEntiyForm" property="xiangmu" disabled="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">请选择</html:option>
								<html:option value="安装">安装</html:option>
								<html:option value="收件">收件</html:option>
							</html:select>	
							<a:need />	
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">单证：</td>
						<td class="editTableContent" >
						已见电信返单：
							<html:checkbox name="paiGongDanEntiyForm" property="dxfandan" value="1" disabled="true"></html:checkbox>
						证件齐全：
							<html:checkbox name="paiGongDanEntiyForm" property="zhengjian" styleId="zhengjian" value="1" disabled="true"></html:checkbox>
						</td>
						</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">天房宽带：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						带宽：
							<html:select name="paiGongDanEntiyForm" property="tfkuandaidaikuan" disabled="true"
								styleClass="commonTextFieldHover" styleId="tfkuandaidaikuan"
								onfocus="this.className='commonTextFieldMove'"  onchange="clearKuandai()"
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--请选择--</html:option>
								<html:option value="1M">1M</html:option>
								<html:option value="1.5M">1.5M</html:option>
								<html:option value="2M">2M</html:option>
								<html:option value="2.5M">2.5M</html:option>
								<html:option value="3M">3M</html:option>
								<html:option value="4M">4M</html:option>
								<html:option value="6M">6M</html:option>
								<html:option value="8M">8M</html:option>
								<html:option value="10M">10M</html:option>
								<html:option value="12M">12M</html:option>
								<html:option value="20M">20M</html:option>
								<html:option value="50M">50M</html:option>
								<html:option value="100M">100M</html:option>
							</html:select>	
								
						时长	：
							<html:select name="paiGongDanEntiyForm" disabled="true" property="tfkdnianxian" styleId="tfkdnianxian"
								styleClass="commonTextFieldHover"  disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
									<html:option value="0">--请选择--</html:option>
								<html:options collection="shichangList" property="key" labelProperty="value" />
							</html:select>
							资费调整倍数：
								<html:select name="paiGongDanEntiyForm"  disabled="true" styleId="beishuselect" property="beishuselect" styleClass="commonTextFieldHover"   onfocus="this.className='commonTextFieldMove'" onblur="this.className='commonTextFieldHover'" onchange="changebeishu()">
									<html:option value="1">X1</html:option><html:option value="2">X2</html:option><html:option value="3">X3</html:option><html:option value="4">X4</html:option><html:option value="5">X5</html:option>
									<html:option value="6">X6</html:option><html:option value="7">X7</html:option><html:option value="8">X8</html:option><html:option value="9">X9</html:option><html:option value="10">X10</html:option>
									<html:option value="11">X11</html:option><html:option value="12">X12</html:option><html:option value="13">X13</html:option><html:option value="14">X14</html:option><html:option value="15">X15</html:option>
									<html:option value="16">X16</html:option><html:option value="17">X17</html:option><html:option value="18">X18</html:option><html:option value="19">X19</html:option><html:option value="20">X20</html:option>
									<html:option value="21">X21</html:option><html:option value="22">X22</html:option><html:option value="23">X23</html:option><html:option value="24">X24</html:option><html:option value="25">X25</html:option>
									<html:option value="26">X26</html:option><html:option value="27">X27</html:option><html:option value="28">X28</html:option><html:option value="29">X29</html:option><html:option value="30">X30</html:option>
									<html:option value="31">X31</html:option><html:option value="32">X32</html:option><html:option value="33">X33</html:option><html:option value="34">X34</html:option><html:option value="35">X35</html:option>
									<html:option value="36">X36</html:option><html:option value="37">X37</html:option><html:option value="38">X38</html:option><html:option value="39">X39</html:option><html:option value="40">X40</html:option>
								</html:select>	<br/>	
						初装费：
							<html:text name="paiGongDanEntiyForm" property="tfkdczf"size="12" disabled="true"
								styleClass="commonTextFieldHover" styleId="tfkdczf" onchange="setvalueschuzhuangfei(this,'chuzhuangfei')"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td>
						宽带费：
						<html:text name="paiGongDanEntiyForm" property="tfkuandaifei"size="12" disabled="true"
								styleClass="commonTextFieldHover" styleId="tfkuandaifei" onchange="setvalues(this,'kuaidaifei')"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						<!-- ONU押金：
						<html:text name="paiGongDanEntiyForm" property="anzhuangshijian"size="12"
								styleClass="commonTextFieldHover" styleId="tfkuandaionu"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						 -->			
						</td>
						</tr>
						</table>
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">天房IPTV：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						数量：
								
								<html:select name="paiGongDanEntiyForm" property="tfiptv" disabled="true"
								styleClass="commonTextFieldHover"  styleId="tfiptvshuliang" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--请选择--</html:option>
								<html:option value="标清">标清</html:option>
								<html:option value="两个标清">两个标清</html:option>
								
								<html:option value="三个标清">三个标清</html:option>
								<html:option value="四个标清">四个标清</html:option>
								<html:option value="高清">高清</html:option>
								<html:option value="两个高清">两个高清</html:option>
								<html:option value="三个高清">三个高清</html:option>
								<html:option value="四个高清">四个高清</html:option>
								<html:option value="一个标清与一个高清">一个标清与一个高清</html:option>
								
								<html:option value="高点">高点</html:option>
								</html:select>
						</td>
						<td>
						时长：
						<html:select name="paiGongDanEntiyForm" property="tfiptvnianxian" disabled="true"
								styleClass="commonTextFieldHover"  styleId="tfiptvshichang" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--请选择--</html:option>
								<html:option value="1">1年</html:option><html:option value="2">2年</html:option>
								<html:option value="3">3年</html:option><html:option value="4">4年</html:option>
								<html:option value="5">5年</html:option>	
						</html:select>		
						</td>
						</tr>
						<tr>
						<td>	
							
						收视费：
						<html:text name="paiGongDanEntiyForm" property="tfiptvshoushifei" size="12"disabled="true"
								styleClass="commonTextFieldHover" styleId="tfiptvshoushifei" onchange="setvalues(this,'shoushifei')"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'" />（元）		
						</td>
						<td>
						机顶盒押金：
						<html:text name="paiGongDanEntiyForm" property="tfjidingheyajin" size="12"disabled="true"
								styleClass="commonTextFieldHover" styleId="tfjidingheyajin" onchange="setvalues(this,'jidinghe')"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />（元）
						</td>
						
						</tr>
						</table>		
						</td>
					</tr>
						<tr height="35px">
						<td class="editTableTitle" width="30px">其他运营商业务：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						套餐：
							
								<html:select name="paiGongDanEntiyForm" property="qtye" disabled="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--请选择--</html:option>
								<html:options collection="dianxintaocan" property="key" labelProperty="value" />
								</html:select>
						初装费：
								<html:select name="paiGongDanEntiyForm" property="dxchuzhuangfei" disabled="true"
								styleClass="commonTextFieldHover"  styleId="dxchuzhuangfei" onchange="dxchuzhuangfeichange(this)"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--请选择--</html:option>
								<!--<html:option value="0">零个0元</html:option>-->
								<html:option value="205">一个205元</html:option>
								<html:option value="410">二个410元</html:option>
								<html:option value="615">三个615元</html:option>
								<html:option value="820">四个820元</html:option>
								</html:select>		
						</td>
						</tr>
						<tr>
						<td>	
						付费方式：
							<html:select name="paiGongDanEntiyForm" property="fufeitype" disabled="true"
								styleClass="commonTextFieldHover"  styleId="fufeitype" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">-请选择-</html:option>
								<html:option value="月付">月付</html:option>
								<html:option value="预付一年">预付一年</html:option>
								<html:option value="预付两年">预付两年</html:option>
								</html:select>		
						费用：&nbsp;
						<html:text name="paiGongDanEntiyForm" property="fufei" size="12"disabled="true"
								styleClass="commonTextFieldHover" onchange="setvalues(this,'nianfei')"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						
						不足月：
						<html:text name="paiGongDanEntiyForm" property="qtbuzuyue" size="12" onchange="setvalues(this,'buzuyue')"
								styleClass="commonTextFieldHover" styleId="qtbuzuyue" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						</table>
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >设备信息：</td>
							<td class="editTableContentLast" >
							分光：
							<html:text styleId="fenguang" name="paiGongDanEntiyForm" property="fenguang" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>							
							onu mac：
							<html:text styleId="onumac" name="paiGongDanEntiyForm" property="onumac" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<br/>
							STB MCID：
							<html:text styleId="stbmcid" name="paiGongDanEntiyForm" property="stbmcid" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							电视IP：
							<html:text styleId="dianshiip" name="paiGongDanEntiyForm" property="dianshiip" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
						<br/>
						</td>
								
					</tr>
						<tr height="35px">
						<td class="editTableTitle" width="30px">所选号码：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						号码1&nbsp;
							<html:text name="paiGongDanEntiyForm" property="telhaoma1" size="12"
								styleClass="commonTextFieldHover" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						号码2&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma2" size="12"
								styleClass="commonTextFieldHover" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>		
						</tr>	
						<tr>
						<td>	
						号码3&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma3" size="12"
								styleClass="commonTextFieldHover" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						号码4&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma4" size="12"
								styleClass="commonTextFieldHover" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>		
						</table>		
						</td>
					</tr>
					
						
					
					<tr height="35px">
						<td class="editTableTitle" width="30px">应收费用：</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td id="onutd">
						ONU押金：
							<html:text name="paiGongDanEntiyForm" property="onu" size="8"
								styleClass="commonTextFieldHover"  styleId="onu"disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>	
						<td style="display:none" id="jiaohuanjiid">
						交换机：&nbsp;
							<!--<html:text name="paiGongDanEntiyForm" property="jiaohuanji" size="8"
								styleClass="commonTextFieldHover"  styleId="jiaohuanji" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />-->
							<html:select name="paiGongDanEntiyForm" property="jiaohuanji" disabled="true"
								styleClass="commonTextFieldHover"  styleId="jiaohuanji" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">请选择</html:option>
								<html:option value="0">0元</html:option>
								<html:option value="50">50元</html:option>	
							</html:select>
						</td>
						<td>	
						收视费：
						<html:text name="paiGongDanEntiyForm" property="shoushifei" size="8"
								styleClass="commonTextFieldHover"  styleId="shoushifei"disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>
						机顶盒押金：
						<html:text name="paiGongDanEntiyForm" property="jidinghe" size="8"
								styleClass="commonTextFieldHover"  styleId="jidinghe"disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>	
						年费：
						<html:text name="paiGongDanEntiyForm" property="nianfei" size="8"
								styleClass="commonTextFieldHover" styleId="nianfei"disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td>		
						不足月：&nbsp;
						<html:text name="paiGongDanEntiyForm" property="buzuyue" size="8"
								styleClass="commonTextFieldHover"  styleId="buzuyue"disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						初装费：
						<html:text name="paiGongDanEntiyForm" property="chuzhuangfei" size="8"
								styleClass="commonTextFieldHover"  styleId="chuzhuangfei"disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						设备销售费：
						<html:text name="paiGongDanEntiyForm" property="shebeixiaoshou" size="8"  readonly="false"
								styleClass="commonTextFieldHover" styleId="shebeixiaoshou" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						材料费：
						<html:text name="paiGongDanEntiyForm" property="cailiaofei" size="8" readonly="false"
								styleClass="commonTextFieldHover"  styleId="cailiaofei" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td>		
						宽带费：&nbsp;&nbsp;&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="kuaidaifei" size="8"
								styleClass="commonTextFieldHover" styleId="kuaidaifei" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						合计：
						<html:text name="paiGongDanEntiyForm" property="heji" size="8"
								styleClass="commonTextFieldHover" styleId="heji"disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />	
						</td>		
						</tr>		
						</table>		
						</td>
						</tr>
					<tr >
						<td class="editTableTitleLast" >开票信息：</td>
						<td class="editTableContentLast" >
							<html:textarea name="paiGongDanEntiyForm" property="kaipiaoxinxi"  onkeyup="if(this.value.length>200)this.value=this.value.substr(0,200)"
								rows="5" cols="70" disabled="true"></html:textarea>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >备注：</td>
						<td class="editTableContentLast" >
							<html:textarea name="paiGongDanEntiyForm" property="beizhu"  
								rows="5" cols="70"  disabled="true"
								></html:textarea>
						</td>
					</tr>
					
				</table>
				</div>
			</div>
			<!-- button -->
			<div name="button" class="content_button">
			<!-- 	<html:button property="btnSave" value="保存" styleClass="commonButton" onclick="subs();"/>
				--><html:button property="btnBack" value="返回" styleClass="commonButton" onclick="commonSubmit('paigongdanList.do?act=init')"/>
				运营商：
				<html:select name="paiGongDanEntiyForm" property="yuyingshang" 
								styleClass="commonTextFieldHover"  styleId="yuyingshang"
								onfocus="this.className='commonTextFieldMove'" disabled="true"
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--请选择--</html:option>
								<html:option value="电信">电信</html:option>
								<html:option value="联通">联通</html:option>
								<html:option value="广电">广电</html:option>
								<html:option value="铁通">铁通</html:option>
								<html:option value="天房">天房</html:option>
							</html:select>	<a:need />
				<input type="hidden" id="yewushijian" name="yewushijian"/>
				开机时间：
				<html:text name="paiGongDanEntiyForm" property="kaijishijian"  styleId="kaijishijian"size="12"
								styleClass="commonTextFieldHover" onclick="new Calendar().show(this)" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
				停机时间：
				<html:text name="paiGongDanEntiyForm" property="tingjishijian"  styleId="tingjishijian"size="12"
								styleClass="commonTextFieldHover" onclick="new Calendar().show(this)" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
				（可手动指定停开机时间）
			</div> 
		</div>
		<html:hidden name="paiGongDanEntiyForm" property="UUID" />
		</html:form>
	</body>
<script type="text/javascript">	
function subs(){
	if(checkInput()){
		commonSubmit('paigongdanEdit.do?act=update');
		}
}

function show(){
	var obj = document.getElementById("xiaoquname");
	if(obj.value=="天欣花园"||obj.value=="福悦里"||obj.value=="海景公寓"){
		document.getElementById("jiaohuanjiid").style.display="";
		document.getElementById("onu").value="0";
		document.getElementById("onutd").style.display="none";
		}else{
			document.getElementById("jiaohuanji").value="0";
			document.getElementById("jiaohuanjiid").style.display="none";
			document.getElementById("onutd").style.display="";
			}
		}
show();

	</script>
</html>