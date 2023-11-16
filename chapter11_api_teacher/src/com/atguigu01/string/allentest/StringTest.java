package com.atguigu01.string.allentest;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * ClassName: StringTest
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023/11/15 13:50
 * @ Version: v1.0
 */
public class StringTest {
    //编码&解码 StringAPI Test
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str1 = "abc中国";//系统默认使用utf8方式编码、解码；编码到字节数组中时，英文使用ASCII码，中文使用编码方式的字符集方式编码。
        byte[] str1Bytes = str1.getBytes();
        for (int i = 0; i < str1Bytes.length; i++) {
            System.out.println(str1Bytes[i]);
        }

        String str = new String(str1Bytes, "utf-8");
        System.out.println(str);
        System.out.println(str.isEmpty());

        String str2 = "abctesthahaha";
        boolean test = str2.startsWith("test", 3);
        System.out.println(test);
//        System.out.println(str1Bytes);
    }

    @Test
    //交换字符串部分顺序
    public void test01() {
        String str1 = "hello_ABCD_world";
        String reverseString = reverseString(str1, 6, 10);
        System.out.println(reverseString);
    }

    /**
     * 翻转字符串中字符【fromIndex开始到toIndex）
     *
     * @param str
     * @param fromIndex
     * @param toIndex
     * @return
     */
    public String reverseString(String str, int fromIndex, int toIndex) {
        //
        char[] toCharArray = str.toCharArray();
        for (int i = fromIndex, j = toIndex - 1; i <= j; i++, j--) {
            char temp = toCharArray[i];
            toCharArray[i] = toCharArray[j];
            toCharArray[j] = temp;
        }
        return new String(toCharArray);
    }

    @Test
    public void test02() {
        String str = "abkkcadkabkebfkabkskabab";
        int ab = findHowManyTimesOccur(str, "ab");
        System.out.println(ab);
    }


    /**
     * ：获取一个字符串在另一个字符串中出现的次数。
     * 比如：获取"ab"在 "abkkcadkabkebfkabkskabab" 中出现的次数
     *
     * @param str
     * @param subStr
     * @return
     */
    public int findHowManyTimesOccur(String str, String subStr) {
        int count = 0;
        int index;
        while ((index = str.indexOf(subStr)) >= 0) {
            count++;
            str = str.substring(index + subStr.length());
        }
        return count;
    }
}
