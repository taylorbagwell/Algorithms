package com.taylorb;

public class Edge {
	private Vertex u;
	private Vertex v;
	private int weight = 0;

	public Edge(Vertex u, Vertex v, int weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

	public int GetWeight() {
		return weight;
	}

	public Vertex GetU() {
		return u;
	}

	public Vertex GetV() {
		return v;
	}
}