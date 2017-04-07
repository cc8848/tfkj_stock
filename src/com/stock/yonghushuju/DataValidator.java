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
		if(value.equals("��ά��") || value.equals("������") ){
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
	 * ����ά�޼�¼������
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
	 * �����¼���ж��Ƿ�����ά��
	 * 
	 * @param value
	 * @param errorCode
	 * @return
	 */
	private String isStateWeixiu(String value,String errorCode){
		if(!("��ά��").equals(value) ){
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
	 * ���������Ѽ�¼������
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
	 * �����¼���ж��Ƿ���������
	 * 
	 * @param value
	 * @param errorCode
	 * @return
	 */
	private String isStateXufei(String value,String errorCode){
		if(!("������").equals(value) ){
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
	 * �����Ѱ�װ��¼������
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
	 * �����¼���ж��Ƿ����Ѱ�װ
	 * @param value
	 * @param errorCode
	 * @return
	 */
	/*private String isStateAnzhuang(String value,String errorCode){
		if(!("�Ѱ�װ").equals(value) ){
			return errorCode;
		}
		
		return null;
	}*/
}
