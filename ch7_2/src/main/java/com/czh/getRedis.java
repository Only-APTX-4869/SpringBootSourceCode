package com.czh;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class getRedis {

    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        System.out.println(jedis.ping());

        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        keys.stream().forEach(System.out::println);
//        Iterator<String> it=keys.iterator() ;
//        while(it.hasNext()){
//            String key = it.next();
//            System.out.println(key);
//        }
    }
}
