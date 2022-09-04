package com.czh.controller.classloadOrder;


public class AAAA {
    public static void main(String[] args) {
        Superclass s = new Subclass(null);
        s.show(s);
    }
}
class Superclass {
    int num = 1;
    {
        System.out.println("First non-static blocks of Superclass");
        num = 2;
    }
    static {
        System.out.println("Static blocks of Superclass");
    }
    {
        init();
        System.out.println("Second non-static blocks of Superclass");
        num = 3;
    }
    Superclass() {
        this(1 << 4);
        System.out.println("No-arg constructor of Superclass");
    }
    Superclass(int num) {
        System.out.println("Int-arg constructor of Superclass: " + num);
    }
    void init() {
        System.out.println("Init method of Superclass: " + num);
    }
    void show(Object obj) {
        System.out.println("Object-arg show method of superclass run...");
    }
    void show(Superclass sup) {
        System.out.println("Superclass-arg show method run...");
    }
}
class Subclass extends Superclass {
    {
        init();
        System.out.println("First non-static blocks of Subclass");
        num = this instanceof Superclass ? -1 : 200;
        init();
    }
    Subclass() {
        System.out.println("No-arg constructor of Subclass");
    }
    static {
        System.out.println("Static blocks of Subclass");
    }
    int num = 100;
    Subclass(String args) {
        this();
        System.out.println("Int-arg constructor of Subclass: " + args);
    }
    {
        init();
        System.out.println("Second non-static blocks of Subclass");
    }
    void init() {
        System.out.println("Init method of Subclass: " + num);
    }
    void show(Object obj) {
        System.out.println("Object-arg show method of subclass run...");
    }
    void show(Subclass sub) {
        System.out.println("Subclass-arg show method run...");
    }
}