//ɾ��
function removeData(){
	if(checkSelect("UUID","��ѡ���ɾ����ԤԼ�ƻ�")){
		confirmRemove();
	}
}
//ɾ��ȷ��
function confirmRemove(){
	showConfirm('ȷ��Ҫɾ��ѡ����ԤԼ�ƻ�.',removeCallback);
}
//ɾ������
function removeCallback(v,m,f){
	if(v){
		document.forms[0].action = "yuyueEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}

function removeData2(){
	if(checkSelect("UUID","��ѡ��������ԤԼ�ƻ�")){
		confirmRemove2();
	}
}
function confirmRemove2(){
	showConfirm('ȷ��Ҫ����ѡ����ԤԼ�ƻ�.',removeCallback2);
}
function removeCallback2(v,m,f){
	if(v){
		document.forms[0].action = "yuyueEdit.do?act=dongjei";
		disableAll(document);
		document.forms[0].submit();
	}
}