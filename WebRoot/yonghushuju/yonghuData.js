//删除
function removeData() {
	if (checkSelect("UUID", "请选择待删除电话号码")) {
		confirmRemove();
	}
}
// 删除确认
function confirmRemove() {
	showConfirm('确定要删除选定的电话号码.', removeCallback);
}
// 删除操作
function removeCallback(v, m, f) {
	if (v) {
		document.forms[0].action = "telNumEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}

// 去除空格
String.prototype.trim = function() {
	return this.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
}

function checkInputForJiaofei() {
	var xiaoquname = document.forms[0].kaijishijian.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("开机时间不能为空");
		document.forms[0].kaijishijian.focus();// 设置焦点
		return false;
	}

	var xiaoquname = document.forms[0].tingjishijian.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("停机时间不能为空");
		document.forms[0].tingjishijian.focus();// 设置焦点
		return false;
	}
	
	return true;
}

function checkInput() {
	var username = document.forms[0].xingming.value;
	
	if (username == null || trim(username) == "") {
		alert("用户姓名不能为空！");
		document.forms[0].xingming.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].xiaoqu.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("用户小区不能为空！");
		document.forms[0].xiaoqu.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].dizhi.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("用户地址不能为空！");
		document.forms[0].dizhi.focus();// 设置焦点
		return false;
	}
//	if (!ismenhao(xiaoquname)) {
//		alert("请输入正确的地址格式！");
//		// document.getElementById("userplace").focus();
//		document.forms[0].dizhi.focus();
//		return false;
//	}
	var lianxidianhua = document.forms[0].lianxidianhua.value;
	if (lianxidianhua == null || trim(lianxidianhua) == "") {
		alert("用户联系电话不能为空！");
		document.forms[0].lianxidianhua.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].shenfensheng.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("用户身份证号不能为空！");
		document.forms[0].shenfensheng.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].shoujuhao.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("收据号不能为空！");
		document.forms[0].shoujuhao.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].fenguangxianhao.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("分光线号不能为空！");
		document.forms[0].fenguangxianhao.focus();// 设置焦点
		return false;
	}

	var xiaoquname = document.forms[0].jiexuweizhi.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("接续位置不能为空！");
		document.forms[0].jiexuweizhi.focus();// 设置焦点
		return false;
	}

	var xiaoquname = document.forms[0].kaijishijian.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("开机时间不能为空");
		document.forms[0].kaijishijian.focus();// 设置焦点
		return false;
	}

	var xiaoquname = document.forms[0].tingjishijian.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("停机时间不能为空");
		document.forms[0].tingjishijian.focus();// 设置焦点
		return false;
	}
	
	var youxiaoshijian = document.forms[0].youxiaoshijian.value;
	if (youxiaoshijian == null || trim(youxiaoshijian) == "") {
		alert("有效时间不能为空");
		document.forms[0].youxiaoshijian.focus();// 设置焦点
		return false;
	}
	
	var shoukuanshijian = document.forms[0].shoukuanshijian.value;
	if (shoukuanshijian == null || trim(shoukuanshijian) == "") {
		alert("收款时间不能为空");
		document.forms[0].shoukuanshijian.focus();// 设置焦点
		return false;
	}

	var wangluo = document.forms[0].wangluo.value;
	var dianshi = document.forms[0].dianshi.value;
	var dianhua = document.forms[0].dianhua.value;
	if (wangluo == null || trim(wangluo) == "") {
		alert("网络不能为空！如果无请填“0”");
		document.forms[0].wangluo.focus();// 设置焦点
		return false;
	}
	if (dianshi == null || trim(dianshi) == "") {
		alert("电视不能为空！如果无请填“0”");
		document.forms[0].dianshi.focus();// 设置焦点
		return false;
	}
	if (dianhua == null || trim(dianhua) == "") {
		alert("电话不能为空！如果无请填“0”");
		document.forms[0].dianhua.focus();// 设置焦点
		return false;
	}
	if (wangluo == '0' && dianshi == '0' && dianhua == '0') {
		alert("网络、电视、电话不能同时为“0”");
		document.forms[0].wangluo.focus();// 设置焦点
		return false;
	}
	if (wangluo != '0' && dianshi != '0') {
		alert("网络、电视、电话不能同时为“0”");
		document.forms[0].wangluo.focus();// 设置焦点
		return false;
	}
	if (wangluo != '0' && dianhua != '0') {
		alert("网络、电视、电话只能选择一种业务");
		document.forms[0].wangluo.focus();// 设置焦点
		return false;
	}
	if (dianshi != '0' && dianhua != '0') {
		alert("网络、电视、电话只能选择一种业务");
		document.forms[0].wangluo.focus();// 设置焦点
		return false;
	}
	if (wangluo != '0' && dianshi != '0' && dianhua != '0') {
		alert("网络、电视、电话只能选择一种业务");
		document.forms[0].wangluo.focus();// 设置焦点
		return false;
	}
	
	var xiaoquname = document.forms[0].yewu.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("业务不能为空！如果无请填“0”");
		document.forms[0].yewu.focus();// 设置焦点
		return false;
	}

	var xiaoquname = document.forms[0].fenguang.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("分光不能为空！");
		document.forms[0].fenguang.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].onumac.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("Onu mac不能为空！如果无请填“0”");
		document.forms[0].onumac.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].stbmcid.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("STB MCID不能为空！如果无请填“0”");
		document.forms[0].stbmcid.focus();// 设置焦点
		return false;
	}

	var xiaoquname = document.forms[0].dianshiip.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("电视IP不能为空！如果无请填“0”");
		document.forms[0].dianshiip.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].wangluoip.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("网络IP不能为空！如果无请填“0”");
		document.forms[0].wangluoip.focus();// 设置焦点
		return false;
	}

	var xiaoquname = document.forms[0].dianhuaip.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("电话IP不能为空！如果无请填“0”");
		document.forms[0].dianhuaip.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].dianhuavlan.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("电话Vlan不能为空！如果无请填“0”");
		document.forms[0].dianhuavlan.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].wangluovlan.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("网络Vlan不能为空！如果无请填“0”");
		document.forms[0].wangluovlan.focus();// 设置焦点
		return false;
	}
//	if (!istel(lianxidianhua)) {
//		alert("电话格式不正确");
//		document.forms[0].lianxidianhua.focus();// 设置焦点
//		return false;
//	}
//	var sxdhhm = document.forms[0].sxdhhm.value;
//	if (sxdhhm != null && sxdhhm != '') {
//		if (!istel(sxdhhm)) {
//			alert("所选电话格式不正确");
//			document.forms[0].sxdhhm.focus();// 设置焦点
//			return false;
//		}
//	}
	
	var xiaoquname = document.forms[0].onuyj.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("Onu押金只能填写数字");
		document.forms[0].onuyj.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].jidingheyj.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("机顶盒押金只能填写数字");
		document.forms[0].jidingheyj.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].shoushifei.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("收视费只能填写数字");
		document.forms[0].shoushifei.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].kuandaifei.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("宽带费只能填写数字");
		document.forms[0].kuandaifei.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].chuzhuangfei.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("初装费只能填写数字");
		document.forms[0].chuzhuangfei.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].bzygf.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("不足月够费只能填写数字");
		document.forms[0].bzygf.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].nianfei.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("年费只能填写数字");
		document.forms[0].nianfei.focus();// 设置焦点
		return false;
	}
	var xiaoquname = document.forms[0].zongshoufei.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("总收费只能填写数字");
		document.forms[0].zongshoufei.focus();// 设置焦点
		return false;
	}
	
	return true;
}

// 合计
heji = function() {

	document.getElementById("heji").value = parseInt(document
			.getElementById("onu").value)
			+ parseInt(document.getElementById("shoushifei").value)
			+ parseInt(document.getElementById("jidinghe").value)
			+ parseInt(document.getElementById("jiaohuanji").value)
			+ parseInt(document.getElementById("nianfei").value)
			+ parseInt(document.getElementById("buzuyue").value)
			+ parseInt(document.getElementById("chuzhuangfei").value)
			+ parseInt(document.getElementById("kuaidaifei").value);
}

function isture(obj) {
	if (!ismenhao(obj.value)) {
		alert("请输入正确的地址格式！例如：11-1-1111");
		// document.getElementById("userplace").focus();
		document.forms[0].dizhi.focus();
		return false;
	}
}

function ismenhao(value) {
	// alert(value);
	// alert(/^\d{2}-\d{1}-\d{4}$/.test(value))
	return /^[a-z0-9]{2}-[a-z0-9]{1}-[a-z0-9]{4}$/.test(value);
}

// 用户电话验证(电话/手机)
function istel(value) {
	return /(^\d{8}$)|(^\d{11}$)/.test(value);
}

// 交换机 onu 显示
function selectxiaoqu(obj) {
	if (obj.value == "天欣花园" || obj.value == "福悦里" || obj.value == "海景公寓") {
		document.getElementById("jiaohuanjiid").style.display = "";
		document.getElementById("onu").value = "0";
		document.getElementById("onutd").style.display = "none";
	} else {
		document.getElementById("jiaohuanji").value = "0";
		document.getElementById("jiaohuanjiid").style.display = "none";
		document.getElementById("onutd").style.display = "";
	}
}

//验证数字
isDigit = function(str) {
	var patrn = /^\d+$/;
	return patrn.test(str);
}
