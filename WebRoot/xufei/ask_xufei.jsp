<!--
   TFTECH corporation (c)2012 all rights reserved.
   Description:

   Update:
   Date         Name               Reason
   ============ ================== ==========
   2012-11-23     Zhu,Xiao-Lei     Create
   
  -->
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>���ٿ��������ʾ��Ŀ</title>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" ></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<div style="height:480px;">
		<html:form action="daijiaofeiDataList.do">
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					��������
				</div>
				<!-- ��ѯ����
				<div id="conten_query2">
					<div id="query2_div" style="display:none;">
					</div>
				</div> -->
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result1">
					<!-- ��ҳͷ -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- ���һ�� start-->
					<div name="result_table" class="result_table1">
						<table border="0" cellspacing="0" cellpadding="1" width="140%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									�û�״̬
								</td>
								<td class="tableTitleLine">
									�տ�ʱ��
								</td>
								<td class="tableTitleLine">
									С��
								</td>
								<td class="tableTitleLine">
									��ַ
								</td>
								<td class="tableTitleLine">
									��Ӫ��
								</td>
								<td class="tableTitleLine">
									����ʱ��
								</td>
								<td class="tableTitleLine">
									ͣ��ʱ��
								</td>
								<td class="tableTitleLine" >
									����
								</td>
								<td class="tableTitleLine" >
									�����˺�
								</td>
								<td class="tableTitleLine">
									����
								</td>
								<td class="tableTitleLine">
									�����˺�
								</td>
								<td class="tableTitleLine">
									���շ�
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ҵ��
								</td>
								<td class="tableTitleLine">
									onuѺ��
								</td>
								<td class="tableTitleLine">
									������Ѻ��
								</td>
								<td class="tableTitleLine">
									���ӷ�
								</td>
								<td class="tableTitleLine">
									�����
								</td>
								<td class="tableTitleLine">
									���
								</td>
								<td class="tableTitleLine">
									�վݺ�
								</td>
								<td class="tableTitleLine">
									��Ʊ��Ϣ
								</td>
								<td class="tableTitleLine">
									ʩ����
								</td>
								<td class="tableTitleLine">
									��ע����
								</td>
								<td class="tableTitleLine">
									�绰
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine">
										<bean:write name="line" field="yonghuzhuangtai" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="shoukuanshijian" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="dizhi" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="yunyingshang" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="kaijishijian" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="tingjishijian" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="wangluo" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="wangluoip" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="dianshi" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="dianhuaip" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="zongshoufei" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="yewu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="onuyj" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="jidingheyj" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="shoushifei" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="kuandaifei" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="nianfei" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="shoujubenhao" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="kaipiaoxinxi" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="shigongren" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="beizhuhuizong" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="dianhua" />
									</td>
								</tr>
							</logic:iterate> 
						</table>

					</div>
					<!-- ���һ�� end-->
					<div name="page_down" class="page_downuser">
						<div align="right">
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- ��ѯ��� end -->
				<!-- button -->
				<div id="buttonC" name="button" class="content_button" >
				  <html:button property="btnSave" value="��������" styleClass="commonButton2" onclick="commonSubmit('shenqingDataEdit.do?act=initInsert')"/>
			    </div>
			</div>
		</html:form>
	</div>
	
			</body>
	<script type="text/javascript"  language="javascript">
	</script>
</html>
