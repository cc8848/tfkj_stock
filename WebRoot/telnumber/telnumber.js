//删除
function removeData(){
	if(checkSelect("UUID","请选择待删除电话号码")){
		confirmRemove();
	}
}
//删除确认
function confirmRemove(){
	showConfirm('确定要删除选定的电话号码.',removeCallback);
}
//删除操作
function removeCallback(v,m,f){
	if(v){
		document.forms[0].action = "telNumEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}
