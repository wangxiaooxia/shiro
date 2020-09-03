package com.qianfeng.model.factory;

public class FactoryDemo {
    public static void main(String[] args) {
        ShapFactory shapFactory = new ShapFactory();
        Shape shape = shapFactory.getShap("Rectangle");
        shape.draw();
        Shape shape1 = shapFactory.getShap("Circle");
        shape1.draw();
    }
}
