import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Second2 {
	
  public static void main(String[] args) {

    int valids = 0;
 
    try {
		
      String content = new String(Files.readAllBytes(Paths.get("passwords.txt")));

      Pattern p = Pattern.compile("(\\d*)-(\\d*)\\s(\\w):\\s(.*)");
      Matcher m = p.matcher(content);
      m.matches();

      while(m.find()) {
	
	boolean isValid = Character.compare(m.group(4).charAt(Integer.valueOf(m.group(1))-1), 
			                    m.group(3).charAt(0)) == 0 
		                            ^
			  Character.compare(m.group(4).charAt(Integer.valueOf(m.group(2))-1),
		 			    m.group(3).charAt(0)) == 0;
	  
        if(isValid) {
	  valids++;
	}
      }

    } catch (IOException ex) { }

    System.out.println(valids);

  }
}
