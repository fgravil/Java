package mySorts;

public class Sorts {
	
	public int[] insertionSort(int arr[])
	{
		for(int i=1;i<arr.length;i++)
		{
			/** current number in the index */
			int value = arr[i];
			/** represents the index, will change based on precedence  */
			int hole = i;
			
			/* if value in the current index is
			 * less than number in previous index 
			 * loop in place and chan
			 */
			while(hole > 0 && value < arr[i-1])
			{
				arr[i] = arr[i-1];
				hole--;
			}
			
			arr[hole] = value;
			
		}
		
		return arr;
	}
}
