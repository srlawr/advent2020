import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fourth {
	
  public static void main(String[] args) throws IOException {
  
		Fourth f = new Fourth();

  }
	
	public Fourth() throws IOException {

		String content = new String(Files.readAllBytes(Paths.get("passports2.txt")));

	//Passport p = new Passport();

		List<Passport> records = Stream.of(content.split("\\n").toString())        //content.stream()
															      .map(String::trim)
																	  .map(s -> new Passport(s))
																	  .collect(Collectors.toList());

		
	}
	
	public class Passport {
		public String byr;
		public String iyr;
		public String eyr;
		public String hgt;
		public String hcl;
		public String ecl;
		public String pid;
		public String cid;
	
		public Passport() {
		  
		}

		public Passport(String init) {
		  addProperties(init);
		}


		public void addProperties(String props) {
			String[] attributes = props.split(":");
			attributes.stream().map(a -> System.out.println(a));
		}
	
		public boolean isValid() {
		  // all but cid
			if(byr != null &&
				 iyr != null &&
				 eyr != null &&
				 hgt != null &&
				 hcl != null &&
				 ecl != null &&
				 pid != null) {
							return true;
				 }
		  	return false;
						
	  }
  }
}
