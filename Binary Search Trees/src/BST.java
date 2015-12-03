
public class BST 
{
	// This is the root node, which starts off as null
	//   when the BST is empty.
	/*@ spec_public*/ BSTNode m_objRootNode;
	int k = 3;
	
	/** Class constructor. **/
	/*@ ensures m_objRootNode == null;*/
	public BST()
	{
		// Not really necessary, provided for clarity.
		m_objRootNode = null;
	}

	/** Method to see if the tree is empty. **/
	/*@ ensures \result == ( m_objRootNode == null ); */
	public boolean IsEmpty()
	{
		// Return a boolean indicating whether the
		//   three is empty or not.
		return( m_objRootNode == null );
	}

	
	/** Functions to search for an element */
    public BSTNode Search( int nKeyValue )
    {
        return( Search( m_objRootNode, nKeyValue ) );
    }
    
    /** Method to search for an element recursively. */
    /*@ requires_redundantly objNode  != null;
     *@ 
     */
    private BSTNode Search( BSTNode objNode, int nKeyValue )
    {
    	
    	if( objNode == null )
    	{
    		return( null );
    	}
    	
    	// First, we get the key value for this node.
    	int nThisKeyValue = objNode.GetKeyValue();
            
    	// See if the passed in key value is less. If so,
    	//   this indicates that we need to go left.
    	if( nKeyValue < nThisKeyValue )
    	{
    		// Get the left node object reference so we
    		//   can walk down it.
    		objNode = objNode.GetLeftNode();
    	}
            
    	// See if the passed in key value is greater. If so,
    	//   this indicates that we need to go right.
    	else if( nKeyValue > nThisKeyValue )
    	{
    		// Get the right node object reference so we
    		//   can walk down it.
    		objNode = objNode.GetRightNode();
    	}

    	// Here we have found the node with the key
    	//   value that was passed in.
    	else
    	{
    		return( objNode );
    	}
            
    	// Now call Search recursively.
    	return( Search( objNode, nKeyValue ) );
	}
    
    /**This method inserts a node based on the key value. */
    
    public void Insert( int nKeyValue ) 
    {
    	// The root node is returned to m_objRootNode from Insert()
    	m_objRootNode = Insert( nKeyValue, m_objRootNode );
    }    

    /** Class protected (internal) method to insert nodes. This method
       will be called recursively.**/
    
    protected BSTNode Insert( int nKeyValue, BSTNode objNode ) 
    {
 
    	// This node is null and simply needs to be allocated.
        if( objNode == null )
        {
        	objNode = new BSTNode( nKeyValue );
        }
        
        // Here we need to walk left.
        else if( nKeyValue < objNode.GetKeyValue())
        {
        	// Set the left node of this object by recursively walking left.
        	objNode.SetLeftNode( Insert( nKeyValue, objNode.GetLeftNode() ) );
        	objNode.setSubSize(objNode.subSize+1);
        }
        
        // Here we need to walk right.
        else if( nKeyValue > objNode.GetKeyValue())
        {
        	// Set the right node of this object by recursively walking right.
        	objNode.SetRightNode( Insert( nKeyValue, objNode.GetRightNode() ) );
        	objNode.setSubSize(objNode.subSize+1);
        }
        //else objNode.setSubSize(objNode.subSize-1);
        //objNode.setSubSize(objNode.subSize+1);
        
        return( objNode );
    }
    
    public int getMin(BSTNode objNode)
    {
    	if(IsEmpty())
    	{
    		System.out.println("Empty tree");
    		return -1;
    	}
    	
    	if(objNode.GetLeftNode() == null)
    		return ( objNode.GetKeyValue() );
    	
    	return( getMin(objNode.GetLeftNode()) );
    }
    
    public int getMax(BSTNode objNode)
    {
    	if(IsEmpty())
    	{
    		System.out.println("Empty tree");
    		return -1;
    	}
    	
    	if(objNode.GetRightNode() == null)
    		return ( objNode.GetKeyValue() );
    	
    	return( getMax(objNode.GetRightNode()) );
    }
    
    public void delete(int nKeyValue)
    {
    	m_objRootNode = (delete(nKeyValue,m_objRootNode));
    	
    }
    /*@ requires objNode != null;
     *@ ensures
     */
    protected BSTNode delete(int nKeyValue, BSTNode objNode)
    {

    	if(objNode == null)
    		return null;
    	
    	if(objNode.GetKeyValue() == nKeyValue)
    	{
    		if(objNode.GetRightNode() == null && objNode.GetLeftNode() == null)
    		{
    			objNode = null;
    			//objNode.setSubSize(objNode.subSize-1);
    		}
    		
    		else if(objNode.GetRightNode() != null && objNode.GetLeftNode() == null)
    		{
    			objNode = objNode.GetRightNode();
    			objNode.setSubSize(objNode.subSize-1);
    		}
    		else if(objNode.GetRightNode() == null && objNode.GetLeftNode() != null)
    		{
    			objNode = objNode.GetLeftNode();
    			objNode.setSubSize(objNode.subSize-1);
    		}
    		else
    		{
    			int value = getMax(objNode.GetLeftNode());
    			delete(value,objNode.GetLeftNode());
    			objNode.SetKeyValue(value); 
    			objNode.setSubSize(objNode.subSize-1);
    		}
    		
    	}
    	else if( nKeyValue < objNode.GetKeyValue() )
        {
        	// Set the left node of this object by recursively walking left.
        	objNode.SetLeftNode( delete( nKeyValue, objNode.GetLeftNode() ) );
        }
        
        // Here we need to talk right.
        else if( nKeyValue > objNode.GetKeyValue() )
        {
        	// Set the right node of this object by recursively walking right.
        	objNode.SetRightNode( delete( nKeyValue, objNode.GetRightNode() ) );
        }
        
        return( objNode );
    		
    }
    
    public void printBST(BSTNode objNode)
    {
    	if(objNode != null)
    	{
    		printBST( objNode.GetLeftNode() );
        	System.out.println(objNode.GetKeyValue());
        	printBST( objNode.GetRightNode() );
    	}
    	
    }
    public void getRank(BSTNode objNode)
    {
    	if(objNode == null)
    		return;
    	
    	getRank(objNode.GetLeftNode());
    	objNode.setRank(objNode.rank+1);
    	getRank(objNode.GetRightNode());
    	
    }
    
}
 