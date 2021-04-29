package day11;

import cn.hutool.crypto.SecureUtil;

import java.nio.charset.StandardCharsets;

/**
 * TODO
 *
 * @author 程方园
 * @className MD5Test
 * @date 2021/4/22
 */
public class MD5Test {

    public static void main(String[] args) {
        String ocode = "test123456";
        String cid = "557";
        String cuid = "11110";
        String devid = "864824030928913";
        String adid = "10001";
        String adname = "测试小程序";
        String pkg = "";
        String time = "15464233341";
        String points = "0.01";
        String adtype = "3";
        String sign = "";
        String minitype = "1";
        String AD_KEY = "4eb9a501a26e0a9";

        String parameter =
                ocode
                + cid
                + cuid
                + devid
                + adid
                + adname
                + pkg
                + adtype
                + time
                + points
                + AD_KEY;
//        String parameter ="test1234565421111086482403092891310001测试小程序3154642333410.01c034b5c36791647";


        System.out.println(SecureUtil.md5(parameter).toLowerCase().substring(10, 20));


    }

    private static final char[] HEXADECIMAL = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String encode(byte[] binaryData) {

        if (binaryData.length != 16) {
            return null;
        }

        char[] buffer = new char[32];

        for (int i=0; i<16; i++) {
            int low = binaryData[i] & 0x0f;
            int high = (binaryData[i] & 0xf0) >> 4;
            buffer[i*2] = HEXADECIMAL[high];
            buffer[i*2 + 1] = HEXADECIMAL[low];
        }

        return new String(buffer);
    }


}
