<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>���ٿ��������ʾ��Ŀ</title>
		<a:base />
		<link href="css/common.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<html:form action="main.do">
			<div id="error_all">
				<!-- ���� -->
				<div class="error_top">
					<font color="#f96c28">������Ϣ</font>
				</div>
				<div class="error_content">
					<table border="0" cellspacing="0" cellpadding="0" width="98%">
						<tr>
							<td align="right">
								<img src="img/flgWorning.jpg"/>
							</td>
							<td>
								ϵͳ��ʱ�������⣬����ϵ����Ա���Ժ����ԣ�
							</td>
						</tr>
					</table>
				</div>
			</div>
		</html:form>
	</body>
</html>
