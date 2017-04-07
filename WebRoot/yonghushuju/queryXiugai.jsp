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
		<script src="yonghushuju/yonghuData.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		
	
	</head>
	<body onload="init()">
	<div style="height:440px;">
		<html:form action="xiugaiShujuLogList.do">
		<bean:define id="xiaoquList" name="xiugaiShujuForm" property="xiaoquList"></bean:define>
		<bean:define id="ztList" name="xiugaiShujuForm" property="ztList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					�û������޸Ĳ�ѯ
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								�޸�ʱ�䣺
							</td>
							<td>
								<html:text name="xiugaiShujuForm" property="xiugaidates" styleId="xiugaidates" size="12" onclick="WdatePicker({el:'xiugaidates'})" />
								<img onclick="WdatePicker({el:'xiugaidates'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 		
							</td>
							<td>
								С�����ƣ�
							</td>
							<td>
								<html:select name="xiugaiShujuForm" property="xx_xiaoqu"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--��ѡ��--</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							</td>
							<td>
								��ַ
							</td>
							<td>
								<html:text name="xiugaiShujuForm" property="xx_dizhi" size="12" />
							</td>
							<td>
								״̬��
							</td>
							<td>
								<html:select name="xiugaiShujuForm" property="yh_zhuangtai"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:options collection="ztList" property="key" labelProperty="value" />
								</html:select>
							</td>
							<td align="right">
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('xiugaiShujuLogList.do?act=query')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;"></div>
				</div>
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result">
					<!-- ��ҳͷ -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- ���һ�� start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="480%">
							<tr bgcolor="#EEF5FA" align="center">
								<!-- <td class="tableTitleLine">
									&nbsp;
								</td> -->
								
								<td class="tableTitleLine">
									�û�״̬
								</td>
								<td class="tableTitleLine">
									ƥ��״̬
								</td>
								<td class="tableTitleLine">
									�տ�ʱ��
								</td>
								<td class="tableTitleLine">
									����
								</td>
								
								<td class="tableTitleLine">
									���֤��
								</td>
								
								<td class="tableTitleLine">
									�վݺ�
								</td>
								
								<td class="tableTitleLine">
									�ֹ��ߺ�
								</td>
								
								<td class="tableTitleLine">
									����λ��
								</td>
								
								<td class="tableTitleLine">
									����
								</td>
								
								<td class="tableTitleLine" >
									ͣ��
								</td>
								<td class="tableTitleLine" >
									��Чʱ��
								</td>
								<td class="tableTitleLine">
									С��
								</td>
								
								<td class="tableTitleLine">
									��ַ
								</td>
								
								<td class="tableTitleLine">
									��ϵ�绰
								</td>
								
								<td class="tableTitleLine">
									����
								</td>
								
								<td class="tableTitleLine">
									����
								</td>
								
								<td class="tableTitleLine">
									�绰
								</td>
								
								<td class="tableTitleLine">
									ҵ��
								</td>
								
								<td class="tableTitleLine">
									�ֹ�
								</td>
								
								<td class="tableTitleLine">
									Onu<br/>mac
								</td>
								
								<td class="tableTitleLine">
									STB<br/>MCID
								</td>
								
								<td class="tableTitleLine">
									����IP
								</td>
								
								<td class="tableTitleLine">
									����IP
								</td>
								
								<td class="tableTitleLine">
									�绰IP
								</td>
								
								<td class="tableTitleLine">
									�绰VLAN
								</td>
								
								<td class="tableTitleLine">
									����VLAN
								</td>
								
								<td class="tableTitleLine">
									����ʱ��
								</td>
								
								<td class="tableTitleLine">
									��֤
								</td>
								
								<td class="tableTitleLine">
									��ѡ�绰����
								</td>
								
								<td class="tableTitleLine">
									ONU<br/>Ѻ��
								</td>
								
								<td class="tableTitleLine">
									������<br/>Ѻ��
								</td>
								
								<td class="tableTitleLine">
									���ӷ�
								</td>
								
								<td class="tableTitleLine">
									�����
								</td>
								
								<td class="tableTitleLine">
									��װ��
								</td>
								
								<td class="tableTitleLine">
									�豸���۷�
								</td>
								
								<td class="tableTitleLine">
									���Ϸ�
								</td>
								
								<td class="tableTitleLine">
									��Ӫ��
								</td>
								
								<td class="tableTitleLine">
									�����·���
								</td>
								
								<td class="tableTitleLine">
									���
								</td>
								
								<td class="tableTitleLine" width="5%">
									��ע
								</td>
								
								<td class="tableTitleLine">
									���շ�
								</td>
								
								<td class="tableTitleLine">
									�վݱ���/�վݺ�
								</td>
								<td class="tableTitleLine">
									��Ʊ��Ϣ
								</td>
								
								<td class="tableTitleLine">
									�����豸ʹ�����
								</td>
								
								<td class="tableTitleLine">
									�����Ĳ�
								</td>
								
								<td class="tableTitleLine">
									������
								</td>
								
								<td class="tableTitleLine">
									RJ11
								</td>
								
								<td class="tableTitleLine">
									RJ45
								</td>
								
								<td class="tableTitleLine">
									ģ��
								</td>
								
								<td class="tableTitleLine">
									���
								</td>
								
								<td class="tableTitleLine">
									����
								</td>
								
								<td class="tableTitleLine">
									ʩ����
								</td>
								
								<td class="tableTitleLine" width="5%">
									�ֳ���ע
								</td>
								
								<td class="tableTitleLine" width="5%">
									��ע����
								</td>
								
								<td class="tableTitleLine">
									�޸���
								</td>
								
								<td class="tableTitleLine">
									�޸�ʱ��
								</td>
								
							</tr>
							
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<!--  <td class="tableContentLine">
										<input name="_ID" type="radio" value="${line.id}" />
									</td> -->
									
									<td class="tableContentLine">
										<bean:write name="line" field="yh_zhuangtai" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="pipeizhuangtai" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="shoukuanshijian" />
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="yh_name" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="yh_shenfenzhengNum" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="yh_shoujuhao" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="yh_fenguangxianNum" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="yh_xujieweizhi" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="yh_kaijiDate" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="yh_tingjiDate" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="yh_youxiaoDate" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="xx_xiaoqu" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="xx_dizhi" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="xx_dianhuaNum" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="xx_wangluo" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="xx_dianshi" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="xx_dianhua" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="xx_yewu" />
									</td>
									
									<td class="tableContentLine" >
										<bean:write name="line" field="fw_fenguang" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fw_onu_mac" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fw_stb_mcid" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fw_dianshi_ip" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fw_wangluo_ip" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fw_dianhua_ip" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fw_dianhua_vlan" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fw_wangluo_vlan" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fw_shangmen_date" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fw_danzheng" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fw_chose_dianhuaNum"  filter="false"/>
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fy_onu" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fy_jidinghe" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fy_shoushi" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fy_kuandai" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fy_chuzhuang" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fy_shebeixiaoshou" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fy_cailiao" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fy_yunyingshang" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fy_buzuyuegou" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fy_nianfei" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="fy_beizhu" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="qt_zongshoufei" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="qt_shoujuNum" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="qt_kaipiaoxinxi" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="qt_shebeishiyong" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="qt_haocai" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="qt_jiexianzi" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="qt_rj11" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="qt_rj45" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="qt_mokuai" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="qt_mianban" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="qt_wangxian" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="qt_shigongren" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="qt_xianchangbeizhu" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="beizhuhuizong" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="xiugai_ren" />
									</td>
									
									<td class="tableContentLine">
										<bean:write name="line" field="xiugai_date" />
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
			</div>
		
			<html:hidden name="xiugaiShujuForm" property="xx_xiaoquHidden" />
			<html:hidden name="xiugaiShujuForm" property="xx_dizhiHidden" />
			<html:hidden name="xiugaiShujuForm" property="yh_zhuangtaiHidden" />
			<html:hidden name="xiugaiShujuForm" property="xiugaidatesHidden" />
		</html:form>
		</div>

	</body>
</html>
