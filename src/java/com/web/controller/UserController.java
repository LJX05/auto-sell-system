/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.controller;

import com.fuzhu.Message;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Michael
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @RequestMapping(value = "/loginUser ", method = RequestMethod.POST)
    public Message loginUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("999999999999999");
        System.out.println(name);
        Message message = new Message();
        message.setSuccess(name);
        return message;
    }

}
