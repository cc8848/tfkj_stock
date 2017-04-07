// 级联信息组件

function cascadeInfo(objId,className){
	// 取得源控件的输入值和名称.
	var obj = document.getElementById(objId);
	var objName = objId;
	var objCode = obj.value;
	// 根据源控件的输入值和数据源获得名称构建参数.
	var param = "act=call&code=" + objCode + "&className=" + className;
	// 声明是否返回有效数据的标识，false表示无效.
	var flag = false;
	// 异步调用共通处理，接收返回的XML数据集，并解析处理.
	$.ajax({ 
		type: "POST",
		url: "async.do",
		data: param,
		dataType:"xml",
		// 成功返回的处理.
		success: function(xml){
			// 遍历XML的result节点.
			$(xml).find('result').each(function(){
				// 设置flag标识为true，表示存在有效数据.
				flag = true;
				// 根据结果集的键值生成对象，如果存在该对象.，那么设置目标对象的文本为结果集的节点文本.
				var spanObj = document.getElementById(objName + "." + $(this).attr("key"));
				if(spanObj != null){
					spanObj.innerHTML = $(this).text();
				}
			});
			// 如果没有有效的数据将执行以下处理.
			if(!flag){
				// 循环BODY下的所有SPAN标签.
				$("body").find("span").each(function(){
					// 判断当前SPAN是否为输入源级联的子类.
					if(objName == $(this).attr("id").substr(0,objName.length)){
						// 如果一致，那么在没有找到数据源的情况下将此标签的文本设置为空.
						$(this).text("");
					}
				});
			}
		},
		// 错误返回的处理.
		error: function(xml){
		}
	}); 
}