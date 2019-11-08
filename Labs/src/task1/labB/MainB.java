package task1.labB;

import java.util.Arrays;
import java.util.Random;

public class MainB {
  public static void main(String[] args) {
    try {

      String regexNumber = ".*\\d.*";
      String regexDot = ".*\\W.*";

      String argumentFromUser = args[0];
      if(argumentFromUser.matches(regexNumber) || argumentFromUser.matches(regexDot)){
        throw new Exception("Argument have illegal chars");
      }

      if(argumentFromUser.length() % 3 != 0) throw new ExceptionInInitializerError();

      StringBuilder[] stringAr = new StringBuilder[argumentFromUser.length() / 3];

      for(int i = 0; i <= argumentFromUser.length(); i++){
        int counter = 0;
        stringAr[i] = new StringBuilder(argumentFromUser.substring(counter, counter + 3));
        argumentFromUser = argumentFromUser.replace(stringAr[i], "");
        counter += 1;
      }

      for (StringBuilder stringBuilder : stringAr) {
        char c;
        do {
          Random r = new Random();
          c = (char) (r.nextInt(26) + 'a');
        } while (c == stringBuilder.charAt(0) && c == stringBuilder.charAt(2));
        stringBuilder.setCharAt(1, c);
      }

      sortedForAlpha(stringAr);

      for(StringBuilder i : stringAr){
        System.out.print(i + " ");
      }

    } catch(ExceptionInInitializerError e){
      System.out.println("String must have 3 elements in part");
    } catch(Exception e){
      System.out.println("Error with argument" + e.getMessage());
    }
  }

  private static void sortedForAlpha(StringBuilder[] arr){
    Arrays.sort(arr, StringBuilder::compareTo);
  }
}


