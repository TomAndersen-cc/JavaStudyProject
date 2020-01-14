package TestCode;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

/**
 * @Author
 * @Version
 * @Date 2019/10/4
 */
public class SplitTest {
    public static void main(String[] args){
        String str= "1363157995052   13826544101 5C-0E-8B-C7-F1-E0:CMCC  120.197.40.4            4   0   264 0   200";
        String[] lines_1 = str.split("\\s+");
        /*String[] lines_2 = str.split(" ");*/
        System.out.println(Arrays.toString(lines_1));
        System.out.println(lines_1.length);
        /*System.out.println(Arrays.toString(lines_2));*/

    }
}
