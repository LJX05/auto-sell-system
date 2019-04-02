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

    void AddGoods(Goods goods);

    public void Update(Goods goods);

    public void Delete(String[] ids);

    public List<Goods> findPage(@Param("pagenum") int pageNum,@Param("size")  int size);
}
