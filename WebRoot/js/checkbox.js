/**
 * 全选选定指定名称的所有复选框.
 * 
 * @fatherName 父复选框的name属性名称.
 * @childrenName 待执行选择或撤销的复选框id属性名称.
 */
function selectAll(fatherName,childrenName){
    var children = document.getElementsByName(childrenName);
    for (var i = 0; i < children.length; i++) {
        if (document.getElementById(fatherName).checked) {
            // 实际选择全部操作
            children[i].checked = true;
        }else {
            // 实现撤销全部操作
            children[i].checked = false;
        }
    }
}

/**
 * 选择或撤销选定指定名称的复选框，并级联更新父复选框的状态.
 * 
 * @object 当前复选框对象，传递"this"即可.
 * @fatherName 父复选框的name属性名称.
 * @childrenName 待执行选择或撤销的复选框id属性名称.
 */
function selectOne(object,fatherName,childrenName){
	var flag = true;
	var m = document.getElementsByName(childrenName);
	for (var i = 0; i < m.length; i++) {
		if (!m[i].checked) {
			flag = false;
			break;
		}
	}
	if (flag) {
		// 理论全选操作.
		document.getElementById(fatherName).checked = true;
	}else {
		// 理论非全选操作.
		document.getElementById(fatherName).checked = false;
	}
}

/**
 * 反选指定名称的所有复选框.
 * 
 * @fatherName 父复选框的name属性名称.
 * @childrenName 待执行选择或撤销的复选框id属性名称.
 */
function selectInvert(fatherName,childrenName){
	var flag = 0;
	var children = document.getElementsByName(childrenName);
    for (var i = 0; i < children.length; i++) {
		children[i].checked = !children[i].checked;
		if (!children[i].checked) {
			flag++;
		}
    }
	if (flag == 0) {
		// 理论全选操作.
		document.getElementById(fatherName).checked = true;
	}else {
		// 理论非全选操作.
		document.getElementById(fatherName).checked = false;
	}
}
