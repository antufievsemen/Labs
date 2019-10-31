package MyProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class MyProperties{

  private Map<String, String> hashMap = new HashMap<>();

  public MyProperties(String pathToFile) throws IOException {
    List<String> list = Files.readAllLines(Paths.get(pathToFile), StandardCharsets.UTF_8);
    for(String line: list){
      String[] arrayOfKeyValue = line.split("=");
      hashMap.put(arrayOfKeyValue[0], arrayOfKeyValue[1]);
    }
  }

  public String getValue(String key){
    return hashMap.get(key);
  }

  public Collection<String> getValues(){
    return hashMap.values();
  }

  public Set<Map.Entry<String, String>> getSetOfEntry(){
    return hashMap.entrySet();
  }

  public String toString(){
    StringBuilder stringBuilder = new StringBuilder();
    for(Map.Entry<String, String> i: hashMap.entrySet()){
      stringBuilder.append(i.toString() + "\n");
    }
    return stringBuilder.toString();
  }
}
