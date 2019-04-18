/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.imp;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.dao.Mapper.GoodsMapper;
import com.dao.Mapper.PayorderMapper;
import com.dao.pojo.OrderItem;
import com.dao.pojo.PayOrder;
import com.fuzhu.OrderPayCode;
import com.service.AliPayService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
public class AliPayServiceImp implements AliPayService {

    @Autowired
    private PayorderMapper payorderMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public String payAndsaveOrder(OrderPayCode orderPayCode, AlipayClient alipayClient) {

//        AlipayClient alipayClient = new DefaultAlipayClient(AppPayConfig.URL, AppPayConfig.APPID,
//                AppPayConfig.RSA_PRIVATE_KEY, AppPayConfig.FORMAT, AppPayConfig.CHARSET,
//                AppPayConfig.ALIPAY_PUBLIC_KEY, AppPayConfig.SIGNTYPE);
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        AlipayTradePayModel model = new AlipayTradePayModel();
        request.setBizModel(model);//设置交易请求模块
        //获得订单参数
        PayOrder order = payorderMapper.selectOrder(orderPayCode.getOrderId());

        String amount = order.getAmount().toString();
        System.out.println(amount);
        //请求模块交易参数
        model.setOutTradeNo(orderPayCode.getOrderId());//流水号
        model.setSubject("超市表表小票");//设置商品标题
        model.setTotalAmount(amount);//设置总金额
        model.setAuthCode(orderPayCode.getCodeE());//支付Code
        model.setScene("bar_code");//设置类型 bar_Code 当面付
        model.setTimeoutExpress("3m");//设置交易时间5分
        System.out.println(model);
        AlipayTradePayResponse response = null;
        try {
            response = alipayClient.execute(request);
            System.out.println("调用成功！");
            System.out.println(response.getBody());
            System.out.println(response.getTradeNo());
            if (null != response.getCode()) {
                switch (response.getCode()) {
                    case "10000":
                        //交易成功
                        payorderMapper.updatOrderStatus(orderPayCode.getOrderId());//更新订单状态
                        //扣库存

                        List<OrderItem> orderItems = order.getOrderItems();
                        for (OrderItem orderItem : orderItems) {
                            goodsMapper.updateGoodsNum(orderItem.getItem_count() * -1, orderItem.getGoods_id());
                        }
                        return "10000";
                    case "40004":
                        //交易失败
                        return "40004";
                    case "20000":
                        //未知异常
                        return "20000";
                    case "10003":
                        //等待用户确认付款
                        return "10003";
                    default:
                        break;
                }
            }
        } catch (AlipayApiException e) {
            System.out.println("调用失败");
            e.printStackTrace();

        }
        return "20000";
    }

    @Override
    public String payWait(OrderPayCode orderPayCode, AlipayClient alipayClient) {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel model = new AlipayTradeQueryModel();//查询模块参数

        request.setBizModel(model);//设置交易请求模块
        model.setOutTradeNo(orderPayCode.getOrderId());//设置商品订单号
        // model.setTradeNo(tradeNo);支付宝交易号 2者不可同时为空
        try {
            AlipayTradeQueryResponse response = null;
            int t = 36;//等待3分钟
            while (t >= 0) {
                response = alipayClient.execute(request);
                String tradeStatus = response.getTradeStatus();
                if ("WAIT_BUYER_PAY".equals(tradeStatus)) {//交易创建，等待买家付款
                    Thread.sleep(5000);
                    t--;
                } else if ("TRADE_SUCCESS".equals(tradeStatus)) {//交易支付成功
                    //交易成功
                    payorderMapper.updatOrderStatus(orderPayCode.getOrderId());//更新订单状态
                    //扣库存
                    PayOrder order = payorderMapper.selectOrder(orderPayCode.getOrderId());
                    List<OrderItem> orderItems = order.getOrderItems();
                    for (OrderItem orderItem : orderItems) {
                        goodsMapper.updateGoodsNum(orderItem.getItem_count() * -1, orderItem.getGoods_id());
                    }
                    return "Success";
                } else if ("TRADE_CLOSED".equals(tradeStatus)) {//未付款交易超时关闭，或支付完成后全额退款
                    return "TRADE_CLOSED";
                } else if ("TRADE_FINISHED".equals(tradeStatus)) {//交易结束，不可退款
                    return "TRADE_FINISHED";
                }
            }
        } catch (AlipayApiException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return "TRADE_CLOSED";
    }

}
