package TestCode;


import java.util.*;
import java.util.regex.Pattern;

public class HelloWorld {
    private static void Remove(List L) {
        L.remove(0);
    }

    private final static String SEPARATOR = "----------------------------------------";

    public static void main(String[] args) {

        System.out.println("Hello World!");
        //使用以下方式能够实现类C++的输出控制
        //这个输出不带换行
        System.out.printf("%s", "Hello World!");
        System.out.printf("%s", "Hello World!");
        //等价于这种输出换行
        System.out.println(String.format("%s", "Hello World!"));

        System.out.println(SEPARATOR);

        //即便是对象的引用的声明类型和其本身的类型不一致，其getClass返回的依旧是对象实例所属类的Class对象
        Object a = 1L;
        System.out.println(a.getClass().getName());

        System.out.println(SEPARATOR);

        List<Integer> myListOfInteger = new ArrayList<>();
        myListOfInteger.add(1);
        myListOfInteger.add(2);
        Remove(myListOfInteger);
        System.out.println(myListOfInteger);

        System.out.println(SEPARATOR);

        // 1.0e9 约等于 Math.pow(10,9) 精度不同，故有可能不同，约等于
        System.out.println(1.0e9 + 7);
        System.out.println(1.e9 + 7);
        System.out.println(1e9 + 7);
        System.out.println(1E9 + 7);
        System.out.println(1000000007);
        System.out.println(Math.pow(2, 31));
        System.out.println(Integer.MAX_VALUE);

        System.out.println(SEPARATOR);

        int[][] x = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(x[0].length);
        System.out.println(x.length);

        System.out.println(SEPARATOR);

        String message = "Welcome to Java";
        //注意使用substring(int beginIndex, int endIndex)方法时，末尾位置不取，具体如下：
        String submessage = message.substring(0, 6);
        System.out.println(submessage);

        System.out.println(SEPARATOR);
        System.out.println(String.class);
        System.out.println(args.getClass());

        System.out.println(SEPARATOR);
        Object obj = (Object) "Tom";
        Object[] objs = (Object[]) args;
        System.out.println(obj.getClass());
        System.out.println(Arrays.toString(objs));
        System.out.println(objs.getClass());

        System.out.println(SEPARATOR);
        //使用数组创建数组的方式
        int[] nums = {1, 2, 3, 4};
        Object[] objs_1 = new Object[]{nums};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(objs_1));

        //测试String、int相互转换
        System.out.println(SEPARATOR);
        //System.out.println(Integer.valueOf("a")); //NumberFormatException
        System.out.println(Integer.valueOf("10086"));
        //System.out.println(Integer.valueOf("0.10086")); //NumberFormatException
        //这就说明Integer.valueOf方法只能转换数字不能转换字符成数字，只能转整数，不能转小数
        //因为Integer是整型

        //使用正则表达式匹配的方式判断一个String是否是纯数字
        String value1 = "ID:10086";
        String value2 = "10086";
        Pattern pattern = Pattern.compile("[0-9]+");
        System.out.println(pattern.matcher(value1).matches());//创建一个matcher然后调用其matches方法
        System.out.println(pattern.matcher(value2).matches());

        //数组分割测试
        System.out.println(SEPARATOR);
        String value = "Word!";
        String[] values = value.split("\\s+");
        System.out.println(values.length);
        System.out.println(Arrays.toString(values));

        //数组拷贝测试
        System.out.println(SEPARATOR);
        String[] users = {"Tom", "Alise", "Fransic"};
        String[] names = new String[3];
        System.arraycopy(users, 0, names, 0, users.length - 1);
        //注意：使用此函数拷贝之后若没达到目标数组的长度则是以null进行填充
        System.out.println(Arrays.toString(names));

        names = Arrays.copyOf(users, users.length);
        System.out.println(Arrays.toString(names));

        names = Arrays.copyOf(users, users.length + 1);
        names[names.length - 1] = "Elize";
        System.out.println(Arrays.toString(names));

        System.out.println(SEPARATOR);
        String number_x = "-0.5";
        String number_y = "-5";

        System.out.println(Double.valueOf(number_x));
        //System.out.println(Integer.valueOf(number_x));
        System.out.println(Integer.valueOf(number_y));
        //使用Integer的valueof转换字符串只能转换整数不能转换小数

        HashMap<HashMap<String, String>, Integer> hashMapIntegerHashMap = new HashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Tom", "Andersen");
        hashMapIntegerHashMap.put(hashMap, 22);
        HashMap<String, String> hashMap1 = new HashMap<>();
        hashMap1.put("Tom", "Andersen");
        System.out.println(hashMapIntegerHashMap.get(hashMap1));
        System.out.println(hashMap == hashMap1);
        System.out.println(hashMap.hashCode() == hashMap1.hashCode());
        System.out.println(hashMap.equals(hashMap1));

        System.out.println(SEPARATOR);
        String a1 = new String("Hashcode");
        String a2 = new String("Hashcode");
        System.out.println(a1 == a2);
        System.out.println(a1.hashCode() == a2.hashCode());
        System.out.println(a1.equals(a2));

    }

}
