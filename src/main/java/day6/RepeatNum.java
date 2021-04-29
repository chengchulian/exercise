package day6;

import java.util.Arrays;

/**
 * TODO
 *
 * @author 程方园
 * @className RepeatNum
 * @date 2021/4/6
 */
public class RepeatNum {

    public static void main(String[] args) {

//        int[] ints = {2, 3, 1, 0, 2, 5, 3};
//        int[] ints = {0,1,2, 3,4, 11,5,6,7,8,9,10,11,12,13,14, 0, 2, 5, 3};
//        int[] ints = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] ints = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(fun2(ints));


    }

    static int fun(int[] nums) {
        int[] flags = new int[nums.length];
        for (int num : nums) {
            if (++flags[num] > 1) {
                return num;
            }
        }
        return -1;
    }

    static int fun2(int[] nums) {
        //使用17位打标记 前16位比较大小
        for (int i = 0; i < nums.length; i++) {
            // 索引 num舍去最高位
            int index = nums[i] << 15 >> 15;
            //第17位为出现次数
            if (nums[index] >> 17 > 1) {
                return index;
            }
            //每出现一次，所在位的数的第17位+1
            nums[index] = ~nums[index] << 15 >>> 15;
        }
        return -1;
    }

    static int fun3(int[] nums) {
        for (int num : nums) {
            int index = num << 15 >> 15;
            //第17位为出现次数
            if (nums[index] >> 17 > 1) {
                return index;
            }
            //每出现一次，所在位的数的第17位+1
            nums[index] = nums[index] + (2 << 17);
        }
        return -1;
    }

}
