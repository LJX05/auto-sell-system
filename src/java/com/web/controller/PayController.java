/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.dao.pojo.OrderItem;
import com.dao.pojo.PayOrder;
import com.fuzhu.AppPayConfig;
import com.fuzhu.Message;
import com.fuzhu.OrderPayCode;
import com.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.service.AliPayService;

/**
 *
 * @author Michael
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private AliPayService aliPayService;

    @ResponseBody
    @RequestMapping(value = "/creatOrder ", method = RequestMethod.POST)
    public Message createPayOrder(@RequestBody PayOrder payorder) {
        System.out.println(payorder);
        Message message = new Message();
        //返回订单号
        message.setSuccess(orderService.createPayOrder(payorder));
        return message;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrderItem ", method = RequestMethod.POST)
    public Message addOrderItem(@RequestBody List<OrderItem> orderitems) {
        boolean ok = orderService.addOrderItem(orderitems);
        Message message = new Message();
        //返回订单号
        if (ok) {
            message.setSuccess(orderitems.get(0).getOrder_id());
        }
        return message;
    }

    @ResponseBody
    @RequestMapping(value = "/paycode ", method = RequestMethod.POST)
    public Message paycode(@RequestBody OrderPayCode orderPayCode) {
        System.out.println(orderPayCode);
        //将客户端 new 到 控制层 将减少服务端创建其对象的次数
        AlipayClient alipayClient = new DefaultAlipayClient(AppPayConfig.URL, AppPayConfig.APPID,
                AppPayConfig.RSA_PRIVATE_KEY, AppPayConfig.FORMAT, AppPayConfig.CHARSET,
                AppPayConfig.ALIPAY_PUBLIC_KEY, AppPayConfig.SIGNTYPE);
        String statusCode = aliPayService.payAndsaveOrder(orderPayCode, alipayClient);
        Message message = new Message();
        //返回订单号
        if (statusCode == "10000") {
            message.setSuccess("Success");
        } else if (statusCode == "10003") {//等待用户确认
            String waitCode = aliPayService.payWait(orderPayCode, alipayClient);
            message.setSuccess(waitCode);
        } else {
            message.setSuccess("Err");
        }
        return message;
    }
}
