package com.wct.javaBasic.classInfo;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy{
    Toy(){}
    Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
    FancyToy(){
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class c){
        System.out.println("类名："+c.getName()+"--是否为接口"+c.isInterface());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.wct.javaBasic.classInfo.FancyToy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
