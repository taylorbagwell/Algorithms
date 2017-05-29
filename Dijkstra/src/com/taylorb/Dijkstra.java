package com.taylorb;

import java.util.*;

public class Dijkstra {
	public Dijkstra() {}

	public Graph CalculateShortestPathFromSource(Graph graph, Node source) {
		source.SetDistance(0);

		HashSet<Node> settledNodes = new HashSet<>();
		HashSet<Node> unsettledNodes = new HashSet<>();

		unsettledNodes.add(source);

		while (unsettledNodes.size() != 0) {
			Node currentNode = GetLowestDistanceNode(unsettledNodes);
			unsettledNodes.remove(currentNode);

			for (Map.Entry<Node, Integer> adjacencyPair : currentNode.GetAdjacentNodes().entrySet()) {
				Node adjacentNode = adjacencyPair.getKey();
				Integer edgeWeight = adjacencyPair.getValue();

				if (!settledNodes.contains(adjacentNode)) {
					CalculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
					unsettledNodes.add(adjacentNode);
				}
			}

			settledNodes.add(currentNode);
		}

		return graph;
	}

	private void CalculateMinimumDistance(Node evaluationNode, int edgeWeight, Node sourceNode) {
		Integer sourceDistance = sourceNode.GetDistance();
		if (sourceDistance + edgeWeight < evaluationNode.GetDistance()) {
			evaluationNode.SetDistance(sourceDistance + edgeWeight);
			LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.GetShortestPath());
			shortestPath.add(sourceNode);
			evaluationNode.SetShortestPath(shortestPath);
		}
	}

	private Node GetLowestDistanceNode(HashSet<Node> unsettledNodes) {
		Node lowestDistanceNode = null;
		int lowestDistance = Integer.MAX_VALUE;
		for (Node node : unsettledNodes) {
			int nodeDistance = node.GetDistance();
			if (nodeDistance < lowestDistance) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}

		return lowestDistanceNode;
	}
}