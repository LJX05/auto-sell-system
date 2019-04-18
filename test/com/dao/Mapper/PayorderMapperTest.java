/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.Mapper;

import com.dao.pojo.PayOrder;
import com.dao.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Michael
 */
public class PayorderMapperTest extends BaseTest {

    @Autowired
    private PayorderMapper payorderMapper;
    
    @Test
    public void testSelect() {
        String  orderId="bb07790cef4d4962803026bed3e70cc4";
       
    }

}
