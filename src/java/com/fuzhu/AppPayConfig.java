/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuzhu;

/**
 *
 * @author Michael
 */
public class AppPayConfig {

    // 1.商户appid
    public static String APPID = "2016092600597361";    
    
    //2.私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCMmplO611Tscj0snWJLCHXW+IatdEj6N+XD4TnnR7RK+cC9GmLGeLHdatLKK0w1ykkCwUN3LXIhomsWu84ASAQA3F4pnQJ5mFpEfZUU/pJxs1jSlbos5B16RJ5vBrMJ8Ep1nUyAPwW0SQMmJlq94w50ZRscKUcDX1tizKDGIrui0ANnPCR9FchhEl7ZPqwOaAZPBO/0TrcdE/WTFxDOkWs+pe3peWOzT4nepMt+qOSvfK1K6q8s3M39FF/ZBAQ8eHrNB9tsTdhUHYigg4LJ/na3LF3o5C7c6j6LMZZKdi3R3jFwW9nDSiWlKeqhW1yX4MLHHVt1hxV/iNrXXhLeKFvAgMBAAECggEARYN1gjgJBwThlmDYjT3daUzLB2uWf4t1Z4jLq3rZro5nAuX1fEkK/pPlYR42KexmMaSlFgplcUNas3StymF8CY66Pe0Fd5OH21t/DogKOQlpp8osF5YXOMRHVxoxoXeSH24guN0VxO4XRYb4apMCp98+4zH531moBk2IZpnurio7gN+DEacEuOryCU6Hi1cGWEwbqqVhFVgS9hFLqRuq/vmSuH7VUi63hOH6OB3T9+6o8gXsXreJY8uNA/wPTj31gPxCmlSCwVZJS98uXnUtcy2AS31SibiY4TU0Lz4tWnMTfgfMsxY0GKkqpzZDKENpaBW6p0DREVRPVcHHYKMbKQKBgQDTvs1rl8gAIqTWk4krRXeYzYXWWIVgIGu1dEee1f+xhdw4sK+Jy/5HqkZsyhfMDXHw1E7KNV/01ZeQEEpQrrVjbUExp5VDjTEmVbmhEy/9WanND6I1WE4yW0IKO/QMXZoOngSajCvR832lZ/Xm8FiF0QMBeLoXDN3zVyhR/wXotQKBgQCp/XQ5VPR0Ai+c15gLaw29AAxkfdx143FH50A6iSHtQ1Qdu502iAhdq9jkiODPhts4vs+BZ03eCfVnfCDzdO+UeRVzlJO1BFV1yWG4AdcyrdDqi6BA6ysx2iJazU34duhdSqRTISkJ2TGb5lE3HVcpwssb2ojix+bskH9IlexsEwKBgQCdy5f78U17RFYBDktvcsJQngB6HteuLhr2S2RAKwv0eGQH3yvBjcK+F1eKJQSc7PwXU7Avop0SsMXU9z7aZ4gHQ1kNLuzePW7+OW4vakQeEl6m0Vq5VEhZ4IYTaGBTgsGW2Q1nOsRBHqpoxFONOVlOx9bsltJe8RjKCg6jJGB77QKBgQCkkapuQq/yi5c6uYIKM9b2DdDxjOPdAZdO7DNDODWvNIp/yn12KJYo0VDGVzmFz+H1+sx7U96PwoZhbEueRqwWym6ZGdMx4QM3aAIBmU6UUrA6EXjQwJttxOeTjsUYcU2d28Bgdm77iNi9PGmN+QrEdEAcNCJnou4OQgnn5LUhHwKBgH0lvN+VwPwCEBi+qtFewqv8eZ7m102yzNi8WHPdD6LgD2jjPJFLxutkJFeHCHnjAaqdRRgC4LAWFpbH9sacr6D89ouftMBCFKFLBd+kQZHYFyPjf+yDeMoEVJneqNZJrYshE5cM1iHxGl11Um+nulfhprDTDu4KmCl5bwek2E3L";
    
    // 3.支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzEdAytfocCKJUAhHTTNpTDFGZCLnGEfbc/piysg/fposfDKD0mgwthJ7YkFGrSXbr/CUrAhrXWVc92FqvexRhNs/M+iEVOByhJKPbqBPlFdFGo1xLa7kXXzk86H8ghhHcA6IMqNpciwbspGQA1fSsLl/tagR/XEK9DUD1i553E7q/Wat2G6R2CWen+SPQ7aP70DZUgLaj3CBLAgdqTyrgFRNxdnlukMSKMIKsRTSeH+15roXG1U6+Ui/RYgORDHEkIJwiqouga8cAde2oISN9RTixKxULtLnO+k8DiQgdHg3L8IjAk5+EgJ1dnPPtnxxoVbV3mcYNmZlIQHZXAkc6wIDAQAB";
    
    // 4.服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.xxx.com/alipay/notify_url.do";
    
     //5.页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://www.xxx.com/alipay/return_url.do";
    
    // 6.请求支付宝的网关地址 沙箱 https://openapi.alipaydev.com/gateway.do
    public static String URL = "https://openapi.alipaydev.com/gateway.do";    
    
    // 7.编码
    public static String CHARSET = "utf-8";
    
    // 8.返回格式
    public static String FORMAT = "json";
    
    // 9.加密类型
    public static String SIGNTYPE = "RSA2";


}
