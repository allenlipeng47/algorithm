package com.pli.project.algorithm.exercise2014;/*
 * http://blog.csdn.net/zzran/article/details/9048671
 * 1��ά������max_len��ʾ����Ҫ������ֵ��cur_len��ʾ��ǰ�����û���ظ��ַ����Ӵ��ĳ��ȣ�pre_index��ʾ��ǰ���������ַ���֮ǰ���ֹ���λ�ã�-1��ʾû�г��ֹ���
 * 2������ÿ����ǰ�������ַ������Ǽ������֮ǰ�Ѿ�������Ĳ��֣�Ҳ���ǵ�ǰ�ַ�֮ǰ�������ַ����Ƿ������ǰ�ַ������û�г��ֹ�����ô���Ǿͽ�cur_len++,�����ӵ�ǰ���������û���ظ��ַ����Ӵ��ĳ��ȡ�
 * 3�������ǰ�ַ�����i�����������ַ���֮ǰ���ֹ������ֵ�����ֵ��pre_index�� ��ôҪ���жϣ��ж�pre_index�����ַ��Ƿ��ڵ�ǰ�������û���ظ��ַ����У����������ô�ͽ�cur_len++������ڵĻ���ô��Ҫ�����ж�max_len ��cur_len֮��Ĺ�ϵ��Ȼ��������ǵĹ�ϵ�������Ƿ�ı�max_len��֮�󻹵ô���cur_len��ֵ����Ϊ�Ѿ��������ظ��ַ��ˣ�����cur_len�͵øı䣬�ı�ɵ�ǰ���������ַ���pre_index����һ���ַ�λ�ò�ֵ������������ǰ�����������Ӵ��Ų������ظ����ַ���
 * �����������㷨�ٸ����ӣ�GEEKSFORGEEKS��
 */

/*
 * http://www.geeksforgeeks.org/amazon-interview-experience-set-149-campus-internship/
 * Round3, Q1
 * Given a string, find the longest substring without repeating characters. 
 * For example, the longest substrings without repeating characters for ��ABDEFGABEF�� are ��BDEFGA�� and ��DEFGAB��.
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
