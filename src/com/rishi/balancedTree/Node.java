package com.rishi.balancedTree;

public class Node {
	public Node right,left;
	public int data;
	
	public Node(int data){
		this.data=data;
		this.right=this.left=null;
	}
}
