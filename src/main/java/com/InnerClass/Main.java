package com.InnerClass;

import com.alibaba.fastjson.JSON;

import java.util.Date;

/**
 * @author : wangxuan
 * @date : 10:49 2020/6/19 0019
 */
public class Main {
    public static void main(String[] args) {

//        Outer.method().show();
////        Outer.Inner inner = new Outer().new Inner("wang");
////        inner.show();
////
////        user u = JSON.parseObject("wang",user.class);
////
////        new Thread(() -> {
////            System.out.println("ja");
////        });
        new user(()->{
            System.out.println("running");
        }).Start();


    }
}
class user{
    private run r;
    public user(run r){
        this.r = r;
    }
    public void Start(){
        r.run();
    }
}
interface run{
    public void run();
}
interface Inter {
    public void show();
}
class Outer {

    private static String name;
    private String age;
    public static Inter method() {
        //匿名类
        return new Inter() {
            @Override
            public void show() {
                System.out.println("inner");
            }
        };
    }

    static class StaticInner{
        public void getName(){
            System.out.println(name);
            //只能访问静态成员
//            System.out.println(age);
        }
    }

    //内部类
    class Inner{
        //不能有静态变量
        //static  int a;
        private String name;
        public Inner(String name){
            this.name = name;
        }
        public void show(){
            System.out.println(name);
        }
        public void show1(){
            //局部内部类
            class inner1{
                private String name;
                public inner1(String name){
                    this.name = name;
                }
                public void show(){
                    System.out.println(name);
                }
            }

            new inner1("xuan").show();
        }
    }
    public void TestDate(){
        //匿名内部类
        System.out.println(new Date(){
            public long getTime(){
                return 1234;
            }
        });
    }
}
