function doSubmit(){
	var username = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	if(isNull(username)){
		infoMessage("用户名不能为空！");
		return;
	}else if(isNull(password)){
		infoMessage("密码不能为空！");
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
