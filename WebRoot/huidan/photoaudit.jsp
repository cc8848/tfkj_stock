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
		*	�ϴ���Ƭ
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
		*	�鿴��Ƭ
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
		*	ɾ����Ƭ
		*/
		function deletephoto(code,msg){
			if(checkSelect(code,msg)){
				showConfirm("ȷ��ɾ����ѡ�û��ڷ������е���Ƭ��",function(v, m, f){
				if(v){
					document.forms[0].action = "photouploadEdit.do?act=deletephotos";
					disableAll(document);
			 		document.forms[0].submit();
			 		}
		 		});
	 		}
		}
		/*
		*	ɾ����Ϣ
		*/
		function deleteinfo(code,msg){
			if(checkSelect(code,msg)){
				showConfirm("ȷ��ɾ����ѡ�û���Ϣ��",function(v, m, f){
				if(v){
					document.forms[0].action = "photouploadEdit.do?act=deleteinfo";
					disableAll(document);
			 		document.forms[0].submit();
			 		}
		 		});
	 		}
		}
		/*
		*	�����˻�
		*/
		function wrongback(code,msg){
			if(checkSelect(code,msg)){
				document.forms[0].action = "photouploadEdit.do?act=wrongback";
				disableAll(document);
				document.forms[0].submit();
			}
		}
		/*
		*	�˶��ύ
		*/
		function auditphoto(code,msg){
			if(checkSelect(code,msg)){
				showConfirm("ȷ������ѡ�û����к˶��ύ��",function(v, m, f){
				if(v){
					var userjtihidden = document.getElementsByName("yonghuzhuangtaihidden");
					var uuids = document.getElementsByName("UUIDS");
					for(var i = 0;i<uuids.length;i++) {
						if(uuids[i].checked==true&&userjtihidden[i].value=='δ�ϴ�') {
							wrongMessage("����δ�ϴ�ͼƬ�����ݣ��ύʧ�ܣ�");
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
		*	�ײͰ���
		*/
		function taocaninclude(code,msg){
			if(checkSelect(code,msg)){
				document.forms[0].action = "photouploadEdit.do?act=taocaninclude";
				disableAll(document);
				document.forms[0].submit();
			}
		}
				/*
		*	�˶Ա�ע
		*/
		function heduibeizhu(code,msg){
			var group = $("[name='UUID']").filter(":checked");
			var uuid = group.val();
			if(checkSelect(code,msg)){
				showConfirm("ȷ������ѡ�û����к˶Ա�ע��",function(v, m, f){
				if(v){
					var heduitext = prompt("������˶Ա�ע������:","") ;
					$.ajax({
							url:"photouploadEdit.do?act=heduibeizhu",
							type : "POST",
							cache:false,
							data:{
								'uuid':uuid,
								'text':encodeURIComponent(heduitext)							
							},
							success: function(data){
								text_info("�˶Ա�ע��ӳɹ���");
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
				<!-- ���� -->
				<div class="conten_top" name="top">
					��Ƭ���
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query" >
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td >
								���С��
							</td>
							<td>
							<html:select property="quyuCode" name="PhotoUploadForm"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">	
									<html:option value="">-��ѡ��-</html:option>
									<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							
							</td>
							
							<td width="30px">
								��ַ
							</td>
							<td>
								<html:text name="PhotoUploadForm" property="addressCode" size="12"/>
							</td>
							
							<td width="55px">
								ʱ������
							</td>
							<td>
								<html:select name="PhotoUploadForm" property="shijianleixing" onclick="check(this)"
									styleClass="commonTextFieldHover"  
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value=""  >-��ѡ��-</html:option>
									<html:option value="1">����ʱ��</html:option>
									<html:option value="2">ͣ��ʱ��</html:option>
									<html:option value="3">�տ�����</html:option>
								</html:select>
							</td>
							
							<td>
								��ʼʱ��
							</td>
							<td>
								    <html:text name="PhotoUploadForm" property="sen1" styleId="sen1" size="10" onclick="WdatePicker({el:'sen1'})" />
									<img onclick="WdatePicker({el:'sen1'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							</td>
							<td>
								����ʱ��
							</td>
							<td>
								    <html:text name="PhotoUploadForm" property="sen2" styleId="sen2" size="10" onclick="WdatePicker({el:'sen2'})" />
									<img onclick="WdatePicker({el:'sen2'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
							</td>
							<td width="55px">
								�ϴ�״̬
							</td>
							<td>
								<html:select name="PhotoUploadForm" property="stateCode"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:option value="δ�ϴ�">δ�ϴ�</html:option>
									<html:option value="���ϴ�">���ϴ�</html:option>
									<html:option value="�ײͰ���">�ײͰ���</html:option>
								</html:select>
							</td>
						<!-- 	<td>
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('huidancheckedList.do?act=query')" />
								
							</td> -->
								<td><input type="button" value="��ѯ" class="commonButton" onclick="if(check2()){commonSubmit('photoauditList.do?act=query');}" /></td>
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
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									&nbsp;&nbsp;&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�ϴ�״̬&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									С��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ַ&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�绰&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�տ�ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ͣ��ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���շ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ƥ��״̬&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���֤��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�վݺ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�ֹ��ߺ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����λ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ϵ�绰&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ҵ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�ֹ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									Onu mac&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									STB MCID&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�绰IP&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�绰VLAN&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����VLAN&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����ʱ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��֤&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ѡ�绰����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ONUѺ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									������Ѻ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���ӷ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��װ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�豸���۷�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���Ϸ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��Ӫ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����¹���&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ע&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�վݱ���/�վݺ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��Ʊ��Ϣ&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����豸ʹ�����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�����Ĳ�&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									������&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									RJ11&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									RJ45&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ģ��&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									���&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ʩ����&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									�ֳ���ע&nbsp;
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									��ע����&nbsp;
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
				 <html:button property="btnViewPhoto" value="�鿴��Ƭ" styleClass="commonButton" onclick="viewphoto('photouploadEdit.do?act=showPhoto','UUID','�뵥ѡ����鿴ͼƬ������')"/>
				 <html:button property="btnUploadPhoto" value="�ϴ���Ƭ" styleClass="commonButton" onclick="viewuploadphoto('photouploadEdit.do?act=uploadPhoto','UUID','�뵥ѡ����ϴ�ͼƬ������')"/>
				 <html:button property="btnTaocan" value="�����˻�" styleClass="commonButton" onclick="wrongback('UUIDS','�뵥ѡ��������˻ص�����')"/>
				 <html:button property="btnTaocan" value="�ײͰ���" styleClass="commonButton" onclick="taocaninclude('UUID','�뵥ѡ����ײͰ���������')"/>
				 <!-- <html:button property="btnSubmit" value="�˶��ύ" styleClass="commonButton" onclick="auditphoto('UUIDS','��ѡ����˶��ύ����Ŀ')"/> -->
				 <html:button property="btnDeleteInfo" value="ɾ����Ϣ" styleClass="commonButton" onclick="deleteinfo('UUIDS','��ѡ��ɾ����Ϣ����Ŀ')"/>
				 <html:button property="btnTaocan" value="�˶Ա�ע" styleClass="commonButton" onclick="heduibeizhu('UUID','�뵥ѡ����˶Ա�ע������')"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<html:button property="btnDeletePhoto" value="ɾ����Ƭ" style="color:white;background-color:red;height: 21px;" onclick="deletephoto('UUIDS','��ѡ��ɾ����Ƭ����Ŀ')"/>
				</div>
			</div>
		</html:form>
		</div>
	</body>
<script>
</script>
</html>
