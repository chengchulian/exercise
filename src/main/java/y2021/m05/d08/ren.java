package y2021.m05.d08;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Random;

/**
 * @author Julian
 * @className ren
 * @date 2021/5/19
 */
public class ren {


    public static void main(String[] args) {



        for (int j = 1; j <= 10; j++) {
            //本金
            double money = 10000;
            //循环一年
            for (int i = 1; i <= 365; i++) {
                // 1/20触发大涨大跌
                boolean specialCase = getSpecialCase(20);
                //涨幅率
                double increase = specialCase ? getRandom(20, -20) : getRandom(5, -5);
                money = money + (money * increase / 100);
            }
            System.out.println(j + "剩余金额:" + formatDouble(money));
        }


    }

    /**
     * v1 ~ v2随机数
     */
    static double getRandom(int v1, int v2) {
        return Math.random() * (v1 - v2) + (v2);
    }

    /**
     * 概率
     */
    static boolean getSpecialCase(int seed) {
        return (int) (Math.random() * seed) == seed - 1;
    }

    static String formatDouble(double value) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(false);
        return nf.format(value);
    }
}
