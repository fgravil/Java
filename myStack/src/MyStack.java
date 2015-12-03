import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MyStack {

	private static Scanner input;

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("C:/Users/Fred/Documents/stack_input.txt");
		input = new Scanner( new FileReader(file));
		ArrayList<String> list = new ArrayList<String>();
		String str = input.nextLine();
		
		while(str.compareTo("0") != 0)
		{
			list = String_arr(str);
			
			System.out.println( infixto_postfix(list));
			System.out.println(evaluator( infixto_postfix(list)));
			System.out.println();
			
			str = input.nextLine();
			
		}
	}
	
	/**Removes whitespace in string and each separate value is added to an ArrayList. */
	public static ArrayList<String> String_arr(String str)
	{
		StringBuffer newString = new StringBuffer();
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i) != ' ')
			{
				newString.append(str.substring(i, i+1));
			}
			else
			{
				list.add(newString.toString());
				newString = new StringBuffer();
			}
		}
		list.add(newString.toString());
		return list;
	}
	
	/**Checks if the input string is a numeric value. */
	public static boolean isNumeric(String str)
	{

	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
	
	/**Checks the numeric representation of the input char */
	public static int precedence(char c)
	{
		if(c == ')' )
			return 4;
		else if(c == '*' || c == '/')
			return 3;
		else if(c == '+' || c == '-')
			return 2;
		else 
			return 1;
		
	}
	
	/**Changes the Arraylist from an infix state to a postfix state. */
	public static ArrayList<String> infixto_postfix(ArrayList<String> list)
	{
		
		Stack<String> fullStack = new Stack<String>(list.size());
		Stack<String> opStack = new Stack<String>(list.size());
			
		for(int i=0;i<list.size();i++)
		{
			if(isNumeric(list.get(i).toString()))
			{
				fullStack.push(list.get(i).toString());
			}
			else
			{
				String operation = list.get(i).toString();
				int opCode = precedence((operation.charAt(0)));//finds precedence of input
				
				/*checks whether the next value to be pushed has higher precedence than
				 *the value at the top of the stack.
				 */
				if((opStack.isEmpty() || precedence(opStack.peek().charAt(0)) < opCode || opCode == 1) && opCode != 4 )
				{
					opStack.push(operation + "");
					
//					if(i == 0 && opStack.peek().compareTo("(") == 0)
//					{
//						fullStack.push(opStack.pop());
//					}
				}
				else if(opCode == 4)
				{
					while(opStack.peek().compareTo("(") != 0)
					{
						fullStack.push(opStack.pop());
					}
					opStack.pop();
				}
				/*if the opCode at the top of opStack has higher precedence than opCode
				 *than that value needs to be popped out and placed into fullStack.
				 *The next opCode will than be pushed in 
				 */
				else
				{
					/*continuously popping values out of opStack as long as it has higher 
					 *precedence than the next value to be pushed into the stack.
					 */
					while(!(opStack.isEmpty()) && precedence(opStack.peek().charAt(0)) >= opCode)
					{
						fullStack.push(opStack.pop());//pop out last
					}
					
					opStack.push(operation + "");//push in the next operation
				}
			}
		}
		
		/*pops out the rest of the values of opCodes that are remaining
		 *when the last iteration of the for loop is reached
		 */
		while(! (opStack.isEmpty()))
		{
			fullStack.push(opStack.pop());
		}
		
		list = new ArrayList<String>();

		
		
		while(!fullStack.isEmpty())
		{
			list.add(fullStack.pop());
		
		}
				
		//postfix_str = new StringBuffer(postfix_str).reverse().toString();
		Collections.reverse(list);
		return list;
	}
	
	/**Evaluates the values in the input ArrayList and returns final result.*/
	public static int evaluator(ArrayList<String> list)
	{
		
		Stack<String> stack = new Stack<String>(list.size());
		int num1, num2 = 0;
		
	
		
		for(int i= 0;i<list.size();i++)
		{			
			if(isNumeric(list.get(i)))
				stack.push(list.get(i));
			
			else
			{
			    if(list.get(i).charAt(0) == '*')
				{
					num1 = Integer.parseInt(stack.pop());
					num2 = Integer.parseInt(stack.pop());
					stack.push((num2 * num1)+ "");

				}
			    else if(list.get(i).charAt(0) == '/')
				{
			    	num1 = Integer.parseInt(stack.pop());
					num2 = Integer.parseInt(stack.pop());
					stack.push((num2 / num1)+ "");
				}
			    else if(list.get(i).charAt(0) == '+')
				{
			    	num1 = Integer.parseInt(stack.pop());
					num2 = Integer.parseInt(stack.pop());
					stack.push((num2 + num1)+ "");
				}
			    else if(list.get(i).charAt(0) == '-')
				{
			    	num1 = Integer.parseInt(stack.pop());
					num2 = Integer.parseInt(stack.pop());
					stack.push((num2 - num1)+ "");
				}
			}
		}
		
		return Integer.parseInt(stack.pop());
	}

}
