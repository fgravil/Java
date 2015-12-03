public class Stack <Elem>{
	  private int tos; 

	/*@ spec_public */ private Elem[] stackArray;
	/*@ spec_public */ private int stackSize;
	/*@ public model int topOfStack; */
	/*@ private represents topOfStack = tos;*/
	/*@ public invariant stackArray != null;
	  @ public invariant 
	  @ (\forall int i; 0<=i && i<=topOfStack;
	  @    stackArray[i] != null);
	  @ public invariant -1<=topOfStack && topOfStack < stackSize;
	 */
	
	/**Method to initialize a stack with a given input size. */
	/*@ requires size > 0;
	  @ ensures stackSize == size;
	  @ ensures stackArray.length == stackSize; 
	  @ ensures topOfStack == -1;
	 */
	@SuppressWarnings("unchecked")
	public Stack(int size) //set desired stack size
	{
		stackSize = size;
		stackArray = (Elem[])(new Object[stackSize]);
		tos = -1;
		
	}
	
	/**Inserts new input at the top of the stack provided it is not full.*/
	/*@ requires input != null;
	  @ requires topOfStack + 1 < stackSize;
	  @ assignable stackArray[topOfStack + 1];
	  @ ensures topOfStack == \old(topOfStack + 1);
	  @ ensures stackArray[topOfStack] == input;
	 */
	public void push(Elem input)
	{

			tos++;
			stackArray[tos] = input;
	}
	
	
	/**Removes value at the top of the stack. */
	/*@ requires topOfStack > -1;
	  @ assignable topOfStack, stackArray[topOfStack];
	  @ ensures \result == stackArray[\old(topOfStack)];
	  @ ensures stackArray[topOfStack] == null;
	  @ ensures topOfStack == \old(topOfStack - 1);
	 */ 
	public Elem pop()
	{
		Elem value = null;
//		if(topOfStack > -1)
//		{
			//System.out.println(stackArray[topOfStack] + " has been popped out of the stack");
			value = stackArray[tos];
			stackArray[tos] = null;//the element of this index is deinitialized
			tos--;
			return value;
//		}
		
			
		
		
	}
	
	/**Identifies value at the very top of the stack. */
	/*@ requires topOfStack > -1;
	  @ ensures \result == stackArray[topOfStack];
	 */
	public /*@pure*/ Elem peek()
	{
		if(tos == -1)
		{
			throw new IllegalArgumentException();
			//System.out.println("The top value of the stack is " + stackArray[topOfStack]);
		}
//		else
//		return "-1";//Empty Stack
		
		return stackArray[tos];
	}
	
	/**Checks whether there is no value in the stack. */
	/*@ ensures \result == (topOfStack == -1); */
	public /*@pure*/ boolean isEmpty()
	{
		return (tos == -1);			
	}
	
	
	/**Returns the stack as a string.*/
	public String toString()
	{
		StringBuffer str = new StringBuffer();
		for(int i=0;i<=tos;i++)
		{
			str.append(stackArray[i].toString());
		}
		
		return str.toString();
	}
	
	
}
