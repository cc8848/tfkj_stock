<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2013-04-01     Zhang,Dong-Yu     Create
   
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
		<title>备注填写</title>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<script src="huidan/huidan.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<html:form action="huidansubList.do">
    <h2 id="titlePanel">退单原因</h2>
			<table >
			
			<tr>
				<td>
				            原因：
			    </td>
				<td><html:textarea name="HuidanForm" property="yewu" rows="5" cols="70" />
				</td>
				
			</tr>
					<td>
						<input type="button" value="保存" class="commonButton" onclick="commonSubmit('huidansubList.do?act=huidanBack_update')" />
					</td>
					<td>
						<input type="button" value="返回" class="commonButton" onclick="commonSubmit('huidansubList.do?act=init')" />
					</td>
			</table>
		<br/>
		<html:hidden name="HuidanForm" property="UUIDHidden" />
		<html:hidden name="HuidanForm" property="yewuHidden" />
    </html:form>
    </body>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	