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
        //集合中放单个元素的类型必须是泛型或者他的子类
        List<? super Father01> list = null;
        List<Father01> father01List = null;
//        father01List.add(new Object());//NOT OK
//        father01List.add(new Son());//OK


        //        ? super Father 表示List的类型是Father或者father的某一个超类的类型（飘忽不定的）
//        ，？万一是Father类型，所以可以放入的元素是Father或者Father 的子类。（放入下界，才不会矛盾）

        //集合中下限明确情况下，<? super Father01>泛型表示：可以放入的单个元素类型为：？下限and下限子类。
//        假设放入父类的话，集合泛型如果表示下限（最小），则无法满足多态（父类引用指向子类对象）、不支持放入。
//        list.add(new Son()); //OK
//        list.add(new Man()); //NOT OK
//        list.add(new Object()) //NOT OK

        List<Man> manAl = new ArrayList<>();
        List<Son> sonAl = new ArrayList<>();

        //整个集合赋值，泛型必须满足？super条件
        list = manAl;

        /*
        Required type:
List
<? super Father01>
         */
//        list = sonAl;

        list.add(new Father01());
//        list.add(new Object()); //NOT OK


    }

    @Test
    public void test03(){
          List<? extends Father01> list = null;
//          泛型为<? extends Father01> 没有下限/无下限；除了null啥都放不了；
        //List<? extends Father01> 表示list泛型的类型肯定是Father子类，
//          但类型为Father最大、下届飘忽不定、上界是确定的；所以不能放入除了null以外的东西，
//          否则放入元素的类型会大于List的泛型类型。不满足多态（放入元素小于泛型类型）

//          list.add(new Son());//NOT OK
//          list.add(new Object());//NOT OK
          list.add(null);

          List<Son> sonAl = new ArrayList<>();

        //整个集合赋值，泛型必须满足？extend条件
          list = sonAl;
          list.add(null);
//          list.add(new Object()); //NOT OK
//          list.add(new Son());  // NOT OK


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

