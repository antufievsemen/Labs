package task1.labC.TypeClasses;

import java.util.Scanner;

public class Menu {


  public static void help() {
    System.out.println("search");
    System.out.println("delete");
    System.out.println("add");
    System.out.println("update");
    System.out.println("view_all");
    System.out.println("exit");
  }

  public static String readFromUser() {
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNextLine()) {
      return scanner.nextLine();
    }
    return null;
  }

}

