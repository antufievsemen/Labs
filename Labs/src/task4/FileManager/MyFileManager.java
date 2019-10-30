package FileManager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MyFileManager {

  private String path;
  private File absFile;

  public MyFileManager(String path){
    this.path = path;
    this.absFile = new File(path);
  }

  public String getPath(){
    return path;
  }

  public void viewFiles() throws IOException{
    if(!absFile.exists()){
      throw new IOException();
    }

    File[] arrOfFiles = absFile.listFiles();
    for (File i : arrOfFiles) {
      if (i.isDirectory()) {
        System.out.println("Dir " + i.getName());
      }

      if (i.isFile()) {
        System.out.println("File " + i.getName());
      }
    }
  }

    public void moveToDir(String name) throws IOException{
      String pathToFile = this.path + "\\" + name;

      if (name.equals("back")){
        this.absFile = this.absFile.getParentFile();
      } else {
        this.absFile = new File(pathToFile);
      }
      if(!absFile.exists()) {
        this.absFile = new File(String.valueOf(this.path));
        throw new IOException();
      }

      this.path = absFile.getPath();
    }

    public boolean createFile(String name) throws IOException {
      String pathToFile = this.path + "\\" + name;
      File fileCreate = new File(pathToFile);
      return fileCreate.createNewFile();
    }

    public boolean deleteFile(String name){
      String pathToFile = this.path + "\\" + name;
      File fileDel = new File(pathToFile);
      return fileDel.delete();
    }

    public void writeToFile(String name) throws IOException {
      String pathToFile = this.path + "\\" + name;
      File file = new File(pathToFile);
      if(!file.exists()) {
        if (!file.canWrite()) {
          throw new IOException();
        }
      }

      FileWriter fileWriter = new FileWriter(file, true);
      System.out.println("Write info");
      String userLine = readFromUser();
      if (userLine != null) {
        fileWriter.write("\n" + userLine + "\n");
        fileWriter.flush();
      }
    }

    public void checkFile(String name) throws IOException{
      String pathToFile = this.path + "\\" + name;
      System.out.println("File " + name + " :");

      BufferedReader reader = Files.newBufferedReader(Paths.get(pathToFile), StandardCharsets.UTF_8);
        String line;

        while((line = reader.readLine()) != null){
          System.out.println(line);
        }
    }

  public static String readFromUser() {
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNextLine()) {
      return scanner.nextLine();
    }
    return null;
  }
}
