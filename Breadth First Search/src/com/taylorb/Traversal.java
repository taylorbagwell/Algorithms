package com.taylorb;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

public class Traversal {

	public Traversal() {}

	public void RunIteratively(Vertex root) {
		Queue<Vertex> q = new LinkedList<>();
		LinkedList<Vertex> s = new LinkedList<>();

		q.add(root);

		while (!q.isEmpty()) {
			Vertex current = q.remove();

			if (!current.HasVisited()) {
				current.SetVisited(true);
				s.add(current);

				Iterator<Vertex> iter = current.GetAdjacentVertices().iterator();
				while (iter.hasNext()) {
					Vertex adjacentVertex = iter.next();

					if (!adjacentVertex.HasVisited()) {
						q.add(adjacentVertex);
					}
				}
			}
		}

		System.out.println(s.toString());
	}

	public void RunRecursively(Queue<Vertex> q, LinkedList<Vertex> s) {
		if (q.isEmpty()) {
			return;
		}

		Vertex current = q.remove();

		if (!current.HasVisited()) {
			current.SetVisited(true);
			s.add(current);

			Iterator<Vertex> iter = current.GetAdjacentVertices().iterator();
			while (iter.hasNext()) {
				Vertex adjacentVertex = iter.next();

				if (!adjacentVertex.HasVisited()) {
					q.add(adjacentVertex);
				}
			}
		}

		RunRecursively(q, s);
	}
}