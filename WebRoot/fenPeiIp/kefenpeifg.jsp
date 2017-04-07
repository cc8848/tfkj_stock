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
		*	查看照片
		*/
		function editfenguang(action,code,msg){
			if(checkSelect(code,msg)){
				var heduitext = prompt("请输入密码:","");
				if(heduitext=="sw1234") {
					document.forms[0].action = action;
					disableAll(document);
				 	document.forms[0].submit();
				}else{
					alert("密码错误！");
				}
	 		}
		}
		/*
		*	删除照片
		*/
		function deletefenguang(action,code,msg){
			if(checkSelect(code,msg)){
				showConfirm("确定删除所选分光信息？",function(v, m, f){
				if(v){
					var heduitext = prompt("请输入密码:","");
					if(heduitext=="sw1234") {
						document.forms[0].action = action;
						disableAll(document);
				 		document.forms[0].submit();
				 		}else{
							alert("密码错误！");
						}
			 		}
		 		});
	 		}
		}
		function handfenguang(action,code,msg){
			if(checkSelect(code,msg)){
				document.forms[0].action = action;
				disableAll(document);
				document.forms[0].submit();
	 		}
		}
		function recyclefenguang(action,code,msg){
			if(checkSelect(code,msg)){
				document.forms[0].action = action;
				disableAll(document);
				document.forms[0].submit();
	 		}
		}
		function inittitle() {
			var mask = document.forms[0].mask.value;
			if(mask=="1") {
				document.getElementById("title").innerHTML="已分配分光一览";
				document.getElementById("btnHand").style.display="none";  
			}else{
				document.getElementById("btnRecycle").style.display="none";  
			}
		}
		//全选
		checkAll=function(thisObj,checkId) {
            if(thisObj==undefined||thisObj==null)return false;
            var frm = document.forms[0];
    
            var inputs = eval("frm."+checkId);
            if(inputs==undefined)return false;
            var isSelected=false;
            if(thisObj.checked){
                    isSelected = true;
            }else{
                    isSelected = false;
            }
            if(inputs.length==undefined){
                    inputs.checked=isSelected;
            }else{
                    for(i=0;i<inputs.length;i++){
                            if(inputs[i].type=="checkbox"){
                                    inputs[i].checked=isSelected;
                            }
                    }                
            }

    }
		</script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init();inittitle();">
	<div style="height:440px;">
		<html:form action="kefenpeifenguangList.do">
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					<span id="title">可分配分光一览</span>
				</div>
				<!-- 查询条件 -->
				<div id="conten_query" >
				<html:hidden styleId="mask" name="keFenPeiFenGuangForm" property="mask"/>
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								分光ID
							</td>
							<td>
								<html:text name="keFenPeiFenGuangForm" property="fenguangID" size="12"/>
							</td>
							<td>
								分光
							</td>
							<td>
								<html:text name="keFenPeiFenGuangForm" property="fenguang" size="12"/>
							</td>
							<td>
								备注
							</td>
							<td>
								<html:text name="keFenPeiFenGuangForm" property="remark" size="12"/>
							</td>
							<td><input type="button" value="查询" class="commonButton" onclick="commonSubmit('kefenpeifenguangList.do?act=query');" /></td>
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
								<td class="tableTitleLine" nowrap="nowrap">
									<input  type="checkbox" id="selectAll" onclick="checkAll(this,'checkBox');"/>
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									&nbsp;&nbsp;&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									分光ID&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									分光&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									备注&nbsp;
								</td>
							</tr>
							<logic:iterate id="line"
								           name="com.takucin.aceeci.frame.pagination"
								           property="result"
								           type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUIDS" type="checkbox" id="checkBox" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="fenguangID" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="fenguang" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="remark" />
									</td>
								</tr>
							</logic:iterate>
						</table>
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
				 	<html:button property="btnEdit" value="编辑" styleClass="commonButton" onclick="editfenguang('kefenpeifenguangEdit.do?act=editFenguang','UUID','请单选择待编辑的数据')"/>
				 	<html:button property="btnDelete" value="删除" styleClass="commonButton" onclick="deletefenguang('kefenpeifenguangEdit.do?act=delFenguang','UUID','请单选择待删除的数据')"/>
					<html:button styleId="btnHand" property="btnHand" value="手动分配分光"  style="color:black;background-color:rgb(255, 223, 15);height: 21px;" onclick="commonCheckSubmit('kefenpeifenguangEdit.do?act=handfenguang','UUID','请单选择待分配的数据')"/>
					<html:button styleId="btnRecycle" property="btnRecycle" value="分光回收使用"  style="color:black;background-color:rgb(255, 223, 15);height: 21px;" onclick="commonCheckSubmit('kefenpeifenguangEdit.do?act=recyclefenguang','UUIDS','请单选择待回收的数据')"/>
				</div>
			</div>
		</html:form>
		<br /><br /><br /><br />
		<html:form action="kefenpeifenguangEdit.do?act=upload" method="post" enctype="multipart/form-data" >
			<table id="quert_table2" cellpadding="1" cellspacing="1" border="0">
				<tr>
					<td>数据导入：</td>
					<td><input name="formFile" type="file" size="60"
						class="commonTextFieldHover" 
						onfocus="this.className='commonTextFieldMove'" 
						onblur="this.className='commonTextFieldHover'" />
					
					<html:submit property="telUpload" value="上传" styleClass="commonButton"></html:submit>
					
					<a href="./huidan/fenguangfenpei.xls">模板下载</a>
					</td>
					</tr>
				</table>
		</html:form>
		</div>
	</body>
<script>
</script>
</html>
