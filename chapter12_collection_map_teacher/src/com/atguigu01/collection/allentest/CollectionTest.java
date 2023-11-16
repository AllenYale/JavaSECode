package com.atguigu01.collection.allentest;

import org.junit.Test;

import java.util.*;

/**
 * ClassName: CollectionTest
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023/11/16 11:47
 * @ Version: v1.0
 */
//TODO：2023年11月16日23:19:54 - Map value值为什么要实现equals（）方法？？（key要同时实现hashcode方法、equals方法）
public class CollectionTest {
    @Test
    public void test01() {
        Collection collection = new ArrayList();
        collection.add(new Person("allen", 28));
        collection.add("testString");
        collection.add(12345);
        collection.add(new char[]{'a', 'b'});
        System.out.println(collection);

        ArrayList arrayList = new ArrayList();
        arrayList.addAll(collection);
        System.out.println("arrayList = " + arrayList);

        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(collection);
        System.out.println("arrayList1 = " + arrayList1);

        //自定义对象必须重写equals方法
        System.out.println("collection.contains(new Person(\"allen\",28)) = " + collection.contains(new Person("allen", 28)));
    }

    //自动装箱128陷阱
    @Test
    public void test02() {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println("i3 == i4 = " + (i3 == i4));
    }

    public static void main(String[] args) {
        Integer a1 = 56;
        int a2 = 56;
        Integer b = 56;
        Integer c = new Integer(56);
        System.out.println(a1 == a2);
        System.out.println(a1 == b);
        System.out.println(a1 == c);
        Integer d = 128;
        Integer e = 128;
        System.out.println(d == e);
        System.out.println(d.intValue() == e.intValue());
        System.out.println(d.equals(e));

    }

    /**
     * 测试增强for循环和普通for循环对数组的修改
     *
     * 结论：增强for （foreach）循环，不能够修改数组中变量
     */
    @Test
    public void test04(){
        String[] strings = new String[]{"str1","str2","str3"};
        for (String string : strings) {
            string = "haha";
        }
        System.out.println(Arrays.toString(strings));

        int[] irr = new int[]{1,2,3};
        for (int i : irr) {
            i = 100;
        }
        System.out.println(Arrays.toString(irr));

        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(123);
        arrayList.add(123);
        arrayList.add(123);

        for (Object o : arrayList) {
            o = "333";
        }
        System.out.println("arrayList = " + arrayList);

    }

    @Test
    public void test06(){
        HashSet hashSet = new HashSet();
        hashSet.add("aaa");
        hashSet.add("bbb");
        hashSet.add("ccc");
        hashSet.add("ddd");

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("ddd");
        linkedHashSet.add("ccc");
        linkedHashSet.add("bbb");
        linkedHashSet.add("aaa");

        //set 存入和输出顺序不一致：无序、不可重复
        System.out.println("hashSet = " + hashSet);

        //加了链表、保证有序
        System.out.println("linkedHashSet = " + linkedHashSet);
    }
}
