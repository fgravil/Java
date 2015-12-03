import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class cow {
	
	private static Scanner read;
	
	public static void reader() throws FileNotFoundException
	{
		read = new Scanner(new File("C:/Users/Fred/Documents/cow.txt"));
		
		int cases = read.nextInt();
		int cow = 0;
		
		for(int i=0; i<cases; i++)
		{
			String input = read.next();
			int length = input.length();
			
			for(int j=0;j<length-1;j++)
			{
				if(input.charAt(j) == input.charAt(j+1) && input.charAt(j) == '(')
				{
					for(int k=i+2;k<input.length()-1;k++ )
					{
						if(input.charAt(k) == input.charAt(k+1) && input.charAt(k) == ')')
						{
							cow++;
						}
					}
				}
			}
			
			System.out.println(cow);
			cow =0;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		reader();
	}

}
