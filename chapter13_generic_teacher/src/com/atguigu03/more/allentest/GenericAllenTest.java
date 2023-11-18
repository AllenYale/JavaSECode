package com.atguigu03.more.allentest;

import com.atguigu03.more.Father;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: GenericAllenTest
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023.11.18 22:23
 * @ Version: v1.0
 */
public class GenericAllenTest {

    @Test
    public void test01(){
        ArrayList<String> strAl = new ArrayList<>();
        strAl.add("aa");

//不能写入数据；
//        List中泛型类型飘忽不定，可能是任何类型；如果放入任何一个类型的数据，
//        总有可能是泛型类型要大（不满足多态、不支持放入）；因此、只能放入null
        List<?> list = null;

        List<String> listStr = new ArrayList<>(strAl);
        List<Integer> listInt = null;

        list = listStr;
//        list = listInt;
//        list.add(123);  带通配符的列表不能add，除了null，

        Object o = list.get(0);
        System.out.println("o = " + o);
    }

    @Test
    public void test02(){
        List<? super Father01> list = null;

        List<Man> manAl = new ArrayList<>();
        List<Son> sonAl = new ArrayList<>();
        list = manAl;
//        list = sonAl;

        list.add(new Father01());
//        list.add(new Object()); ? super Father 表示List的类型是Father或者father的某一个超类的类型（飘忽不定的）
//        ，？万一是Father类型，所以可以放入的元素是Father或者Father 的子类。（放入下界，才不会矛盾）

    }

    @Test
    public void test03(){
          List<? extends Father01> list = null;

          List<Son> sonAl = new ArrayList<>();
          list = sonAl;
          list.add(null);
//          list.add(new Object());
//          list.add(new Son());  List<? extends Father01> 表示list泛型的类型肯定是Father子类，
//          但类型为Father最大、下届飘忽不定、上界是确定的；所以不能放入除了null以外的东西，否则放入元素的类型会大于List的泛型类型。



    }

    public void method01(List<?> list){

    }

}

class Man{

}
class Father01 extends Man{

}

class Son extends Father01{

}

