
function removeData1(){
	if(checkSelect("zmUUID","请选择要删除的账目")){
		confirmRemove1();
	}
}
function confirmRemove1(){
	showConfirm('确定要删除此条账目！',removeCallback1);
}
function removeCallback1(v,m,f){
	if(v){
		document.forms[0].action = "editeAccountsMateList.do?act=zhangmuDelete";
		disableAll(document);
		document.forms[0].submit();
	}
}





function removeData2(){
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



/*function shenhe(){
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
	}*/
