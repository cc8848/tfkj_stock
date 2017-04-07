<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2015-12-15   Dai-Zhen           Create
   
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
		<script src="js/business.js" language="javascript"></script>
		<script src="huidan/huidan.js" language="javascript"></script>
		<script type="text/javascript">
		/*
		*	上传照片
		*/
		function viewuploadphoto(action,code,msg){
			if(checkSelect(code,msg)){
				var group = $("[name='UUID']").filter(":checked");
				var uuid = group.val();
				var uploadwindow = window.open('<%=basePath%>'+action+'&uuid='+uuid,'newwindow','height=500px,width=880px,top=150,left=300,toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
				uploadwindow.onunload = function(){
					if(check2()){commonSubmit('photoauditList.do?act=query');}
				}
			}
		}
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
		function refreshgamen() {
			setTimeout(function() {commonSubmit('photoauditList.do?act=query');},2000);
		}
		/*
		*	删除照片
		*/
		function deletephoto(code,msg){
			if(checkSelect(code,msg)){
				showConfirm("确定删除所选用户在服务器中的照片？",function(v, m, f){
				if(v){
					document.forms[0].action = "photouploadEdit.do?act=deletephotos";
					disableAll(document);
			 		document.forms[0].submit();
			 		}
		 		});
	 		}
		}
		/*
		*	删除信息
		*/
		function deleteinfo(code,msg){
			if(checkSelect(code,msg)){
				showConfirm("确定删除所选用户信息？",function(v, m, f){
				if(v){
					document.forms[0].action = "photouploadEdit.do?act=deleteinfo";
					disableAll(document);
			 		document.forms[0].submit();
			 		}
		 		});
	 		}
		}
		/*
		*	错误退回
		*/
		function wrongback(code,msg){
			if(checkSelect(code,msg)){
				document.forms[0].action = "photouploadEdit.do?act=wrongback";
				disableAll(document);
				document.forms[0].submit();
			}
		}
		/*
		*	核对提交
		*/
		function auditphoto(code,msg){
			if(checkSelect(code,msg)){
				showConfirm("确定对所选用户进行核对提交？",function(v, m, f){
				if(v){
					var userjtihidden = document.getElementsByName("yonghuzhuangtaihidden");
					var uuids = document.getElementsByName("UUIDS");
					for(var i = 0;i<uuids.length;i++) {
						if(uuids[i].checked==true&&userjtihidden[i].value=='未上传') {
							wrongMessage("存在未上传图片的数据，提交失败！");
							return false;
						}
					}
					document.forms[0].action = "photouploadEdit.do?act=auditphotoFTP";
					disableAll(document);
				 	document.forms[0].submit();
			 		}
		 		});
	 		}
		}
		
		/*
		*	套餐包含
		*/
		function taocaninclude(code,msg){
			if(checkSelect(code,msg)){
				document.forms[0].action = "photouploadEdit.do?act=taocaninclude";
				disableAll(document);
				document.forms[0].submit();
			}
		}
				/*
		*	核对备注
		*/
		function heduibeizhu(code,msg){
			var group = $("[name='UUID']").filter(":checked");
			var uuid = group.val();
			if(checkSelect(code,msg)){
				showConfirm("确定对所选用户进行核对备注？",function(v, m, f){
				if(v){
					var heduitext = prompt("请输入核对备注的内容:","") ;
					$.ajax({
							url:"photouploadEdit.do?act=heduibeizhu",
							type : "POST",
							cache:false,
							data:{
								'uuid':uuid,
								'text':encodeURIComponent(heduitext)							
							},
							success: function(data){
								text_info("核对备注添加成功！");
								commonSubmit('photoauditList.do?act=query');
							}
						});
					}
		 		});
			}
		}
		</script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="photoauditList.do">
		<bean:define id="xiaoquList" name="PhotoUploadForm" property="xiaoquList"></bean:define>
		<bean:define id="statusList" name="PhotoUploadForm" property="statusList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					照片审核
				</div>
				<!-- 查询条件 -->
				<div id="conten_query" >
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td >
								入库小区
							</td>
							<td>
							<html:select property="quyuCode" name="PhotoUploadForm"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">	
									<html:option value="">-请选择-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							
							</td>
							
							<td width="30px">
								地址
							</td>
							<td>
								<html:text name="PhotoUploadForm" property="addressCode" size="12"/>
							</td>
							
							<td width="55px">
								时间类型
							</td>
							<td>
								<html:select name="PhotoUploadForm" property="shijianleixing" onclick="check(this)"
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
								    <html:text name="PhotoUploadForm" property="sen1" styleId="sen1" size="10" onclick="WdatePicker({el:'sen1'})" />
									<img onclick="WdatePicker({el:'sen1'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							</td>
							<td>
								结束时间
							</td>
							<td>
								    <html:text name="PhotoUploadForm" property="sen2" styleId="sen2" size="10" onclick="WdatePicker({el:'sen2'})" />
									<img onclick="WdatePicker({el:'sen2'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							</td>
							<td width="55px">
								上传状态
							</td>
							<td>
								<html:select name="PhotoUploadForm" property="stateCode"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:option value="未上传">未上传</html:option>
									<html:option value="已上传">已上传</html:option>
									<html:option value="套餐包含">套餐包含</html:option>
								</html:select>
							</td>
						<!-- 	<td>
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('huidancheckedList.do?act=query')" />
								
							</td> -->
								<td><input type="button" value="查询" class="commonButton" onclick="if(check2()){commonSubmit('photoauditList.do?act=query');}" /></td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- 查询结果 start -->
				<div name="result" class="conten_result">
					<!-- 分页头 -->
					<div name="page_up" class="page_up">
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
									&nbsp;&nbsp;&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									上传状态&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									小区&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									地址&nbsp;
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
									收款时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									开机时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									停机时间&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									总收费&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									匹配状态&nbsp;
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
									联系电话&nbsp;
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
							</tr>
							<logic:iterate id="line"
								           name="com.takucin.aceeci.frame.pagination"
								           property="result"
								           type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUIDS" type="checkbox" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="yonghuzhuangtai" />
										<input type="hidden" name="yonghuzhuangtaihidden" value="<bean:write name="line" field="yonghuzhuangtai" />"/>
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="dizhi" />
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
										<bean:write name="line" field="shoukuanshijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="kaijishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="tingjishijian" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="zongshoufei" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="pipeizhuangtai" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xingming" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="shenfenzheng" />
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
										<bean:write name="line" field="lianxidianhua" />
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
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="beizhuhuizong" />
									</td>
								</tr>
							</logic:iterate>
						</table>
						<html:hidden styleId="gamenKbn" name="PhotoUploadForm" property="gamenKbn" />
					</div>
					<!-- 结果一览 end-->
					<div name="page_down" class="page_down">
						<div align="right">
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- 查询结果 end -->
				<!-- button -->
				<div name="button" class="content_button">
				 <html:button property="btnViewPhoto" value="查看照片" styleClass="commonButton" onclick="viewphoto('photouploadEdit.do?act=showPhoto','UUID','请单选择待查看图片的数据')"/>
				 <html:button property="btnUploadPhoto" value="上传照片" styleClass="commonButton" onclick="viewuploadphoto('photouploadEdit.do?act=uploadPhoto','UUID','请单选择待上传图片的数据')"/>
				 <html:button property="btnTaocan" value="错误退回" styleClass="commonButton" onclick="wrongback('UUIDS','请单选择待错误退回的数据')"/>
				 <html:button property="btnTaocan" value="套餐包含" styleClass="commonButton" onclick="taocaninclude('UUID','请单选择待套餐包含的数据')"/>
				 <!-- <html:button property="btnSubmit" value="核对提交" styleClass="commonButton" onclick="auditphoto('UUIDS','请选择待核对提交的条目')"/> -->
				 <html:button property="btnDeleteInfo" value="删除信息" styleClass="commonButton" onclick="deleteinfo('UUIDS','请选择删除信息的条目')"/>
				 <html:button property="btnTaocan" value="核对备注" styleClass="commonButton" onclick="heduibeizhu('UUID','请单选择待核对备注的数据')"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<html:button property="btnDeletePhoto" value="删除照片" style="color:white;background-color:red;height: 21px;" onclick="deletephoto('UUIDS','请选择删除照片的条目')"/>
				</div>
			</div>
		</html:form>
		</div>
	</body>
<script>
</script>
</html>
