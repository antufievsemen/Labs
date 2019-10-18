package task1.labB;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class MainB {
  public static void main(String[] args) throws Exception {
    String ar = new String("nmlkhgfedcba");

    if (ar.length() % 3 != 0) throw new Exception("Error with argument");

    StringBuilder []stringAr = new StringBuilder[ar.length() / 3];
    for (int i = 0; i <= ar.length(); i++) {
      int counter = 0;
      stringAr[i] = new StringBuilder(ar.substring(counter, counter + 3));
      ar = ar.replace(stringAr[i], "");
      counter += 1;
    }

    for (int i = 0; i < stringAr.length; i++ ){
        char c;
        do {
          Random r = new Random();
          c = (char) (r.nextInt(26) + 'a');
        } while(c == stringAr[i].charAt(0) && c == stringAr[i].charAt(2));
        stringAr[i].setCharAt(1, c);
    }

    sortedForAlpha(stringAr);

    for(StringBuilder i:stringAr) {
      System.out.print(i + " ");
    }
  }

  private static void sortedForAlpha(StringBuilder[] arr) {
    Arrays.sort(arr, StringBuilder::compareTo);
  }
 }


