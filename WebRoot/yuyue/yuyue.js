//删除
function removeData(){
	if(checkSelect("UUID","请选择待删除的预约计划")){
		confirmRemove();
	}
}
//删除确认
function confirmRemove(){
	showConfirm('确定要删除选定的预约计划.',removeCallback);
}
//删除操作
function removeCallback(v,m,f){
	if(v){
		document.forms[0].action = "yuyueEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}

function removeData2(){
	if(checkSelect("UUID","请选择待冻结的预约计划")){
		confirmRemove2();
	}
}
function confirmRemove2(){
	showConfirm('确定要冻结选定的预约计划.',removeCallback2);
}
function removeCallback2(v,m,f){
	if(v){
		document.forms[0].action = "yuyueEdit.do?act=dongjei";
		disableAll(document);
		document.forms[0].submit();
	}
}