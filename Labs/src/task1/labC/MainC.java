package task1.labC;

import task1.labC.TypeClasses.BookInfo;
import task1.labC.TypeClasses.MyList;
import task1.labC.TypeClasses.Menu;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainC {
  public static void main(String[] args){
    try {
      List<String> lines = Files.readAllLines(Paths.get("src\\task1\\labC\\TypeClasses\\Library.txt"), StandardCharsets.UTF_8);
      MyList<BookInfo> collectionOfBook = new MyList<BookInfo>(lines);
      Menu.help();
      System.out.println("Use command");
      while(true){

        String usersString = Menu.readFromUser();
        if(usersString == null){
          System.out.println("Incorrect command");
          continue;
        }

        if (usersString.equals("exit")) break;
        switch (usersString) {

          case "search":
            System.out.println("Choose field and value");
            String field = Menu.readFromUser();
            String value = Menu.readFromUser();
            if (field != null && value != null) {
              BookInfo book = collectionOfBook.searchBookWithField(field, value);
              if (book != null)
              System.out.println(book.toString());
            } else {
              System.out.println("Wrong field or value, repeat");
              break;
            }
            break;

          case "delete":
            System.out.println("Write id");
            String id = Menu.readFromUser();
            if (id != null) {
              boolean bool = collectionOfBook.deleteBook(Integer.parseInt(id));
              if (bool)
                System.out.println("Book is deleted");
            }
            else {
              System.out.println("Wrong id, repeat");
              break;
            }
            break;

          case "update":
            System.out.println("Write id and new info about book");
            id = Menu.readFromUser();
            String updateBook = Menu.readFromUser();

            if (id != null && updateBook != null) {
              if (collectionOfBook.updateBook(Integer.parseInt(id), updateBook))
                System.out.println("The book update");

            }
            else {
              System.out.println("Wrong id or update book repeat");
              break;
            }
            break;

          case "add":
            System.out.println("Write new book");
            String newBook = Menu.readFromUser();
            if (newBook != null)
              collectionOfBook.addBook(newBook);
            else {
              System.out.println("Wrong new bookad");
              break;
            }
            break;

          case "view_all":
            for (BookInfo i : collectionOfBook) {
              System.out.println(i.toString());
            }
            break;

          case "help":
            Menu.help();
            break;
        }
      }

    } catch (IOException e) {
      System.out.println("File is incorrect");
    }

  }
}
