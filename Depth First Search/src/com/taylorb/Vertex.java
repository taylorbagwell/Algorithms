package com.taylorb;

import java.util.LinkedList;

public class Vertex {
	private boolean visited = false;
	private LinkedList<Vertex> adjacentVertices = new LinkedList<>();
	private String identifier;

	public Vertex(String identifier) {
		this.identifier = identifier;
	}

	public boolean HasVisited() {
		return visited;
	}

	public void SetVisited(boolean visited) {
		this.visited = visited;
	}

	public void AddAdjacentVertex(Vertex vertex) {
		adjacentVertices.add(vertex);
	}

	public LinkedList<Vertex> GetAdjacentVertices() {
		return adjacentVertices;
	}

	@Override
	public String toString() {
		return identifier;
	}
}