<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>�췿�Ƽ���������ϵͳ</title>
    <link rel="Shortcut Icon" href="favicon.ico" />
	<link type="text/css" rel="stylesheet" href="login/css/login.css" />
	<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script src="js/popupBox.js" language="javascript"></script>
    <script src="js/validate.js" language="javascript"></script>
    <script type="text/javascript" src="login/js/login.js"></script>
    <jsp:include page="/common/commonMessage.jsp" />
  </head>
  
  <body onload="init()">
    <html:form action="/login" method="post">
    <!-- ϵͳSlogan -->
	<div id="mainSlogan">
	<img src="img/logintop.jpg" name=loginSlogan" />
	</div>
	<!-- ϵͳ���� -->
	<div id="maintitle">
	  &nbsp;
	</div>
	<!-- login���� -->
    <table width="1012" border="0" align="center" id="main" cellpadding="1" cellspacing="1">
   		<tr>
   			<!-- logo -->
    		<td rowspan="2">
				<img src="img/loginlogo.jpg" name=loginLogo" />
			</td>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
  			<td>
  				<!-- ������ -->
  				<table border="0">
  					<tr>
  						<td align="right" style="font-size:12px">
  							�û�����
  						</td>
  						<td>
  							<input id="userName" name="userName" type="text" style="font-size:12px;height:16px;width:140px;" />
  						</td>
  					</tr>
  					<tr>
  						<td align="right" style="font-size:12px">
  							���룺
  						</td>
  						<td>
  							<input id="password" name="password" type="password" style="font-size:12px;height:16px;width:140px;" onkeydown="autoSubimit()" />
  						</td>
  					</tr>
  					<tr align="right">
  						<td colspan="2">
  							<html:button property="btnSubmit" value="��¼" styleClass="submit" onclick="doSubmit()"></html:button>
  						</td>
  					</tr>
  				</table>
   			</td>
    	</tr>
    	</table>
    </html:form>
  </body>
</html>
