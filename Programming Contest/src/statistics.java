import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class statistics {

	private static Scanner read;
	public static void reader() throws FileNotFoundException
	{
		read = new Scanner(new File("C:/Users/Fred/Documents/statistics.txt"));
		
		int cases = read.nextInt(), pupils;
		
		for(int i=0; i<cases; i++)
		{
			pupils = read.nextInt();
			int[] arr = new int[pupils];
			int gap =0;
			
			for(int j=0; j<arr.length;j++ )
				arr[j] = read.nextInt();
			
			arr = Sort(arr);
			
			for(int j=0;j<arr.length-1;j++)
			{
				if(arr[j] - arr[j+1] > gap)
				{
					gap = arr[j] - arr[j+1];
				}
			}		
			System.out.printf("Class %d\nMax %d, Min %d, Largest gap %d\n",i+1,arr[0],arr[pupils-1],gap);
			
		}
		
		
	}
	
	public static int[] Sort(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
			for(int j=0; j< arr.length-1; j++)
			{
				if(arr[j] <= arr[j+1])
				{
					int swap =arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = swap;
				}
			}
		
		return arr;
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		reader();
	}

}
