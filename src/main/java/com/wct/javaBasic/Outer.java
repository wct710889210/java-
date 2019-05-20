package com.wct.javaBasic;

/**
 * 内部类测试
 */
public class Outer {
    String outerInfo;
    static int i = 1;

    {
        outerInfo = "info_out";
    }

    //成员内部类
    public class Inner{
        String info;
        //static String test;   //非静态内部类不能有静态变量和方法
        final static String a = "a";    //但非静态内部类可以定义常量

        public Inner(String info) {
            this.info = info;
        }

        public void show(){
            final int arg = 1;
            //方法内部类
            class InnerMethod{
                //构造函数
                InnerMethod(){

                }
                //static int a = 1;   //不能存在静态变量

                //方法内部类不能申明静态方法
                //  static String get(){
                //
                //  }

                public void print(){
                    System.out.println(arg);
                }
            }
            //匿名内部类
            new Runnable(){
                //static String a = "a";    //不能存在静态变量

                //匿名内部类不能申明静态方法
                //  static String get(){
                //
                //  }

                @Override
                public void run() {
                    String i = info;
                }
            };
            System.out.println("outer="+outerInfo+"|inner="+info);
        }

    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner("TEST");  //需要使用外部对象来创建成员内部类
        inner.show();
    }
}
