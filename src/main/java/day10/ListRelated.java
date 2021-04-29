package day10;

import com.sun.javafx.UnmodifiableArrayList;
import com.sun.xml.internal.stream.StaxErrorReporter;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import sun.security.provider.NativePRNG;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * List相关
 *
 * @author 程方园
 * @className ListRelated
 * @date 2021/4/20
 */
public class ListRelated {

    public ListRelated() {
    }

    public static void main(String[] args) throws InterruptedException {


        List<Object> objectVector = new Vector<>();

        Set<Object> synchronizedSet = Collections.synchronizedSet(new HashSet<>());
        Map<Object, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        List<Object> synchronizedList = Collections.synchronizedList(new ArrayList<>());

        CopyOnWriteArraySet<Object> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        CopyOnWriteArrayList<Object> copyOnWriteArrayList = new CopyOnWriteArrayList<>();




    }

}
