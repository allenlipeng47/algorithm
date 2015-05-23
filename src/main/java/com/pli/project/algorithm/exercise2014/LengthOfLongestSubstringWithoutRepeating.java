package com.pli.project.algorithm.exercise2014;/*
 * http://blog.csdn.net/zzran/article/details/9048671
 * 1，维护变量max_len表示满足要求的最大值，cur_len表示当前计算的没有重复字符的子串的长度，pre_index表示当前索引处的字符在之前出现过的位置，-1表示没有出现过。
 * 2，对于每个当前遍历的字符，我们检查它在之前已经处理过的部分，也就是当前字符之前的所有字符中是否包含当前字符，如果没有出现过，那么我们就将cur_len++,以增加当前最长连续而且没有重复字符的子串的长度。
 * 3，如果当前字符（即i索引处）的字符在之前出现过，出现的索引值是pre_index， 那么要做判断，判断pre_index处的字符是否在当前最长连续且没有重复字符串中，如果不在那么就将cur_len++，如果在的话那么就要首先判断max_len 与cur_len之间的关系，然后根据他们的关系来决定是否改变max_len，之后还得处理cur_len的值，因为已经出现了重复字符了，这样cur_len就得改变，改变成当前索引出的字符到pre_index处下一个字符位置差值，这样做，当前满足条件的子串才不会有重复的字符。
 * 下面对上面的算法举个例子，GEEKSFORGEEKS：
 */

/*
 * http://www.geeksforgeeks.org/amazon-interview-experience-set-149-campus-internship/
 * Round3, Q1
 * Given a string, find the longest substring without repeating characters. 
 * For example, the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”.
 */
import java.util.HashMap;

public class LengthOfLongestSubstringWithoutRepeating {
	
	
	public static int findLongestSubstringWithoutRepeating(String s){
		if(s==null){
			return -1;
		}
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int max_start = 0;		//Record the position where the max substring starts
		int max_len = 1;		//Record the length of max substring
		int curr_len = 1;		//Record the length of current substring
		hm.put(s.charAt(0), 0);
		for(int i=1;i<s.length();i++){
			if((hm.get(s.charAt(i))==null)||(i-curr_len>hm.get(s.charAt(i)))){
				//Current char hasn't been read, or position of previous char c is not in the range of current substring
				curr_len++;
				hm.put(s.charAt(i), i);
			}
			else{
				if(curr_len>max_len){	//Find a new max length, update the max_len
					max_len = curr_len;
					max_start = i - curr_len;
				}
				curr_len = i - hm.get(s.charAt(i));	//Calculate the new length of current substring
				hm.put(s.charAt(i), i);
			}
		}
//		System.out.println("max start:" + max_start);
//		System.out.println("max len:" + max_len);
		return max_len;
	}
	
	public static void main(String[] args) {
		//String str = "abcdefeczqposc";
		String str = "GEEKSFORGEEKS";
		int max_len = findLongestSubstringWithoutRepeating(str);
		System.out.println(max_len);
	}

}
