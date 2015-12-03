
//@ model import org.jmlspecs.models.JMLEqualsToObjectMap;


public class EmptyNode<K extends Comparable<K>, O> implements Node<K,O>{
	
	 /*@ public pure model JMLEqualsToObjectMap getMappings()
	     {	
	 	     return new JMLEqualsToObjectMap();
	     }
	 */
	public EmptyNode() {
		
	}

	/** Creates a new empty node. */
	@Override
	public Node<K,O> addTraverse(K key, O obj) {
		return new RegNode<K, O>(key,obj);
		
	}

	/** Returns an empty string. */
	/*@ ensures \result == ""; */
	public String toString()
	{
		return "";
	}
	
	/** Returns an empty string. */
	/*@ ensures \result == ""; */
	@Override
	public String toString(Node.Placement place) {
		
		return "";
	}

	/** Throws an exception if a node cannot be found with the given key */
	@Override
	public O Search(K key) {
		
		throw new NotFoundException();
	}
	
	
}
