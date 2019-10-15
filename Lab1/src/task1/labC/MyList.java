package task1.labC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MyList<E extends BookInfo> extends ArrayList<E> {

  public <T extends String>MyList(List<T> arr) throws Exception{
    for (String str : arr) {
      this.addBook(str);
    }
  }

  public void addBook(String str) {
    String [] lines = str.split(" ");
    BookInfo book = new BookInfo(Integer.parseInt(lines[0]), lines[1], lines[2], Integer.parseInt(lines[3]));
    add((E) book);
  }

  public boolean deleteBook(Integer id) {
    Iterator<E> iterator = this.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().getId() == id) {
        iterator.remove();
        return true;
      }

    }

    return false;
  }

  public boolean updateBook(Integer id, String str) {
    Iterator<E> iterator = this.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().getId() == id) {
        iterator.remove();
        addBook(id + str);
        return true;

      }
    }
    return false;
  }

  public BookInfo searchBookWithField(String field, String value) {
    Iterator<E> iterator = this.iterator();
      switch (field) {
        case "id" :
          for (E i :this) {
            if (i.getId() == Integer.parseInt(value)) {
              return i;
            }
          }
          break;

        case "author":
          for (E i :this) {
            if (i.getAuthor().equals(value)) {
              return i;
            }
          }
          break;

        case "name":
          for (E i :this) {
            if (i.getName().equals(value)) {
              return i;
            }
          }
          break;

        case "year":
          for (E i :this) {
            if (i.getYear() == Integer.parseInt(value)) {
              return i;
            }
          }
          break;
      }
      return null;
    }

}
