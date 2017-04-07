package com.stock.paigongdan;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.common.Validator;

public class PGDValidator extends Validator{
	
	public String insertValidate(EntityPGD pgd) throws Exception{
		initErrors();
		addError(isEmpty(pgd.getXiaoquname(),ErrorConstant.IMPORT_XIAOQU_EMPTY));
		addError(isEmpty(pgd.getUserplace(),ErrorConstant.IMPORT_DIZHI_EMPTY));
		addError(isEmpty(pgd.getUsertel(),ErrorConstant.IMPORT_USERTEL_EMPTY));
		
		addError(isEmpty(pgd.getUsertel(),ErrorConstant.IMPORT_USERTEL_EMPTY));
		
		return getErrorCode();
	}	
	
	public static boolean isEligible(int age){  
		 
		return age > 18;  
		 
		} 
	public void sys(){
		System.out.println("===");
	}
	
	public String syss(String a){
		System.out.println("333333");
		System.out.println(a);
		return a;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		isEligible(1);
		
		try {
			Class<?> c = Class.forName("com.stock.paigongdan.PGDValidator");
			Object o = c.newInstance();
			Method method ,me;
			try {
				method = o.getClass().getMethod("sys");
				Object object = method.invoke(o);
				System.out.println(object);
				
				me = o.getClass().getMethod("syss", new  Class[]{String.class});
				Object obj = me.invoke(o, new Object[]{"1"});
				System.out.println(obj);
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			System.out.println(" Ù–‘£∫");
	         Field f[] = c.getDeclaredFields();
	         for (int i = 0; i < f.length; i++) {
	             System.out.println(f[i].getName());
	         }
	         System.out.println("∑Ω∑®£∫");
	         Method m[] = c.getDeclaredMethods();
	         for (int i = 0; i < m.length; i++) {
	             System.out.println(m[i].toString());
	         }
	         try {
	        	 
				c.getModifiers();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 

		System.out.println(isEligible(1));
	}
}
