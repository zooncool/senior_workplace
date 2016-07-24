package src.java.basic.practice.other;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

/**
 * Created by linzh on 2016/7/22.
 */
public class SocketTest {
    public static void main(String[] args) {
//        urlTest();
        socketTest();
    }

    public static void urlTest(){
        URL wifi = null;
        try {
            wifi = new URL("http://localhost:8080/analyze");
            InputStream is = wifi.openStream();
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();
            while (data!=null){
                System.out.println(data);
                data = br.readLine();
            }
            br.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(wifi.getHost()+"|"+wifi.getPort()+"|"+wifi.getPath());
    }

    public static void socketTest(){
        Socket socket = null;
        OutputStream os = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            socket = new Socket("127.0.0.1",8080);
            os = socket.getOutputStream();
            pw = new PrintWriter(os,true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw.println("*/*");
            pw.println("gzip, deflate");
            pw.println("zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            pw.println("keep-alive");
            pw.println("loginname=admin; JSESSIONID=924689471DAEBE751FDBE53891FF49BB");
            pw.println("localhost:8080");
            pw.println("http://localhost:8080/analyze");
            pw.println("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:47.0) Gecko/20100101 Firefox/47.0");
            pw.println("XMLHttpRequest");
            pw.flush();
            socket.shutdownOutput();
            String data = br.readLine();
            while(data!=null){
                System.out.println(data);
                data = br.readLine();
            }
            br.close();
            socket.getOutputStream().close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
