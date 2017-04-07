<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>快速开发框架演示项目</title>
		<a:base />
		<link href="css/common.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<html:form action="main.do">
			<div id="error_all">
				<!-- 标题 -->
				<div class="error_top">
					<font color="#1745aa">注意信息</font>
				</div>
				<div class="error_content">
					<table border="0" cellspacing="0" cellpadding="0" width="98%">
						<tr>
							<td align="right">
								<img src="img/flgNotice.jpg"/>
							</td>
							<td>
								抱歉！由于您长时间没有操作，或您的账户在异地登录，请<a href="login.do?act=init" target="_parent">重新登录</a>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</html:form>
	</body>
</html>
