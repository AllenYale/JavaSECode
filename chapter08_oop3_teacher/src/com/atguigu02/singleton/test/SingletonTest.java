package com.atguigu02.singleton.test;

/**
 * ClassName: SingletonTest
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023/11/7 7:43
 * @ Version: v1.0
 */
public class SingletonTest {
    public static void main(String[] args) {
        Person person1 = Person.person;
        Person person2 = Person.person;
        System.out.println(person2==person1);
    }
}

class Person{
    public static Person person = new Person();

    private Person(){

    }

//    public static Person getPersonInstance(){
//        person = new Person();
//        return person;
//    }


}
