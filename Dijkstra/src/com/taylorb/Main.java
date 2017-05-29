package com.taylorb;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");

		nodeA.AddAdjacentNode(10, nodeB);
		nodeA.AddAdjacentNode(15, nodeC);
		nodeB.AddAdjacentNode(12, nodeD);
		nodeB.AddAdjacentNode(15, nodeF);
		nodeC.AddAdjacentNode(10, nodeE);
		nodeD.AddAdjacentNode(2, nodeE);
		nodeD.AddAdjacentNode(1, nodeF);
		nodeF.AddAdjacentNode(5, nodeE);

		Graph graph = new Graph();

		graph.AddNode(nodeA);
		graph.AddNode(nodeB);
		graph.AddNode(nodeC);
		graph.AddNode(nodeD);
		graph.AddNode(nodeE);
		graph.AddNode(nodeF);

		Dijkstra dijkstra = new Dijkstra();
		graph = dijkstra.CalculateShortestPathFromSource(graph, nodeA);

		Iterator<Node> iter = graph.GetNodes().iterator();
		while (iter.hasNext()) {
			Node currNode = iter.next();

			System.out.println(String.format("%s: %s - %s", currNode.GetIdentifier(), currNode.GetDistance(),
					currNode.GetShortestPath().toString()));
		}
	}
}