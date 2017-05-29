package com.taylorb;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Traversal traversal = new Traversal();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Run Example Resursively or Iteratively (I, R)? ");
		String val = scanner.next();

		scanner.close();

		Vertex v0 = new Vertex("A");
		Vertex v1 = new Vertex("B");
		Vertex v2 = new Vertex("C");
		Vertex v3 = new Vertex("D");
		Vertex v4 = new Vertex("E");
		Vertex v5 = new Vertex("F");
		Vertex v6 = new Vertex("G");

		v0.AddAdjacentVertex(v1);
		v0.AddAdjacentVertex(v2);
		v0.AddAdjacentVertex(v4);

		v1.AddAdjacentVertex(v3);
		v1.AddAdjacentVertex(v5);
		v1.AddAdjacentVertex(v0);

		v2.AddAdjacentVertex(v6);
		v2.AddAdjacentVertex(v0);

		v3.AddAdjacentVertex(v1);

		v4.AddAdjacentVertex(v0);
		v4.AddAdjacentVertex(v5);

		v5.AddAdjacentVertex(v1);
		v5.AddAdjacentVertex(v4);

		v6.AddAdjacentVertex(v2);

		if (val.toLowerCase().equals("i")) {
			traversal.RunIteratively(v0);
		}

		else if (val.toLowerCase().equals("r")) {
			LinkedList<Vertex> s = new LinkedList<>();
			traversal.RunRecursively(s, v0);
			System.out.println(s.toString());
		}
	}
}