//ɾ��
function removeData(){
	if(checkSelect("employeeCode","��ѡ���ɾ������Ա")){
		confirmRemove();
	}
}
//ɾ��ȷ��
function confirmRemove(){
	showConfirm('ȷ��Ҫɾ��ѡ������Ա.',removeCallback);
}
//ɾ������
function removeCallback(v,m,f){
	if(v){
		document.forms[0].action = "employeeEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}