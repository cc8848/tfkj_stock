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
		<html:form action="mingxitotalList.do" method="post">
			<div id="content_all">
				<!-- ���� -->
				<div class="conten_top">
					��ϸͳ��
 <a href="shuliangtotalList.do?act=init" target="content">����ͳ��</a>
  <a href="shourutotalList.do?act=init" target="content">����ͳ��</a>
				</div>
				<!-- ��ѯ���� -->
				<div id="conten_query">

					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td width="400px">
								<script>
var arrayObj = new Array();
</script>
								<logic:iterate id="xiaoquList" name="totalForm"  property="xiaoquList">
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
								<script>
var arraygzlb = new Array();
</script>
								<logic:iterate id="gzlb" name="totalForm"  property="gongzuoleibieList">
									<script>
var temp = '<bean:write  name="gzlb"  property="key" />';
arraygzlb.push(temp);
</script>
								</logic:iterate>
								<input type="button" value="�������" onclick="show_gzlb();" />
								<html:textarea name="totalForm" property="gongzuoleibie"
									rows="1" cols="30" readonly="true"></html:textarea>
								<script>
function show_gzlb() {
	var child = window.showModalDialog('total/gongzuoleibie.htm', arraygzlb,
			'dialogWidth=760px ; dialogHeight=500px');
	if (!child.closed) {
		if (!window.close()) {
			//document.getElementById("txt0").value = child;
			//alert(child);
			document.forms[0].gongzuoleibie.value = child;
		} else {
			window.close();
			child.close();
		}
	}
}
</script>
							</td>
						</tr>
						<tr>
							<td width="400px">
								<script>
var arrayyys = new Array();
arrayyys.push('�췿');
arrayyys.push('����');
arrayyys.push('��ͨ');
arrayyys.push('��ͨ');
arrayyys.push('���');
</script>
								<input type="button" value="��Ӫ��" onclick="show_yys();" />
								<html:textarea name="totalForm" property="yunyingshang" rows="1"
									cols="30" readonly="true"></html:textarea>
								<script>
function show_yys() {
	var child = window.showModalDialog('total/yunyingshang.htm', arrayyys,
			'dialogWidth=760px ; dialogHeight=500px');
	if (!child.closed) {
		if (!window.close()) {
			//document.getElementById("txt0").value = child;
			//alert(child);
			document.forms[0].yunyingshang.value = child;
		} else {
			window.close();
			child.close();
		}
	}
}
</script>
							</td>
							<td>
								ʱ������
								<html:select name="totalForm" property="shijianleixing"
									styleClass="commonTextFieldHover"
									onfocus="this.className='commonTextFieldMove'"
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-��ѡ��-</html:option>
									<html:option value="1">����ʱ��</html:option>
									<html:option value="2">ͣ��ʱ��</html:option>
									<html:option value="3">�տ�����</html:option>
									<html:option value="4">��Чʱ��</html:option>
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
					<jsp:include page="/common/paginationHeader.jsp" />
					</div>

					<!-- ���һ�� start-->
					<div class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="200%">
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

					<!-- ���һ�� end-->
					<div class="page_down">
						<div align="right">
						<jsp:include page="/common/paginationFooter.jsp" />
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
			<html:hidden name="totalForm" property="shijianleixingHidden" />
			<html:hidden name="totalForm" property="kaijisHidden" />
			<html:hidden name="totalForm" property="kaijieHidden" />

		</html:form>
		<script type="text/javascript">
//����excle
function exportNoBind(){
	document.forms[0].action = 'mingxitotalListDaochu.do?act=export';
 	document.forms[0].submit();
}		
function sub() {
	if (checkInput()) {
		commonSubmit('mingxitotalList.do?act=query');
	}
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
