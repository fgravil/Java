import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Inequality {

	private static Scanner read;
	public static void reader() throws FileNotFoundException
	{
		read = new Scanner(new File("C:/Users/Fred/Documents/inequality.txt"));
		
		int cases = read.nextInt();
		long target = 0,x;
		int size, result=0, counter;
		
		for(int i=0; i<cases;i++)
		{
			target = read.nextInt();
			size = read.nextInt();
			x = -target;
			counter = 0;
			int[] arr = new int[size];
			
			for(int j=0; j<size; j++ )
			{
				arr[j] = read.nextInt();
			}
			
			for(long j=-target;j<target;j++)
			{
				
				for(int k=0; k<arr.length;k++)
				{
					result += Math.abs(arr[k] - x);
					
					if(result > target)
					{
						break;
					}
					
				}
				
				if(result <= target)
					 counter++;
				result = 0;
				x++;
			}
			
			System.out.println(counter);
			
		}
		
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		reader();
	}

}
