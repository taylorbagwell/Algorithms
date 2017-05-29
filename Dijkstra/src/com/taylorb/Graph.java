package com.taylorb;

import java.util.HashSet;

public class Graph {
	private HashSet<Node> nodes = new HashSet<Node>();

	public Graph() {}

	public void AddNode(Node node) {
		nodes.add(node);
	}

	public HashSet<Node> GetNodes() {
		return nodes;
	}
}