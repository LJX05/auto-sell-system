/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.controller;

import com.dao.pojo.Goods;
import com.dao.pojo.Page;
import com.dao.pojo.PageResult;
import com.fuzhu.Message;
import com.service.GoodsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Michael
 */
@RestController
@RequestMapping("/auto")
public class GoodsCountroller {

    @Autowired
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "/found", method = RequestMethod.POST)
    public Goods FoudById(@RequestBody String id) {
        System.out.println("我成功了" + id);
        return goodsService.FoudById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Goods> FoudAll() {
        List<Goods> foudAll = goodsService.FoudAll();
        return foudAll;
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Message Add(@RequestBody Goods goods) {
        goodsService.AddGoods(goods);
        Message message = new Message();
        message.setSuccess("添加成功！！！");
        return message;
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Message Update(@RequestBody Goods goods) {
        System.out.println(goods);
        System.out.println("Update()");
        goodsService.UpdateGoods(goods);
        Message message = new Message();
        message.setSuccess("修改成功！！！");
        return message;
     
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Message  Delete(@RequestBody String[] ids) {
        goodsService.DeleteGoods(ids);
        Message message = new Message();
        message.setSuccess("删除成功！！！");
        return message;
    }
    
    @ResponseBody
    @RequestMapping(value = "/findPage", method = RequestMethod.POST)
    public PageResult  findPage(@RequestBody Page p ) { //当前页 和 每页查询的数量
        System.out.println(p.getPage()+"---"+p.getSize());
        return  goodsService.findPage(p.getPage() ,p.getSize());
      
    }

}
