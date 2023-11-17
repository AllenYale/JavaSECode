package com.atguigu05.map.allentest;

import org.junit.Test;

import java.util.*;

/**
 * ClassName: MapTest
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023.11.17 10:29
 * @ Version: v1.0
 */
public class MapTest {
    @Test
    public void test01(){
        //底层：数组+单向链表+红黑树（jdk8）
        HashMap hashMap = new HashMap();
        hashMap.put(null, null);
        hashMap.put("name", "allen");
        hashMap.put("name1", "allen");
        hashMap.put("name2", "allen");
        System.out.println("hashMap = " + hashMap);

//        Hashtable hashtable = new Hashtable();
//        hashtable.put(null, "test");
//        hashtable.put("name", null);
//        System.out.println("hashtable = " + hashtable);

        //hashmap基础上，数据结构增加了双向链表
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("name","allen");
        linkedHashMap.put("age","28");
        linkedHashMap.put("address","hz");
        linkedHashMap.remove("name","allen");
        Set set = linkedHashMap.keySet();
        for (Object o : set) {
            System.out.println("o = " + o);
        }

        Collection values = linkedHashMap.values();
        for (Object value : values) {
            System.out.println("value = " + value);
        }

        Set entrySet = linkedHashMap.entrySet();
        for (Object o : entrySet) {
            System.out.println("o = " + o);
            Map.Entry entry = (Map.Entry) o;
            System.out.println("entry.getKey() = " + entry.getKey());
            System.out.println("entry.getValue() = " + entry.getValue());
        }

        System.out.println("linkedHashMap = " + linkedHashMap);

        //底层使用红黑树
        TreeMap treeMap = new TreeMap();


    }

    @Test
    public void test02(){
        //底层：数组+单向链表+红黑树（jdk8）
        HashMap hashMap = new HashMap();
        hashMap.put(null, null);
        hashMap.put("name", "allen");
        hashMap.put("name1", "allen");
        Object put = hashMap.put("name2", "allen");
        System.out.println("put = " + put);

        System.out.println("hashMap = " + hashMap);

        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println("iterator.next() = " + iterator.next());
        }
    }
}
