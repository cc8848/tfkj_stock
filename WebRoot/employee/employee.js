//删除
function removeData(){
	if(checkSelect("employeeCode","请选择待删除的人员")){
		confirmRemove();
	}
}
//删除确认
function confirmRemove(){
	showConfirm('确定要删除选定的人员.',removeCallback);
}
//删除操作
function removeCallback(v,m,f){
	if(v){
		document.forms[0].action = "employeeEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}