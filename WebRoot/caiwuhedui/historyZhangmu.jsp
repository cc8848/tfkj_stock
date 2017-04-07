<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2012-11-23     Zhu,Xiao-Lei     Create
   
  -->
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
		<script src="yonghushuju/yonghuData.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
		<script>
			var idStr="";
   	  		arrayCheckId = new Array();//��ѡID����
     	</script>
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="historyList.do">
			<bean:define id="xiaoquList" name="zhangmuForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					��ʷ��Ŀ
				</div>
				<div id="conten_query2">
				<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
						
							<td width="50px">
								�����:
							</td>
							<td>
								<html:text name="zhangmuForm" property="cunkuanren" size="12"/>
							</td>
							<td>
								&nbsp;��ʼʱ��
							</td>
							
							<td>
							    <html:text name="zhangmuForm" property="cunkuanshijians" styleId="cunkuanshijians" size="10" onclick="WdatePicker({el:'cunkuanshijians'})" />
								<img onclick="WdatePicker({el:'cunkuanshijians'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
								</img>
							</td>
							<td>
								&nbsp;������ʱ��
							</td>
							
							<td>
							    <html:text name="zhangmuForm" property="cunkuanshijiane" styleId="cunkuanshijiane" size="10" onclick="WdatePicker({el:'cunkuanshijiane'})" />
								<img onclick="WdatePicker({el:'cunkuanshijiane'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
								</img>
							</td>
							<td> ������У�</td>
							<td>
						 		<html:select name="zhangmuForm" property="cunkuanyinhang"  
										styleClass="commonTextFieldHover"  
										onfocus="this.className='commonTextFieldMove'" 
										onblur="this.className='commonTextFieldHover'">
						    <html:option value="">-��ѡ��-</html:option>
							<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							
								</td>
								
							<td width="50px">
								�����:
							</td>
							<td>
								<html:text name="zhangmuForm" property="wangdianhao" size="12"/>
							</td>
							
							<td width="60px">
								�����:
							</td>
							<td>
								<html:text name="zhangmuForm" property="cunkuanjine" size="12"/>
							</td>
							<td align="right">
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('historyList.do?act=query&zhuangtai=3')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result">
					<!-- ��ҳͷ -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" /> 
					</div>
					<!-- ���һ�� start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="100%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�������&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��Ϣ����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���շѺϼƽ��&nbsp;
								</td>
								
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<%-- <input name="zmUUID" type="radio" value="${line.id}" /> --%>
										<input name="UUIDS" type="checkbox" onclick="choseItem(this);" value="${line.id}" id="${line.id}"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cunkuanren" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cunkuanshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cunkuanyinhang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangdianhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cunkuanjine" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xinxishuliang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="zongshoufeiheji" />
									</td>
								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- ���һ�� end-->
					<div name="page_down" class="page_downuser">
						<div align="right">
							<jsp:include page="/caiwuhedui/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- ��ѯ��� end -->
				<!-- button -->
				<div id="buttonC" name="button" class="content_button" >

				
				 <!--  <html:button property="btnSave" value="����ͳ�Ʊ�" styleClass="commonButton3" onclick="commonCheckSubmit('zhangmuDataInsert.do?act=downHuiZongTongJi','zmUUID','��ѡ��Ҫ��������ͳ�Ʊ����Ŀ��')"/>
				  <html:button property="btnSave" value="�շѴ����ϸ" styleClass="commonButton3" onclick="commonCheckSubmit('zhangmuDataInsert.do?act=downCunKuanMingXi','zmUUID','��ѡ��Ҫ���������ϸ�����Ŀ��')"/>
				  <html:button property="btnSave" value="���Ŵ�����ϸ" styleClass="commonButton3" onclick="commonCheckSubmit('zhangmuDataInsert.do?act=downDianXinShouFei','zmUUID','��ѡ��Ҫ�������Ŵ��շѴ����ϸ�����Ŀ��')"/>
				  <html:button property="btnSave" value="����ռ��˱�" styleClass="commonButton3" onclick="commonSubmit('zhangmuDataInsert.do?act=downYHRiJiZhang')"/>
				  <html:button property="btnSave" value="�ύ����ʷ��Ŀ" styleClass="commonButton3" onclick="commonCheckSubmit('reportformsList.do?act=subAccount','zmUUID','��ѡ��Ҫ�ύ����Ŀ')"/> -->
			  <!--<html:button property="btnSave" value="ɾ��" styleClass="commonButton" onclick="removeData()"/>-->
			  	  <html:button property="btnSave" value="ȫѡ" styleClass="commonButton" onclick="isCheck()"/>	

			  	  <html:button property="btnSave" value="��Ϣ��ѯ" styleClass="commonButton2" onclick="subsave();"/>
			  	  <html:button property="btnSave" value="�����˻�" styleClass="commonButton2" onclick="commonCheckSubmit('historyList.do?act=backAccount','UUIDS','��ѡҪ���˵���Ŀ���ݣ�')"/>
			    </div>
			</div>
			<html:hidden name="zhangmuForm" property="UUIDHidden" />
	   <script>
			      		//var value = document.getElementsByTagName("input");
			      		//zongshoufei = value[value.length - 3].value;
			      		//zongshoufei = Number(zongshoufei);
			      		var value = document.getElementsByTagName("input");
			      		Struuid = value[value.length - 1].value;
			      		
			   	  		function choseItem(obj1) { 
			   	  		    var a = obj1.value;
		   	  				if(obj1.checked) {
								arrayCheckId.push(a);
								//alert(arrayCheckId);
		   	  				}else{
						     	for (var i = 0; i < arrayCheckId.length; i++) {        
						           if (arrayCheckId[i] == a) {
						           		arrayCheckId.splice(i,1);
						           }
						     	}  
		   	  				}
		   	  				//alert(arrayCheckId);
						} 
					
		 </script>
			
		</html:form>
	</div>
	</body>
	<script type="text/javascript"  language="javascript">
		function  hiddenEditDiv() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			switch (roleCode) {         
			        case '5': 
			 			break;               
			    	 case '4':               
			            document.getElementById("buttonC").style.display="none";  
			            break;       
			} 
		}
		hiddenEditDiv();	
		
		var allCheck = false;
		
		function isCheck(){
			var code_Values = document.getElementsByTagName("input"); 
			for(var i = 0;i < code_Values.length;i++) {
				if(code_Values[i].type == "checkbox" && code_Values[i].checked) {
					uncheckAll();
					allCheck = false;
					break;
				} else {
					allCheck = true;
				}
			}
			if(allCheck==true){
				checkAll();
			}
			/* if(allCheck==false){
				checkAll();
				allCheck=true;
			}else{
				uncheckAll();
				allCheck=false;
			} */
		}
		
		function checkAll() { 
		var code_Values = document.getElementsByTagName("input"); 
			for(var i = 0;i < code_Values.length;i++) { 
				if(code_Values[i].type == "checkbox") { 
				code_Values[i].checked = true; 
				arrayCheckId.push(code_Values[i].value);
					
				
				} 
			} 
			//alert(arrayCheckId);
		} 
		function uncheckAll() { 
			var code_Values = document.getElementsByTagName("input"); 
			for(var i = 0;i < code_Values.length;i++) { 
					if(code_Values[i].type == "checkbox") { 
						code_Values[i].checked = false; 
						for (var j = 0; j < arrayCheckId.length; j++) {        
						           if (arrayCheckId[j] == code_Values[i].value) {
						           		arrayCheckId.splice(j,1);
						           }
						}   
					} 
			} 
			//alert(arrayCheckId);
		} 
	
		
		
			function checkbox() {
			var arrayUUID = new Array();
			var idSrt="";
			var value = document.getElementsByTagName("input");	   
			var UUIDHidden = value[value.length - 1].value;  
		
			//alert(zhifuleixingHidden);
			if(UUIDHidden != "" && UUIDHidden != null) {	
			 	var s = UUIDHidden.indexOf(",",0);
			 
			 	while(s>-1){
				 	var uuid =UUIDHidden.substring(0,s);
				 	UUIDHidden = UUIDHidden.substring(s+1,UUIDHidden.length);
					arrayUUID.push(uuid);
					s = UUIDHidden.indexOf(",",0);
					
				}
				arrayUUID.push(UUIDHidden);
				//alert("arrayUUID:="+arrayUUID);
				for(var i = 0 ; i < arrayUUID.length; i ++){
					var ishaveid = document.getElementById(arrayUUID[i]);
					if(ishaveid != null){
						ishaveid.checked = true; 
						arrayCheckId.push(arrayUUID[i]);
					}else{
						idSrt +="," + arrayUUID[i];
					}
				}
				//alert("arrayCheckId = " + arrayCheckId);
				idSrt = idSrt.replace(/^,{1}/,""); 
				value[value.length - 1].value = idSrt ;
			}
		}
		checkbox();
		
		function  decide() {
			var idnStr = value[value.length - 1].value;
			for(var i =0 ; i < arrayCheckId.length;i++){
				var id = arrayCheckId[i];
				idnStr += ","+id;
			}
			idnStr = idnStr.replace(/^,{1}/,""); 
			value[value.length - 1].value = idnStr;
			
			//alert(idnStr);
				
		}
		
		function  subsave() {
			if(check()){
				commonSubmit('zhangmuDatasList.do?act=init');
			}
		}
			check = function(){
			//alert("check");
				var value = document.getElementsByTagName("input");
				
				
				//�������� ��ӵ�ǰҳ����ѡID
				idStr = value[value.length - 1].value;
				for(var i =0 ; i<arrayCheckId.length;i++){
					var id = arrayCheckId[i];
					idStr += ","+id;
				}
			    idStr = idStr.replace(/^,{1}/,""); 
				
			
				value[value.length - 1].value = idStr;
			
				return true;
			};
	</script>
</html>
