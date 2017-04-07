package com.stock.userCount;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.takucin.aceeci.common.Constant;

public class SessionListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent event)
    {
        if (event.getName().equals(Constant.LOGIN_USER))//������ǰ����������session.setAttribute("userid")�Ƿ����
        {
            try
            {
            	//System.out.println("add");
                OnlineCounter.doUser(event.getValue(),false);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }

    public void attributeRemoved(HttpSessionBindingEvent event)
    {
    	if (event.getName().equals(Constant.LOGIN_USER))//������ǰ����������session.setAttribute("userid")�Ƿ����
        {
    		try
    		{
    			//System.out.println("delete");
    			OnlineCounter.doUser(event.getValue(),true);
    		}catch (Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    }

 
 
    public void attributeReplaced(HttpSessionBindingEvent event)
    {
    	
    }


}
