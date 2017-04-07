// 取消左空格.
function ltrim(s) {
	return s.replace(/^(\s*| *)/, "");
}
// 去掉右空格.
function rtrim(s) {
	return s.replace(/(\s*| *)$/, "");
}
// 去掉左右空格.
function trim(s) {
	return ltrim(rtrim(s));
}
// 判断一个字符串是否为空，如果为空则返回true，否则返回false.
function isNull(element) {
	if (element == null || trim(element) == "") {
		return true;
	}
	return false;
}

// 判断字符串是否为数值，如果是则返回true，否则返回false. 
function isNumeric(value) {
	return /^(?:[1-9][0-9]*|0)(?:\.[0-9]+)?$/.test(value);
}

// 判断字符串是否为自然数（正整数和零），如果是则返回true，否则返回false. 
function isNaturalNumber(value) {
	return /^[0-9]+[0-9]*]*$/.test(value);
}

// 判断字符串是否为正整数，如果是则返回true，否则返回false. 
function isInteger(value) {
	return /^[1-9]+[0-9]*]*$/.test(value);
}

// 判断一个字符是否是中文，如果是则返回true，否则返回false. 
function isChinese(str) {
	var lst = /[u00-uFF]/;
	return !lst.test(str);
}

// 获得一个字符串的字节长度，如果是则返回true，否则返回false. 
function byteLength(str) {
	var strlength = 0;
	for (i = 0; i < str.length; i++) {
		if (isChinese(str.charAt(i))) {
			strlength = strlength + 2;
		} else {
			strlength = strlength + 1;
		}
	}
	return strlength;
}
// 提交时禁用其他按钮的操作.
function disableAll(doc) {
	with (doc.forms[0]) {
		for (i = 0; i < elements.length; i++) {
			switch (elements[i].type) {
			  case "submit":
			  case "button":
			  case "cancel":
			  case "reset":
				elements[i].disabled = true;
			}
		}
	}
}
//0-100验证
function zeroToHundredCheck(s) {
	if (/^(?:[0-9][0-9]*|0)(?:\.[0-9]+)?$/.test(s) && (s >= 0) && (s <= 100)) {
		return false;
	} else {
		return true;
	}
}

/*
	0-1 数字范围验证
	update：2009-08-14 PM
	auther：flp
*/
function zeroToOneCheck(s) {
	if (/^(?:[0-9][0-9]*|0)(?:\.[0-9]+)?$/.test(s) && (s >= 0) && (s <= 1)) {
		return false;
	} else {
		return true;
	}
}

// 如果传入的值完全是由字母和数字构成的，返回true,否则返回false
function isLetterAndNumber(s){
	var pat = new RegExp("^[A-Za-z0-9]+$");
	return pat.test(s);
}

function isUpperLetter(c){
	return /^[A-Z]+$/.test(c);
}

function isLowerLetter(c){
	return /^[a-z]+$/.test(c);
}

function isNumber(c){
	return /^[0-9]+$/.test(c);
}

function isTwoDight(c){
	if(c.indexOf('.') != -1){
		return c.substr(c.indexOf('.')+1).length <= 2
	}
	return true;
}

