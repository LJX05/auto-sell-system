/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.pojo.OrderItem;
import com.dao.pojo.PayOrder;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface OrderService {

    public String  createPayOrder(PayOrder payorder);

    public boolean addOrderItem(List<OrderItem> orderitems);

    
    
}
