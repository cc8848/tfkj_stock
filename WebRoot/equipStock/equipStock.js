//ɾ��
function removeData(){
	if(checkSelect("UUIDS","��ѡ���ɾ�����豸")){
		confirmRemove();
	}
}
//ɾ��ȷ��
function confirmRemove(){
	showConfirm('ȷ��Ҫɾ��ѡ�����豸��',removeCallback);
}
//ɾ������
function removeCallback(v,m,f){
	if(v){
		document.forms[0].action = "equipStockEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}