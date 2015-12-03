import org.jmlspecs.models.*;
public interface Node <K extends Comparable <K>,O>{
	
	/*@ public model JMLEqualsToObjectMap getMappings(nullable Node<K,O> node);
	  @ public model JMLEqualsToObjectMap getMappings();
	 */
	enum Placement {LEFT,RIGHT;};
	
	/** Returns a representation of the mapping at this node and subnodes */
	String toString();
	
	/** Returns value found at the given key if there is a mapping from key to that value, and throws an exception otherwise.*/
	O Search(K key);
	
	/** Adds mapping from key to obj and returns the node containing that mapping. */
	Node<K,O> addTraverse(K key, O obj);
	
	/** This returns the same string is toString, but adds comma to the left or  right of the result. */
	String toString(Placement place);
	
}
