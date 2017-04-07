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
	
	</head>
	
	<body onload="init()">
	
		<html:form action="totalList.do?act=query" method="post" >
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
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				
				<!-- ��ѯ��� start -->
				<div  class="conten_result">
					<!-- ��ҳͷ -->
					<div  class="page_up">
						<!-- <jsp:include page="/common/paginationHeader.jsp" /> -->
					</div>
					
					<!-- ���һ�� start-->
					<div  class="result_table">
						 <bean:define id="wideSize" name="totalForm" property="wideSize"></bean:define>
						 <bean:define id="heightSize" name="totalForm" property="heightSize"></bean:define>
						 <bean:define id="pathA" name="totalForm" property="pathA"></bean:define>
						 <img width="<bean:write name="wideSize"/>" height="<bean:write name="heightSize"/>" src="<bean:write name="pathA"/>" alt="total" /> 
						<table border="0" cellspacing="0" cellpadding="1"  width="100%">
						<tr bgcolor="#EEF5FA" align="center">
							<td class="tableTitleLine" nowrap="nowrap" rowspan="2">
								С��
							</td >
							<td class="tableTitleLine"nowrap="nowrap" rowspan="2">
								�Ѱ�װ����
							</td >
							<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap" colspan="4" >
								�Ѱ�װ
							</td >
							<td bgcolor="#afdfe4" class="tableTitleLine"nowrap="nowrap" rowspan="2">
								��ά��
							</td >
							<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap" colspan="4" >
								������
							</td >
							<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap" colspan="4" >
								���˶�
							</td >
						</tr>
						
						<tr bgcolor="#EEF5FA" align="center">
							
							<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap">
								���
							</td >
							<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap">
								����
							</td >
							<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap">
								�绰
							</td >
							<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap">
								�Ѱ�װ�ܼ�
							</td >
							
							
							<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap">
								���
							</td >
							<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap">
								����
							</td >
							<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap">
								�绰
							</td >
							<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap">
								�������ܼ�
							</td >
							
							
							<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap">
								���
							</td >
							<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap">
								����
							</td >
							<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap">
								�绰
							</td >
							<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap">
								���˶��ܼ�
							</td >
							
						</tr>
						

						<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="xiaoqu1" /> 
									</td >
									<td class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="huNum" /> 
									</td >
									
									<td  bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="wl_anzhuangNum" /> 
									</td >
									<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="ds_anzhuangNum" /> 
									</td >
									<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="dh_anzhuangNum" /> 
									</td >
									<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap">
										 <bean:write name="line" field="anzhuangNum" /> 
									</td >
									
									<td bgcolor="#afdfe4" class="tableTitleLine"nowrap="nowrap">
										 <bean:write name="line" field="weixiuNum" /> 
									</td >
									
									<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="wl_xufeiNum" /> 
									</td >
									<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="ds_xufeiNum" /> 
									</td >
									<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="dh_xufeiNum" /> 
									</td >
									<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap">
										 <bean:write name="line" field="xufeiNum" /> 
									</td >
									
									<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="wl_tuidingNum" /> 
									</td >
									<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="ds_tuidingNum" /> 
									</td >
									<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap">
										<bean:write name="line" field="dh_tuidingNum" /> 
									</td >
									<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap">
										 <bean:write name="line" field="tuidingNum" /> 
									</td >
								</tr>
						</logic:iterate>
						</table>
					</div>
					
					<!-- ���һ�� end-->
					<div name="page_down" class="page_down">
						<div align="right">
						<!-- 	<jsp:include page="/common/paginationFooter.jsp" /> -->
						</div>
					</div>
				</div>
			</div>
			<html:hidden name="totalForm" property="xiaoqutextHidden" />
			<html:hidden name="totalForm" property="xiaoquHidden" />
			<html:hidden name="totalForm" property="kaijisHidden" />
			<html:hidden name="totalForm" property="kaijieHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	
	
	function sub(){
			if(checkInput())
				{
					commonSubmit('totalList.do?act=query');
				}
			}
			
		checkInput = function()
		 {
			/*var kaijis = document.forms[0].kaijis.value;
			var tingjis = document.forms[0].tingjis.value;
			if((kaijis==null||trim(kaijis)=="") &&(tingjis==null||trim(tingjis)==""))
				{
					alert("��ʼ�ͽ���ʱ�䲻��ͬΪ�գ�");
					document.forms[0].kaijis.focus();//���ý���
					return false;
				}
		
			if(tingjis<kaijis)
			{
				alert("����ʱ������ڿ�ʼʱ�䣡");
				return false;
			} */
				return true;
		 };
		 
		  function autoSubimit(){
				if (event.keyCode == 13) {
					sub();
				}
			}
	</script>
</html>
