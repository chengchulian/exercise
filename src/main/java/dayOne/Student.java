package dayOne;


import java.util.*;
import java.util.stream.Stream;

/**
 * @ClassName Student
 * @Description TODO
 * @Author 程方园
 * @CreateDate 2021/2/26 15:42
 */
public class Student {

    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }


    void test1() {


    }

    public static void main(String[] args) {
//        List<Student> studentList = new ArrayList<Student>() {{
//            add(new Student() {{
//                setId(1);
//            }});            add(new Student() {{
//                setId(2);
//            }});
//        }};
//        String s = studentList.stream()
//                .map(Student::getId)
//                .map(Object::toString)
//                .collect(Collectors.joining(","));
//        System.out.println(s);


//        str = String.join(",", Arrays.stream(str.split(",")).collect(Collectors.toSet()));

        String str = "1,2,3,4,5";
        String getCode = "3,3,4";

        List<String> stringList = Arrays.asList(str.split(","));
//        String x = Arrays
//                .stream(getCode.split(","))
//                .distinct()
//                .filter(stringList::contains)
//                .collect(Collectors.joining(","));
//        System.out.println(x);

        Stream<String> stringStream = Arrays.stream(getCode.split(",")).distinct().filter(stringList::contains);
        System.out.println(String.join(",",stringStream.toArray(String[]::new)));


//
//        List<String> strings = new ArrayList<String>() {{
//            add("1");
//            add(null);
//
//        }};
//        List<String> collect = strings.stream().filter(it -> it.length() > 1).collect(Collectors.toList());
//
//        System.out.println(collect);
//
//        Hashtable map = new Hashtable();
//
//        String[] ch = {"1", "2", "3", "a", "v", "b", "a"};
//
//        for (String s : ch) {
//            if (map.containsKey(s)) {
//                map.put(s, ((Integer) map.get(s)) + 1);
//                continue;
//            }
//            map.put(s, 0);
//        }
//
//        System.out.println(map);
//        List<Integer> list = new ArrayList<Integer>() {{
//            add(1);
//            add(null);
//        }};


    }

}

