<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>快速开发框架演示项目</title>
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
		<style>
		.checkbox {
 			background-Color:e-xpression(this.checked?'yellow':'buttonface');
		}
		</style>
		<script>
			var ztStr="";
			var idStr="";
   	  		var zongshoufei = 0;
   	  		arrayCheck = new Array();//已选状态数组
   	  		arrayCheckId = new Array();//已选ID数组
     	</script>
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="accountsmateList.do">
		<bean:define id="xiaoquList" name="zhangmuForm" property="xiaoquList"></bean:define>
		<bean:define id="statusList" name="zhangmuForm" property="statusList"></bean:define>
		<bean:define id="senList" name="zhangmuForm" property="senList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					匹配账目
				</div>
				<!-- 查询条件 -->
				<div id="conten_query3">
					<table id="quert_table"  align="center" cellpadding="1" cellspacing="1" border="1">
						<tr  align="center">
							<td width="60px">
								<font style="font-weight: bold;">存款人:</font>
							</td>
							<td>
							<html:text name="zhangmuForm" property="cunkuanren" readonly="true" size="8"/>
							<html:hidden name="zhangmuForm" property="zmUUID"  />
							</td >
							
							<td width="60px">
								<font style="font-weight: bold;">存款时间:</font>
							</td>
							<td >
								<html:text name="zhangmuForm" property="cunkuanshijian" readonly="true" size="10"/>
							</td>
							
							<td width="60px">
								<font style="font-weight: bold;">存款银行:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="cunkuanyinhang" readonly="true" size="8"/>
							</td >
							
							<td width="60px">
								<font style="font-weight: bold;">网点号:</font>
							</td >
							<td>
								<html:text name="zhangmuForm" property="wangdianhao" readonly="true" size="8"/>
							</td>
							
							<td width="60px">
								<font style="font-weight: bold;">存款金额:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="cunkuanjine" readonly="true" size="6"/>
							</td>
							<td width="100px">
								<font style="font-weight: bold;">总收费合计金额:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="zongshoufeiheji" readonly="true" size="6"/>
							</td>
							<td width="45px">
								<font style="font-weight: bold;">差值:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="chazhi" readonly="true" size="6"/>
							</td>
							<td width="60px">
								<font style="font-weight: bold;">信息数量:</font>
							</td>
							<td>
								<html:text name="zhangmuForm" property="xinxishuliang" readonly="true" size="4"/>
							</td>
						</tr>
					</table>
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
						<td width="50px">
<script>
var arrayObj = new Array();
</script>
	<logic:iterate id="xiaoquList" name="zhangmuForm"  property="xiaoquList">
<script>
var temp = '<bean:write  name="xiaoquList"  property="key" />';
arrayObj.push(temp);
</script>
	</logic:iterate>
	<td>
	<input type="button" value="小区选择" onclick="show_child();" />
	<html:textarea name="zhangmuForm" property="quyuCode" rows="1"
									cols="35px" readonly="true"></html:textarea>
	</td>
	<script>
function show_child() {
	var child = window.showModalDialog('total/modal.htm', arrayObj,
			'dialogWidth=760px ; dialogHeight=500px');
	if (!child.closed) {
		if (!window.close()) {
			//document.getElementById("txt0").value = child;
			//alert(child);
			document.forms[0].quyuCode.value = child;
		} else {
			window.close();
			child.close();
		}
	}
}
</script>
</td>
							<td width="30px">
								地址
							</td>
							<td>
								<html:text name="zhangmuForm" property="addressCode" size="12"/>
							</td>
						<td width="55px">
								时间类型
							</td>
							<td>
								<html:select name="zhangmuForm" property="shijianleixing" 
									styleClass="commonTextFieldHover"  
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value=""  >-请选择-</html:option>
									<html:option value="1">开机时间</html:option>
									<html:option value="2">停机时间</html:option>
									<html:option value="3">收款日期</html:option>
								</html:select>
							  
							</td>
							<td>
								开始时间
							</td>
							<td>
								<html:text name="zhangmuForm" property="kaijis" styleId="kaijis" size="10" onclick="WdatePicker({el:'kaijis'})" />
								<img onclick="WdatePicker({el:'kaijis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							    
							</td>
							<td>
								结束时间
							</td>
							<td>
								<html:text name="zhangmuForm" property="kaijie" styleId="kaijie" size="10" onclick="WdatePicker({el:'kaijie'})" />
								<img onclick="WdatePicker({el:'kaijie'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							    
							</td>
							<td>
								状态
							</td>
							<td>
								<html:select name="zhangmuForm" property="stateCode"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:options collection="statusList" property="key" labelProperty="value" />
								</html:select>
							</td>
							</tr>
							<tr>
							<td width="55px">
								综合查询
							</td>
							<td>
								<html:select name="zhangmuForm" property="sen1"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:options collection="senList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								等于
							</td>
							<td>
								<html:text name="zhangmuForm" property="senValue1" size="12" />
							</td>
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('accountsmateList.do?act=query&type=1')" />
							</td>
						</tr>
						</table>
				</div>
					
				<!-- 查询结果 start -->
				<div name="result" class="conten_result3">
					<!-- 分页头 -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- 结果一览 start-->
					<div name="result_table" class="result_table2">
						<table border="0" cellspacing="0" cellpadding="1" width="140%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收款类型&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									用户状态&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收款时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									姓名&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									小区&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									地址&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									开机时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									停机时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									网络&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									电视&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									电话&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									业务&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									总收费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收据本号/收据号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									开票信息&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									onu押金&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									机顶盒押金&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收视费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									宽带费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									初装费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									不足月费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									年费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									设备销售费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									材料费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									备注&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									施工人&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									现场备注&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									备注汇总&nbsp;
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUIDS" type="checkbox" value="${line.id}" onclick="choseItem(this);" id="id${line.id}"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap" id="zt${line.id}" >
										<html:select name="zhangmuForm" property="zhifuleixing"  
										styleClass="commonTextFieldHover"  
										onfocus="this.className='commonTextFieldMove'" 
										onblur="this.className='commonTextFieldHover'">
										<html:option value="-请选择-">-请选择-</html:option>
										<html:option value="pos机">pos机</html:option>
										<html:option value="pos机开票">pos机开票</html:option>
										<html:option value="现金">现金</html:option>
										<html:option value="开票">开票</html:option>
										<html:option value="支票">支票</html:option>
										<html:option value="支票开票">支票开票</html:option>
										<html:option value="电汇">电汇</html:option>
										<html:option value="电汇开票">电汇开票</html:option>
										</html:select>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yonghuzhuangtai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoukuanshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xingming" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaijishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="tingjishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangluo" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianshi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianhua" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yewu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap" id="${line.id}">
										<bean:write name="line" field="zongshoufei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoujubenhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaipiaoxinxi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="onuyj" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="jidingheyj" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoushifei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kuandaifei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="chuzhuangfei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="bzygf" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="nianfei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shebeixiaoshou" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cailiaofei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="beizhu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shigongren" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xianchangbeizhu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">ianhj
										<bean:write name="line" field="beizhuhuizong" />
									</td>
								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- 结果一览 end-->
					<div name="page_down" class="page_downuser">
						<div align="right"  >
							<jsp:include page="/caiwuhedui/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- 查询结果 end -->
				<!-- button -->
				<div id="buttonC" name="button" class="content_button" >
				 <!--  <html:button property="btnSave" value="保存" styleClass="commonButton" onclick="commonCheckSubmit('zhangMuEdit.do?act=insertPipeiZhangmu','UUIDS','请选择待匹配的数据')"/> -->
				  <html:button property="btnSave" value="保存" styleClass="commonButton" onclick="subsave();"/>
				  <html:button property="btnSave" value="返回" styleClass="commonButton" onclick="commonSubmit('moneymateList.do?act=init&zhuangtai=0')"/>
				  <br/>已勾选用户总收费：<input type="text" size="10" readonly="readonly"  id="txt"/>

				  
			      <script>
			      		var value = document.getElementsByTagName("input");
			      		zongshoufei = value[value.length - 3].value;
			      		zongshoufei = Number(zongshoufei);
			   	  		function choseItem(obj1) { 
			   	  		    var a = obj1.value;
			   	  			var value = document.getElementById(a).innerText;
			   	  			//var b = document.getElementById("zt"+a).firstChild.value;
							value = Number(value);
		   	  				if(obj1.checked) {
		   	  				    obj1.parentNode.parentNode.style.backgroundColor="#66FFFF";
								zongshoufei += value;
								document.getElementById("txt").value = zongshoufei; 
								arrayCheck.push("zt"+a);
								arrayCheckId.push(a);
								//alert(arrayCheck);   
						     	//alert(arrayCheckId);
		   	  				}else{
		   	  					obj1.parentNode.parentNode.style.backgroundColor="white";
		   	  					zongshoufei -= value;
								document.getElementById("txt").value = zongshoufei; 
								val = "zt"+a;
								for (var i = 0; i < arrayCheck.length; i++)  {        
						           if (arrayCheck[i] == val) {
						           		arrayCheck.splice(i, 1);   
						           }
						     	}  
						     	for (var i = 0; i < arrayCheckId.length; i++)  {        
						           if (arrayCheckId[i] == a) {
						           		arrayCheckId.splice(i,1);
						           }
						     	}  
						     	//alert(arrayCheck);   
						     	//alert(arrayCheckId);   
		   	  				}
						} 
						/* function isCheck(o) {
							
						
						 	var value = document.getElementsByTagName("input");
							value[value.length - 1].value = ztStr;
							var ischecka = document.getElementById(o).checked;
							if(ischecka)
							{
							    var b = document.getElementById("zt"+o).firstChild.value;
								var value = document.getElementsByTagName("input");
								ztStr = "" + b;
								value[value.length - 1].value = ztStr;
							} 
							
							//alert(b);
						}
						 */
			      </script>
			  <!--<html:button property="btnSave" value="编辑账目" styleClass="commonButton2" onclick="commonCheckSubmit('yonghuDataEdit.do?act=showInfo','UUID','请选择待查看的用户数据')"/>	-->
			  <!--<html:button property="btnSave" value="删除" styleClass="commonButton" onclick="removeData()"/>-->
			  <!--<html:button property="btnSave" value="添加" styleClass="commonButton" onclick="commonSubmit('paigongdanEdit.do?act=initInsert')"/>	-->
			  <!--<html:button property="btnSave" value="解绑" styleClass="commonButton" onclick="removeData1()"/>	-->
			    </div>
			</div>
			<html:hidden name="zhangmuForm" property="quyuCodeHidden" />
			<html:hidden name="zhangmuForm" property="addressCodeHidden" />
			<html:hidden name="zhangmuForm" property="stateCodeHidden" />
			<html:hidden name="zhangmuForm" property="shijianleixingHidden" />
			<html:hidden name="zhangmuForm" property="kaijisHidden" />
			<html:hidden name="zhangmuForm" property="kaijieHidden" />
			<html:hidden name="zhangmuForm" property="sen1Hidden" />
			<html:hidden name="zhangmuForm" property="senValue1Hidden" />
			<html:hidden name="zhangmuForm" property="zhangmuUUIDHidden" />
			<html:hidden name="zhangmuForm" property="zongshoufeiHidden" />
			<input type="hidden" name="UUIDHidden" />
			<html:hidden name="zhangmuForm" property="zhifuleixingHidden" />

		</html:form>
	</div>
	</body>
	<script type="text/javascript"  language="javascript">
		function  hiddenEditDiv() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			switch (roleCode) {         
			       
			} 
		}
		hiddenEditDiv();	
		function shoufei() {
			var value = document.getElementsByTagName("input");	   
			zongshoufei = Number(value[value.length - 3].value);   
			document.getElementById("txt").value = 	zongshoufei;
		}
		shoufei();
		function checkbox() {
			var arrayUUID = new Array();
			var arrayZFLX = new Array();
			var idSrt="";
			var ztSrt="";
			var value = document.getElementsByTagName("input");	   
			var UUIDHidden = value[value.length - 2].value;  
			var zhifuleixingHidden = value[value.length - 1].value;  
			//alert(zhifuleixingHidden);
			if(UUIDHidden != "" && zhifuleixingHidden != "" && UUIDHidden != null && zhifuleixingHidden != null)
			{	
			 	var s = UUIDHidden.indexOf(",",0);
			 	var s1 = zhifuleixingHidden.indexOf(",",0);
			 	while(s>-1){
				 	var uuid =UUIDHidden.substring(0,s);
				 	UUIDHidden = UUIDHidden.substring(s+1,UUIDHidden.length);
				 	var zhifuleixing = zhifuleixingHidden.substring(0,s1);
				 	zhifuleixingHidden = zhifuleixingHidden.substring(s1+1,zhifuleixingHidden.length);
				 	//alert(UUIDHidden);
					//alert(uuid);
					arrayUUID.push(uuid);
					arrayZFLX.push(zhifuleixing);
					s = UUIDHidden.indexOf(",",0);
					s1 = zhifuleixingHidden.indexOf(",",0);
				}
				arrayUUID.push(UUIDHidden);
				arrayZFLX.push(zhifuleixingHidden);
				//alert("arrayUUID:="+arrayUUID);
				//alert("zhifuleixingArray:="+arrayZFLX);
				
				for(var i = 0 ; i < arrayUUID.length; i ++){
					var ishaveid = document.getElementById("id"+arrayUUID[i]);
					if(ishaveid != null){
						ishaveid.checked = true; 
						document.getElementById("zt"+arrayUUID[i]).firstChild.value = arrayZFLX[i];
						arrayCheckId.push(arrayUUID[i]);
						arrayCheck.push("zt"+arrayUUID[i]);
					}else{
						idSrt +="," + arrayUUID[i];
						ztSrt +="," + arrayZFLX[i];
					}
					//alert(arrayCheck);
				}
				
				idSrt = idSrt.replace(/^,{1}/,""); 
				ztSrt = ztSrt.replace(/^,{1}/,""); 
				value[value.length - 2].value = idSrt ;
				value[value.length - 1].value = ztSrt ;
				//alert(idSrt);
				//alert("arrayCheckId=="+arrayCheckId);
			}
		}
		checkbox();
		
		
	
		function  subsave() {
			if(check()){
				commonSubmit('zhangMuEdit.do?act=insertPipeiZhangmu');
			}
		}
			check = function(){
			//alert("check");
				var value = document.getElementsByTagName("input");
				//点击保存后 添加当前页的已选状态
				ztStr = value[value.length - 1].value;
				for(var i =0 ; i<arrayCheck.length;i++){
					var zt = document.getElementById(arrayCheck[i]).firstChild.value;
					ztStr += ","+zt;
				}
			    ztStr = ztStr.replace(/^,{1}/,""); 
				
				//点击保存后 添加当前页的已选ID
				idStr = value[value.length - 2].value;
				for(var i =0 ; i<arrayCheckId.length;i++){
					var id = arrayCheckId[i];
					idStr += ","+id;
				}
			    idStr = idStr.replace(/^,{1}/,""); 
				
				//点击保存后的总收费
				zongshoufei = document.getElementById("txt").value;
				if(zongshoufei==0)
				{
					alert("未选择匹配数据不能保存！");
					zongshoufei = Number(zongshoufei);
					return false;
				}
				
				var b = ztStr.indexOf("-请选择-", 0);
				if(b!=-1){
					alert("有选中的数据收款类型未选择，请勾选后保存！");
					zongshoufei = Number(zongshoufei);
					return false;
				}
				var b = ztStr.indexOf("undefined", 0);
				if(b!=-1){
					alert("浏览器异常，请检查浏览器配置！");
					zongshoufei = Number(zongshoufei);
					return false;
				}
				value[value.length - 1].value = ztStr;
				value[value.length - 2].value = idStr;
				value[value.length - 3].value = Number(zongshoufei);
				return true;
			};
		var control = true;
		function  decide() {
			//alert("decide");
			if(control){
				control = false;
				//alert("decide");
				//alert(document.getElementById(arrayCheck[i]).firstChild.value);
				var value = document.getElementsByTagName("input");
				
				//已选状态
				var ztnStr = value[value.length - 1].value;
				for(var i =0 ; i<arrayCheck.length;i++){
					var zt = document.getElementById(arrayCheck[i]).firstChild.value;
					ztnStr += ","+zt;
				}
				ztnStr = ztnStr.replace(/^,{1}/,""); 
				value[value.length - 1].value = ztnStr;
				
				//已选ID
				var idnStr = value[value.length - 2].value;
				for(var i =0 ; i<arrayCheckId.length;i++){
					var id = arrayCheckId[i];
					idnStr += ","+id;
				}
				idnStr = idnStr.replace(/^,{1}/,""); 
				value[value.length - 2].value = idnStr;
				
				//已选总费
				zongshoufei = document.getElementById("txt").value;
				value[value.length - 3].value = zongshoufei;
				
				/* alert("已选类型：" + ztnStr);
				alert("已选ID：" + idnStr);
				alert("已选总费：" + zongshoufei);   */
			}
		}
	</script>
</html>
