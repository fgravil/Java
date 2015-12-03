
public class BinarySearchTree
{
	
	static BST m_objBST = new BST();
	
	
	public static void main(String[] args) 
	{
		
		m_objBST.Insert(50);
		m_objBST.Insert(17);
		m_objBST.Insert(12);
		m_objBST.Insert(23);
		m_objBST.Insert(9);
		m_objBST.Insert(14);
		m_objBST.Insert(19);
		m_objBST.Insert(72);
		m_objBST.Insert(54);
		m_objBST.Insert(76);
		m_objBST.Insert(67);
		
		//m_objBST.delete(50);
		
		m_objBST.printBST(m_objBST.m_objRootNode);
		System.out.println(m_objBST.Search(17).getRank());
		
		//System.out.print(m_objBST.getMax(m_objBST.m_objRootNode));
	}
	
}