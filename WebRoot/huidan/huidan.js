//��֤���ֵ�������ʽ
pattern2=/^[0-9]+$/;
//��֤���֤��������ʽ
pattern1=/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
//��֤���ڵ�������ʽ
pattern3=/^[1,2][0-9]{3}-[0-9]{2}-[0-9]{2}$/;
//�ص�����-�༭��ʱ����֤
function error_edit(){
	var kai  = document.getElementById('kaijis').value;
	var ting = document.getElementById('tingjis').value;
	var shou = document.getElementById('kaishi').value;
	if(!pattern3.test(kai) || !pattern3.test(ting) || !pattern3.test(shou)){
		alert('ʱ���ʽ�������������룡');
	}else{
		commonSubmit('huidanerrorList.do?act=edit_save');
	}
}
function check_querenchaifen(){
	var a = document.getElementById('kaipiao').value;
	var b = document.getElementById('feikaipiao').value;
	if(a != null && trim(a) != "" && b != null && trim(b) != ""){
		commonSubmit('huidanerrorList.do?act=querenchaifen');
	}
	else{
		alert('����д��Ʊ�վݺź�δ��Ʊ�վݺ�!');
	}
}
//�ص��ύҳ�� �ύ�ǿ� ����
function check_zhengchangtijiao(){
	if(check_suoyou() && check_shijian()){
		commonSubmit('huidansubList.do?act=update_zhengchang');
	}
}
function check_kaipiaochaifen(){
	if(check_suoyou() && check_shijian()){
		commonSubmit('huidansubList.do?act=update_chaifen');
	}
}
function check_jiucuoxiugai(){
	if(check_suoyou()){
		commonSubmit('huidansubList.do?act=update_jiucuo');
	}
}
function check_shijian(){
	var shoukuanshijian = document.getElementById('kaishi').value;
	var kaijishijian = document.getElementById('kaijishijian').value;
	if(shoukuanshijian!=kaijishijian){
		alert("�տ�ʱ����������������!");
		return false;
	}
	if(!pattern3.test(shoukuanshijian)){
		alert("�տ�ʱ���ʽ�������������룡");
		return false;
	}
	var zong = document.getElementById('sub_9').value;
	var all=
		parseInt(document.getElementById('count_1').value)
		+parseInt(document.getElementById('count_2').value)
		+parseInt(document.getElementById('count_3').value)
		+parseInt(document.getElementById('count_4').value)
		+parseInt(document.getElementById('count_5').value)
		+parseInt(document.getElementById('count_6').value)
		+parseInt(document.getElementById('count_7').value)
		+parseInt(document.getElementById('count_8').value)
		+parseInt(document.getElementById('count_9').value);
	if(zong != all){
		alert("���շ��������������룡");
		return false;
	}
	return true;
}
function check_suoyou(){
	document.getElementById('shouju').value=document.getElementById('sub_10').value;
	var shigongren = document.getElementById('sub_4').value;
	if (shigongren == null || trim(shigongren) == "") {
		alert("ʩ���˲���Ϊ�գ�");
		document.getElementById('sub_4').focus();// ���ý���
		return false;
	}
	var shoukuanshijian = document.getElementById('kaishi').value;
	if (shoukuanshijian == null || trim(shoukuanshijian) == "") {
		alert("�տ�ʱ�䲻��Ϊ�գ�");
		document.getElementById('kaishi').focus();// ���ý���
		return false;
	}
	if (!pattern3.test(shoukuanshijian)) {
		alert("�տ�ʱ���ʽ�������������룡");
		document.getElementById('kaishi').focus();// ���ý���
		return false;
	}
	var yonghuxingming = document.getElementById('sub_6').value;
	if (yonghuxingming == null || trim(yonghuxingming) == "") {
		alert("�û���������Ϊ�գ�");
		document.getElementById('sub_6').focus();// ���ý���
		return false;
	}
	var shenfenghzhenghao = document.getElementById('sub_7').value;
	if (shenfenghzhenghao == null || trim(shenfenghzhenghao) == "") {
		alert("���֤�Ų���Ϊ�գ�");
		document.getElementById('sub_7').focus();// ���ý���
		return false;
	}
	/*if (!pattern1.test(shenfenghzhenghao)){
		alert("���֤��ʽ��������������");
		return false;
	}*/
	var jiexuweizhi = document.getElementById('sub_8').value;
	if (jiexuweizhi == null || trim(jiexuweizhi) == "") {
		alert("����λ�ò���Ϊ�գ�");
		document.getElementById('sub_8').focus();// ���ý���
		return false;
	}
	var zongshoufei = document.getElementById('sub_9').value;
	if (zongshoufei == null || trim(zongshoufei) == "") {
		alert("���շѲ���Ϊ�գ�");
		document.getElementById('sub_9').focus();// ���ý���
		return false;
	}
	if(!pattern2.test(zongshoufei)){
		alert("���շ�����������!");
		document.getElementById('sub_9').focus();// ���ý���
		return false;
	}
	var shoujubenhao = document.getElementById('sub_10').value;
	if (shoujubenhao == null || trim(shoujubenhao) == "") {
		alert("�վݱ��Ų���Ϊ�գ�");
		document.getElementById('sub_10').focus();// ���ý���
		return false;
	}
	var jiexianzi = document.getElementById('sub_11').value;
	if (jiexianzi !=null && trim(jiexianzi)!= "" && !pattern2.test(jiexianzi)) {
		alert("���������������֣�");
		document.getElementById('sub_11').focus();// ���ý���
		return false;
	}
	var rj11 = document.getElementById('sub_12').value;
	if (rj11 !=null && trim(rj11)!= "" && !pattern2.test(rj11)) {
		alert("rj11���������֣�");
		document.getElementById('sub_12').focus();// ���ý���
		return false;
	}
	var rj45 = document.getElementById('sub_13').value;
	if (rj45 !=null && trim(rj45)!= "" && !pattern2.test(rj45)) {
		alert("rj45���������֣�");
		document.getElementById('sub_13').focus();// ���ý���
		return false;
	}
	var mokuai = document.getElementById('sub_14').value;
	if (mokuai !=null && trim(mokuai)!= "" && !pattern2.test(mokuai)) {
		alert("ģ�����������֣�");
		document.getElementById('sub_14').focus();// ���ý���
		return false;
	}
	var mianban = document.getElementById('sub_15').value;
	if (mianban !=null && trim(mianban)!= "" && !pattern2.test(mianban)) {
		alert("������������֣�");
		document.getElementById('sub_15').focus();// ���ý���
		return false;
	}
	var wangxian = document.getElementById('sub_16').value;
	if (wangxian !=null && trim(wangxian)!= "" && !pattern2.test(wangxian)) {
		alert("�������������֣�");
		document.getElementById('sub_16').focus();// ���ý���
		return false;
	}
	return true;
}

//���ûص��ύҳ����ĸ��ύ��ťѡ��
//�г��� �޳��� ��Ʊ�����
function check_youchuru(){
	document.getElementById('check_11').disabled=false;
	document.getElementById('check_22').disabled=true;
	document.getElementById('check_22').value="";
	document.getElementById('count_qian').innerHTML='';
	document.getElementById('button_3').disabled=false;
	document.getElementById('button_2').disabled=true;
	document.getElementById('button_1').disabled=true;
}
function check_wuchuru(){
	document.getElementById('check_11').disabled=true;
	document.getElementById('check_22').disabled=true;
	document.getElementById('check_11').value="";
	document.getElementById('check_22').value="";
	document.getElementById('count_qian').innerHTML=
		parseInt(document.getElementById('count_1').value)
		+parseInt(document.getElementById('count_2').value)
		+parseInt(document.getElementById('count_3').value)
		+parseInt(document.getElementById('count_4').value)
		+parseInt(document.getElementById('count_5').value)
		+parseInt(document.getElementById('count_6').value)
		+parseInt(document.getElementById('count_7').value)
		+parseInt(document.getElementById('count_8').value)
		+parseInt(document.getElementById('count_9').value);
	document.getElementById('button_1').disabled=false;
	document.getElementById('button_2').disabled=true;
	document.getElementById('button_3').disabled=true;
}
function check_kaipiaojinechaifen(){
	document.getElementById('check_11').disabled=true;
	document.getElementById('check_22').disabled=false;
	document.getElementById('check_11').value="";
	document.getElementById('count_qian').innerHTML=
		parseInt(document.getElementById('count_1').value)
		+parseInt(document.getElementById('count_2').value)
		+parseInt(document.getElementById('count_3').value)
		+parseInt(document.getElementById('count_4').value)
		+parseInt(document.getElementById('count_5').value)
		+parseInt(document.getElementById('count_6').value)
		+parseInt(document.getElementById('count_7').value)
		+parseInt(document.getElementById('count_8').value)
		+parseInt(document.getElementById('count_9').value);
	document.getElementById('button_1').disabled=true;
	document.getElementById('button_3').disabled=true;
	document.getElementById('button_2').disabled=false;
}
function check_huidan(){
	var xiaoqu = document.forms[0].xiaoqu.value;
	if (xiaoqu == null || trim(xiaoqu) == "") {
		alert("��ѡ��С����");
		document.forms[0].xiaoqu.focus();// ���ý���
		return false;
	}
	var dizhi = document.forms[0].dizhi.value;
	if (dizhi == null || trim(dizhi) == "") {
		alert("��ַ����Ϊ�գ�");
		document.forms[0].dizhi.focus();// ���ý���
		return false;
	}
	var lianxidianhua = document.forms[0].telNoCode.value;
	if (lianxidianhua == null || trim(lianxidianhua) == "") {
		alert("��ϵ�绰����Ϊ�գ�");
		document.forms[0].telNoCode.focus();// ���ý���
		return false;
	}
	var wangluo = document.forms[0].wangluo.value;
	if (wangluo == null || trim(wangluo) == "") {
		alert("�����������");
		document.forms[0].wangluo.focus();// ���ý���
		return false;
	}
	var dianshi = document.forms[0].dianshi.value;
	if (dianshi == null || trim(dianshi) == "") {
		alert("����������");
		document.forms[0].dianshi.focus();// ���ý���
		return false;
	}
	var dianhua = document.forms[0].dianhua.value;
	if (dianhua == null || trim(dianhua) == "") {
		alert("������绰�");
		document.forms[0].dianhua.focus();// ���ý���
		return false;
	}
	var yewu = document.forms[0].yewu.value;
	if (yewu == null || trim(yewu) == "") {
		alert("������ҵ���");
		document.forms[0].yewu.focus();// ���ý���
		return false;
	}
	var fenguang = document.forms[0].fenguang.value;
	if (fenguang == null || trim(fenguang) == "") {
		alert("������ֹ��");
		document.forms[0].fenguang.focus();// ���ý���
		return false;
	}
	var onumac = document.forms[0].onuCode.value;
	if (onumac == null || trim(onumac) == "") {
		alert("������onumac��");
		document.forms[0].onuCode.focus();// ���ý���
		return false;
	}
	var stbmcid = document.forms[0].mcidCode.value;
	if (stbmcid == null || trim(stbmcid) == "") {
		alert("������stbmcid��");
		document.forms[0].mcidCode.focus();// ���ý���
		return false;
	}
	var dianshiip = document.forms[0].dianshiip.value;
	if (dianshiip == null || trim(dianshiip) == "") {
		alert("���������ip��");
		document.forms[0].dianshiip.focus();// ���ý���
		return false;
	}
	var wangluoip = document.forms[0].wangluoip.value;
	if (wangluoip == null || trim(wangluoip) == "") {
		alert("����������ip��");
		document.forms[0].wangluoip.focus();// ���ý���
		return false;
	}
	var dianhuaip = document.forms[0].dianhuaip.value;
	if (dianhuaip == null || trim(dianhuaip) == "") {
		alert("������绰ip��");
		document.forms[0].dianhuaip.focus();// ���ý���
		return false;
	}
	var dianhuavlan = document.forms[0].dianhuavlan.value;
	if (dianhuavlan == null || trim(dianhuavlan) == "") {
		alert("������绰vlan��");
		document.forms[0].dianhuavlan.focus();// ���ý���
		return false;
	}
	var wangluovlan = document.forms[0].wangluovlan.value;
	if (wangluovlan == null || trim(wangluovlan) == "") {
		alert("����������vlan��");
		document.forms[0].wangluovlan.focus();// ���ý���
		return false;
	}
	var shangmenshijian = document.forms[0].shangmenshijian.value;
	if (shangmenshijian == null || trim(shangmenshijian) == "") {
		alert("����������ʱ�䣡");
		document.forms[0].shangmenshijian.focus();// ���ý���
		return false;
	}
	var danzheng = document.forms[0].danzheng.value;
	if (danzheng == null || trim(danzheng) == "") {
		alert("�����뵥֤��");
		document.forms[0].danzheng.focus();// ���ý���
		return false;
	}
	var sxdhhm = document.forms[0].sxdhhm.value;
	if (sxdhhm == null || trim(sxdhhm) == "") {
		alert("��������ѡ�绰���룡");
		document.forms[0].sxdhhm.focus();// ���ý���
		return false;
	}
	var onuyj = document.forms[0].onuyj.value;
	if (onuyj == null || trim(onuyj) == "") {
		alert("������onuѺ��");
		document.forms[0].onuyj.focus();// ���ý���
		return false;
	}
	var jidingheyj = document.forms[0].jidingheyj.value;
	if (jidingheyj == null || trim(jidingheyj) == "") {
		alert("�����������Ѻ��");
		document.forms[0].jidingheyj.focus();// ���ý���
		return false;
	}
	var shoushifei = document.forms[0].shoushifei.value;
	if (shoushifei == null || trim(shoushifei) == "") {
		alert("���������ӷѣ�");
		document.forms[0].shoushifei.focus();// ���ý���
		return false;
	}
	var kuandaifei = document.forms[0].kuandaifei.value;
	if (kuandaifei == null || trim(kuandaifei) == "") {
		alert("���������ѣ�");
		document.forms[0].kuandaifei.focus();// ���ý���
		return false;
	}
	var chuzhuangfei = document.forms[0].chuzhuangfei.value;
	if (chuzhuangfei == null || trim(chuzhuangfei) == "") {
		alert("�������װ�ѣ�");
		document.forms[0].chuzhuangfei.focus();// ���ý���
		return false;
	}
	var shebeixiaoshoufei = document.forms[0].shebeixiaoshoufei.value;
	if (shebeixiaoshoufei == null || trim(shebeixiaoshoufei) == "") {
		alert("�������豸���۷ѣ�");
		document.forms[0].shebeixiaoshoufei.focus();// ���ý���
		return false;
	}
	var cailiaofei = document.forms[0].cailiaofei.value;
	if (cailiaofei == null || trim(cailiaofei) == "") {
		alert("��������Ϸѣ�");
		document.forms[0].cailiaofei.focus();// ���ý���
		return false;
	}
	var yunyingshang = document.forms[0].yunyingshang.value;
	if (yunyingshang == null || trim(yunyingshang) == "") {
		alert("��������Ӫ�̣�");
		document.forms[0].yunyingshang.focus();// ���ý���
		return false;
	}
	var bzygf = document.forms[0].bzygf.value;
	if (bzygf == null || trim(bzygf) == "") {
		alert("�����벻���¹��ѣ�");
		document.forms[0].bzygf.focus();// ���ý���
		return false;
	}
	var nianfei = document.forms[0].nianfei.value;
	if (nianfei == null || trim(nianfei) == "") {
		alert("��������ѣ�");
		document.forms[0].nianfei.focus();// ���ý���
		return false;
	}
	var beizhuhuizong = document.forms[0].beizhuhuizong.value;
	if (beizhuhuizong == null || trim(beizhuhuizong) == "") {
		alert("�����뱸ע���ܣ�");
		document.forms[0].beizhuhuizong.focus();// ���ý���
		return false;	
	}
	var beizhu = document.forms[0].beizhu.value;
	if (beizhu == null || trim(beizhu) == "") {
		alert("��ע����Ϊ�գ�");
		document.forms[0].beizhu.focus();// ���ý���
		return false;
	}
	var s1 = document.getElementById('kaijis').value;
	var s2 = document.getElementById('tingjis').value;
	if(!pattern3.test(s1)){
		alert("����ʱ���ʽ�������������룡");
		return false;
	}
	if(!pattern3.test(s2)){
		alert("�ػ�ʱ���ʽ�������������룡");
		return false;
	}
	if(s1>s2){
		alert("��ͣ��ʱ�������������������룡");
		return false;
	}
	return true;
}
function check_(){
	var code_Values = document.getElementsByTagName("input"); 
	for(var i = 0;i < code_Values.length;i++) {
		if(code_Values[i].type == "checkbox") {
			code_Values[i].checked = "checked"; 
		}
	}	
}
function sub_updateHuidan() {
    if(check_huidan()){
              commonSubmit('huidandaoruList.do?act=update_Huidan');
     }
}


function check(){
	var kaijie = document.forms[0].kaijie.value;
	var tingjie = document.forms[0].tingjie.value;
	if (trim(kaijie) == "" && trim(tingjie) == ""){
		return true;
	} else {
		if(!(trim(kaijie) == "")) {
			kaijie = /^\d{4}[-](\d{2})[-](\d{2})$/.test(kaijie);
			if (kaijie == false ) {
				alert("��ʼʱ�������ʽ����");
				document.forms[0].kaijie.focus();// ���ý���
				return false;
			}
		}

		if(!(trim(tingjie) == "")) {
			tingjie = /^\d{4}[-](\d{2})[-](\d{2})$/.test(tingjie);
			if (tingjie == false ) {
				alert("����ʱ�������ʽ����");
				document.forms[0].tingjie.focus();// ���ý���
				return false;
			}
		}
	}
	return true;
}
function check1(){
	var kaijis = document.forms[0].kaijis.value;
	var kaijie = document.forms[0].kaijie.value;
	if (trim(kaijis) == "" && trim(kaijie) == ""){
		return true;
	} else {
		if(!(trim(kaijis) == "")) {
			kaijis = /^\d{4}[-](\d{2})[-](\d{2})$/.test(kaijis);
			if (kaijis == false ) {
				alert("��ʼʱ�������ʽ����");
				document.forms[0].kaijis.focus();// ���ý���
				return false;
			}
		}

		if(!(trim(kaijie) == "")) {
			kaijie = /^\d{4}[-](\d{2})[-](\d{2})$/.test(kaijie);
			if (kaijie == false ) {
				alert("����ʱ�������ʽ����");
				document.forms[0].kaijie.focus();// ���ý���
				return false;
			}
		}
	}
	return true;
}

function check2(){
	var sen1 = document.forms[0].sen1.value;
	var sen2 = document.forms[0].sen2.value;
	if (trim(sen1) == "" && trim(sen2) == ""){
		return true;
	} else {
		if(!(trim(sen1) == "")) {
			sen1 = /^\d{4}[-](\d{2})[-](\d{2})$/.test(sen1);
			if (sen1 == false ) {
				alert("��ʼʱ�������ʽ����");
				document.forms[0].sen1.focus();// ���ý���
				return false;
			}
		}

		if(!(trim(sen2) == "")) {
			sen2 = /^\d{4}[-](\d{2})[-](\d{2})$/.test(sen2);
			if (sen2 == false ) {
				alert("����ʱ�������ʽ����");
				document.forms[0].sen2.focus();// ���ý���
				return false;
			}
		}
	}
	return true;
}

