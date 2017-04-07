package com.hrbank.business.common;

public class ErrorConstant {

	public static final String E001001 = "BUSINESS.E001001";

	// EmployeeValidator
	public static final String EMPLOYEE_CODE_EMPTY = "ERREMP001";
	public static final String EMPLOYEE_CODE_FORMAT_ILLEGAL = "ERREMP002";
	public static final String EMPLOYEE_CODE_REPEATED = "ERREMP003";
	public static final String EMPLOYEE_NAME_EMPTY = "ERREMP004";
	public static final String EMPLOYEE_NAME_OUT_OF_LENGTH = "ERREMP005";
	public static final String EMPLOYEE_CODE_NOT_EXIST = "ERREMP006";
	public static final String EMPLOYEE_CODE_REPEATED_PARAM = "ERREMP007";

	// DepartmentValidator
	public static final String DEPARTMENT_NAME_EMPTY = "ERRDPT001";
	public static final String DEPARTMENT_NAME_OUT_OF_LENGTH = "ERRDPT002";
	public static final String DEPARTMENT_NAME_REPEATED = "ERRDPT003";

	// ImportValidator
	public static final String UPLOAD_FILE_EMPTY = "ERRIMP001";
	public static final String UPLOAD_FILE_NOT_XLS = "ERRIMP002";
	public static final String UPLOAD_FILE_PARSE_ERROR = "ERRIMP003";

	// BindValidator
	public static final String SCALE_EMPTY = "ERRBID001";
	public static final String SCALE_OUT_OF_BONDS = "ERRBID002";
	public static final String SCALE_NOT_NUMBER = "ERRBID003";
	public static final String SCALE_DECIMAL_POINT_OUT_OF_BONDS = "ERRBID004";
	public static final String BIND_EMPLOYEE_REPEATED = "ERRBID005";
	public static final String SCALE_SUM_OUT_OF_BONDS = "ERRBID006";

	// PasswordValidator
	public static final String OLD_PASSWORD_EMPTY = "ERRPWD001";
	public static final String OLD_PASSWORD_NOT_MATCH = "ERRPWD002";
	public static final String NEW_PASSWORD_EMPTY = "ERRPWD003";
	public static final String NEW_PASSWORD_FORMAT_ILLEGAL = "ERRPWD004";
	public static final String NEW_PASSWORD_OUT_OF_LENGTH = "ERRPWD005";
	public static final String CONFIRM_PASSWORD_EMPTY = "ERRPWD006";
	public static final String PASSWORD_NOT_EQUALS = "ERRPWD007";

	// ImportDataValidator
	public static final String IMPORT_YEAR_EMPTY = "ERRIPD001";
	public static final String IMPORT_MONTH_EMPTY = "ERRIPD002";

	// Common
	public static final String LOGIN_ERROR = "ERRCOM001";

	// ScaleValidator
	public static final String IMPORT_SCALE_OUT_OF_BONDS = "ERRISC001";
	public static final String IMPORT_SCALE_NOT_NUMBER = "ERRISC002";
	public static final String IMPORT_SCALE_DECIMAL_POINT_OUT_OF_BONDS = "ERRISC003";

	// paiogongdan excel

	public static final String IMPORT_PGD_EXECL_SAMECARDID = "ERRPGDEXCEL001";// 数据空
	public static final String PGD_DATA_ERROR = "ERRPGDEXCEL002";// 派工单excel导入错误
	public static final String WXD_DATA_ERROR = "WXD_DATA_ERROR";// 维修单excel导入错误
	public static final String XFD_DATA_ERROR = "XFD_DATA_ERROR";// 续费单excel导入错误
	public static final String AZD_DATA_ERROR = "AZD_DATA_ERROR";// 续费单excel导入错误
	public static final String UP_DATA_ERROR = "UP_DATA_ERROR";// excel导入错误,含有特殊列，请检查Excel！

	public static final String IMPORT_XIAOQU_EMPTY = "ERRPGDEXCEL003";// 小区名不能为空
	public static final String IMPORT_DIZHI_EMPTY = "ERRPGDEXCEL004";// 地址
	public static final String IMPORT_USERTEL_EMPTY = "ERRPGDEXCEL005";// 用户电话

	public static final String IMPORT_PAIGONGDATE_EMPTY = "ERRPGDEXCEL006";// 派工单日期不能为空

	public static final String DELETE_EQM_STATE = "ERRDELLET";// 删除的设备状态不正确
	public static final String YIKU_EQM_STATE = "YIKU_EQM_STATE";
	public static final String IMPORT_EQU_EXECL_SAMECARDID = "IMPORT_EQU_EXECL_SAMECARDID";// 导入设备excel
																							// 为空

	public static final String IMPORT_KU_EMPTY = "IMPORT_KU_EMPTY";
	public static final String IMPORT_MAC_EMPTY = "IMPORT_MAC_EMPTY";
	public static final String IMPORT_RUKUREN_EMPTY = "IMPORT_RUKUREN_EMPTY";
	public static final String IMPORT_TYP_EMPTY = "IMPORT_TYP_EMPTY";
	public static final String IMPORT_XIANGHAO_EMPTY = "IMPORT_XIANGHAO_EMPTY";
	public static final String IMPORT_XIANHAO_EMPTY = "IMPORT_XIANHAO_EMPTY";

	public static final String DELETE_PGD_STATE = "DELETE_PGD_STATE";
	public static final String FENPEI_IP_STATE = "FENPEI_IP_STATE";

	public static final String QUEREN_CHUKU_STATE = "QUEREN_CHUKU_STATE";// 只有状态为出库未确认状态才能确认出库

	public static final String QUEREN_CHONGRUKU_STATE = "QUEREN_CHONGRUKU_STATE";// 只能已解绑状态才能重入库

	public static final String QUEREN_SUNHUAI_STATE = "QUEREN_SUNHUAI_STATE";// 只能确认已解绑状态才能确认已损坏

	public static final String UPDATE_EQM_STATE = "UPDATE_EQM_STATE";//

	public static final String UPDATE_PGD_STATE = "UPDATE_PGD_STATE";

	public static final String IMPORT_USER_XQNAME_EMPTY = "IMPORT_USER_XQNAME_EMPTY"; // 上传，小区名称不能为空
	public static final String IMPORT_USER_YONGHU_EMPTY = "IMPORT_USER_YONGHU_EMPTY"; // 上传，姓名不能为空
	public static final String IMPORT_USER_ZJH_EMPTY = "IMPORT_USER_ZJH_EMPTY"; // 上传，证件号不能为空
	public static final String IMPORT_USER_DZ_EMPTY = "IMPORT_USER_DZ_EMPTY"; // 上传，房号不能为空
	public static final String IMPORT_USER_DATA_ERROR = "IMPORT_USER_DATA_ERROR"; // 数据库异常

	public static final String HUIDAN_PGD_STATE = "HUIDAN_PGD_STATE";// 只有ip已分配状态才能结单

	public static final String CHONGFUMAC = "CHONGFUMAC";// mac地址重复！

	public static final String SHUJUWANGONGSTATE_ERRORY = "SHUJUWANGONGSTATE_ERRORY";// 数据完结状态错误
	public static final String SHIGONGSTATE = "SHIGONGSTATE";
	public static final String GONGBISTATE = "GONGBISTATE";
	public static final String JIEDANSTATE = "JIEDANSTATE";

	public static final String YUYUEEXIST = "YUYUEEXIST";// 预约已经存在
	public static final String YIPAIJIHUA = "YIPAIJIHUA";// 客服已排预约，不能删除

	public static final String YUYUENOEXIST = "YUYUENOEXIST";
	public static final String YUYUEAZ = "YUYUEAZ";
	public static final String YUYUEQJ = "YUYUEQJ";

	public static final String XUANHAOBUCUNZAI = "XUANHAOBUCUNZAI"; // 选号不存在
	public static final String HAOMABEIXUAN = "HAOMABEIXUAN"; // 号码已被 选过。
	public static final String XUANHAOCUOWU = "XUANHAOCUOWU"; // 选号错误

	public static final String IMPORT_QUYU_EMPTY = "IMPORT_QUYU_EMPTY";
	public static final String IMPORT_TELNO_EMPTY = "IMPORT_TELNO_EMPTY";

	public static final String DELETE_TEL_STATE = "DELETE_TEL_STATE";

	public static final String IMPORT_STATE_EMPTY = "IMPORT_STATE_EMPTY";

	public static final String ANZHUANGWANBI = "ANZHUANGWANBI";

	public static final String TUIDANSTATE = "TUIDANSTATE";

	public static final String NOTELNO1 = "NOTELNO1";// 所选的号码1不存在

	public static final String NOTELNO2 = "NOTELNO2";// 所选的号码2不存在

	public static final String NOTELNO3 = "NOTELNO3";// 所选的号码3不存在

	public static final String NOTELNO4 = "NOTELNO4";// 所选的号码1不存在

	public static final String YIXUANTEL1 = "YIXUANTEL1";

	public static final String YIXUANTEL2 = "YIXUANTEL2";

	public static final String YIXUANTEL3 = "YIXUANTEL3";

	public static final String YIXUANTEL4 = "YIXUANTEL4";

	public static final String QUJIANSTATE_ERRORY = "QUJIANSTATE_ERRORY";// 取件状态错误

	public static final String SHOUJIANSTATE_ERRORY = "SHOUJIANSTATE_ERRORY";// 收件操作状态错误
	public static final String SHUJUSHANGCHUANSTATE_ERRORY = "SHUJUSHANGCHUANSTATE_ERRORY";//

	public static final String DIANXINXIADAN_ERRORY = "DIANXINXIADAN_ERRORY";
	public static final String KEFUSHUJUSTATE_ERRORY = "KEFUSHUJUSTATE_ERRORY";
	public static final String TUIDANETIAOZHUAN_RRORY = "TUIDANETIAOZHUAN_RRORY";

	public static final String YONGHU_JIAOFEI_STATE = "YONGHU_JIAOFEI_STATE";
	public static final String IMPORT_YONGHUDATA_EXECL_SAMECARDID = "ERRYHDATAEXCEL001";// 数据空
	public static final String IMPORT_YHDIZHI_EMPTY = "IMPORT_YHDIZHI_EMPTY";
	public static final String IMPORT_STATE_ERROR = "IMPORT_STATE_ERROR";
	public static final String IMPORT_STATE_ERROR01 = "IMPORT_STATE_ERROR01";
	public static final String IMPORT_STATE_ERROR02 = "IMPORT_STATE_ERROR02";
	public static final String IMPORT_STATE_ERROR03 = "IMPORT_STATE_ERROR03";
	public static final String IMPORT_STATE_ERROR04 = "IMPORT_STATE_ERROR04";
	public static final String EDIT_STATE_ERROR = "EDIT_STATE_ERROR";
	public static final String IMPORT_YONGHUDATA_ERROR01 = "IMPORT_YONGHUDATA_ERROR01";// 用户数据{0}业务有重复！
	public static final String IMPORT_YIXUFEI_ERROR0 = "IMPORT_YIXUFEI_ERROR0";// {0}
	public static final String IMPORT_YIXUFEI_ERROR01 = "IMPORT_YIXUFEI_ERROR01";// 缴费单用户{0}业务为空！
	public static final String IMPORT_YIXUFEI_ERROR02 = "IMPORT_YIXUFEI_ERROR02";// 缴费单用户{0}含有多种业务！
	public static final String IMPORT_YIXUFEI_ERROR03 = "IMPORT_YIXUFEI_ERROR03";// 缴费用户{0}含有重复业务记录
	public static final String IMPORT_YIXUFEI_ERROR04 = "IMPORT_YIXUFEI_ERROR04";// 缴费用户{0}没有安装{1}业务
	public static final String DOWN_BIDUI_ANZHUANG = "DOWN_BIDUI_ANZHUANG";// 已安装比对
	public static final String SUBMIT_PIPEI_STATE = "SUBMIT_PIPEI_STATE";
	public static final String SUBMIT_PIPEI_UPDATE_ERROR = "SUBMIT_PIPEI_UPDATE_ERROR";
}
