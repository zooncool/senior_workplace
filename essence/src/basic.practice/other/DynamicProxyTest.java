package src.java.basic.practice.other;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by linzh on 2016/7/7.
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        HelloProxy helloProxy = new HelloProxyImpl();
        HelloProxyInvocationHandler handler = new HelloProxyInvocationHandler(helloProxy);
        HelloProxy proxy = (HelloProxy)Proxy.newProxyInstance(helloProxy.getClass().getClassLoader(),helloProxy.getClass().getInterfaces(),handler);
//        proxy.sayFuck();
        proxy.sayHello("hi");
    }
}


interface HelloProxy{
    public void sayHello(String s);

    public void sayFuck();
}

class HelloProxyImpl implements HelloProxy{
    @Override
    public void sayHello(String s) {
        System.out.println(s);
    }

    @Override
    public void sayFuck() {
        System.out.println("fuck");
    }
}

class HelloProxyInvocationHandler implements InvocationHandler{

    private Object helloProxy;

    public HelloProxyInvocationHandler(Object helloProxy) {
        this.helloProxy = helloProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        System.out.println(proxy.getClass()+"|"+method.getName());
        Object result = method.invoke(helloProxy,args[0]);
        after();
        return result;
    }

    public void before(){
        System.out.println("before...");
    }
    public void after(){
        System.out.println("after...");
    }
}