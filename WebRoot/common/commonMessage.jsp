<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>

<script language="javascript">
function init(){
	<html:messages id="message" message="true">
		<logic:notEmpty name="message">
			wrongMessage("<bean:write name='message' filter='false' />");
	   </logic:notEmpty>
	</html:messages>
}
</script>