/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.imp;

import com.dao.Mapper.GoodsMapper;
import com.dao.pojo.Goods;
import com.dao.pojo.PageResult;
import com.service.GoodsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
public class GoodsServiceImp implements GoodsService {

    @Autowired
    public GoodsMapper goodsMapper;

    @Override
    public Goods foudById(String id) {
        System.out.println("我进入服务层了");
        return goodsMapper.selectGoods(id);
    }

    @Override
    public List<Goods> foudAll() {
        return goodsMapper.foundAll();
    }

    @Override
    public void addGoods(Goods goods) {
        goodsMapper.addGoods(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsMapper.update(goods);
    }

    @Override
    public void deleteGoods(String[] ids) {
        goodsMapper.delete(ids);
    }

    @Override
    public PageResult findPage(int pageNum, int size) {
        //第1页就是 0 ，10  ; 2页  size+1, size
        System.out.println(pageNum);
        List<Goods> Goodses = goodsMapper.findPage((pageNum-1)*size, size);
        Integer total = goodsMapper.findCount();                
      
        PageResult pageResult = new PageResult(total, Goodses);

        return pageResult;
    }

}
