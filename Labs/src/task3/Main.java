import StringBuilderWIthUndo.StringBuilderWithUndo;

public class Main {

  public static void main(String[] args) {

    String testLine = "aaa";
    StringBuilder sb = new StringBuilder("eee");
    StringBuilderWithUndo myStringBuilder = new StringBuilderWithUndo(testLine);
    StringBuilderWithUndo myStringBuilder2 = new StringBuilderWithUndo(sb + "fff");

    myStringBuilder.append("bbb")
            .append("ccc")
            .append("ddd");
    System.out.println(myStringBuilder);

    myStringBuilder.undo();
    System.out.println(myStringBuilder);

    myStringBuilder.undo()
            .undo();
    System.out.println(myStringBuilder);

    System.out.println(myStringBuilder.compareTo(sb));
    StringBuilder sb2 = new StringBuilder("ggg");
    myStringBuilder.setStringBuilder(sb2);
    System.out.println(myStringBuilder.compareTo(myStringBuilder2));

    myStringBuilder.append("aaa")
            .append("bbb")
            .append("ccc")
            .append("ddd");
    myStringBuilder.delete(12, 15)
            .delete(6, 9)
            .deleteCharAt(0)
            .deleteCharAt(2);
    System.out.println(myStringBuilder);

    myStringBuilder.replace(4, 6, "hh");
    System.out.println(myStringBuilder);

    myStringBuilder.insert(2, "iii");
    System.out.println(myStringBuilder);
  }
}