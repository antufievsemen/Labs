import MyProperties.Properties;


public class Main {
  public static void main(String[] args) {
    Properties myProperties = new Properties("C:\\Users\\antuf\\Projects\\Lab5\\src\\MyProperties\\FileWithPasswords.properties");
    System.out.println(myProperties.toString());
  }
}
