package com.pli.project.algorithm.exercise2014.weeklychallenge1;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string, find the char which repeats most.
 */
public class MostRepeatedChar {
	
	/*
	 * Use a static 65535 to store the appeared times of each char.
	 * Iterate chs[] one time. Use extra int[65535] space for record char times.
	 * Time complexity O(n), space complexity O(1)
	 */
	public static char findMostRepeatedChar1(String str){
		if(str==null||str.length()==0){
			throw new RuntimeException("invalid input");
		}
		int[] rec = new int[65535];
		int bigPos = 0;
		for(int i=0;i<str.length();i++){
			rec[str.charAt(i)]++;
			bigPos = rec[str.charAt(i)]>rec[bigPos]?str.charAt(i):bigPos;
		}
		return (char)bigPos;
	}
	
	/*
	 * Use hashmap.
	 * Time complexity O(n), space complexity O(1)
	 */
	public static char findMostRepeatedChar2(String str){
		if(str==null||str.length()==0){
			throw new RuntimeException("invalid input");
		}
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		char result = str.charAt(0);
		for(int i=0;i<str.length();i++){
			if(!hm.containsKey(str.charAt(i))){
				hm.put(str.charAt(i), 1);
				continue;
			}
			int currTimes = hm.get(str.charAt(i));
			result = (++currTimes>hm.get(result))?str.charAt(i):result;
			hm.put(str.charAt(i), ++currTimes);
		}
		return result;
	}
	
	/*
	 * If the most repeated char appears more than half times in char[]
	 * Iterate chs 1 time. Use 2 extra integers.
	 * Time complexity O(n), space complexity O(1)
	 */
	public static char findMostRepeatedChar3(String str){
		if(str==null||str.length()==0){
			throw new RuntimeException("invalid input");
		}
		char result = str.charAt(0);
		int times = 1;
		for(int i = 1; i<str.length(); i++){
			if(str.charAt(i)==result){
				times++;
				continue;
			}
			times--;
			if(times<0){
				times = 1;
				result = str.charAt(i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String str = "12abaa11a";
		char result = findMostRepeatedChar3(str);
		System.out.println(result);
	}

}
