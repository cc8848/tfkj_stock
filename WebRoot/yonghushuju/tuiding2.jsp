<!--
TFTECH corporation (c)2012 all rights reserved.
Description:

Update:
Date Name Reason
============ ================== ==========
2012-11-23 Zhu,Xiao-Lei Create

-->
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
    <title>快速开发框架演示项目</title>
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
    <link href="css/common.css" type="text/css" rel="stylesheet"/>
    <link href="css/popupBox.css" type="text/css" rel="stylesheet"/>
    <script src="js/validate.js" language="javascript"></script>
    <script src="js/common.js" language="javascript"></script>
    <script src="js/jquery.js" language="javascript"></script>
    <script src="js/popupBox.js" language="javascript"></script>
    <script src="yonghushuju/yonghuData.js" language="javascript"></script>
    <script src="js/business.js" language="javascript"></script>
    <jsp:include page="/common/commonMessage.jsp"/>
</head>
<body onload="init()">
<html:form action="yonghuDataEdit.do">
    <div id="content_all">
        <!-- 标题 -->
        <div class="conten_top" name="top">退订申请</div>
        <div class="conten_query" name="query"></div>
        <div name="result" class="conten_result">
            <div name="result_table" class="result_table">
                <table border="0" cellspacing="0" cellpadding="2" width="940px">
                    <tr height="35px">
                        <td class="editTableTitle" width="30px">用户信息：</td>
                        <td class="editTableContent">
                            <table>
                                <tr>
                                    <td>
                                        小区名称：
                                        <%--<!-- <html:select name="yonghuDataEntityForm"--%>
												<%--property="xiaoqu" styleId="xiaoqu"--%>
												<%--styleClass="commonTextFieldHover"--%>
												<%--onchange="selectxiaoqu(this)"--%>
												<%--onfocus="this.className='commonTextFieldMove'"--%>
												<%--onblur="this.className='commonTextFieldHover'" disabled="true">--%>
												<%--<html:options collection="xiaoquList" property="key"--%>
													<%--labelProperty="value" />--%>
											<%--</html:select> <a:need /> -->--%>
                                        <html:text name="yonghuDataEntityForm"
                                                   property="xiaoqu" size="12" maxlength="20" readonly="true"
                                                   styleClass="commonTextFieldHover"
                                                   onfocus="this.className='commonTextFieldMove'"
                                                   onblur="this.className='commonTextFieldHover'" disabled="true"/>
                                        <a:need/>
                                        用户地址： <html:text name="yonghuDataEntityForm"
                                                         property="dizhi" size="12" maxlength="20" readonly="true"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"
                                                         disabled="true"/> <a:need/>
                                    </td>
                                    
                                </tr>
                                <tr hidden="true">
                                    <td>
                                        用户姓名： <html:text name="yonghuDataEntityForm"
                                                         property="xingming" size="12" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"
                                                         disabled="true"/> <a:need/>
                                        联系电话： <html:text name="yonghuDataEntityForm"
                                                         property="lianxidianhua" size="12" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"
                                                         disabled="true"/> <a:need/>
                                    </td>
                                </tr>

                                    <td>身份证号： <html:text name="yonghuDataEntityForm"
                                                         property="shenfensheng" size="30" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"
                                                         disabled="true"/> <a:need/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
                <table border="0" cellspacing="0" cellpadding="2" width="940px">
                    <tr height="35px">
                        <td class="editTableTitle" width="30px">服务信息：</td>
                        <td class="editTableContent">
                            <table>
                                <tr hidden="true">
                                    <td>用户状态： <html:select name="yonghuDataEntityForm" property="yonghuzhuangtai"
                                                           styleClass="commonTextFieldHover"
                                                           onfocus="this.className='commonTextFieldMove'"
                                                           onblur="this.className='commonTextFieldHover'"
                                                           disabled="true">
                                        <html:option value="已安装">已安装</html:option>
                                        <html:option value="已维修">已维修</html:option>
                                        <html:option value="已续费">已续费</html:option>
                                        <html:option value="已退订">已退订</html:option>
                                        <html:option value="已拆机">已拆机</html:option>
                                        <html:option value="错误项">错误项</html:option>
                                        <html:option value="停机保号">停机保号</html:option>
                                        <html:option value="已收件">已收件</html:option>
                                    </html:select>
                                        <a:need/>
                                        匹配状态： <html:select name="yonghuDataEntityForm" property="pipeizhuangtai"
                                                           styleClass="commonTextFieldHover"
                                                           onfocus="this.className='commonTextFieldMove'"
                                                           onblur="this.className='commonTextFieldHover'"
                                                           disabled="true">
                                            <html:option value="已匹配">已匹配</html:option>
                                            <html:option value="未匹配">未匹配</html:option>
                                        </html:select>
                                        <a:need/>

                                        收款时间： <html:text name="yonghuDataEntityForm" property="shoukuanshijian"
                                                         styleId="shoukuanshijian" size="10"
                                                         onclick="WdatePicker({el:'shoukuanshijian'})" disabled="true"/>
                                        <img onclick="WdatePicker({el:'shoukuanshijian'})"
                                             src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif"
                                             width="16" height="22" align="absmiddle"> <a:need/>
                                        </img>
                                        <br/>
                                        收据号：<html:text name="yonghuDataEntityForm"
                                                       property="shoujuhao" size="20" maxlength="100"
                                                       styleClass="commonTextFieldHover"
                                                       onfocus="this.className='commonTextFieldMove'"
                                                       onblur="this.className='commonTextFieldHover'" disabled="true"/>
                                        <a:need/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>分光线号： <html:text name="yonghuDataEntityForm"
                                                         property="fenguangxianhao" size="12" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"
                                                         disabled="true"/> <a:need/>
                                        接续位置： <html:text name="yonghuDataEntityForm"
                                                         property="jiexuweizhi" size="12" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"
                                                         disabled="true"/> <a:need/>
                                    </td>
                                </tr>
                                <tr hidden="true">
                                    <td disabled="true">开机时间： <html:text name="yonghuDataEntityForm"
                                                                         property="kaijishijian"
                                                                         styleId="kaijishijians" size="10"
                                                                         onclick="WdatePicker({el:'kaijishijians'})"
                                                                         disabled="true"/>
                                        <img onclick="WdatePicker({el:'kaijishijians'})"
                                             src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif"
                                             width="16" height="22" align="absmiddle"> <a:need/>
                                        停机时间： <html:text name="yonghuDataEntityForm" property="tingjishijian"
                                                         styleId="tingjishijians" size="10"
                                                         onclick="WdatePicker({el:'tingjishijians'})"/>
                                        <img onclick="WdatePicker({el:'tingjishijians'})"
                                             src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif"
                                             width="16" height="22" align="absmiddle"> <a:need/>
                                        有效时间： <html:text name="yonghuDataEntityForm" property="youxiaoshijian"
                                                         styleId="youxiaoshijians" size="10"
                                                         onclick="WdatePicker({el:'youxiaoshijians'})"/>
                                        <img onclick="WdatePicker({el:'youxiaoshijians'})"
                                             src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif"
                                             width="16" height="22" align="absmiddle"> <a:need/>
                                    </td>
                                </tr>
                                <tr disabled="true">
                                    <td>网络： <html:text name="yonghuDataEntityForm"
                                                       property="wangluo" size="12" maxlength="20"
                                                       styleClass="commonTextFieldHover"
                                                       onfocus="this.className='commonTextFieldMove'"
                                                       onblur="this.className='commonTextFieldHover'"/> <a:need/>
                                        电视： <html:text name="yonghuDataEntityForm"
                                                       property="dianshi" size="12" maxlength="20"
                                                       styleClass="commonTextFieldHover"
                                                       onfocus="this.className='commonTextFieldMove'"
                                                       onblur="this.className='commonTextFieldHover'"/> <a:need/>
                                        电话： <html:text name="yonghuDataEntityForm"
                                                       property="dianhua" size="12" maxlength="20"
                                                       styleClass="commonTextFieldHover"
                                                       onfocus="this.className='commonTextFieldMove'"
                                                       onblur="this.className='commonTextFieldHover'"/> <a:need/>
                                    </td>
                                </tr>
                                <tr disabled="true">
                                    <td>业务： <html:text name="yonghuDataEntityForm"
                                                       property="yewu" size="12" maxlength="100"
                                                       styleClass="commonTextFieldHover"
                                                       onfocus="this.className='commonTextFieldMove'"
                                                       onblur="this.className='commonTextFieldHover'"/>

                                    </td>
                                    <td>
                                        分光： <html:text name="yonghuDataEntityForm"
                                                       property="fenguang" size="12" maxlength="100"
                                                       styleClass="commonTextFieldHover"
                                                       onfocus="this.className='commonTextFieldMove'"
                                                       onblur="this.className='commonTextFieldHover'"/>
                                    </td>
                                </tr>
                            </table>

                        </td>
                    </tr>
                </table>

                <table border="0" cellspacing="0" cellpadding="2" width="940px">
                    <tr height="35px">
                        <td class="editTableTitle" width="30px">退订信息：</td>
                        <td class="editTableContent">
                            <table>
                                <tr>
                                    <td>退订时间： <html:text name="yonghuDataEntityForm" property="tuidingshijian"
                                                         styleId="tuidingshijian" size="10"
                                                         onclick="WdatePicker({el:'tuidingshijian'})"
                                                         /><a:need/>
                                        施工人： <html:text name="yonghuDataEntityForm"
                                                        property="shigongren" size="12" maxlength="100"

                                                /><a:need/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>退订原因： <html:text name="yonghuDataEntityForm"
                                                         property="tuidingyuanyin" size="30" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>

                                        <html:checkbox property="tuikuandai" name="yonghuDataEntityForm" value="1">退宽带</html:checkbox>
                                        <html:checkbox property="tuionu" name="yonghuDataEntityForm" value="1">退onu</html:checkbox>
                                        <html:checkbox property="tuijidinghe" name="yonghuDataEntityForm" value="1">退机顶盒</html:checkbox>
                                        <html:checkbox property="tuiyajin" name="yonghuDataEntityForm" value="1">退押金</html:checkbox>
                                    </td>
                                </tr>

                            </table>
                        </td>
                    </tr>
                </table>
                <table border="0" cellspacing="0" cellpadding="2" width="940px">
                    <tr height="35px" disabled="true">
                        <td class="editTableTitle" width="30px">设备信息：</td>
                        <td class="editTableContent">
                            <table>
                                <tr>
                                    <td>Onu mac： <html:text name="yonghuDataEntityForm"
                                                            property="onumac" size="12" maxlength="100"
                                                            styleClass="commonTextFieldHover"
                                                            onfocus="this.className='commonTextFieldMove'"
                                                            onblur="this.className='commonTextFieldHover'"/><a:need/>
                                        STB MCID： <html:text name="yonghuDataEntityForm"
                                                             property="stbmcid" size="12" maxlength="100"
                                                             styleClass="commonTextFieldHover"
                                                             onfocus="this.className='commonTextFieldMove'"
                                                             onblur="this.className='commonTextFieldHover'"/><a:need/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>电视IP： <html:text name="yonghuDataEntityForm"
                                                         property="dianshiip" size="14" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"/><a:need/>
                                        网络IP： <html:text name="yonghuDataEntityForm"
                                                         property="wangluoip" size="14" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"/> <a:need/>
                                        电话IP： <html:text name="yonghuDataEntityForm"
                                                         property="dianhuaip" size="14" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"/> <a:need/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>电话vlan： <html:text name="yonghuDataEntityForm"
                                                           property="dianhuavlan" size="15" maxlength="100"
                                                           styleClass="commonTextFieldHover"
                                                           onfocus="this.className='commonTextFieldMove'"
                                                           onblur="this.className='commonTextFieldHover'"/> <a:need/>
                                        网络vlan： <html:text name="yonghuDataEntityForm"
                                                           property="wangluovlan" size="15" maxlength="100"
                                                           styleClass="commonTextFieldHover"
                                                           onfocus="this.className='commonTextFieldMove'"
                                                           onblur="this.className='commonTextFieldHover'"/> <a:need/>
                                    </td>

                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
                <table border="0" cellspacing="0" cellpadding="2" width="940px">
                    <tr height="35px">
                        <td class="editTableTitle" width="30px">上门信息：</td>
                        <td class="editTableContent">
                            <table>
                                <tr hidden="true">
                                    <td>上门时间： <html:text name="yonghuDataEntityForm"
                                                         property="shangmenshijian" size="15" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"/>

                                        单证：<html:text name="yonghuDataEntityForm"
                                                      property="danzheng" size="30" maxlength="100"
                                                      styleClass="commonTextFieldHover"
                                                      onfocus="this.className='commonTextFieldMove'"
                                                      onblur="this.className='commonTextFieldHover'"/>
                                    </td>
                                </tr>
                                <tr hidden="true">
                                    <td>
                                        所选电话号码：<html:text name="yonghuDataEntityForm"
                                                          property="sxdhhm" size="40" maxlength="100"
                                                          styleClass="commonTextFieldHover"
                                                          onfocus="this.className='commonTextFieldMove'"
                                                          onblur="this.className='commonTextFieldHover'"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Onu押金： <html:text name="yonghuDataEntityForm"
                                                          property="onuyj" size="15" maxlength="100"
                                                          styleClass="commonTextFieldHover"
                                                          onfocus="this.className='commonTextFieldMove'"
                                                          onblur="this.className='commonTextFieldHover'"/>
                                        机顶盒押金： <html:text name="yonghuDataEntityForm"
                                                          property="jidingheyj" size="15" maxlength="100"
                                                          styleClass="commonTextFieldHover"
                                                          onfocus="this.className='commonTextFieldMove'"
                                                          onblur="this.className='commonTextFieldHover'"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>收视费： <html:text name="yonghuDataEntityForm"
                                                        property="shoushifei" size="15" maxlength="100"
                                                        styleClass="commonTextFieldHover"
                                                        onfocus="this.className='commonTextFieldMove'"
                                                        onblur="this.className='commonTextFieldHover'"/>
                                        宽带费： <html:text name="yonghuDataEntityForm"
                                                        property="kuandaifei" size="15" maxlength="100"
                                                        styleClass="commonTextFieldHover"
                                                        onfocus="this.className='commonTextFieldMove'"
                                                        onblur="this.className='commonTextFieldHover'"/>
                                        初装费： <html:text name="yonghuDataEntityForm"
                                                        property="chuzhuangfei" size="15" maxlength="100"
                                                        styleClass="commonTextFieldHover"
                                                        onfocus="this.className='commonTextFieldMove'"
                                                        onblur="this.className='commonTextFieldHover'"/>
                                    </td>

                                </tr>
                                <tr>
                                    <td>设备销售费： <html:text name="yonghuDataEntityForm"
                                                          property="shebeixiaoshou" size="15" maxlength="20"
                                                          styleClass="commonTextFieldHover"
                                                          onfocus="this.className='commonTextFieldMove'"
                                                          onblur="this.className='commonTextFieldHover'"/>
                                        材料费： <html:text name="yonghuDataEntityForm"
                                                        property="cailiaofei" size="15" maxlength="20"
                                                        styleClass="commonTextFieldHover"
                                                        onfocus="this.className='commonTextFieldMove'"
                                                        onblur="this.className='commonTextFieldHover'"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>运营商： <html:text name="yonghuDataEntityForm"
                                                        property="yunyingshang" size="15" maxlength="100"
                                                        styleClass="commonTextFieldHover"
                                                        onfocus="this.className='commonTextFieldMove'"
                                                        onblur="this.className='commonTextFieldHover'"/>
                                        不足月够费： <html:text name="yonghuDataEntityForm"
                                                          property="bzygf" size="15" maxlength="100"
                                                          styleClass="commonTextFieldHover"
                                                          onfocus="this.className='commonTextFieldMove'"
                                                          onblur="this.className='commonTextFieldHover'"/>
                                        年费： <html:text name="yonghuDataEntityForm"
                                                       property="nianfei" size="15" maxlength="100"
                                                       styleClass="commonTextFieldHover"
                                                       onfocus="this.className='commonTextFieldMove'"
                                                       onblur="this.className='commonTextFieldHover'"/>
                                    </td>

                                </tr>
                                <tr hidden="true">
                                    <td>备注： <!--  <html:text name="yonghuDataEntityForm"
												property="beizhu" size="15" maxlength="100"
												styleClass="commonTextFieldHover"
												onfocus="this.className='commonTextFieldMove'"
												onblur="this.className='commonTextFieldHover'" /> -->
                                        <html:textarea name="yonghuDataEntityForm" property="beizhu"
                                                       rows="5" cols="70"
                                                       onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
                                        </html:textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        总收费： <html:text name="yonghuDataEntityForm"
                                                        property="zongshoufei" size="15" maxlength="100"
                                                        styleClass="commonTextFieldHover"
                                                        onfocus="this.className='commonTextFieldMove'"
                                                        onblur="this.className='commonTextFieldHover'"/>
                                    </td>

                                </tr>
                                <tr hidden="true">
                                    <td>收据本号/收据号： <html:text name="yonghuDataEntityForm"
                                                             property="shoujubenhao" size="30" maxlength="100"
                                                             styleClass="commonTextFieldHover"
                                                             onfocus="this.className='commonTextFieldMove'"
                                                             onblur="this.className='commonTextFieldHover'"/>
                                    </td>
                                </tr>
                                <tr hidden="true">
                                    <td>开票信息：
                                        <html:textarea name="yonghuDataEntityForm" property="kaipiaoxinxi"
                                                       rows="5" cols="70"
                                                       onkeyup="if(this.value.length>200)this.value=this.value.substr(0,200)">
                                        </html:textarea>
                                    </td>
                                </tr>
                                <tr hidden="true">
                                    <td>
                                        其他设备使用情况： <html:text name="yonghuDataEntityForm"
                                                             property="qtsbsyqk" size="30" maxlength="100"
                                                             styleClass="commonTextFieldHover"
                                                             onfocus="this.className='commonTextFieldMove'"
                                                             onblur="this.className='commonTextFieldHover'"/>
                                    </td>

                                </tr>
                                <tr hidden="true">
                                    <td>其他耗材： <html:text name="yonghuDataEntityForm"
                                                         property="qitahaocai" size="15" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"/>
                                        接线子： <html:text name="yonghuDataEntityForm"
                                                        property="jiexianzi" size="15" maxlength="100"
                                                        styleClass="commonTextFieldHover"
                                                        onfocus="this.className='commonTextFieldMove'"
                                                        onblur="this.className='commonTextFieldHover'"/> <br/>
                                        RJ11： <html:text name="yonghuDataEntityForm"
                                                         property="rj11" size="15" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"/>
                                        RJ45： <html:text name="yonghuDataEntityForm"
                                                         property="rj45" size="15" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"/>
                                    </td>

                                </tr>
                                <tr hidden="true">
                                    <td>模块： <html:text name="yonghuDataEntityForm"
                                                       property="mokuai" size="15" maxlength="100"
                                                       styleClass="commonTextFieldHover"
                                                       onfocus="this.className='commonTextFieldMove'"
                                                       onblur="this.className='commonTextFieldHover'"/>
                                        面板： <html:text name="yonghuDataEntityForm"
                                                       property="mianban" size="15" maxlength="100"
                                                       styleClass="commonTextFieldHover"
                                                       onfocus="this.className='commonTextFieldMove'"
                                                       onblur="this.className='commonTextFieldHover'"/>
                                        网线： <html:text name="yonghuDataEntityForm"
                                                       property="wangxian" size="15" maxlength="100"
                                                       styleClass="commonTextFieldHover"
                                                       onfocus="this.className='commonTextFieldMove'"
                                                       onblur="this.className='commonTextFieldHover'"/>

                                    </td>

                                </tr>
                                <tr hidden="true">
                                    <td>
                                        <%--施工人： <html:text name="yonghuDataEntityForm"--%>
                                                        <%--property="shigongren" size="15" maxlength="100"--%>
                                                        <%--styleClass="commonTextFieldHover"--%>
                                                        <%--onfocus="this.className='commonTextFieldMove'"--%>
                                                        <%--onblur="this.className='commonTextFieldHover'"/>--%>
                                        现场备注： <html:text name="yonghuDataEntityForm"
                                                         property="xianchangbeizhu" size="15" maxlength="100"
                                                         styleClass="commonTextFieldHover"
                                                         onfocus="this.className='commonTextFieldMove'"
                                                         onblur="this.className='commonTextFieldHover'"/>
                                    </td>

                                </tr>
                                <tr>
                                    <td>备注汇总：
                                        <html:textarea name="yonghuDataEntityForm" property="beizhuhuizong"
                                                       rows="5" cols="70"
                                                       onkeyup="if(this.value.length>250)this.value=this.value.substr(0,250)">
                                        </html:textarea>
                                    </td>

                                </tr>
                            </table>
                        </td>
                    </tr>

                </table>
            </div>
        </div>
        <!-- button -->
        <div name="button" class="content_button">
            <html:button property="btnSave" value="提交" styleClass="commonButton" onclick="subs();"/>
            <html:button property="btnBack" value="返回" styleClass="commonButton"
                         onclick="commonSubmit('yonghuDataList.do?act=init')"/>
        </div>
    </div>
    <html:hidden name="yonghuDataEntityForm" property="UUID"/>
</html:form>
</body>
<script type="text/javascript">
    function subs() {
//        if (checkInput()) {
            commonSubmit('yonghuDataEdit.do?act=insertTuiding');
//        }
    }
</script>
</html>