/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.pojo;

/**
 *
 * @author Michael
 */
public class Goods {

    private Integer id;
    private String goods_name;
    private Integer goods_number;
    private Float goods_price;
    private String goods_id;

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

    public Integer getGoods_number() {
        return goods_number;
    }

    public void setGoods_number(Integer goods_number) {
        this.goods_number = goods_number;
    }

    public Float getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Float goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

}
