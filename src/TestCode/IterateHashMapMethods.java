package TestCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author TomAndersen
 * @Date 2020/1/8
 * @Version
 * @Description
 */
public class IterateHashMapMethods {
    // 此类主要用于总结HashMap的各种遍历方式以及可能出现的异常问题
    // 前两种是传统的迭代器Iterator的遍历方式
    // 方法一：使用迭代器迭代Map.Entry接口，通过迭代器获取Map.Entry类型对象，使用Entry接口的getKey、getValue方法来获得HashMap的键值对
    public static void printByIterator(HashMap hashMap) {
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key.toString() + ";" + value.toString());
        }
    }

    // 方法二：使用迭代器迭代HashMap的keySet，使用迭代器获取HashMap的键，再通过键获取对应的值
    public static void printByIterator1(HashMap hashMap) {
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = hashMap.get(key);
            System.out.println(key.toString() + ":" + value.toString());
        }
    }

    // 方法三：使用for-each增强型循环遍历HashMap的entrySet
    public static void printByForEach(HashMap<?, ?> hashMap) {
        for (Map.Entry<?, ?> entry : hashMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key.toString() + ":" + value.toString());
        }
    }

    // 方法四：使用for-each增强型循环遍历HashMap的keySet
    public static void printByForEach1(HashMap<?, ?> hashMap) {
        for (Object key : hashMap.keySet()) {
            Object value = hashMap.get(key);
            System.out.println(key.toString() + ":" + value.toString());
        }
    }

    // 方法五：使用JDK1.8新特性for-each的简写方法
    public static void printByForEach2(HashMap<?, ?> hashMap) {
        hashMap.forEach((k, v) -> System.out.println(k + ":" + v));
    }


    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Name", "TomAndersen");
        hashMap.put("Sex", "Male");
        hashMap.put("Age", "23");
        printByIterator(hashMap);
        printByIterator1(hashMap);
        printByForEach(hashMap);
        printByForEach1(hashMap);
        printByForEach2(hashMap);
    }
}
