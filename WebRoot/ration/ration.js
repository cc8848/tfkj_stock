
function removeData(){
	if(checkSelect("UUIDS","��ѡ���ָ�����豸")){
		confirmRemove();
	}
}

function confirmRemove(){
	showConfirm('ȷ��Ҫָ����ѡ�豸��',removeCallback);
}

function removeCallback(v,m,f){
	if(v){
		document.forms[0].action = "bangding.do?act=bangding";
		disableAll(document);
		document.forms[0].submit();
	}
}