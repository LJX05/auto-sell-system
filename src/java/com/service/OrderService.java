/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.pojo.Orderitem;
import com.dao.pojo.Payorder;
import com.fuzhu.OrderPayCode;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface OrderService {

    public String  createPayOrder(Payorder payorder);

    public boolean addOrderItem(List<Orderitem> orderitems);

    
    
}
