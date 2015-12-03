
public class EmptyNode<K extends Comparable<K>, O> implements Node<K,O>{
	/*@ public model JMLValueToObjectMap keyToValue;
	 *@ public pure model JMLValueToObjectMap getMappings(Node node)
	 *{	if(node == null)
	 		return new JMLValueToObjectMap();
	 	else return new JMLValueToObjectMap(new JMLInteger(node.key), node.obj)
	 								.extendUnion(getMappings(node.leftNode))
	 								.extendUnion(getMapping(node.rightNode));
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
	/*@ ensures /result == ""; */
	public String toString()
	{
		return "";
	}
	
	/** Returns an empty string. */
	/*@ ensures /result == ""; */
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
