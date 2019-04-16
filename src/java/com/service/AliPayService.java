/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.alipay.api.AlipayClient;
import com.fuzhu.OrderPayCode;

/**
 *
 * @author Michael
 */
public interface AliPayService {

    public String  payAndsaveOrder(OrderPayCode orderPayCode,AlipayClient alipayClient);

    public String payWait(OrderPayCode orderPayCode,AlipayClient alipayClient);
    
}
