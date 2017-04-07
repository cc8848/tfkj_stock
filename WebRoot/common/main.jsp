<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/aceeci.tld" prefix="a"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    int usercount = com.stock.userCount.OnlineCounter.getOnlineCount();
%>
<bean:define id="footContent" name="com.takucin.aceeci.main.MAIN_INFO"></bean:define>
<bean:define id="loginUser" name="com.takucin.aceeci.user.LOGIN_USER"></bean:define>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<a:base />
<title>�췿�Ƽ�����ϵͳ</title>
<link rel="Shortcut Icon" href="favicon.ico" />
<link href="css/common.css" type="text/css" rel="stylesheet" />
<link href="css/menu.css" type="text/css" rel="stylesheet" />
<script src="js/menu.js" language="javascript"></script>
</head>
<body id="top" style="background-color: #fff">
	<div style="text-align: center;left:0%; width: 100%; "  align="center";  >
	<form action="main.do" >
		<html:hidden name="footContent" property="employeeCode" />
		<html:hidden name="footContent" property="employeeName" />
		<html:hidden name="footContent" property="departmentCode" />
		<html:hidden name="footContent" property="departmentName" />
		
		<div style="text-align: right;margin-right: 40px;margin-top: 10px">
			<a href="logout.do?act=logout" style="margin-right: 10px;font-size: 13px;font-weight: bold;">�û�ע��</a>
			<a href="password.do?act=init" target="content" style="margin-right: 10px;font-size: 13px;font-weight: bold;">�����޸�</a>
			<a href="main.do?act=back" target="content" style="margin-right: 10px;font-size: 13px;font-weight: bold;">������ҳ</a>
		</div>
		<div style="z-index:11;position: absolute; top:94px; left:0%; width: 100%; color: #E8EEF3 ;border-bottom: #aaa 1px solid">
			<ul class="menu" id="menu" style="left:0%; width: 100%; ">
				<!-- �������� -->
				<logic:equal name="loginUser" property="roleCode" value="1">

					<li>
						<a class="menulink" target="content">��������</a>
						<ul>
							<li>
								<a href="paigongdanList.do?act=init" target="content">�ɹ�������</a>
							</li>
							<li>
								<a href="tongjiList.do?act=init" target="content">����������</a>
							</li>
							<li>
								<a href="qujianList.do?act=init" target="content">�ռ�����</a>
							</li>
						</ul>
					</li>


					<li>
						<a href="chugongdanHistoryList.do?act=init" class="menulink" target="content">��������ʷ</a>
					</li>
					<li>
						<a href="qujianHistoryList.do?act=init" class="menulink" target="content">�ռ���ʷ</a>
					</li>
					<li>
						<a href="yuyueList.do?act=init" class="menulink" target="content">ԤԼ�ƻ�</a>
					</li>
					<li>
						<a href="yuyuequeryList.do?act=init" class="menulink" target="content">ԤԼ��ѯ</a>
					</li>

					<li>
						<a href="selectTelNumberList.do?act=init" class="menulink" target="content">�绰ѡ��</a>
					</li>
					<li>
						<a class="menulink" target="content">�豸���</a>
						<ul>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">С���豸����</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">�쳣�豸��</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">���ѹ���</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">��������</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">ά���ύ</a>
							</li>
							<li>
								<a href="operateList.do?act=init" target="content">���������޸�/�˶�</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�ص�����</a>
						<ul>
							<li>
								<a href="huidansubList.do?act=init" target="content">�ص��ύ</a>
							</li>
							<li>
								<a href="photouploadList.do?act=init" target="content">��Ƭ�ϴ�</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�û�����</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">���ݾ�ȷ��ѯ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">ͳ�Ʋ�ѯ</a>
						<ul>
							<li>
								<a href="totalList.do?act=init" target="content">����ͳ��</a>
							</li>
							<li>
								<a href="shoufeitotalList.do?act=init" target="content">�շ�ͳ��</a>
							</li>
							<li>
								<a href="haocaitotalList.do?act=init" target="content">�Ĳ�ͳ��</a>
							</li>
							<li>
								<a href="shigongrenList.do?act=init" target="content">ʩ����ͳ��</a>
							</li>
							<li>
								<a href="gongzuoliangList.do?act=init" target="content">������ͳ��</a>
							</li>
							<li>
								<a href="serchSheQuJineList.do?act=init" target="content">�������ͳ��</a>
							</li>
							<li>
								<a href="serchYunYingShangList.do?act=init" target="content">��Ӫ��ͳ��</a>
							</li>
							<li>
								<a href="mingxitotalList.do?act=init" target="content">�ձ�ͳ��</a>
							</li>
							<li>
								<a href="xufeilv.do?act=init" target="content">������ͳ��</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">����˶�</a>
						<ul>
							<li>
								<a href="moneymateList.do?act=init&zhuangtai=0" target="content">�����ƥ��</a>
							</li>
						</ul>
					</li>
				</logic:equal>
				<!-- ���ݺ˶� -->
				<logic:equal name="loginUser" property="roleCode" value="7">
					<li>
						<a class="menulink" target="content">��������</a>
						<ul>
							<li>
								<a href="paigongdanList.do?act=init" target="content">�ɹ�������</a>
							</li>
							<li>
								<a href="tongjiList.do?act=init" target="content">����������</a>
							</li>
							<li>
								<a href="qujianList.do?act=init" target="content">�ռ�����</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="chugongdanHistoryList.do?act=init" class="menulink" target="content">��������ʷ</a>
					</li>
					<li>
						<a href="qujianHistoryList.do?act=init" class="menulink" target="content">�ռ���ʷ</a>
					</li>
					<li>
						<a href="yuyueList.do?act=init" class="menulink" target="content">ԤԼ�ƻ�</a>
					</li>
					<li>
						<a href="yuyuequeryList.do?act=init" class="menulink" target="content">ԤԼ��ѯ</a>
					</li>

					<li>
						<a href="selectTelNumberList.do?act=init" class="menulink" target="content">�绰ѡ��</a>
					</li>
					<li>
						<a class="menulink" target="content">�豸���</a>
						<ul>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">С���豸����</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">�쳣�豸��</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">���ѹ���</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">��������</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">ά���ύ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�ص�����</a>
						<ul>
							<li>
								<a href="huidansubList.do?act=init" target="content">�ص��ύ</a>
							</li>
							<li>
								<a href="huidancheckedList.do?act=init" target="content">�����˶�</a>
							</li>
							<li>
								<a href="huidanreviewList.do?act=init" target="content">��������</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�û�����</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">���ݾ�ȷ��ѯ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">����˶�</a>
						<ul>
							<li>
								<a href="moneymateList.do?act=init&zhuangtai=0" target="content">�����ƥ��</a>
							</li>
						</ul>
					</li>
				</logic:equal>

				<!-- kefu -->
				<logic:equal name="loginUser" property="roleCode" value="2">
					<li>
						<a href="paigongdanList.do?act=init" class="menulink" target="content">�ɹ�������</a>
					</li>
					<li>
						<a href="tongjiList.do?act=init" class="menulink" target="content">����������</a>
					</li>
					<li>
						<a href="selectTelNumberList.do?act=init" class="menulink" target="content">�绰ѡ��</a>
					</li>
					<li>
						<a href="yuyuequeryList.do?act=init" class="menulink" target="content">ԤԼ��ѯ</a>
					</li>
					<li>
						<a class="menulink" target="content">���ѹ���</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">��������</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">ά���ύ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�û�����</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">���ݾ�ȷ��ѯ</a>
							</li>
						</ul>
					</li>
				</logic:equal>


				<!-- �ֳ�ʩ����Ա -->
				<logic:equal name="loginUser" property="roleCode" value="3">
					<li>
						<a href="tongjiList.do?act=init" class="menulink" target="content">����������</a>
					</li>
					<li>
						<a href="qujianList.do?act=init" class="menulink" target="content">�ռ�����</a>
					</li>
					<li>
						<a href="yuyueList.do?act=init" class="menulink" target="content">ԤԼ�ƻ�</a>
					</li>
					<li>
						<a href="yuyuequeryList.do?act=init" class="menulink" target="content">ԤԼ��ѯ</a>
					</li>
					<li>
						<a class="menulink" target="content">�豸���</a>
						<ul>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">С���豸����</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">�쳣�豸��</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">���ѹ���</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">��������</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">ά���ύ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�ص�����</a>
						<ul>
							<li>
								<a href="huidansubList.do?act=init" target="content">�ص��ύ</a>
							</li>
							<li>
								<a href="photouploadList.do?act=init" target="content">��Ƭ�ϴ�</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�û�����</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">���ݾ�ȷ��ѯ</a>
							</li>
						</ul>
					</li>
				</logic:equal>

				<!-- ��ά������Ա -->
				<logic:equal name="loginUser" property="roleCode" value="4">
					<li>
						<a href="tongjiList.do?act=init" class="menulink" target="content">����������</a>
					</li>
					<li>
						<a href="qujianList.do?act=init" class="menulink" target="content">�ռ�����</a>
					</li>
					<li>
						<a href="yuyueList.do?act=init" class="menulink" target="content">ԤԼ�ƻ�</a>
					</li>
					<li>
						<a href="yuyuequeryList.do?act=init" class="menulink" target="content">ԤԼ��ѯ</a>
					</li>
					<li>
						<a href="chugongdanHistoryList.do?act=init" class="menulink" target="content">��������ʷ</a>
					</li>
					<li>
						<a href="qujianHistoryList.do?act=init" class="menulink" target="content">�ռ���ʷ</a>
					</li>
					<li>
						<a class="menulink" target="content">�豸���</a>
						<ul>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">С���豸����</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">�쳣�豸��</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">���ѹ���</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">��������</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">ά���ύ</a>
							</li>
							<li>
								<a href="operateList.do?act=init" target="content">���������޸�/�˶�</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�ص�����</a>
						<ul>
							<li>
								<a href="huidansubList.do?act=init" target="content">�ص��ύ</a>
							</li>
							<li>
								<a href="photouploadList.do?act=init" target="content">��Ƭ�ϴ�</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�û�����</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">���ݾ�ȷ��ѯ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">����˶�</a>
						<ul>
							<li>
								<a href="moneymateList.do?act=init&zhuangtai=0" target="content">�����ƥ��</a>
							</li>
						</ul>
					</li>
				</logic:equal>

				<!-- ����˶���Ա -->
				<logic:equal name="loginUser" property="roleCode" value="6">

					<li>
						<a class="menulink" target="content">�û�����</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">���ݾ�ȷ��ѯ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">����˶�</a>
						<ul>
							<li>
								<a href="financingcheckList.do?act=init&zhuangtai=1" target="content">������˶�</a>
							</li>
							<li>
								<a href="reportformsList.do?act=init&zhuangtai=2" target="content">���񱨱�</a>
							</li>
							<li>
								<a href="historyList.do?act=init&zhuangtai=3" target="content">��ʷ��Ŀ</a>
							</li>
						</ul>
					</li>
				</logic:equal>


				<!-- ��������Ա ����Ȩ�� -->
				<logic:equal name="loginUser" property="roleCode" value="5">

					<li>
						<a class="menulink" target="content">ϵͳά��</a>
						<ul>
							<li>
								<a href="employeeList.do?act=init" target="content">�û�����</a>
							</li>
							<li>
								<a href="shichangList.do?act=init" target="content">���ά��</a>
							</li>
							<li>
								<a href="dianshiList.do?act=init" target="content">IPTVά��</a>
							</li>
							<li>
								<a href="rediuslog.do?act=init" target="content">RADIUS�ӿ���־</a>
							</li>
							<li>
								<a href="iptvlogList.do?act=init" target="content">IPTV�ӿ���־</a>
							</li>
							<li>
								<a href="webServiceLog.do?act=init" target="content">���Žӿ���־</a>
							</li>
							<li>
								<a href="quyuweihuList.do?act=init" target="content">����վά��</a>
							</li>
							<li>
								<a href="xiaoquList.do?act=init" target="content">С��ά��</a>
							</li>
							<li>
								<a href="fenguangguizeList.do?act=init" target="content">�ֹ�������</a>
							</li>
							<li>
								<a href="kefenpeifenguangList.do?act=init&mask=0" target="content">�ɷ��䷽�ֹ�</a>
							</li>
							<li>
								<a href="kefenpeifenguangList.do?act=init&mask=1" target="content">�ѷ���ֹ�</a>
							</li>
						</ul>

					</li>
					<li>
						<a class="menulink" target="content">��������</a>
						<ul>
							<li>
								<a href="paigongdanList.do?act=init" target="content">�ɹ�������</a>
							</li>
							<li>
								<a href="tongjiList.do?act=init" target="content">����������</a>
							</li>
							<li>
								<a href="qujianList.do?act=init" target="content">�ռ�����</a>
							</li>
							<li>
								<a href="huidanPreImportList.do?act=init" target="content">�ص�Ԥ����</a>
							</li>
							<li>
								<a href="huidanPreImportHistoryList.do?act=init" target="content">Ԥ������ʷ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">��ʷ��Ϣ</a>
						<ul>
							<li>
								<a href="chugongdanHistoryList.do?act=init" target="content">��������ʷ</a>
							</li>
							<li>
								<a href="qujianHistoryList.do?act=init" target="content">�ռ���ʷ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">ԤԼ����</a>
						<ul>
							<li>
								<a href="yuyueList.do?act=init" target="content">ԤԼ�ƻ�</a>
							</li>
							<li>
								<a href="yuyuequeryList.do?act=init" target="content">ԤԼ��ѯ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�绰ѡ��</a>
						<ul>
							<li>
								<a href="telNumberList.do?act=init" target="content">�绰����</a>
							</li>
							<li>
								<a href="selectTelNumberList.do?act=init" target="content">�绰ѡ��</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�豸���</a>
						<ul>
							<li>
								<a href="shebeirukuList.do?act=init" target="content">�豸�������</a>
							</li>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">С���豸����</a>
							</li>
							<li>
								<a href="shebeianzhuangkuList.do?act=init" target="content">�Ѱ�װ�豸����</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">�쳣�豸��</a>
							</li>
							<li>
								<a href="zongkufangInfoList.do?act=init" target="content">�ܿⷿ��Ϣ</a>
							</li>
							<li>
								<a href="zongkufangLogList.do?act=init" target="content">�ܿⷿ��־</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">����ά�޹���</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">��������</a>
							</li>
							<li>
								<a href="chulidaijiaofeiDataList.do?act=init" target="content">��������</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">ά���ύ</a>
							</li>
							<li>
								<a href="chulidaiweixiuDataList.do?act=init" target="content">����ά��</a>
							</li>
							<li>
								<a href="operateList.do?act=init" target="content">���������޸�/�˶�</a>
							</li>
							<li>
								<a href="dealOperateList.do?act=init" target="content">���������޸�/�˶�</a>
							</li>
							<!-- <li><a href="weixiujiaofeiLogList.do?act=init"  target="content">ά��/����ɾ����¼</a></li> -->
						</ul>
					</li>

					<li>
						<a class="menulink" target="content">�ص�����</a>
						<ul>
							<li>
								<a href="huidandaoruList.do?act=init" target="content">�ص�����</a>
							</li>
							<li>
								<a href="huidansubList.do?act=init" target="content">�ص��ύ</a>
							</li>
							<li>
								<a href="huidanerrorList.do?act=init" target="content">�ص�����</a>
							</li>
							<li>
								<a href="huidancheckList.do?act=init" target="content">�����豸�˶�</a>
							</li>
							<li>
								<a href="huidancheckedList.do?act=init" target="content">�����˶�</a>
							</li>
							<li>
								<a href="huidanreviewList.do?act=init" target="content">��������</a>
							</li>
							<li>
								<a href="huidanauditList.do?act=init" target="content">�ƻ����</a>
							</li>
							<li>
								<a href="qiegaiauditList.do?act=init" target="content">��·�и����</a>
							</li>
							<li>
								<a href="photouploadList.do?act=init" target="content">��Ƭ�ϴ�</a>
							</li>
							<li>
								<a href="photoauditList.do?act=init" target="content">��Ƭ���</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�û�����</a>
						<ul>
							<li>
								<a href="yonghuDataList.do?act=init" target="content">���ݹ���</a>
							</li>
							<li>
								<a href="weixiuDataList.do?act=init" target="content">ά�޹���</a>
							</li>
							<!-- <li><a href="jiaofeiTXList.do?act=init" target="content">�ɷѹ���</a></li> -->
							<li>
								<a href="xiugaiShujuLogList.do?act=init" target="content">�޸ļ�¼��ѯ</a>
							</li>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">���ݾ�ȷ��ѯ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">ͳ�Ʋ�ѯ</a>
						<ul>
							<li>
								<a href="totalList.do?act=init" target="content">����ͳ��</a>
							</li>
							<li>
								<a href="shoufeitotalList.do?act=init" target="content">�շ�ͳ��</a>
							</li>
							<li>
								<a href="haocaitotalList.do?act=init" target="content">�Ĳ�ͳ��</a>
							</li>
							<li>
								<a href="shigongrenList.do?act=init" target="content">ʩ����ͳ��</a>
							</li>
							<li>
								<a href="gongzuoliangList.do?act=init" target="content">������ͳ��</a>
							</li>
							<li>
								<a href="serchSheQuJineList.do?act=init" target="content">�������ͳ��</a>
							</li>
							<li>
								<a href="serchYunYingShangList.do?act=init" target="content">��Ӫ��ͳ��</a>
							</li>
							<li>
								<a href="mingxitotalList.do?act=init" target="content">�ձ�ͳ��</a>
							</li>
							<li>
								<a href="xufeilv.do?act=init" target="content">������ͳ��</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">����˶�</a>
						<ul>
							<li>
								<a href="moneymateList.do?act=init&zhuangtai=0" target="content">�����ƥ��</a>
							</li>
							<li>
								<a href="financingcheckList.do?act=init&zhuangtai=1" target="content">������˶�</a>
							</li>
							<li>
								<a href="reportformsList.do?act=init&zhuangtai=2" target="content">���񱨱�</a>
							</li>
							<li>
								<a href="historyList.do?act=init&zhuangtai=3" target="content">��ʷ��Ŀ</a>
							</li>
						</ul>
					</li>

				</logic:equal>


				<!-- ���ݹ��� -->
				<logic:equal name="loginUser" property="roleCode" value="8">

					<li>
						<a class="menulink" target="content">ϵͳά��</a>
						<ul>
							<li>
								<a href="shichangList.do?act=init" target="content">ʱ��ά��</a>
							</li>
							<li>
								<a href="quyuweihuList.do?act=init" target="content">����ά��</a>
							</li>
							<li>
								<a href="xiaoquList.do?act=init" target="content">С��ά��</a>
							</li>
							<li>
								<a href="rediuslog.do?act=init" target="content">RADIUS�ӿ���־</a>
							</li>
							<li>
								<a href="iptvlogList.do?act=init" target="content">IPTV�ӿ���־</a>
							</li>
							<li>
								<a href="webServiceLog.do?act=init" target="content">���Žӿ���־</a>
							</li>
							<li>
								<a href="fenguangguizeList.do?act=init" target="content">�ֹ�������</a>
							</li>
							<li>
								<a href="kefenpeifenguangList.do?act=init&mask=0" target="content">�ɷ��䷽�ֹ�</a>
							</li>
							<li>
								<a href="kefenpeifenguangList.do?act=init&mask=1" target="content">�ѷ���ֹ�</a>
							</li>
						</ul>

					</li>
					<li>
						<a class="menulink" target="content">��������</a>
						<ul>
							<li>
								<a href="paigongdanList.do?act=init" target="content">�ɹ�������</a>
							</li>
							<li>
								<a href="tongjiList.do?act=init" target="content">����������</a>
							</li>
							<li>
								<a href="qujianList.do?act=init" target="content">�ռ�����</a>
							</li>
							<li>
								<a href="huidanPreImportList.do?act=init" target="content">�ص�Ԥ����</a>
							</li>
							<li>
								<a href="huidanPreImportHistoryList.do?act=init" target="content">Ԥ������ʷ</a>
							</li>
						</ul>
					</li>

					<li>
						<a class="menulink" target="content">��ʷ��Ϣ</a>
						<ul>
							<li>
								<a href="chugongdanHistoryList.do?act=init" target="content">��������ʷ</a>
							</li>
							<li>
								<a href="qujianHistoryList.do?act=init" target="content">�ռ���ʷ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">ԤԼ����</a>
						<ul>
							<li>
								<a href="yuyueList.do?act=init" target="content">ԤԼ�ƻ�</a>
							</li>
							<li>
								<a href="yuyuequeryList.do?act=init" target="content">ԤԼ��ѯ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�绰ѡ��</a>
						<ul>
							<li>
								<a href="telNumberList.do?act=init" target="content">�绰����</a>
							</li>
							<li>
								<a href="selectTelNumberList.do?act=init" target="content">�绰ѡ��</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�豸���</a>
						<ul>
							<li>
								<a href="shebeirukuList.do?act=init" target="content">�豸�������</a>
							</li>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">С���豸����</a>
							</li>
							<li>
								<a href="shebeianzhuangkuList.do?act=init" target="content">�Ѱ�װ�豸����</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">�쳣�豸��</a>
							</li>
							<li>
								<a href="zongkufangInfoList.do?act=init" target="content">�ܿⷿ��Ϣ</a>
							</li>
							<li>
								<a href="zongkufangLogList.do?act=init" target="content">�ܿⷿ��־</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">����ά�޹���</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">��������</a>
							</li>
							<li>
								<a href="chulidaijiaofeiDataList.do?act=init" target="content">��������</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">ά���ύ</a>
							</li>
							<li>
								<a href="chulidaiweixiuDataList.do?act=init" target="content">����ά��</a>
							</li>
							<li>
								<a href="operateList.do?act=init" target="content">���������޸�/�˶�</a>
							</li>
							<li>
								<a href="dealOperateList.do?act=init" target="content">���������޸�/�˶�</a>
							</li>
							<!-- <li><a href="weixiujiaofeiLogList.do?act=init"  target="content">ά��/����ɾ����¼</a></li> -->
						</ul>
					</li>

					<li>
						<a class="menulink" target="content">�ص�����</a>
						<ul>
							<li>
								<a href="huidandaoruList.do?act=init" target="content">�ص�����</a>
							</li>
							<li>
								<a href="huidansubList.do?act=init" target="content">�ص��ύ</a>
							</li>
							<li>
								<a href="huidanerrorList.do?act=init" target="content">�ص�����</a>
							</li>
							<li>
								<a href="huidancheckList.do?act=init" target="content">�����豸�˶�</a>
							</li>
							<li>
								<a href="huidancheckedList.do?act=init" target="content">�����˶�</a>
							</li>
							<li>
								<a href="huidanreviewList.do?act=init" target="content">��������</a>
							</li>
							<li>
								<a href="photouploadList.do?act=init" target="content">��Ƭ�ϴ�</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�û�����</a>
						<ul>
							<li>
								<a href="yonghuDataList.do?act=init" target="content">���ݹ���</a>
							</li>
							<li>
								<a href="weixiuDataList.do?act=init" target="content">ά�޹���</a>
							</li>
							<!-- <li><a href="jiaofeiTXList.do?act=init" target="content">�ɷѹ���</a></li> -->
							<li>
								<a href="xiugaiShujuLogList.do?act=init" target="content">�޸ļ�¼��ѯ</a>
							</li>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">���ݾ�ȷ��ѯ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">ͳ�Ʋ�ѯ</a>
						<ul>
							<li>
								<a href="totalList.do?act=init" target="content">����ͳ��</a>
							</li>
							<li>
								<a href="shoufeitotalList.do?act=init" target="content">�շ�ͳ��</a>
							</li>
							<li>
								<a href="haocaitotalList.do?act=init" target="content">�Ĳ�ͳ��</a>
							</li>
							<li>
								<a href="shigongrenList.do?act=init" target="content">ʩ����ͳ��</a>
							</li>
							<li>
								<a href="gongzuoliangList.do?act=init" target="content">������ͳ��</a>
							</li>
							<li>
								<a href="mingxitotalList.do?act=init" target="content">�ձ�ͳ��</a>
							</li>
							<li>
								<a href="xufeilv.do?act=init" target="content">������ͳ��</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">����˶�</a>
						<ul>
							<li>
								<a href="moneymateList.do?act=init&zhuangtai=0" target="content">�����ƥ��</a>
							</li>
							<li>
								<a href="financingcheckList.do?act=init&zhuangtai=1" target="content">������˶�</a>
							</li>
							<li>
								<a href="reportformsList.do?act=init&zhuangtai=2" target="content">���񱨱�</a>
							</li>
							<li>
								<a href="historyList.do?act=init&zhuangtai=3" target="content">��ʷ��Ŀ</a>
							</li>
						</ul>
					</li>

				</logic:equal>


				<!-- ������Ա -->
				<logic:equal name="loginUser" property="roleCode" value="9">
					<li>
						<a class="menulink" target="content">ͳ�Ʋ�ѯ</a>
						<ul>
							<li>
								<a href="serchSheQuJineList.do?act=init" target="content">�������ͳ��</a>
							</li>
							<li>
								<a href="serchYunYingShangList.do?act=init" target="content">��Ӫ��ͳ��</a>
							</li>
						</ul>
					</li>
				</logic:equal>



				<!-- ���רԱ10 -->
				<logic:equal name="loginUser" property="roleCode" value="10">
					<li>
						<a class="menulink" target="content">��������</a>
						<ul>
							<li>
								<a href="paigongdanList.do?act=init" target="content">�ɹ�������</a>
							</li>
							<li>
								<a href="tongjiList.do?act=init" target="content">����������</a>
							</li>
							<li>
								<a href="qujianList.do?act=init" target="content">�ռ�����</a>
							</li>
						</ul>
					</li>


					<li>
						<a href="chugongdanHistoryList.do?act=init" class="menulink" target="content">��������ʷ</a>
					</li>
					<li>
						<a href="qujianHistoryList.do?act=init" class="menulink" target="content">�ռ���ʷ</a>
					</li>
					<li>
						<a href="yuyueList.do?act=init" class="menulink" target="content">ԤԼ�ƻ�</a>
					</li>
					<li>
						<a href="yuyuequeryList.do?act=init" class="menulink" target="content">ԤԼ��ѯ</a>
					</li>

					<li>
						<a href="selectTelNumberList.do?act=init" class="menulink" target="content">�绰ѡ��</a>
					</li>
					<li>
						<a class="menulink" target="content">�豸���</a>
						<ul>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">С���豸����</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">�쳣�豸��</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">���ѹ���</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">��������</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">ά���ύ</a>
							</li>
							<li>
								<a href="operateList.do?act=init" target="content">���������޸�/�˶�</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�ص�����</a>
						<ul>
							<li>
								<a href="huidansubList.do?act=init" target="content">�ص��ύ</a>
							</li>
							<li>
								<a href="photouploadList.do?act=init" target="content">��Ƭ�ϴ�</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">�û�����</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">���ݾ�ȷ��ѯ</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">ͳ�Ʋ�ѯ</a>
						<ul>
							<li>
								<a href="totalList.do?act=init" target="content">����ͳ��</a>
							</li>
							<li>
								<a href="shoufeitotalList.do?act=init" target="content">�շ�ͳ��</a>
							</li>
							<li>
								<a href="haocaitotalList.do?act=init" target="content">�Ĳ�ͳ��</a>
							</li>
							<li>
								<a href="shigongrenList.do?act=init" target="content">ʩ����ͳ��</a>
							</li>
							<li>
								<a href="gongzuoliangList.do?act=init" target="content">������ͳ��</a>
							</li>
							<li>
								<a href="serchSheQuJineList.do?act=init" target="content">�������ͳ��</a>
							</li>
							<li>
								<a href="serchYunYingShangList.do?act=init" target="content">��Ӫ��ͳ��</a>
							</li>
							<li>
								<a href="mingxitotalList.do?act=init" target="content">�ձ�ͳ��</a>
							</li>
							<li>
								<a href="xufeilv.do?act=init" target="content">������ͳ��</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">����˶�</a>
						<ul>
							<li>
								<a href="moneymateList.do?act=init&zhuangtai=0" target="content">�����ƥ��</a>
							</li>
						</ul>
					</li>
				</logic:equal>
			</ul>

			<script type="text/javascript">
				var menu=new menu.dd("menu");
				menu.init("menu","menuhover");
			</script>
		</div>
		<div style="z-index:9;position: absolute; top: 124px; left:0%; width: 100%; height: 650px;">
			<iframe name="content" height="650px" width="100%" src="common/welcome.jsp" frameborder="0" scrolling="no" noresize="noresize" id="mainFrame" title="mainFrame"></iframe>
		</div>
		<div style="z-index:10;position: absolute; top:660px; left:0%; width: 100%; height: 15px;">
			<table id="foot" width="100%">
				<tr>
					<td class="footerTitle">
						��¼�û���ţ�
						<bean:write name="footContent" property="employeeCode" />
						&nbsp;&nbsp; ��¼�û�������
						<bean:write name="footContent" property="employeeName" />
						&nbsp;&nbsp; ��ǰ����������
						<span><%=usercount %>��
						</span>
					</td>
				</tr>
			</table>
		</div>



	</form>
	</div>
</body>
</html>