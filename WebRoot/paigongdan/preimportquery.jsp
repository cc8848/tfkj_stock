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
		<script src="js/Calendar3.js" language="javascript"></script>
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/popupBox.css" type="text/css" rel="stylesheet" />
		<script src="js/common.js" language="javascript"></script>
		<script src="js/validate.js" language="javascript"></script>
		<script src="js/jquery.js" language="javascript"></script>
		<script src="js/popupBox.js" language="javascript"></script>
		<script src="paigongdan/paigongdan.js" language="javascript"></script>
		<script src="js/business.js" language="javascript"></script>
		
	<script type="text/javascript"  language="javascript">
		function  hiddenEditDiv2() {
			var roleCode = '<%=((com.hrbank.business.employee.Employee)session.getAttribute(com.takucin.aceeci.common.Constant.LOGIN_USER)).getRoleCode()%>';
			if(roleCode!='5'&&roleCode!='8') {
				document.getElementById("deviceedit").style.display="none";
				document.getElementById("btnfenguangpipei").style.display="none";
				document.getElementById("btnfenguangback").style.display="none";
			}
			if(roleCode!='5'&&roleCode!='8'&&roleCode!='2') {
				document.getElementById("btnEdit").style.display="none";
			}
		}
		//删除
		function removeData(){
			if(checkSelect("UUIDS","请选择待删除的回单")){
				confirmRemove();
			}
		}
		//删除确认
		function confirmRemove(){
			showConfirm('确定要删除选定的回单？',removeCallback);
		}
		//删除操作
		function removeCallback(v,m,f){
			if(v){
				document.forms[0].action = "huidanPreImportList.do?act=delete";
				disableAll(document);
				document.forms[0].submit();
			}
		}
		function checkValue(val) {
			if(val==""||val=="0"||val=="　"||val==" ") {
				return true;
			}
		}
		function exportNoBind(){
			var xiaoqu = document.getElementById("xiaoqu").value;
			var paigongriqi = document.getElementById("paigongriqis").value;
			//if(xiaoqu==null||trim(xiaoqu)==""){
			//	infoMessage("请输入小区名称");
			//	document.getElementById("xiaoqu").focus();
			//	return false;
			//	}
			if(xiaoqu==null||trim(paigongriqi)==""){
				infoMessage("请输入派工日期");
				document.getElementById("paigongriqis").focus();
				return false;
				}
			window.open("huidanPreImportReport.do?act=export&paigongriqi="+ paigongriqi + "&xiaoqu=" + encodeURI(encodeURI(xiaoqu)));
	}
	function diertaiiptv(code,msg){
			var group = $("[name='UUID']").filter(":checked");
			var uuid = group.val();
			var uuids = document.getElementsByName("UUID");
			var tfiptvhidden = document.getElementsByName("tfiptvhidden");
			var fenguanghidden = document.getElementsByName("fenguanghidden");
			var onumachidden = document.getElementsByName("onumachidden");
			var xiaoqu = document.getElementsByName("xiaoquhidden");
			var dizhi = document.getElementsByName("dizhihidden");
			if(checkSelect(code,msg)){
				for(var i = 0;i<uuids.length;i++) {
					if(uuids[i].checked==true) {
					var heduitext = "";
						var a = /^(\d{4})-(\d{2})-(\d{2})$/
						while(true) {
							if(checkValue(tfiptvhidden[i].value)&&checkValue(fenguanghidden[i].value)&&checkValue(onumachidden[i].value)) {
								heduitext = prompt(xiaoqu[i].value+dizhi[i].value+"生成第二台电视，请输入新停机时间（不填则保留老停机时间）:","YYYY-MM-DD") ;
								if(heduitext===null) {
									return false;
								}
								if(heduitext=="") {
									break;
								}
								if (!a.test(heduitext)) { 
									infoMessage("日期格式不正确!") 
									continue;
								}else{
									break;
								}
							}else{
								infoMessage("电视、分光、ONU MAC必须非空非零！");
								return false;
							}
						} 
						document.getElementById("tingjishijian").value=heduitext;
						document.forms[0].action = "huidanPreImportList.do?act=diertaiiptv";
						disableAll(document);
						document.forms[0].submit();
					}
				}
			}
			//if(checkSelect(code,msg)){
			//		var heduitext = prompt("请输入核对备注的内容:","") ;
			//		$.ajax({
			//				url:"photouploadEdit.do?act=heduibeizhu",
			//				type : "POST",
			//				cache:false,
			//				data:{
			//					'uuid':uuid,
			//					'text':encodeURIComponent(heduitext)							
			//				},
			//				success: function(data){
			//					text_info("核对备注添加成功！");
			//					commonSubmit('photoauditList.do?act=query');
			//				}
			//			});
			//}
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
		<jsp:include page="/common/commonMessage.jsp" />
	</head>
	<body onload="init();">
		<html:form action="huidanPreImportList.do">
		<bean:define id="xiaoquList" name="paiGongDanPreImportForm" property="xiaoquList"></bean:define>
			<div id="content_all">
				<!-- 标题 -->
				<div class="conten_top" name="top">
					回单预导入
				</div>
				<!-- 查询条件 -->
				<div id="conten_query2" >
					<table id="quert_table" cellpadding="1" cellspacing="1" border="0">
						<tr>
							<td>
								派工日期
							</td>
							<td>
								<html:text name="paiGongDanPreImportForm" property="paigongriqis" styleId="paigongriqis" size="10" onclick="new Calendar().show(this)" />		
							</td>
							<td>
								开机时间
							</td>
							<td>
								<html:text name="paiGongDanPreImportForm" property="kaijishijian" styleId="kaijishijian" size="10" onclick="new Calendar().show(this)" />		
							</td>
							<td>
								停机时间
							</td>
							<td>
								<html:text name="paiGongDanPreImportForm" property="tingjishijian" styleId="tingjishijian" size="10" onclick="new Calendar().show(this)" />		
							</td>
							<td>
								小区名称
							</td>
							<td>
								<html:select name="paiGongDanPreImportForm" property="xiaoqu"
								styleClass="commonTextFieldHover" styleId="xiaoqu"
								onfocus="this.className='commonTextFieldMove'" 
								onblur="this.className='commonTextFieldHover'">
								<html:option value="">-请选择-</html:option>
								<html:options collection="xiaoquList" property="key" labelProperty="value" />
							</html:select>
							</td>
							<td>
								地址
							</td>
							<td>
								<html:text name="paiGongDanPreImportForm" property="dizhi" size="10" />
							</td>
							<td>
								业务类型
							</td>
							<td>
								<html:select name="paiGongDanPreImportForm" property="yewutype"
									styleClass="commonTextFieldHover" 
									onfocus="this.className='commonTextFieldMove'" 
									onblur="this.className='commonTextFieldHover'">
									<html:option value="">-请选择-</html:option>
									<html:option value="安装">安装</html:option>
									<html:option value="移机">移机</html:option>
									<html:option value="线路切改">线路切改</html:option>
								</html:select>
							</td>
							<td align="right">
								<input type="button" value="查询" class="commonButton" onclick="commonSubmit('huidanPreImportList.do?act=query')" />
							</td>
						</tr>
					</table>
					<div id="query2_div" style="display:none;">
					</div>
				</div>
				<!-- 查询结果 start -->
				<div name="result" class="conten_result2"  >
					<!-- 分页头 -->
					<div name="page_up" class="page_up">
						<jsp:include page="/common/paginationHeader.jsp" />
					</div>
					<!-- 结果一览 start-->
					<div name="result_table" class="result_table">
						<table border="0" cellspacing="0" cellpadding="1" width="140%">
							<tr bgcolor="#EEF5FA" align="center">
								<td class="tableTitleLine">
									<input  type="checkbox" id="selectAll" onclick="checkAll(this,'checkBox');"/>
								</td>
								<td class="tableTitleLine">
									&nbsp;
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									业务类型
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									安装比对
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									运营商
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									派工日期
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									开机时间
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									停机时间
								</td>
								<td class="tableTitleLine" nowrap="nowrap">
									小区
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									地址
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									联系电话
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									网络
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电视
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电话
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									业务
								</td>
								<td class="tableTitleLine" weight="20%"nowrap="nowrap">
									分光
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									onumac
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									STB MCID
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电视ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									网络ip
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电话ip/电视账号
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									电话VLAN
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									网络VLAN
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									上门时间
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									用户姓名
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									身份证
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									单证
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									所选电话号码
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									ONU押金
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									机顶盒押金
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									收视费
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									宽带费
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									初装费
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									设备销售费
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									材料费
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									不足月够费
								</td>
								<td class="tableTitleLine"nowrap="nowrap">
									年费
								</td>
								<td class="tableTitleLine">
									备注
								</td>
							</tr>
							<logic:iterate id="line"
								name="com.takucin.aceeci.frame.pagination" property="result"
								type="com.takucin.aceeci.frame.sql.DataRow">
								<tr align="center">
									<td class="tableContentLine">
										<input name="UUIDS" type="checkbox" id="checkBox" value="${line.id}" />
									</td>
									<td class="tableContentLine">
										<input name="UUID" type="radio" value="${line.id}" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="yewuleixing" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<font color="blue"><bean:write name="line" field="biduikbn" /></font>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="yuyingshang" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="paigongriqi" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="newkaijishijian" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="newtingjishijian" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="xiaoquname" /><input type="hidden" name="xiaoquhidden" value="<bean:write name="line" field="xiaoquname" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="userplace" /><input type="hidden" name="dizhihidden" value="<bean:write name="line" field="userplace" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="usertel" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tfkuandaidaikuan" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tfiptv" /><input type="hidden" name="tfiptvhidden" value="<bean:write name="line" field="tfiptv" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="tfsfyewu" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="qtye" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="bdfenguang"  filter="false"/><input type="hidden" name="fenguanghidden" value="<bean:write name="line" field="fenguangD" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="bdonumac"  filter="false"/><input type="hidden" name="onumachidden" value="<bean:write name="line" field="onumacD" />"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="bdstbmcid"  filter="false"/>
									</td>
									
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="bddianshiip" filter="false"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="netip" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="telip" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="telvaln"/>
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="netvaln" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="anzhuangshijian" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="username" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="shenfenzheng" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="danzheng" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="telhaoma" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="onu" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="jidinghe" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="shoushifei" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="kuaidaifei" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="chuzhuangfei" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="shebeixiaoshou" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="cailiaofei" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="buzuyue" />
									</td>
									<td class="tableContentLine"nowrap="nowrap">
										<bean:write name="line" field="nianfei" />
									</td>
									<td class="tableContentLine" width="29%" nowrap="nowrap">
										<bean:write name="line" field="beizhu" />
									</td>
								</tr>
							</logic:iterate>
						</table>

					</div>
					<!-- 结果一览 end-->
					<div name="page_down" class="page_down">
						<div align="right">
							<jsp:include page="/common/paginationFooter.jsp" />
						</div>
					</div>
				</div>
				<!-- 查询结果 end -->
				<!-- button -->
				<div name="button" class="content_button" style="width:70%">
						<html:button styleId="btnEdit" property="btnSave" value="编辑信息" styleClass="commonButton2" onclick="commonCheckSubmit('huidanPreImportListEdit.do?act=initEdit','UUID','请选择待编辑的派工单')"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<html:button styleId="btnfenguangpipei" property="btnfenguangpipei" value="匹配分光"  style="color:white;background-color:green;height: 21px;"  onclick="commonCheckSubmit('huidanPreImportList.do?act=pipeipgd','UUIDS','请选择待匹配的记录')"/>
						<html:button styleId="btnfenguangback" property="btnfenguangback" value="分光回收"  style="color:black;background-color:rgb(255, 110, 0);height: 21px;"  onclick="commonCheckSubmit('huidanPreImportList.do?act=recyclepgd','UUIDS','请选择待回收的记录')"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<html:button styleId="deviceedit" property="btnSave" value="生成第二台IPTV"  style="color:white;background-color:blue;height: 21px;" onclick="diertaiiptv('UUID','请选择待编辑的派工单')"/>
						<html:button styleId="btnfenguangpipei" property="btnfenguangpipei" value="删除信息"  style="color:black;background-color:yellow;height: 21px;"  onclick="removeData()"/>
						<br />
						<input type="button" class="commonButton2" value="导出报表" onclick="exportNoBind();"/>
						&nbsp;&nbsp;
						<html:button property="btnSave" value="第三方分光" styleClass="commonButton3" onclick="commonCheckSubmit('huidanPreImportList.do?act=disanfangfenguang','UUIDS','请选择待匹配的记录')"/>
						<html:button property="btnSave" value="待分配onu" styleClass="commonButton2" onclick="commonCheckSubmit('huidanPreImportList.do?act=daifenpeionu','UUIDS','请选择待匹配的记录')"/>
						<html:button property="btnSave" value="待分配机顶盒" styleClass="commonButton3" onclick="commonCheckSubmit('huidanPreImportList.do?act=daifenpeijidinghe','UUIDS','请选择待匹配的记录')"/>
						<html:button property="btnSave" value="FTTB小区" styleClass="commonButton2" onclick="commonCheckSubmit('huidanPreImportList.do?act=fttbxiaoqu','UUIDS','请选择待匹配的记录')"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<html:button property="btnSave" value="传输回单" styleClass="commonButton2" onclick="commonCheckSubmit('huidanPreImportList.do?act=transportHuidan','UUIDS','请选择待匹配的记录')"/>
				</div>
			</div>
		</html:form>
</body>
</html>
