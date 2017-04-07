<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>

<tr>
	<td>
		<div class="topPagination">
			<table border="0" cellspacing="2" cellpadding="2" width="95%" >
				<tr>
					<td align="left">
						总共<b>
							<bean:write name="com.takucin.aceeci.frame.pagination" property="recordCount" />
						</b>条记录
	      				&nbsp;&nbsp;
	      				每页显示<b>
	      					<bean:write name="com.takucin.aceeci.frame.pagination" property="rows" />
	      				</b>行
	      			</td>
				</tr>
			</table>
		</div>
	</td>
</tr>


