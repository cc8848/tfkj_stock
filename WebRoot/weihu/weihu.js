
function removeData1(){
	if(checkSelect("UUID","��ѡ��Ҫɾ����ʱ����Ϣ")){
		confirmRemove1();
	}
}
function confirmRemove1(){
	showConfirm('ȷ��Ҫɾ������ʱ����Ϣ��',removeCallback1);
}
function removeCallback1(v,m,f){
	if(v){
		document.forms[0].action = "shichangEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}

function removeData3(){
	if(checkSelect("UUID","��ѡ��Ҫɾ����Ϣ")){
		confirmRemove3();
	}
}
function confirmRemove3(){
	showConfirm('ȷ��Ҫɾ��������Ϣ��',removeCallback3);
}
function removeCallback3(v,m,f){
	if(v){
		document.forms[0].action = "dianshiEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}

function removeQuyuData(){
	if(checkSelect("UUID","��ѡ��Ҫɾ����ʱ����Ϣ")){
		confirmQuyuRemove();
	}
}
function confirmQuyuRemove(){
	showConfirm('ȷ��Ҫɾ������������Ϣ��',removeQuyuCallback);
}
function removeQuyuCallback(v,m,f){
	if(v){
		document.forms[0].action = "quyuweihuEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}

function removeXiaoquData(){
	if(checkSelect("UUID","��ѡ��Ҫɾ����С����Ϣ")){
		confirmXiaoquRemove();
	}
}
function confirmXiaoquRemove(){
	showConfirm('ȷ��Ҫɾ������ʱ����Ϣ��',removeXiaoquCallback);
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
			alert("���ӷ����������֣�");
			document.forms[0].shoushifei.focus();//���ý���
			return false;
			}
	}
	*/
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



function shenhe(){
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
	}
}