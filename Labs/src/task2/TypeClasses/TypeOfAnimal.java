package TypeClasses;

public enum TypeOfAnimal {
  PREDATOR ("predator"),
  HERBIVOROUS("herbivorous"),
  OMNIVOROUS("omnivorous");

  private String typeOfAnimal;

  TypeOfAnimal(String typeOfAnimal) {
    this.typeOfAnimal = typeOfAnimal;
  }

  public String getTypeOfAnimal() {
    return typeOfAnimal;
  }

}
