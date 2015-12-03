//@ model import org.jmlspecs.models.JMLValueToObjectMap;
//@ model import org.jmlspecs.models.JMLInteger;
public class BinaryTree {
	
	/*@ public model JMLValueToObjectMap keyToValue;
	 *@ public pure model JMLValueToObjectMap getMappings(Node node)
	 *{	if(node == null)
	 		return new JMLValueToObjectMap();
	 	else return new JMLValueToObjectMap(new JMLInteger(node.key), node.obj)
	 								.extendUnion(getMappings(node.leftNode))
	 								.extendUnion(getMapping(node.rightNode));
	 	 	}
	 */
	/** top node of the binary search tree **/
	protected Node root; //@ in keyToValue;
	/*@ protected represents keyToValue = getMappings(root);
	 */
	
	
	/*@ ensures  keyToValue.equals( \old(keyToValue.extend(new JMLInteger(key),obj) ));
	 */
	public void addNode(int key,String obj)
	{
		Node newNode = new Node(key, obj);
		
		//checks if the tree is empty to set a new head node
		if(root == null)
		{
			root = newNode;
		}
		else
		{
			root.addTraverse(newNode);;
		}
	}
	
	/**prints the binary search tree in increasing order **/
	/*@ requires root != null;
	 */
	public void printInOrder()
	{
		printInOrder(root);
	}
	
	public String toString()
	{
		return "{" + root.toString() + "}";
	}
	
	private void printInOrder(Node root)
	{
		if(root != null)
		{
			printInOrder(root.leftNode);
			System.out.println(root.obj);
			printInOrder(root.rightNode);
		}
		
	}
	
	/**prints the binary search tree from top to bottom**/
	/*@ requires root != null;
	 */
	public void printPreOrder()
	{
		printPreOrder(root);
	}
	private void printPreOrder(Node root)
	{
		if(root != null)
		{
			System.out.println(root.key);
			printPreOrder(root.leftNode);
			printPreOrder(root.rightNode);
		}
	}
	
	/**prints the binary search tree from left to right **/
	/*@ requires root != null;
	 */
	public void printPostOrder()
	{
		printPostOrder(root);
	}
	private void printPostOrder(Node root)
	{
		printPostOrder(root.leftNode);
		printPostOrder(root.rightNode);
		System.out.println(root.key);
	}
	
	/** Searches for the if the key exists in the BST and prints out the object **/
	/*@ requires node != null;
	  @ ensures \result == node.obj;
	 */
	public String Search(Node node, int key)
	{
		//returns empty string if the key is not in the BST
		if(node == null)
			return "";
		
		//returns the string of the node where the key is found
		else if(node.key == key)
		{
			return node.obj;
		}
		
		
		else if(key < node.key)
		{
			node = node.leftNode;
		}
		
		else if(key > node.key)
		{
			node = node.rightNode;
		}
		
		return Search(node , key);
	}

}
