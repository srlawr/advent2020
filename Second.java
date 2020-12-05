import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Second {
	
  public static void main(String[] args) {

    int valids = 0;
 
    try {
		
      String content = new String(Files.readAllBytes(Paths.get("passwords.txt")));

      Pattern p = Pattern.compile("(\\d*)-(\\d*)\\s(\\w):\\s(.*)");
      Matcher m = p.matcher(content);
      m.matches();

      while(m.find()) {
	long count = m.group(4).chars().filter(ch -> ch == m.group(3).charAt(0)).count();
	
	boolean isValid = count >= Long.valueOf(m.group(1)) &&
		          count <= Long.valueOf(m.group(2));

        if(isValid) {
	  valids++;
	}
      }

    } catch (IOException ex) { }

    System.out.println(valids);

  }
}
