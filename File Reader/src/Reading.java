import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Reading {
	
	private static Scanner input;
	
	public static void main(String args[]) throws FileNotFoundException
	{
		File file = new File("input.txt");
		input = new Scanner(new FileReader(file));
		
	}

}
