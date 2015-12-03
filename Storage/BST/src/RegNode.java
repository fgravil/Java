//@ model import org.jmlspecs.models.*;
public class RegNode<K extends Comparable<K>,O> implements Node<K,O>{

	/*@ spec_public @*/ K key;
	/*@ spec_public @*/ O obj;
	/*@ spec_public @*/ Node<K,O> leftNode = new EmptyNode<K,O>();
	/*@ spec_public @*/ Node<K,O> rightNode = new EmptyNode<K,O>();
	
	/*@ public model JMLValueToObjectMap keyToValue;
	  @ public pure model JMLValueToObjectMap getMappings(nullable Node<K,O> node)
	 	{	if(node == null)
	 		return new JMLValueToObjectMap();
	 	else return new JMLValueToObjectMap(node.key, node.obj)
	 								.extendUnion(getMappings(node.leftNode))
	 								.extendUnion(getMapping(node.rightNode));
	 	 	}
	 */
	enum Placement {LEFT,RIGHT;};
	
	
	/**make a singleton node with the given key and value
	 */
	/*@ assignable key,obj;
	  @ ensures this.key == key;
	  @ ensures this.obj == obj; 
	 */
	public RegNode(K key, O obj)
	{
		this.key = key;
		this.obj = obj;
	}

	/**returns a string that represents the set of all mappings at this node and subnodes.  */
	/*@ ensures \result != "";*/
	public String toString()
	{
		return leftNode.toString(Node.Placement.RIGHT) 
				+ "(" + key.toString()+ "," + obj.toString() + ")" 
				+ rightNode.toString(Node.Placement.LEFT);
	}
	
	/** This returns the same string is toString, but adds comma to the left or  right of the result. */
	/*@ ensures /result != "" */
	@Override
	public String toString( Node.Placement place) {
		if(Node.Placement.LEFT == place)
		{
			return ", " + this.toString();
		}
		else
			return this.toString() + ", ";
		
	}
	
	/** Adds mapping from key to obj and returns the node containing that mapping. */
	@Override
		public Node<K, O> addTraverse(K newKey, O newObj) {
		
		if(newKey.compareTo(this.key) < 0)
		{
			leftNode = leftNode.addTraverse(newKey, newObj);
		}
		
	
		else if(newKey.compareTo(this.key) > 0)
		{
			rightNode = rightNode.addTraverse(newKey, newObj);
		}
		
		else
		{
			obj = newObj;
		}
		
		return this;
		
	}
	
	/** Traverses the node to find a key match and returns the obj. */
	/*@ ensures /result == obj;*/
	public O Search(K key)
	{
		if(key.compareTo(this.key) < 0)
			return leftNode.Search(key);
		
		else if(key.compareTo(this.key) >0)
			return rightNode.Search(key);
		
		else
			return obj;
	}

	

	
}
