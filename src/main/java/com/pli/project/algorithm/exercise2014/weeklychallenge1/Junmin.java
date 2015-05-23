package com.pli.project.algorithm.exercise2014.weeklychallenge1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Junmin {
	// ASCII table size is 256
	private final static int SIZE = 256;

	// time O(input.length() + SIZE)
	// space O(SIZE)
	public static void sort(String input) {
		int[] freq = new int[SIZE];
		for (int i = 0; i < input.length(); i++)
			freq[input.charAt(i)]++;

		Set<Entry> sorted = new TreeSet<Entry>();
		for (int i = 0; i < SIZE; i++) {
			if (freq[i] > 0)
				sorted.add(new Entry((char) i, freq[i]));
		}

		for (Entry e : sorted) {
			int counter = e.counter;
			while (counter-- > 0)
				System.out.print(e.c);
		}
	}

	// space O(unique characters in input)
	// time: O(length of input)
	public void sort2(String input) {
		Map<Character, Integer> store = new HashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (store.containsKey(c)) {
				store.put(c, store.get(c) + 1);
			} else
				store.put(c, 1);
		}
		Set<Entry> sorted = new TreeSet<Entry>();
		for (Character k : store.keySet()) {
			sorted.add(new Entry(k, store.get(k)));
		}

		for (Entry e : sorted) {
			int counter = e.counter;
			while (counter-- > 0)
				System.out.print(e.c);
		}
	}

	static class Entry implements Comparable<Entry> {
		char c;
		int counter;

		Entry(char f, int h) {
			this.c = f;
			this.counter = h;
		}

		public int compareTo(Entry o) {
			if (o.counter - this.counter == 0)
				return this.c - o.c;
			return o.counter - this.counter;
		}
	}

	// time O(SIZE + input.length())
	// space O(SIZE)

	public char most(String input) {
		int[] freq = new int[SIZE];
		int mostIndex = -1;
		int max = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			freq[c]++;
			if (freq[c] > max) {
				max = freq[c];
				mostIndex = c;
			}
		}
		return (char) mostIndex;
	}

	// space O(unique characters in input)
	// time: O(length of input)
	public char most2(String input) {
		Map<Character, Integer> store = new HashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (store.containsKey(c)) {
				store.put(c, store.get(c) + 1);
			} else
				store.put(c, 1);
		}
		int max = 0;
		char most = '0';
		for (Character c : store.keySet()) {
			if (store.get(c) > max) {
				max = store.get(c);
				most = c;
			}
		}
		return most;
	}

	public static void main(String[] args) {

	}
}
