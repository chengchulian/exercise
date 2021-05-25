package y2021.m05.d08;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author 程方园
 * @className ListDemo
 * @date 2021/5/8
 */
public class ListDemo {

    public static void main(String[] args) {
        List<Long> longs = new ArrayList<>();

        String str = ",1,1,2,3,4,";

        String[] split = str.split(",");


        for (String s : split) {

            try {
                long value = Long.parseLong(s);
                longs.add(value);
            } catch (NumberFormatException ignored) {
            }

        }

        System.out.println(longs);




    }

}
