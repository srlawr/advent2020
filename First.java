import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class First {

  public static void main(String[] args) {

    try {
	
	List<String> content = Files.readAllLines(Paths.get("expenses.csv"));


	content.forEach(thisNumber->{

	Stream<String> allNumbers = content.stream();
	
        Stream<String> result = allNumbers.filter(secondNumber -> Integer.valueOf(secondNumber)+Integer.valueOf(thisNumber) == 2020);

	result.forEach(thisOne->System.out.println(Integer.valueOf(thisOne)*Integer.valueOf(thisNumber)+" "));
      });

 
    } catch (IOException ex) {

    }
  
  }
}
