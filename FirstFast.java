import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FirstFast {
	

	public static void main(String[] args) {

	boolean gotIt = false;

	try {
 	
	List<String> content = Files.readAllLines(Paths.get("expenses.csv"));


	content.forEach(firstNum -> {
		content.forEach(secondNum -> {
			content.forEach(thirdNum -> {

		
			if(Integer.valueOf(firstNum) + 
			   Integer.valueOf(secondNum) + 
			   Integer.valueOf(thirdNum) == 2020) {

				System.out.println(Integer.valueOf(firstNum) * 
						   Integer.valueOf(secondNum) * 
						   Integer.valueOf(thirdNum));
			}

			});
	
		});
	});
	
	
	} catch (IOException ex) {

	}

	}

}
