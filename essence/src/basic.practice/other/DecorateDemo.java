package src.java.basic.practice.other;

/**
 * Created by linzh on 2016/7/6.
 */
public class DecorateDemo {

    public static void main(String[] args) {
        new Performance(new Log(new Order())).execute2();
//        new Log(new Log(new Order())).execute();
//        new LogClass(new OrderClass()).execute();
    }
}

class Order implements Command{

    @Override
    public void execute() {
        System.out.println("submit the order ");
    }
}

class Log implements Command{

    private Command command;
    public Log(Command c) {
        this.command = c;
    }

    @Override
    public void execute() {
        System.out.println("before log...");
        command.execute();
        System.out.println("after log...");
    }

    public void execute2() {
        System.out.println("before log2...");
        command.execute();
        System.out.println("after log2...");
    }
}

class Performance implements Command{

    private Command command;
    public Performance(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        System.out.println("before performance...");
        command.execute();
        System.out.println("after performance...");
    }

    public void execute2() {
        System.out.println("before performance2...");
        command.execute();
        System.out.println("after performance2...");
    }
}

abstract class Business{
    abstract void execute();
}

class LogClass extends Business{

    private Business business;

    public LogClass(Business business) {
        this.business = business;
    }

    @Override
    void execute() {
        System.out.println("before log class...");
        business.execute();
        System.out.println("after log class...");
    }
}

class OrderClass extends Business{

    @Override
    void execute() {
        System.out.println("submit order...");
    }
}