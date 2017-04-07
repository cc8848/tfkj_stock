// ������Ϣ���

function cascadeInfo(objId,className){
	// ȡ��Դ�ؼ�������ֵ������.
	var obj = document.getElementById(objId);
	var objName = objId;
	var objCode = obj.value;
	// ����Դ�ؼ�������ֵ������Դ������ƹ�������.
	var param = "act=call&code=" + objCode + "&className=" + className;
	// �����Ƿ񷵻���Ч���ݵı�ʶ��false��ʾ��Ч.
	var flag = false;
	// �첽���ù�ͨ�������շ��ص�XML���ݼ�������������.
	$.ajax({ 
		type: "POST",
		url: "async.do",
		data: param,
		dataType:"xml",
		// �ɹ����صĴ���.
		success: function(xml){
			// ����XML��result�ڵ�.
			$(xml).find('result').each(function(){
				// ����flag��ʶΪtrue����ʾ������Ч����.
				flag = true;
				// ���ݽ�����ļ�ֵ���ɶ���������ڸö���.����ô����Ŀ�������ı�Ϊ������Ľڵ��ı�.
				var spanObj = document.getElementById(objName + "." + $(this).attr("key"));
				if(spanObj != null){
					spanObj.innerHTML = $(this).text();
				}
			});
			// ���û����Ч�����ݽ�ִ�����´���.
			if(!flag){
				// ѭ��BODY�µ�����SPAN��ǩ.
				$("body").find("span").each(function(){
					// �жϵ�ǰSPAN�Ƿ�Ϊ����Դ����������.
					if(objName == $(this).attr("id").substr(0,objName.length)){
						// ���һ�£���ô��û���ҵ�����Դ������½��˱�ǩ���ı�����Ϊ��.
						$(this).text("");
					}
				});
			}
		},
		// ���󷵻صĴ���.
		error: function(xml){
		}
	}); 
}