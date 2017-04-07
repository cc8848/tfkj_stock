<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a" %>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>���ٿ��������ʾ��Ŀ</title>
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
        <!-- ���� -->
        <div class="conten_top" name="top">
            radius�ӿ���־
        </div>
        <!-- ��ѯ���� -->
        <div id="conten_query">
            <table id="quert_table" cellpadding="1" cellspacing="1" border="0">
                <tr>
                    <td>
                        С����
                    </td>
                    <td>
                        <html:text name="rediusLogForm" property="xiaoqu" size="12"/>
                    </td>
                    <td>
                        ��ַ��
                    </td>
                    <td>
                        <html:text name="rediusLogForm" property="dizhi" size="12"/>
                    </td>

                    <td>
                        ����˺ţ�
                    </td>
                    <td>
                        <html:text name="rediusLogForm" property="account" size="12"/>
                    </td>
                    <td>
                        �������ڣ�
                    </td>
                    <td>
                        <html:text name="rediusLogForm" property="createDt" size="12"/>
                    </td>

                    <td>
                        �ӿ����ͣ�
                    </td>
                    <td>
                        <html:select name="rediusLogForm" property="type"
                                     styleClass="commonTextFieldHover"
                                     onfocus="this.className='commonTextFieldMove'"
                                     onblur="this.className='commonTextFieldHover'">
                            <html:option value="">-��ѡ��-</html:option>
                            <html:option value="����">����</html:option>
                            <html:option value="ͣ��">ͣ��</html:option>
                            <html:option value="���ʱ��">���ʱ��</html:option>
                            <html:option value="�����޸�">�����޸�</html:option>
                        </html:select>
                    </td>
                    <td>
                        ��־״̬��
                    </td>
                    <td>
                        <html:select name="rediusLogForm" property="status"
                                     styleClass="commonTextFieldHover"
                                     onfocus="this.className='commonTextFieldMove'"
                                     onblur="this.className='commonTextFieldHover'">
                            <html:option value="">-��ѡ��-</html:option>
                            <html:option value="�ɹ�">�ɹ�</html:option>
                            <html:option value="ʧ��">ʧ��</html:option>
                        </html:select>
                    </td>
                    <td>
                        �������ѣ�
                    </td>
                    <td>
                        <html:select name="rediusLogForm" property="isweb"
                                     styleClass="commonTextFieldHover"
                                     onfocus="this.className='commonTextFieldMove'"
                                     onblur="this.className='commonTextFieldHover'">
                            <html:option value="">-��ѡ��-</html:option>
                            <html:option value="��">��</html:option>
                            <html:option value="��">��</html:option>
                        </html:select>
                    </td>
                    <td align="right">
                        <input type="button" value="��ѯ" class="commonButton"
                               onclick="commonSubmit('rediuslog.do?act=query')"/>
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
                        <jsp:include page="/common/paginationHeader.jsp"/>
                </div>
            <!-- ���һ�� start-->
            <div name="result_table" class="result_table">
                <table border="0" cellspacing="0" cellpadding="1" width="100%">
                    <tr bgcolor="#EEF5FA" align="center">
                        <td class="tableTitleLine" nowrap="nowrap">
                            С��
                        </td>
                        <td class="tableTitleLine" nowrap="nowrap">
                            ��ַ
                        </td>
                        <td class="tableTitleLine" nowrap="nowrap">
                            ����˺�
                        </td>
                        <td class="tableTitleLine" nowrap="nowrap">
                            �ӿڴ�������
                        </td>
                        <td class="tableTitleLine" nowrap="nowrap">
                            �ӿ�����
                        </td>
                        <td class="tableTitleLine" nowrap="nowrap">
                            ��������
                        </td>
                        <td class="tableTitleLine" nowrap="nowrap">
                            �Ƿ�ɹ�
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
            <!-- ���һ�� end-->
            <div name="page_down" class="page_down">
                    <div align="right">
                            <jsp:include page="/common/paginationFooter.jsp"/>
                    </div>

            </div>
        </div>
        <!-- ��ѯ��� end -->
        <!-- button -->
        <div name="button" class="content_button">
            <%--<input type="button" class="commonButton2" value="��������" onclick="exportNoBind();"/>--%>
            <%--<input type="button" class="commonButton2" value="����ͣ��" onclick="IPTVStop();"/>--%>
        </div>
    </div>

</html:form>
</body>
<script type="text/javascript">
    //����excle
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
