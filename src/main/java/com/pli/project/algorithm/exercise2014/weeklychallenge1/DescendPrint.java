package com.pli.project.algorithm.exercise2014.weeklychallenge1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

/*
 * Given a string, sort its chars by their number of 
 * appearance in descending order. e.g. input: abcbaa, output: aaabbc.
 */
public class DescendPrint {
	
	/*
	 * Step1, put all <char, count> in hashMap. This costs O(n) time, O(n) space
	 * Step2, put all <char, count> to hashTree, as <count, List<char>>. This
	 * costs O(nlogn), O(n) space Step3, print result from hashTree Total time,
	 * O(n + nlogn) = O(nlogn) Total space, O(n + n) = O(n)
	 */
	public static void descendPrint1(String str) {
		if (str == null || str.length() == 0) {
			return;
		}
		// put char count to hashMap
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (!hm.containsKey(str.charAt(i))) {
				hm.put(str.charAt(i), 1);
				continue;
			}
			int count = hm.get(str.charAt(i));
			hm.put(str.charAt(i), ++count);
		}
		// dump <K,V> from hashmap to treeMap, as <V, Set(K)>
		Map<Integer, ArrayList<Character>> tm = new TreeMap<Integer, ArrayList<Character>>(
				Collections.reverseOrder());
		Iterator<Entry<Character, Integer>> itr = hm.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<Character, Integer> hmItem = itr.next();
			char ch = hmItem.getKey();
			int times = hmItem.getValue();
			ArrayList<Character> tmItem = tm.get(times);
			if (tmItem == null) { // a new character
				tmItem = new ArrayList<Character>();
				tmItem.add(ch);
				tm.put(times, tmItem);
				continue;
			}
			tmItem.add(ch);
		}
		// Print result
		Set<Entry<Integer, ArrayList<Character>>> resultSets = tm.entrySet();
		for (Entry<Integer, ArrayList<Character>> set : resultSets) {
			int times = set.getKey();
			for (char ch : set.getValue()) {
				for (int i = 0; i < times; i++) {
					System.out.print(ch);
				}
			}
		}
	}

	/*
	 * Step1, put all <char, count> in hashMap. This costs O(n) time, O(n) space
	 * Step2, initial List. Put Entry<Character, Integer> to this list. Step3,
	 * sort the list according to val. This costs O(nlogn) time, it doesn't
	 * cost extra space. Step3, print result from hashTree Total time, O(n +
	 * nlogn) = O(nlogn) Total space, O(n)
	 */
	public static void descendPrint2(String str) {
		if (str == null || str.length() == 0) {
			return;
		}
		// put char count to hashMap
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (!hm.containsKey(str.charAt(i))) {
				hm.put(str.charAt(i), 1);
				continue;
			}
			int count = hm.get(str.charAt(i));
			hm.put(str.charAt(i), ++count);
		}
		// Sort hashMap according to val.
		Set<Entry<Character, Integer>> set = hm.entrySet();
		ArrayList<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(
				set);
		Collections.sort(list, new DescendComparator());
		// Print result
		for (Entry<Character, Integer> entry : list) {
			char ch = entry.getKey();
			int count = entry.getValue();
			for (int i = 0; i < count; i++) {
				System.out.print(ch);
			}
		}
	}

	public static void main(String[] args) {
		String str = "abcccbbaaa";
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		int i = hm.get('a');
		System.out.println(i);
		descendPrint2(str);
	}
}

class DescendComparator implements Comparator<Entry<Character, Integer>> {
	public int compare(Entry<Character, Integer> entry1,
			Entry<Character, Integer> entry2) {
		int count1 = entry1.getValue();
		int count2 = entry2.getValue();
		return count2 - count1;
	}
}