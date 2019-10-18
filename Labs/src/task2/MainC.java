import TypeClasses.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class MainC {
  public static void main(String[] args) {
    List<Food> herbFoodList = new ArrayList<Food>();
    herbFoodList.add(new Food("seeds", 121));
    herbFoodList.add(new Food("plants", 150));

    List<Food> predFoodList = new ArrayList<Food>();
    predFoodList.add(new Food("pork", 76));
    predFoodList.add(new Food("beef", 66));

    List<Food> omniFoodList = new ArrayList<Food>();
    omniFoodList.add(new Food("seeds", 1000));
    omniFoodList.add(new Food("beef", 33));

    Predator tiger = new Predator(33, "tiger", predFoodList);
    Predator lion = new Predator(54, "lion", predFoodList);

    Herbivorous cow = new Herbivorous(66, "cow", herbFoodList);
    Herbivorous goat = new Herbivorous(72, "goat", herbFoodList);

    Omnivorous pig = new Omnivorous(90, "pig", omniFoodList);
    Omnivorous boar = new Omnivorous(21, "boar", omniFoodList);

    ArrayList<Animal> animalList = new ArrayList<Animal>();
    animalList.add(pig);
    animalList.add(cow);
    animalList.add(tiger);
    animalList.add(lion);
    animalList.add(goat);
    animalList.add(boar);

    animalList.sort(new Comparator<Animal>() {
      @Override
      public int compare(Animal animal1, Animal animal2) {
        int temp = Integer.compare(animal2.quantAllFood(), animal1.quantAllFood());
        if (temp == 0) return animal1.getName().compareTo(animal2.getName());
        return temp;
      }
    });

    for (int i = animalList.size() - 1; i > animalList.size() - 4; i--) {
      System.out.println(animalList.get(i).getId());
    }
  }
}
