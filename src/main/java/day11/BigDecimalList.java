package day11;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * TODO
 *
 * @author 程方园
 * @className BigDecimalList
 * @date 2021/4/22
 */
public class BigDecimalList {

    String money;

    public String getMoney() {
        return money;
    }

    public static void main(String[] args) {

        int[] ints = {0, 6, 3, 0, 0, 0, 4, 0, 0, 1};

        int last = ints.length;

        for (int i = 0; i < ints.length; i++) {

            if (ints[i] != 0) {
                if (i - last > 1) {
                    System.out.println(last + ":::" + ints[last]);
                    System.out.println(i + ":::" + ints[i]);
                }
                last = i;
            }


        }
        System.out.println(factorial(2021));


    }

    static String factorial(int num){

        if (num <= 1){
            return "1";
        }

        return BigInteger.valueOf(num).multiply(new BigInteger(factorial(num-1))).toString();

    }

}
