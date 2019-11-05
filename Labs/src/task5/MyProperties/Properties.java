package MyProperties;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Properties {

  private Map<String, String> hashMap;

  public Properties(String pathToFile) {
    try {
      File file = new File(pathToFile);
      if (file.exists()) {
        String extension = getExtension(pathToFile);
        if (!extension.equals(".properties")) {
          throw new IOException("File don`t have properties");
        }
      } else {
        throw new IOException("File doesnt exist");
      }

      hashMap = new HashMap<>();
      List<String> list = Files.readAllLines(Paths.get(pathToFile), StandardCharsets.UTF_8);
      for (String line : list) {

        if (!line.contains("=")){
          throw new IOException(line + "doesnt have delimiter");
        }

        String[] arrayOfKeyValue = line.split("=");

        if (arrayOfKeyValue.length == 0 || arrayOfKeyValue[0].equals("")) {
          throw new IOException(line + "doesnt have KEY");
        }

        if (hashMap.containsKey(arrayOfKeyValue[0])) {
          throw new IOException("Properties file have the same KEY");
        }

        if (arrayOfKeyValue.length == 1){
          hashMap.put(arrayOfKeyValue[0], null);
        } else hashMap.put(arrayOfKeyValue[0], arrayOfKeyValue[1]);
      }
    } catch (IOException e) {
      System.out.println("Can`t reed file " + pathToFile);
    } catch (NullPointerException e) {
      System.out.println("File " + pathToFile + "hasn`t extension");
    }
  }

  public String getPropertyByName(String key) {
    return hashMap.get(key);
  }

  public Collection<String> getProperties() {
    return hashMap.values();
  }

  public Set<Map.Entry<String, String>> getSetOfEntry() {
    return hashMap.entrySet();
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<String, String> i : hashMap.entrySet()) {
      stringBuilder.append(i.toString()).append("\n");
    }
    return stringBuilder.toString();
  }

  private String getExtension(String path) throws NullPointerException {
    int numOfDot = path.indexOf(".");
    if (numOfDot <= 0) {
      throw new NullPointerException();
    }
    return path.substring(numOfDot);
  }
}
