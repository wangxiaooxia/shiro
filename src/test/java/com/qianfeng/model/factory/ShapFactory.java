package com.qianfeng.model.factory;

public class ShapFactory {
    public Shape getShap(String type){
        if (type == null){
            return null;
        }
        if (type.equalsIgnoreCase("Rectangle")){
            return new Rectangle();
        }
        if (type.equalsIgnoreCase("Circle")){
            return new Cirecle();
        }
        return null;
    }
}
