import TypeClasses.*;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainE {

  public static void main(String[] args) throws Exception {
    List<Animal> animalList = new ArrayList<Animal>();
    String filePathZooIn = "C:/Users/antuf/Projects/Lab2/src/TypeClasses/ZooIn";
    String filePathZooOut = "C:/Users/antuf/Projects/Lab2/src/TypeClasses/ZooOut";
    try {
      animalList = readZooFrom(filePathZooIn);


      animalList.sort(new Comparator<Animal>() {
        @Override
        public int compare(Animal animal1, Animal animal2) {
          int temp = Integer.compare(animal2.quantAllFood(), animal1.quantAllFood());
          if (temp == 0) return animal1.getName().compareTo(animal2.getName());
          return temp;
        }

      });

      if (writeZooTo(filePathZooOut, animalList)) {
        System.out.println("File rewrite");
      }
    } catch (IOException e) {
      System.out.println("Fix File and restart the program");
    }

  }


  public static List<Animal> readZooFrom(String filePath) throws IOException {
    List<Animal> animalList = new ArrayList<Animal>();

      List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);

      for (String animal : lines) {
        String[] arrayStr = animal.split(";", 4);

        if (arrayStr[2].equals(TypeOfAnimal.PREDATOR.getTypeOfAnimal())) {
          animalList.add(new Predator(Integer.parseInt(arrayStr[0]),
                  arrayStr[1], getListOfFood(arrayStr[3])));
        }

        if (arrayStr[2].equals(TypeOfAnimal.HERBIVOROUS.getTypeOfAnimal())) {
          animalList.add(new Herbivorous(Integer.parseInt(arrayStr[0]),
                  arrayStr[1], getListOfFood(arrayStr[3])));
        }

        if (arrayStr[2].equals(TypeOfAnimal.OMNIVOROUS.getTypeOfAnimal())) {
          animalList.add(new Omnivorous(Integer.parseInt(arrayStr[0]),
                  arrayStr[1], getListOfFood(arrayStr[3])));
        }
      }

      return animalList;
  }

  public static boolean writeZooTo(String filePath, List<Animal> list) throws IOException {
    try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8)) {
      for ( Animal i: list) {
        writer.write(i.toString());
      }
      return true;

    } catch (IOException e) {
      e.printStackTrace();
      throw new IOException("IOException throw in method writeZooTo");
    }

  }


  public static List<Food> getListOfFood(String str) {
    String [] lines = str.split(";");
    List<Food> foodList = new ArrayList<>();

    for (int i = 0; i < lines.length ; i+=2) {
      foodList.add(new Food(lines[i], Integer.parseInt(lines[i + 1])));
    }

    return foodList;
  }
}
