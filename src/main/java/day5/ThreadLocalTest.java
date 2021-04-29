package day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * TODO
 *
 * @author 程方园
 * @className ThreadLocalTest
 * @date 2021/4/2
 */
public class ThreadLocalTest {

    static ThreadLocal<Integer> THREAD_LOCAL_COUNT = new ThreadLocal<>();

    static Integer COUNT = 0;

    public static void main(String[] args) {
        List<Runnable> runnableList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            runnableList.add(() -> {
                int randomInt = new Random().nextInt(5) + 5;

                THREAD_LOCAL_COUNT.set(randomInt);
                COUNT = randomInt;
                System.out.println(Thread.currentThread().getName() + "::::::Thread" + "::::" + THREAD_LOCAL_COUNT.get());
                System.out.println(Thread.currentThread().getName() + "::::NoThread" + "::::" + COUNT);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "::::::Thread" + "::::" + THREAD_LOCAL_COUNT.get());
                System.out.println(Thread.currentThread().getName() + "::::NoThread" + "::::" + COUNT);
                THREAD_LOCAL_COUNT.remove();
                COUNT = 0;

            });
        }
        runnableList.forEach(runnable -> new Thread(runnable).start());

    }

}
