package day7;

import java.lang.reflect.Field;

/**
 * TODO
 *
 * @author 程方园
 * @className Reflex
 * @date 2021/4/6
 */
public class DoMain<T> {
    private Integer age;
    private String name;
    private T remark1;
    private T remark2;
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public T getRemark1() {
        return remark1;
    }
    public void setRemark1(T remark1) {
//        Class<?> clazz = remark1.getClass();
//
//        try {
//            Field value = clazz.getDeclaredField("value");
//            value.setAccessible(true);
//            try {
//                value.set(this.remark1,remark1);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }

        this.remark1 = remark1;
    }
    public T getRemark2() {
        return remark2;
    }
    public void setRemark2(T remark2) {
        this.remark2 = remark2;
    }

    public DoMain() {
        remark1 = (T) new Integer(0);
    }

    @Override
    public String toString() {
        return "DoMain{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", remark1=" + remark1 +
                ", remark2=" + remark2 +
                '}';
    }

    public static void main(String[] args) {
    }


}
