import FileManager.MyFileManager;

import java.io.IOException;

import static FileManager.MyFileManager.readFromUser;

public class Main {
  public static void main(String[] args) {
    MyFileManager myFileManager = new MyFileManager("");//Write your path
    System.out.println("Write the command");
    while (true) {
      myFileManager.help();
      String userStr = readFromUser();
      if (userStr == null) {
        System.out.println("Rewrite the command");
      }

      if(userStr.equals("exit")){
        break;
      }
      switch (userStr) {

        case ("viewFiles"): {
          try {
            myFileManager.viewFiles();
          } catch (IOException e) {
            System.out.println("Check your path to file: " + myFileManager.getPath());
          }
          break;
        }

        case ("moveToDir"): {
          System.out.println("Write the name of the Directory");
          String userPar = readFromUser();
          try {
            if (userPar == null) {
              System.out.println("Rewrite the parametr");
            }

            myFileManager.moveToDir(userPar);
          } catch (IOException e) {
            System.err.println("Check name of the Dir");
          }
          break;
        }

        case ("deleteFile"): {
            System.out.println("Write the name of the file");
            String userPar = readFromUser();
            if (userPar == null) {
              System.out.println("Rewrite the parametr");
            }

            if (myFileManager.deleteFile(userPar)) {
              System.out.println("File was deleted (" + userPar + ")");
            } else {
              System.out.println("File is (" + userPar + ") is doesnt exist");
            }
          break;
        }

        case ("createFile"): {
          System.out.println("Write the name of the file");
          String userPar = readFromUser();
          try {
            if (userPar == null) {
              System.out.println("Rewrite the parametr");
            }

            if (myFileManager.createFile(userPar)) {
              System.out.println("File was created (" + userPar + ")");
            } else {
              System.out.println("File was not created (" + userPar + ")");
            }

          } catch (IOException e) {
            System.out.println("Check file to creat" + userPar);
          }
          break;
        }

        case ("checkFile"): {
          System.out.println("Write the name of the file");
          String userPar = readFromUser();
          try {
            if (userPar == null) {
              System.out.println("Rewrite the parametr");
            }

            myFileManager.checkFile(userPar);
          } catch (IOException e) {
            System.out.println("Have error with read from the file" + userPar);
          }
          break;
        }

        case ("writeToFile"): {
          System.out.println("Write the name of the file");
          String userPar = readFromUser();
          try {
            if (userPar == null) {
              System.out.println("Rewrite the parametr");
            }

            myFileManager.writeToFile(userPar);
          } catch (IOException e) {
            System.out.println("Have error with write to the file" + userPar);
          }
          break;
        }
        case("help"):{
          myFileManager.help();
          break;
        }
        default:
          System.out.println("Rewrite the command");
          break;
      }

    }


  }
}
