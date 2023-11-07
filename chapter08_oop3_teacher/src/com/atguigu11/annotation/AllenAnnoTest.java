package com.atguigu11.annotation;

import org.junit.Test;

/**
 * ClassName: AllenAnnoTest
 * Description:
 *
 * @Author hanyuye
 * @Create 2023/11/7 15:02
 * @Version 1.0
 * @IDE idea_mac_m1
 */
@AllenAnnotationTest(value = "class")
public class AllenAnnoTest {
    private String name;

    public static void main(String[] args) {
        System.out.println(new AllenAnnoTest().name);
    }
}



