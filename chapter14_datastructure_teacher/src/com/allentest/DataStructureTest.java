package com.allentest;

import org.junit.Test;

import java.util.HashMap;

/**
 * ClassName: DataStructureTest
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023.11.19 8:27
 * @ Version: v1.0
 */
public class DataStructureTest {
    @Test
    public void test01(){
        Object o = new Object();
        System.out.println("o = " + o);
    }

    @Test
    public void test02(){
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("AA", 1234);
    }
}
