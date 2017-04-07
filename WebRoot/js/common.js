//document.oncontextmenu = function mouseRight(){
//	event.returnValue=false;//屏蔽鼠标右键
//}
//document.onkeydown = function onKeyDown() {
//	if (event.keyCode == 13) {
//		doSubmit();
//	}	
//};
var interval; //间隔
//放大
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
// 弹出一个信息对话框.
function infoMessage(text){
	$.prompt(text_info(text),{buttons:{'确认':true}});
}
// 封装信息消息文本.
function text_info(text){
	return "<table><tr><td><img src='img/information.png'></td><td valign='middle'><B>" + text + "</B></td></tr></table>";
}
// 弹出一个错误对话框.
function wrongMessage(text){
	$.prompt(text_wrong(text),{buttons:{'确认':true}});
}
// 封装错误消息文本.
function text_wrong(text){
	return "<table><tr><td><img src='img/information.png'></td><td valign='middle'><B>" + text + "</B></td></tr></table>";
}
// 弹出一个询问对话框.
function showConfirm(text,callbackfunc){
	$.prompt(message(text),{buttons:{'确认':true,'取消':false},callback:callbackfunc,focus:1});
}
// 封装询问对话框消息文本.
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

// 获得当前选中的批次号.
function getRemarksBatchCode(){
	var batchCode = document.getElementsByName("batchCode");
		for(var i=0;i<batchCode.length;i++){
			if(batchCode[i].checked){
				return batchCode[i].value;
			}
		}
}

// 获得URL重写字符串.
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

