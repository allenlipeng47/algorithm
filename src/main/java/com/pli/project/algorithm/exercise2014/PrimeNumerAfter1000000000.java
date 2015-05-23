package com.pli.project.algorithm.exercise2014;

/*
 * Problem: Write a method to return first five 10 digit prime numbers.
 * Solution: Primes after a point in the series are multiples of 6 +/-1. that is 31 = 30 + 1, 37 = 36 + 1 and so on.
 * http://www.careercup.com/question?id=5763123118080000 
 * 
 * n=6r+q,
 * q could be 0 1 2 3 4 5, if q is 0 2 4, it can't be prime number.
 * if q is 3, because of 6r, n can be divided by 3.
 * so, the prime number happens when q is 1 or 5. 
 */
public class PrimeNumerAfter1000000000 {
	
	public static void main(String[] args) {
		find();
	}
	
	public static void find(){
		long num = 1000000000;
		int n=5;
		int alreadyFound = 0;
		for(;num%6!=0;num++);
		
			
		while(true){
			num+=6;
			long checkNum = num-1;
			long threshold = (long)Math.sqrt((double)checkNum);
			boolean found = true;
			for(int j=2;j<threshold;j++){
				if(checkNum%j==0){
					found = false;
					break;
				}
			}
			if(found){
				System.out.println(checkNum);
				alreadyFound++;
				if(alreadyFound>=n){
					break;
				}
			}
			//check the 2nd one
			checkNum = num+1;
			threshold = (long)Math.sqrt((double)checkNum);
			found = true;
			for(int j=2;j<threshold;j++){
				if(checkNum%j==0){
					found = false;
					break;
				}
			}
			if(found){
				System.out.println(checkNum);
				alreadyFound++;
				if(alreadyFound>=n){
					break;
				}
			}
		}
	}
	
}
