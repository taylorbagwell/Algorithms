package com.taylorb;

public class Vertex {
	private String identifier;
	private int distance = Integer.MAX_VALUE;
	private Vertex predecessor = null;

	public Vertex(String identifier) {
		this.identifier = identifier;
	}

	public void SetDistance(int distance) {
		this.distance = distance;
	}

	public int GetDistance() {
		return distance;
	}

	public String GetIdentifier() {
		return identifier;
	}

	public void SetPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public Vertex GetPredecessor() {
		return predecessor;
	}

	@Override
	public String toString() {
		return identifier;
	}
}