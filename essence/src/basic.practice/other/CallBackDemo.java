package src.java.basic.practice.other;

/**
 * Created by linzh on 2016/7/6.
 */
public class CallBackDemo {
    public static void main(String[] args) {
        Staff staff = new Staff("engineer","2 year");//招聘雇员
        Boss boss = new Boss(staff);//企业主借助雇员
        boss.business();//资本运作
    }
}

//资源接口
interface Resource{
    //如何赚钱
    String howToMakeMoney(String method);
}

//企业主拥有资源，实现资源接口
class Boss implements Resource{

    private Staff staff;
    public Boss(Staff staff) {
        this.staff = staff;
    }

    //开始资本运作
    public void business(){
        //通过雇员，把企业主的赚钱方法教给雇员，获得收益
        String profit = staff.makeProfit(Boss.this);
        System.out.println("business result "+profit);
    }

    //企业主制定的赚钱方法
    @Override
    public String howToMakeMoney(String method) {
        return method;
    }
}

//雇员
class Staff {
    private String method;//方法
    private String time;//时间

    public Staff(String method,String time) {
        this.time = time;
        this.method = method;
    }

    //产生利润收益
    public String makeProfit(Resource resource){
        String methodName = resource.howToMakeMoney(method);
        String profit = "use " + methodName+" this method and spend " + time+" time,get 1000 dollars";
        return profit;
    };
}
