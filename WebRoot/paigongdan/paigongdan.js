//删除
function removeData(){
	if(checkSelect("UUID","请选择待删除的派工单")){
		confirmRemove();
	}
}
//删除确认
function confirmRemove(){
	showConfirm('确定要删除选定的派工单？',removeCallback);
}
//删除操作
function removeCallback(v,m,f){
	if(v){
		if(deletecheck("UUID")) {
				return false;
		}
		document.forms[0].action = "paigongdanEdit.do?act=delete";
		disableAll(document);
		document.forms[0].submit();
	}
}

function removeData1(){
	if(checkSelect("UUID","请选择待解绑的派工单")){
		confirmRemove1();
	}
}
//删除确认
function confirmRemove1(){
	showConfirm('确定要解绑选定的派工单？',removeCallback1);
}
//删除操作
function removeCallback1(v,m,f){
	if(v){
		document.forms[0].action = "paigongdanEdit.do?act=jiebang";
		disableAll(document);
		document.forms[0].submit();
	}
}



//去除空格
String.prototype.trim = function () {
	return this .replace(/^\s\s*/, '' ).replace(/\s\s*$/, '' );
      }

function checkInput1(){
	var username = document.forms[0].username.value;
	if(username==null||trim(username)==""){
		alert("用户姓名不能为空！");
		document.forms[0].username.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].xiaoquname[0].value;
	var selectxiaoquhidden = document.forms[0].selectxiaoquhidden.value;
	if((xiaoquname==null||trim(xiaoquname)=="")&&(selectxiaoquhidden==null||trim(selectxiaoquhidden)=="")){
		alert("小区名称不能为空！");
		document.getElementById("xiaoquname").focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].userplace.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("用户地址不能为空！");
		document.forms[0].userplace.focus();//设置焦点
		return false;
		}
	if(!ismenhao(xiaoquname)){
		alert("请输入正确的地址格式！");
		//document.getElementById("userplace").focus();
		document.forms[0].userplace.focus();
		return false;
		}
	var xiaoquname = document.forms[0].usertel.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("用户联系电话不能为空！");
		document.forms[0].usertel.focus();//设置焦点
		return false;
		}
	
	var xiaoquname = document.forms[0].paigongriqi.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("派工日期不能为空！");
		document.forms[0].paigongriqi.focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].anzhuangshijian.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("上门安装时间不能为空！");
		document.forms[0].anzhuangshijian.focus();//设置焦点
		return false;
		}
	
	var xiaoquname = document.forms[0].xiangmu.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("项目不能为空");
		document.forms[0].xiangmu.focus();//设置焦点
		return false;
		}

	var tfkuandaidaikuan = document.forms[0].tfkuandaidaikuan.value;
	var qiegaidaikuan = document.forms[0].qiegaidaikuan.value;
	if((tfkuandaidaikuan==null||trim(tfkuandaidaikuan)=="")&&trim(qiegaidaikuan)==""){
		alert("带宽不能为空！如果无请填“0”");
		document.forms[0].tfkuandaidaikuan.focus();//设置焦点
		return false;
	}
	
	
	var tfkdnianxian = document.forms[0].tfkdnianxian.value;
	
	if (tfkdnianxian == 0 && tfkuandaidaikuan != 0){
		alert("带宽已经选择，请选择时长！");
		document.forms[0].tfkdnianxian.focus();//设置焦点
		return false;
	}
	
	if (tfkdnianxian != 0 && tfkuandaidaikuan==0){
		alert("时长已经选择，请选择带宽！");
		document.forms[0].tfkuandaidaikuan.focus();//设置焦点
		return false;
	}
	if(tfkdnianxian==null||trim(tfkdnianxian)==""){
		alert("时长不能为空！请选择正确的时长类型和带宽");
		document.forms[0].tfkdnianxian.focus();//设置焦点
		return false;
		}
	
	var xiaoquname = document.forms[0].tfiptv.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("IPTV不能为空！如果无请填“0”");
		document.forms[0].tfiptv.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].tfiptvnianxian.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("IPTV年限不能为空！如果无请填“0”");
		document.forms[0].tfiptvnianxian.focus();//设置焦点
		return false;
		}
	var yuyingshang = document.forms[0].yuyingshang.value;
	if(yuyingshang==null||trim(yuyingshang)=="0"){
		alert("运营商不能为空！");
		document.forms[0].yuyingshang.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].qtye.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("套餐不能为空！");
		document.forms[0].qtye.focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].dxchuzhuangfei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("初装费不能为空！");
		document.forms[0].dxchuzhuangfei.focus();//设置焦点
		return false;
		}
	
	var xiaoquname = document.forms[0].fufei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("年付不能为空！如果无请填“0”");
		document.forms[0].fufei.focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].telhaoma1.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("号码一不能为空！如果无请填“0000000”");
		document.forms[0].telhaoma1.focus();//设置焦点
		return false;
		}
	if(!istel(xiaoquname)){
		alert("电话格式不正确");
		document.forms[0].telhaoma1.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].telhaoma2.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("号码二不能为空！如果无请填“0000000”");
		document.forms[0].telhaoma2.focus();//设置焦点
		return false;
		}
	
	if(!istel(xiaoquname)){
		alert("电话格式不正确");
		document.forms[0].telhaoma2.focus();//设置焦点
		return false;
		}
	document.forms[0].telhaoma1.value = trim(document.forms[0].telhaoma1.value);
	document.forms[0].telhaoma2.value = trim(document.forms[0].telhaoma2.value);
	document.forms[0].telhaoma3.value = trim(document.forms[0].telhaoma3.value);
	document.forms[0].telhaoma4.value = trim(document.forms[0].telhaoma4.value);
	var xiaoquname = document.forms[0].telhaoma3.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("号码3不能为空！如果无请填“0000000”");
		document.forms[0].telhaoma3.focus();//设置焦点
		return false;
		}
	if(!istel(xiaoquname)){
		alert("电话格式不正确");
		document.forms[0].telhaoma3.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].telhaoma4.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("号码4不能为空！如果无请填“0000000”");
		document.forms[0].telhaoma4.focus();//设置焦点
		return false;
		}
	if(!istel(xiaoquname)){
		alert("电话格式不正确");
		document.forms[0].telhaoma4.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].onu.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("onu押金不能为空！如果无请填“0”");
		document.forms[0].onu.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].shoushifei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("收视费不能为空！如果无请填“0”");
		document.forms[0].shoushifei.focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].jidinghe.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("机顶盒押金不能为空！如果无请填“0”");
		document.forms[0].jidinghe.focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].nianfei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("年费不能为空！如果无请填“0”");
		document.forms[0].nianfei.focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].buzuyue.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("不足月不能为空！如果无请填“0”");
		document.forms[0].buzuyue.focus();//设置焦点
		return false;
		}else if(!isDigit(xiaoquname)){
			alert("不足月只能填写数字");
			document.forms[0].buzuyue.focus();//设置焦点
			return false;
		}
	var xiaoquname = document.forms[0].chuzhuangfei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("初装费不能为空！如果无请填“0”");
		document.forms[0].chuzhuangfei.focus();//设置焦点
		return false;
		}else if(!isDigit(xiaoquname)){
			alert("初装费只能填写数字");
			document.forms[0].chuzhuangfei.focus();//设置焦点
			return false;
		}
	var xiaoquname = document.forms[0].kuaidaifei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("宽带费不能为空！如果无请填“0”");
		document.forms[0].kuaidaifei.focus();//设置焦点
		return false;
		}else if(!isDigit(xiaoquname)){
			alert("宽带费只能填写数字");
			document.forms[0].kuaidaifei.focus();//设置焦点
			return false;
		}
	var xiaoquname = document.forms[0].beizhu.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("备注不能为空！如果无请填“无”");
		document.forms[0].beizhu.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.getElementById("heji").value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("合计不能为空，请点“合计”");
		document.forms[0].heji.focus();//设置焦点
		return false;
		}
			var isyijiradio = document.forms[0].isYiji;
			var isYiji = "0";
			if(isyijiradio!=undefined) {
				var isYiji = document.forms[0].isYiji[1].checked;
			var yichuxiaoqu = document.forms[0].yichuxiaoqu.value;
			var yichudizhi = document.forms[0].yichudizhi.value;
			var yichuyewu = document.forms[0].yichuyewu.value;
			var yichudianshi = document.forms[0].yichudianshi.value;
			var yichuqita = document.forms[0].yichuqita.value;
			if(isYiji == "1" && (yichuxiaoqu == ' ' && yichuxiaoqu == '')) {
				alert("移出小区不能为空！");
				document.forms[0].yichuxiaoqu.focus();//设置焦点
				return false;
			}
			if(isYiji == "1" && yichudizhi == '') {
				alert("移出地址不能为空！");
				document.forms[0].yichudizhi.focus();//设置焦点
				return false;
			}
			if(isYiji == "1" && (yichuyewu == ''&&yichudianshi == ''&&yichuqita == '')) {
				alert("移出业务不能为空！");
				document.forms[0].yichuyewu.focus();//设置焦点
				return false;
			}
			}
	return true;
}
function checkInput2(){
	var username = document.forms[0].username.value;
	if(username==null||trim(username)==""){
		alert("用户姓名不能为空！");
		document.forms[0].username.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].xiaoquname.value;
	var selectxiaoquhidden = document.forms[0].selectxiaoquhidden.value;
	if((xiaoquname==null||trim(xiaoquname)=="")&&(selectxiaoquhidden==null||trim(selectxiaoquhidden)=="")){
		alert("小区名称不能为空！");
		document.forms[0].xiaoquname.focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].userplace.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("用户地址不能为空！");
		document.forms[0].userplace.focus();//设置焦点
		return false;
		}
	if(!ismenhao(xiaoquname)){
		alert("请输入正确的地址格式！");
		//document.getElementById("userplace").focus();
		document.forms[0].userplace.focus();
		return false;
		}
	var xiaoquname = document.forms[0].usertel.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("用户联系电话不能为空！");
		document.forms[0].usertel.focus();//设置焦点
		return false;
		}
	
	var xiaoquname = document.forms[0].paigongriqi.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("派工日期不能为空！");
		document.forms[0].paigongriqi.focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].anzhuangshijian.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("上门安装时间不能为空！");
		document.forms[0].anzhuangshijian.focus();//设置焦点
		return false;
		}
	
	//var xiaoquname = document.forms[0].xiangmu.value;
	//if(xiaoquname==null||trim(xiaoquname)==""){
	//	alert("项目不能为空");
	//	document.forms[0].xiangmu.focus();//设置焦点
	//	return false;
	//	}

	var xiaoquname = document.forms[0].tfkuandaidaikuan.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("带宽不能为空！如果无请填“0”");
		document.forms[0].tfkuandaidaikuan.focus();//设置焦点
		return false;
		}

	
	
	var xiaoquname = document.forms[0].tfkdnianxian.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("年限不能为空！如果无请填“0”");
		document.forms[0].tfkdnianxian.focus();//设置焦点
		return false;
		}
	
	var xiaoquname = document.forms[0].tfiptv.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("IPTV不能为空！如果无请填“0”");
		document.forms[0].tfiptv.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].tfiptvnianxian.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("IPTV年限不能为空！如果无请填“0”");
		document.forms[0].tfiptvnianxian.focus();//设置焦点
		return false;
		}
	var yuyingshang = document.forms[0].yuyingshang.value;
	if(yuyingshang==null||trim(yuyingshang)=="0"){
		alert("运营商不能为空！");
		document.forms[0].yuyingshang.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].qtye.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("套餐不能为空！");
		document.forms[0].qtye.focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].dxchuzhuangfei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("初装费不能为空！");
		document.forms[0].dxchuzhuangfei.focus();//设置焦点
		return false;
		}
	
	var xiaoquname = document.forms[0].fufei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("年付不能为空！如果无请填“0”");
		document.forms[0].fufei.focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].telhaoma1.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("号码一不能为空！如果无请填“0000000”");
		document.forms[0].telhaoma1.focus();//设置焦点
		return false;
		}
	if(!istel(xiaoquname)){
		alert("电话格式不正确");
		document.forms[0].telhaoma1.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].telhaoma2.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("号码二不能为空！如果无请填“0000000”");
		document.forms[0].telhaoma2.focus();//设置焦点
		return false;
		}
	if(!istel(xiaoquname)){
		alert("电话格式不正确");
		document.forms[0].telhaoma2.focus();//设置焦点
		return false;
		}
	
	var xiaoquname = document.forms[0].telhaoma3.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("号码3不能为空！如果无请填“0000000”");
		document.forms[0].telhaoma3.focus();//设置焦点
		return false;
		}
	if(!istel(xiaoquname)){
		alert("电话格式不正确");
		document.forms[0].telhaoma3.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].telhaoma4.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("号码4不能为空！如果无请填“0000000”");
		document.forms[0].telhaoma4.focus();//设置焦点
		return false;
		}
	if(!istel(xiaoquname)){
		alert("电话格式不正确");
		document.forms[0].telhaoma4.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].onu.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("onu押金不能为空！如果无请填“0”");
		document.forms[0].onu.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.forms[0].shoushifei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("收视费不能为空！如果无请填“0”");
		document.forms[0].shoushifei.focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].jidinghe.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("机顶盒押金不能为空！如果无请填“0”");
		document.forms[0].jidinghe.focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].nianfei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("年费不能为空！如果无请填“0”");
		document.forms[0].nianfei.focus();//设置焦点
		return false;
		}

	var xiaoquname = document.forms[0].buzuyue.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("不足月不能为空！如果无请填“0”");
		document.forms[0].buzuyue.focus();//设置焦点
		return false;
		}else if(!isDigit(xiaoquname)){
			alert("不足月只能填写数字");
			document.forms[0].buzuyue.focus();//设置焦点
			return false;
		}
	var xiaoquname = document.forms[0].chuzhuangfei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("初装费不能为空！如果无请填“0”");
		document.forms[0].chuzhuangfei.focus();//设置焦点
		return false;
		}else if(!isDigit(xiaoquname)){
			alert("初装费只能填写数字");
			document.forms[0].chuzhuangfei.focus();//设置焦点
			return false;
		}
	var xiaoquname = document.forms[0].kuaidaifei.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("宽带费不能为空！如果无请填“0”");
		document.forms[0].kuaidaifei.focus();//设置焦点
		return false;
		}else if(!isDigit(xiaoquname)){
			alert("宽带费只能填写数字");
			document.forms[0].kuaidaifei.focus();//设置焦点
			return false;
		}
	var xiaoquname = document.forms[0].beizhu.value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("备注不能为空！如果无请填“无”");
		document.forms[0].beizhu.focus();//设置焦点
		return false;
		}
	var xiaoquname = document.getElementById("heji").value;
	if(xiaoquname==null||trim(xiaoquname)==""){
		alert("合计不能为空，请点“合计”");
		document.forms[0].heji.focus();//设置焦点
		return false;
		}
	return true;
}
	//置空天房宽带信息
	function clearKuandai(){
		if(document.getElementById("tfkuandaidaikuan").value=="4M"){
			document.getElementById("tfkdnianxian").value="15";
			document.getElementById("tfkdczf").value="0";
			document.getElementById("tfkuandaifei").value="1200";
			document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
			document.getElementById("kuaidaifei").value="1200";
		}else if(document.getElementById("tfkuandaidaikuan").value=="8M"){
			document.getElementById("tfkdnianxian").value="18";
			document.getElementById("tfkdczf").value="0";
			document.getElementById("tfkuandaifei").value="1600";
			document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
			document.getElementById("kuaidaifei").value="1600";
		}else{
		document.getElementById("tfkdnianxian").value="0";
		document.getElementById("tfkdczf").value="0";
		document.getElementById("tfkuandaifei").value="0";
		//document.getElementById("tfkuandaionu").value="0";

		document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
		document.getElementById("kuaidaifei").value="0";

		document.getElementById("heji").value=="0";
		}
		}
	//天房宽带资费设置
	function tfscselect(objs){
	//	alert("-s-s---s"+document.getElementById("tfkuandaidaikuan").value);
		document.getElementById("heji").value=="0";
		obj=objs.value;
		//alert(document.getElementById("tfkdnianxian").value);
		if(document.getElementById("tfkuandaidaikuan").value=="0"){
			alert("请选择带宽！");
			document.getElementById("tfkdnianxian").focus();//设置焦点
			}
		else{
			if(document.getElementById("tfkuandaidaikuan").value=="1M"){
			if(obj<=5){
				document.getElementById("tfkdczf").value=150;
				document.getElementById("tfkuandaifei").value=obj*80;

				document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
				document.getElementById("kuaidaifei").value=obj*80;
				
				}else if(obj==6){
					document.getElementById("tfkdczf").value=0;
					document.getElementById("tfkuandaifei").value=400;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=400;
					}else if(obj>6&&obj<=11){
					document.getElementById("tfkdczf").value=0;
					document.getElementById("tfkuandaifei").value=obj*80;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=obj*80;
					}else if(obj==15){
							document.getElementById("tfkdczf").value=0;
							document.getElementById("tfkuandaifei").value=700;

							document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
							document.getElementById("kuaidaifei").value=700;
						}else if(obj==30){
							document.getElementById("tfkdczf").value=0;
							document.getElementById("tfkuandaifei").value=1400;

							document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
							document.getElementById("kuaidaifei").value=1400;
						}else{
							alert("天房宽带1M没有"+obj+"月资费产品");
						}
						
			}else if(document.getElementById("tfkuandaidaikuan").value=="2M"){
				if(obj<=5){
					document.getElementById("tfkdczf").value=150;
					document.getElementById("tfkuandaifei").value=obj*100;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=obj*100;
					}else if(obj==6){
						document.getElementById("tfkdczf").value=0;
						document.getElementById("tfkuandaifei").value=550;

						document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
						document.getElementById("kuaidaifei").value=550;
						}else if(obj>6&&obj<=11){
						document.getElementById("tfkdczf").value=0;
						document.getElementById("tfkuandaifei").value=obj*100;

						document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
						document.getElementById("kuaidaifei").value=obj*100;
						}else if(obj==15){
								document.getElementById("tfkdczf").value=0;
								document.getElementById("tfkuandaifei").value=1000;

								document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
								document.getElementById("kuaidaifei").value=1000;
							}else if(obj==30){
								document.getElementById("tfkdczf").value=0;
								document.getElementById("tfkuandaifei").value=2000;

								document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
								document.getElementById("kuaidaifei").value=2000;
							}else{
								alert("天房宽带2M没有"+obj+"月资费产品");
							}
				}
			else if(document.getElementById("tfkuandaidaikuan").value=="4M"){
				if(obj==15){
					document.getElementById("tfkdczf").value=0;
					document.getElementById("tfkuandaifei").value=1200;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=1200;
				}else if(obj==30){
					document.getElementById("tfkdczf").value=0;
					document.getElementById("tfkuandaifei").value=2400;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=2400;
				}else{
					alert("天房宽带4M没有"+obj+"月资费产品");
				}
			}else if(document.getElementById("tfkuandaidaikuan").value=="8M"){
				if(obj==18){
					document.getElementById("tfkdczf").value=0;
					document.getElementById("tfkuandaifei").value=1600;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=1600;
				}else if(obj==36){
					document.getElementById("tfkdczf").value=0;
					document.getElementById("tfkuandaifei").value=3200;

					document.getElementById("chuzhuangfei").value=parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
					document.getElementById("kuaidaifei").value=3200;
				}else{
					alert("天房宽带8M没有"+obj+"月资费产品");
				}
			}
		}
		}
	
	
	//其他运营商业务资费设置
	function qtzfselect(objs){
	//	alert("-s-s---s"+document.getElementById("tfkuandaidaikuan").value);
		//document.getElementById("heji").value=="0";
		obj=objs.value;
		//alert(document.getElementById("tfkdnianxian").value);
		if(document.getElementById("qtye").value=="0"){
			//document.getElementById("qtye").focus();//设置焦点
		}
		else{
			if(document.getElementById("qtye").value=="固话业务") {
				if(obj=="月付"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="预付一年"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="预付两年"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="单产品2M") {
				if(obj=="月付"){
					document.getElementById("fufei").value=80;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="预付一年"){
					document.getElementById("fufei").value=800;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="预付两年"){
					document.getElementById("fufei").value=1440;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="单产品4M") {
				if(obj=="月付"){
					document.getElementById("fufei").value=100;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="预付一年"){
					document.getElementById("fufei").value=1000;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="预付两年"){
					document.getElementById("fufei").value=1800;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="单产品8M") {
				if(obj=="月付"){
					document.getElementById("fufei").value=140;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="预付一年"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="预付两年"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="e8-88（2M）") {
				if(obj=="月付"){
					document.getElementById("fufei").value=88;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="预付一年"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="预付两年"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="e8-108（4M）") {
				if(obj=="月付"){
					document.getElementById("fufei").value=108;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="预付一年"){
					document.getElementById("fufei").value=1080;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="预付两年"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="e9-109（2M）") {
				if(obj=="月付"){
					document.getElementById("fufei").value=109;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="预付一年"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="预付两年"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("qtye").value=="e9-139（4M）") {
				if(obj=="月付"){
					document.getElementById("fufei").value=139;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="预付一年"){
					document.getElementById("fufei").value=1390;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="预付两年"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
					
		}
	}
	
	//套餐对应其他运营商业务资费设置
	function taocanselect(objs){
	//	alert("-s-s---s"+document.getElementById("tfkuandaidaikuan").value);
		//document.getElementById("heji").value=="0";
		obj=objs.value;
		//alert(document.getElementById("tfkdnianxian").value);
		if(document.getElementById("fufeitype").value=="0"){
			//document.getElementById("fufeitype").focus();//设置焦点
		}
		else{
			if(document.getElementById("fufeitype").value=="月付") {
				if(obj=="固话业务"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="单产品2M"){
					document.getElementById("fufei").value=80;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="单产品4M"){
					document.getElementById("fufei").value=100;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="单产品8M"){
					document.getElementById("fufei").value=140;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e8-88（2M）"){
					document.getElementById("fufei").value=88;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e8-108（4M）"){
					document.getElementById("fufei").value=108;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e9-109（2M）"){
					document.getElementById("fufei").value=109;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e9-139（4M）"){
					document.getElementById("fufei").value=139;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			if(document.getElementById("fufeitype").value=="预付一年") {
				if(obj=="固话业务"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="单产品2M"){
					document.getElementById("fufei").value=800;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="单产品4M"){
					document.getElementById("fufei").value=1000;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="单产品8M"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e8-88（2M）"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e8-108（4M）"){
					document.getElementById("fufei").value=1080;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e9-109（2M）"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e9-139（4M）"){
					document.getElementById("fufei").value=1390;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
			
			if(document.getElementById("fufeitype").value=="预付两年") {
				if(obj=="固话业务"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if (obj=="单产品2M"){
					document.getElementById("fufei").value=1440;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="单产品4M"){
					document.getElementById("fufei").value=1800;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="单产品8M"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e8-88（2M）"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e8-108（4M）"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e9-109（2M）"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
				if(obj=="e9-139（4M）"){
					document.getElementById("fufei").value=0;
					setvalues(document.getElementById("fufei"),'nianfei');
				}
			}
					
		}
	}

	//设置tftv
	ipshichangchange = function(objs){
	//	alert(document.getElementById("zhengjian").checked)
	document.getElementById("heji").value=="0";
		var obj = objs.value;
		var tfiptvshuliang = document.getElementById("tfiptvshuliang").value
		if(tfiptvshuliang=="0"){
			alert("请选择数量！");
			return false;
			}
		else if(tfiptvshuliang=="一个标清"){
			document.getElementById("tfiptvshoushifei").value=240*obj;

			document.getElementById("shoushifei").value=240*obj;
			if(document.getElementById("zhengjian").checked==true){
				document.getElementById("tfjidingheyajin").value=100;

				document.getElementById("jidinghe").value=100;
				}
			else{
				document.getElementById("tfjidingheyajin").value=400;

				document.getElementById("jidinghe").value=400;
				}
			}
		else {
			if (tfiptvshuliang=="高清") {
				return;
			} else if (tfiptvshuliang=="两个高清") {
				return;
			} else if (tfiptvshuliang=="三个高清") {
				return;
			} else if (tfiptvshuliang=="四个高清") {
				return;
			}
			var s = 0;
			if (tfiptvshuliang=="两个标清") {
				s = 1;
			} else if (tfiptvshuliang=="三个标清") {
				s = 2;
			} else if (tfiptvshuliang=="四个标清") {
				s = 3;
			}
			
			//alert("s"+s);
				document.getElementById("tfiptvshoushifei").value=(240+120*s)*obj;

				document.getElementById("shoushifei").value=(240+120*s)*obj;
				
				if(document.getElementById("zhengjian").checked==true){
					document.getElementById("tfjidingheyajin").value=100+400*s;

					document.getElementById("jidinghe").value=100+400*s;
					}
				else{
					document.getElementById("tfjidingheyajin").value=400+400*s;

					document.getElementById("jidinghe").value=400+400*s;
					}
				}
		}
	
	//清空
	cleartfiptv = function(){
		document.getElementById("tfiptvshichang").value="0";
		document.getElementById("tfiptvshoushifei").value="0";
		document.getElementById("tfjidingheyajin").value="0";

		document.getElementById("shoushifei").value="0";
		document.getElementById("jidinghe").value="0";

		document.getElementById("heji").value=="";
		}

	
	hj=function(){
		if(hejicheck()){
			heji();
		}
	}
	
	hejicheck = function(){
	var obj=document.getElementById("xiaoquname").value;
		
		if(obj.value=="天欣花园"||obj.value=="福悦里"||obj.value=="海景公寓"){
			if(document.getElementById("jiaohuanji").value==""){
				alert("请选择交换机押金");
				return false;
			}
		}else{
			if(document.getElementById("onu").value==""){
				alert("请选择onu押金");
				return false;
			}
		}
			
	}
	//合计
	heji=function(){
		
	document.getElementById("heji").value=
	parseInt(document.getElementById("onu").value)+
	parseInt(document.getElementById("shoushifei").value)+
	parseInt(document.getElementById("jidinghe").value)+
	parseInt(document.getElementById("jiaohuanji").value)+
	parseInt(document.getElementById("nianfei").value)+
	parseInt(document.getElementById("buzuyue").value)+
	parseInt(document.getElementById("chuzhuangfei").value)+
	parseInt(document.getElementById("shebeixiaoshou").value)+
	parseInt(document.getElementById("cailiaofei").value)+
	parseInt(document.getElementById("kuaidaifei").value);
		}

	function isture(obj){
		if(!ismenhao(obj.value)){
			alert("请输入正确的地址格式！例如：11-1-1111 或者 11-11 或者 11-1-别墅");
			//document.getElementById("userplace").focus();
			document.forms[0].userplace.focus();
			return false;
			}
		}
	
	function ismenhao(value) {
		//alert(value);
		//alert(/^\d{2}-\d{1}-\d{4}$/.test(value))
		//return /^\d{2}-\d{1}-\d{4}$/.test(value);
		var a = /^[a-z0-9]{2}-[a-z0-9]{1}-[a-z0-9]{4}$/.test(value);
		var b = /^[a-z0-9]{2}-[a-z0-9]{2}$/.test(value);
		var c = /^[a-z0-9]{2}-[a-z0-9]{1}-别墅$/.test(value);
		
		return a||b||c;
	}

	//用户电话验证(电话/手机)
	function istel(value){
		return /(^\d{8}$)|(^\d{11}$)/.test(value);
		} 
	//交换机 onu 显示
	function selectxiaoqu(obj){
		//if(obj.value=="天欣花园"||obj.value=="福悦里"||obj.value=="海景公寓"){
		//	document.getElementById("jiaohuanjiid").style.display="";
		//	document.getElementById("onu").value="0";
		//	document.getElementById("onutd").style.display="none";
		//	}else{
		//		document.getElementById("jiaohuanji").value="0";
		//		document.getElementById("jiaohuanjiid").style.display="none";
		//		document.getElementById("onutd").style.display="";
		//		}
		} 

	//验证数字
	isDigit = function (str) {
		var patrn=/^\d+$/;
		return patrn.test(str);
		}
	
	//设置初装费总额
	function dxchuzhuangfeichange(obj){
		
		document.getElementById("chuzhuangfei").value=
			parseInt(document.getElementById("yijifei").value)+parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
		}

	function setvalueschuzhuangfei(onj){
		if(onj.value==''){
			onj.value=0;
		}
		
		document.getElementById("chuzhuangfei").value=
			parseInt(document.getElementById("yijifei").value)+parseInt(document.getElementById("tfkdczf").value)+parseInt(document.getElementById("dxchuzhuangfei").value);
		}
	
	//初装费
	setvalues = function(obj,id){
		if(obj.value==''){
			obj.value=0;
		}
		document.getElementById(id).value=obj.value;
		}
	
	
	
	
//******************************************************************下面异步请求
	function createXMLHttpRequest() {
		if (window.XMLHttpRequest) { //Mozilla 浏览器
			XMLHttpReq = new XMLHttpRequest();
		} else {
			if (window.ActiveXObject) { // IE浏览器			
				try {
						XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
					} 
				catch (e) {
						try {
							XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
						} 
						catch (e){}
					}
			}
		}
	}
	//发送请求
	function sendRequest(url, params, method) {
		if (method) {
			if (method.toLowerCase("post")) {
				sendRequestPost(url, params);
			} else {
				if (method.toLowerCase("get")) {
					sendRequestGet(url + "?" + params);
				} else {
				}
			}
		} else {
			alert("\u63d0\u4ea4\u65b9\u5f0f\u4e0d\u80fd\u4e3a\u7a7a\uff01");
		}
	}
	//post发送请求函数
	function sendRequestPost(url, params) {
		params=encodeURI(params); 
        params=encodeURI(params);  
		createXMLHttpRequest();
		XMLHttpReq.open("POST", url, true);
		XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
		XMLHttpReq.setRequestHeader("Content-Type" , "application/x-www-form-urlencoded ; charset=GBK");
		XMLHttpReq.send(params); // 发送请求
	}
	//get发送请求函数
	function sendRequestGet(url) {
		createXMLHttpRequest();
		XMLHttpReq.open("GET", url, true);
		XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
		XMLHttpReq.send(null); // 发送请求
	}
	//post发送请求函数(无需传递参数时)
	function sendRequestPostwihtnoArgs(url) {
		createXMLHttpRequest();
		XMLHttpReq.open("POST", url, true);
		XMLHttpReq.onreadystatechange = processResponse;//指定回调函数
		XMLHttpReq.send(null); // 发送请求
	}
	// 处理返回信息函数
	function processResponse() {
		if (XMLHttpReq.readyState == 4) { // 判断对象状态
			if (XMLHttpReq.status == 200) { //信息已经成功返回，开始处理信息
					/* var res = XMLHttpReq.responseText;
					if(res.length < 1){
						return;
					} */
					var res = XMLHttpReq.responseText;
					Select = document.forms[0].tfkdnianxian;
					for (var i = Select.length; i >= 0 ; i--) {
						Select.options[i] = null;
					}
					var s = res.indexOf(",",0);
					Select.options[Select.options.length] = new Option ("请选择","0");
					while(s>-1){
						var shichang =res.substring(0,s);
			 			res = res.substring(s+1,res.length);
						Select.options[Select.options.length] = new Option (shichang,shichang);
						s = res.indexOf(",",0);
					}
					Select.options[Select.options.length] = new Option (res,res);
					
					
				} 
			} else { 
				//页面不正常
				/* var content=document.getElementById("ul1");
				for (var i=content.childNodes.length-1 ; i>=0 ; i--) {
					var childNode = content.childNodes[i];
					content.removeChild(childNode);
				}  */
			}
		}
	function findStubyClasslId() {
		var shichangleixing = document.forms[0].shichangleixing.value;
		var tfkuandaidaikuan = document.forms[0].tfkuandaidaikuan.value;
		//if(shichangleixing != "" || tfkuandaidaikuan!=""){
			var sURL = "allStu.do?act=getDaikuan";
			var method = "post";
			var sParams = "shichangleixing=" + shichangleixing + "&tfkuandaidaikuan=" + tfkuandaidaikuan;
			sendRequest(sURL, sParams, method);
	 
}
	
	
	
	
	
	
	
	
	
	