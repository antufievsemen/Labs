package StringBuilderWIthUndo;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class StringBuilderWithUndo {

    private Deque<StringBuilder> commands = new LinkedList<>();
    private StringBuilder stringBuilder;

    public StringBuilderWithUndo(String line) {
      stringBuilder = new StringBuilder(line);
    }

    public StringBuilderWithUndo(StringBuilder line) {
      stringBuilder = new StringBuilder(line);
    }

    public int compareTo(StringBuilder another) {
      return stringBuilder.compareTo(another);
    }

    public int compareTo(StringBuilderWithUndo another) {
      return stringBuilder.compareTo(another.stringBuilder);
    }

    public StringBuilderWithUndo append(Object obj) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.append(obj);
      return this;
    }

    public StringBuilderWithUndo append(String str) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.append(str);
      return this;
    }

    public StringBuilderWithUndo append(StringBuffer sb) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.append(sb);
      return this;
    }

    public StringBuilderWithUndo append(CharSequence s) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.append(s);
      return this;
    }

    public StringBuilderWithUndo append(CharSequence s, int start, int end) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.append(s, start, end);
      return this;
    }

    public StringBuilderWithUndo append(char[] str) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.append(str);
      return this;
    }

    public StringBuilderWithUndo append(char[] str, int offset, int len) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.append(str, offset, len);
      return this;
    }

    public StringBuilderWithUndo append(boolean b) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.append(b);
      return this;
    }

    public StringBuilderWithUndo append(char c) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.append(c);
      return this;
    }

    public StringBuilderWithUndo append(int i) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.append(i);
      return this;
    }

    public StringBuilderWithUndo append(long lng) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.append(lng);
      return this;
    }

    public StringBuilderWithUndo append(float f) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.append(f);
      return this;
    }

    public StringBuilderWithUndo append(double d) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.append(d);
      return this;
    }

    public StringBuilderWithUndo appendCodePoint(int codePoint) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.appendCodePoint(codePoint);
      return this;
    }

    public StringBuilderWithUndo delete(int start, int end) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.delete(start, end);
      return this;
    }

    public StringBuilderWithUndo deleteCharAt(int index) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.deleteCharAt(index);
      return this;
    }

    public StringBuilderWithUndo replace(int start, int end, String str) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.replace(start, end, str);
      return this;
    }

    public StringBuilderWithUndo insert(int index, char[] str, int offset, int len) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.insert(index, str, offset, len);
      return this;
    }

    public StringBuilderWithUndo insert(int offset, Object obj) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.insert(offset, obj);
      return this;
    }

    public StringBuilderWithUndo insert(int offset, String str) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.insert(offset, str);
      return this;
    }

    public StringBuilderWithUndo insert(int offset, char[] str) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.insert(offset, str);
      return this;
    }

    public StringBuilderWithUndo insert(int dstOffset, CharSequence s) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.insert(dstOffset, s);
      return this;
    }

    public StringBuilderWithUndo insert(int dstOffset, CharSequence s, int start, int end) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.insert(dstOffset, s, start, end);
      return this;
    }

    public StringBuilderWithUndo insert(int offset, boolean b) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.insert(offset, b);
      return this;
    }

    public StringBuilderWithUndo insert(int offset, char c) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.insert(offset, c);
      return this;
    }

    public StringBuilderWithUndo insert(int offset, int i) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.insert(offset, i);
      return this;
    }

    public StringBuilderWithUndo insert(int offset, long l) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.insert(offset, l);
      return this;
    }

    public StringBuilderWithUndo insert(int offset, float f) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.insert(offset, f);
      return this;
    }

    public StringBuilderWithUndo insert(int offset, double d) {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.insert(offset, d);
      return this;
    }

    int indexOf(String str) {
      return stringBuilder.indexOf(str);
    }

    int indexOf(String str, int fromIndex) {
      return stringBuilder.indexOf(str, fromIndex);
    }

    int lastIndexOf(String str) {
      return stringBuilder.lastIndexOf(str);
    }

    int lastIndexOf(String str, int fromIndex) {
      return stringBuilder.lastIndexOf(str, fromIndex);
    }

    public StringBuilderWithUndo reverse() {

      commands.add(new StringBuilder(stringBuilder));
      stringBuilder.reverse();
      return this;
    }

    public StringBuilderWithUndo undo() {
      if (!commands.isEmpty()) {
        stringBuilder = commands.removeLast();
      } else {
        System.err.println("История изменений пуста, состояние объекта не изменено");
      }
      return this;
    }

    public StringBuilder getStringBuilder() {
      return stringBuilder;
    }

    public void setStringBuilder(StringBuilder stringBuilder) {
      this.stringBuilder = stringBuilder;
    }

    public String toString() {
      return stringBuilder.toString();
    }
}

