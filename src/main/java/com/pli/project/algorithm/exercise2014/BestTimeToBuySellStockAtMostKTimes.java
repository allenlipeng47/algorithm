package com.pli.project.algorithm.exercise2014;


public class BestTimeToBuySellStockAtMostKTimes {
	
	public static void main(String[] args) {
		int[] prices = {4,6,3,7,4,9,3,2,5,7};
		System.out.println(bestTimeToBuySellStockAtMostKTimes(prices, 3));
	}
	
	
	public static int bestTimeToBuySellStockAtMostKTimes(int[] prices, int k){
		if(prices==null || prices.length==0)  
	        return 0;  
	    int[] local = new int[prices.length];  
	    int[] global = new int[prices.length];  
	    for(int i=0;i<prices.length-1;i++)  
	    {  
	    	int diff = prices[i+1]-prices[i];  
	        for(int j=k;j>=1;j--)  
	        {  
	            local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);  
	            global[j] = Math.max(local[j],global[j]);  
	        }  
	    }
	    return global[k];
	}
	
	public static void print(int[][] array){
		for(int j=0;j<array[0].length;j++){
			for(int i=0;i<array.length;i++){
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}
	}

}







