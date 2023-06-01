package com.sonic.polygonGraph;

public class Node {

	private int data; // data element
	private boolean visited; // flag to track the already visited node
	private Node leftNode;
	private Node rightNode;

	public Node(int _data){
		this.data = _data;
		visited = false;
	}
	
	public int getData()
	{
		return data;
	}
	
	public boolean checkVisited()
	{
		return visited;
	}
	
	public void setVisited(boolean bool)
	{
		visited = bool;
	}
	
	public Node getLeftNode()
	{
		return leftNode;
	}
	
	public Node getRightNode()
	{
		return rightNode;
	}

	public void addLeftNode(Node node){
		leftNode = node;
		node.rightNode = this;
	}
	
	public void addRightNode(Node node){
		rightNode = node;
		node.leftNode = this;
	}

}
