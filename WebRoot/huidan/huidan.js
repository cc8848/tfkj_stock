//验证数字的正则表达式
pattern2=/^[0-9]+$/;
//验证身份证的正则表达式
pattern1=/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
//验证日期的正则表达式
pattern3=/^[1,2][0-9]{3}-[0-9]{2}-[0-9]{2}$/;
//回单纠错-编辑的时间验证
function error_edit(){
	var kai  = document.getElementById('kaijis').value;
	var ting = document.getElementById('tingjis').value;
	var shou = document.getElementById('kaishi').value;
	if(!pattern3.test(kai) || !pattern3.test(ting) || !pattern3.test(shou)){
		alert('时间格式有误，请重新输入！');
	}else{
		commonSubmit('huidanerrorList.do?act=edit_save');
	}
}
function check_querenchaifen(){
	var a = document.getElementById('kaipiao').value;
	var b = document.getElementById('feikaipiao').value;
	if(a != null && trim(a) != "" && b != null && trim(b) != ""){
		commonSubmit('huidanerrorList.do?act=querenchaifen');
	}
	else{
		alert('请填写开票收据号和未开票收据号!');
	}
}
//回单提交页面 提交非空 检验
function check_zhengchangtijiao(){
	if(check_suoyou() && check_shijian()){
		commonSubmit('huidansubList.do?act=update_zhengchang');
	}
}
function check_kaipiaochaifen(){
	if(check_suoyou() && check_shijian()){
		commonSubmit('huidansubList.do?act=update_chaifen');
	}
}
function check_jiucuoxiugai(){
	if(check_suoyou()){
		commonSubmit('huidansubList.do?act=update_jiucuo');
	}
}
function check_shijian(){
	var shoukuanshijian = document.getElementById('kaishi').value;
	var kaijishijian = document.getElementById('kaijishijian').value;
	if(shoukuanshijian!=kaijishijian){
		alert("收款时间有误，请重新输入!");
		return false;
	}
	if(!pattern3.test(shoukuanshijian)){
		alert("收款时间格式有误，请重新输入！");
		return false;
	}
	var zong = document.getElementById('sub_9').value;
	var all=
		parseInt(document.getElementById('count_1').value)
		+parseInt(document.getElementById('count_2').value)
		+parseInt(document.getElementById('count_3').value)
		+parseInt(document.getElementById('count_4').value)
		+parseInt(document.getElementById('count_5').value)
		+parseInt(document.getElementById('count_6').value)
		+parseInt(document.getElementById('count_7').value)
		+parseInt(document.getElementById('count_8').value)
		+parseInt(document.getElementById('count_9').value);
	if(zong != all){
		alert("总收费有误，请重新输入！");
		return false;
	}
	return true;
}
function check_suoyou(){
	document.getElementById('shouju').value=document.getElementById('sub_10').value;
	var shigongren = document.getElementById('sub_4').value;
	if (shigongren == null || trim(shigongren) == "") {
		alert("施工人不能为空！");
		document.getElementById('sub_4').focus();// 设置焦点
		return false;
	}
	var shoukuanshijian = document.getElementById('kaishi').value;
	if (shoukuanshijian == null || trim(shoukuanshijian) == "") {
		alert("收款时间不能为空！");
		document.getElementById('kaishi').focus();// 设置焦点
		return false;
	}
	if (!pattern3.test(shoukuanshijian)) {
		alert("收款时间格式有误，请重新输入！");
		document.getElementById('kaishi').focus();// 设置焦点
		return false;
	}
	var yonghuxingming = document.getElementById('sub_6').value;
	if (yonghuxingming == null || trim(yonghuxingming) == "") {
		alert("用户姓名不能为空！");
		document.getElementById('sub_6').focus();// 设置焦点
		return false;
	}
	var shenfenghzhenghao = document.getElementById('sub_7').value;
	if (shenfenghzhenghao == null || trim(shenfenghzhenghao) == "") {
		alert("身份证号不能为空！");
		document.getElementById('sub_7').focus();// 设置焦点
		return false;
	}
	/*if (!pattern1.test(shenfenghzhenghao)){
		alert("身份证格式有误，请重新输入");
		return false;
	}*/
	var jiexuweizhi = document.getElementById('sub_8').value;
	if (jiexuweizhi == null || trim(jiexuweizhi) == "") {
		alert("接续位置不能为空！");
		document.getElementById('sub_8').focus();// 设置焦点
		return false;
	}
	var zongshoufei = document.getElementById('sub_9').value;
	if (zongshoufei == null || trim(zongshoufei) == "") {
		alert("总收费不能为空！");
		document.getElementById('sub_9').focus();// 设置焦点
		return false;
	}
	if(!pattern2.test(zongshoufei)){
		alert("总收费请输入数字!");
		document.getElementById('sub_9').focus();// 设置焦点
		return false;
	}
	var shoujubenhao = document.getElementById('sub_10').value;
	if (shoujubenhao == null || trim(shoujubenhao) == "") {
		alert("收据本号不能为空！");
		document.getElementById('sub_10').focus();// 设置焦点
		return false;
	}
	var jiexianzi = document.getElementById('sub_11').value;
	if (jiexianzi !=null && trim(jiexianzi)!= "" && !pattern2.test(jiexianzi)) {
		alert("接线子请输入数字！");
		document.getElementById('sub_11').focus();// 设置焦点
		return false;
	}
	var rj11 = document.getElementById('sub_12').value;
	if (rj11 !=null && trim(rj11)!= "" && !pattern2.test(rj11)) {
		alert("rj11请输入数字！");
		document.getElementById('sub_12').focus();// 设置焦点
		return false;
	}
	var rj45 = document.getElementById('sub_13').value;
	if (rj45 !=null && trim(rj45)!= "" && !pattern2.test(rj45)) {
		alert("rj45请输入数字！");
		document.getElementById('sub_13').focus();// 设置焦点
		return false;
	}
	var mokuai = document.getElementById('sub_14').value;
	if (mokuai !=null && trim(mokuai)!= "" && !pattern2.test(mokuai)) {
		alert("模块请输入数字！");
		document.getElementById('sub_14').focus();// 设置焦点
		return false;
	}
	var mianban = document.getElementById('sub_15').value;
	if (mianban !=null && trim(mianban)!= "" && !pattern2.test(mianban)) {
		alert("面板请输入数字！");
		document.getElementById('sub_15').focus();// 设置焦点
		return false;
	}
	var wangxian = document.getElementById('sub_16').value;
	if (wangxian !=null && trim(wangxian)!= "" && !pattern2.test(wangxian)) {
		alert("网线请输入数字！");
		document.getElementById('sub_16').focus();// 设置焦点
		return false;
	}
	return true;
}

//设置回单提交页面的四个提交按钮选项
//有出入 无出入 开票金额拆分
function check_youchuru(){
	document.getElementById('check_11').disabled=false;
	document.getElementById('check_22').disabled=true;
	document.getElementById('check_22').value="";
	document.getElementById('count_qian').innerHTML='';
	document.getElementById('button_3').disabled=false;
	document.getElementById('button_2').disabled=true;
	document.getElementById('button_1').disabled=true;
}
function check_wuchuru(){
	document.getElementById('check_11').disabled=true;
	document.getElementById('check_22').disabled=true;
	document.getElementById('check_11').value="";
	document.getElementById('check_22').value="";
	document.getElementById('count_qian').innerHTML=
		parseInt(document.getElementById('count_1').value)
		+parseInt(document.getElementById('count_2').value)
		+parseInt(document.getElementById('count_3').value)
		+parseInt(document.getElementById('count_4').value)
		+parseInt(document.getElementById('count_5').value)
		+parseInt(document.getElementById('count_6').value)
		+parseInt(document.getElementById('count_7').value)
		+parseInt(document.getElementById('count_8').value)
		+parseInt(document.getElementById('count_9').value);
	document.getElementById('button_1').disabled=false;
	document.getElementById('button_2').disabled=true;
	document.getElementById('button_3').disabled=true;
}
function check_kaipiaojinechaifen(){
	document.getElementById('check_11').disabled=true;
	document.getElementById('check_22').disabled=false;
	document.getElementById('check_11').value="";
	document.getElementById('count_qian').innerHTML=
		parseInt(document.getElementById('count_1').value)
		+parseInt(document.getElementById('count_2').value)
		+parseInt(document.getElementById('count_3').value)
		+parseInt(document.getElementById('count_4').value)
		+parseInt(document.getElementById('count_5').value)
		+parseInt(document.getElementById('count_6').value)
		+parseInt(document.getElementById('count_7').value)
		+parseInt(document.getElementById('count_8').value)
		+parseInt(document.getElementById('count_9').value);
	document.getElementById('button_1').disabled=true;
	document.getElementById('button_3').disabled=true;
	document.getElementById('button_2').disabled=false;
}
function check_huidan(){
	var xiaoqu = document.forms[0].xiaoqu.value;
	if (xiaoqu == null || trim(xiaoqu) == "") {
		alert("请选择小区！");
		document.forms[0].xiaoqu.focus();// 设置焦点
		return false;
	}
	var dizhi = document.forms[0].dizhi.value;
	if (dizhi == null || trim(dizhi) == "") {
		alert("地址不能为空！");
		document.forms[0].dizhi.focus();// 设置焦点
		return false;
	}
	var lianxidianhua = document.forms[0].telNoCode.value;
	if (lianxidianhua == null || trim(lianxidianhua) == "") {
		alert("联系电话不能为空！");
		document.forms[0].telNoCode.focus();// 设置焦点
		return false;
	}
	var wangluo = document.forms[0].wangluo.value;
	if (wangluo == null || trim(wangluo) == "") {
		alert("请输入网络项！");
		document.forms[0].wangluo.focus();// 设置焦点
		return false;
	}
	var dianshi = document.forms[0].dianshi.value;
	if (dianshi == null || trim(dianshi) == "") {
		alert("请输入电视项！");
		document.forms[0].dianshi.focus();// 设置焦点
		return false;
	}
	var dianhua = document.forms[0].dianhua.value;
	if (dianhua == null || trim(dianhua) == "") {
		alert("请输入电话项！");
		document.forms[0].dianhua.focus();// 设置焦点
		return false;
	}
	var yewu = document.forms[0].yewu.value;
	if (yewu == null || trim(yewu) == "") {
		alert("请输入业务项！");
		document.forms[0].yewu.focus();// 设置焦点
		return false;
	}
	var fenguang = document.forms[0].fenguang.value;
	if (fenguang == null || trim(fenguang) == "") {
		alert("请输入分光项！");
		document.forms[0].fenguang.focus();// 设置焦点
		return false;
	}
	var onumac = document.forms[0].onuCode.value;
	if (onumac == null || trim(onumac) == "") {
		alert("请输入onumac！");
		document.forms[0].onuCode.focus();// 设置焦点
		return false;
	}
	var stbmcid = document.forms[0].mcidCode.value;
	if (stbmcid == null || trim(stbmcid) == "") {
		alert("请输入stbmcid！");
		document.forms[0].mcidCode.focus();// 设置焦点
		return false;
	}
	var dianshiip = document.forms[0].dianshiip.value;
	if (dianshiip == null || trim(dianshiip) == "") {
		alert("请输入电视ip！");
		document.forms[0].dianshiip.focus();// 设置焦点
		return false;
	}
	var wangluoip = document.forms[0].wangluoip.value;
	if (wangluoip == null || trim(wangluoip) == "") {
		alert("请输入网络ip！");
		document.forms[0].wangluoip.focus();// 设置焦点
		return false;
	}
	var dianhuaip = document.forms[0].dianhuaip.value;
	if (dianhuaip == null || trim(dianhuaip) == "") {
		alert("请输入电话ip！");
		document.forms[0].dianhuaip.focus();// 设置焦点
		return false;
	}
	var dianhuavlan = document.forms[0].dianhuavlan.value;
	if (dianhuavlan == null || trim(dianhuavlan) == "") {
		alert("请输入电话vlan！");
		document.forms[0].dianhuavlan.focus();// 设置焦点
		return false;
	}
	var wangluovlan = document.forms[0].wangluovlan.value;
	if (wangluovlan == null || trim(wangluovlan) == "") {
		alert("请输入网络vlan！");
		document.forms[0].wangluovlan.focus();// 设置焦点
		return false;
	}
	var shangmenshijian = document.forms[0].shangmenshijian.value;
	if (shangmenshijian == null || trim(shangmenshijian) == "") {
		alert("请输入上门时间！");
		document.forms[0].shangmenshijian.focus();// 设置焦点
		return false;
	}
	var danzheng = document.forms[0].danzheng.value;
	if (danzheng == null || trim(danzheng) == "") {
		alert("请输入单证！");
		document.forms[0].danzheng.focus();// 设置焦点
		return false;
	}
	var sxdhhm = document.forms[0].sxdhhm.value;
	if (sxdhhm == null || trim(sxdhhm) == "") {
		alert("请输入所选电话号码！");
		document.forms[0].sxdhhm.focus();// 设置焦点
		return false;
	}
	var onuyj = document.forms[0].onuyj.value;
	if (onuyj == null || trim(onuyj) == "") {
		alert("请输入onu押金！");
		document.forms[0].onuyj.focus();// 设置焦点
		return false;
	}
	var jidingheyj = document.forms[0].jidingheyj.value;
	if (jidingheyj == null || trim(jidingheyj) == "") {
		alert("请输入机顶盒押金！");
		document.forms[0].jidingheyj.focus();// 设置焦点
		return false;
	}
	var shoushifei = document.forms[0].shoushifei.value;
	if (shoushifei == null || trim(shoushifei) == "") {
		alert("请输入收视费！");
		document.forms[0].shoushifei.focus();// 设置焦点
		return false;
	}
	var kuandaifei = document.forms[0].kuandaifei.value;
	if (kuandaifei == null || trim(kuandaifei) == "") {
		alert("请输入宽带费！");
		document.forms[0].kuandaifei.focus();// 设置焦点
		return false;
	}
	var chuzhuangfei = document.forms[0].chuzhuangfei.value;
	if (chuzhuangfei == null || trim(chuzhuangfei) == "") {
		alert("请输入初装费！");
		document.forms[0].chuzhuangfei.focus();// 设置焦点
		return false;
	}
	var shebeixiaoshoufei = document.forms[0].shebeixiaoshoufei.value;
	if (shebeixiaoshoufei == null || trim(shebeixiaoshoufei) == "") {
		alert("请输入设备销售费！");
		document.forms[0].shebeixiaoshoufei.focus();// 设置焦点
		return false;
	}
	var cailiaofei = document.forms[0].cailiaofei.value;
	if (cailiaofei == null || trim(cailiaofei) == "") {
		alert("请输入材料费！");
		document.forms[0].cailiaofei.focus();// 设置焦点
		return false;
	}
	var yunyingshang = document.forms[0].yunyingshang.value;
	if (yunyingshang == null || trim(yunyingshang) == "") {
		alert("请输入运营商！");
		document.forms[0].yunyingshang.focus();// 设置焦点
		return false;
	}
	var bzygf = document.forms[0].bzygf.value;
	if (bzygf == null || trim(bzygf) == "") {
		alert("请输入不足月够费！");
		document.forms[0].bzygf.focus();// 设置焦点
		return false;
	}
	var nianfei = document.forms[0].nianfei.value;
	if (nianfei == null || trim(nianfei) == "") {
		alert("请输入年费！");
		document.forms[0].nianfei.focus();// 设置焦点
		return false;
	}
	var beizhuhuizong = document.forms[0].beizhuhuizong.value;
	if (beizhuhuizong == null || trim(beizhuhuizong) == "") {
		alert("请输入备注汇总！");
		document.forms[0].beizhuhuizong.focus();// 设置焦点
		return false;	
	}
	var beizhu = document.forms[0].beizhu.value;
	if (beizhu == null || trim(beizhu) == "") {
		alert("备注不能为空！");
		document.forms[0].beizhu.focus();// 设置焦点
		return false;
	}
	var s1 = document.getElementById('kaijis').value;
	var s2 = document.getElementById('tingjis').value;
	if(!pattern3.test(s1)){
		alert("开机时间格式有误，请重新输入！");
		return false;
	}
	if(!pattern3.test(s2)){
		alert("关机时间格式有误，请重新输入！");
		return false;
	}
	if(s1>s2){
		alert("开停机时间输入有误，请重新输入！");
		return false;
	}
	return true;
}
function check_(){
	var code_Values = document.getElementsByTagName("input"); 
	for(var i = 0;i < code_Values.length;i++) {
		if(code_Values[i].type == "checkbox") {
			code_Values[i].checked = "checked"; 
		}
	}	
}
function sub_updateHuidan() {
    if(check_huidan()){
              commonSubmit('huidandaoruList.do?act=update_Huidan');
     }
}


function check(){
	var kaijie = document.forms[0].kaijie.value;
	var tingjie = document.forms[0].tingjie.value;
	if (trim(kaijie) == "" && trim(tingjie) == ""){
		return true;
	} else {
		if(!(trim(kaijie) == "")) {
			kaijie = /^\d{4}[-](\d{2})[-](\d{2})$/.test(kaijie);
			if (kaijie == false ) {
				alert("开始时间输入格式有误！");
				document.forms[0].kaijie.focus();// 设置焦点
				return false;
			}
		}

		if(!(trim(tingjie) == "")) {
			tingjie = /^\d{4}[-](\d{2})[-](\d{2})$/.test(tingjie);
			if (tingjie == false ) {
				alert("结束时间输入格式有误！");
				document.forms[0].tingjie.focus();// 设置焦点
				return false;
			}
		}
	}
	return true;
}
function check1(){
	var kaijis = document.forms[0].kaijis.value;
	var kaijie = document.forms[0].kaijie.value;
	if (trim(kaijis) == "" && trim(kaijie) == ""){
		return true;
	} else {
		if(!(trim(kaijis) == "")) {
			kaijis = /^\d{4}[-](\d{2})[-](\d{2})$/.test(kaijis);
			if (kaijis == false ) {
				alert("开始时间输入格式有误！");
				document.forms[0].kaijis.focus();// 设置焦点
				return false;
			}
		}

		if(!(trim(kaijie) == "")) {
			kaijie = /^\d{4}[-](\d{2})[-](\d{2})$/.test(kaijie);
			if (kaijie == false ) {
				alert("结束时间输入格式有误！");
				document.forms[0].kaijie.focus();// 设置焦点
				return false;
			}
		}
	}
	return true;
}

function check2(){
	var sen1 = document.forms[0].sen1.value;
	var sen2 = document.forms[0].sen2.value;
	if (trim(sen1) == "" && trim(sen2) == ""){
		return true;
	} else {
		if(!(trim(sen1) == "")) {
			sen1 = /^\d{4}[-](\d{2})[-](\d{2})$/.test(sen1);
			if (sen1 == false ) {
				alert("开始时间输入格式有误！");
				document.forms[0].sen1.focus();// 设置焦点
				return false;
			}
		}

		if(!(trim(sen2) == "")) {
			sen2 = /^\d{4}[-](\d{2})[-](\d{2})$/.test(sen2);
			if (sen2 == false ) {
				alert("结束时间输入格式有误！");
				document.forms[0].sen2.focus();// 设置焦点
				return false;
			}
		}
	}
	return true;
}

