package com.pli.project.algorithm.exercise2014;

import java.util.HashMap;

public class DivisionWithCycleRemainder {
	
	
	public static void main(String[] args){
		String result = divisionToString(45,17);
		System.out.println(result);
	}
	
	public static String divisionToString(int num1, int num2) {
		int beforeD = num1 / num2;	//the result before dot
		int afterD = num1 % num2;	//the result after dot
		if(afterD==0){
			return String.valueOf(beforeD);
		}
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		StringBuffer result = new StringBuffer(beforeD + ".");
		int remainder = afterD * 10;
		while(!hm.containsKey(remainder)){
			hm.put(remainder, result.length());	//remainder never exist, insert into hm
			int curr_value = remainder / num2;	//result of current position
			result.append(curr_value);
			remainder = (remainder % num2) * 10;
		}
		result.insert(hm.get(remainder).intValue(), '(');
		result.append(')');
		return result.toString();
	}
}