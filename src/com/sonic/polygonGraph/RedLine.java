package com.sonic.polygonGraph;

public class RedLine {
	private Node node1;
	private Node node2;
	
	public RedLine(Node _node1, Node _node2)
	{
		node1 = _node1;
		node2 = _node2;
	}
	
	public int getNodeData1()
	{
		return node1.getData();
	}
	
	public int getNodeData2()
	{
		return node2.getData();
	}
	
	public void print()
	{
		System.out.println("RedLine (" + node1.getData() + ", " + node2.getData() + ")");
	}
}
