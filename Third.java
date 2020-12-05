import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Third {
	
  public static void main(String[] args) throws IOException {
  
    String content = new String(Files.readAllBytes(Paths.get("trees.txt")));
 
    int[][] map = Arrays.stream(content.split("\\n"))
                           .map(e -> e.chars()
                           .filter(b -> b != 13)
                           .toArray())
                           .toArray(int[][]::new);

    int numOfTrees = 0;

    int currX = 0;
    int currY = 0;

    while(currY < map.length-1) {

      if(map[currY][currX] == 35) {
        numOfTrees++;
      }

      currX = currX + 3;
      
      if(currX >= map[currY].length) {
        currX = currX - map[currY].length;
      }

      currY++;
    
    } 

    System.out.println(numOfTrees);

  }
}
