package dayOne;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName Medium1052
 * @Description TODO
 * @Author 程方园
 * @CreateDate 2021/2/23 16:04
 */
public class Medium1052 {

    private static final Integer value5 = 10;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        List<String> stringList = new ArrayList<>();

        stringList.add("123");

//        List<String> list = stringList.stream()
//                .collect(Collectors
//                        .toMap(
//                                //key
//                                item -> item.getPipId(),
//                                //value
//                                item -> item,
//                                //如果key已经有值,执行的策略,v1旧值,v2新值 return v1 保留v1
//                                (v1,v2)->{
//                                    return v1;
//                                }
//                        )).collect(Collectors.toList());
//
//        new Map
        

//        System.out.println(list);


        Integer value1 = 10;
        Integer value2 = value1;
        Integer value3 = new Integer(value1);
        Integer value4 = 10;
        process(value1);
        System.out.println(value1 + "::::" + value2 + "::::" + value3 + "::::" + value4 + "::::" + value5);
        processReflex(value1);
        System.out.println(value1 + "::::" + value2 + "::::" + value3 + "::::" + value4 + "::::" + value5);
    }

    static void process(Integer integer) {
        integer = 7;
    }

    static void processReflex(Integer integer) throws NoSuchFieldException, IllegalAccessException {
        Class<? extends Integer> clazz = integer.getClass();
        Field value = clazz.getDeclaredField("value");
        value.setAccessible(true);
        value.set(integer, 5);
    }

    /**
     * @param object          有相应注解标记相应函数的类的对象
     * @param interfaceClazz  待实现接口的Class
     * @param annotationClazz 注解的Class
     * @param <T>             接口类型
     * @return 实现了接口的代理类对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T buildInterfaceClass(Object object, Class<T> interfaceClazz, Class annotationClazz) {
        return (T) Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz}, new InterfaceHandler(object, annotationClazz));
    }

    /**
     * 找出特定类上被特定注解标记的方法
     *
     * @param objectClass     类的Class
     * @param annotationClass 注解的Class
     * @return 被annotationClass标记的方法
     * @throws Exception 没有方法上面有annotationClass的注解
     */
    public static Method getInterfaceMethod(Class<?> objectClass, Class<? extends Annotation> annotationClass) throws Exception {
        Method[] declaredMethods = objectClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Annotation[] declaredAnnotations = declaredMethod.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                if (declaredAnnotation.annotationType().equals(annotationClass)) {
                    return declaredMethod;
                }
            }
        }

        throw new Exception("没有含有 " + annotationClass.getName() + " 注解的方法");
    }

    /**
     * 对代理类上相应的函数调用转化为被特定注解标记的函数调用
     */
    private static class InterfaceHandler implements InvocationHandler {
        private Object object;
        private Class annotationClazz;

        public InterfaceHandler(Object object, Class annotationClazz) {
            this.object = object;
            this.annotationClazz = annotationClazz;
        }

        static int max(int x, int y) {
            return Math.max(x, y);
        }

        int func(int x, int y) {

            return Math.max(x, y);
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().toLowerCase().endsWith(annotationClazz.getSimpleName().toLowerCase())) {
                Method interfaceMethod = getInterfaceMethod(object.getClass(), annotationClazz);
                return interfaceMethod.invoke(object, args);
            }
            throw new Exception("未实现函数");
        }
    }


}
