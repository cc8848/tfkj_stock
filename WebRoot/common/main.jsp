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
<title>天房科技工单系统</title>
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
			<a href="logout.do?act=logout" style="margin-right: 10px;font-size: 13px;font-weight: bold;">用户注销</a>
			<a href="password.do?act=init" target="content" style="margin-right: 10px;font-size: 13px;font-weight: bold;">密码修改</a>
			<a href="main.do?act=back" target="content" style="margin-right: 10px;font-size: 13px;font-weight: bold;">返回首页</a>
		</div>
		<div style="z-index:11;position: absolute; top:94px; left:0%; width: 100%; color: #E8EEF3 ;border-bottom: #aaa 1px solid">
			<ul class="menu" id="menu" style="left:0%; width: 100%; ">
				<!-- 区域负责人 -->
				<logic:equal name="loginUser" property="roleCode" value="1">

					<li>
						<a class="menulink" target="content">工单管理</a>
						<ul>
							<li>
								<a href="paigongdanList.do?act=init" target="content">派工单管理</a>
							</li>
							<li>
								<a href="tongjiList.do?act=init" target="content">出工单管理</a>
							</li>
							<li>
								<a href="qujianList.do?act=init" target="content">收件管理</a>
							</li>
						</ul>
					</li>


					<li>
						<a href="chugongdanHistoryList.do?act=init" class="menulink" target="content">出工单历史</a>
					</li>
					<li>
						<a href="qujianHistoryList.do?act=init" class="menulink" target="content">收件历史</a>
					</li>
					<li>
						<a href="yuyueList.do?act=init" class="menulink" target="content">预约计划</a>
					</li>
					<li>
						<a href="yuyuequeryList.do?act=init" class="menulink" target="content">预约查询</a>
					</li>

					<li>
						<a href="selectTelNumberList.do?act=init" class="menulink" target="content">电话选号</a>
					</li>
					<li>
						<a class="menulink" target="content">设备库存</a>
						<ul>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">小区设备管理</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">异常设备库</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">续费管理</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">申请续费</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">维修提交</a>
							</li>
							<li>
								<a href="operateList.do?act=init" target="content">申请密码修改/退订</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">回单管理</a>
						<ul>
							<li>
								<a href="huidansubList.do?act=init" target="content">回单提交</a>
							</li>
							<li>
								<a href="photouploadList.do?act=init" target="content">照片上传</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">用户数据</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">数据精确查询</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">统计查询</a>
						<ul>
							<li>
								<a href="totalList.do?act=init" target="content">户数统计</a>
							</li>
							<li>
								<a href="shoufeitotalList.do?act=init" target="content">收费统计</a>
							</li>
							<li>
								<a href="haocaitotalList.do?act=init" target="content">耗材统计</a>
							</li>
							<li>
								<a href="shigongrenList.do?act=init" target="content">施工人统计</a>
							</li>
							<li>
								<a href="gongzuoliangList.do?act=init" target="content">工作量统计</a>
							</li>
							<li>
								<a href="serchSheQuJineList.do?act=init" target="content">社区金额统计</a>
							</li>
							<li>
								<a href="serchYunYingShangList.do?act=init" target="content">运营商统计</a>
							</li>
							<li>
								<a href="mingxitotalList.do?act=init" target="content">日报统计</a>
							</li>
							<li>
								<a href="xufeilv.do?act=init" target="content">续费率统计</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">财务核对</a>
						<ul>
							<li>
								<a href="moneymateList.do?act=init&zhuangtai=0" target="content">存款金额匹配</a>
							</li>
						</ul>
					</li>
				</logic:equal>
				<!-- 数据核对 -->
				<logic:equal name="loginUser" property="roleCode" value="7">
					<li>
						<a class="menulink" target="content">工单管理</a>
						<ul>
							<li>
								<a href="paigongdanList.do?act=init" target="content">派工单管理</a>
							</li>
							<li>
								<a href="tongjiList.do?act=init" target="content">出工单管理</a>
							</li>
							<li>
								<a href="qujianList.do?act=init" target="content">收件管理</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="chugongdanHistoryList.do?act=init" class="menulink" target="content">出工单历史</a>
					</li>
					<li>
						<a href="qujianHistoryList.do?act=init" class="menulink" target="content">收件历史</a>
					</li>
					<li>
						<a href="yuyueList.do?act=init" class="menulink" target="content">预约计划</a>
					</li>
					<li>
						<a href="yuyuequeryList.do?act=init" class="menulink" target="content">预约查询</a>
					</li>

					<li>
						<a href="selectTelNumberList.do?act=init" class="menulink" target="content">电话选号</a>
					</li>
					<li>
						<a class="menulink" target="content">设备库存</a>
						<ul>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">小区设备管理</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">异常设备库</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">续费管理</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">申请续费</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">维修提交</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">回单管理</a>
						<ul>
							<li>
								<a href="huidansubList.do?act=init" target="content">回单提交</a>
							</li>
							<li>
								<a href="huidancheckedList.do?act=init" target="content">工单核对</a>
							</li>
							<li>
								<a href="huidanreviewList.do?act=init" target="content">工单复查</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">用户数据</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">数据精确查询</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">财务核对</a>
						<ul>
							<li>
								<a href="moneymateList.do?act=init&zhuangtai=0" target="content">存款金额匹配</a>
							</li>
						</ul>
					</li>
				</logic:equal>

				<!-- kefu -->
				<logic:equal name="loginUser" property="roleCode" value="2">
					<li>
						<a href="paigongdanList.do?act=init" class="menulink" target="content">派工单管理</a>
					</li>
					<li>
						<a href="tongjiList.do?act=init" class="menulink" target="content">出工单管理</a>
					</li>
					<li>
						<a href="selectTelNumberList.do?act=init" class="menulink" target="content">电话选号</a>
					</li>
					<li>
						<a href="yuyuequeryList.do?act=init" class="menulink" target="content">预约查询</a>
					</li>
					<li>
						<a class="menulink" target="content">续费管理</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">申请续费</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">维修提交</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">用户数据</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">数据精确查询</a>
							</li>
						</ul>
					</li>
				</logic:equal>


				<!-- 现场施工人员 -->
				<logic:equal name="loginUser" property="roleCode" value="3">
					<li>
						<a href="tongjiList.do?act=init" class="menulink" target="content">出工单管理</a>
					</li>
					<li>
						<a href="qujianList.do?act=init" class="menulink" target="content">收件管理</a>
					</li>
					<li>
						<a href="yuyueList.do?act=init" class="menulink" target="content">预约计划</a>
					</li>
					<li>
						<a href="yuyuequeryList.do?act=init" class="menulink" target="content">预约查询</a>
					</li>
					<li>
						<a class="menulink" target="content">设备库存</a>
						<ul>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">小区设备管理</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">异常设备库</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">续费管理</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">申请续费</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">维修提交</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">回单管理</a>
						<ul>
							<li>
								<a href="huidansubList.do?act=init" target="content">回单提交</a>
							</li>
							<li>
								<a href="photouploadList.do?act=init" target="content">照片上传</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">用户数据</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">数据精确查询</a>
							</li>
						</ul>
					</li>
				</logic:equal>

				<!-- 运维内勤人员 -->
				<logic:equal name="loginUser" property="roleCode" value="4">
					<li>
						<a href="tongjiList.do?act=init" class="menulink" target="content">出工单管理</a>
					</li>
					<li>
						<a href="qujianList.do?act=init" class="menulink" target="content">收件管理</a>
					</li>
					<li>
						<a href="yuyueList.do?act=init" class="menulink" target="content">预约计划</a>
					</li>
					<li>
						<a href="yuyuequeryList.do?act=init" class="menulink" target="content">预约查询</a>
					</li>
					<li>
						<a href="chugongdanHistoryList.do?act=init" class="menulink" target="content">出工单历史</a>
					</li>
					<li>
						<a href="qujianHistoryList.do?act=init" class="menulink" target="content">收件历史</a>
					</li>
					<li>
						<a class="menulink" target="content">设备库存</a>
						<ul>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">小区设备管理</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">异常设备库</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">续费管理</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">申请续费</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">维修提交</a>
							</li>
							<li>
								<a href="operateList.do?act=init" target="content">申请密码修改/退订</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">回单管理</a>
						<ul>
							<li>
								<a href="huidansubList.do?act=init" target="content">回单提交</a>
							</li>
							<li>
								<a href="photouploadList.do?act=init" target="content">照片上传</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">用户数据</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">数据精确查询</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">财务核对</a>
						<ul>
							<li>
								<a href="moneymateList.do?act=init&zhuangtai=0" target="content">存款金额匹配</a>
							</li>
						</ul>
					</li>
				</logic:equal>

				<!-- 财务核对人员 -->
				<logic:equal name="loginUser" property="roleCode" value="6">

					<li>
						<a class="menulink" target="content">用户数据</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">数据精确查询</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">财务核对</a>
						<ul>
							<li>
								<a href="financingcheckList.do?act=init&zhuangtai=1" target="content">存款财务核对</a>
							</li>
							<li>
								<a href="reportformsList.do?act=init&zhuangtai=2" target="content">财务报表</a>
							</li>
							<li>
								<a href="historyList.do?act=init&zhuangtai=3" target="content">历史账目</a>
							</li>
						</ul>
					</li>
				</logic:equal>


				<!-- 超级管理员 所有权限 -->
				<logic:equal name="loginUser" property="roleCode" value="5">

					<li>
						<a class="menulink" target="content">系统维护</a>
						<ul>
							<li>
								<a href="employeeList.do?act=init" target="content">用户管理</a>
							</li>
							<li>
								<a href="shichangList.do?act=init" target="content">宽带维护</a>
							</li>
							<li>
								<a href="dianshiList.do?act=init" target="content">IPTV维护</a>
							</li>
							<li>
								<a href="rediuslog.do?act=init" target="content">RADIUS接口日志</a>
							</li>
							<li>
								<a href="iptvlogList.do?act=init" target="content">IPTV接口日志</a>
							</li>
							<li>
								<a href="webServiceLog.do?act=init" target="content">电信接口日志</a>
							</li>
							<li>
								<a href="quyuweihuList.do?act=init" target="content">服务站维护</a>
							</li>
							<li>
								<a href="xiaoquList.do?act=init" target="content">小区维护</a>
							</li>
							<li>
								<a href="fenguangguizeList.do?act=init" target="content">分光分配规则</a>
							</li>
							<li>
								<a href="kefenpeifenguangList.do?act=init&mask=0" target="content">可分配方分光</a>
							</li>
							<li>
								<a href="kefenpeifenguangList.do?act=init&mask=1" target="content">已分配分光</a>
							</li>
						</ul>

					</li>
					<li>
						<a class="menulink" target="content">工单管理</a>
						<ul>
							<li>
								<a href="paigongdanList.do?act=init" target="content">派工单管理</a>
							</li>
							<li>
								<a href="tongjiList.do?act=init" target="content">出工单管理</a>
							</li>
							<li>
								<a href="qujianList.do?act=init" target="content">收件管理</a>
							</li>
							<li>
								<a href="huidanPreImportList.do?act=init" target="content">回单预导入</a>
							</li>
							<li>
								<a href="huidanPreImportHistoryList.do?act=init" target="content">预导入历史</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">历史信息</a>
						<ul>
							<li>
								<a href="chugongdanHistoryList.do?act=init" target="content">出工单历史</a>
							</li>
							<li>
								<a href="qujianHistoryList.do?act=init" target="content">收件历史</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">预约管理</a>
						<ul>
							<li>
								<a href="yuyueList.do?act=init" target="content">预约计划</a>
							</li>
							<li>
								<a href="yuyuequeryList.do?act=init" target="content">预约查询</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">电话选号</a>
						<ul>
							<li>
								<a href="telNumberList.do?act=init" target="content">电话导入</a>
							</li>
							<li>
								<a href="selectTelNumberList.do?act=init" target="content">电话选号</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">设备库存</a>
						<ul>
							<li>
								<a href="shebeirukuList.do?act=init" target="content">设备导入分配</a>
							</li>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">小区设备管理</a>
							</li>
							<li>
								<a href="shebeianzhuangkuList.do?act=init" target="content">已安装设备管理</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">异常设备库</a>
							</li>
							<li>
								<a href="zongkufangInfoList.do?act=init" target="content">总库房信息</a>
							</li>
							<li>
								<a href="zongkufangLogList.do?act=init" target="content">总库房日志</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">续费维修管理</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">申请续费</a>
							</li>
							<li>
								<a href="chulidaijiaofeiDataList.do?act=init" target="content">处理续费</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">维修提交</a>
							</li>
							<li>
								<a href="chulidaiweixiuDataList.do?act=init" target="content">处理维修</a>
							</li>
							<li>
								<a href="operateList.do?act=init" target="content">申请密码修改/退订</a>
							</li>
							<li>
								<a href="dealOperateList.do?act=init" target="content">处理密码修改/退订</a>
							</li>
							<!-- <li><a href="weixiujiaofeiLogList.do?act=init"  target="content">维修/续费删除记录</a></li> -->
						</ul>
					</li>

					<li>
						<a class="menulink" target="content">回单管理</a>
						<ul>
							<li>
								<a href="huidandaoruList.do?act=init" target="content">回单导入</a>
							</li>
							<li>
								<a href="huidansubList.do?act=init" target="content">回单提交</a>
							</li>
							<li>
								<a href="huidanerrorList.do?act=init" target="content">回单纠错</a>
							</li>
							<li>
								<a href="huidancheckList.do?act=init" target="content">数据设备核对</a>
							</li>
							<li>
								<a href="huidancheckedList.do?act=init" target="content">工单核对</a>
							</li>
							<li>
								<a href="huidanreviewList.do?act=init" target="content">工单复查</a>
							</li>
							<li>
								<a href="huidanauditList.do?act=init" target="content">移机审核</a>
							</li>
							<li>
								<a href="qiegaiauditList.do?act=init" target="content">线路切改审核</a>
							</li>
							<li>
								<a href="photouploadList.do?act=init" target="content">照片上传</a>
							</li>
							<li>
								<a href="photoauditList.do?act=init" target="content">照片审核</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">用户数据</a>
						<ul>
							<li>
								<a href="yonghuDataList.do?act=init" target="content">数据管理</a>
							</li>
							<li>
								<a href="weixiuDataList.do?act=init" target="content">维修管理</a>
							</li>
							<!-- <li><a href="jiaofeiTXList.do?act=init" target="content">缴费管理</a></li> -->
							<li>
								<a href="xiugaiShujuLogList.do?act=init" target="content">修改记录查询</a>
							</li>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">数据精确查询</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">统计查询</a>
						<ul>
							<li>
								<a href="totalList.do?act=init" target="content">户数统计</a>
							</li>
							<li>
								<a href="shoufeitotalList.do?act=init" target="content">收费统计</a>
							</li>
							<li>
								<a href="haocaitotalList.do?act=init" target="content">耗材统计</a>
							</li>
							<li>
								<a href="shigongrenList.do?act=init" target="content">施工人统计</a>
							</li>
							<li>
								<a href="gongzuoliangList.do?act=init" target="content">工作量统计</a>
							</li>
							<li>
								<a href="serchSheQuJineList.do?act=init" target="content">社区金额统计</a>
							</li>
							<li>
								<a href="serchYunYingShangList.do?act=init" target="content">运营商统计</a>
							</li>
							<li>
								<a href="mingxitotalList.do?act=init" target="content">日报统计</a>
							</li>
							<li>
								<a href="xufeilv.do?act=init" target="content">续费率统计</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">财务核对</a>
						<ul>
							<li>
								<a href="moneymateList.do?act=init&zhuangtai=0" target="content">存款金额匹配</a>
							</li>
							<li>
								<a href="financingcheckList.do?act=init&zhuangtai=1" target="content">存款财务核对</a>
							</li>
							<li>
								<a href="reportformsList.do?act=init&zhuangtai=2" target="content">财务报表</a>
							</li>
							<li>
								<a href="historyList.do?act=init&zhuangtai=3" target="content">历史账目</a>
							</li>
						</ul>
					</li>

				</logic:equal>


				<!-- 数据管理 -->
				<logic:equal name="loginUser" property="roleCode" value="8">

					<li>
						<a class="menulink" target="content">系统维护</a>
						<ul>
							<li>
								<a href="shichangList.do?act=init" target="content">时长维护</a>
							</li>
							<li>
								<a href="quyuweihuList.do?act=init" target="content">区域维护</a>
							</li>
							<li>
								<a href="xiaoquList.do?act=init" target="content">小区维护</a>
							</li>
							<li>
								<a href="rediuslog.do?act=init" target="content">RADIUS接口日志</a>
							</li>
							<li>
								<a href="iptvlogList.do?act=init" target="content">IPTV接口日志</a>
							</li>
							<li>
								<a href="webServiceLog.do?act=init" target="content">电信接口日志</a>
							</li>
							<li>
								<a href="fenguangguizeList.do?act=init" target="content">分光分配规则</a>
							</li>
							<li>
								<a href="kefenpeifenguangList.do?act=init&mask=0" target="content">可分配方分光</a>
							</li>
							<li>
								<a href="kefenpeifenguangList.do?act=init&mask=1" target="content">已分配分光</a>
							</li>
						</ul>

					</li>
					<li>
						<a class="menulink" target="content">工单管理</a>
						<ul>
							<li>
								<a href="paigongdanList.do?act=init" target="content">派工单管理</a>
							</li>
							<li>
								<a href="tongjiList.do?act=init" target="content">出工单管理</a>
							</li>
							<li>
								<a href="qujianList.do?act=init" target="content">收件管理</a>
							</li>
							<li>
								<a href="huidanPreImportList.do?act=init" target="content">回单预导入</a>
							</li>
							<li>
								<a href="huidanPreImportHistoryList.do?act=init" target="content">预导入历史</a>
							</li>
						</ul>
					</li>

					<li>
						<a class="menulink" target="content">历史信息</a>
						<ul>
							<li>
								<a href="chugongdanHistoryList.do?act=init" target="content">出工单历史</a>
							</li>
							<li>
								<a href="qujianHistoryList.do?act=init" target="content">收件历史</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">预约管理</a>
						<ul>
							<li>
								<a href="yuyueList.do?act=init" target="content">预约计划</a>
							</li>
							<li>
								<a href="yuyuequeryList.do?act=init" target="content">预约查询</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">电话选号</a>
						<ul>
							<li>
								<a href="telNumberList.do?act=init" target="content">电话导入</a>
							</li>
							<li>
								<a href="selectTelNumberList.do?act=init" target="content">电话选号</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">设备库存</a>
						<ul>
							<li>
								<a href="shebeirukuList.do?act=init" target="content">设备导入分配</a>
							</li>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">小区设备管理</a>
							</li>
							<li>
								<a href="shebeianzhuangkuList.do?act=init" target="content">已安装设备管理</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">异常设备库</a>
							</li>
							<li>
								<a href="zongkufangInfoList.do?act=init" target="content">总库房信息</a>
							</li>
							<li>
								<a href="zongkufangLogList.do?act=init" target="content">总库房日志</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">续费维修管理</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">申请续费</a>
							</li>
							<li>
								<a href="chulidaijiaofeiDataList.do?act=init" target="content">处理续费</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">维修提交</a>
							</li>
							<li>
								<a href="chulidaiweixiuDataList.do?act=init" target="content">处理维修</a>
							</li>
							<li>
								<a href="operateList.do?act=init" target="content">申请密码修改/退订</a>
							</li>
							<li>
								<a href="dealOperateList.do?act=init" target="content">处理密码修改/退订</a>
							</li>
							<!-- <li><a href="weixiujiaofeiLogList.do?act=init"  target="content">维修/续费删除记录</a></li> -->
						</ul>
					</li>

					<li>
						<a class="menulink" target="content">回单管理</a>
						<ul>
							<li>
								<a href="huidandaoruList.do?act=init" target="content">回单导入</a>
							</li>
							<li>
								<a href="huidansubList.do?act=init" target="content">回单提交</a>
							</li>
							<li>
								<a href="huidanerrorList.do?act=init" target="content">回单纠错</a>
							</li>
							<li>
								<a href="huidancheckList.do?act=init" target="content">数据设备核对</a>
							</li>
							<li>
								<a href="huidancheckedList.do?act=init" target="content">工单核对</a>
							</li>
							<li>
								<a href="huidanreviewList.do?act=init" target="content">工单复查</a>
							</li>
							<li>
								<a href="photouploadList.do?act=init" target="content">照片上传</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">用户数据</a>
						<ul>
							<li>
								<a href="yonghuDataList.do?act=init" target="content">数据管理</a>
							</li>
							<li>
								<a href="weixiuDataList.do?act=init" target="content">维修管理</a>
							</li>
							<!-- <li><a href="jiaofeiTXList.do?act=init" target="content">缴费管理</a></li> -->
							<li>
								<a href="xiugaiShujuLogList.do?act=init" target="content">修改记录查询</a>
							</li>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">数据精确查询</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">统计查询</a>
						<ul>
							<li>
								<a href="totalList.do?act=init" target="content">户数统计</a>
							</li>
							<li>
								<a href="shoufeitotalList.do?act=init" target="content">收费统计</a>
							</li>
							<li>
								<a href="haocaitotalList.do?act=init" target="content">耗材统计</a>
							</li>
							<li>
								<a href="shigongrenList.do?act=init" target="content">施工人统计</a>
							</li>
							<li>
								<a href="gongzuoliangList.do?act=init" target="content">工作量统计</a>
							</li>
							<li>
								<a href="mingxitotalList.do?act=init" target="content">日报统计</a>
							</li>
							<li>
								<a href="xufeilv.do?act=init" target="content">续费率统计</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">财务核对</a>
						<ul>
							<li>
								<a href="moneymateList.do?act=init&zhuangtai=0" target="content">存款金额匹配</a>
							</li>
							<li>
								<a href="financingcheckList.do?act=init&zhuangtai=1" target="content">存款财务核对</a>
							</li>
							<li>
								<a href="reportformsList.do?act=init&zhuangtai=2" target="content">财务报表</a>
							</li>
							<li>
								<a href="historyList.do?act=init&zhuangtai=3" target="content">历史账目</a>
							</li>
						</ul>
					</li>

				</logic:equal>


				<!-- 社区人员 -->
				<logic:equal name="loginUser" property="roleCode" value="9">
					<li>
						<a class="menulink" target="content">统计查询</a>
						<ul>
							<li>
								<a href="serchSheQuJineList.do?act=init" target="content">社区金额统计</a>
							</li>
							<li>
								<a href="serchYunYingShangList.do?act=init" target="content">运营商统计</a>
							</li>
						</ul>
					</li>
				</logic:equal>



				<!-- 库管专员10 -->
				<logic:equal name="loginUser" property="roleCode" value="10">
					<li>
						<a class="menulink" target="content">工单管理</a>
						<ul>
							<li>
								<a href="paigongdanList.do?act=init" target="content">派工单管理</a>
							</li>
							<li>
								<a href="tongjiList.do?act=init" target="content">出工单管理</a>
							</li>
							<li>
								<a href="qujianList.do?act=init" target="content">收件管理</a>
							</li>
						</ul>
					</li>


					<li>
						<a href="chugongdanHistoryList.do?act=init" class="menulink" target="content">出工单历史</a>
					</li>
					<li>
						<a href="qujianHistoryList.do?act=init" class="menulink" target="content">收件历史</a>
					</li>
					<li>
						<a href="yuyueList.do?act=init" class="menulink" target="content">预约计划</a>
					</li>
					<li>
						<a href="yuyuequeryList.do?act=init" class="menulink" target="content">预约查询</a>
					</li>

					<li>
						<a href="selectTelNumberList.do?act=init" class="menulink" target="content">电话选号</a>
					</li>
					<li>
						<a class="menulink" target="content">设备库存</a>
						<ul>
							<li>
								<a href="shebeichukuList.do?act=init" target="content">小区设备管理</a>
							</li>
							<li>
								<a href="shebeiyichangkuList.do?act=init" target="content">异常设备库</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">续费管理</a>
						<ul>
							<li>
								<a href="daijiaofeiDataList.do?act=init" target="content">申请续费</a>
							</li>
							<li>
								<a href="daiweixiuDataList.do?act=init" target="content">维修提交</a>
							</li>
							<li>
								<a href="operateList.do?act=init" target="content">申请密码修改/退订</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">回单管理</a>
						<ul>
							<li>
								<a href="huidansubList.do?act=init" target="content">回单提交</a>
							</li>
							<li>
								<a href="photouploadList.do?act=init" target="content">照片上传</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">用户数据</a>
						<ul>
							<li>
								<a href="yonghuDataYunweiList.do?act=init" target="content">数据精确查询</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">统计查询</a>
						<ul>
							<li>
								<a href="totalList.do?act=init" target="content">户数统计</a>
							</li>
							<li>
								<a href="shoufeitotalList.do?act=init" target="content">收费统计</a>
							</li>
							<li>
								<a href="haocaitotalList.do?act=init" target="content">耗材统计</a>
							</li>
							<li>
								<a href="shigongrenList.do?act=init" target="content">施工人统计</a>
							</li>
							<li>
								<a href="gongzuoliangList.do?act=init" target="content">工作量统计</a>
							</li>
							<li>
								<a href="serchSheQuJineList.do?act=init" target="content">社区金额统计</a>
							</li>
							<li>
								<a href="serchYunYingShangList.do?act=init" target="content">运营商统计</a>
							</li>
							<li>
								<a href="mingxitotalList.do?act=init" target="content">日报统计</a>
							</li>
							<li>
								<a href="xufeilv.do?act=init" target="content">续费率统计</a>
							</li>
						</ul>
					</li>
					<li>
						<a class="menulink" target="content">财务核对</a>
						<ul>
							<li>
								<a href="moneymateList.do?act=init&zhuangtai=0" target="content">存款金额匹配</a>
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
						登录用户编号：
						<bean:write name="footContent" property="employeeCode" />
						&nbsp;&nbsp; 登录用户姓名：
						<bean:write name="footContent" property="employeeName" />
						&nbsp;&nbsp; 当前在线人数：
						<span><%=usercount %>人
						</span>
					</td>
				</tr>
			</table>
		</div>



	</form>
	</div>
</body>
</html>