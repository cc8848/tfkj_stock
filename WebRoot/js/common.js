//document.oncontextmenu = function mouseRight(){
//	event.returnValue=false;//��������Ҽ�
//}
//document.onkeydown = function onKeyDown() {
//	if (event.keyCode == 13) {
//		doSubmit();
//	}	
//};
var interval; //���
//�Ŵ�
function showHiddenDiv(){
	$("#queryHidden").slideDown("slow");
	$(".btnSlideDown").hide("slow");
	$(".btnSlideUp").show("slow");
}
function hiddenHiddenDiv(){
	$("#queryHidden").slideUp("slow");
	$(".btnSlideUp").hide("slow");
	$(".btnSlideDown").show("slow");
}
// ����һ����Ϣ�Ի���.
function infoMessage(text){
	$.prompt(text_info(text),{buttons:{'ȷ��':true}});
}
// ��װ��Ϣ��Ϣ�ı�.
function text_info(text){
	return "<table><tr><td><img src='img/information.png'></td><td valign='middle'><B>" + text + "</B></td></tr></table>";
}
// ����һ������Ի���.
function wrongMessage(text){
	$.prompt(text_wrong(text),{buttons:{'ȷ��':true}});
}
// ��װ������Ϣ�ı�.
function text_wrong(text){
	return "<table><tr><td><img src='img/information.png'></td><td valign='middle'><B>" + text + "</B></td></tr></table>";
}
// ����һ��ѯ�ʶԻ���.
function showConfirm(text,callbackfunc){
	$.prompt(message(text),{buttons:{'ȷ��':true,'ȡ��':false},callback:callbackfunc,focus:1});
}
// ��װѯ�ʶԻ�����Ϣ�ı�.
function message(text){
	return "<table><tr><td><img src='img/confirm.png'></td><td valign='middle'><B>" + text + "</B></td></tr></table>";
}
//
function keyDownCheck(){
var keyCode = window.event.keyCode;
	if(keyCode == 13){
		return false;
	}
	return true;
}

// ��õ�ǰѡ�е����κ�.
function getRemarksBatchCode(){
	var batchCode = document.getElementsByName("batchCode");
		for(var i=0;i<batchCode.length;i++){
			if(batchCode[i].checked){
				return batchCode[i].value;
			}
		}
}

// ���URL��д�ַ���.
function getRewriteURL(elementIds){
	var retStr = "";
	var idArray = elementIds.split(",");
	for(var i = 0; i < idArray.length; i++){
		var id = idArray[i];
		retStr += id;
		retStr += "=";
		retStr += encodeURI(document.getElementById(id).value);
		retStr += "&";
	}
	return retStr.substring(0, retStr.length-1);
}

function changeTextFiledStyle(obj,flg){

	if(flg == "blur"){
		obj.className="commonTextFieldHover";
	}else if(flg == "focus"){
		obj.className='commonTextFieldMove';
	}
}

