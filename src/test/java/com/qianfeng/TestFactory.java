package com.qianfeng;

public class TestFactory {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();
        Shape shape1 = shapeFactory.getShape("RECTANGLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();

    }
}
interface Shape {
    void draw();
}


class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square  implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
class ShapeFactory {
  public Shape getShape (String shapeType){
      if (shapeType == null){
          return null;
      }
      if (shapeType.equalsIgnoreCase("CIRCLE")) {
          return new Circle();
      }
      if (shapeType.equalsIgnoreCase("RECTANGLE")) {
          return new Rectangle();
      }
      if (shapeType.equalsIgnoreCase("SQUARE")) {
          return new Square();
      }
      return null;
  }
}