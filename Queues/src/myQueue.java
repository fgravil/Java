/**
 * @author Fred Gravil
 *
 */
public class myQueue {

	public static void main(String[] args) {
		
		Queue<String> newQ = new Queue<String>(6);
		
		newQ.insert("3");
		newQ.insert("4");
		newQ.insert("11");
		newQ.insert("15");
		newQ.remove();
		newQ.remove();
		newQ.peek();
		System.out.println(newQ.toString());
		
	}

}
