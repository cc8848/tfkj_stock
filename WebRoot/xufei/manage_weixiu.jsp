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
		<script src="js/Calendar3.js" language="javascript"></script>
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<script src="xufei/xufei.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
		<style>
			form {padding:0;margin:0;border:0}
		</style> 
	</head>
	<body onload="init()">
	<div style="height:480px;">
		<html:form action="chulidaiweixiuDataList.do">
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					ά�޴�����
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query2">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								ά��ʱ��
							</td>
							<td>
								<html:text name="yonghuDataForm" property="tingjiDateHidden" size="10" onclick="new Calendar().show(this)" />		
							</td>
							<td>
								С������
							</td>
							<td>
								<html:select name="yonghuDataForm" property="quyuCodeHidden"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">-��ѡ��-</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							</td>
							<td>
								��ַ
							</td>
							<td>
								<html:text name="yonghuDataForm" property="addressCodeHidden" size="10" />
							</td>
							<td>
								ά������
							</td>
							<td>
							<html:select name="yonghuDataForm" property="zhuangtai"
								styleClass="commonTextFieldHover" 
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">-��ѡ��-</html:option>
								<html:option value="�豸����">�豸����</html:option>
								<html:option value="ƽ̨����">ƽ̨����</html:option>
								<html:option value="FTTH����">FTTH����</html:option>
								<html:option value="�����ս�">�����ս�</html:option>
								<html:option value="��������">��������</html:option>
							</html:select>
							</td>
							<td align="right">
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('chulidaiweixiuDataList.do?act=query')" />
							</td>
							</tr>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result2">
					<!-- ��ҳͷ -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- ���һ�� start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="200%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine">
									�༭
								</td>
								<td class="tableTitleLine">
									�û�״̬
								</td>
								<td class="tableTitleLine">
									ά��ʱ��
								</td>
								<td class="tableTitleLine">
									С��
								</td>
								<td class="tableTitleLine">
									��ַ
								</td>	
								<td class="tableTitleLine">
									ά������
								</td>	
								<td class="tableTitleLine">
									��Ӫ��
								</td>						
								<td class="tableTitleLine">
									ά������
								</td>
								<td class="tableTitleLine">
									�ֹ�
								</td>
								<td class="tableTitleLine">
									onu mac
								</td>
								<td class="tableTitleLine">
									STB MCID
								</td>
								<td class="tableTitleLine">
									����IP
								</td>
								<td class="tableTitleLine">
									ʩ����
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
									�����
								</td>
								<td class="tableTitleLine">
									���ӷ�
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
									���
								</td>
								<td class="tableTitleLine">
									onuѺ��
								</td>
								<td class="tableTitleLine">
									������Ѻ��
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
									�����Ĳ�
								</td>
								<td class="tableTitleLine">
									��ע����
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center" style="<bean:write name='line' field='linkcolor' />;">
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUIDS" type="checkbox" value="${line.id}" />
										
									</td>
									<td class="tableContentLine" nowrap="nowrap">
										<input name="UUID" type="radio" value="${line.id}" />  
									</td>
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
										<input type="hidden" name="fenguang" value="<bean:write name='line' field='fenguang' />"/>
										<input type="hidden" name="fenguangID" value="<bean:write name='line' field='fenguangID' />"/>
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="onumac" />
										<input type="hidden" name="onumac" value="<bean:write name='line' field='onumac' />"/>
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="stbmcid" />
										<input type="hidden" name="stbmcid" value="<bean:write name='line' field='stbmcid' />"/>
									</td>
									<td class="tableContentLine">
										<bean:write name="line" field="dianshiip" />
										<input type="hidden" name="dianshiip" value="<bean:write name='line' field='dianshiip' />"/>
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
					<html:button property="btnSave" value="ȫѡ" styleClass="commonButton" onclick="isCheck()"/>
				  <html:button property="btnSave" value="¼��" styleClass="commonButton2" onclick="shenhe1();"/>
				  <html:button property="btnSave" value="�༭" styleClass="commonButton2" onclick="commonCheckSubmit('shenqingDataEdit.do?act=initEditDaiweixiu','UUID','��ѡ��һ�����༭��ά������')"/>
				  <html:button property="btnSave" value="ɾ��" styleClass="commonButton2" onclick="removeData3()"/>
					<html:button styleId="btnfenguangpipei" property="btnfenguangpipei" value="ƥ��ֹ�"  style="color:white;background-color:green;height: 21px;"  onclick="commonCheckSubmit('shenqingDataEdit.do?act=pipeipgd','UUIDS','��ѡ���ƥ��ļ�¼')"/>
					<html:button styleId="btnfenguangback" property="btnfenguangback" value="�ֹ����"  style="color:black;background-color:rgb(255, 110, 0);height: 21px;"  onclick="commonCheckSubmit('shenqingDataEdit.do?act=recyclepgd','UUIDS','��ѡ������յļ�¼')"/>
				<!--   <html:button property="btnSave" value="�鿴����" styleClass="commonButton2" onclick="commonCheckSubmit('yonghuDataEdit.do?act=showInfo','UUID','��ѡ����鿴���û�����')"/> -->
			    </div>
			</div>
<!-- 			<html:hidden name="yonghuDataForm" property="quyuCodeHidden" /> -->
		</html:form>
		</div>
	
		
			</body>
	<script type="text/javascript"  language="javascript">
		function deletecheck(uuid) {
			var uuids = document.getElementsByName(uuid);
			var fenguangs = document.getElementsByName("fenguang");
			var onumacs = document.getElementsByName("onumac");
			var stbmcids = document.getElementsByName("stbmcid");
			var dianshiips = document.getElementsByName("dianshiip");
			var fenguangid = document.getElementsByName("fenguangID");
			for(var i=0;i<uuids.length;i++){
				if(uuids[i].checked){
					if(!checkValue(fenguangs[i].value)&&!checkValue(fenguangid[i].value)){
						alert("��ѡ�ɹ��������зֹ⣬����ִ�С��ֹ���ա��������ٽ���ɾ��!");
						return true;
					}else if(checkValue(fenguangs[i].value)&&checkValue(onumacs[i].value)&&checkValue(stbmcids[i].value)&&checkValue(dianshiips[i].value)) {
						//return true;
					}else{
						alert("��ѡ�ɹ����������豸������ִ�С��豸�ؿ⡿�������ٽ���ɾ����");
						return true;
					}
				}
			}
			return false;	
		}
		function checkValue(val) {
			if(val==""||val=="0"||val=="��"||val==" ") {
				return true;
			}
		}
		function  hiddenEditDiv() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			switch (roleCode) {         
			        case '5': 
			 			break;
			 		case '8':
			 			break;               
			    	 case '4':               
			            document.getElementById("buttonC").style.display="none";  
			            break;
			         default:
			         	document.getElementById("btnfenguangpipei").style.display="none";  
			         	document.getElementById("btnfenguangback").style.display="none";            
			} 
		}
		hiddenEditDiv();	
		var allCheck = false;
		
		function isCheck(){
			if(allCheck == false){
				checkAll();
				allCheck = true;
			}else{
				uncheckAll();
				allCheck = false;
			} 
		}
		
		function checkAll() { 
		var code_Values = document.getElementsByTagName("input"); 
			for(var i = 0;i < code_Values.length;i++) {
				if(code_Values[i].type == "checkbox") {
					code_Values[i].checked = true; 
				}
			}
			//alert(arrayCheckId);
		} 
		function uncheckAll() {
			var code_Values = document.getElementsByTagName("input"); 
			for(var i = 0;i < code_Values.length;i++) {
				if(code_Values[i].type == "checkbox") {
					code_Values[i].checked = false; 
				} 
			}
		}
	</script>
</html>
