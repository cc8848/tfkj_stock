function doSubmit(){
	var username = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	if(isNull(username)){
		infoMessage("�û�������Ϊ�գ�");
		return;
	}else if(isNull(password)){
		infoMessage("���벻��Ϊ�գ�");
		return;
	}

	document.forms[0].action = 'login.do?act=login';
	document.forms[0].submit();
}

function autoSubimit(){
	if (event.keyCode == 13) {
		doSubmit();
	}
}
