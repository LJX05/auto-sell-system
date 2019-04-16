/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Michael
 */
public class Orderitem implements Serializable {

    private Integer id;

    private Integer item_count;

    private BigDecimal item_amount;

    private String order_id;

    private String goods_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem_count() {
        return item_count;
    }

    public void setItem_count(Integer item_count) {
        this.item_count = item_count;
    }

    public BigDecimal getItem_amount() {
        return item_amount;
    }

    public void setItem_amount(BigDecimal item_amount) {
        this.item_amount = item_amount;
    }
   

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

   

    @Override
    public String toString() {
        return "Orderitem{" + "id=" + id + ", item_count=" + item_count + ", item_amount=" + item_amount + ", order_id=" + order_id + ", goods_id=" + goods_id + '}';
    }

}
