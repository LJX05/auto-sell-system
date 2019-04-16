/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuzhu;

/**
 *
 * @author Michael
 */
public class OrderPayCode {
    private String codeE;
    private String orderId;

    public String getCodeE() {
        return codeE;
    }

    public String getOrderId() {
        return orderId;
    }
    
    public void setCodeE(String codeE) {
        this.codeE = codeE;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderPayCode{" + "codeE=" + codeE + ", orderId=" + orderId + '}';
    }
    
}
