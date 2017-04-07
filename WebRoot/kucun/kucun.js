
function changeData(){
	if(checkSelect("UUIDS","请选择要删除的账目")){
		confirmChange();
	}
}
function confirmChange(){
	showConfirm('确定要修改状态吗？',removeCallback);
}
function removeCallback(v,m,f){
	if(v){
		document.forms[0].action = "shebeichuku.do?act=shebeiZTchange";
		disableAll(document);
		document.forms[0].submit();
	}
}

function deleteData(){
	if(checkSelect("UUIDS","请多选择要删除的设备信息！")){
		confirmChange1();
	}
}
function confirmChange1(){
	showConfirm('确定要删除吗？',removeCallback1);
}
function removeCallback1(v,m,f){
	if(v){
		document.forms[0].action ="shebeirukuList.do?act=deleteShebeiData";
		disableAll(document);
		document.forms[0].submit();
	}
}

function check_product() {
	var xianghao = document.forms[0].xianghao.value;
	if (xianghao == null || trim(xianghao) == "") {
		alert("箱号不能为空！");
		document.forms[0].xianghao.focus();// 设置焦点
		return false;
	}
	var rukuren = document.forms[0].rukuren.value;
	if (rukuren == null || trim(rukuren) == "") {
		alert("请选择入库人！");
		document.forms[0].rukuren.focus();// 设置焦点
		return false;
	}
	var shebeileixing = document.forms[0].shebeileixing.value;
	if (shebeileixing == null || trim(shebeileixing) == "") {
		alert("请输入设备类型！");
		document.forms[0].shebeileixing.focus();// 设置焦点
		return false;
	}
	var shebeixinghao = document.forms[0].shebeixinghao.value;
	if (shebeixinghao == null || trim(shebeixinghao) == "") {
		alert("请输入设备型号！");
		document.forms[0].shebeixinghao.focus();// 设置焦点
		return false;
	}
	var mac = document.forms[0].mac.value;
	if (mac == null || trim(mac) == "") {
		alert("请输入MAC！");
		document.forms[0].mac.focus();// 设置焦点
		return false;
	}
	var mcid = document.forms[0].mcid.value;
	if (mcid == null || trim(mcid) == "") {
		alert("请输入MCID！");
		document.forms[0].mcid.focus();// 设置焦点
		return false;
	}
	var beizhu = document.forms[0].beizhu.value;
	if (beizhu == null || trim(beizhu) == "") {
		alert("请输入备注信息！");
		document.forms[0].beizhu.focus();// 设置焦点
		return false;
	}

	return true;
}



function check(){
	var kaishi = document.forms[0].kaishi.value;
	var jieshu = document.forms[0].jieshu.value;
	if (trim(kaishi) == "" && trim(jieshu) == ""){
		return true;
	} else {
		if(!(trim(kaishi) == "")) {
			kaishi = /^\d{4}[-](\d{2})[-](\d{2})$/.test(kaishi);
			if (kaishi == false ) {
				alert("开始时间输入格式有误！");
				document.forms[0].kaishi.focus();// 设置焦点
				return false;
			}
		}

		if(!(trim(jieshu) == "")) {
			jieshu = /^\d{4}[-](\d{2})[-](\d{2})$/.test(jieshu);
			if (jieshu == false ) {
				alert("结束时间输入格式有误！");
				document.forms[0].jieshu.focus();// 设置焦点
				return false;
			}
		}
	}
	return true;
}
