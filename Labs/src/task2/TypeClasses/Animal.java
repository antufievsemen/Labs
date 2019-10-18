package TypeClasses;

import java.util.List;

public abstract class  Animal {

  protected int id;
  protected String name;
  protected List<Food> food;

  public int quantAllFood() {
    int sum = 0;

    for (Food i: this.food) {
      sum += i.getQuant();
    }

    return sum;
  }

  public abstract String typeOfAnimal();

  public List<Food> getFood() {
    return food;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    StringBuilder resStr = new StringBuilder();
    resStr.append(Integer.toString(id)).append(" " + name).append( " " + typeOfAnimal()).append(" : \n");
    for (Food i : food) {
      resStr.append(i.toString());
    }
    return resStr.toString();
  }

}


