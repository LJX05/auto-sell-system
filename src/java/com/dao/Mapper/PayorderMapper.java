/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.Mapper;

import com.dao.pojo.OrderItem;
import com.dao.pojo.PayOrder;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Michael
 */
public interface PayorderMapper {

    public void insertOrder(PayOrder payorder);

    public void insertItmeBatch(List<OrderItem> orderitems);

    public void updatOrderStatus(@Param("orderId") String orderId);

    public BigDecimal selectAmount(@Param("orderId")String orderId);
    
    public PayOrder   select(@Param("orderId")String orderId);
    public PayOrder   selectOrder(@Param("orderId")String orderId);
}
