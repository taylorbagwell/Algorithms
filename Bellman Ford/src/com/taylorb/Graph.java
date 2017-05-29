package com.taylorb;

import java.util.LinkedList;

public class Graph {
	private LinkedList<Edge> edges = new LinkedList<>();
	private LinkedList<Vertex> vertices = new LinkedList<>();

	public Graph() {}

	public void AddEdge(Edge edge) {
		edges.add(edge);
	}

	public void AddVertex(Vertex vertex) {
		vertices.add(vertex);
	}

	public LinkedList<Edge> GetEdges() {
		return edges;
	}

	public LinkedList<Vertex> GetVertices() {
		return vertices;
	}
}