<%@ page contentType="application/vnd.ms-excel; charset=GBK" language="java" import="java.sql.*,com.takucin.aceeci.util.*"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<%
	String filename = "�ձ�����ͳ��_" + Common.getTime();
	response.setHeader("Content-Disposition", "inline; filename=" + java.net.URLEncoder.encode(filename, "UTF-8") + ".xls");
	response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(filename, "UTF-8") + ".xls");
%>
	<body>
			<div id="content_all">
				<!-- ��ѯ��� start -->
				<div class="conten_result">
					<!-- ���һ�� start-->
					<div class="result_table">
						<table border="1" cellspacing="0" cellpadding="1" width="100%">
							<tr  bgcolor="#EEF5FA" align="center">
								<logic:iterate id="line"
									name="com.takucin.aceeci.frame.pagination" property="result"
									type="com.takucin.aceeci.frame.sql.DataRow">
									<td  class="tableTitleLine" nowrap="nowrap">
										<table border="1" cellspacing="0" cellpadding="1" width="100%">
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap" >
													��Ӫ��
												</td>
												<td class="tableTitleLine" nowrap="nowrap" >
													�������
												</td>
												<td class="tableTitleLine" nowrap="nowrap" >
													���
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td rowspan="6" class="tableTitleLine" nowrap="nowrap" bgcolor="#afdfe4">
													<bean:write name="line" field="yys" />
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													����
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="kaihu" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap">
													�ռ�
												</td>
												<td  class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="shoujian" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap">
													ά��
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="weixiu" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap">
													����
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="xufei" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap">
													�˶�
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="tuiding" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap" >
													���˶��ϼ�
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="ctdhj" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td rowspan="6" class="tableTitleLine" nowrap="nowrap" bgcolor="#afdfe4">
													<bean:write name="line" field="yys" />
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													��Ѻ�𿪻�
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="cyjkaihu" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap">
													��Ѻ���ռ�
												</td>
												<td  class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="cyjshoujuan" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td  class="tableTitleLine" nowrap="nowrap">
													��Ѻ��ά��
												</td>
												<td  class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="cyjweixiu" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td  class="tableTitleLine" nowrap="nowrap">
													��Ѻ������
												</td>
												<td  class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="cyjxufei" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap">
													��Ѻ���˶�
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="cyjtuiding" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap" >
													��Ѻ���˶��ϼ�
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="cyjtdhj" />
												</td>
											</tr>
										</table>
									</td>
								</logic:iterate>
							</tr>
						</table>
					</div>
				</div>
			</div>
	</body>