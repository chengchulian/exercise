package day9;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author 程方园
 * @className Solution
 * @date 2021/4/16
 */
public class Solution {

    private String value;

    public Solution(String value) {
        this.value = value;
    }

    public static boolean containsDuplicate(int[] nums) {

        return false;
    }

    public static synchronized void syncTest1(){
        System.out.println(Thread.currentThread().getName()+"syncTest1");
        syncTest2();
    }

    public static synchronized void syncTest2(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"syncTest2");
        syncTest1();
    }
    public static void main(String[] args) {

        new Thread(Solution::syncTest1).start();
        new Thread(Solution::syncTest1).start();

    }

    @Override
    public String toString() {
        return "Solution{" +
                "value='" + value + '\'' +
                '}';
    }

    //        stringList = stringList
//                .stream()
//                .peek(System.out::println)
//                .collect(Collectors.toList());

//        stringList.forEach(System.out::println);

}
