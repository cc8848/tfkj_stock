//ɾ��
function removeData(){
	if(checkSelect("departmentCode","��ѡ���ɾ�����ɹ���")){
		confirmRemove();
	}
}
//ɾ��ȷ��
function confirmRemove(){
	showConfirm('ȷ��Ҫɾ��ѡ�����ɹ���.',removeCallback);
}
//ɾ������
function removeCallback(v,m,f){
	if(v){
		document.forms[0].action = "departmentEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}