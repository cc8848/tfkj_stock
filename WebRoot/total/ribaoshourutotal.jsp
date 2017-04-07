<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>���ٿ��������ʾ��Ŀ</title>
		<script language="javascript" type="text/javascript"
			src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js">
</script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript">
</script>
		<script src="js/validate.js" language="javascript">
</script>
		<script src="js/jquery.js" language="javascript">
</script>
		<script src="js/popupBox.js" language="javascript">
</script>
		<script src="js/business.js" language="javascript">
</script>
		<jsp:include page="/common/commonMessage.jsp" />

	</head>
	<body onload="init()">
		<html:form action="shourutotalList.do" method="post">
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top">
					����ͳ��
					<a href="mingxitotalList.do?act=init" target="content">��ϸͳ��</a>
					<a href="shuliangtotalList.do?act=init" target="content">����ͳ��</a>
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">

					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr  bgcolor="#EEF5FA" align="center">
							<td width="400px">
								<script>
var arrayObj = new Array();
</script>
								<logic:iterate id="xiaoquList" name="totalForm"
									property="xiaoquList">
									<script>
var temp = '<bean:write  name="xiaoquList"  property="key" />';
arrayObj.push(temp);
</script>
								</logic:iterate>
								<input type="button" value="С��ѡ��" onclick="show_child();" />
								<html:textarea name="totalForm" property="xiaoqutext" rows="1"
									cols="30" readonly="true"></html:textarea>
								<script>
function show_child() {
	var child = window.showModalDialog('total/modal.htm', arrayObj,
			'dialogWidth=760px ; dialogHeight=500px');
	if (!child.closed) {
		if (!window.close()) {
			//document.getElementById("txt0").value = child;
			//alert(child);
			document.forms[0].xiaoqutext.value = child;
		} else {
			window.close();
			child.close();
		}
	}
}
</script>
							</td>
							<td width="450px">
								ʱ������
								<html:select name="totalForm" property="shijianleixing"
									styleClass="commonTextFieldHover"
									onfocus="this.className='commonTextFieldMove'"
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:option value="1">����ʱ��</html:option>
									<html:option value="2">ͣ��ʱ��</html:option>
									<html:option value="3">�տ�����</html:option>
								</html:select>
								��ʼʱ��
								<html:text name="totalForm" property="kaijis" styleId="kaijis"
									size="10" onclick="WdatePicker({el:'kaijis'})" />
								<img onclick="WdatePicker({el:'kaijis'})"
									src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif"
									width="16" height="22" align="absmiddle" />

								����ʱ��
								<html:text name="totalForm" property="kaijie" styleId="kaijie"
									size="10" onclick="WdatePicker({el:'kaijie'})" />
								<img onclick="WdatePicker({el:'kaijie'})"
									src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif"
									width="16" height="22" align="absmiddle" />

							</td>
							<td align="right">
								<input type="button" value="ͳ��" class="commonButton"
									onclick="sub();" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display: none;">
					</div>
				</div>

				<!-- ��ѯ��� start -->
				<div class="conten_result">
					<!-- ��ҳͷ -->
					<div class="page_up">
						<%--					<jsp:include page="/common/paginationHeader.jsp" />--%>
					</div>

					<!-- ���һ�� start-->
					<div class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="100%">
							<tr  bgcolor="#EEF5FA" align="center">
								<logic:iterate id="line"
									name="com.takucin.aceeci.frame.pagination" property="result"
									type="com.takucin.aceeci.frame.sql.DataRow">
									<td  class="tableTitleLine" nowrap="nowrap">
										<table border="0" cellspacing="0" cellpadding="1" width="100%">
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

					<!-- ���һ�� end-->
					<div class="page_down">
						<div align="right">
							<%--						<jsp:include page="/common/paginationFooter.jsp" />--%>
						</div>
					</div>
				</div>
				<div name="button" class="content_button">
					<input type="button" class="commonButton2" value="��������" onclick="exportNoBind();"/>
				</div>
			</div>
			<html:hidden name="totalForm" property="xiaoqutextHidden" />
			<html:hidden name="totalForm" property="gongzuoleibiehidden" />
			<html:hidden name="totalForm" property="yunyingshanghidden" />
			<html:hidden name="totalForm" property="xiaoquHidden" />
			<html:hidden name="totalForm" property="kaijisHidden" />
			<html:hidden name="totalForm" property="kaijieHidden" />

		</html:form>
		<script type="text/javascript">
//����excle
function exportNoBind(){
	document.forms[0].action = 'shourutotalListDaochu.do?act=query';
 	document.forms[0].submit();
}			
function sub() {
	if (checkInput()) {
		commonSubmit('shourutotalList.do?act=query');
	}
}

checkInput = function() {
	var kaijis = document.forms[0].kaijis.value;
	var tingjis = document.forms[0].kaijie.value;
	var type = document.forms[0].shijianleixing.value;
	if (type != "") {

		if ((kaijis != null || trim(kaijis) != "")
				&& (tingjis == null || trim(tingjis) == "")) {
			alert("����ʱ�䲻��Ϊ�գ�");
			document.forms[0].kaijis.focus();//���ý���
			return false;
		}

		if ((kaijis == null || trim(kaijis) == "")
				&& (tingjis != null || trim(tingjis) != "")) {
			alert("��ʼʱ�䲻��Ϊ�գ�");
			document.forms[0].kaijis.focus();//���ý���
			return false;
		}

		if (tingjis < kaijis) {
			alert("����ʱ������ڿ�ʼʱ�䣡");
			return false;
		}
		 var d = DateDiff(kaijis, tingjis);
			if (d > 370) {
				alert("ʱ���ȴ���370�죬������ѡ�����ʱ�䣡");
				return false;
			}
	}
	return true;
};
function DateDiff(sDate1,sDate2) { 
		    var arrDate,objDate1,objDate2,intDays;
		    arrDate=sDate1.split("-");
		    objDate1=new Date(arrDate[1]+'-'+arrDate[2]+'-'+arrDate[0]);
		    arrDate=sDate2.split("-");
		    objDate2=new Date(arrDate[1] + '-'+arrDate[2]+'-'+arrDate[0]);
		    intDays=parseInt(Math.abs(objDate1-objDate2)/1000/60/60/24);
		    return intDays;
		}
function autoSubimit() {
	if (event.keyCode == 13) {
		sub();
	}
}
</script>
	</body>
</html>
