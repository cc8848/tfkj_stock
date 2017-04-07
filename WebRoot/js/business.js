
function commonSubmit(action){
	document.forms[0].action = action;
		disableAll(document);
	 	document.forms[0].submit();
}

function checkSelect(code,msg){
	var c = document.getElementsByName(code);
	
	for(var i=0;i<c.length;i++){
		if(c[i].checked){
			return true;
		}
	}
	infoMessage(msg);
	return false;
}

function commonCheckSubmit(action,code,msg){
	if(checkSelect(code,msg)){
		commonSubmit(action);
	}
}
function commonCheckSubmit2(action,code,msg){
	if(checkSelect2(code,msg)){
		commonSubmit(action);
	}
}
function checkSelect2(code,msg){
	var c = document.getElementsByName(code);
	var num=0;
	for(var i=0;i<c.length;i++){
		if(c[i].checked){
			num++;
		}
	}
	if(num>1){
		infoMessage("退单操作只能选择一条记录！");
		return false;
	}
	for(var i=0;i<c.length;i++){
		if(c[i].checked){
			return true;
		}
	}
	infoMessage(msg);
	return false;
}
function commonCheckSubmit1(action,code,msg){
	if(checkSelect(code,msg)){
		commonSubmit1(action);
	}
}
function commonSubmit1(action){
	var chukuplaceString = document.getElementById("chukuplaceString").value;
	var act = action+"&chukuplaceString="+encodeURI(encodeURI(chukuplaceString));
	document.forms[0].action = act;
		disableAll(document);
	 	document.forms[0].submit();
}