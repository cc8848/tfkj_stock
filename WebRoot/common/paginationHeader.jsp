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
						�ܹ�<b>
							<bean:write name="com.takucin.aceeci.frame.pagination" property="recordCount" />
						</b>����¼
	      				&nbsp;&nbsp;
	      				ÿҳ��ʾ<b>
	      					<bean:write name="com.takucin.aceeci.frame.pagination" property="rows" />
	      				</b>��
	      			</td>
				</tr>
			</table>
		</div>
	</td>
</tr>


