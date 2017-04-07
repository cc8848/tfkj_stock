<%@ page contentType="application/vnd.ms-excel; charset=GBK" language="java" import="java.sql.*,com.takucin.aceeci.util.*"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<%
	String filename = "日报收入统计_" + Common.getTime();
	response.setHeader("Content-Disposition", "inline; filename=" + java.net.URLEncoder.encode(filename, "UTF-8") + ".xls");
	response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(filename, "UTF-8") + ".xls");
%>
	<body>
			<div id="content_all">
				<!-- 查询结果 start -->
				<div class="conten_result">
					<!-- 结果一览 start-->
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
													运营商
												</td>
												<td class="tableTitleLine" nowrap="nowrap" >
													工作类别
												</td>
												<td class="tableTitleLine" nowrap="nowrap" >
													金额
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td rowspan="6" class="tableTitleLine" nowrap="nowrap" bgcolor="#afdfe4">
													<bean:write name="line" field="yys" />
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													开户
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="kaihu" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap">
													收件
												</td>
												<td  class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="shoujian" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap">
													维修
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="weixiu" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap">
													续费
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="xufei" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap">
													退定
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="tuiding" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap" >
													除退定合计
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
													除押金开户
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="cyjkaihu" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap">
													除押金收件
												</td>
												<td  class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="cyjshoujuan" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td  class="tableTitleLine" nowrap="nowrap">
													除押金维修
												</td>
												<td  class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="cyjweixiu" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td  class="tableTitleLine" nowrap="nowrap">
													除押金续费
												</td>
												<td  class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="cyjxufei" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap">
													除押金退定
												</td>
												<td class="tableTitleLine" nowrap="nowrap">
													<bean:write name="line" field="cyjtuiding" />
												</td>
											</tr>
											<tr  bgcolor="#EEF5FA" align="center">
												<td class="tableTitleLine" nowrap="nowrap" >
													除押金退定合计
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