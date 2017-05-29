package com.taylorb;

import java.util.HashMap;
import java.util.LinkedList;

public class Node {
	private String identifier;
	private int distance = Integer.MAX_VALUE;
	private HashMap<Node, Integer> adjacentNodes = new HashMap<>();
	private LinkedList<Node> shortestPath = new LinkedList<>();

	public Node(String identifier) {
		this.identifier = identifier;
	}

	public void AddAdjacentNode(int distance, Node node) {
		adjacentNodes.put(node, distance);
	}

	public void SetDistance(int distance) {
		this.distance = distance;
	}

	public int GetDistance() {
		return distance;
	}

	public HashMap<Node, Integer> GetAdjacentNodes() {
		return adjacentNodes;
	}

	public void SetShortestPath(LinkedList<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public LinkedList<Node> GetShortestPath() {
		return shortestPath;
	}

	public String GetIdentifier() {
		return identifier;
	}

	@Override
	public String toString() {
		return identifier;
	}
}