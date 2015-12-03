import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Elections {

	private  static Scanner scan;
	
	public static void reader() throws FileNotFoundException
	{
		int spoilt = 0;
		Candidates winner = new Candidates();
		scan = new Scanner(new File("C:/Users/Fred/Documents/elections.txt"));
		
		Candidates[] candidate = new Candidates[7];
		
		for(int i=0;i<7;i++)
		{
			String name = scan.nextLine();
			candidate[i] = new Candidates();
			candidate[i].setName(name);
		}
		
		while(scan.hasNext())
		{
			int number = scan.nextInt();
			if(number > 7 || number < 1 )
			{
				spoilt++;
			}
			else
			{
				
				switch(number)
				{
					case 1: candidate[0].setVotes(1);	break;
					case 2: candidate[1].setVotes(1);	break;
					case 3: candidate[2].setVotes(1);	break;
					case 4: candidate[3].setVotes(1);	break;
					case 5: candidate[4].setVotes(1);	break;
					case 6: candidate[5].setVotes(1);	break;
					case 7: candidate[6].setVotes(1);	break;
					default: break;
				}
			}
		}
		
		List<Candidates> winners = new ArrayList<Candidates>();	
		
		for(int i=0; i< candidate.length -1 ; i++)
		{
			if(candidate[i].getVotes() >= candidate[i+1].getVotes())
			{
				winners.add(candidate[i]);
			}
		}
		
		if(winners.size() == 0)
		{
			System.out.println("The winner of the election is "  + winners.get(0).getName() +" with " +
					winners.get(0).getVotes() + " votes. There was " + spoilt + " spoilt votes.");
		}
		else
		{
			System.out.print("There was a tie between candidates ");
			
			for(Candidates i : winners)
				System.out.print(i.getName() + ", ");
			
			System.out.println("who got a total of " + winners.get(0).getVotes() + " votes.");
			
			System.out.println("There was " + spoilt + " votes.");
		}
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		reader();
	}
}
