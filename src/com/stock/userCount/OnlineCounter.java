package com.stock.userCount;

import java.util.Vector;

import com.hrbank.business.employee.Employee;

public class OnlineCounter {

    private static Vector<Employee> list = new Vector<Employee>();//在线会员

    private OnlineCounter(){
    	
    }

   // 统计当前在线会员人数
    public static void doUser(Object object,boolean bl) {
    	
    	Employee ua  = (Employee)object;
    
    	Employee ls_ua = new Employee();

        for (int i = 0; i < list.size(); i++) {
        	ls_ua = (Employee)list.get(i);
        	//同一账号重复登录不新增
        	if(bl==false && ua.getEmployeeCode().equals(ls_ua.getEmployeeCode())) {
        		return;     	
        	}

           //删除不在线的用户
            if(bl==true && ua.getEmployeeCode().equals(ls_ua.getEmployeeCode()))
            {
        	    list.remove(i);
            }
            
            //System.out.println(ua.getIcode());
            //System.out.println(ls_ua.getIcode());
        }
        //添加一个新的在线用户
        if(bl==false)   
            list.addElement(ua);
        
        //System.out.println(getOnlineCount());
     }


   public static int getOnlineCount() {
     //返回当前在线人数
     return list.size();
   }
   
   public static Vector<Employee> getOnline() {
     return list;
   }

   

}
