
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer,String> tree = new BinaryTree<Integer,String>();
		tree.add(50, "Fred");
		tree.add(25, "John");
		tree.add(75, "Gary");
		tree.add(10, "Andy");
		tree.add(30, "Carl");
		
		System.out.println(tree.toString());
	}

}
