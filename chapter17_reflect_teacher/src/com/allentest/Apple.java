package com.allentest;

/**
 * ClassName: Apple
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023.11.24 11:40
 * @ Version: v1.0
 */
public class Apple implements Fruit{
    @Override
    public void squeeze() {
        System.out.println("squeeze：\n" +
                "挤压，捏；挤出，榨出（液体等）；---APPLE");
    }
}
