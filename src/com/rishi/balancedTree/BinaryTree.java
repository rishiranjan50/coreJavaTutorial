package com.rishi.balancedTree;

public class BinaryTree {
	Node root;
	
	public static void main(String[] args) {
		//make binary tree
		treebalancingExample();
		
	}
	
	public static void treebalancingExample(){
		long start = System.currentTimeMillis();
		System.out.println("Programm starting****"+start);
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left= new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        
        tree.root.left.left.right.left = new Node(18);
        
        if(tree.isBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
        
        long finish = System.currentTimeMillis();
        System.out.println(finish+"execution time ***"+(finish-start));
	}

	private boolean isBalanced(Node root2) {
		// TODO Auto-generated method stub
		if(root2 == null){
			return true;
		}
		
		int leftHeight = height(root2.left);
		int rightHeight = height(root2.right);

		if(Math.abs(leftHeight-rightHeight) <= 1 &&(isBalanced(root2.left) && isBalanced(root2.right))){
			return true;
		}
		return false;
	}

	private int height(Node node) {
		// TODO Auto-generated method
		if(node == null || node.equals(null))
			return 0;
		return 1+Math.max(height(node.left), height(node.right));
	}
	
	
}
