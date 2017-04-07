<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>���ٿ��������ʾ��Ŀ</title>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<script type="text/javascript">
		//����XMLHttpRequest����   
		function createXMLHttpRequest() {
			if (window.XMLHttpRequest) { //Mozilla �����
				XMLHttpReq = new XMLHttpRequest();
			} else {
				if (window.ActiveXObject) { // IE�����			
					try {
							XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
						} 
					catch (e) {
							try {
								XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
							} 
							catch (e){}
						}
				}
			}
		}
		//��������
		function sendRequest(url, params, method) {
			if (method) {
				if (method.toLowerCase("post")) {
					sendRequestPost(url, params);
				} else {
					if (method.toLowerCase("get")) {
						sendRequestGet(url + "?" + params);
					} else {
					}
				}
			} else {
				alert("\u63d0\u4ea4\u65b9\u5f0f\u4e0d\u80fd\u4e3a\u7a7a\uff01");
			}
		}
		//post����������
		function sendRequestPost(url, params) {
			params=encodeURI(params); 
	        params=encodeURI(params);  
			createXMLHttpRequest();
			XMLHttpReq.open("POST", url, true);
			XMLHttpReq.onreadystatechange = processResponse;//ָ����Ӧ����
			XMLHttpReq.setRequestHeader("Content-Type" , "application/x-www-form-urlencoded ; charset=GBK");
			XMLHttpReq.send(params); // ��������
		}
		//get����������
		function sendRequestGet(url) {
			createXMLHttpRequest();
			XMLHttpReq.open("GET", url, true);
			XMLHttpReq.onreadystatechange = processResponse;//ָ����Ӧ����
			XMLHttpReq.send(null); // ��������
		}
		//post����������(���贫�ݲ���ʱ)
		function sendRequestPostwihtnoArgs(url) {
			createXMLHttpRequest();
			XMLHttpReq.open("POST", url, true);
			XMLHttpReq.onreadystatechange = processResponse;//ָ���ص�����
			XMLHttpReq.send(null); // ��������
		}
		// ��������Ϣ����
		function processResponse() {
			if (XMLHttpReq.readyState == 4) { // �ж϶���״̬
				if (XMLHttpReq.status == 200) { //��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
				//����1�ļ������ڡ�����0�ļ����ڡ�
					var res = XMLHttpReq.responseText;
					var isres = res.slice(0, 1);
					if(isres == 1) {
						alert("���ݵ����쳣��");
					} 
					if(isres == 0) {
						res = res.slice(1, res.length);
						window.location.href='http://'+res+':8080/tfkj_stock/excel/gongzuoliang.xls';
					}
				} else { 
					
				}
			}
		}
		//commonSubmit('importExcelList.do?act=downExcel')
		function findStubyClasslId() {
				var sURL = "importExcelList.do?act=downExcel";
				var method = "post";
				var sParams = "";
				sendRequest(sURL, sParams, method);
	}
	</script>
	</head>
	<body onload="init()">
		<html:form action="gongzuoliangList.do" >
		<bean:define id="xiaoquList" name="totalForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					ͳ������
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">
			
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								<script >
								var  arrayObj = new Array();
								</script>
								<logic:iterate  id="xiaoquList" name="totalForm"  property="xiaoquList" >
								 	<script  >
									 var temp = '<bean:write  name="xiaoquList"  property="key" />' ;
									 arrayObj.push(temp);
									</script> 
								 </logic:iterate> 
								<input type="button" value="С��ѡ��" onclick="show_child();"/>
								<html:textarea name="totalForm" property="xiaoqutext" rows="1" cols="30"  readonly="true"></html:textarea>
								 <script> 
								function show_child() 
								{ 
								var child=window.showModalDialog('total/modal.htm',arrayObj,'dialogWidth=760px ; dialogHeight=500px');
									 if(!child.closed) 
									 { 
										if(!window.close()) 
										{ 
											//document.getElementById("txt0").value = child;
											//alert(child);
											document.forms[0].xiaoqutext.value = child;
										} 
										else 
										{ 
											window.close(); 
											child.close(); 
										} 
									}
								} 
								</script> 
							</td>
							<td width="60px">
								ʱ������
							</td>
							<td>
								<html:select name="totalForm" property="shijianleixing"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:option value="1">����ʱ��</html:option>
									<html:option value="2">ͣ��ʱ��</html:option>
									<html:option value="3">�տ�����</html:option>
									<html:option value="4">��Чʱ��</html:option>
								</html:select>
							    
							</td>
							<td>
								��ʼʱ��
							</td>
							<td>
								<html:text name="totalForm" property="kaijis" styleId="kaijis" size="10" onclick="WdatePicker({el:'kaijis'})" />
								<img onclick="WdatePicker({el:'kaijis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
							    
							</td>
							<td>
								����ʱ��
							</td>
							<td>
								<html:text name="totalForm" property="kaijie" styleId="kaijie" size="10" onclick="WdatePicker({el:'kaijie'})" />
								<img onclick="WdatePicker({el:'kaijie'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
							    
							</td>
						
							
							<td align="right">
								<input type="button" value="ͳ��" class="commonButton" onclick="sub();" />
								  <html:button property="btnSave" value="����" styleClass="commonButton" onclick="findStubyClasslId();"/>
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				
				<!-- ��ѯ��� start -->
				<div  class="conten_result4">
					<!-- ��ҳͷ -->
					<div  class="page_up">
						<!--  <jsp:include page="/common/paginationHeader.jsp" />  -->
					</div>
					
					<!-- ���һ�� start-->
					<div  class="result_table3">
					
						<table border="0" cellspacing="0" cellpadding="1"  width="100%">
						<tr bgcolor="#EEF5FA" align="center">
							<td class="tableTitleLine" nowrap="nowrap" colspan="1" rowspan="2" >
								����
							</td >
							<td class="tableTitleLine" nowrap="nowrap" colspan="1"  rowspan="2">
								С������
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1" rowspan="2">
								����������
							</td >
							
							<td class="tableTitleLine"nowrap="nowrap" colspan="7" rowspan="1">
								��װ��
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1" rowspan="2" >
								ά����(�����ռ���
							</td >
							<td class="tableTitleLine"nowrap="nowrap" rowspan="2" colspan="1" >
								����
							</td >
							<td class="tableTitleLine"nowrap="nowrap" rowspan="2" colspan="1">
								�˶�
							</td >
							
						</tr>
						<tr bgcolor="#EEF5FA" align="center">
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								����
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								���
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								�绰
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								����
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								�ײ�
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								�뻧��
							</td >
							<td class="tableTitleLine"nowrap="nowrap" colspan="1">
								�״��뻧��
							</td >
						</tr>
						

						<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="riqi" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="shigongren" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="dianshi" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="kuandai" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="dianhua" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="dankuan" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="taocan" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="ruhushu" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="shoucirujushu" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="weixiushu" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="xufei" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="tuiding" /> 
									</td >
									
								</tr>
						</logic:iterate>
						</table>
					</div>
					
					<!-- ���һ�� end-->
					<div name="page_down" class="page_down">
						<div align="right">
						 <!-- 	<jsp:include page="/common/paginationFooter.jsp" />  -->
						</div>
					</div>
				</div>
			</div>
			<html:hidden name="totalForm" property="xiaoquHidden" />
			<html:hidden name="totalForm" property="kaijisHidden" />
			<html:hidden name="totalForm" property="kaijieHidden" />
			<html:hidden name="totalForm" property="shijianleixingHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	function sub(){
			if(checkInput()) {
					commonSubmit('gongzuoliangList.do?act=query');
				}
			}
			
		checkInput = function()
		{
	  		var kaijis = document.forms[0].kaijis.value;
			var kaijie = document.forms[0].kaijie.value;
			if ((kaijis != null || trim(kaijis) != "") && (kaijie == null || trim(kaijie) == "")) {
					alert("����ʱ�䲻��Ϊ�գ�");
					document.forms[0].kaijis.focus();//���ý���
					return false;
			}
				
			if ((kaijis == null || trim(kaijis) == "") && (kaijie != null || trim(kaijie) != "")) {
					alert("��ʼʱ�䲻��Ϊ�գ�");
					document.forms[0].kaijis.focus();//���ý���
					return false;
			} 
		    var shijianleixing = document.forms[0].shijianleixing.value;
		    if (trim(shijianleixing) == "") {
					alert("��ѡ��ʱ�����ͣ�");
					document.forms[0].shijianleixing.focus();//���ý���
					return false;
			} 
			
			var d = DateDiff(kaijis, kaijie);
			if (d > 40) {
				alert("ʱ���ȴ���40�죬������ѡ�����ʱ�䣡");
				return false;
			}
			/* if(tingjis<kaijis)
			{
				alert("����ʱ������ڿ�ʼʱ�䣡");
				return false;
			}  */
				return true;
		 };
		 
		  function DateDiff(sDate1,sDate2) { 
		    var arrDate,objDate1,objDate2,intDays;
		    arrDate=sDate1.split("-");
		    objDate1=new Date(arrDate[1]+'-'+arrDate[2]+'-'+arrDate[0]);
		    arrDate=sDate2.split("-");
		    objDate2=new Date(arrDate[1] + '-'+arrDate[2]+'-'+arrDate[0]);
		    intDays=parseInt(Math.abs(objDate1-objDate2)/1000/60/60/24);
		    return intDays;
		}
		 
		  function autoSubimit(){
				if (event.keyCode == 13) {
					sub();
				}
			}
	</script>
</html>
