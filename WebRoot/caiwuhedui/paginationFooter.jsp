<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>

<tr>
	<td align="right">
        <span id="paginationButtonGroup" >
	        ��ǰ��<b>
	            <bean:write name="com.takucin.aceeci.frame.pagination" property="startRecord" />
	            -
	            <bean:write name="com.takucin.aceeci.frame.pagination" property="endRecord" />
	        </b>����¼
	        <b>
	        	<bean:write name="com.takucin.aceeci.frame.pagination" property="currentPageCount" />
	        	/
	        	<bean:write name="com.takucin.aceeci.frame.pagination" property="pageCount" />
	        </b>
	        &nbsp;&nbsp;
	        <logic:equal name="com.takucin.aceeci.frame.pagination" property="renderedpreviousStatus" value="true">
				<a href="javascript:doPaginationSubmit('firstPage')" onclick="decide();">��ҳ</a> 
				<a href="javascript:doPaginationSubmit('previous')" onclick="decide();">��һҳ</a> 
			</logic:equal>
			<logic:equal name="com.takucin.aceeci.frame.pagination" property="renderedpreviousStatus" value="false">
				��ҳ ��һҳ
			</logic:equal>
			<logic:equal name="com.takucin.aceeci.frame.pagination" property="renderedNextStatus" value="true">
				<a href="javascript:doPaginationSubmit('next')" onclick="decide();">��һҳ</a> 
				<a href="javascript:doPaginationSubmit('lastPage')" onclick="decide();">βҳ</a>
			</logic:equal>
			<logic:equal name="com.takucin.aceeci.frame.pagination" property="renderedNextStatus" value="false">
				��һҳ βҳ
			</logic:equal>
		</span>
		<span id="paginationButtonGroupText" style="display:none">
			��ǰ��<b>
	            <bean:write name="com.takucin.aceeci.frame.pagination" property="startRecord" />
	            -
	            <bean:write name="com.takucin.aceeci.frame.pagination" property="endRecord" />
	        </b>����¼
	        <b>
	        	<bean:write name="com.takucin.aceeci.frame.pagination" property="currentPageCount" />
	        	/
	        	<bean:write name="com.takucin.aceeci.frame.pagination" property="pageCount" />
	        </b>
	        &nbsp;&nbsp;
			��ҳ ��һҳ ��һҳ βҳ
		</span>
	</td>
</tr>

<script language="javascript">
    function doPaginationSubmit(actionMethod){
    	document.forms[0].action = document.forms[0].action + '?act=' + actionMethod;
    	document.getElementById("paginationButtonGroup").style.display = "none";
    	document.getElementById("paginationButtonGroupText").style.display = "block";
    	document.forms[0].submit();
    }
</script>


