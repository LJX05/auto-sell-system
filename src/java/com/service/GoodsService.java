/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.pojo.Goods;
import com.dao.pojo.PageResult;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface GoodsService {

    public Goods FoudById(String id);

    public List<Goods> FoudAll();

    public void AddGoods(Goods goods);

    public void UpdateGoods(Goods goods);

    public void DeleteGoods(String[] ids);

    public PageResult findPage(int page, int size);
    
    
}
