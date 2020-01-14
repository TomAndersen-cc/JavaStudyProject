package TestCode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Tom Andersen
 * @version 0.1
 * @date 2019/10/3
 */
public class MapTest {
    public static void main(String[] args) {
        /*
        //map的子类数据结构中都不允许有重复元素
        Map<Integer, Integer> myMap = new TreeMap<>();
        myMap.put(1, 2);
        myMap.put(2, 2);
        myMap.put(2, 2);
        for (int key : myMap.keySet()) {
            System.out.println(key +" "+ myMap.get(key));
        }
        */
        Map<Integer, Integer> myMap = new TreeMap<>();
        myMap.put(5, 2);
        myMap.put(2, 3);
        myMap.put(4, 4);
        myMap.put(11, 4);
        myMap.put(50, 4);
        myMap.put(9, 4);
        System.out.println(myMap);
        //此Iterator中的泛型是Entry条目，即不能直接读取key，value，需要使用Entry条目对象读取
        //entrySet方法即是将Map转换成一种Set集合，Set集合中的元素是一个个Entry，即键值对

        /*Iterator<Map.Entry<Integer,Integer>> entryIterator = myMap.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Integer, Integer> integerEntry = entryIterator.next();
            if (integerEntry.getKey() == 2) {
                entryIterator.remove();
            }
        }*/
        //上述代码等价于下一句代码
        myMap.entrySet().removeIf(integerEntry -> integerEntry.getKey() == 2);

        System.out.println(myMap);
    }
}
