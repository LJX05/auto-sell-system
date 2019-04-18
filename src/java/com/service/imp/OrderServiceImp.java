/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.imp;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.dao.Mapper.PayorderMapper;
import com.dao.pojo.OrderItem;
import com.dao.pojo.PayOrder;
import com.fuzhu.OrderPayCode;
import com.service.OrderService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 *
 * @author Michael
 */
@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private PayorderMapper payorderMapper;

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    @Override
    public String createPayOrder(PayOrder payorder) {
        try {
            if (payorder.getAmount().compareTo(BigDecimal.ZERO)>0) {
            //创建订单完善信息
            payorder.setCreate_time(new Date());
            payorder.setOrder_id(UUID.randomUUID().toString().replace("-", ""));
            payorder.setStatus(Boolean.FALSE);
            //保存订单 数据库处理
            payorderMapper.insertOrder(payorder);                   
            }        
        } catch (Exception e) {
            System.out.println("添加用户异常,报错信息:" + e.getMessage());
            //手动回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
        return payorder.getOrder_id();
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    @Override
    public boolean addOrderItem(List<OrderItem> orderitems) {
        try {
            payorderMapper.insertItmeBatch(orderitems);
            return true;
        } catch (Exception e) {
            System.out.println("添加用户异常,报错信息:" + e.getMessage());
            //手动回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }

    }


}
