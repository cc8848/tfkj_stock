/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: data validator class.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-11-23   Zhu.Xiao-Lei          Create
 */
package com.stock.yonghushuju;

import java.util.List;
import java.util.Map;

import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.common.Validator;

/**
 * data validator class.
 * 
 * @author Zhu.Xiao-Lei
 *
 */
public class DataValidator extends Validator {
	
	/**
	 * excel import validator method.
	 * 
	 * @param pgd
	 * @return
	 * @throws Exception
	 */
	public String insertValidate(EntityData pgd) throws Exception{
		initErrors();
		
		addError(isEmpty(pgd.getXiaoqu(), ErrorConstant.IMPORT_QUYU_EMPTY));
		addError(isState(pgd.getYonghuzhuangtai(), ErrorConstant.IMPORT_STATE_ERROR));
		addError(isState1(pgd.getYonghuzhuangtai(), ErrorConstant.IMPORT_STATE_ERROR04));
		addError(isEmpty(pgd.getDizhi(), ErrorConstant.IMPORT_YHDIZHI_EMPTY));
		
		return getErrorCode();
	}
	
	private String isState(String value,String errorCode){
		if(value.equals("已维修") || value.equals("已续费") ){
			return errorCode;
		}
		
		return null;
	}
	private String isState1(String value,String errorCode){
		if(value == null || value.trim() == "" || value.trim().equals("")) {
			return errorCode;
		}
		
		return null;
	}
	
	/**
	 * 插入维修纪录过滤器
	 * 
	 * @param pgd
	 * @return
	 * @throws Exception
	 */
	public String insertWeixiuValidate(EntityData pgd) throws Exception {
		initErrors();
		
		addError(isEmpty(pgd.getXiaoqu(), ErrorConstant.IMPORT_QUYU_EMPTY));
		addError(isStateWeixiu(pgd.getYonghuzhuangtai(), ErrorConstant.IMPORT_STATE_ERROR01));
		addError(isStateWeixiu1(pgd.getYonghuzhuangtai(), ErrorConstant.IMPORT_STATE_ERROR04));
		addError(isEmpty(pgd.getDizhi(), ErrorConstant.IMPORT_YHDIZHI_EMPTY));
		
		return getErrorCode();
	}
	
	/**
	 * 错误记录，判断是否是已维修
	 * 
	 * @param value
	 * @param errorCode
	 * @return
	 */
	private String isStateWeixiu(String value,String errorCode){
		if(!("已维修").equals(value) ){
			return errorCode;
		}
		
		return null;
	}
	private String isStateWeixiu1(String value,String errorCode){
		if(value == null || value.trim() == "" || value.trim().equals("")) {
			return errorCode;
		}
		
		return null;
	}
	
	/**
	 * 插入已续费记录过滤器
	 * 
	 * @param pgd
	 * @param zjlist 
	 * @return
	 * @throws Exception
	 */
	public String insertXufeiValidate(EntityData pgd) throws Exception {
		initErrors();
		
		addError(isEmpty(pgd.getXiaoqu(), ErrorConstant.IMPORT_QUYU_EMPTY));
		addError(isStateXufei(pgd.getYonghuzhuangtai(), ErrorConstant.IMPORT_STATE_ERROR02));
		addError(isStateXufei1(pgd.getYonghuzhuangtai(), ErrorConstant.IMPORT_STATE_ERROR04));
		addError(isEmpty(pgd.getDizhi(), ErrorConstant.IMPORT_YHDIZHI_EMPTY));
		
		return getErrorCode();
	}
	
	/**
	 * 错误记录，判断是否是已续费
	 * 
	 * @param value
	 * @param errorCode
	 * @return
	 */
	private String isStateXufei(String value,String errorCode){
		if(!("已续费").equals(value) ){
			return errorCode;
		}
		
		return null;
	}
	private String isStateXufei1(String value,String errorCode){
		if(value == null || value.trim() == "" || value.trim().equals("")) {
			return errorCode;
		}
		
		return null;
	}
	
	/**
	 * 插入已安装记录过滤器
	 * 
	 * @param pgd
	 * @param zjlist 
	 * @return
	 * @throws Exception
	 */
	public String insertAnzhuangValidate(EntityData pgd) throws Exception {
		initErrors();
		addError(isEmpty(pgd.getXiaoqu(), ErrorConstant.IMPORT_QUYU_EMPTY));
		//addError(isStateAnzhuang(pgd.getYonghuzhuangtai(), ErrorConstant.IMPORT_STATE_ERROR03));
		addError(isEmpty(pgd.getDizhi(), ErrorConstant.IMPORT_YHDIZHI_EMPTY));
		
		return getErrorCode();
	}
	
	/**
	 * 错误记录，判断是否是已安装
	 * @param value
	 * @param errorCode
	 * @return
	 */
	/*private String isStateAnzhuang(String value,String errorCode){
		if(!("已安装").equals(value) ){
			return errorCode;
		}
		
		return null;
	}*/
}
