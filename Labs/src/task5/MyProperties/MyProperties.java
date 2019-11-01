package MyProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*; нельзя так делать, все такие импорты разворачивать


public class MyProperties{ Properties

  private Map<String, String> hashMap = new HashMap<>(); инициализация в конструкторе + ты знаешь размер мапы

  public MyProperties(String pathToFile) throws IOException { лови IOException, бросай новое исключение и напиши понятное сообщение пользователю
    List<String> list = Files.readAllLines(Paths.get(pathToFile), StandardCharsets.UTF_8); Если файл без расширения .properties?
    for(String line: list){
      String[] arrayOfKeyValue = line.split("="); там может не быть =
      hashMap.put(arrayOfKeyValue[0], arrayOfKeyValue[1]); слева от = могут быть пусто, надо ругаться и говорить, что неверный формат, а вот значение может быть пустое
      не должно быть два одинаковых ключа! но мапа позволит тебе вставить
    }
  }

  public String getValue(String key){ getPropertyByName
    return hashMap.get(key);
  }

  public Collection<String> getValues(){ getProperties
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
