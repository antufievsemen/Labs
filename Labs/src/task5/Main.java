import MyProperties.Properties;

import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    Properties myProperties = new Properties("src\\MyProperties\\FileWithPasswords.properties");
    System.out.println(myProperties.toString());
  }
}
