//��ʼ��div��
$(document).ready(function() {
var times = 0;
	// ���� 
	if(getLegitimate("departmentCode")){
		var highlightindex = -1;
		var wordInputObJ = $(document.getElementsByName("departmentCode"));
		var src = 1;
		var auto = $("#autoDepartmentCode");
		var height = 20;
		var top = wordInputObJ.offset().top;
		if(top > 80){
			height = 3;
		}
		autoComplete(highlightindex,wordInputObJ,src,height,auto);
	}
	if(getLegitimate("departmentCodeCond")){
		var highlightindex = -1;
		var wordInputObJ = $(document.getElementsByName("departmentCodeCond"));
		var src = 1;
		var auto = $("#autoDepartmentCode");
		var height = 20;
		autoComplete(highlightindex,wordInputObJ,src,height,auto);
	}
	
	// ��Ա
	if(getLegitimate("employeeCode")){
		var highlightindex = -1;
		var wordInputObJ = $(document.getElementsByName("employeeCode"));
		var src = 2;
		var auto = $("#autoEmployeeCode");
		var height = 20;
		var top = wordInputObJ.offset().top;
		if(top > 80){
			height = 3;
		}
		autoComplete(highlightindex,wordInputObJ,src,height,auto);
	}
	if(getLegitimate("employeeCodeCond")){
		var highlightindex = -1;
		var wordInputObJ = $(document.getElementsByName("employeeCodeCond"));
		var src = 2;
		var auto = $("#autoEmployeeCode");
		var height = 20;
		autoComplete(highlightindex,wordInputObJ,src,height,auto);
	}
})
function autoComplete(highlightindex,wordInputObJ,src,height,auto){
    var wordInputOffset = wordInputObJ.position();
	var wordWidth = getTextWidth(wordInputObJ.width())
    auto.hide().css("background","#ffffff").css("border-right","#525252 2px solid").css("border-top","#525252 2px solid")
            .css("border-left","#525252 2px solid").css("border-bottom","#525252 2px solid")
            .css("position","absolute").css("text-align","left").css("cursor","default")
            .css("top",wordInputOffset.top + height + "px")
            .css("left",wordInputOffset.left + "px").width(wordInputObJ.width() + wordWidth);
    //���ı�����Ӽ��̰��²�������¼�
    wordInputObJ.keyup(function(event) {
    	
        //�����ı����еļ����¼�
        var myEvent = event || window.event;
        var keyCode = myEvent.keyCode;
        //�жϼ�λ
        if (keyCode >= 48 && keyCode <= 87 || keyCode == 8 || keyCode == 46 
        	|| keyCode == 27 ||keyCode >= 96 && keyCode <= 111) {
            //��ȡ�ı����е�����
            var wordInputVal = wordInputObJ.val();
            if(wordInputVal.replace("%","").replace("&","") != wordInputVal){
           		auto.hide();
            	return ;
            }
            var autoNode = auto;
            if (wordInputVal != "") {
                //���ı����е����ݷ��͸���������
                 $.ajax({type:"POST",url:"autoComplete.do?act=autoCode&code=" + wordInputVal+"&src=" + src,
				   dataType: "json",success:  function (data){ 
					   autoNode.html("");
					   //��װ����
					   for(var i=0;i<data.resultList.length;i++){
					   var newDivNode = $("<div id=" +i+ ">");
						   if(i%2 != 0){
						  		newDivNode.html(data.resultList[i].list).appendTo(autoNode).css("background-color","#E8E8E8");
						 	}else{
						 		newDivNode.html(data.resultList[i].list).appendTo(autoNode).css("background-color","#FFFFFF");
						 	} 
						 //������
                   		newDivNode.mouseover(function(){
	                        if(highlightindex != -1){
		                        if(highlightindex%2!=0){
			                    	auto.children("div").eq(highlightindex).css("background-color","#E8E8E8").css("font-size","12").css("font-weight","normal");
			                    }else{
			                    	auto.children("div").eq(highlightindex).css("background-color","#FFFFFF").css("font-size","12").css("font-weight","normal");
		                    	}
	                        }
	                        highlightindex = $(this).attr("id");
	                        $(this).css("background-color","#3399FF").css("font-size","12").css("font-weight","bold");
	                    });
	                     //����Ƴ�
	                    newDivNode.mouseout(function(){
	                   		if(highlightindex%2!=0){
		                    	auto.children("div").eq(highlightindex).css("background-color","#E8E8E8").css("font-size","12").css("font-weight","normal");
		                    }else{
		                    	auto.children("div").eq(highlightindex).css("background-color","#FFFFFF").css("font-size","12").css("font-weight","normal");
	                    	}
	                    });
	                   //�����
	                    newDivNode.click(function(){
	                        var comText = $(this).text().substring(0,12);
	                        auto.hide();
	                        highlightindex=-1;
	                        wordInputObJ.val(rtrim(comText));
	                    });
				  	   }
					 	if(data.resultList.length>0){
					    	autoNode.show();
					    }else{
					     autoNode.hide();
                       	 //���������ص�ͬʱ�������ڵ�����ֵҲ�Ƴ�-1
                       	 highlightindex = -1;
					    }
				  	 }
                })
            }else {
                autoNode.hide();
                highlightindex = -1;
            }
        } else if (keyCode == 38 || keyCode == 40) {
            //��������������38����40����
            if (keyCode == 38) {
                //����
                var autoNodes = auto.children("div")
                if (highlightindex != -1) {
                    //���ԭ�������������򽫱���ɫ�ĳ�ԭɫ
                    if(highlightindex%2!=0){
                    	autoNodes.eq(highlightindex).css("background-color","#E8E8E8").css("font-size","12").css("font-weight","normal");
                    }else{
                    	autoNodes.eq(highlightindex).css("background-color","#FFFFFF").css("font-size","12").css("font-weight","normal");
                    }
                    highlightindex--;
                } else {
                    highlightindex = autoNodes.length - 1;    
                }
                if (highlightindex == -1) {
                    //����޸�����ֵ�Ժ�index���-1��������ֵָ�����һ��Ԫ��
                    highlightindex = autoNodes.length - 1;
                }
                //�����ڸ��������ݱ����ɫ
                autoNodes.eq(highlightindex).css("background-color","#3399FF").css("font-size","12").css("font-weight","bold");
            }
            if (keyCode == 40) {
                //����
                var autoNodes = auto.children("div")
                if (highlightindex != -1) {
                    //���ԭ�������������򽫱���ɫ�ĳ�ԭɫ
                    if(highlightindex%2!=0){
                    	autoNodes.eq(highlightindex).css("background-color","#E8E8E8").css("font-size","12").css("font-weight","normal");
                    }else{
                    autoNodes.eq(highlightindex).css("background-color","#FFFFFF").css("font-size","12").css("font-weight","normal");
                    }
                }
                highlightindex++;
                if (highlightindex == autoNodes.length) {
                    //����޸�����ֵ�Ժ�index���-1��������ֵָ�����һ��Ԫ��
                    highlightindex = 0;
                }
                //�����ڸ��������ݱ����ɫ
                autoNodes.eq(highlightindex).css("background-color","#3399FF").css("font-size","12").css("font-weight","bold");
            }
        } else if (keyCode == 13) {
            //���������ǻس�
            //������������
            if (highlightindex != -1) {
                //ȡ�������ڵ���ı�����
                var comText = auto.hide().children("div").eq(highlightindex).text().substring(0,12);
                highlightindex = -1;
                //�ı����е����ݱ�ɸ����ڵ������
               wordInputObJ.val(rtrim(comText));
            }
        }
    });
}
function rtrim(s){
	var a = "";
	for(var i=0; i<s.length; i++){
		if(s.charCodeAt(i) != 160){
			a += s.substring(i,i+1); 
		}
	}
	return a;
	//return s.replace(/(\s*$)/g, "");
	}
function getLegitimate(bb){
	var aa = document.getElementsByName(bb);
		for(var i=0;i<aa.length;i++){ 
			if(aa[i].type == "text"){ 
				return true;
			} 
		}
	return false;
}
function getTextWidth(textWidth){
	var wordWidth;
    if(textWidth > 100){
   		wordWidth = 60;
    }else if(textWidth > 70 && textWidth < 100){
   		wordWidth = 90;
    }else if(textWidth < 70){
   		wordWidth = 120;
    }
    return wordWidth;
}