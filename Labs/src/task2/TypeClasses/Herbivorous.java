package TypeClasses;

import java.util.List;

public class Herbivorous extends Animal {

  public Herbivorous(int id, String name, List<Food> food) {
    this.id = id;
    this.name = name;
    this.food = food;
  }

  @Override
  public String typeOfAnimal() {
    return TypeOfAnimal.HERBIVOROUS.getTypeOfAnimal();
  }

}
