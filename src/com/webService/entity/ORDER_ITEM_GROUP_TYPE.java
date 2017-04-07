package com.webService.entity;

/**
 * 订单项实体
 * @author Xinhua-Zhao
 * @date： 日期：2015-1-28 时间：上午11:15:26
 */
public class ORDER_ITEM_GROUP_TYPE {
    private String order_item_group_id;
    private String cust_order_id;
    private String service_offer_id;
    private String service_offer_name;
    private String accept_time;
    public String getOrder_item_group_id() {
        return order_item_group_id;
    }
    public void setOrder_item_group_id(String order_item_group_id) {
        this.order_item_group_id = order_item_group_id;
    }
    public String getCust_order_id() {
        return cust_order_id;
    }
    public void setCust_order_id(String cust_order_id) {
        this.cust_order_id = cust_order_id;
    }
    public String getService_offer_id() {
        return service_offer_id;
    }
    public void setService_offer_id(String service_offer_id) {
        this.service_offer_id = service_offer_id;
    }
    public String getService_offer_name() {
        return service_offer_name;
    }
    public void setService_offer_name(String service_offer_name) {
        this.service_offer_name = service_offer_name;
    }
    public String getAccept_time() {
        return accept_time;
    }
    public void setAccept_time(String accept_time) {
        this.accept_time = accept_time;
    }
    
}
