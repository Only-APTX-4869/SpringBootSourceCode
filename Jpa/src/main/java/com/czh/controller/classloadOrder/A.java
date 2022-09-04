package com.czh.controller.classloadOrder;

class A {
    int i = 1;

    A(int i) {
        this.i = i;
    }

    class B {
        B(int i) {
            this.i = i;
        }

        int i = 2;

        class C {
            C(int i) {
                this.i = i;
            }

            int i = 3;

            // 补充代码体：
            // 实现A类、B类、C类中变量i的值相加，并return该加值。
            public int add() {
                return 0;
            };
        }
    }

}

class Test {

    public static void main(String[] args) {
        int result = new A(1).new B(2).new C(3).add();
        System.out.println("结果是：" + result);
    }
}

