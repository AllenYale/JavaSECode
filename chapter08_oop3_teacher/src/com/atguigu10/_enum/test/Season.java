package com.atguigu10._enum.test;

/**
 * ClassName: Season
 * Description:
 *
 * @Author hanyuye
 * @Create 2023/11/7 12:11
 * @Version 1.0
 * @IDE idea_mac_m1
 */
public enum Season implements Show{
    SPRING("this is spring"){
        @Override
        public void show() {
            System.out.println("spring show");
        }
    },
    SUMMER("this is summer"),
    AUTUMN("this is autumn"),
    WINTER("this is winter");

    private final String seasonName;

    Season(String seasonName){
        this.seasonName = seasonName;
    }

    //如果枚举对象没有自动重写实现接口的方法，调用枚举类默认的实现接口方法
    @Override
    public void show() {
        System.out.println("默认实现方法");
    }
}