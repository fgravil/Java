import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class triangle {

	private static Scanner read;
	
	public static void reader() throws FileNotFoundException
	{
		read = new Scanner(System.in);
		
		int cases = read.nextInt();
		
		for(int i=0; i<cases;i++)
		{
			int a,b,c;
			
			a = read.nextInt();
			b = read.nextInt();
			c = read.nextInt();
			
			if(a >= b + c)
			{
				System.out.println("Case #" + (i+1) + ":" + " invalid!");
			}
			else if(b >= a + c)
			{
				System.out.println("Case #" + (i+1) + ":" + " invalid!");
			}
			else if(c >= a + b)
			{
				System.out.println("Case #" + (i+1) + ":" + " invalid!");
			}
			else
			{
				if(a == b && a==c)
				{
					System.out.println("Case #" + (i+1) + ":" + " equilateral");
				}
				else if(a == b || a==c || b==c)
				{
					System.out.println("Case #" + (i+1) + ":" + " isosceles");
				}
				else
					System.out.println("Case #" + (i+1) + ":" + " scalene");
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		reader();
		

	}

}
