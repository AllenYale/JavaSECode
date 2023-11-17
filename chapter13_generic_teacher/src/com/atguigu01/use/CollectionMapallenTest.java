package com.atguigu01.use;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: CollectionMapallenTest
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023.11.17 21:30
 * @ Version: v1.0
 */
public class CollectionMapallenTest {
    @Test
    public void test01() {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("allen", 28);
        hashMap.put("clark", 30);
        hashMap.put("lulu", 29);

//        Set<Map.Entry<String, Integer>> set = hashMap.entrySet();
//        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();

//JDK10 新特性，var修饰变量；直接类型推断。省略变量的类型书写。
        var set = hashMap.entrySet();
        var iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println("next.getKey() + \"--->\" + next.getValue() = " + next.getKey() + "--->" + next.getValue());
        }
    }
}
