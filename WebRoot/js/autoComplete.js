//初始化div框
$(document).ready(function() {
var times = 0;
	// 部门 
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
	
	// 人员
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
    //给文本框添加键盘按下并弹起的事件
    wordInputObJ.keyup(function(event) {
    	
        //处理文本框中的键盘事件
        var myEvent = event || window.event;
        var keyCode = myEvent.keyCode;
        //判断键位
        if (keyCode >= 48 && keyCode <= 87 || keyCode == 8 || keyCode == 46 
        	|| keyCode == 27 ||keyCode >= 96 && keyCode <= 111) {
            //获取文本框中的内容
            var wordInputVal = wordInputObJ.val();
            if(wordInputVal.replace("%","").replace("&","") != wordInputVal){
           		auto.hide();
            	return ;
            }
            var autoNode = auto;
            if (wordInputVal != "") {
                //将文本框中的内容发送给服务器端
                 $.ajax({type:"POST",url:"autoComplete.do?act=autoCode&code=" + wordInputVal+"&src=" + src,
				   dataType: "json",success:  function (data){ 
					   autoNode.html("");
					   //封装数据
					   for(var i=0;i<data.resultList.length;i++){
					   var newDivNode = $("<div id=" +i+ ">");
						   if(i%2 != 0){
						  		newDivNode.html(data.resultList[i].list).appendTo(autoNode).css("background-color","#E8E8E8");
						 	}else{
						 		newDivNode.html(data.resultList[i].list).appendTo(autoNode).css("background-color","#FFFFFF");
						 	} 
						 //鼠标进入
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
	                     //鼠标移出
	                    newDivNode.mouseout(function(){
	                   		if(highlightindex%2!=0){
		                    	auto.children("div").eq(highlightindex).css("background-color","#E8E8E8").css("font-size","12").css("font-weight","normal");
		                    }else{
		                    	auto.children("div").eq(highlightindex).css("background-color","#FFFFFF").css("font-size","12").css("font-weight","normal");
	                    	}
	                    });
	                   //鼠标点击
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
                       	 //弹出框隐藏的同时，高亮节点索引值也制成-1
                       	 highlightindex = -1;
					    }
				  	 }
                })
            }else {
                autoNode.hide();
                highlightindex = -1;
            }
        } else if (keyCode == 38 || keyCode == 40) {
            //如果输入的是向上38向下40按键
            if (keyCode == 38) {
                //向上
                var autoNodes = auto.children("div")
                if (highlightindex != -1) {
                    //如果原来存在索引，则将背景色改成原色
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
                    //如果修改索引值以后index变成-1，则将索引值指向最后一个元素
                    highlightindex = autoNodes.length - 1;
                }
                //让现在高亮的内容变成蓝色
                autoNodes.eq(highlightindex).css("background-color","#3399FF").css("font-size","12").css("font-weight","bold");
            }
            if (keyCode == 40) {
                //向下
                var autoNodes = auto.children("div")
                if (highlightindex != -1) {
                    //如果原来存在索引，则将背景色改成原色
                    if(highlightindex%2!=0){
                    	autoNodes.eq(highlightindex).css("background-color","#E8E8E8").css("font-size","12").css("font-weight","normal");
                    }else{
                    autoNodes.eq(highlightindex).css("background-color","#FFFFFF").css("font-size","12").css("font-weight","normal");
                    }
                }
                highlightindex++;
                if (highlightindex == autoNodes.length) {
                    //如果修改索引值以后index变成-1，则将索引值指向最后一个元素
                    highlightindex = 0;
                }
                //让现在高亮的内容变成蓝色
                autoNodes.eq(highlightindex).css("background-color","#3399FF").css("font-size","12").css("font-weight","bold");
            }
        } else if (keyCode == 13) {
            //如果输入的是回车
            //下拉框有索引
            if (highlightindex != -1) {
                //取出高亮节点的文本内容
                var comText = auto.hide().children("div").eq(highlightindex).text().substring(0,12);
                highlightindex = -1;
                //文本框中的内容变成高亮节点的内容
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