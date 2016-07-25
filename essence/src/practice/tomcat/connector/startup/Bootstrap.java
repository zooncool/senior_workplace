/* explains Tomcat's default container */
package src.practice.tomcat.connector.startup;


import org.apache.catalina.connector.http.HttpConnector;
import src.practice.tomcat.connector.core.SimpleContainer;

public final class Bootstrap {
  public static void main(String[] args) {
    HttpConnector connector = new HttpConnector();
    SimpleContainer container = new SimpleContainer();
    connector.setContainer(container);
    try {
      connector.initialize();
      connector.start();

      // make the application wait until we press any key.
      System.in.read();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}