package day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author 程方园
 * @className SomeThread
 * @date 2021/3/29
 */
public class SomeThread {


    public static void main(String[] args) throws InterruptedException {
        //索引
        AtomicInteger index = new AtomicInteger(0);
        //需要处理的数据
        List<Integer> list = new ArrayList<Integer>() {{
            for (int i = 0; i < 10000; i++) {
                add(i);
            }
        }};
        List<Runnable> runnableList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            runnableList.add(() -> {
                //一个线程随机处理5-10个数据
                int num = new Random().nextInt(50) + 50;
                //处理数据索引
                int pindex = index.getAndAdd(num);
                processData(list, pindex, num);
            });
        }
        for (Runnable runnable : runnableList) {
            //多线程执行
            new Thread(runnable).start();
        }
        Thread.sleep(2000);
        System.out.println("已处理" + index.get() + "个");
    }

    //处理数据
    public static void processData(List<Integer> list, Integer pindex, Integer num) {
        System.out.println(new ArrayList<Integer>() {{
            for (int i = 0; i < num; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {
                }
                add(list.get(pindex + i));
            }
        }});
    }




}
