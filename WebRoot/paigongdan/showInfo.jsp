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
			<!-- ���� -->
			<div class="conten_top" name="top">
				�ɹ�������鿴
			</div>
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="940px">
					<tr height="35px">
						<td class="editTableTitle" width="30px">�û���Ϣ��</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						�û�������
						<html:text name="paiGongDanEntiyForm" property="username"size="12"
								styleClass="commonTextFieldHover" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
							<a:need />
						С�����ƣ�
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
						�û���ַ��
						<html:text name="paiGongDanEntiyForm" property="userplace"size="12"disabled="true"
								styleClass="commonTextFieldHover"	onchange="isture(this)"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
							<a:need />
						��ϵ�绰��
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
						<td class="editTableTitle" width="30px">�ɹ����ڣ�</td>
						<td class="editTableContent" >
						
						�ɹ����ڣ�
							<html:text name="paiGongDanEntiyForm" property="paigongriqi"  styleId="paigongriqi"size="12"
								styleClass="commonTextFieldHover" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						<img onclick="WdatePicker({el:'paigongriqi'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 		
						<a:need />
						����ʱ�䣺
						<html:select name="paiGongDanEntiyForm" property="anzhuangshijian" 
								styleClass="commonTextFieldHover" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">��ѡ��</html:option>
								<html:option value="����">����</html:option>
								<html:option value="����">����</html:option>
								<html:option value="ȫ��">����</html:option>
							</html:select>			
							<a:need />
						��Ŀ��
							<html:select name="paiGongDanEntiyForm" property="xiangmu" disabled="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">��ѡ��</html:option>
								<html:option value="��װ">��װ</html:option>
								<html:option value="�ռ�">�ռ�</html:option>
							</html:select>	
							<a:need />	
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">��֤��</td>
						<td class="editTableContent" >
						�Ѽ����ŷ�����
							<html:checkbox name="paiGongDanEntiyForm" property="dxfandan" value="1" disabled="true"></html:checkbox>
						֤����ȫ��
							<html:checkbox name="paiGongDanEntiyForm" property="zhengjian" styleId="zhengjian" value="1" disabled="true"></html:checkbox>
						</td>
						</tr>
					<tr height="35px">
						<td class="editTableTitle" width="30px">�췿�����</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						����
							<html:select name="paiGongDanEntiyForm" property="tfkuandaidaikuan" disabled="true"
								styleClass="commonTextFieldHover" styleId="tfkuandaidaikuan"
								onfocus="this.className='commonTextFieldMove'"  onchange="clearKuandai()"
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--��ѡ��--</html:option>
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
								
						ʱ��	��
							<html:select name="paiGongDanEntiyForm" disabled="true" property="tfkdnianxian" styleId="tfkdnianxian"
								styleClass="commonTextFieldHover"  disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
									<html:option value="0">--��ѡ��--</html:option>
								<html:options collection="shichangList" property="key" labelProperty="value" />
							</html:select>
							�ʷѵ���������
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
						��װ�ѣ�
							<html:text name="paiGongDanEntiyForm" property="tfkdczf"size="12" disabled="true"
								styleClass="commonTextFieldHover" styleId="tfkdczf" onchange="setvalueschuzhuangfei(this,'chuzhuangfei')"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td>
						����ѣ�
						<html:text name="paiGongDanEntiyForm" property="tfkuandaifei"size="12" disabled="true"
								styleClass="commonTextFieldHover" styleId="tfkuandaifei" onchange="setvalues(this,'kuaidaifei')"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						<!-- ONUѺ��
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
						<td class="editTableTitle" width="30px">�췿IPTV��</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						������
								
								<html:select name="paiGongDanEntiyForm" property="tfiptv" disabled="true"
								styleClass="commonTextFieldHover"  styleId="tfiptvshuliang" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--��ѡ��--</html:option>
								<html:option value="����">����</html:option>
								<html:option value="��������">��������</html:option>
								
								<html:option value="��������">��������</html:option>
								<html:option value="�ĸ�����">�ĸ�����</html:option>
								<html:option value="����">����</html:option>
								<html:option value="��������">��������</html:option>
								<html:option value="��������">��������</html:option>
								<html:option value="�ĸ�����">�ĸ�����</html:option>
								<html:option value="һ��������һ������">һ��������һ������</html:option>
								
								<html:option value="�ߵ�">�ߵ�</html:option>
								</html:select>
						</td>
						<td>
						ʱ����
						<html:select name="paiGongDanEntiyForm" property="tfiptvnianxian" disabled="true"
								styleClass="commonTextFieldHover"  styleId="tfiptvshichang" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--��ѡ��--</html:option>
								<html:option value="1">1��</html:option><html:option value="2">2��</html:option>
								<html:option value="3">3��</html:option><html:option value="4">4��</html:option>
								<html:option value="5">5��</html:option>	
						</html:select>		
						</td>
						</tr>
						<tr>
						<td>	
							
						���ӷѣ�
						<html:text name="paiGongDanEntiyForm" property="tfiptvshoushifei" size="12"disabled="true"
								styleClass="commonTextFieldHover" styleId="tfiptvshoushifei" onchange="setvalues(this,'shoushifei')"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'" />��Ԫ��		
						</td>
						<td>
						������Ѻ��
						<html:text name="paiGongDanEntiyForm" property="tfjidingheyajin" size="12"disabled="true"
								styleClass="commonTextFieldHover" styleId="tfjidingheyajin" onchange="setvalues(this,'jidinghe')"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />��Ԫ��
						</td>
						
						</tr>
						</table>		
						</td>
					</tr>
						<tr height="35px">
						<td class="editTableTitle" width="30px">������Ӫ��ҵ��</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						�ײͣ�
							
								<html:select name="paiGongDanEntiyForm" property="qtye" disabled="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--��ѡ��--</html:option>
								<html:options collection="dianxintaocan" property="key" labelProperty="value" />
								</html:select>
						��װ�ѣ�
								<html:select name="paiGongDanEntiyForm" property="dxchuzhuangfei" disabled="true"
								styleClass="commonTextFieldHover"  styleId="dxchuzhuangfei" onchange="dxchuzhuangfeichange(this)"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--��ѡ��--</html:option>
								<!--<html:option value="0">���0Ԫ</html:option>-->
								<html:option value="205">һ��205Ԫ</html:option>
								<html:option value="410">����410Ԫ</html:option>
								<html:option value="615">����615Ԫ</html:option>
								<html:option value="820">�ĸ�820Ԫ</html:option>
								</html:select>		
						</td>
						</tr>
						<tr>
						<td>	
						���ѷ�ʽ��
							<html:select name="paiGongDanEntiyForm" property="fufeitype" disabled="true"
								styleClass="commonTextFieldHover"  styleId="fufeitype" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">-��ѡ��-</html:option>
								<html:option value="�¸�">�¸�</html:option>
								<html:option value="Ԥ��һ��">Ԥ��һ��</html:option>
								<html:option value="Ԥ������">Ԥ������</html:option>
								</html:select>		
						���ã�&nbsp;
						<html:text name="paiGongDanEntiyForm" property="fufei" size="12"disabled="true"
								styleClass="commonTextFieldHover" onchange="setvalues(this,'nianfei')"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						
						�����£�
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
						<td class="editTableTitle" >�豸��Ϣ��</td>
							<td class="editTableContentLast" >
							�ֹ⣺
							<html:text styleId="fenguang" name="paiGongDanEntiyForm" property="fenguang" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>							
							onu mac��
							<html:text styleId="onumac" name="paiGongDanEntiyForm" property="onumac" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<br/>
							STB MCID��
							<html:text styleId="stbmcid" name="paiGongDanEntiyForm" property="stbmcid" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							����IP��
							<html:text styleId="dianshiip" name="paiGongDanEntiyForm" property="dianshiip" maxlength="50" readonly="true"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><br/>
						<br/>
						</td>
								
					</tr>
						<tr height="35px">
						<td class="editTableTitle" width="30px">��ѡ���룺</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td>
						����1&nbsp;
							<html:text name="paiGongDanEntiyForm" property="telhaoma1" size="12"
								styleClass="commonTextFieldHover" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						����2&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma2" size="12"
								styleClass="commonTextFieldHover" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>		
						</tr>	
						<tr>
						<td>	
						����3&nbsp;
						<html:text name="paiGongDanEntiyForm" property="telhaoma3" size="12"
								styleClass="commonTextFieldHover" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						����4&nbsp;&nbsp;
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
						<td class="editTableTitle" width="30px">Ӧ�շ��ã�</td>
						<td class="editTableContent" >
						<table>
						<tr>
						<td id="onutd">
						ONUѺ��
							<html:text name="paiGongDanEntiyForm" property="onu" size="8"
								styleClass="commonTextFieldHover"  styleId="onu"disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>	
						<td style="display:none" id="jiaohuanjiid">
						��������&nbsp;
							<!--<html:text name="paiGongDanEntiyForm" property="jiaohuanji" size="8"
								styleClass="commonTextFieldHover"  styleId="jiaohuanji" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />-->
							<html:select name="paiGongDanEntiyForm" property="jiaohuanji" disabled="true"
								styleClass="commonTextFieldHover"  styleId="jiaohuanji" 
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">��ѡ��</html:option>
								<html:option value="0">0Ԫ</html:option>
								<html:option value="50">50Ԫ</html:option>	
							</html:select>
						</td>
						<td>	
						���ӷѣ�
						<html:text name="paiGongDanEntiyForm" property="shoushifei" size="8"
								styleClass="commonTextFieldHover"  styleId="shoushifei"disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>
						������Ѻ��
						<html:text name="paiGongDanEntiyForm" property="jidinghe" size="8"
								styleClass="commonTextFieldHover"  styleId="jidinghe"disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>	
						��ѣ�
						<html:text name="paiGongDanEntiyForm" property="nianfei" size="8"
								styleClass="commonTextFieldHover" styleId="nianfei"disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td>		
						�����£�&nbsp;
						<html:text name="paiGongDanEntiyForm" property="buzuyue" size="8"
								styleClass="commonTextFieldHover"  styleId="buzuyue"disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						��װ�ѣ�
						<html:text name="paiGongDanEntiyForm" property="chuzhuangfei" size="8"
								styleClass="commonTextFieldHover"  styleId="chuzhuangfei"disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						�豸���۷ѣ�
						<html:text name="paiGongDanEntiyForm" property="shebeixiaoshou" size="8"  readonly="false"
								styleClass="commonTextFieldHover" styleId="shebeixiaoshou" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						���Ϸѣ�
						<html:text name="paiGongDanEntiyForm" property="cailiaofei" size="8" readonly="false"
								styleClass="commonTextFieldHover"  styleId="cailiaofei" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						</tr>
						<tr>
						<td>		
						����ѣ�&nbsp;&nbsp;&nbsp;&nbsp;
						<html:text name="paiGongDanEntiyForm" property="kuaidaifei" size="8"
								styleClass="commonTextFieldHover" styleId="kuaidaifei" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'" />
						</td>
						<td>		
						�ϼƣ�
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
						<td class="editTableTitleLast" >��Ʊ��Ϣ��</td>
						<td class="editTableContentLast" >
							<html:textarea name="paiGongDanEntiyForm" property="kaipiaoxinxi"  onkeyup="if(this.value.length>200)this.value=this.value.substr(0,200)"
								rows="5" cols="70" disabled="true"></html:textarea>
						</td>
					</tr>
					<tr >
						<td class="editTableTitleLast" >��ע��</td>
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
			<!-- 	<html:button property="btnSave" value="����" styleClass="commonButton" onclick="subs();"/>
				--><html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('paigongdanList.do?act=init')"/>
				��Ӫ�̣�
				<html:select name="paiGongDanEntiyForm" property="yuyingshang" 
								styleClass="commonTextFieldHover"  styleId="yuyingshang"
								onfocus="this.className='commonTextFieldMove'" disabled="true"
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--��ѡ��--</html:option>
								<html:option value="����">����</html:option>
								<html:option value="��ͨ">��ͨ</html:option>
								<html:option value="���">���</html:option>
								<html:option value="��ͨ">��ͨ</html:option>
								<html:option value="�췿">�췿</html:option>
							</html:select>	<a:need />
				<input type="hidden" id="yewushijian" name="yewushijian"/>
				����ʱ�䣺
				<html:text name="paiGongDanEntiyForm" property="kaijishijian"  styleId="kaijishijian"size="12"
								styleClass="commonTextFieldHover" onclick="new Calendar().show(this)" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
				ͣ��ʱ�䣺
				<html:text name="paiGongDanEntiyForm" property="tingjishijian"  styleId="tingjishijian"size="12"
								styleClass="commonTextFieldHover" onclick="new Calendar().show(this)" disabled="true"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
				�����ֶ�ָ��ͣ����ʱ�䣩
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
	if(obj.value=="������԰"||obj.value=="������"||obj.value=="������Ԣ"){
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