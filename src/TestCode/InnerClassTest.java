package TestCode;

/**
 * @Author
 * @Version
 * @Date 2019/10/4
 */
public class InnerClassTest {
    class InnerClass {
        int x =2;
    }
    private void ChangeNum(InnerClass m){
        m.x =1;
    }
    public static void main(String[] args){

        InnerClassTest myTest = new InnerClassTest();
        InnerClass m = myTest.new InnerClass();
        myTest.ChangeNum(m);
        System.out.println(m.x);
    }
}
