package com.allentest.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Consumer;

/**
 * ClassName: NewFeatureAllenTest
 * Description:
 * @ Author: Hanyuye
 * @ Date: 2023.11.24 14:32
 * @ Version: v1.0
 */
/*
 笔记：
   Lambda表达式，本质是作为接口实现类的对象；
   另一方面，lambda表达式是一个匿名函数。
   函数式编程：函数 = 对象；

   函数式接口提供实现类对象时，才能用Lambda表达式

 */
public class NewFeatureAllenTest {
    @Test
    public void test01(){
        //匿名内部类
        new Runnable(){
            @Override
            public void run() {
                System.out.println("匿名实现runnable接口的类，重写的run方法");
            }
        }.run();

        System.out.println("**************");
        //lambda表达式写法
        //FunctionalInterface 内部只有一个抽象方法，且没有形参
        Runnable r2 = () -> {
            System.out.println("学习lambda表达式、重写接口中唯一的抽象run方法。。。。。。");
        };
        r2.run();

    }

    @Test
    public void test02(){
        //lambda表达式，简写版，简写重写形参类型
        Comparator<Integer> comparator = (o1, o2) -> {
          return Integer.compare(o1, o2);
        };
        System.out.println("comparator.compare(11, 22) = " + comparator.compare(11, 22));

        //lambda表达式，简写版，简写删除大括号
        //Lambda体只有一条语句时，return 与大括号都可以省略
        Comparator<Character> comparator1 = (o1, o2) -> Character.compare(o1, o2);
        System.out.println("comparator1.compare('a', 'b') = " + comparator1.compare('a', 'b'));

        System.out.println("**************");
        //方法引用：要重写的方法参数和要重写的方法的内部调用到的方法参数列表一致、且（内部调用到的）是静态方法；
        //::可能是方法引用、构造器引用、数组引用。
        Comparator<Double> comparator2 = Double::compare;
        System.out.println("comparator2.compare(11.11, 9.9998) = " + comparator2.compare(11.11, 9.9998));

    }

    @Test
    public void test03(){
        //lambda String 类型推断，数据类型可以省略、当形参列表只有一个参数时小口号也能省略
        Consumer<String> consumer = /*(*//*String*/ s/*)*/ -> {
            System.out.println(s);
        };

        consumer.accept("test consumer");
        
        //类型推断
        HashMap<String, String> hashMap = new HashMap<>();
//        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        var entries = hashMap.entrySet();

    }

    @Test
    public void test04(){
        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("hello");
        myFunctionalInterface.hello();
    }

}
