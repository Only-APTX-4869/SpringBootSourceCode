package com.czh.JDK8;

import com.czh.entity.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args){

        HashMap<String, String> map = new HashMap<String, String>(){{
            put("a","A");
            put("b","B");
        }};
        //lambad
        map.forEach((k,v) ->{
            System.out.println("k="+k+",v="+v);
        } );
        //推荐方法
        for(Map.Entry<String,String> entry:map.entrySet()){
           System.out.println("k="+entry.getKey()+",v="+entry.getValue());
        }

        Student student = new Student();
        student.setName("李雷");
        student.setSex("男");
        ArrayList<Student>  list = new ArrayList<>();
        list.add(student);
        // 使用 stream 流
        List<String> names1 =list.stream().map(item -> item.getName()).collect(Collectors.toList());
        System.out.println(names1);
        System.out.println("------------华丽的分割线----------------");
        List<String> names2 =list.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(names2);
    }

}
