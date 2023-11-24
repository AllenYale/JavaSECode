package com.allentest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * ClassName: ReflectionAllenTest
 * Description:
 *
 案例：榨汁机榨水果汁，水果分别有苹果(Apple)、香蕉(Banana)、桔子(Orange)等。

 效果如图。

 提示：
 1、声明(Fruit)水果接口，包含榨汁抽象方法：void squeeze(); /skwiːz/

 2、声明榨汁机(Juicer)，包含运行方法：public void run(Fruit f)，方法体中，调用f的榨汁方法squeeze()

 3、声明各种水果类，实现水果接口，并重写squeeze();

 4、在src下，建立配置文件：config.properties，并在配置文件中配上fruitName=xxx（其中xx为某种水果的全类名）

 5、在FruitTest测试类中，
 （1）读取配置文件，获取水果类名，并用反射创建水果对象，
 （2）创建榨汁机对象，并调用run()方法
 * @ Author: Hanyuye
 * @ Date: 2023.11.24 11:38
 * @ Version: v1.0
 */
public class ReflectionAllenTest {
    @Test
    public void test01() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //读取properties，拿到需要创建对象的配置文件中的字符串
        Properties properties = new Properties();

        File file = new File("src/config_allen.properties");
        FileInputStream fis = new FileInputStream(file);

        properties.load(fis);

        String fruitName = properties.getProperty("fruitName");

        //反射创建对象
        Class fruitClazz = Class.forName(fruitName);
        Constructor declaredConstructor = fruitClazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        Fruit fruit = (Fruit) declaredConstructor.newInstance();

        Juicer juicer = new Juicer();
        juicer.runJuice(fruit);
//        fruit.squeeze();




    }
}
