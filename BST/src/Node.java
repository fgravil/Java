/**
 * 
 */

/**
 * @author Fred
 *
 */
public class Node{
	
	enum Placement {LEFT,RIGHT;};
	int key;
	String obj;
	
	/*@ nullable @*/ Node leftNode;
	/*@ nullable @*/ Node rightNode;
	
	/*@ invariant (leftNode != null) ==> leftNode.key < key;
	  @ invariant (rightNode != null) ==> key < rightNode.key;
	 */
	
	/*@ public model JMLValueToObjectMap keyToValue;
	 *@ public pure model JMLValueToObjectMap getMappings()
	 *{
	 	return new JMLValueToObjectMap(new JMLInteger(this.key), this.obj)
	 								.extendUnion(getMappings(this.leftNode))
	 								.extendUnion(getMapping(this.rightNode));
	 	 	}
	  
	  public pure model JMLValueToObjectMap getMappings(Node nullNode)
	  {
	  	
	  }
	  
	 */
	
	public Node(int key, String obj)
	{
		this.key = key;
		this.obj = obj;
	}
	
	public String toString()
	{
		return toString(leftNode,Placement.RIGHT) 
			+ "(" + Integer.toString(key)+ "," + obj.toString() + ")" 
			+ toString(rightNode, Placement.LEFT);
	}
	
	/*@ requires newNode != null;
	 *@ ensures 
	 */
    void addTraverse(Node newNode)
	{
		
		/** if the key is smaller than the current node, traverse the leftNode**/
		if(newNode.key < this.key)
		{
			if(this.leftNode == null)
			{
				this.leftNode = newNode;
			}
			else
			{
				this.leftNode.addTraverse(newNode);;
			}
		}
		
		else if(newNode.key == this.key)
		{
			this.obj = newNode.obj;
		}
		

		else if(newNode.key > this.key)
		{
			if(this.rightNode == null)
			{
				this.rightNode = newNode;
			}
			else
			{
				this.rightNode.addTraverse(newNode);
			}
		}
	}
	
	/** This returns the empty string if helpNode is null, otherwise returns the String for that 
	 * node with a comma to the place side of the return string.
	 * @param helpNode
	 * @param place - the side where the comma goes in the result.
	 * @return - string appropriate for helpNode's subtree.
	 */
	public String toString(/*@ nullable @*/ Node helpNode, Placement place)
	{
		
		if(helpNode == null)
		{
			return "";
		}
		else
		{
			String ret = helpNode.toString();
			
			if(Placement.LEFT == place)
			{
				return ", " + ret;
			}
			else
				return ret + ", ";
		}
			
	}
	
	

}
