package com.sonic.polygonGraph;

import java.util.*;

public class Polygon {
	private List<Node> listNodes;
	private int dimension;

	public Polygon(List<Node> _listNodes) {
		listNodes = _listNodes;
		dimension = listNodes.size();
		createGraph();
	}

	public Polygon(int _dimension) {
		dimension = _dimension;
		createNodes();
		createGraph();
	}

	private void createNodes() {
		listNodes = new ArrayList<Node>();
		for (int i = 0; i < dimension; i++) {
			listNodes.add(new Node(i + 1));
		}
	}

	private void createGraph() {
		try {
			if (dimension > 2) {
				for (int i = 0; i < dimension; i++) {
					if (i < dimension - 1) {
						listNodes.get(i).addLeftNode(listNodes.get(i + 1));
					} else
						listNodes.get(i).addLeftNode(listNodes.get(0));
				}
			}
		} catch (Exception e) {
			System.out.println("[Polygon create graph] " + e.getMessage());
		}
	}

	public List<RedLine> getRedLines(int key) {
		List<RedLine> redLines = null;
		try {
			if (key > dimension)
				return null;
			redLines = new ArrayList<RedLine>();
			Node node = listNodes.get(key - 1);
			redLines.add(new RedLine(node, new Node(0)));
			node.setVisited(true);
			node = node.getLeftNode();
			while (!node.checkVisited()) {
				Node node2 = node.getRightNode();
				while (node2.checkVisited()) {
					node2 = node2.getRightNode();
				}
				redLines.add(new RedLine(node, node2));
				node.setVisited(true);
				node2.setVisited(true);
				node = node.getLeftNode();
			}
			clearVisitedNodes();
		} catch (Exception e) {
			System.out.println("[getRedLines] " + e.getMessage());
		}
		return redLines;
	}

	private void clearVisitedNodes() {
		for (Node node : listNodes) {
			node.setVisited(false);
		}
	}

	public int getDimension() {
		return dimension;
	}

	// ---------------------------------------Print Test-------------------------------------------

	public void printf() {
		System.out.println("Polygon dimension " + dimension);
		Node node = listNodes.get(0);
		System.out.println("Node " + node.getData());
		for (int i = 0; i < dimension * 2; i++) {
			node = node.getRightNode();
			System.out.println("Node " + node.getData());
		}
	}

	public void printListRedLines(List<RedLine> redLines) {
		int redLineDimension = redLines.size();
		for (int i = 0; i < redLineDimension; i++) {
			redLines.get(i).print();
		}
	}
}
