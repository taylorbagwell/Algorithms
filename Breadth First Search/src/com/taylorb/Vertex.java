package com.taylorb;

import java.util.LinkedList;

public class Vertex {
	private String identifier;
	private LinkedList<Vertex> adjacentVertices = new LinkedList<>();
	private boolean visited = false;

	public Vertex(String identifier) {
		this.identifier = identifier;
	}

	public void AddAdjacentVertex(Vertex vertex) {
		adjacentVertices.add(vertex);
	}

	public LinkedList<Vertex> GetAdjacentVertices() {
		return adjacentVertices;
	}

	public void SetVisited(boolean visited) {
		this.visited = visited;
	}

	public boolean HasVisited() {
		return visited;
	}

	@Override
	public String toString() {
		return identifier;
	}
}