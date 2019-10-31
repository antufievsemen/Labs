import MyProperties.MyProperties;

import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    try {
      MyProperties myProperties = new MyProperties("C:\\Users\\antuf\\Projects\\Lab5\\src\\MyProperties\\FileWithPasswords");
      System.out.println(myProperties.toString());
    } catch (IOException e) {
      System.err.println("File can`t read");
    }
  }
}
