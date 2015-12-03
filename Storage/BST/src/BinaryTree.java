//@ model import org.jmlspecs.models.JMLValueToObjectMap;
//@ model import org.jmlspecs.models.JMLInteger;
public class BinaryTree<K extends Comparable<K>,O> {
	
	/*@ public model JMLValueToObjectMap keyToValue;
	  @ public pure model JMLValueToObjectMap getMappings(Node<K,O> node)
	  {	if(node == null)
	 		return new JMLValueToObjectMap();
	 	else return new JMLValueToObjectMap(new JMLInteger(node.key), node.obj)
	 								.extendUnion(getMappings(node.leftNode))
	 								.extendUnion(getMapping(node.rightNode));
	 	 	}
	 */
	/** Top node of the binary search tree **/
	protected Node<K,O> root; //@ in keyToValue;
	/*@ protected represents keyToValue = getMappings(root);
	 */
	
	/** Initializes the tree and sets root node as empty an empty node. */
	public BinaryTree()
	{
		root = new EmptyNode<K,O>();
	}
	
	/** Initializes root node with given key and O type object. */
	public BinaryTree(K key, O obj)
	{
		root = new RegNode<K,O>(key, obj);
	}
	
	/** Adds a new node to the tree at the correct position upon tree traversal. */
	/*@ ensures  keyToValue.equals( \old(keyToValue.extend(new JMLInteger(key),obj) ));
	 */
	public void add(K key,O obj)
	{
		root = root.addTraverse(key,obj);
	}
	
	/** Returns BST as a string. */
	public String toString()
	{
		return "{" + root.toString() + "}";
	}
	

	/** Searches for the if the key exists in the BST and prints out the object **/
	/*@ requires node != null;
	 *@ ensures /result == node.obj;
	 */
	public O Search(K key)
	{
		return  root.Search(key);
	
	}

}
