package com.taylorb;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Graph graph = new Graph();
		BellmanFord bf = new BellmanFord();

		System.out.print("Enter Example to Run (1, 2, 3)? ");
		int ex = scanner.nextInt();

		scanner.close();

		if (ex == 1) {
			Vertex a = new Vertex("0");
			Vertex b = new Vertex("1");
			Vertex c = new Vertex("2");
			Vertex d = new Vertex("3");
			Vertex e = new Vertex("4");
			Vertex f = new Vertex("5");
			Vertex g = new Vertex("6");
			Vertex h = new Vertex("7");

			graph.AddVertex(a);
			graph.AddVertex(b);
			graph.AddVertex(c);
			graph.AddVertex(d);
			graph.AddVertex(e);
			graph.AddVertex(f);
			graph.AddVertex(g);
			graph.AddVertex(h);

			graph.AddEdge(new Edge(a, b, 5));
			graph.AddEdge(new Edge(a, e, 9));
			graph.AddEdge(new Edge(a, h, 8));
			graph.AddEdge(new Edge(b, c, 12));
			graph.AddEdge(new Edge(b, d, 15));
			graph.AddEdge(new Edge(b, h, 4));
			graph.AddEdge(new Edge(c, d, 3));
			graph.AddEdge(new Edge(c, g, 11));
			graph.AddEdge(new Edge(d, g, 9));
			graph.AddEdge(new Edge(e, f, 4));
			graph.AddEdge(new Edge(e, g, 20));
			graph.AddEdge(new Edge(e, h, 5));
			graph.AddEdge(new Edge(f, c, 1));
			graph.AddEdge(new Edge(f, g, 13));
			graph.AddEdge(new Edge(h, f, 6));
			graph.AddEdge(new Edge(h, c, 7));

			bf.RunAlgorithm(graph, a);
		}

		else if (ex == 2) {
			Vertex a = new Vertex("1");
			Vertex b = new Vertex("2");
			Vertex c = new Vertex("3");
			Vertex d = new Vertex("4");
			Vertex e = new Vertex("5");

			graph.AddVertex(a);
			graph.AddVertex(b);
			graph.AddVertex(c);
			graph.AddVertex(d);
			graph.AddVertex(e);

			graph.AddEdge(new Edge(a, c, 6));
			graph.AddEdge(new Edge(a, d, 3));
			graph.AddEdge(new Edge(b, a, 3));
			graph.AddEdge(new Edge(c, d, 2));
			graph.AddEdge(new Edge(d, b, 1));
			graph.AddEdge(new Edge(d, c, 1));
			graph.AddEdge(new Edge(e, b, 4));
			graph.AddEdge(new Edge(e, d, 2));

			bf.RunAlgorithm(graph, e);
		}

		else if (ex == 3) {
			// Contains negative cycle

			Vertex a = new Vertex("0");
			Vertex b = new Vertex("1");
			Vertex c = new Vertex("2");
			Vertex d = new Vertex("3");

			graph.AddVertex(a);
			graph.AddVertex(b);
			graph.AddVertex(c);
			graph.AddVertex(d);

			graph.AddEdge(new Edge(a, b, 5));
			graph.AddEdge(new Edge(a, c, 4));
			graph.AddEdge(new Edge(b, d, 3));
			graph.AddEdge(new Edge(c, b, -6));
			graph.AddEdge(new Edge(d, c, 2));

			bf.RunAlgorithm(graph, a);
		}
	}
}