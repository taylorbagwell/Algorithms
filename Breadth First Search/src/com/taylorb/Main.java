package com.taylorb;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Traversal traversal = new Traversal();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Example to Run (1, 2)? ");
		int ex = scanner.nextInt();

		System.out.print("Compute Iteratively or Recursively (I, R)? ");
		String val = scanner.next();

		scanner.close();

		if (ex == 1) {
			Vertex v0 = new Vertex("0");
			Vertex v1 = new Vertex("1");
			Vertex v2 = new Vertex("2");
			Vertex v3 = new Vertex("3");

			v0.AddAdjacentVertex(v1);
			v0.AddAdjacentVertex(v2);

			v1.AddAdjacentVertex(v2);

			v2.AddAdjacentVertex(v0);
			v2.AddAdjacentVertex(v3);

			v3.AddAdjacentVertex(v3);

			if (val.toLowerCase().equals("i")) {
				traversal.RunIteratively(v2);
			}

			else if (val.toLowerCase().equals("r")) {
				Queue<Vertex> q = new LinkedList<>();
				LinkedList<Vertex> s = new LinkedList<>();
				q.add(v2);

				traversal.RunRecursively(q, s);

				System.out.println(s.toString());
			}
		}

		else if (ex == 2) {
			Vertex v0 = new Vertex("0");
			Vertex v1 = new Vertex("1");
			Vertex v2 = new Vertex("2");
			Vertex v3 = new Vertex("3");
			Vertex v4 = new Vertex("4");
			Vertex v5 = new Vertex("5");
			Vertex v6 = new Vertex("6");
			Vertex v7 = new Vertex("7");
			Vertex v8 = new Vertex("8");

			v0.AddAdjacentVertex(v1);
			v0.AddAdjacentVertex(v3);
			v0.AddAdjacentVertex(v8);

			v1.AddAdjacentVertex(v0);
			v1.AddAdjacentVertex(v7);

			v2.AddAdjacentVertex(v3);
			v2.AddAdjacentVertex(v5);
			v2.AddAdjacentVertex(v7);

			v3.AddAdjacentVertex(v0);
			v3.AddAdjacentVertex(v2);
			v3.AddAdjacentVertex(v4);

			v4.AddAdjacentVertex(v3);
			v4.AddAdjacentVertex(v8);

			v5.AddAdjacentVertex(v2);
			v5.AddAdjacentVertex(v6);

			v6.AddAdjacentVertex(v5);

			v7.AddAdjacentVertex(v1);
			v7.AddAdjacentVertex(v2);

			v8.AddAdjacentVertex(v0);
			v8.AddAdjacentVertex(v4);

			if (val.toLowerCase().equals("i")) {
				traversal.RunIteratively(v0);
			}

			else if (val.toLowerCase().equals("r")) {
				Queue<Vertex> q = new LinkedList<>();
				LinkedList<Vertex> s = new LinkedList<>();
				q.add(v0);

				traversal.RunRecursively(q, s);

				System.out.println(s.toString());
			}
		}
	}
}