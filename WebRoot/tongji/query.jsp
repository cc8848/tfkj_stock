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
		<script src="js/Calendar3.js" language="javascript"></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init();hiddenEditDiv2();">
		<html:form action="tongjiList.do">
		<bean:define id="xiaoquList" name="tongjiForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top" name="top">
					����������
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								С�����ƣ�
							</td>
							<td>
								<!--<html:text name="tongjiForm" property="xiaoqu" size="12" styleId="xiaoqu"/>-->
								<html:select name="tongjiForm" property="xiaoqu"styleId="xiaoqu"
								styleClass="commonTextFieldHover"  onkeydown="autoSubimit()"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--��ѡ��--</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
								
							</td>
							<td>
								���ڣ�
							</td>
							<td>
								<html:text name="tongjiForm" onclick="new Calendar().show(this)"  property="paigongriqi" size="12" styleId="paigongriqi"/>
							</td>
							
							<td>
								��ϵ�绰��
							</td>
							<td>
								<html:text name="tongjiForm" property="userTel"  size="12"  onkeydown="autoSubimit()"/>
							</td>
							<td>
								��ַ��
							</td>
							<td>
								<html:text name="tongjiForm" property="dizhi"  size="12"  onkeydown="autoSubimit()"/>
							</td>
							<td>
								�ɹ���״̬��
							</td>
							<td>
							<html:select name="tongjiForm" property="state"
								styleClass="commonTextFieldHover"  onkeydown="autoSubimit()"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--��ѡ��--</html:option>
								<html:option value="1">��ԤԼ</html:option>
								<html:option value="5">�����깤</html:option>
								<html:option value="6">ʩ����</html:option>
								<html:option value="7">����</html:option>
							</html:select>
							</td>
							<td>
								�ύ״̬��
							</td>
							<td>
							<html:select name="tongjiForm" property="importstate"
								styleClass="commonTextFieldHover"  onkeydown="autoSubimit()"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">--��ѡ��--</html:option>
								<html:option value="0">δ�ύ</html:option>
								<html:option value="1">���ύ</html:option>
							</html:select>
							</td>
							<td align="right">
								<input type="button" value="��ѯ" class="commonButton" onclick="commonSubmit('tongjiList.do?act=query')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- ��ѯ��� start -->
				<div name="result" class="conten_result">
					<!-- ��ҳͷ -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- ���һ�� start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1"  width="130%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine" nowrap="nowrap">
									<input  type="checkbox" id="selectAll" onclick="checkAll(this,'checkBox');"/>
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									״̬
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									�ύ״̬
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									����
								</td >
								<td class="tableTitleLine"nowrap="nowrap">
									��Ŀ
								</td>
								<td class="tableTitleLine"nowrap="nowrap" >
									����
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									ʱ��
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									С������
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�û���ַ
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�û�����
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									���֤��
								</td>
								<td class="tableTitleLine" weight="20%"nowrap="nowrap">
									��ϵ�绰
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									���
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									����
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�绰
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									ҵ��
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�ֹ�
								</td>
								<!-- <td class="tableTitleLine">
									�û�Ҫ��
								</td> -->
								<td class="tableTitleLine"nowrap="nowrap">
									ONUMAC
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									STBMCID
								</td>
								
								<td class="tableTitleLine"nowrap="nowrap">
									����ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									����ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�绰ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									�绰valn
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									����valn
								</td>
								<td class="tableTitleLine">
									��ע
								</td>
								
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine">
										<input name="UUIDS" type="checkbox" id="checkBox" value="${line.id}" />
									</td>
									<!-- <td class="tableContentLine">
										<bean:write name="line" field="PK_ID" />
									</td> -->
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="stateName" /><input type="hidden" name="statehidden" value="<bean:write name="line" field="stateName" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="importstate" /><input type="hidden" name="importstatehidden" value="<bean:write name="line" field="importstate" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<a href="paigongdanEdit.do?act=showInfo1&UUID=<bean:write name="line" field="PK_ID" />">�鿴����</a>
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xiangmu" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="paigongriqi" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="anzhuangshijian" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xiaoquname" /><input type="hidden" name="xiaoquname" value="<bean:write name="line" field="xiaoquname" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="userplace" /><input type="hidden" name="userplace" value="<bean:write name="line" field="userplace" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="username" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="shenfenzheng" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="usertel" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tfkuandaidaikuan" />/<bean:write name="line" field="tfkdnianxian" />
									</td>
									
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tfiptv" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="dianhua" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="qtye" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="fenguangD" />
									</td>
									<!--  <td class="tableContentLine">
										<bean:write name="line" field="useryaoqiu" />
									</td>-->
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="onumacD" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="stbmcidD" />
									</td>
									
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="dianshiipD" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="netip" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="telip" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="telvaln" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="netvaln" />
									</td>
									
									<td class="tableContentLine" width="30%" nowrap="nowrap">
										<bean:write name="line" field="beizhu" />
									</td>
									
									
								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- ���һ�� end-->
					<div name="page_down" class="page_down">
						<div align="right">
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- ��ѯ��� end -->
				<!-- button -->
				<div name="button" class="content_button">
				<html:button property="btnSave" styleId="shujuwangong" value="�����깤" styleClass="commonButton2" onclick="commonCheckSubmit('tongjiEdit.do?act=operate&type=1','UUIDS','��ѡ����������ɹ���')"/>
				<html:button property="btnSave" value="���չ���" styleClass="commonButton2" onclick="commonSubmit('paigongdanEdit.do?act=dangriGD')"/>	
				&nbsp;&nbsp;&nbsp;&nbsp;
				<html:button property="btnSave" styleId="huidanpre" value="�ص�Ԥ����" style="color:black;background-color:green;height: 21px;" onclick="commonCheckSubmit('tongjiEdit.do?act=huidanImport','UUIDS','��ѡ����������ɹ���')"/>
				<html:button property="btnSave" styleId="joufupre" value="�ظ�Ԥ����"   style="color:black;background-color:yellow;height: 21px;" onclick="commonCheckSubmit('tongjiEdit.do?act=huidanImportTwice','UUIDS','��ѡ����������ɹ���')"/>
				</div>
			</div>
			<html:hidden name="tongjiForm" property="xiaoquHidden" />
			<html:hidden name="tongjiForm" property="userTelHidden" />
			<html:hidden name="tongjiForm" property="stateHidden" />
			<html:hidden name="tongjiForm" property="paigongriqiHidden" />
			<html:hidden name="tongjiForm" property="dizhiHidden" />
		</html:form>
	</body>
	<script type="text/javascript">
	//����excle
		function exportNoBind(){
		//var classUUID = document.getElementById("classUUID").value;
		var xiaoqu = document.getElementById("xiaoqu").value;
		var paigongriqi = document.getElementById("paigongriqi").value;
			//if(xiaoqu==null||trim(xiaoqu)==""){
			//	infoMessage("������С������");
			//	document.getElementById("xiaoqu").focus();
			//	return false;
			//	}
			if(xiaoqu==null||trim(paigongriqi)==""){
				infoMessage("�������ɹ�����");
				document.getElementById("paigongriqi").focus();
				return false;
				}
			window.open("tongjiReport.do?act=export&paigongriqi="+ paigongriqi + "&xiaoqu=" + encodeURI(encodeURI(xiaoqu)));
	}
	function  hiddenEditDiv2() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			if(roleCode!='5'&&roleCode!='8') {
				document.getElementById("huidanpre").style.display="none";
				document.getElementById("joufupre").style.display="none";
				document.getElementById("shujuwangong").style.display="none";
			}
		}
		function autoSubimit() {
			if (event.keyCode == 13) {
				commonSubmit('tongjiList.do?act=query');
			}
		}
		checkAll=function(thisObj,checkId) {
            if(thisObj==undefined||thisObj==null)return false;
            var frm = document.forms[0];
    
            var inputs = eval("frm."+checkId);
            if(inputs==undefined)return false;
            var isSelected=false;
            if(thisObj.checked){
                    isSelected = true;
            }else{
                    isSelected = false;
            }
            if(inputs.length==undefined){
                    inputs.checked=isSelected;
            }else{
                    for(i=0;i<inputs.length;i++){
                            if(inputs[i].type=="checkbox"){
                                    inputs[i].checked=isSelected;
                            }
                    }                
            }

    }
	</script>
</html>
