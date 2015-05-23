package com.pli.project.algorithm.exercise2014;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class TopogicalSorintDFS {

	public static void main(String[] args) {
		Vector<String> airports = new Vector<String>();
		airports.add("JFK");
		airports.add("LAX");
		airports.add("SNA");
		airports.add("RKJ");
		airports.add("LAX");
		airports.add("SNA");
		Vector<String> result = findPath(airports);
		System.out.println(result.toString());
	}

	public static Vector<String> findPath(Vector<String> airports) {
		Map<String, AirNode> nodes = new HashMap<String, AirNode>();
		// construct graph
		for (int i = 0; i < airports.size(); i += 2) {
			String from = airports.get(i);
			String to = airports.get(i + 1);
			if (!nodes.containsKey(from)) {
				nodes.put(from, new AirNode(from));
			}
			if (!nodes.containsKey(to)) {
				nodes.put(to, new AirNode(to));
			}
			nodes.get(from).outgoing.add(nodes.get(to));
		}
		Vector<String> result = new Vector<String>();
		HashSet<String> visited = new HashSet<String>();
		//start the dfs on graph
		for (AirNode node : nodes.values()) {
			dfs(node, visited, result);
		}
		return result;
	}

	public static void dfs(AirNode node, HashSet<String> visited,
			Vector<String> result) {
		if (visited.contains(node.airport)) {
			return;
		}
		visited.add(node.airport);
		for (AirNode curr : node.outgoing) {
			dfs(curr, visited, result);
		}
		result.insertElementAt(node.airport, 0);
	}
}

class AirNode {
	String airport;
	Set<AirNode> outgoing;

	public AirNode(String airport) {
		this.airport = airport;
		outgoing = new HashSet<AirNode>();
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj instanceof AirNode) {
			AirNode node = (AirNode) obj;
			return this.airport.equals(node.airport);
		}
		return false;
	}

	public int hashCode() {
		return this.airport.hashCode();
	}
}
