import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;


/**
 * @ClassName CompletableFutureTest
 * @Description TODO
 * @Author 程方园
 * @CreateDate 2021/2/19 17:14
 */
public class CompletableFutureTest {

    public static Executor executor = Executors.newFixedThreadPool(20);


    public static void main(String[] args) {

        List<CompletableFuture<String>> futureList = new ArrayList<>();

        futureList.add(CompletableFuture.supplyAsync(() -> Thread.currentThread().getName()));
        futureList.add(CompletableFuture.supplyAsync(() -> Thread.currentThread().getName()));
        futureList.add(CompletableFuture.supplyAsync(() -> Thread.currentThread().getName()));



        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));

        for (CompletableFuture<String> future : futureList) {
            System.out.println(future.join());
        }

        System.out.println("====================================");

    }

    public static <E, T> List<T> s(List<E> list, Class<T> clazz) {
        return list.stream().map(it -> {
            T target;
            try {
                target = clazz.newInstance();
                BeanUtils.copyProperties(it, target);
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException("内部错误");
            }
            return target;
        }).collect(Collectors.toList());
    }


    static void test() {
        Scanner scanner = new Scanner(System.in);
        int starNum = scanner.nextInt();
        //行数 - 1
        int row = 1;
        while (Math.pow(row, 2) + Math.pow(row - 1, 2) <= starNum) {
            row++;
        }
        //行数
        row = (row - 1) * 2 - 1;
        //打印菱形
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < Math.abs(row / 2 - i); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < row - 2 * Math.abs(row / 2 - i); j++) {
                System.out.print("*");
            }
            System.out.println("\n");
        }

        System.out.printf("剩余:%d", (int) (starNum - ((Math.pow(((double) (row + 1) / 2), 2) + Math.pow(((double) ((row + 1) / 2) - 1), 2)))));
    }


}
