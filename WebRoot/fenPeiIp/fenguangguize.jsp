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
		<title>���ٿ��������ʾ��Ŀ</title>
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
		*	�鿴��Ƭ
		*/
		function editfenguang(action,code,msg){
			if(checkSelect(code,msg)){
				var heduitext = prompt("����������:","");
				if(heduitext=="sw1234") {
					document.forms[0].action = action;
					disableAll(document);
				 	document.forms[0].submit();
				}else{
					alert("�������");
				}
	 		}
		}
		/*
		*	ɾ����Ƭ
		*/
		function deletefenguang(action,code,msg){
			if(checkSelect(code,msg)){
				showConfirm("ȷ��ɾ����ѡ�ֹ�������",function(v, m, f){
				if(v){
					var heduitext = prompt("����������:","");
					if(heduitext=="sw1234") {
						document.forms[0].action = action;
						disableAll(document);
				 		document.forms[0].submit();
				 		}else{
							alert("�������");
						}
			 		}
		 		});
	 		}
		}
		</script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init();">
	<div style="height:440px;">
		<html:form action="fenguangguizeList.do">
		<bean:define id="xiaoquList" name="fenPeiFenGuangGuiZeForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					�ֹ�������
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query" >
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td >
								���С��
							</td>
							<td>
							<html:select property="xiaoqu" name="fenPeiFenGuangGuiZeForm"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">	
									<html:option value="">-��ѡ��-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							
							</td>
							<td>
								¥��
							</td>
							<td>
								<html:text name="fenPeiFenGuangGuiZeForm" property="louhao" size="12"/>
							</td>
							<td>
								¥��
							</td>
							<td>
								<html:text name="fenPeiFenGuangGuiZeForm" property="loumen" size="12"/>
							</td>
							<td>
								¥��
							</td>
							<td>
								   <html:text name="fenPeiFenGuangGuiZeForm" property="louceng" size="12"/>
							</td>
							<td>
								��Ԫ
							</td>
							<td>
								    <html:text name="fenPeiFenGuangGuiZeForm" property="danyuan" size="12"/>
							</td>
							<td>
								�ֹ�ID
							</td>
							<td>
								<html:text name="fenPeiFenGuangGuiZeForm" property="fenguangID" size="12"/>
							</td>
							<td>
								��ע
							</td>
							<td>
								<html:text name="fenPeiFenGuangGuiZeForm" property="beizhu" size="12"/>
							</td>
							<td><input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('fenguangguizeList.do?act=query');" /></td>
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
						<table border="0" cellspacing="0" cellpadding="1" width="98%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine" nowrap="nowrap">
									&nbsp;&nbsp;&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									С��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									¥��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									¥��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									¥��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��Ԫ&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�ֹ�ID&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ע&nbsp;
								</td>
							</tr>
							<logic:iterate id="line"
								           name="com.takucin.aceeci.frame.pagination"
								           property="result"
								           type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="louhao" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="loumen" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="louceng" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="danyuan" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="fenguangID" />
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<bean:write name="line" field="beizhu" />
									</td>
								</tr>
							</logic:iterate>
						</table>
					</div>
					<!-- ���һ�� end-->
					<div name="page_down" class="page_down">
						<div align="right">
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- ��ѯ��� end -->
				<!-- button -->
				<div name="button" class="content_button">
				 	<html:button property="btnEdit" value="�༭" styleClass="commonButton" onclick="editfenguang('fenguangguizeEdit.do?act=editFenguang','UUID','�뵥ѡ����༭������')"/>
				 	<html:button property="btnDelete" value="ɾ��" styleClass="commonButton" onclick="deletefenguang('fenguangguizeEdit.do?act=delFenguang','UUID','�뵥ѡ���ɾ��������')"/>
				</div>
			</div>
		</html:form>
		<br /><br /><br /><br />
		<html:form action="fenguangguizeEdit.do?act=upload" method="post" enctype="multipart/form-data" >
			<table id="quert_table2" cellpadding="1" cellspacing="1" border="0">
				<tr>
					<td>���ݵ��룺</td>
					<td><input name="formFile" type="file" size="60"
						class="commonTextFieldHover" 
						onfocus="this.className='commonTextFieldMove'" 
						onblur="this.className='commonTextFieldHover'" />
					
					<html:submit property="telUpload" value="�ϴ�" styleClass="commonButton"></html:submit>
					
					<a href="./huidan/fenguangguize.xls">ģ������</a>
					</td>
					</tr>
				</table>
		</html:form>
		</div>
	</body>
<script>
</script>
</html>
