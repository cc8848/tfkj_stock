<%@ page contentType="application/vnd.ms-excel; charset=GBK" language="java" import="java.sql.*,com.takucin.aceeci.util.*"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<%
	String filename = "�ձ���ϸͳ��_" + Common.getTime();
	response.setHeader("Content-Disposition", "inline; filename=" + java.net.URLEncoder.encode(filename, "UTF-8") + ".xls");
	response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(filename, "UTF-8") + ".xls");
%>
	<body>
			<div id="content_all">
				<!-- ��ѯ��� start -->
				<div class="conten_result">
					<!-- ���һ�� start-->
					<div class="result_table">
						<table border="1" cellspacing="0" cellpadding="1" width="200%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine" nowrap="nowrap" colspan="8">
									������Ϣ
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap"
									colspan="3">
									ҵ������
								</td>
								<td bgcolor="#afdfe4" class="tableTitleLine" nowrap="nowrap"
									colspan="10">
									����
								</td>
								<td bgcolor="#FFFF00" class="tableTitleLine" nowrap="nowrap"
									colspan="2">
									�����¼
								</td>
							</tr>
							<tr bgcolor="#EEF5FA" align="center">
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									����ʱ��
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									ͣ��ʱ��
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									�տ�ʱ��
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									С��
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									С����ַ
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									��Ӫ��
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									�������
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									ʩ����
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									���
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									����
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									�绰
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									ONUѺ��
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									������Ѻ��
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									���ӷ�
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									�����
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									��װ��
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									�豸���۷�
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									���Ϸ�
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									�����¹���
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									���
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									�ϼƷ���
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									�վ��˱���/�վݺ�
								</td>
								<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap">
									��Ʊ��Ϣ
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