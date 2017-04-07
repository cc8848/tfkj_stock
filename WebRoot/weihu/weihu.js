
function removeData1(){
	if(checkSelect("UUID","请选择要删除的时长信息")){
		confirmRemove1();
	}
}
function confirmRemove1(){
	showConfirm('确定要删除此条时长信息吗！',removeCallback1);
}
function removeCallback1(v,m,f){
	if(v){
		document.forms[0].action = "shichangEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}

function removeData3(){
	if(checkSelect("UUID","请选择要删除信息")){
		confirmRemove3();
	}
}
function confirmRemove3(){
	showConfirm('确定要删除此条信息吗！',removeCallback3);
}
function removeCallback3(v,m,f){
	if(v){
		document.forms[0].action = "dianshiEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}

function removeQuyuData(){
	if(checkSelect("UUID","请选择要删除的时长信息")){
		confirmQuyuRemove();
	}
}
function confirmQuyuRemove(){
	showConfirm('确定要删除此条区域信息吗！',removeQuyuCallback);
}
function removeQuyuCallback(v,m,f){
	if(v){
		document.forms[0].action = "quyuweihuEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}

function removeXiaoquData(){
	if(checkSelect("UUID","请选择要删除的小区信息")){
		confirmXiaoquRemove();
	}
}
function confirmXiaoquRemove(){
	showConfirm('确定要删除此条时长信息吗！',removeXiaoquCallback);
}
function removeXiaoquCallback(v,m,f){
	if(v){
		document.forms[0].action = "xiaoquEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}



function removeData2(){
	/*//var hedui = document.getElementById('${line.id}');
	if(shoushifei!="")
	{
		if(isNaN(shoushifei)){
			alert("收视费请输入数字！");
			document.forms[0].shoushifei.focus();//设置焦点
			return false;
			}
	}
	*/
	if(checkSelect("UUID","请选择要删除的信息")){
		confirmRemove2();
	}
}
function confirmRemove2(){
	showConfirm('确定要删除此条待已匹配信息!',removeCallback2);
}
function removeCallback2(v,m,f){
	 var uuid = document.all.UUID;
	 for(var i = 0 ; i < uuid.length ; i++)
	 {       
       	 if(uuid[i].checked)
       	 {         
            md=uuid.UUID[i];
            var shenhe = document.getElementById(md.value).innerText;
            shenhe = trim(shenhe);
            if(shenhe=="已核对")
            {
            	alert("已核对账目信息不能删除！");
            	v=false;
            }
         }
     }
	if(v){
		document.forms[0].action = "editeAccountsMateList.do?act=yipipeiDelete";
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
	showConfirm('确定要录入缴费吗.',removeCallbackshenhe);
}
function removeCallbackshenhe(v,m,f){
	if(v){
		document.forms[0].action = "daijiaoFeidataImport.do?act=daijiaofeiImport";
		disableAll(document);
		document.forms[0].submit();
	}
}