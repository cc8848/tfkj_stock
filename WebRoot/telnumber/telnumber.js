//ɾ��
function removeData(){
	if(checkSelect("UUID","��ѡ���ɾ���绰����")){
		confirmRemove();
	}
}
//ɾ��ȷ��
function confirmRemove(){
	showConfirm('ȷ��Ҫɾ��ѡ���ĵ绰����.',removeCallback);
}
//ɾ������
function removeCallback(v,m,f){
	if(v){
		document.forms[0].action = "telNumEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}
