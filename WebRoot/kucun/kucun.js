
function changeData(){
	if(checkSelect("UUIDS","��ѡ��Ҫɾ������Ŀ")){
		confirmChange();
	}
}
function confirmChange(){
	showConfirm('ȷ��Ҫ�޸�״̬��',removeCallback);
}
function removeCallback(v,m,f){
	if(v){
		document.forms[0].action = "shebeichuku.do?act=shebeiZTchange";
		disableAll(document);
		document.forms[0].submit();
	}
}

function deleteData(){
	if(checkSelect("UUIDS","���ѡ��Ҫɾ�����豸��Ϣ��")){
		confirmChange1();
	}
}
function confirmChange1(){
	showConfirm('ȷ��Ҫɾ����',removeCallback1);
}
function removeCallback1(v,m,f){
	if(v){
		document.forms[0].action ="shebeirukuList.do?act=deleteShebeiData";
		disableAll(document);
		document.forms[0].submit();
	}
}

function check_product() {
	var xianghao = document.forms[0].xianghao.value;
	if (xianghao == null || trim(xianghao) == "") {
		alert("��Ų���Ϊ�գ�");
		document.forms[0].xianghao.focus();// ���ý���
		return false;
	}
	var rukuren = document.forms[0].rukuren.value;
	if (rukuren == null || trim(rukuren) == "") {
		alert("��ѡ������ˣ�");
		document.forms[0].rukuren.focus();// ���ý���
		return false;
	}
	var shebeileixing = document.forms[0].shebeileixing.value;
	if (shebeileixing == null || trim(shebeileixing) == "") {
		alert("�������豸���ͣ�");
		document.forms[0].shebeileixing.focus();// ���ý���
		return false;
	}
	var shebeixinghao = document.forms[0].shebeixinghao.value;
	if (shebeixinghao == null || trim(shebeixinghao) == "") {
		alert("�������豸�ͺţ�");
		document.forms[0].shebeixinghao.focus();// ���ý���
		return false;
	}
	var mac = document.forms[0].mac.value;
	if (mac == null || trim(mac) == "") {
		alert("������MAC��");
		document.forms[0].mac.focus();// ���ý���
		return false;
	}
	var mcid = document.forms[0].mcid.value;
	if (mcid == null || trim(mcid) == "") {
		alert("������MCID��");
		document.forms[0].mcid.focus();// ���ý���
		return false;
	}
	var beizhu = document.forms[0].beizhu.value;
	if (beizhu == null || trim(beizhu) == "") {
		alert("�����뱸ע��Ϣ��");
		document.forms[0].beizhu.focus();// ���ý���
		return false;
	}

	return true;
}



function check(){
	var kaishi = document.forms[0].kaishi.value;
	var jieshu = document.forms[0].jieshu.value;
	if (trim(kaishi) == "" && trim(jieshu) == ""){
		return true;
	} else {
		if(!(trim(kaishi) == "")) {
			kaishi = /^\d{4}[-](\d{2})[-](\d{2})$/.test(kaishi);
			if (kaishi == false ) {
				alert("��ʼʱ�������ʽ����");
				document.forms[0].kaishi.focus();// ���ý���
				return false;
			}
		}

		if(!(trim(jieshu) == "")) {
			jieshu = /^\d{4}[-](\d{2})[-](\d{2})$/.test(jieshu);
			if (jieshu == false ) {
				alert("����ʱ�������ʽ����");
				document.forms[0].jieshu.focus();// ���ý���
				return false;
			}
		}
	}
	return true;
}
