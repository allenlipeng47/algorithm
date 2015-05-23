package com.pli.project.algorithm.exercise2014;

/*
 * Suppose the pots are arranged in L[0] to L[n].
 * First player can pick either L[0] or L[n]. If
 * he picks L[0] Second player can pick either
 * L[1] or L[n]. If first picks L[n], second
 * player can pick L[0] or L[n-1]. As the second
 * player is also playing optimally he will also
 * use the same strategy as the first player. Let
 * us assume f(i,j) is the number of coins a
 * player would get if he plays optimally from a
 * point when two ends are i and j (0<=i<=j<=n).
 * So f(0,n) would be the number of coins that
 * first player would get after playing optimally.
 * As second player is also playing optimally, he
 * will pick a pot such that after his picking first
 * player will get fewer gold if played optimally.
 * If second player takes pot number 1, player 1
 * will get f(2,n). If second player takes pot
 * number n, first player will get f(1,n-1). Second
 * player will play such that 1st player gets minimum
 * of these two options. So if first player takes pot
 * 0 his final count of gold will be L[0]+Min(f(2,n),f(1,n-1)).
 * Similarly if he picks the last pot this total count
 * will be L[n]+Min(f(0,n-2),f(1,n-1)). From these two
 * items whichever is greater First player should pick
 * that, and that should be his winning strategy as playing first.
 */
public class GetMaxGold {
	
	public static void main(String[] args) {
		int[] gold = {1,2,3,1};
		int[][] memo = new int[gold.length][gold.length];
		printArray(gold, 0, gold.length-1);
		System.out.println(getMaxGold(gold, 0, gold.length-1, memo));
	}

	
	public static int getMaxGold(int[] gold, int start, int end, int[][] memo){
		if(start>end){
			return 0;
		}
		if(memo[start][end]!=0){
			return memo[start][end];
		}
		int maxLeft = gold[start] + Math.min(getMaxGold(gold, start+1, end-1, memo), getMaxGold(gold, start+2, end, memo));
		int maxRight = gold[end] + Math.min(getMaxGold(gold, start, end-2, memo), getMaxGold(gold, start+1, end-1, memo));
		memo[start][end] = Math.max(maxLeft, maxRight);
//		printArray(gold, start, end);
		System.out.println("start:" + start + " end:" + end + " choose:" + String.valueOf((maxLeft>maxRight)?start:end));
		System.out.println();
		return memo[start][end];
	}
	
	public static void printArray(int[] array, int start, int end){
		for(int i=start;i<=end;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println();
	}
}
