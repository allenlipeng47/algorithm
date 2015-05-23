package com.pli.project.algorithm.exercise2014;

import java.util.Arrays;


/*
There are at most eight servers in a data center. 
Each server has got a capacity/memory limit. There 
can be at most 8 tasks that need to be scheduled 
on those servers. Each task requires certain 
capacity/memory to run, and each server can handle 
multiple tasks as long as the capacity limit is not 
hit. Write a program to see if all of the given tasks 
can be scheduled or not on the servers? 
Ex: 
Servers capacity limits: 8, 16, 8, 32 
Tasks capacity needs: 18, 4, 8, 4, 6, 6, 8, 8 
For this example, the program should say 'true'. 

Ex2: 
Server capacity limits: 1, 3 
Task capacity needs: 4 
For this example, program should return false. 
 */
public class ServerCapacityBalancer {
	
	public static void main(String[] args) {
		int[] server = {8,16,8,32};
		int[] task = {18,8,8,8,6,6,4,4};
		int[] result = balanceServer(server, task);
		System.out.println(Arrays.toString(result));
		
	}
	
	
	public static int[] balanceServer(int[] server, int[] task){
		if(server==null||task==null){
			return null;
		}
		int[] result = new int[task.length];
		for(int i=0;i<result.length;i++){
			result[i] = -1;
		}
		balanceServerUtil(server, task, 0, result);
		return result;
	}
	
	//put task[n] in the server, and save the result
	public static boolean balanceServerUtil(int[] server, int[] task, int n, int[] result){
		if(n>=task.length){
			return true;
		}
		for(int i=0;i<server.length;i++){
			if(server[i]>=task[n]){
				server[i] -= task[n];
				result[n] = i;
				if(balanceServerUtil(server, task, n+1, result)){
					return true;
				}
				server[i] += task[n];
				result[n] = -1;
			}
		}
		return false;
	}

}
