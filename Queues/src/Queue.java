
public class Queue<T> {
	
	/*@ spec_public*/ private T[] myQueue;
	/*@ spec_public*/ private int sizeOfQueue;
	/**index of the beginning of queue */
	/*@ spec_public*/ private int front = 0; 
	/**index of the last element of queue */
	/*@ spec_public*/ private int rear = 0; 
	/**number of elements in queue */
	/*@ spec_public*/ private int count = 0;


	/*@ public invariant myQueue != null;
	  @ public invariant (\forall int i; i<=front && i< rear;
	  @						myQueue[i] != null);
	  @ public invariant 0<=front && front<= count;
	  @ public invariant 0<=rear && rear<= count;
	  @ public invariant 0<= count && count<= sizeOfQueue;
	  */
	
   /**Initializes queue by given it an input size.*/
   /*@ requires size > 0;
	 @ ensures \fresh(myQueue);  
	 @ ensures myQueue.length == sizeOfQueue;
	 */
	@SuppressWarnings("unchecked")
	public Queue(int size)
	{
		sizeOfQueue = size;
		myQueue = (T[])(new Object[sizeOfQueue]);
		
	}
	
	/**Inserts new input into the queue.*/	
   /*@ requires (count+ 1) < sizeOfQueue;
	 @ ensures myQueue[rear] == input;
	 @ ensures rear == \old(rear + 1);
	 @ ensures count== \old(count+ 1);
	 */
	public void insert(T input)
	{
		if(count + 1 < sizeOfQueue) //checks if adding a new input will cause an overflow
		{
			myQueue[rear] = input; //added value at the end of line
			rear++; //keeps track of the end value in line
			count++; // number of items incremented
			//System.out.println(input + " has been added to the queue.");
		}
//		else
//			System.out.println("OVERFLOW!");
		
	}
	
	/**Removes front value in queue and returns it.**/
	/*@ public normal_behavior
	 @ requires count!= 0;
	 @ assignable front, myQueue[front];
	 @ ensures \result == \old(myQueue[(front)]);
	 @ ensures myQueue[\old(front)] == null;
	 @ ensures front == \old(front + 1);
	 @ ensures count== \old(count- 1); 
	 */
	public T remove()
	{
		T value = null;
		if(count != 0)
		{
			//System.out.println(myQueue[front] + " has been  removed from the queue");
			value = myQueue[front]; //item that gets popped off and returned
			myQueue[front] = null; //the current countis set to null
			front++; // the new front is the next index
			count--; //the countcount is decremented
			
		}
		else
		{
			throw new IllegalArgumentException();
		}
		
		return value;
	}
	
	/**Returns the value that is in the front of the queue.*/
	/*@ requires count!= 0;
	  @ ensures \result == myQueue[front];
	 */
	public /*@pure*/ T peek() 
	{	
		return myQueue[front];
	}
	
	/**Returns the queue s a string representation. */
	public /*@pure*/ String toString()
	{
		StringBuffer str = new StringBuffer();
		for(int i=front;i<=rear-1;i++) //counts from front to rear to values in queue
		{
			str.append(myQueue[i].toString() + " ");
		}
		
		return str.toString();
	}

}
