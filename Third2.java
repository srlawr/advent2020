import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.math.BigInteger;

public class Third2 {
	
  public static void main(String[] args) throws IOException {
  
    String content = new String(Files.readAllBytes(Paths.get("trees.txt")));
 
    int[][] map = Arrays.stream(content.split("\\n"))
                           .map(e -> e.chars()
                           .filter(b -> b != 13)
                           .toArray())
                           .toArray(int[][]::new);

    BigInteger numOfTrees = new BigInteger(SlopeRun(1, 1, map).toString());

    numOfTrees = numOfTrees.multiply(BigInteger.valueOf(SlopeRun(3,1, map)));
    numOfTrees = numOfTrees.multiply(BigInteger.valueOf(SlopeRun(5,1, map)));
    numOfTrees = numOfTrees.multiply(BigInteger.valueOf(SlopeRun(7,1, map)));
    numOfTrees = numOfTrees.multiply(BigInteger.valueOf(SlopeRun(1,2, map)));

    System.out.println(numOfTrees);
  }

  private static Integer SlopeRun(int diffX, int diffY, int[][] map) {

    Integer localTrees = 0;

    int currX = 0;
    int currY = 0;

    while(currY < map.length) {

      if(map[currY][currX] == 35) {
        localTrees++;
      }

      currX = currX + diffX;
      
      if(currX >= map[currY].length) {
        currX = currX - map[currY].length;
      }

      currY = currY + diffY;
    } 

    return localTrees;
  }
}

