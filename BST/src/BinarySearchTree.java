
public class BinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.addNode(50, "Fred");
		tree.addNode(25, "John");
		tree.addNode(75, "Gary");
		tree.addNode(10, "Andy");
		tree.addNode(30, "Carl");
		
		tree.printInOrder();
		System.out.println(tree.toString());
		//System.out.println(tree.Search(tree.root,3 ));
	}

}
