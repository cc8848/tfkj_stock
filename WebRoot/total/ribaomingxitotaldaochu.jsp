<%@ page contentType="application/vnd.ms-excel; charset=GBK" language="java" import="java.sql.*,com.takucin.aceeci.util.*"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<%
	String filename = "日报明细统计_" + Common.getTime();
	response.setHeader("Content-Disposition", "inline; filename=" + java.net.URLEncoder.encode(filename, "UTF-8") + ".xls");
	response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(filename, "UTF-8") + ".xls");
%>
	<body>
			<div id="content_all">
				<!-- 查询结果 start -->
				<div class="conten_result">
					<!-- 结果一览 start-->
					<div class="result_table">
						<table border="1" cellspacing="0" cellpadding="1" width="200%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine" nowrap="nowrap" colspan="8">
									基本信息
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap"
									colspan="3">
									业务类型
								</td>
								<td bgcolor="#afdfe4" class="tableTitleLine" nowrap="nowrap"
									colspan="10">
									费用
								</td>
								<td bgcolor="#FFFF00" class="tableTitleLine" nowrap="nowrap"
									colspan="2">
									财务记录
								</td>
							</tr>
							<tr bgcolor="#EEF5FA" align="center">
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									开机时间
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									停机时间
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									收款时间
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									小区
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									小区地址
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									运营商
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									工作类别
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									施工人
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									宽带
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									电视
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									电话
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									ONU押金
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									机顶盒押金
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									收视费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									宽带费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									初装费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									设备销售费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									材料费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									不足月够费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									年费
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									合计费用
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									收据账本号/收据号
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									开票信息
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="kaijishijian" format="yyyy-MM-dd" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="tingjishijian" format="yyyy-MM-dd"/>
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="shoukuanshijian" format="yyyy-MM-dd"/>
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="yunyingshang" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="gongzuoleibie" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="shigongren" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="wangluo" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="dianshi" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="dianhua" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="onuyj" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="jidingheyj" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="shoushifei" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="kuandaifei" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="chuzhuangfei" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="shebeixiaoshou" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="cailiaofei" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="bzygf" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="nianfei" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="hejifeiyong" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="shoujubenhao" />
									</td>
									<td class="tableTitleLine" nowrap="nowrap">
										<bean:write name="line" field="kaipiaoxinxi" />
									</td>
								</tr>
							</logic:iterate>
						</table>
					</div>
				</div>
			</div>
	</body>