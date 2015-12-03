
public class TriNumbers {

	public static void main(String[] args) {
		
		int num = 0;
		long result = 0;
		
		while(num != 500)
		{
			
		}

	}
	
	public static long TriNum(long num)
	{
		if(num == 0)
			return 0;
		
		return (num + TriNum(num-1));
	}
	
	public static boolean isPrime(long num)
	{
		if(num % 2 == 0)
			return false;
		for(int i=3;i*i<num;i+=2)
		{
			if(num % i == 0)
			return false;
		}
		
		return true;
	}

}
