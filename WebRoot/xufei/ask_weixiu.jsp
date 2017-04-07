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
		<title>快速开发框架演示项目</title>
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
		<html:form action="daiweixiuDataList.do">
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					维修提交
				</div>
				<!-- 查询条件
				<div id="conten_query2">
					<div id="query2_div" style="display:none;">
					</div>
				</div> -->
				<!-- 查询结果 start -->
				<div name="result" class="conten_result1">
					<!-- 分页头 -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- 结果一览 start-->
					<div name="result_table" class="result_table1">
						<table border="0" cellspacing="0" cellpadding="1" width="200%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									用户状态
								</td>
								<td class="tableTitleLine">
									维修时间
								</td>
								<td class="tableTitleLine">
									小区
								</td>
								<td class="tableTitleLine">
									地址
								</td>	
								<td class="tableTitleLine">
									维修类型
								</td>	
								<td class="tableTitleLine">
									运营商
								</td>						
								<td class="tableTitleLine">
									维修内容
								</td>
								<td class="tableTitleLine">
									分光
								</td>
								<td class="tableTitleLine">
									onu mac
								</td>
								<td class="tableTitleLine">
									STB MCID
								</td>
								<td class="tableTitleLine">
									电视IP
								</td>
								<td class="tableTitleLine">
									施工人
								</td>
								<td class="tableTitleLine">
									总收费
								</td>
								<td class="tableTitleLine">
									收据本号/收据号
								</td>
								<td class="tableTitleLine">
									开票信息
								</td>
								<td class="tableTitleLine">
									宽带费
								</td>
								<td class="tableTitleLine">
									收视费
								</td>
								<td class="tableTitleLine">
									初装费
								</td>
								<td class="tableTitleLine">
									设备销售费
								</td>
								<td class="tableTitleLine">
									材料费
								</td>
								<td class="tableTitleLine">
									年费
								</td>
								<td class="tableTitleLine">
									onu押金
								</td>
								<td class="tableTitleLine">
									机顶盒押金
								</td>
								
								<td class="tableTitleLine">
									接线子
								</td>
								<td class="tableTitleLine">
									RJ11
								</td>
								<td class="tableTitleLine">
									RJ45
								</td>
								<td class="tableTitleLine">
									模块
								</td>
								<td class="tableTitleLine">
									面板
								</td>
								<td class="tableTitleLine">
									网线
								</td>
								<td class="tableTitleLine">
									其它耗材
								</td>
								<td class="tableTitleLine">
									备注汇总
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
										<bean:write name="line" field="weixiuleixing" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="yunyingshang" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="yewu" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="fenguang"  filter="false"/>
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="onumac" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="stbmcid" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="dianshiip" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="shigongren" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="zongshoufei" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="shoujubenhao" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="kaipiaoxinxi" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="kuandaifei" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="shoushifei" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="chuzhuangfei" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="shebeixiaoshou" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="cailiaofei" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="nianfei" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="onuyj" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="jidingheyj" />
									</td>
									

									<td class="tableContentLine">
										<bean:write name="line" field="jiexianzi" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="rj11" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="rj45" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="mokuai" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="mianban" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="wangxian" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="qitahaocai" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="beizhuhuizong" />
									</td>
								</tr>
							</logic:iterate> 
						</table>
					</div>
					<!-- 结果一览 end-->
					<div name="page_down" class="page_downuser">
						<div align="right">
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- 查询结果 end -->
				<!-- button -->
				<div id="buttonC" name="button" class="content_button" >
				  <html:button property="btnSave" value="维修提交" styleClass="commonButton2" onclick="commonSubmit('shenqingDataEdit.do?act=initInsertWeixiu')"/>
			    </div>
			</div>
		</html:form>
	</div>
	</body>
	<script type="text/javascript"  language="javascript">
	</script>
</html>
