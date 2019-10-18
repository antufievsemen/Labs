package TypeClasses;

import java.util.List;

public class Omnivorous extends Animal {

  public Omnivorous(int id, String name, List<Food> food) {
    this.id = id;
    this.name = name;
    this.food = food;
  }

  @Override
  public String typeOfAnimal() {
    return TypeOfAnimal.OMNIVOROUS.getTypeOfAnimal();
  }

}
