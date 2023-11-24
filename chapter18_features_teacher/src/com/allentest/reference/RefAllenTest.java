package com.allentest.reference;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * ClassName: RefAllenTest
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023.11.24 15:31
 * @ Version: v1.0
 */
/*
* 方法引用，重写方法内部只有一行语句；
* */
public class RefAllenTest {

    //方法引用：情况1：对象：：实例方法
    @Test
    public void test01(){

        //方法引用：重写方法参数和调用方法参数一致，返回类型一致；（可以看做调用方法对重写方法的替换，且省去一切匿名类和方法重写过程）
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("test ref....");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("测试方法引用。。。。");

        //方法引用： 重写方法的形参列表和返回类型和内部调用的是一样的，可以做替换（覆盖）
        Employee employee = new Employee(1001, "allen");
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return employee.getName();
            }
        };
        System.out.println("supplier.get() = " + supplier.get());

        Supplier<String> supplier1 = () -> employee.getName();
        System.out.println("supplier1 = " + supplier1);

        Supplier<String> supplier2 = employee::getName;
        System.out.println("supplier2.get() = " + supplier2.get());
    }

    //方法引用：情况2：类：：静态方法
    @Test
    public void test02(){
        Function<Double, Long> function = aDouble -> Math.round(aDouble);

        //针对double，返回long值；方法引用
        Function<Double, Long> function1 = Math::round;

    }

    //方法引用：情况3：类：：对象方法（难）
    /*
    规则：当重写的方法的参数列表参数个数为n是，该方法内部调用的方法参数个数为n-1；
    且放回类型一致；且内部方法将第一个参数作为调用者，第二个参数作为参数传入
     */

    @Test
    public void test03(){
        Comparator<String> comparator = (o1, o2) -> o1.compareTo(o2);

        Comparator<String> comparator1 = String::compareTo;
        System.out.println("comparator1.compare(\"zabcd\", \"bcd\") = " + comparator1.compare("zabcd", "bcd"));
    }

//构造器引用: 类名：：new；调用了类中某一个确定的构造器，（取决于函数式结构抽象方法的形参列表（个数、类型确定））
//数组引用：数组名[]::new
    @Test
    public void test05(){
        Supplier<Employee> supplier = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee(1001);
            }
        };
        System.out.println("supplier.get() = " + supplier.get());

        Supplier<Employee> supplier2 = Employee::new;
        System.out.println("supplier2.get() = " + supplier2.get());

        System.out.println("**********构造器引用2******");
        BiFunction<Integer, String, Employee> biFunction = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer integer, String s) {
                return new Employee(integer, s);
            }
        };
        System.out.println("biFunction.apply(1001, \"allenyale\") = " + biFunction.apply(1001, "allenyale"));

        //调用的是和形参列表一致的构造器，此处为 int 和string
        BiFunction<Integer, String, Employee> biFunction2 = Employee::new;

        System.out.println("*********数组引用********");
        Function<Integer,Employee[]> function = new Function<Integer, Employee[]>() {
            @Override
            public Employee[] apply(Integer length) {
                return new Employee[length];
            }
        };

        Function<Integer,Employee[]> function2 = Employee[]::new;//只关注结果，不关注过程。
        Employee[] employees = function2.apply(10);
        System.out.println("employees.length = " + employees.length);
    }
}

