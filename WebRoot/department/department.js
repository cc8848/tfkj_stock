//删除
function removeData(){
	if(checkSelect("departmentCode","请选择待删除的派工单")){
		confirmRemove();
	}
}
//删除确认
function confirmRemove(){
	showConfirm('确定要删除选定的派工单.',removeCallback);
}
//删除操作
function removeCallback(v,m,f){
	if(v){
		document.forms[0].action = "departmentEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}