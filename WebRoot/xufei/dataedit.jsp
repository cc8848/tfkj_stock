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
		<html:form action="shenqingDataEdit.do">
			<bean:define id="xiaoquList" name="jiaofeiDataFrom" property="xiaoquList"></bean:define>
		<div id="content_all">
			<!-- ���� -->
			<div class="conten_top" name="top">
				���ɷѱ༭
			</div>
			<!--  �����༭ start -->
			<div class="conten_query" name="query">
			</div>
			<div name="result" class="conten_result">
				<div name="result_table" class="result_table">
				<table border="0" cellspacing="0" cellpadding="2" width="960px">
					<tr height="35px">
						<td class="editTableTitle" >С����</td>
						<td class="editTableContent" >С�����ƣ�
						<html:text name="jiaofeiDataFrom" property="xiaoqu" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
							 &nbsp; &nbsp; 
							С����ַ��
							<html:text name="jiaofeiDataFrom" property="dizhi" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<a:need />
						</td>
					</tr>
					<tr >
						<td class="editTableTitle" >��Ӫ�̣�</td>
						<td class="editTableContent">��Ӫ�̣�
						<html:select name="jiaofeiDataFrom" property="yunyingshang" 
								styleClass="commonTextFieldHover"  styleId="yunyingshang"
								onfocus="this.className='commonTextFieldMove'"  
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">--��ѡ��--</html:option>
								<html:option value="����">����</html:option>
								<html:option value="��ͨ">��ͨ</html:option>
								<html:option value="���">���</html:option>
								<html:option value="��ͨ">��ͨ</html:option>
								<html:option value="�췿">�췿</html:option>
							</html:select>	<a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >���ѣ�</td>
						<td class="editTableContent" >
						<html:radio property="zhongkuandai" value="0" onclick="ischeckk(this);" value="����" >����</html:radio>
					    <script type="text/javascript">
						function ischeckk(v){
							var asd = v.checked;
								if(asd){
									document.forms[0].wangluo.style.visibility = "";
									document.forms[0].dianshi.style.visibility = "hidden";
									document.forms[0].dianhua.style.visibility = "hidden";
									
									document.forms[0].kuandaifei.readOnly = false;
									document.forms[0].shoushifei.readOnly = true;
									document.forms[0].shoushifei.value = 0;
									
									document.forms[0].dianshi.value = 0;
									document.forms[0].dianhua.value = 0;
									zongfei();
								}else{
									document.forms[0].wangluo.style.visibility = "hidden";
								}
							}
						</script> 
						<html:select name="jiaofeiDataFrom" property="wangluo" style="visibility: visible;  "
								styleClass="commonTextFieldHover"  
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">-��ѡ��-</html:option>
									<html:option value="1M">1M</html:option>
								<html:option value="2M">2M</html:option>
								<html:option value="3M">3M</html:option>
								<html:option value="4M">4M</html:option>
								<html:option value="6M">6M</html:option>
								<html:option value="10M">10M</html:option>
								<html:option value="12M">12M</html:option>
								<html:option value="20M">20M</html:option>
								<html:option value="50M">50M</html:option>
								<html:option value="100M">100M</html:option>
						</html:select>  
						<html:radio property="zhongkuandai" value="0" onclick="ischeckd(this);" value="����">����</html:radio>
			     		<script type="text/javascript">
						function ischeckd(v){
							var asd = v.checked;
								if(asd){
									document.forms[0].dianshi.style.visibility = "";
									document.forms[0].wangluo.style.visibility = "hidden";
									document.forms[0].dianhua.style.visibility = "hidden";
									
									document.forms[0].kuandaifei.readOnly = true;
									document.forms[0].kuandaifei.value = 0;
									document.forms[0].shoushifei.readOnly = false;
									document.forms[0].wangluo.value = 0;
									zongfei();
								}else{
									document.forms[0].dianshi.style.visibility = "hidden";
								}
							}
						</script> 
						
						<html:select name="jiaofeiDataFrom" property="dianshi" style="visibility: hidden; "
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">-��ѡ��-</html:option>
								<html:option value="����">����</html:option>
								<html:option value="��������">��������</html:option>
								<html:option value="��������">��������</html:option>
								<html:option value="�ĸ�����">�ĸ�����</html:option>
								<html:option value="����">����</html:option>
								<html:option value="��������">��������</html:option>
								<html:option value="��������">��������</html:option>
								<html:option value="�ĸ�����">�ĸ�����</html:option>
								<html:option value="�ߵ�">�ߵ�</html:option>
						</html:select>  
						
						<html:radio property="zhongkuandai" value="0" onclick="ischeckw(this);" value="�绰">�绰</html:radio>
			     		<script type="text/javascript">
						function ischeckw(v){
							var asd = v.checked;
								if(asd){
									document.forms[0].dianshi.style.visibility = "hidden";
									document.forms[0].wangluo.style.visibility = "hidden";
									document.forms[0].dianhua.style.visibility = "";
									
									document.forms[0].kuandaifei.readOnly = true;
									document.forms[0].kuandaifei.value = 0;
									document.forms[0].shoushifei.readOnly = true;
									document.forms[0].shoushifei.value = 0;
									//document.forms[0].wangluo.value = 0;
									zongfei();
								}else{
									document.forms[0].dianshi.style.visibility = "hidden";
									document.forms[0].wangluo.style.visibility = "hidden";
								}
							}
						</script> 
						
						<html:select name="jiaofeiDataFrom" property="dianhua" style="visibility: hidden; "
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="0">-��ѡ��-</html:option>
								<html:option value="��ͨ">��ͨ</html:option>
						</html:select>  
						 &nbsp; &nbsp; <a:need />
						</td>
					</tr>
					
					<tr height="35px">
						<td class="editTableTitle" >ʱ�䣺</td>
						<td class="editTableContent">
						ҵ�񿪻�ʱ�䣺
						 <html:text name="jiaofeiDataFrom" property="kaijishijian" styleId="kaijishijians" size="10" onclick="WdatePicker({el:'kaijishijians'})" />
						 <img onclick="WdatePicker({el:'kaijishijians'})" 
							  src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" 
							  width="16" 
							  height="22" 
							 align="absmiddle"/>  
							 <a:need />
						ҵ��ͣ��ʱ�䣺
						 <html:text name="jiaofeiDataFrom" property="tingjishijian" styleId="tingjishijians" size="10" onclick="WdatePicker({el:'tingjishijians'})"  />
						<img onclick="WdatePicker({el:'tingjishijians'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>  <a:need />
						<br />
						�տ�ʱ�䣺
						 <html:text name="jiaofeiDataFrom" property="shoukuanshijian" styleId="shoukuanshijian" size="10" onclick="WdatePicker({el:'shoukuanshijian'})"  />
						<img onclick="WdatePicker({el:'shoukuanshijian'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/>  <a:need />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >�շѣ�</td>
						<td class="editTableContent" >
							����ѣ�
							<html:text name="jiaofeiDataFrom" property="kuandaifei" maxlength="50"  onchange="zongfei();" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
									
							���ӷѣ�
							<html:text name="jiaofeiDataFrom" property="shoushifei" maxlength="50" readonly="true" onchange="zongfei();" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							<br/>
							ONUѺ��
							<html:text name="jiaofeiDataFrom" property="onuyj" maxlength="50" onchange="zongfei();" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							������Ѻ��
							<html:text name="jiaofeiDataFrom" property="jidingheyj" maxlength="50" onchange="zongfei();" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
									<br/>
							��ѣ�
							<html:text name="jiaofeiDataFrom" property="nianfei" maxlength="50" onchange="zongfei();" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
							���շѣ�
							<html:text name="jiaofeiDataFrom" property="zongshoufei" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						 <script type="text/javascript">
							var wangluo =	document.forms[0].wangluo.value ;
							var dianshi =	document.forms[0].dianshi.value ;
							var dianhua =	document.forms[0].dianhua.value ;
							if(dianshi != 0){
								document.forms[0].dianshi.style.visibility = "";
								document.forms[0].wangluo.style.visibility = "hidden";
								document.forms[0].dianhua.style.visibility = "hidden";
								document.forms[0].kuandaifei.readOnly = true;
								document.forms[0].shoushifei.readOnly = false;
							}
							if(wangluo != 0){
								document.forms[0].dianshi.style.visibility = "hidden";
								document.forms[0].wangluo.style.visibility = "";
								document.forms[0].dianhua.style.visibility = "hidden";
								document.forms[0].kuandaifei.readOnly = false;
								document.forms[0].shoushifei.readOnly = true;
							}
							if(dianhua != 0){
								document.forms[0].dianshi.style.visibility = "hidden";
								document.forms[0].wangluo.style.visibility = "hidden";
								document.forms[0].dianhua.style.visibility = "";
								document.forms[0].kuandaifei.readOnly = false;
								document.forms[0].shoushifei.readOnly = false;
							}
						</script>  
						<script type="text/javascript">
							function zongfei(){
									var kf = document.forms[0].kuandaifei.value;
									var sf = document.forms[0].shoushifei.value;
									var oyf = document.forms[0].onuyj.value;
									var jyf = document.forms[0].jidingheyj.value ;
									var nf = document.forms[0].nianfei.value;
									document.forms[0].zongshoufei.value = Number(kf) + Number(sf) + Number(oyf) + Number(jyf) + Number(nf);
							}
						</script>
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >ҵ��</td>
						<td class="editTableContent" >
						ҵ������������
							<html:text name="jiaofeiDataFrom" property="yewu" maxlength="150" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/>
						�վݺţ�
							<html:text name="jiaofeiDataFrom" property="shoujubenhao" maxlength="50"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><a:need />
									<br/>
										
						ʩ���ˣ�
							<html:text name="jiaofeiDataFrom" property="shigongren" maxlength="150" 
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'"/><a:need />
						
						�༭ʱ�䣺
 						<html:text name="jiaofeiDataFrom" property="nowdata" styleId="nowdata" size="20" readonly="true" />
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >��Ʊ��Ϣ��</td>
						<td class="editTableContentLast" >
							<html:textarea name="jiaofeiDataFrom" property="kaipiaoxinxi"  
							rows="5" cols="70"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
							</html:textarea>
						</td>
					</tr>
					<tr height="35px">
						<td class="editTableTitle" >��ע��</td>
						<td class="editTableContentLast" >
							<html:textarea name="jiaofeiDataFrom" property="beizhuhuizong"  
							rows="5" cols="70"  onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
							</html:textarea>
						</td>
					</tr>
					
				</table>
				</div>
			</div>
			<!--  �����༭ end -->
			<!-- button -->
			<div name="button" class="content_button">
				<html:button property="btnSave" value="�ύ" styleClass="commonButton" onclick=" sub();"/>
				<html:button property="btnBack" value="����" styleClass="commonButton" onclick="commonSubmit('chulidaijiaofeiDataList.do?act=init')"/> 
			</div>
		</div>
		<html:hidden name="jiaofeiDataFrom" property="nowdataHidden" />
		<html:hidden name="jiaofeiDataFrom" property="UUID" />
		</html:form>
	</body>
	<script type="text/javascript">
	function sub(){
		if(checkInput()){
			commonSubmit('shenqingDataEdit.do?act=updateDaiJiaofei');
			}
	}
	checkInput = function(){
		var dizhi = document.forms[0].dizhi.value;
		if(dizhi==null||trim(dizhi)==""){
			alert("��ַ������д��");
			document.forms[0].dizhi.focus();//���ý���
			return false;
			}
		var yunyingshang = document.forms[0].yunyingshang.value;
		if(yunyingshang==null||trim(yunyingshang)=="0"){
			alert("��Ӫ�̲���Ϊ�գ�");
			document.forms[0].yunyingshang.focus();//���ý���
			return false;
		}
		var kaijishijian = document.forms[0].kaijishijian.value;
		if(kaijishijian==null||trim(kaijishijian)==""){
			alert("ҵ�񿪻�ʱ�������д��");
			document.forms[0].kaijishijian.focus();//���ý���
			return false;
			}
	
		var tingjishijian = document.forms[0].tingjishijian.value;
		if(tingjishijian==null||trim(tingjishijian)==""){
			alert("ҵ��ͣ��ʱ�������д��");
			document.forms[0].tingjishijian.focus();//���ý���
			return false;
			}
			
		var shoukuanshijian = document.forms[0].shoukuanshijian.value;
		if(shoukuanshijian==null||trim(shoukuanshijian)==""){
			alert("�տ�ʱ�������д��");
			document.forms[0].shoukuanshijian.focus();//���ý���
			return false;
			}
			
		var shoujubenhao = document.forms[0].shoujubenhao.value;
		if(shoujubenhao==null||trim(shoujubenhao)==""){
			alert("�վݺű�����д��");
			document.forms[0].shoujubenhao.focus();//���ý���
			return false;
			}
			
		var shigongren = document.forms[0].shigongren.value;
		if(shigongren==null||trim(shigongren)==""){
			alert("ʩ���˱�����д��");
			document.forms[0].shigongren.focus();//���ý���
			return false;
			}
			
		var nianfei = document.forms[0].nianfei.value;
		if(nianfei != "") {
			if(isNaN(nianfei)){
				alert("������������֣�");
				document.forms[0].nianfei.focus();//���ý���
				return false;
				}
		}	
			
		var kuandaifei = document.forms[0].kuandaifei.value;
		if(kuandaifei != "") {
			if(isNaN(kuandaifei)){
				alert("��������������֣�");
				document.forms[0].kuandaifei.focus();//���ý���
				return false;
				}
		}
			
		var shoushifei = document.forms[0].shoushifei.value;
		if(shoushifei!="")
		{
			if(isNaN(shoushifei)){
				alert("���ӷ����������֣�");
				document.forms[0].shoushifei.focus();//���ý���
				return false;
				}
		}
			
		var onuyj = document.forms[0].onuyj.value;
		if(onuyj!="")
		{
			if(isNaN(onuyj)){
				alert("onjѺ�����������֣�");
				document.forms[0].onuyj.focus();//���ý���
				return false;
				}
		}
			
		var jidingheyj = document.forms[0].jidingheyj.value;
		if(jidingheyj!="")
		{
			if(isNaN(jidingheyj)){
				alert("������Ѻ�����������֣�");
				document.forms[0].jidingheyj.focus();//���ý���
				return false;
				}
		}
		var kaijishijian = document.forms[0].kaijishijian.value;
		var tingjishijian = document.forms[0].tingjishijian.value;
		var sta =  /^\d{4}[-](\d{2})[-]\d{2}$/.test(kaijishijian);
		var sta1 =  /^\d{4}[-](\d{2})[-]\d{2}$/.test(tingjishijian);
		if (sta == false || sta1 == false) {
			alert("������ͣ��������������");
			return false;
		}
		var ischeck1 = document.forms[0].zhongkuandai[0].checked;
		var ischeck2 = document.forms[0].zhongkuandai[1].checked;
		var ischeck3 = document.forms[0].zhongkuandai[2].checked;
		if(ischeck1){
		     var wangluo = document.forms[0].wangluo.value;
			 if(wangluo == 0) {
			 	alert("������ѡ��");
				return false;
			 }
			 document.forms[0].dianshi.value = "0";
			 document.forms[0].dianhua.value = "0";
		}else if(ischeck2){
		 	 var dianshi = document.forms[0].dianshi.value;
			 if(dianshi == 0) {
			 	alert("������ѡ��");
				return false;
			 }
			 document.forms[0].wangluo.value = "0";
			 document.forms[0].dianhua.value = "0";
		} else {
			 var dianhua = document.forms[0].dianhua.value;
			 if(dianhua == 0) {
			 	alert("�绰��ѡ��");
				return false;
			 }
			 document.forms[0].wangluo.value = "0";
		 	 document.forms[0].dianshi.value = "0";
		}
		
		/* var qjjh = document.forms[0].qjjh.value;
		if(qjjh!=null&&trim(qjjh)!=""){
			if(!isDigit(qjjh)){
				alert("�ƻ�ȡ���������������֣�");
				document.forms[0].qjjh.focus();//���ý���
				return false;
				}
			}else{
				document.forms[0].qjjh.value=9999;
				} */
		return true;
	};
	
</script>
</html>