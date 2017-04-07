
function removeData(){
	if(checkSelect("UUIDS","请选择待指定的设备")){
		confirmRemove();
	}
}

function confirmRemove(){
	showConfirm('确定要指定所选设备？',removeCallback);
}

function removeCallback(v,m,f){
	if(v){
		document.forms[0].action = "bangding.do?act=bangding";
		disableAll(document);
		document.forms[0].submit();
	}
}