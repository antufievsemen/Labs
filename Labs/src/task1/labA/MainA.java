package task1.labA;

import java.util.Random;

public class MainA {

  public static void main(String[] args) {
    try {
      if (args.length != 2) {
        throw new ExceptionInInitializerError("Error with the quant of parametrs");
      }

      int i = Integer.parseInt(args[0]);
      int j = Integer.parseInt(args[1]);
      int[][] matrix = new int[i][j];

      for (i = 0; i < matrix.length; i++) {
        Random r = new Random();
        int randomJ = r.nextInt(j);
        matrix[i][randomJ] = 1;
      }

      for (i = 0; i < matrix.length; i++) {
        for (j = 0; j < matrix[0].length; j++) {
          System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
      }
    } catch (Exception e){
      System.out.println("Incorrect parametrs");
    } catch(ExceptionInInitializerError e){
      System.out.println("The quant of parametrs is wrong");
    }
  }
}
