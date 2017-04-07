<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>

<tr>
	<td align="right">
        <span id="paginationButtonGroup" >
	        当前第<b>
	            <bean:write name="com.takucin.aceeci.frame.pagination" property="startRecord" />
	            -
	            <bean:write name="com.takucin.aceeci.frame.pagination" property="endRecord" />
	        </b>条记录
	        <b>
	        	<bean:write name="com.takucin.aceeci.frame.pagination" property="currentPageCount" />
	        	/
	        	<bean:write name="com.takucin.aceeci.frame.pagination" property="pageCount" />
	        </b>
	        &nbsp;&nbsp;
	        <logic:equal name="com.takucin.aceeci.frame.pagination" property="renderedpreviousStatus" value="true">
				<a href="javascript:doPaginationSubmit('firstPage')" onclick="decide();">首页</a> 
				<a href="javascript:doPaginationSubmit('previous')" onclick="decide();">上一页</a> 
			</logic:equal>
			<logic:equal name="com.takucin.aceeci.frame.pagination" property="renderedpreviousStatus" value="false">
				首页 上一页
			</logic:equal>
			<logic:equal name="com.takucin.aceeci.frame.pagination" property="renderedNextStatus" value="true">
				<a href="javascript:doPaginationSubmit('next')" onclick="decide();">下一页</a> 
				<a href="javascript:doPaginationSubmit('lastPage')" onclick="decide();">尾页</a>
			</logic:equal>
			<logic:equal name="com.takucin.aceeci.frame.pagination" property="renderedNextStatus" value="false">
				下一页 尾页
			</logic:equal>
		</span>
		<span id="paginationButtonGroupText" style="display:none">
			当前第<b>
	            <bean:write name="com.takucin.aceeci.frame.pagination" property="startRecord" />
	            -
	            <bean:write name="com.takucin.aceeci.frame.pagination" property="endRecord" />
	        </b>条记录
	        <b>
	        	<bean:write name="com.takucin.aceeci.frame.pagination" property="currentPageCount" />
	        	/
	        	<bean:write name="com.takucin.aceeci.frame.pagination" property="pageCount" />
	        </b>
	        &nbsp;&nbsp;
			首页 上一页 下一页 尾页
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


