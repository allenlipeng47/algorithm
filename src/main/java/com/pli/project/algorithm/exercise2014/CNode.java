package com.pli.project.algorithm.exercise2014;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CNode {
	char c;
	Set<CNode> outgoing = new HashSet<CNode>();

	CNode(char i) {
		this.c = i;
	}

	// these two methods are important for hash
	public int hasCode() {
		return this.c;
	}

	public boolean equals(Object c) {
		if (c == this)
			return true;
		if (c instanceof CNode) {
			return this.c == ((CNode) c).c;
		}
		return false;
	}

	public static List<Character> findLanguageOrderDFS(String[] words) {

		Set<CNode> vertices = new HashSet<CNode>();
		createGraph(words, vertices);

		List<Character> result = new ArrayList<Character>();
		// add those vertices without any incoming edges
		Set<CNode> visited = new HashSet<CNode>();
		Set<CNode> processed = new HashSet<CNode>();
		Stack<CNode> stack = new Stack<CNode>();
		for (CNode n : vertices) {
			if (visited.contains(n))
				continue;
			if (processed.contains(n))
				throw new IllegalArgumentException("cycle found");
			DFS(n, visited, processed, stack);
			visited.add(n);
			stack.add(n);
		}

		while (!stack.isEmpty()) {
			result.add(stack.pop().c);
		}

		return result;
	}

	public static void DFS(CNode v, Set<CNode> visited, Set<CNode> processed,
			Stack<CNode> s) {
		if (visited.contains(v))
			return;
		if (processed.contains(v))
			throw new IllegalArgumentException("cycle found");
		processed.add(v);
		for (CNode n : v.outgoing) {
			if (!visited.contains(n)) {
				DFS(n, visited, processed, s);
			}
		}
		visited.add(v);
		s.push(v);
	}

	private static void createGraph(String[] words, Set<CNode> vertices) {
		// we may not need this hash map if we can trust the hashcode() written
		// in CNode class
		Map<Character, CNode> nodes = new HashMap<Character, CNode>();
		for (int i = 0; i < words.length - 1; i++) {
			String current = words[i], next = words[i + 1];
			int j = 0;
			for (j = 0; j < current.length() && j < next.length()
					&& current.charAt(j) == next.charAt(j); j++) {
			}

			char c1 = current.charAt(j), c2 = next.charAt(j);
			CNode start = null, end = null;

			if (!nodes.containsKey(c1)) {
				start = new CNode(c1);
				nodes.put(c1, start);
				vertices.add(start);
			}
			if (!nodes.containsKey(c2)) {
				end = new CNode(c2);
				nodes.put(c2, end);
				vertices.add(end);
			}
			start = nodes.get(c1);
			end = nodes.get(c2);
			start.outgoing.add(end);
		}
	}
}
