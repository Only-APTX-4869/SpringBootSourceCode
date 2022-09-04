package com.czh.controller;

class Parent {

    private int data;

    public Parent(int d){ data = d; }

}

class Child extends Parent{

    String name;

    public Child(String s, int d){ //john 10,
    

                name = s;

    }

}
