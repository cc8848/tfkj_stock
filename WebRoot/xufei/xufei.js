

function removeData2(){
	if(checkSelect("UUID","请选择要删除的待缴费信息")){
		confirmRemove2();
	}
}
function confirmRemove2(){
	showConfirm('确定要删除此条待缴费信息.',removeCallback2);
}
function removeCallback2(v,m,f){
	if(v){
		if(deletecheck("UUID")) {
				return false;
		}
		document.forms[0].action = "daijiaoFeidataImport.do?act=daijiaofeiDelete";
		disableAll(document);
		document.forms[0].submit();
	}
}



function removeData3(){
	if(checkSelect("UUIDS","请选择要删除的待维修信息")){
		confirmRemove3();
	}
}
function confirmRemove3(){
	showConfirm('确定要删除这些待维修信息.',removeCallback3);
}
function removeCallback3(v,m,f){
	if(v){
		if(deletecheck("UUIDS")) {
			return false;
		}
		document.forms[0].action = "daijiaoFeidataImport.do?act=daiweixiuDelete";
		disableAll(document);
		document.forms[0].submit();
	}
}


function shenhe(){
	if(checkSelect("UUID","请选择要录入的缴费信息")){
		confirmShenhe();
	}
}
function confirmShenhe(){
	showConfirm('确定要录入缴费信息吗.',removeCallbackshenhe);
}
function removeCallbackshenhe(v,m,f){
	if(v){
		document.forms[0].action = "daijiaoFeidataImport.do?act=daijiaofeiImport";
		disableAll(document);
		document.forms[0].submit();
	}
}



function shenhe1(){
	if(checkSelect("UUIDS","请选择要录入的维修信息")){
		confirmShenhe1();
	}
}

function confirmShenhe1(){
	showConfirm('确定要录入维修信息吗.',removeCallbackshenhe1);
}
function removeCallbackshenhe1(v,m,f){
	if(v){
		document.forms[0].action = "daijiaoFeidataImport.do?act=daiweixiuImport";
		disableAll(document);
		document.forms[0].submit();
	}
}

var tfids = "";
//create by 赵兴华
function shenhe2(){
	if(checkSelect1("UUIDS","请选择要处理的信息")){
		showConfirm('确定要处理信息吗.',chuli);
	}
}

function checkSelect1(code,msg){
	var c = document.getElementsByName(code);
	tfids = "";
	for(var i=0;i<c.length;i++){
		if(c[i].checked){
			tfids += $(c[i]).val() + ",";
		}
	}
	if(tfids.length > 1) {
		tfids = tfids.substring(0, tfids.length - 1);
		return true;
	}
	infoMessage(msg);
	return false;
}

function chuli(v,m,f){
	
	if(v){
		document.forms[0].action = "daijiaoFeidataImport.do?act=daoxiugai&tfids=" + tfids;
		disableAll(document);
		document.forms[0].submit();
	}
}


function removeData4(){
	if(chuli1("UUIDS","请选择要删除的信息")){
		showConfirm('确定要处理信息吗.',chuli2);
	}
}
function chuli1(code,msg){
	var c = document.getElementsByName(code);
	tfids = "";
	for(var i=0;i<c.length;i++){
		if(c[i].checked){
			tfids += $(c[i]).val() + ",";
		}
	}
	if(tfids.length > 1) {
		tfids = tfids.substring(0, tfids.length - 1);
		return true;
	}
	infoMessage(msg);
	return false;
}
function chuli2(v,m,f){
	if(v){
		document.forms[0].action = "daijiaoFeidataImport.do?act=operateDel&tfids=" + tfids;
		disableAll(document);
		document.forms[0].submit();
	}
}
