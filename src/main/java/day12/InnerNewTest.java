package day12;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author 程方园
 * @className InnerNewTest
 * @date 2021/4/23
 */
public class InnerNewTest {


    public static void main(String[] args) {

        Class<?> clazz0 = ArrayList.class;

        Class<?> clazz1 = new ArrayList<String>().getClass();


        Class<?> clazz2 = new ArrayList<String>() {
        }.getClass();

        Class<?> clazz3 = new ArrayList<String>() {{
        }}.getClass();

        System.out.println(clazz0 == clazz1);
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);
        System.out.println(clazz3 == clazz1);

    }


}
