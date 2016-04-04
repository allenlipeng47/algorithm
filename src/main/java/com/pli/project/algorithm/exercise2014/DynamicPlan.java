package com.pli.project.algorithm.exercise2014;

public class DynamicPlan {
	
	//0-1背包问
	public static void main(String[] args) {
		int[] weight={2,3,5,7,3,2,2,3,5};
		int[] value={2,3,4,5,6,8,3,2,3};
		pack(weight, value, 10);
	}
	
	public static void pack(int[] weight, int[] value, int packWeight){
		int m[][] = new int[value.length][packWeight];
		String[][] result = new String[value.length][packWeight];
		for(int i=0;i<value.length;i++)
			for(int j=0;j<packWeight;j++)
				result[i][j] = "";
		//初值，第一行
		for(int i=0;i<packWeight;i++){
			if(weight[0]<=i){
				m[0][i] = value[0];
				result[0][i] = String.valueOf(0);
			}
		}
		for(int i=1;i<value.length;i++){
			//外层循环i值
			for(int j=0;j<packWeight;j++){
				//做第i个元素与背包值j的比较
				//1. 当wi大于背包值时，m[i][j]=m[i-1][j];
				if(weight[i]>j){
					m[i][j]=m[i-1][j];
					continue;
				}
				//2. 当wi小于等背包值时，用wi的重量去装物品i，尝试用j-wi的重最去装物品1到物品i个元素。
				//并将它们的总价值相加，与m[i-1][j]不装时作比较，看哪个大
				if(weight[i]<=j){
					int tmpValue = m[i-1][j-weight[i]]+value[i];
					if(tmpValue>m[i-1][j]){
						m[i][j] = tmpValue;
						result[i][j] = String.valueOf(i) + " " + result[i-1][j-weight[i]];
					}
					else{
						m[i][j] = m[i-1][j];
						result[i][j] = result[i-1][j];
					}
					continue;
				}
			}//for
		}//for
	/*------------------------------result pring-------------------------------*/
		System.out.print("val:\t");
		print(value);
		System.out.print("weight:\t");
		print(weight);
		System.out.println();
		print(m);
		print(result[value.length-1]);
	}
	
	public static void print(int a[][]){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void print(int a[]){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}
	
	public static void print(String a[]){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}

}
