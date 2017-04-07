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
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		
	</head>
	<body onload="init()">
		<html:form action="shoufeitotalList.do?act=query" method="post" >
		<bean:define id="xiaoquList" name="totalForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" >
					统计数据
				</div>
				<!-- 查询条件 -->
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
								<input type="button" value="小区选择" onclick="show_child();"/>
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
								时间类型
							</td>
							<td>
								<html:select name="totalForm" property="shijianleixing"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
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
								<html:text name="totalForm" property="kaijis" styleId="kaijis" size="10" onclick="WdatePicker({el:'kaijis'})" />
								<img onclick="WdatePicker({el:'kaijis'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
							    
							</td>
							<td>
								结束时间
							</td>
							<td>
								<html:text name="totalForm" property="kaijie" styleId="kaijie" size="10" onclick="WdatePicker({el:'kaijie'})" />
								<img onclick="WdatePicker({el:'kaijie'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"/> 
							    
							</td>
							<td align="right">
								<input type="button" value="统计" class="commonButton" onclick="sub();" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				
				<!-- 查询结果 start -->
				<div  class="conten_result">
					<!-- 分页头 -->
					<div  class="page_up">
						<!-- <jsp:include page="/common/paginationHeader.jsp" /> -->
					</div>
					
					<!-- 结果一览 start-->
					<div  class="result_table">
					 <bean:define id="wideSize" name="totalForm" property="wideSize"></bean:define>
					 <bean:define id="heightSize" name="totalForm" property="heightSize"></bean:define>
					 <bean:define id="pathA" name="totalForm" property="pathA"></bean:define>
						<img width="<bean:write name="wideSize"/>" height="<bean:write name="heightSize"/>" src="<bean:write name="pathA"/>" alt="total" /> 
						<table border="0" cellspacing="0" cellpadding="1"  width="200%">
						<tr bgcolor="#EEF5FA" align="center">
							<td class="tableTitleLine" nowrap="nowrap" rowspan="2">
								小区
							</td >
							<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap" colspan="5" >
								已安装
							</td >
							<td bgcolor="#afdfe4" class="tableTitleLine"nowrap="nowrap" colspan="5">
								已维修
							</td >
							<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap" colspan="4">
								已续费
							</td >
							<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap" colspan="4">
								已退订
							</td >
							<td class="tableTitleLine"nowrap="nowrap" rowspan="2">
								合计
							</td >
						</tr>
						<tr bgcolor="#EEF5FA" align="center">
							<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap"  >
								收视费
							</td >
							<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap">
								宽带费
							</td >
							<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap">
								押金(ONU+机顶盒)
							</td >
							<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap">
								杂费
							</td >
							<td bgcolor="#c99979" class="tableTitleLine"nowrap="nowrap">
								小区已安装总收费
							</td >
							
							<td bgcolor="#afdfe4" class="tableTitleLine"nowrap="nowrap">
								收视费
							</td >
							<td  bgcolor="#afdfe4" class="tableTitleLine"nowrap="nowrap">
								宽带费
							</td >
							<td bgcolor="#afdfe4" class="tableTitleLine"nowrap="nowrap">
								押金(ONU+机顶盒)
							</td >
							<td bgcolor="#afdfe4" class="tableTitleLine"nowrap="nowrap">
								杂费
							</td >
							<td bgcolor="#afdfe4" class="tableTitleLine"nowrap="nowrap">
								小区已维修总收费
							</td >
							
							<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap">
								收视费
							</td >
							<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap">
								宽带费
							</td >
							<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap">
								押金(ONU+机顶盒)
							</td >
							<td bgcolor="#00FF00" class="tableTitleLine"nowrap="nowrap">
								小区已续费总收费
							</td >
							
							<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap">
								收视费
							</td >
							<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap">
								宽带费
							</td >
							<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap">
								押金(ONU+机顶盒)
							</td >
							<td bgcolor="#FFFF00" class="tableTitleLine"nowrap="nowrap">
								小区已退订总收费
							</td >
						</tr>

						<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td  class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="xiaoqu1" /> 
									</td >
									<td   bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="az_shoushifei" /> 
									</td >
									<td  bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="az_kuandaifei" /> 
									</td >
									<td  bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="az_onujidingheyj" /> 
									</td >
									<td  bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="az_zafei" /> 
									</td >
									<td  bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="az_zong" /> 
									</td >
									<td bgcolor="#afdfe4" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="wx_shoushifei" /> 
									</td >
									<td bgcolor="#afdfe4" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="wx_kuandaifei" /> 
									</td >
									<td bgcolor="#afdfe4" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="wx_onujidingheyj" /> 
									</td >
									<td  bgcolor="#afdfe4" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="wx_zafei" /> 
									</td >
									<td bgcolor="#afdfe4" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="wx_zong" /> 
									</td >
									<td bgcolor="#00FF00" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="xf_shoushifei" /> 
									</td >
									<td bgcolor="#00FF00" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="xf_kuandaifei" /> 
									</td >
									<td bgcolor="#00FF00" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="xf_onujidingheyj" /> 
									</td >
									<td bgcolor="#00FF00" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="xf_zong" /> 
									</td >
									<td bgcolor="#FFFF00" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="td_shoushifei" /> 
									</td >
									<td bgcolor="#FFFF00" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="td_kuandaifei" /> 
									</td >
									<td bgcolor="#FFFF00" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="td_onujidingheyj" /> 
									</td >
									<td bgcolor="#FFFF00" class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="td_zong" /> 
									</td >
									<td class="tableTitleLine" nowrap="nowrap">
										 <bean:write name="line" field="zongji" /> 
									</td >
								</tr>
						</logic:iterate>
						</table>
					</div>
					
					<!-- 结果一览 end-->
					<div class="page_down">
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
		<script type="text/javascript" >
	function sub(){
			if(checkInput())
				{
					commonSubmit('shoufeitotalList.do?act=query');
				}
			}
			
		checkInput = function()
		{
	 /* 		var kaijis = document.forms[0].kaijis.value;
			var tingjis = document.forms[0].tingjis.value;
			if((kaijis!=null||trim(kaijis)!="") &&(tingjis==null||trim(tingjis)==""))
				{
					alert("结束时间不能为空！");
					document.forms[0].kaijis.focus();//设置焦点
					return false;
				}
				
			if((kaijis==null||trim(kaijis)=="") &&(tingjis!=null||trim(tingjis)!=""))
				{
					alert("开始时间不能为空！");
					document.forms[0].kaijis.focus();//设置焦点
					return false;
				} */
		
			/* if(tingjis<kaijis)
			{
				alert("结束时间请大于开始时间！");
				return false;
			}  */
				return true;
		 };
		 
		  function autoSubimit(){
			if (event.keyCode == 13) {
				sub();
			}
		}
	</script>
	</body>
</html>
