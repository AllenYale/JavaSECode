package com.atguigu03.date.allenTest;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName: DateAllenTest
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023/11/15 16:57
 * @ Version: v1.0
 */
public class DateAllenTest {
    @Test
    public void test(){
        //java.util.date
        Date date = new Date();
        System.out.println(date);//Wed Nov 15 17:05:04 CST 2023

        System.out.println(date.toString());

        long dateTime = date.getTime();
        System.out.println(dateTime);

        Date date1 = new Date(dateTime);
        Date date2 = new Date(13241431234123L);
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);

        //java.sql.date 对应数据库中date类型

    }

    @Test
    public void test02(){
        java.sql.Date date = new java.sql.Date(1700039018754L);
        System.out.println("date = " + date);// 2023-11-15
    }

    @Test
    public void test03(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.sql.Date date = new java.sql.Date(new Date().getTime());
        String format = sdf.format(date);
        System.out.println("format = " + format);


    }


    @Test
    public void test04(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());
        System.out.println(Calendar.DAY_OF_MONTH);
        System.out.println(Calendar.DAY_OF_MONTH);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));

        calendar.set(Calendar.YEAR, 2011);
        Calendar.getInstance().set(Calendar.YEAR, 2011);
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.add(Calendar.YEAR, -1);
        System.out.println(calendar.get(Calendar.YEAR));

        //Calendar --> Date
        Date time = calendar.getTime();
        System.out.println(time);

        calendar.setTime(time);


    }


    @Test
    public void test05(){
        Employee employee = new Programmer();
//        Architect architect = (Architect)employee;  java.lang.ClassCastException: com.atguigu03.date.allenTest.Programmer cannot be cast to com.atguigu03.date.allenTest.Architect
        Programmer program = (Programmer)employee;
        if(employee instanceof Programmer){
            System.out.println("是程序员");
        } else if (employee instanceof Architect) {
            System.out.println("是架构师");
        } else if (employee instanceof DevelopArchitect) {
            System.out.println("是开发架构师");
        }
    }

}

class Employee {

}

class Programmer extends Employee{

}

class Architect extends Programmer{

}

class DevelopArchitect extends Architect{

}


