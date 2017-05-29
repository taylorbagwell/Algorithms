package com.taylorb;

import java.util.Iterator;

public class BellmanFord {
	public BellmanFord() {}

	public void RunAlgorithm(Graph graph, Vertex source) {
		int numOfVertices = graph.GetVertices().size();
		int numOfEdges = graph.GetEdges().size();

		source.SetDistance(0);

		for (int i = 1; i < numOfVertices; i++) {
			for (int j = 0; j < numOfEdges; j++) {
				Edge e = graph.GetEdges().get(j);
				Vertex u = e.GetU();
				Vertex v = e.GetV();
				int weight = e.GetWeight();

				if (u.GetDistance() != Integer.MAX_VALUE && u.GetDistance() + weight < v.GetDistance()) {
					v.SetDistance(u.GetDistance() + weight);
					v.SetPredecessor(u);
				}
			}
		}

		for (int j = 0; j < numOfEdges; j++) {
			Edge e = graph.GetEdges().get(j);
			Vertex u = e.GetU();
			Vertex v = e.GetV();
			int weight = e.GetWeight();

			if (u.GetDistance() != Integer.MAX_VALUE && u.GetDistance() + weight < v.GetDistance()) {
				System.out.println("Graph Contains a Negative Cycle.");
				return;
			}
		}

		Iterator<Vertex> vertices = graph.GetVertices().iterator();
		while (vertices.hasNext()) {
			Vertex vertex = vertices.next();
			System.out.println(String.format("Identifier: %s | Distance: %s | Predecessor: %s", vertex.GetIdentifier(),
					vertex.GetDistance(), vertex.GetPredecessor()));
		}
	}
}