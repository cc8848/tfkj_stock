

function removeData2(){
	if(checkSelect("UUID","��ѡ��Ҫɾ���Ĵ��ɷ���Ϣ")){
		confirmRemove2();
	}
}
function confirmRemove2(){
	showConfirm('ȷ��Ҫɾ���������ɷ���Ϣ.',removeCallback2);
}
function removeCallback2(v,m,f){
	if(v){
		if(deletecheck("UUID")) {
				return false;
		}
		document.forms[0].action = "daijiaoFeidataImport.do?act=daijiaofeiDelete";
		disableAll(document);
		document.forms[0].submit();
	}
}



function removeData3(){
	if(checkSelect("UUIDS","��ѡ��Ҫɾ���Ĵ�ά����Ϣ")){
		confirmRemove3();
	}
}
function confirmRemove3(){
	showConfirm('ȷ��Ҫɾ����Щ��ά����Ϣ.',removeCallback3);
}
function removeCallback3(v,m,f){
	if(v){
		if(deletecheck("UUIDS")) {
			return false;
		}
		document.forms[0].action = "daijiaoFeidataImport.do?act=daiweixiuDelete";
		disableAll(document);
		document.forms[0].submit();
	}
}


function shenhe(){
	if(checkSelect("UUID","��ѡ��Ҫ¼��Ľɷ���Ϣ")){
		confirmShenhe();
	}
}
function confirmShenhe(){
	showConfirm('ȷ��Ҫ¼��ɷ���Ϣ��.',removeCallbackshenhe);
}
function removeCallbackshenhe(v,m,f){
	if(v){
		document.forms[0].action = "daijiaoFeidataImport.do?act=daijiaofeiImport";
		disableAll(document);
		document.forms[0].submit();
	}
}



function shenhe1(){
	if(checkSelect("UUIDS","��ѡ��Ҫ¼���ά����Ϣ")){
		confirmShenhe1();
	}
}

function confirmShenhe1(){
	showConfirm('ȷ��Ҫ¼��ά����Ϣ��.',removeCallbackshenhe1);
}
function removeCallbackshenhe1(v,m,f){
	if(v){
		document.forms[0].action = "daijiaoFeidataImport.do?act=daiweixiuImport";
		disableAll(document);
		document.forms[0].submit();
	}
}

var tfids = "";
//create by ���˻�
function shenhe2(){
	if(checkSelect1("UUIDS","��ѡ��Ҫ�������Ϣ")){
		showConfirm('ȷ��Ҫ������Ϣ��.',chuli);
	}
}

function checkSelect1(code,msg){
	var c = document.getElementsByName(code);
	tfids = "";
	for(var i=0;i<c.length;i++){
		if(c[i].checked){
			tfids += $(c[i]).val() + ",";
		}
	}
	if(tfids.length > 1) {
		tfids = tfids.substring(0, tfids.length - 1);
		return true;
	}
	infoMessage(msg);
	return false;
}

function chuli(v,m,f){
	
	if(v){
		document.forms[0].action = "daijiaoFeidataImport.do?act=daoxiugai&tfids=" + tfids;
		disableAll(document);
		document.forms[0].submit();
	}
}


function removeData4(){
	if(chuli1("UUIDS","��ѡ��Ҫɾ������Ϣ")){
		showConfirm('ȷ��Ҫ������Ϣ��.',chuli2);
	}
}
function chuli1(code,msg){
	var c = document.getElementsByName(code);
	tfids = "";
	for(var i=0;i<c.length;i++){
		if(c[i].checked){
			tfids += $(c[i]).val() + ",";
		}
	}
	if(tfids.length > 1) {
		tfids = tfids.substring(0, tfids.length - 1);
		return true;
	}
	infoMessage(msg);
	return false;
}
function chuli2(v,m,f){
	if(v){
		document.forms[0].action = "daijiaoFeidataImport.do?act=operateDel&tfids=" + tfids;
		disableAll(document);
		document.forms[0].submit();
	}
}
