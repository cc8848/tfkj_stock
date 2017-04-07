<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a" %>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>快速开发框架演示项目</title>
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
    <link href="css/common.css" type="text/css" rel="stylesheet"/>
    <link href="css/popupBox.css" type="text/css" rel="stylesheet"/>
    <script src="js/common.js" language="javascript"></script>
    <script src="js/validate.js" language="javascript"></script>
    <script src="js/jquery.js" language="javascript"></script>
    <script src="js/popupBox.js" language="javascript"></script>
    <script src="js/business.js" language="javascript"></script>
    <jsp:include page="/common/commonMessage.jsp"/>
</head>
<body onload="init()">
<html:form action="rediuslog.do">
    <div id="content_all">
        <!-- 标题 -->
        <div class="conten_top" name="top">
            radius接口日志
        </div>
        <!-- 查询条件 -->
        <div id="conten_query">
            <table id="quert_table" cellpadding="1" cellspacing="1" border="0">
                <tr>
                    <td>
                        小区：
                    </td>
                    <td>
                        <html:text name="rediusLogForm" property="xiaoqu" size="12"/>
                    </td>
                    <td>
                        地址：
                    </td>
                    <td>
                        <html:text name="rediusLogForm" property="dizhi" size="12"/>
                    </td>

                    <td>
                        宽带账号：
                    </td>
                    <td>
                        <html:text name="rediusLogForm" property="account" size="12"/>
                    </td>
                    <td>
                        触发日期：
                    </td>
                    <td>
                        <html:text name="rediusLogForm" property="createDt" size="12"/>
                    </td>

                    <td>
                        接口类型：
                    </td>
                    <td>
                        <html:select name="rediusLogForm" property="type"
                                     styleClass="commonTextFieldHover"
                                     onfocus="this.className='commonTextFieldMove'"
                                     onblur="this.className='commonTextFieldHover'">
                            <html:option value="">-请选择-</html:option>
                            <html:option value="复机">复机</html:option>
                            <html:option value="停机">停机</html:option>
                            <html:option value="速率变更">速率变更</html:option>
                            <html:option value="密码修改">密码修改</html:option>
                        </html:select>
                    </td>
                    <td>
                        日志状态：
                    </td>
                    <td>
                        <html:select name="rediusLogForm" property="status"
                                     styleClass="commonTextFieldHover"
                                     onfocus="this.className='commonTextFieldMove'"
                                     onblur="this.className='commonTextFieldHover'">
                            <html:option value="">-请选择-</html:option>
                            <html:option value="成功">成功</html:option>
                            <html:option value="失败">失败</html:option>
                        </html:select>
                    </td>
                    <td>
                        网上续费：
                    </td>
                    <td>
                        <html:select name="rediusLogForm" property="isweb"
                                     styleClass="commonTextFieldHover"
                                     onfocus="this.className='commonTextFieldMove'"
                                     onblur="this.className='commonTextFieldHover'">
                            <html:option value="">-请选择-</html:option>
                            <html:option value="是">是</html:option>
                            <html:option value="否">否</html:option>
                        </html:select>
                    </td>
                    <td align="right">
                        <input type="button" value="查询" class="commonButton"
                               onclick="commonSubmit('rediuslog.do?act=query')"/>
                    </td>
                </tr>
            </table>
            <div id="query2_div" style="display:none;">
            </div>
        </div>
        <!-- 查询结果 start -->
        <div name="result" class="conten_result">
            <!-- 分页头 -->

                <div name="page_up" class="page_up">
                        <jsp:include page="/common/paginationHeader.jsp"/>
                </div>
            <!-- 结果一览 start-->
            <div name="result_table" class="result_table">
                <table border="0" cellspacing="0" cellpadding="1" width="100%">
                    <tr bgcolor="#EEF5FA" align="center">
                        <td class="tableTitleLine" nowrap="nowrap">
                            小区
                        </td>
                        <td class="tableTitleLine" nowrap="nowrap">
                            地址
                        </td>
                        <td class="tableTitleLine" nowrap="nowrap">
                            宽带账号
                        </td>
                        <td class="tableTitleLine" nowrap="nowrap">
                            接口触发日期
                        </td>
                        <td class="tableTitleLine" nowrap="nowrap">
                            接口类型
                        </td>
                        <td class="tableTitleLine" nowrap="nowrap">
                            网上续费
                        </td>
                        <td class="tableTitleLine" nowrap="nowrap">
                            是否成功
                        </td>
                    </tr>
                    <logic:iterate id="line"
                                       name="com.takucin.aceeci.frame.pagination" property="result"
                                       type="com.takucin.aceeci.frame.sql.DataRow">
                            <tr align="center">
                                <td class="tableContentLine" nowrap="nowrap">
                                    <bean:write name="line" field="xiaoqu"/>
                                </td>
                                <td class="tableContentLine" height="20" nowrap="nowrap">
                                    <bean:write name="line" field="dizhi"/>
                                </td>
                                <td class="tableContentLine" height="20" nowrap="nowrap">
                                    <bean:write name="line" field="account"/>
                                </td>
                                <td class="tableContentLine" height="20" nowrap="nowrap">
                                    <bean:write name="line" field="createDt"/>
                                </td>
                                <td class="tableContentLine" height="20" nowrap="nowrap">
                                    <bean:write name="line" field="type"/>
                                </td>
                                <td class="tableContentLine" height="20" nowrap="nowrap">
                                    <bean:write name="line" field="isweb"/>
                                </td>
                                <td class="tableContentLine" height="20" nowrap="nowrap">
                                    <bean:write name="line" field="status"/>
                                </td>
                            </tr>
                        </logic:iterate>

                </table>

            </div>
            <!-- 结果一览 end-->
            <div name="page_down" class="page_down">
                    <div align="right">
                            <jsp:include page="/common/paginationFooter.jsp"/>
                    </div>

            </div>
        </div>
        <!-- 查询结果 end -->
        <!-- button -->
        <div name="button" class="content_button">
            <%--<input type="button" class="commonButton2" value="导出报表" onclick="exportNoBind();"/>--%>
            <%--<input type="button" class="commonButton2" value="当日停机" onclick="IPTVStop();"/>--%>
        </div>
    </div>

</html:form>
</body>
<script type="text/javascript">
    //导出excle
    function exportNoBind() {
        var tingjizhanghao = document.getElementById("tingjizhanghao").value;
        var tingjishijian = document.getElementById("tingjishijian").value;
        var shifouchenggong = document.getElementById("shifouchenggong").value;
//        window.open("iptvlogReport.do?act=export&tingjizhanghao=" + encodeURI(encodeURI(tingjizhanghao)) + "&tingjishijian=" + tingjishijian + "&shifouchenggong=" + encodeURI(encodeURI(shifouchenggong)));
    }

    function IPTVStop() {
        commonSubmit('iptvlogList.do?act=ipStop');
    }
    function autoSubimit() {
        if (event.keyCode == 13) {
            commonSubmit('rediuslog.do?act=query');
        }
    }
</script>
</html>
