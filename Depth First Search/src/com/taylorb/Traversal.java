package com.taylorb;

import java.util.Stack;
import java.util.Iterator;
import java.util.LinkedList;

public class Traversal {
	public Traversal() {}

	public void RunIteratively(Vertex root) {
		Stack<Vertex> s = new Stack<>();
		LinkedList<Vertex> visited = new LinkedList<>();

		s.push(root);

		while (!s.isEmpty()) {
			Vertex current = s.pop();

			if (!current.HasVisited()) {
				current.SetVisited(true);
				visited.add(current);

				Iterator<Vertex> iter = current.GetAdjacentVertices().iterator();
				while (iter.hasNext()) {
					Vertex adjacentVertex = iter.next();
					s.push(adjacentVertex);
				}
			}
		}

		System.out.println(visited.toString());
	}

	public void RunRecursively(LinkedList<Vertex> visited, Vertex current) {
		current.SetVisited(true);
		visited.add(current);

		Iterator<Vertex> iter = current.GetAdjacentVertices().iterator();
		while (iter.hasNext()) {
			Vertex adjacentVertex = iter.next();

			if (!adjacentVertex.HasVisited()) {
				RunRecursively(visited, adjacentVertex);
			}
		}
	}
}