package com.stock.userCount;

import java.util.Vector;

import com.hrbank.business.employee.Employee;

public class OnlineCounter {

    private static Vector<Employee> list = new Vector<Employee>();//���߻�Ա

    private OnlineCounter(){
    	
    }

   // ͳ�Ƶ�ǰ���߻�Ա����
    public static void doUser(Object object,boolean bl) {
    	
    	Employee ua  = (Employee)object;
    
    	Employee ls_ua = new Employee();

        for (int i = 0; i < list.size(); i++) {
        	ls_ua = (Employee)list.get(i);
        	//ͬһ�˺��ظ���¼������
        	if(bl==false && ua.getEmployeeCode().equals(ls_ua.getEmployeeCode())) {
        		return;     	
        	}

           //ɾ�������ߵ��û�
            if(bl==true && ua.getEmployeeCode().equals(ls_ua.getEmployeeCode()))
            {
        	    list.remove(i);
            }
            
            //System.out.println(ua.getIcode());
            //System.out.println(ls_ua.getIcode());
        }
        //���һ���µ������û�
        if(bl==false)   
            list.addElement(ua);
        
        //System.out.println(getOnlineCount());
     }


   public static int getOnlineCount() {
     //���ص�ǰ��������
     return list.size();
   }
   
   public static Vector<Employee> getOnline() {
     return list;
   }

   

}
