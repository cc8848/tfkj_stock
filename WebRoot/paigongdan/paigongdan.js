//ɾ��
function removeData(){
	if(checkSelect("UUID","��ѡ���ɾ�����ɹ���")){
		confirmRemove();
	}
}
//ɾ��ȷ��
function confirmRemove(){
	showConfirm('ȷ��Ҫɾ��ѡ�����ɹ�����',removeCallback);
}
//ɾ������
function removeCallback(v,m,f){
	if(v){
		if(deletecheck("UUID")) {
				return false;
		}
		document.forms[0].action = "paigongdanEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}

function removeData1(){
	if(checkSelect("UUID","��ѡ��������ɹ���")){
		confirmRemove1();
	}
}
//ɾ��ȷ��
function confirmRemove1(){
	showConfirm('ȷ��Ҫ���ѡ�����ɹ�����',removeCallback1);
}
//ɾ������
function removeCallback1(v,m,f){
	if(v){
		document.forms[0].action = "paigongdanEdit.do?act=jiebang";
		disableAll(document);
		document.forms[0].submit();
	}
}



//ȥ���ո�
String.prototype.trim = function () {
	return this .replace(/^\s\s*/, '' ).replace(/\s\s*$/, '' );
      }

function checkInput1(){
	var username = document.forms[0].username.value;
	if(username==null||trim(username)==""){
		alert("�û���������Ϊ�գ�");
		document.forms[0].username.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].xiaoquname[0].value;
	var selectxiaoquhidden = document.forms[0].selectxiaoquhidden.value;
	if((xiaoquname==null||trim(xiaoquname)=="")&&(selectxiaoquhidden==null||trim(selectxiaoquhidden)=="")){
		alert("С�����Ʋ���Ϊ�գ�");
		document.getElementById("xiaoquname").focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].userplace.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�û���ַ����Ϊ�գ�");
		document.forms[0].userplace.focus();//���ý���
		return false;
		}
	if(!ismenhao(xiaoquname)){
		alert("��������ȷ�ĵ�ַ��ʽ��");
		//document.getElementById("userplace").focus();
		document.forms[0].userplace.focus();
		return false;
		}
	var xiaoquname = document.forms[0].usertel.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�û���ϵ�绰����Ϊ�գ�");
		document.forms[0].usertel.focus();//���ý���
		return false;
		}
	
	var xiaoquname = document.forms[0].paigongriqi.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�ɹ����ڲ���Ϊ�գ�");
		document.forms[0].paigongriqi.focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].anzhuangshijian.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("���Ű�װʱ�䲻��Ϊ�գ�");
		document.forms[0].anzhuangshijian.focus();//���ý���
		return false;
		}
	
	var xiaoquname = document.forms[0].xiangmu.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("��Ŀ����Ϊ��");
		document.forms[0].xiangmu.focus();//���ý���
		return false;
		}

	var tfkuandaidaikuan = document.forms[0].tfkuandaidaikuan.value;
	var qiegaidaikuan = document.forms[0].qiegaidaikuan.value;
	if((tfkuandaidaikuan==null||trim(tfkuandaidaikuan)=="")&&trim(qiegaidaikuan)==""){
		alert("������Ϊ�գ���������0��");
		document.forms[0].tfkuandaidaikuan.focus();//���ý���
		return false;
	}
	
	
	var tfkdnianxian = document.forms[0].tfkdnianxian.value;
	
	if (tfkdnianxian == 0 && tfkuandaidaikuan != 0){
		alert("�����Ѿ�ѡ����ѡ��ʱ����");
		document.forms[0].tfkdnianxian.focus();//���ý���
		return false;
	}
	
	if (tfkdnianxian != 0 && tfkuandaidaikuan==0){
		alert("ʱ���Ѿ�ѡ����ѡ�����");
		document.forms[0].tfkuandaidaikuan.focus();//���ý���
		return false;
	}
	if(tfkdnianxian==null||trim(tfkdnianxian)==""){
		alert("ʱ������Ϊ�գ���ѡ����ȷ��ʱ�����ͺʹ���");
		document.forms[0].tfkdnianxian.focus();//���ý���
		return false;
		}
	
	var xiaoquname = document.forms[0].tfiptv.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("IPTV����Ϊ�գ���������0��");
		document.forms[0].tfiptv.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].tfiptvnianxian.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("IPTV���޲���Ϊ�գ���������0��");
		document.forms[0].tfiptvnianxian.focus();//���ý���
		return false;
		}
	var yuyingshang = document.forms[0].yuyingshang.value;
	if(yuyingshang==null||trim(yuyingshang)=="0"){
		alert("��Ӫ�̲���Ϊ�գ�");
		document.forms[0].yuyingshang.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].qtye.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�ײͲ���Ϊ�գ�");
		document.forms[0].qtye.focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].dxchuzhuangfei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("��װ�Ѳ���Ϊ�գ�");
		document.forms[0].dxchuzhuangfei.focus();//���ý���
		return false;
		}
	
	var xiaoquname = document.forms[0].fufei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�긶����Ϊ�գ���������0��");
		document.forms[0].fufei.focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].telhaoma1.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("����һ����Ϊ�գ���������0000000��");
		document.forms[0].telhaoma1.focus();//���ý���
		return false;
		}
	if(!istel(xiaoquname)){
		alert("�绰��ʽ����ȷ");
		document.forms[0].telhaoma1.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].telhaoma2.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("���������Ϊ�գ���������0000000��");
		document.forms[0].telhaoma2.focus();//���ý���
		return false;
		}
	
	if(!istel(xiaoquname)){
		alert("�绰��ʽ����ȷ");
		document.forms[0].telhaoma2.focus();//���ý���
		return false;
		}
	document.forms[0].telhaoma1.value = trim(document.forms[0].telhaoma1.value);
	document.forms[0].telhaoma2.value = trim(document.forms[0].telhaoma2.value);
	document.forms[0].telhaoma3.value = trim(document.forms[0].telhaoma3.value);
	document.forms[0].telhaoma4.value = trim(document.forms[0].telhaoma4.value);
	var xiaoquname = document.forms[0].telhaoma3.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("����3����Ϊ�գ���������0000000��");
		document.forms[0].telhaoma3.focus();//���ý���
		return false;
		}
	if(!istel(xiaoquname)){
		alert("�绰��ʽ����ȷ");
		document.forms[0].telhaoma3.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].telhaoma4.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("����4����Ϊ�գ���������0000000��");
		document.forms[0].telhaoma4.focus();//���ý���
		return false;
		}
	if(!istel(xiaoquname)){
		alert("�绰��ʽ����ȷ");
		document.forms[0].telhaoma4.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].onu.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("onuѺ����Ϊ�գ���������0��");
		document.forms[0].onu.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].shoushifei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("���ӷѲ���Ϊ�գ���������0��");
		document.forms[0].shoushifei.focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].jidinghe.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("������Ѻ����Ϊ�գ���������0��");
		document.forms[0].jidinghe.focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].nianfei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("��Ѳ���Ϊ�գ���������0��");
		document.forms[0].nianfei.focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].buzuyue.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�����²���Ϊ�գ���������0��");
		document.forms[0].buzuyue.focus();//���ý���
		return false;
		}else if(!isDigit(xiaoquname)){
			alert("������ֻ����д����");
			document.forms[0].buzuyue.focus();//���ý���
			return false;
		}
	var xiaoquname = document.forms[0].chuzhuangfei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("��װ�Ѳ���Ϊ�գ���������0��");
		document.forms[0].chuzhuangfei.focus();//���ý���
		return false;
		}else if(!isDigit(xiaoquname)){
			alert("��װ��ֻ����д����");
			document.forms[0].chuzhuangfei.focus();//���ý���
			return false;
		}
	var xiaoquname = document.forms[0].kuaidaifei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("����Ѳ���Ϊ�գ���������0��");
		document.forms[0].kuaidaifei.focus();//���ý���
		return false;
		}else if(!isDigit(xiaoquname)){
			alert("�����ֻ����д����");
			document.forms[0].kuaidaifei.focus();//���ý���
			return false;
		}
	var xiaoquname = document.forms[0].beizhu.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("��ע����Ϊ�գ����������ޡ�");
		document.forms[0].beizhu.focus();//���ý���
		return false;
		}
	var xiaoquname = document.getElementById("heji").value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�ϼƲ���Ϊ�գ���㡰�ϼơ�");
		document.forms[0].heji.focus();//���ý���
		return false;
		}
			var isyijiradio = document.forms[0].isYiji;
			var isYiji = "0";
			if(isyijiradio!=undefined) {
				var isYiji = document.forms[0].isYiji[1].checked;
			var yichuxiaoqu = document.forms[0].yichuxiaoqu.value;
			var yichudizhi = document.forms[0].yichudizhi.value;
			var yichuyewu = document.forms[0].yichuyewu.value;
			var yichudianshi = document.forms[0].yichudianshi.value;
			var yichuqita = document.forms[0].yichuqita.value;
			if(isYiji == "1" && (yichuxiaoqu == ' ' && yichuxiaoqu == '')) {
				alert("�Ƴ�С������Ϊ�գ�");
				document.forms[0].yichuxiaoqu.focus();//���ý���
				return false;
			}
			if(isYiji == "1" && yichudizhi == '') {
				alert("�Ƴ���ַ����Ϊ�գ�");
				document.forms[0].yichudizhi.focus();//���ý���
				return false;
			}
			if(isYiji == "1" && (yichuyewu == ''&&yichudianshi == ''&&yichuqita == '')) {
				alert("�Ƴ�ҵ����Ϊ�գ�");
				document.forms[0].yichuyewu.focus();//���ý���
				return false;
			}
			}
	return true;
}
function checkInput2(){
	var username = document.forms[0].username.value;
	if(username==null||trim(username)==""){
		alert("�û���������Ϊ�գ�");
		document.forms[0].username.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].xiaoquname.value;
	var selectxiaoquhidden = document.forms[0].selectxiaoquhidden.value;
	if((xiaoquname==null||trim(xiaoquname)=="")&&(selectxiaoquhidden==null||trim(selectxiaoquhidden)=="")){
		alert("С�����Ʋ���Ϊ�գ�");
		document.forms[0].xiaoquname.focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].userplace.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�û���ַ����Ϊ�գ�");
		document.forms[0].userplace.focus();//���ý���
		return false;
		}
	if(!ismenhao(xiaoquname)){
		alert("��������ȷ�ĵ�ַ��ʽ��");
		//document.getElementById("userplace").focus();
		document.forms[0].userplace.focus();
		return false;
		}
	var xiaoquname = document.forms[0].usertel.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�û���ϵ�绰����Ϊ�գ�");
		document.forms[0].usertel.focus();//���ý���
		return false;
		}
	
	var xiaoquname = document.forms[0].paigongriqi.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�ɹ����ڲ���Ϊ�գ�");
		document.forms[0].paigongriqi.focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].anzhuangshijian.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("���Ű�װʱ�䲻��Ϊ�գ�");
		document.forms[0].anzhuangshijian.focus();//���ý���
		return false;
		}
	
	//var xiaoquname = document.forms[0].xiangmu.value;
	//if(xiaoquname==null||trim(xiaoquname)==""){
	//	alert("��Ŀ����Ϊ��");
	//	document.forms[0].xiangmu.focus();//���ý���
	//	return false;
	//	}

	var xiaoquname = document.forms[0].tfkuandaidaikuan.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("������Ϊ�գ���������0��");
		document.forms[0].tfkuandaidaikuan.focus();//���ý���
		return false;
		}

	
	
	var xiaoquname = document.forms[0].tfkdnianxian.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("���޲���Ϊ�գ���������0��");
		document.forms[0].tfkdnianxian.focus();//���ý���
		return false;
		}
	
	var xiaoquname = document.forms[0].tfiptv.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("IPTV����Ϊ�գ���������0��");
		document.forms[0].tfiptv.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].tfiptvnianxian.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("IPTV���޲���Ϊ�գ���������0��");
		document.forms[0].tfiptvnianxian.focus();//���ý���
		return false;
		}
	var yuyingshang = document.forms[0].yuyingshang.value;
	if(yuyingshang==null||trim(yuyingshang)=="0"){
		alert("��Ӫ�̲���Ϊ�գ�");
		document.forms[0].yuyingshang.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].qtye.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�ײͲ���Ϊ�գ�");
		document.forms[0].qtye.focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].dxchuzhuangfei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("��װ�Ѳ���Ϊ�գ�");
		document.forms[0].dxchuzhuangfei.focus();//���ý���
		return false;
		}
	
	var xiaoquname = document.forms[0].fufei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�긶����Ϊ�գ���������0��");
		document.forms[0].fufei.focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].telhaoma1.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("����һ����Ϊ�գ���������0000000��");
		document.forms[0].telhaoma1.focus();//���ý���
		return false;
		}
	if(!istel(xiaoquname)){
		alert("�绰��ʽ����ȷ");
		document.forms[0].telhaoma1.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].telhaoma2.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("���������Ϊ�գ���������0000000��");
		document.forms[0].telhaoma2.focus();//���ý���
		return false;
		}
	if(!istel(xiaoquname)){
		alert("�绰��ʽ����ȷ");
		document.forms[0].telhaoma2.focus();//���ý���
		return false;
		}
	
	var xiaoquname = document.forms[0].telhaoma3.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("����3����Ϊ�գ���������0000000��");
		document.forms[0].telhaoma3.focus();//���ý���
		return false;
		}
	if(!istel(xiaoquname)){
		alert("�绰��ʽ����ȷ");
		document.forms[0].telhaoma3.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].telhaoma4.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("����4����Ϊ�գ���������0000000��");
		document.forms[0].telhaoma4.focus();//���ý���
		return false;
		}
	if(!istel(xiaoquname)){
		alert("�绰��ʽ����ȷ");
		document.forms[0].telhaoma4.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].onu.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("onuѺ����Ϊ�գ���������0��");
		document.forms[0].onu.focus();//���ý���
		return false;
		}
	var xiaoquname = document.forms[0].shoushifei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("���ӷѲ���Ϊ�գ���������0��");
		document.forms[0].shoushifei.focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].jidinghe.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("������Ѻ����Ϊ�գ���������0��");
		document.forms[0].jidinghe.focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].nianfei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("��Ѳ���Ϊ�գ���������0��");
		document.forms[0].nianfei.focus();//���ý���
		return false;
		}

	var xiaoquname = document.forms[0].buzuyue.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�����²���Ϊ�գ���������0��");
		document.forms[0].buzuyue.focus();//���ý���
		return false;
		}else if(!isDigit(xiaoquname)){
			alert("������ֻ����д����");
			document.forms[0].buzuyue.focus();//���ý���
			return false;
		}
	var xiaoquname = document.forms[0].chuzhuangfei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("��װ�Ѳ���Ϊ�գ���������0��");
		document.forms[0].chuzhuangfei.focus();//���ý���
		return false;
		}else if(!isDigit(xiaoquname)){
			alert("��װ��ֻ����д����");
			document.forms[0].chuzhuangfei.focus();//���ý���
			return false;
		}
	var xiaoquname = document.forms[0].kuaidaifei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("����Ѳ���Ϊ�գ���������0��");
		document.forms[0].kuaidaifei.focus();//���ý���
		return false;
		}else if(!isDigit(xiaoquname)){
			alert("�����ֻ����д����");
			document.forms[0].kuaidaifei.focus();//���ý���
			return false;
		}
	var xiaoquname = document.forms[0].beizhu.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("��ע����Ϊ�գ����������ޡ�");
		document.forms[0].beizhu.focus();//���ý���
		return false;
		}
	var xiaoquname = document.getElementById("heji").value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("�ϼƲ���Ϊ�գ���㡰�ϼơ�");
		document.forms[0].heji.focus();//���ý���
		return false;
		}
	return true;
}
	//�ÿ��췿�����Ϣ
	function clearKuandai(){
		if(document.getElementById("tfkuandaidaikuan").value=="4M"){
			document.getElementById("tfkdnianxian").value="15";
			document.getElementById("tfkdczf").value="0";
			document.getElementById("tfkuandaifei").value="1200";
			document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
			document.getElementById("kuaidaifei").value="1200";
		}else if(document.getElementById("tfkuandaidaikuan").value=="8M"){
			document.getElementById("tfkdnianxian").value="18";
			document.getElementById("tfkdczf").value="0";
			document.getElementById("tfkuandaifei").value="1600";
			document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
			document.getElementById("kuaidaifei").value="1600";
		}else{
		document.getElementById("tfkdnianxian").value="0";
		document.getElementById("tfkdczf").value="0";
		document.getElementById("tfkuandaifei").value="0";
		//document.getElementById("tfkuandaionu").value="0";

		document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
		document.getElementById("kuaidaifei").value="0";

		document.getElementById("heji").value=="0";
		}
		}
	//�췿����ʷ�����
	function tfscselect(objs){
	//	alert("-s-s---s"+document.getElementById("tfkuandaidaikuan").value);
		document.getElementById("heji").value=="0";
		obj=objs.value;
		//alert(document.getElementById("tfkdnianxian").value);
		if(document.getElementById("tfkuandaidaikuan").value=="0"){
			alert("��ѡ�����");
			document.getElementById("tfkdnianxian").focus();//���ý���
			}
		else{
			if(document.getElementById("tfkuandaidaikuan").value=="1M"){
			if(obj<=5){
				document.getElementById("tfkdczf").value=150;
				document.getElementById("tfkuandaifei").value=obj*80;

				document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
				document.getElementById("kuaidaifei").value=obj*80;
				
				}else if(obj==6){
					document.getElementById("tfkdczf").value=0;
					document.getElementById("tfkuandaifei").value=400;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=400;
					}else if(obj>6&&obj<=11){
					document.getElementById("tfkdczf").value=0;
					document.getElementById("tfkuandaifei").value=obj*80;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=obj*80;
					}else if(obj==15){
							document.getElementById("tfkdczf").value=0;
							document.getElementById("tfkuandaifei").value=700;

							document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
							document.getElementById("kuaidaifei").value=700;
						}else if(obj==30){
							document.getElementById("tfkdczf").value=0;
							document.getElementById("tfkuandaifei").value=1400;

							document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
							document.getElementById("kuaidaifei").value=1400;
						}else{
							alert("�췿���1Mû��"+obj+"���ʷѲ�Ʒ");
						}
						
			}else if(document.getElementById("tfkuandaidaikuan").value=="2M"){
				if(obj<=5){
					document.getElementById("tfkdczf").value=150;
					document.getElementById("tfkuandaifei").value=obj*100;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=obj*100;
					}else if(obj==6){
						document.getElementById("tfkdczf").value=0;
						document.getElementById("tfkuandaifei").value=550;

						document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
						document.getElementById("kuaidaifei").value=550;
						}else if(obj>6&&obj<=11){
						document.getElementById("tfkdczf").value=0;
						document.getElementById("tfkuandaifei").value=obj*100;

						document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
						document.getElementById("kuaidaifei").value=obj*100;
						}else if(obj==15){
								document.getElementById("tfkdczf").value=0;
								document.getElementById("tfkuandaifei").value=1000;

								document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
								document.getElementById("kuaidaifei").value=1000;
							}else if(obj==30){
								document.getElementById("tfkdczf").value=0;
								document.getElementById("tfkuandaifei").value=2000;

								document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
								document.getElementById("kuaidaifei").value=2000;
							}else{
								alert("�췿���2Mû��"+obj+"���ʷѲ�Ʒ");
							}
				}
			else if(document.getElementById("tfkuandaidaikuan").value=="4M"){
				if(obj==15){
					document.getElementById("tfkdczf").value=0;
					document.getElementById("tfkuandaifei").value=1200;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=1200;
				}else if(obj==30){
					document.getElementById("tfkdczf").value=0;
					document.getElementById("tfkuandaifei").value=2400;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=2400;
				}else{
					alert("�췿���4Mû��"+obj+"���ʷѲ�Ʒ");
				}
			}else if(document.getElementById("tfkuandaidaikuan").value=="8M"){
				if(obj==18){
					document.getElementById("tfkdczf").value=0;
					document.getElementById("tfkuandaifei").value=1600;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=1600;
				}else if(obj==36){
					document.getElementById("tfkdczf").value=0;
					document.getElementById("tfkuandaifei").value=3200;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=3200;
				}else{
					alert("�췿���8Mû��"+obj+"���ʷѲ�Ʒ");
				}
			}
		}
		}
	
	
	//������Ӫ��ҵ���ʷ�����
	function qtzfselect(objs){
	//	alert("-s-s---s"+document.getElementById("tfkuandaidaikuan").value);
		//document.getElementById("heji").value=="0";
		obj=objs.value;
		//alert(document.getElementById("tfkdnianxian").value);
		if(document.getElementById("qtye").value=="0"){
			//document.getElementById("qtye").focus();//���ý���
		}
		else{
			if(document.getElementById("qtye").value=="�̻�ҵ��") {
				if(obj=="�¸�"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="Ԥ��һ��"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="Ԥ������"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="����Ʒ2M") {
				if(obj=="�¸�"){
					document.getElementById("fufei").value=80;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="Ԥ��һ��"){
					document.getElementById("fufei").value=800;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="Ԥ������"){
					document.getElementById("fufei").value=1440;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="����Ʒ4M") {
				if(obj=="�¸�"){
					document.getElementById("fufei").value=100;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="Ԥ��һ��"){
					document.getElementById("fufei").value=1000;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="Ԥ������"){
					document.getElementById("fufei").value=1800;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="����Ʒ8M") {
				if(obj=="�¸�"){
					document.getElementById("fufei").value=140;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="Ԥ��һ��"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="Ԥ������"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="e8-88��2M��") {
				if(obj=="�¸�"){
					document.getElementById("fufei").value=88;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="Ԥ��һ��"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="Ԥ������"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="e8-108��4M��") {
				if(obj=="�¸�"){
					document.getElementById("fufei").value=108;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="Ԥ��һ��"){
					document.getElementById("fufei").value=1080;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="Ԥ������"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="e9-109��2M��") {
				if(obj=="�¸�"){
					document.getElementById("fufei").value=109;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="Ԥ��һ��"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="Ԥ������"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="e9-139��4M��") {
				if(obj=="�¸�"){
					document.getElementById("fufei").value=139;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="Ԥ��һ��"){
					document.getElementById("fufei").value=1390;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="Ԥ������"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
					
		}
	}
	
	//�ײͶ�Ӧ������Ӫ��ҵ���ʷ�����
	function taocanselect(objs){
	//	alert("-s-s---s"+document.getElementById("tfkuandaidaikuan").value);
		//document.getElementById("heji").value=="0";
		obj=objs.value;
		//alert(document.getElementById("tfkdnianxian").value);
		if(document.getElementById("fufeitype").value=="0"){
			//document.getElementById("fufeitype").focus();//���ý���
		}
		else{
			if(document.getElementById("fufeitype").value=="�¸�") {
				if(obj=="�̻�ҵ��"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="����Ʒ2M"){
					document.getElementById("fufei").value=80;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="����Ʒ4M"){
					document.getElementById("fufei").value=100;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="����Ʒ8M"){
					document.getElementById("fufei").value=140;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e8-88��2M��"){
					document.getElementById("fufei").value=88;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e8-108��4M��"){
					document.getElementById("fufei").value=108;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e9-109��2M��"){
					document.getElementById("fufei").value=109;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e9-139��4M��"){
					document.getElementById("fufei").value=139;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("fufeitype").value=="Ԥ��һ��") {
				if(obj=="�̻�ҵ��"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="����Ʒ2M"){
					document.getElementById("fufei").value=800;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="����Ʒ4M"){
					document.getElementById("fufei").value=1000;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="����Ʒ8M"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e8-88��2M��"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e8-108��4M��"){
					document.getElementById("fufei").value=1080;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e9-109��2M��"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e9-139��4M��"){
					document.getElementById("fufei").value=1390;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			
			if(document.getElementById("fufeitype").value=="Ԥ������") {
				if(obj=="�̻�ҵ��"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="����Ʒ2M"){
					document.getElementById("fufei").value=1440;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="����Ʒ4M"){
					document.getElementById("fufei").value=1800;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="����Ʒ8M"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e8-88��2M��"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e8-108��4M��"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e9-109��2M��"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e9-139��4M��"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
					
		}
	}

	//����tftv
	ipshichangchange = function(objs){
	//	alert(document.getElementById("zhengjian").checked)
	document.getElementById("heji").value=="0";
		var obj = objs.value;
		var tfiptvshuliang = document.getElementById("tfiptvshuliang").value
		if(tfiptvshuliang=="0"){
			alert("��ѡ��������");
			return false;
			}
		else if(tfiptvshuliang=="һ������"){
			document.getElementById("tfiptvshoushifei").value=240*obj;

			document.getElementById("shoushifei").value=240*obj;
			if(document.getElementById("zhengjian").checked==true){
				document.getElementById("tfjidingheyajin").value=100;

				document.getElementById("jidinghe").value=100;
				}
			else{
				document.getElementById("tfjidingheyajin").value=400;

				document.getElementById("jidinghe").value=400;
				}
			}
		else {
			if (tfiptvshuliang=="����") {
				return;
			} else if (tfiptvshuliang=="��������") {
				return;
			} else if (tfiptvshuliang=="��������") {
				return;
			} else if (tfiptvshuliang=="�ĸ�����") {
				return;
			}
			var s = 0;
			if (tfiptvshuliang=="��������") {
				s = 1;
			} else if (tfiptvshuliang=="��������") {
				s = 2;
			} else if (tfiptvshuliang=="�ĸ�����") {
				s = 3;
			}
			
			//alert("s"+s);
				document.getElementById("tfiptvshoushifei").value=(240+120*s)*obj;

				document.getElementById("shoushifei").value=(240+120*s)*obj;
				
				if(document.getElementById("zhengjian").checked==true){
					document.getElementById("tfjidingheyajin").value=100+400*s;

					document.getElementById("jidinghe").value=100+400*s;
					}
				else{
					document.getElementById("tfjidingheyajin").value=400+400*s;

					document.getElementById("jidinghe").value=400+400*s;
					}
				}
		}
	
	//���
	cleartfiptv = function(){
		document.getElementById("tfiptvshichang").value="0";
		document.getElementById("tfiptvshoushifei").value="0";
		document.getElementById("tfjidingheyajin").value="0";

		document.getElementById("shoushifei").value="0";
		document.getElementById("jidinghe").value="0";

		document.getElementById("heji").value=="";
		}

	
	hj=function(){
		if(hejicheck()){
			heji();
		}
	}
	
	hejicheck = function(){
	var obj=document.getElementById("xiaoquname").value;
		
		if(obj.value=="������԰"||obj.value=="������"||obj.value=="������Ԣ"){
			if(document.getElementById("jiaohuanji").value==""){
				alert("��ѡ�񽻻���Ѻ��");
				return false;
			}
		}else{
			if(document.getElementById("onu").value==""){
				alert("��ѡ��onuѺ��");
				return false;
			}
		}
			
	}
	//�ϼ�
	heji=function(){
		
	document.getElementById("heji").value=
	parseInt(document.getElementById("onu").value)+
	parseInt(document.getElementById("shoushifei").value)+
	parseInt(document.getElementById("jidinghe").value)+
	parseInt(document.getElementById("jiaohuanji").value)+
	parseInt(document.getElementById("nianfei").value)+
	parseInt(document.getElementById("buzuyue").value)+
	parseInt(document.getElementById("chuzhuangfei").value)+
	parseInt(document.getElementById("shebeixiaoshou").value)+
	parseInt(document.getElementById("cailiaofei").value)+
	parseInt(document.getElementById("kuaidaifei").value);
		}

	function isture(obj){
		if(!ismenhao(obj.value)){
			alert("��������ȷ�ĵ�ַ��ʽ�����磺11-1-1111 ���� 11-11 ���� 11-1-����");
			//document.getElementById("userplace").focus();
			document.forms[0].userplace.focus();
			return false;
			}
		}
	
	function ismenhao(value) {
		//alert(value);
		//alert(/^\d{2}-\d{1}-\d{4}$/.test(value))
		//return /^\d{2}-\d{1}-\d{4}$/.test(value);
		var a = /^[a-z0-9]{2}-[a-z0-9]{1}-[a-z0-9]{4}$/.test(value);
		var b = /^[a-z0-9]{2}-[a-z0-9]{2}$/.test(value);
		var c = /^[a-z0-9]{2}-[a-z0-9]{1}-����$/.test(value);
		
		return a||b||c;
	}

	//�û��绰��֤(�绰/�ֻ�)
	function istel(value){
		return /(^\d{8}$)|(^\d{11}$)/.test(value);
		} 
	//������ onu ��ʾ
	function selectxiaoqu(obj){
		//if(obj.value=="������԰"||obj.value=="������"||obj.value=="������Ԣ"){
		//	document.getElementById("jiaohuanjiid").style.display="";
		//	document.getElementById("onu").value="0";
		//	document.getElementById("onutd").style.display="none";
		//	}else{
		//		document.getElementById("jiaohuanji").value="0";
		//		document.getElementById("jiaohuanjiid").style.display="none";
		//		document.getElementById("onutd").style.display="";
		//		}
		} 

	//��֤����
	isDigit = function (str) {
		var patrn=/^\d+$/;
		return patrn.test(str);
		}
	
	//���ó�װ���ܶ�
	function dxchuzhuangfeichange(obj){
		
		document.getElementById("chuzhuangfei").value=
			parseInt(document.getElementById("yijifei").value)+parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
		}

	function setvalueschuzhuangfei(onj){
		if(onj.value==''){
			onj.value=0;
		}
		
		document.getElementById("chuzhuangfei").value=
			parseInt(document.getElementById("yijifei").value)+parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
		}
	
	//��װ��
	setvalues = function(obj,id){
		if(obj.value==''){
			obj.value=0;
		}
		document.getElementById(id).value=obj.value;
		}
	
	
	
	
//******************************************************************�����첽����
	function createXMLHttpRequest() {
		if (window.XMLHttpRequest) { //Mozilla �����
			XMLHttpReq = new XMLHttpRequest();
		} else {
			if (window.ActiveXObject) { // IE�����			
				try {
						XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
					} 
				catch (e) {
						try {
							XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
						} 
						catch (e){}
					}
			}
		}
	}
	//��������
	function sendRequest(url, params, method) {
		if (method) {
			if (method.toLowerCase("post")) {
				sendRequestPost(url, params);
			} else {
				if (method.toLowerCase("get")) {
					sendRequestGet(url + "?" + params);
				} else {
				}
			}
		} else {
			alert("\u63d0\u4ea4\u65b9\u5f0f\u4e0d\u80fd\u4e3a\u7a7a\uff01");
		}
	}
	//post����������
	function sendRequestPost(url, params) {
		params=encodeURI(params); 
        params=encodeURI(params);  
		createXMLHttpRequest();
		XMLHttpReq.open("POST", url, true);
		XMLHttpReq.onreadystatechange = processResponse;//ָ����Ӧ����
		XMLHttpReq.setRequestHeader("Content-Type" , "application/x-www-form-urlencoded ; charset=GBK");
		XMLHttpReq.send(params); // ��������
	}
	//get����������
	function sendRequestGet(url) {
		createXMLHttpRequest();
		XMLHttpReq.open("GET", url, true);
		XMLHttpReq.onreadystatechange = processResponse;//ָ����Ӧ����
		XMLHttpReq.send(null); // ��������
	}
	//post����������(���贫�ݲ���ʱ)
	function sendRequestPostwihtnoArgs(url) {
		createXMLHttpRequest();
		XMLHttpReq.open("POST", url, true);
		XMLHttpReq.onreadystatechange = processResponse;//ָ���ص�����
		XMLHttpReq.send(null); // ��������
	}
	// ��������Ϣ����
	function processResponse() {
		if (XMLHttpReq.readyState == 4) { // �ж϶���״̬
			if (XMLHttpReq.status == 200) { //��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
					/* var res = XMLHttpReq.responseText;
					if(res.length < 1){
						return;
					} */
					var res = XMLHttpReq.responseText;
					Select = document.forms[0].tfkdnianxian;
					for (var i = Select.length; i >= 0 ; i--) {
						Select.options[i] = null;
					}
					var s = res.indexOf(",",0);
					Select.options[Select.options.length] = new Option ("��ѡ��","0");
					while(s>-1){
						var shichang =res.substring(0,s);
			 			res = res.substring(s+1,res.length);
						Select.options[Select.options.length] = new Option (shichang,shichang);
						s = res.indexOf(",",0);
					}
					Select.options[Select.options.length] = new Option (res,res);
					
					
				} 
			} else { 
				//ҳ�治����
				/* var content=document.getElementById("ul1");
				for (var i=content.childNodes.length-1 ; i>=0 ; i--) {
					var childNode = content.childNodes[i];
					content.removeChild(childNode);
				}  */
			}
		}
	function findStubyClasslId() {
		var shichangleixing = document.forms[0].shichangleixing.value;
		var tfkuandaidaikuan = document.forms[0].tfkuandaidaikuan.value;
		//if(shichangleixing != "" || tfkuandaidaikuan!=""){
			var sURL = "allStu.do?act=getDaikuan";
			var method = "post";
			var sParams = "shichangleixing=" + shichangleixing + "&tfkuandaidaikuan=" + tfkuandaidaikuan;
			sendRequest(sURL, sParams, method);
	 
}
	
	
	
	
	
	
	
	
	
	