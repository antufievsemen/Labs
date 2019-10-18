package TypeClasses;

public class Food {

  private String name;
  private int quant;

  public Food(String name, int quant) {
    this.name = name;
    this.quant = quant;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQuant() {
    return quant;
  }

  public void setQuant(int price) {
    this.quant = quant;
  }

  @Override
  public String toString() {
    return "[" + name + " - " + Integer.toString(quant) + "] \n";
  }

}
