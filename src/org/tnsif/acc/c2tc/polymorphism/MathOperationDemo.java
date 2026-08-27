package org.tnsif.acc.c2tc.polymorphism;

interface MathOp {
    int operate(int a, int b);
}

class Add implements MathOp {
    public int operate(int a, int b) {
        return a + b;
    }
}

class Sub implements MathOp {
    public int operate(int a, int b) {
        return a - b;
    }
}

public class MathOperationDemo {
    public static void main(String[] args) {
        MathOp obj;
        obj = new Add();
        System.out.println(obj.operate(10, 5)); // 15
        obj = new Sub();
        System.out.println(obj.operate(10, 5)); // 5
    }
}
