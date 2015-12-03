//@ model import org.jmlspecs.models.JMLEqualsToObjectMap;
//@ model import org.jmlspecs.models.JMLInteger;
public class BinaryTree<K extends Comparable<K>,O> {
	
	/*@ public model JMLEqualsToObjectMap keyToValue;
	 */
	/** Top node of the binary search tree **/
	protected Node<K,O> root; //@ in keyToValue;
	/*@ protected represents keyToValue = root.getMappings();
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
	/*@ ensures  keyToValue.equals( \old(keyToValue.extend(key,obj) ));
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
	

	/** Searches for the value associated with the key and returns the value.**/
	/*@ public normal_behavior
	  @   requires keyToValue.isDefinedAt(key);
	  @   ensures \result == keyToValue.apply(key);
	  @ also 
	  @ public exceptional_behavior
	  @   requires !keyToValue.isDefinedAt(key);
	  @   signals_only NotFoundException;
	 */
	public O Search(K key)
	{
		return  root.Search(key);
	
	}

}
