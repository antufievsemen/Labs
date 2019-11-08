package task1.labC.TypeClasses;

import java.util.Scanner;

public class Menu {


  public static void help() {
    System.out.println("search - find book with field in library(fields: id, author, name, year)");
    System.out.println("delete - delete book from library by id");
    System.out.println("add - add book to library, you should indicate id, author, name, year");
    System.out.println("update - update info about book(search book by id to update)");
    System.out.println("view_all - view all book in the library");
    System.out.println("exit - exit from the programm");
  }

  public static String readFromUser() {
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNextLine()) {
      return scanner.nextLine();
    }
    return null;
  }

}

