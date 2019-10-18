package task1.labA;

public class MainA {

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      new Exception("Error with the quant of parametrs");
    }
    int i = Integer.parseInt(args[0]);
    int j = Integer.parseInt(args[1]);
    byte [][]matrix = new byte[i][j];
    for (i = 0; i < matrix.length; i++) {
      for (j =0;j < matrix[i].length; j++) {
        if (i == j) {
          matrix[i][j] = 1;
        } else matrix[i][j] = 0;
      }
    }

    for (i = 0; i < matrix.length; i++) {
      for (j =0;j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
