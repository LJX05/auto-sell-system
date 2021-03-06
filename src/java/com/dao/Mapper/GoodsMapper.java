/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.Mapper;

import com.dao.pojo.Goods;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Michael
 */
public interface GoodsMapper {

    Goods selectGoods(String id);

    List<Goods> foundAll();

    void addGoods(Goods goods);

    public void update(Goods goods);

    public void updateGoodsNum(@Param("num") int num, @Param("goods_id") String goods_id);

    public void delete(String[] ids);

    public List<Goods> findPage(@Param("pagenum") int pageNum, @Param("size") int size);

    public Integer findCount();
}
