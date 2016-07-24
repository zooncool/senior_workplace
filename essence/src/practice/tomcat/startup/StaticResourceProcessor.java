package src.practice.tomcat.startup;


import src.practice.tomcat.startup.connector.http.HttpRequest;
import src.practice.tomcat.startup.connector.http.HttpResponse;

import java.io.IOException;

public class StaticResourceProcessor {

  public void process(HttpRequest request, HttpResponse response) {
    try {
      response.sendStaticResource();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
