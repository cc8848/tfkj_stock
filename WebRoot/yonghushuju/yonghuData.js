//ɾ��
function removeData() {
	if (checkSelect("UUID", "��ѡ���ɾ���绰����")) {
		confirmRemove();
	}
}
// ɾ��ȷ��
function confirmRemove() {
	showConfirm('ȷ��Ҫɾ��ѡ���ĵ绰����.', removeCallback);
}
// ɾ������
function removeCallback(v, m, f) {
	if (v) {
		document.forms[0].action = "telNumEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}

// ȥ���ո�
String.prototype.trim = function() {
	return this.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
}

function checkInputForJiaofei() {
	var xiaoquname = document.forms[0].kaijishijian.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("����ʱ�䲻��Ϊ��");
		document.forms[0].kaijishijian.focus();// ���ý���
		return false;
	}

	var xiaoquname = document.forms[0].tingjishijian.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("ͣ��ʱ�䲻��Ϊ��");
		document.forms[0].tingjishijian.focus();// ���ý���
		return false;
	}
	
	return true;
}

function checkInput() {
	var username = document.forms[0].xingming.value;
	
	if (username == null || trim(username) == "") {
		alert("�û���������Ϊ�գ�");
		document.forms[0].xingming.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].xiaoqu.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("�û�С������Ϊ�գ�");
		document.forms[0].xiaoqu.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].dizhi.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("�û���ַ����Ϊ�գ�");
		document.forms[0].dizhi.focus();// ���ý���
		return false;
	}
//	if (!ismenhao(xiaoquname)) {
//		alert("��������ȷ�ĵ�ַ��ʽ��");
//		// document.getElementById("userplace").focus();
//		document.forms[0].dizhi.focus();
//		return false;
//	}
	var lianxidianhua = document.forms[0].lianxidianhua.value;
	if (lianxidianhua == null || trim(lianxidianhua) == "") {
		alert("�û���ϵ�绰����Ϊ�գ�");
		document.forms[0].lianxidianhua.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].shenfensheng.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("�û����֤�Ų���Ϊ�գ�");
		document.forms[0].shenfensheng.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].shoujuhao.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("�վݺŲ���Ϊ�գ�");
		document.forms[0].shoujuhao.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].fenguangxianhao.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("�ֹ��ߺŲ���Ϊ�գ�");
		document.forms[0].fenguangxianhao.focus();// ���ý���
		return false;
	}

	var xiaoquname = document.forms[0].jiexuweizhi.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("����λ�ò���Ϊ�գ�");
		document.forms[0].jiexuweizhi.focus();// ���ý���
		return false;
	}

	var xiaoquname = document.forms[0].kaijishijian.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("����ʱ�䲻��Ϊ��");
		document.forms[0].kaijishijian.focus();// ���ý���
		return false;
	}

	var xiaoquname = document.forms[0].tingjishijian.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("ͣ��ʱ�䲻��Ϊ��");
		document.forms[0].tingjishijian.focus();// ���ý���
		return false;
	}
	
	var youxiaoshijian = document.forms[0].youxiaoshijian.value;
	if (youxiaoshijian == null || trim(youxiaoshijian) == "") {
		alert("��Чʱ�䲻��Ϊ��");
		document.forms[0].youxiaoshijian.focus();// ���ý���
		return false;
	}
	
	var shoukuanshijian = document.forms[0].shoukuanshijian.value;
	if (shoukuanshijian == null || trim(shoukuanshijian) == "") {
		alert("�տ�ʱ�䲻��Ϊ��");
		document.forms[0].shoukuanshijian.focus();// ���ý���
		return false;
	}

	var wangluo = document.forms[0].wangluo.value;
	var dianshi = document.forms[0].dianshi.value;
	var dianhua = document.forms[0].dianhua.value;
	if (wangluo == null || trim(wangluo) == "") {
		alert("���粻��Ϊ�գ���������0��");
		document.forms[0].wangluo.focus();// ���ý���
		return false;
	}
	if (dianshi == null || trim(dianshi) == "") {
		alert("���Ӳ���Ϊ�գ���������0��");
		document.forms[0].dianshi.focus();// ���ý���
		return false;
	}
	if (dianhua == null || trim(dianhua) == "") {
		alert("�绰����Ϊ�գ���������0��");
		document.forms[0].dianhua.focus();// ���ý���
		return false;
	}
	if (wangluo == '0' && dianshi == '0' && dianhua == '0') {
		alert("���硢���ӡ��绰����ͬʱΪ��0��");
		document.forms[0].wangluo.focus();// ���ý���
		return false;
	}
	if (wangluo != '0' && dianshi != '0') {
		alert("���硢���ӡ��绰����ͬʱΪ��0��");
		document.forms[0].wangluo.focus();// ���ý���
		return false;
	}
	if (wangluo != '0' && dianhua != '0') {
		alert("���硢���ӡ��绰ֻ��ѡ��һ��ҵ��");
		document.forms[0].wangluo.focus();// ���ý���
		return false;
	}
	if (dianshi != '0' && dianhua != '0') {
		alert("���硢���ӡ��绰ֻ��ѡ��һ��ҵ��");
		document.forms[0].wangluo.focus();// ���ý���
		return false;
	}
	if (wangluo != '0' && dianshi != '0' && dianhua != '0') {
		alert("���硢���ӡ��绰ֻ��ѡ��һ��ҵ��");
		document.forms[0].wangluo.focus();// ���ý���
		return false;
	}
	
	var xiaoquname = document.forms[0].yewu.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("ҵ����Ϊ�գ���������0��");
		document.forms[0].yewu.focus();// ���ý���
		return false;
	}

	var xiaoquname = document.forms[0].fenguang.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("�ֹⲻ��Ϊ�գ�");
		document.forms[0].fenguang.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].onumac.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("Onu mac����Ϊ�գ���������0��");
		document.forms[0].onumac.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].stbmcid.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("STB MCID����Ϊ�գ���������0��");
		document.forms[0].stbmcid.focus();// ���ý���
		return false;
	}

	var xiaoquname = document.forms[0].dianshiip.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("����IP����Ϊ�գ���������0��");
		document.forms[0].dianshiip.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].wangluoip.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("����IP����Ϊ�գ���������0��");
		document.forms[0].wangluoip.focus();// ���ý���
		return false;
	}

	var xiaoquname = document.forms[0].dianhuaip.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("�绰IP����Ϊ�գ���������0��");
		document.forms[0].dianhuaip.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].dianhuavlan.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("�绰Vlan����Ϊ�գ���������0��");
		document.forms[0].dianhuavlan.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].wangluovlan.value;
	if (xiaoquname == null || trim(xiaoquname) == "") {
		alert("����Vlan����Ϊ�գ���������0��");
		document.forms[0].wangluovlan.focus();// ���ý���
		return false;
	}
//	if (!istel(lianxidianhua)) {
//		alert("�绰��ʽ����ȷ");
//		document.forms[0].lianxidianhua.focus();// ���ý���
//		return false;
//	}
//	var sxdhhm = document.forms[0].sxdhhm.value;
//	if (sxdhhm != null && sxdhhm != '') {
//		if (!istel(sxdhhm)) {
//			alert("��ѡ�绰��ʽ����ȷ");
//			document.forms[0].sxdhhm.focus();// ���ý���
//			return false;
//		}
//	}
	
	var xiaoquname = document.forms[0].onuyj.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("OnuѺ��ֻ����д����");
		document.forms[0].onuyj.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].jidingheyj.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("������Ѻ��ֻ����д����");
		document.forms[0].jidingheyj.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].shoushifei.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("���ӷ�ֻ����д����");
		document.forms[0].shoushifei.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].kuandaifei.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("�����ֻ����д����");
		document.forms[0].kuandaifei.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].chuzhuangfei.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("��װ��ֻ����д����");
		document.forms[0].chuzhuangfei.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].bzygf.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("�����¹���ֻ����д����");
		document.forms[0].bzygf.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].nianfei.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("���ֻ����д����");
		document.forms[0].nianfei.focus();// ���ý���
		return false;
	}
	var xiaoquname = document.forms[0].zongshoufei.value;
	if (xiaoquname != null && trim(xiaoquname) != "" && !isDigit(xiaoquname)) {
		alert("���շ�ֻ����д����");
		document.forms[0].zongshoufei.focus();// ���ý���
		return false;
	}
	
	return true;
}

// �ϼ�
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
		alert("��������ȷ�ĵ�ַ��ʽ�����磺11-1-1111");
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

// �û��绰��֤(�绰/�ֻ�)
function istel(value) {
	return /(^\d{8}$)|(^\d{11}$)/.test(value);
}

// ������ onu ��ʾ
function selectxiaoqu(obj) {
	if (obj.value == "������԰" || obj.value == "������" || obj.value == "������Ԣ") {
		document.getElementById("jiaohuanjiid").style.display = "";
		document.getElementById("onu").value = "0";
		document.getElementById("onutd").style.display = "none";
	} else {
		document.getElementById("jiaohuanji").value = "0";
		document.getElementById("jiaohuanjiid").style.display = "none";
		document.getElementById("onutd").style.display = "";
	}
}

//��֤����
isDigit = function(str) {
	var patrn = /^\d+$/;
	return patrn.test(str);
}
