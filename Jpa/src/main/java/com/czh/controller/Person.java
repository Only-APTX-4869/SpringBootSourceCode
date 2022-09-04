package com.czh.controller;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public static void main(String[] args){
      List list1 = new ArrayList();
      list1.add(0);
      List list2 = list1;

      System.out.println(list1.get(0)instanceof Integer);
      System.out.println(list2.get(0)instanceof Integer);

    }
}
