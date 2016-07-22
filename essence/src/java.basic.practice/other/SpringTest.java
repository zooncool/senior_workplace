package src.java.basic.practice.other;

/**
 * Created by linzh on 2016/7/20.
 */
public class SpringTest {

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("");
//        Object o = ctx.getBean("");
        String a = "192.168.137.2";
        String b = a.split("\\.")[2];
        System.out.println(b);
    }
}
