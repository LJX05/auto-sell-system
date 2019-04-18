/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Goods implements Serializable {

   
    private Integer id;
  
    private String goods_name;
   
    private int goods_number;
   
    private BigDecimal goods_price;
 
    private String goods_id;
    
    private List<OrderItem> orderitems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public int getGoods_number() {
        return goods_number;
    }

    public void setGoods_number(int goods_number) {
        this.goods_number = goods_number;
    }

    public BigDecimal getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(BigDecimal goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public List<OrderItem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<OrderItem> orderitems) {
        this.orderitems = orderitems;
    }

    @Override
    public String toString() {
        return "Goods{" + "id=" + id + ", goods_name=" + goods_name + ", goods_number=" + goods_number + ", goods_price=" + goods_price + ", goods_id=" + goods_id + ", orderitems=" + orderitems + '}';
    }
    

   
    
}
