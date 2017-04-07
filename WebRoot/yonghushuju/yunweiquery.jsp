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
		<title>快速开发框架演示项目</title>
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
		%>
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
				<style type="text/css">
		
		.dropDownList {
			position: absolute;
			top: 30px;
		}
		
		.dropDownList div.dropdown {
			float: left;
			margin-right: 120px;
			width: 146px;
			height: 200px;
			overflow: auto;
			overFlow-x: hidden;
		}
		
		.dropDownList span {
			display: block;
			width: 146px;
			height: 26px;
			background: url() left top no-repeat;
			line-height: 26px;
			text-indent: 12px;
			border: solid 1px #83BBD9;
			cursor: default;
		}
		
		.dropDownList span.over {
			background-position: left bottom;
			border-color: #B4C91A;
		}
		
		.dropDownList ul {
			background: #eee;
			width: 200px;
			display: none;
			height: 20px;
		}
		
		.dropDownList ul li {
			height: 20px;
			width: 100%;
			padding: 3px 0;
			text-indent: 12px;
			cursor: default;
			background-color: white;
		}
		
		.dropDownList ul li.over {
			background: #ccc;
		}
		
		.dropDownList ul.show {
			display: block;
		}
		</style>
		<script type="text/javascript"  language="javascript">
			document.onkeydown = function(event_e){
				if(window.event) {
					event_e = window.event;
				}
				var int_keycode = event_e.charCode||event_e.keyCode;
				if(int_keycode=='13') {
					sub();
					return false;
				}
			}
		</script>
	</head>
	<body onload="init()" id="body1">
	<div style="height:440px;">
		<html:form action="yonghuDataYunweiList.do">
		<bean:define id="xiaoquList" name="yonghuDataForm" property="xiaoquList"></bean:define>
		<bean:define id="statusList" name="yonghuDataForm" property="statusList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					用户数据查询
				</div>
				<!-- 查询条件 -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								小区：
							</td>
							<td>
								<html:select name="yonghuDataForm" property="quyuCode"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td>
								<font color='#FF0000'>* </font> 
							</td>
							<td>
								地址：
							</td>
							<td>
								<html:text name="yonghuDataForm" property="addressCode" size="12"  onkeyup="findStubyClasslId();"/>
								<div class="dropDownList" >
								 <div id="dropDownList1" class="dropdown" />
								  <ul id="ul1"></ul>
								 </div>
								 </div>
							</td>
								 
							<td>
								<font color='#FF0000'>*  &nbsp;&nbsp;</font> 
							</td>
							<td>
								状态
							</td>
							<td>
								<html:select name="yonghuDataForm" property="stateCode"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--请选择--</html:option>
								<html:option value="退单">退单</html:option>
								<html:option value="已修改">已修改</html:option>
								<html:options collection="statusList" property="key" labelProperty="value" />
								</html:select>
							</td>
				<td width="55px">
					时间类型
				</td>
				<td>
					<html:select name="yonghuDataForm" property="shijianleixing" onclick="check(this)"
								 styleClass="commonTextFieldHover"
								 onfocus="this.className='commonTextFieldMove'"
								 onblur="this.className='commonTextFieldHover'">
						<html:option value=""  >-请选择-</html:option>
						<html:option value="1">开机时间</html:option>
						<html:option value="2">停机时间</html:option>
						<html:option value="3">收款日期</html:option>
						<html:option value="4">有效时间</html:option>
					</html:select>

				</td>
				<td>
					开始时间
				</td>
				<td>
					<html:text name="yonghuDataForm" property="kaijis" styleId="kaijis" size="10" onclick="WdatePicker({el:'kaijis'})" readonly="true"/>
					<img onclick="WdatePicker({el:'kaijis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">

				</td>
				<td>
					结束时间
				</td>
				<td>
					<html:text name="yonghuDataForm" property="kaijie" styleId="kaijie" size="10" onclick="WdatePicker({el:'kaijie'})" readonly="true"/>
					<img onclick="WdatePicker({el:'kaijie'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">

				</td>
				<script language="javascript" type="text/javascript">
					function check(v){

						if(v.value!=""){
							document.forms[0].kaijis.readOnly = false;
							document.forms[0].kaijie.readOnly = false;
						}else{
							document.forms[0].kaijis.readOnly = true;
							document.forms[0].kaijie.readOnly = true;
						}
					}
				</script>
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="sub();" />
							</td>
							<td>
								联系电话：
							</td>
							<td>
								<html:text name="yonghuDataForm" property="telNoCode" size="11" />
							</td>
							<td align="right">
								<input type="button" value="联系电话查询" class="commonButton3" onclick="sub2();" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- 查询结果 start -->
				<div name="result" class="conten_result">
					<!-- 分页头 -->
					<div name="page_up" class="page_up" >
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- 结果一览 start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="98%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									用户状态&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									匹配状态&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收款时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									姓名&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									身份证号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									收据号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									分光线号&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									接续位置&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									开机时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									停机时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									有效时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									小区&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									地址&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									联系电话&nbsp;
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
									分光&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									Onu mac&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									STB MCID&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									电视IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									网络IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									电话IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									电话VLAN&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									网络VLAN&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									上门时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									单证&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									所选电话号码&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ONU押金&nbsp;
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
									设备销售费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									材料费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									运营商&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									不足月够费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									年费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									备注&nbsp;
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
									其他设备使用情况&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									其他耗材&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									接线子&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									RJ11&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									RJ45&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									模块&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									面板&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									网线&nbsp;
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
								<td class="tableTitleLine" nowrap="nowrap">
									维修类型&nbsp;
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yonghuzhuangtai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="pipeizhuangtai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoukuanshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xingming" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shenfensheng" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoujuhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="fenguangxianhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="jiexuweizhi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaijishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="tingjishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="youxiaoshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="lianxidianhua" />
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
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="fenguang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="onumac" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="stbmcid" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianshiip" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangluoip" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianhuaip" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dianhuavlan" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangluovlan" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shangmenshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="danzheng" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="sxdhhm" />
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
										<bean:write name="line" field="shebeixiaoshou" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="cailiaofei" />
									</td>
									
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yunyingshang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="bzygf" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="nianfei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="beizhu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="zongshoufei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shoujubenhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaipiaoxinxi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="qtsbsyqk" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="qitahaocai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="jiexianzi" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="rj11" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="rj45" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="mokuai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="mianban" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="wangxian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shigongren" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xianchangbeizhu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap"><br />
										<bean:write name="line" field="beizhuhuizong" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
									<bean:write name="line" field="weixiuleixing" />
								</td>
								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- 结果一览 end-->
					<div name="page_down" class="page_downuser">	
						<div align="right" id="footer" >
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- 查询结果 end -->
				<!-- button -->
				<div id="buttonC" name="button" class="content_button" >
				  <html:button property="btnSave" value="查看详情" styleClass="commonButton2" onclick="commonCheckSubmit('yonghuDataEdit.do?act=showInfo','UUID','请选择待查看的派工单')"/>
			      <!-- <html:button property="btnViewPhoto" value="查看照片" styleClass="commonButton" onclick="viewphoto('photouploadEdit.do?act=showPhotoFTP','UUID','请单选择待查看的数据')"/> -->
			    </div>
			</div>
			<html:hidden name="yonghuDataForm" property="quyuCodeHidden" />
			<html:hidden name="yonghuDataForm" property="addressCodeHidden" />
			<html:hidden name="yonghuDataForm" property="zhuangtai" />
		</html:form>
		</div>
	</body>
	
	<script type="text/javascript"  language="javascript">
		/*
		*	查看照片
		*/
		function viewphoto(action,code,msg){
			if(checkSelect(code,msg)){
				var group = $("[name='UUID']").filter(":checked");
				var uuid = group.val();
				window.open('<%=basePath%>'+action+'&uuid='+uuid,'newwindow','height='+(window.screen.availHeight-30)+',width='+(window.screen.availWidth-10)+',top=0,left=0,toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
			}
		}
		function sub(){
		  
			if(checkInput())
				{
					document.forms[0].zhuangtai.value = "0";
					commonSubmit('yonghuDataYunweiList.do?act=query');
				}
			}
			
			function sub2(){
		  
			if(checkInput2())
				{
					document.forms[0].zhuangtai.value = "1";
					commonSubmit('yonghuDataYunweiList.do?act=query');
				}
			}

		checkInput2 = function()
		{
			var lianxidianhua = document.forms[0].telNoCode.value;
			if(lianxidianhua==null||trim(lianxidianhua)=="")
				{
					alert("联系电话不能为空！");
					document.forms[0].telNoCode.focus();//设置焦点
					return false;
				}else if(lianxidianhua.length<11) {
					alert("联系电话不能小于11位！");
					document.forms[0].telNoCode.focus();//设置焦点
					return false;
				}
				return true;
		 } ;

		checkInput = function()
		{
			var xiaoqu = document.forms[0].quyuCode.value;
			if(xiaoqu==null||trim(xiaoqu)=="")
				{
					alert("小区不能为空！");
					document.forms[0].quyuCode.focus();//设置焦点
					return false;
				}
		
			var dizhi = document.forms[0].addressCode.value;
			if(dizhi==null||trim(dizhi)=="")
				{
					alert("地址不能为空！");
					document.forms[0].addressCode.focus();//设置焦点
					return false;
				}
				return true;
		 } ;
		 
		 function autoSubimit(){
			if (event.keyCode == 13) {
				sub();
			}
}
		//创建XMLHttpRequest对象   
			function createXMLHttpRequest() {
				if (window.XMLHttpRequest) { //Mozilla 浏览器
					XMLHttpReq = new XMLHttpRequest();
				} else {
					if (window.ActiveXObject) { // IE浏览器			
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
			//发送请求
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
			//post发送请求函数
			function sendRequestPost(url, params) {
				params=encodeURI(params); 
		        params=encodeURI(params);  
				createXMLHttpRequest();
				XMLHttpReq.open("POST", url, true);
				XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
				XMLHttpReq.setRequestHeader("Content-Type" , "application/x-www-form-urlencoded ; charset=GBK");
				XMLHttpReq.send(params); // 发送请求
			}
			//get发送请求函数
			function sendRequestGet(url) {
				createXMLHttpRequest();
				XMLHttpReq.open("GET", url, true);
				XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
				XMLHttpReq.send(null); // 发送请求
			}
			//post发送请求函数(无需传递参数时)
			function sendRequestPostwihtnoArgs(url) {
				createXMLHttpRequest();
				XMLHttpReq.open("POST", url, true);
				XMLHttpReq.onreadystatechange = processResponse;//指定回调函数
				XMLHttpReq.send(null); // 发送请求
			}
			// 处理返回信息函数
			function processResponse() {
				if (XMLHttpReq.readyState == 4) { // 判断对象状态
					if (XMLHttpReq.status == 200) { //信息已经成功返回，开始处理信息
						var res = XMLHttpReq.responseText;
						if(res.length < 1){
							hiddenUI();
							return;
						}
						var content=document.getElementById("ul1");
						for (var i=content.childNodes.length-1 ; i>=0 ; i--) {
							var childNode = content.childNodes[i];
							content.removeChild(childNode);
						} 
						__initDropDownList(res);
					} else { 
						//页面不正常
						var content=document.getElementById("ul1");
						for (var i=content.childNodes.length-1 ; i>=0 ; i--) {
							var childNode = content.childNodes[i];
							content.removeChild(childNode);
						} 
						hiddenUI();
					}
				}
			}
			
			function findStubyClasslId() {
				var xiaoqu = document.forms[0].quyuCode.value;
				var dizhi = document.forms[0].addressCode.value;
				if(dizhi.length > 2){
					var sURL = "allStu.do?act=test";
					var method = "post";
					var sParams = "xiaoqu=" + xiaoqu + "&dizhi=" + dizhi;
					sendRequest(sURL, sParams, method);
			 }
		}
	</script>
	<script type="text/javascript">
	var ____configArray;
	function __initDropDownList(configArray) {
		 ____configArray = configArray;
		 var existArray = configArray.split("|");
		 var parentContainer = document.getElementById("dropDownList1");
	 	 var optionLength = existArray.length;
	 	 for(var j=0;j<optionLength;j++){
	  	   //获取ul，以便能够添加项目
		   var ulObj = document.getElementById("ul1");
		   var liObj = document.createElement("li");
		   var textNode=document.createTextNode(existArray[j]);
		   liObj.appendChild(textNode);
		   liObj.setAttribute("currentIndex",j);
		   //给每个liObj添加事件
		   liObj.onclick=function(){
		       selectCurrentItem(this);
		   };
		   liObj.onmouseover=function() {
		       this.className="over";
		   };
		   liObj.onmouseout=function() {
		       this.className="";
		   }; 
		   ulObj.appendChild(liObj);
		 }
		 showUI();
		 parentContainer.onclick = function(event){
		 if (!event) {
		   	event = window.event;
		   }
		    //阻止事件冒泡
		    event.cancelBubble=true;
		    var eventUlObj = document.getElementById("ul1");//this.getElementsByTagName("ul1");
		    bodyClickHiddenUl(eventUlObj);
	 	 }; 
 	}
	 
	function selectCurrentItem(currentObj) {
		 document.forms[0].addressCode.value = currentObj.firstChild.nodeValue;
		 hiddenUI();
	}
	function showHiddenUl(){
		var ulObj = document.getElementById("ul1");
		if(ulObj.className == "") {
			ulObj.className = "show";
		}else{
		    ulObj.className = "";
		}
	}
	function hiddenUI() {
		var ulObj = document.getElementById("ul1");
		ulObj.className = "";

	}
	function showUI() {
		var ulObj = document.getElementById("ul1");
		ulObj.className = "show";

	}
		//点击body区域（非“下拉菜单”）隐藏菜单
	function addBodyClick(func) {
		var bodyObj=document.getElementById("body1");
		var oldBodyClick = bodyObj.onclick;
		if (typeof bodyObj.onclick != 'function') 
		{
			bodyObj.onclick = func;
		} else {
	   		bodyObj.onclick = function() {
	    	oldBodyClick();
	    	func();
	 		};
		}
	}
	//隐藏所有的UL
	function bodyClickHiddenUl(eventUlObj){
		//alert(eventUlObj);
		if (____configArray == undefined || ____configArray==null || ____configArray=="") {
			return;
		} 
		//hiddenUI();
		if (eventUlObj == undefined) {
			hiddenUI();
		}  
	}	
	//添加这个可以确保点击body区域的时候 也可以隐藏菜单
	addBodyClick(bodyClickHiddenUl);
	</script>
</html>
