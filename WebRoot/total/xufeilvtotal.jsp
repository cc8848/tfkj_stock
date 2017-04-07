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
		<html:form action="xufeilv.do" method="post">
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top">
					��ϸͳ��
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">

					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td width="400px">
								<script>
var arrayObj = new Array();
</script>
								<logic:iterate id="xiaoquList" name="xufeilvForm"  property="xiaoquList">
									<script>
var temp = '<bean:write  name="xiaoquList"  property="key" />';
arrayObj.push(temp);
</script>
								</logic:iterate>
								<input type="button" value="С��ѡ��" onclick="show_child();" />
								<html:textarea name="xufeilvForm" property="xiaoqutext" rows="1"
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
							<td>
								
								��ʼʱ��
								<html:text name="xufeilvForm" property="kaijis" styleId="kaijis"
									size="10" onclick="WdatePicker({el:'kaijis'})" />
								<img onclick="WdatePicker({el:'kaijis'})"
									src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif"
									width="16" height="22" align="absmiddle" />

								����ʱ��
								<html:text name="xufeilvForm" property="kaijie" styleId="kaijie"
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
					
					<div class="result_table">
					<table border="0" cellspacing="0" cellpadding="1" width="100%">
						  <tr bgcolor="#EEF5FA" align="center">
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%" rowspan="3">С��</td>
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" colspan="6"><bean:write name="xufeilvForm" property="kaijis" />��<bean:write name="xufeilvForm" property="kaijie" /></td>
						  </tr>
						  <tr bgcolor="#EEF5FA" align="center">
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" colspan="3">���ҵ��</td>
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" colspan="3">����ҵ��</td>
						  </tr>
						  <tr bgcolor="#EEF5FA" align="center">
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%">������</td>
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%">������</td>
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%">������(%)</td>
						   	<td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%">������</td>
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%">������</td>
						    <td bgcolor="#c99979" class="tableTitleLine" nowrap="nowrap" width="14%">������(%)</td>
						  </tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="xiaoqu" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xufeishuwangluo" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="hejizhiwangluo" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xufeilvwangluo" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xufeishudianshi" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="hejizhidianshi" />
									</td>
									<td class="tableContentLine" height="20"nowrap="nowrap">
										<bean:write name="line" field="xufeilvdianshi" />
									</td>
								</tr>
							</logic:iterate>
						</table>
					</div>
					<!-- ���һ�� end-->
					</div>
				</div>
			</div>
			<html:hidden name="xufeilvForm" property="xiaoqutextHidden" />
			<html:hidden name="xufeilvForm" property="kaijisHidden" />
			<html:hidden name="xufeilvForm" property="kaijieHidden" />

		</html:form>
		<script type="text/javascript">
//����excle
function exportNoBind(){
	document.forms[0].action = 'mingxitotalListDaochu.do?act=export';
 	document.forms[0].submit();
}		
function sub() {
	var xiaoquname = document.forms[0].xiaoqutext.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("�û�С������Ϊ�գ�");
		document.forms[0].xiaoqutext.focus();// ���ý���
		return false;
	}
	var kaijis = document.forms[0].kaijis.value;
	if (kaijis == null || trim(kaijis) == "") {
		alert("��ʼʱ�䲻��Ϊ�գ�");
		document.forms[0].kaijis.focus();// ���ý���
		return false;
	}
	var kaijie = document.forms[0].kaijie.value;
	if (kaijie == null || trim(kaijie) == "") {
		alert("����ʱ�䲻��Ϊ�գ�");
		document.forms[0].kaijie.focus();// ���ý���
		return false;
	}
		commonSubmit('xufeilv.do?act=query');
	
}

checkInput = function() {
	 		var kaijis = document.forms[0].kaijis.value;
		var tingjis = document.forms[0].kaijie.value;
	var type=document.forms[0].shijianleixing.value;
	if(type!=""){
		
		if((kaijis!=null||trim(kaijis)!="") &&(tingjis==null||trim(tingjis)==""))
			{
				alert("����ʱ�䲻��Ϊ�գ�");
				document.forms[0].kaijis.focus();//���ý���
				return false;
			}
			
		if((kaijis==null||trim(kaijis)=="") &&(tingjis!=null||trim(tingjis)!=""))
			{
				alert("��ʼʱ�䲻��Ϊ�գ�");
				document.forms[0].kaijis.focus();//���ý���
				return false;
			} 

	 if(tingjis<kaijis)
	{
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
