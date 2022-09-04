package com.czh.util.jwt;

/**
 * @author: baron
 * @date: 2020-01-13 23:32
 **/
public class TestHS256 {

    public static void main(String[] args) throws InterruptedException {
        TestHS256 t = new TestHS256();
        t.testHS256();
    }

    //测试HS256加密生成Token
    public static void testHS256() throws InterruptedException {
        String id = "001";
        String name = "chenzhenhua";
        String passworld = "123456";
        String token = JWTHS256.buildJWT(id + name + passworld);
        //解密token
        System.out.println("token已生成" + token);
        String account = JWTHS256.vaildToken(token);
        System.out.println("token的账号：" + account + "测试token过期,10秒后过期------");
        Thread.sleep(10 * 1000);
        System.out.println("解析token" + JWTHS256.vaildToken(token));
    }
}
