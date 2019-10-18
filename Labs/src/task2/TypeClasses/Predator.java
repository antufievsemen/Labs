package TypeClasses;

import java.util.List;

public class Predator extends Animal {
  public Predator (int id, String name, List<Food> food) {
    this.id = id;
    this.name = name;
    this.food = food;
  }

  @Override
  public String typeOfAnimal() {
    return TypeOfAnimal.PREDATOR.getTypeOfAnimal();
  }

}
