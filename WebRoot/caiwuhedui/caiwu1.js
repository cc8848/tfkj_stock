
function removeData1(){
	if(checkSelect("zmUUID","��ѡ��Ҫɾ������Ŀ")){
		confirmRemove1();
	}
}
function confirmRemove1(){
	showConfirm('ȷ��Ҫɾ��������Ŀ��',removeCallback1);
}
function removeCallback1(v,m,f){
	if(v){
		document.forms[0].action = "editeAccountsMateList.do?act=zhangmuDelete";
		disableAll(document);
		document.forms[0].submit();
	}
}





function removeData2(){
	if(checkSelect("UUID","��ѡ��Ҫɾ������Ϣ")){
		confirmRemove2();
	}
}
function confirmRemove2(){
	showConfirm('ȷ��Ҫɾ����������ƥ����Ϣ!',removeCallback2);
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
            if(shenhe=="�Ѻ˶�")
            {
            	alert("�Ѻ˶���Ŀ��Ϣ����ɾ����");
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
	if(checkSelect("UUID","��ѡ��Ҫ¼��Ľɷ���Ϣ")){
		confirmShenhe();
	}
}
function confirmShenhe(){
	showConfirm('ȷ��Ҫ¼��ɷ���.',removeCallbackshenhe);
}
function removeCallbackshenhe(v,m,f){
	if(v){
		document.forms[0].action = "daijiaoFeidataImport.do?act=daijiaofeiImport";
		disableAll(document);
		document.forms[0].submit();
	}*/
