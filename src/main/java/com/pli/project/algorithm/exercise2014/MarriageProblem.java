package com.pli.project.algorithm.exercise2014;

public class MarriageProblem {
	
	public static void main(String[] args) {
		//��һλi��¼��ǰӦ�ø���iλ���ϵ��˷���proposal
		//���һλΪ0��˵����ǰ��û����ƥ���ϵ��ˣ�Ϊ1��˵���Ѿ�ƥ��
		int[][] manProposerCrush = {
				{1,1,0,2,3,0},
				{1,3,0,1,2,0},
				{1,0,2,1,3,0},
				{1,1,2,0,3,0}
		};
		
		int[][] womanAcceptorCrush = {
				{1,0,2,1,3,0},
				{1,2,3,0,1,0},
				{1,3,1,2,0,0},
				{1,2,1,0,3,0}
		};
		
	}
	
	public static void MarriageMatch(int[][] manProposer, int[][] womanAcceptor){
		int singleMan;
		while((singleMan=getSingle(manProposer))!=-1){
			int crushedWomen = manProposer[singleMan][manProposer.length-1];
			//if(womanAcceptor[crushWomen][])
			
		}
		
		
	}
	
	public static int getSingle(int[][] manProposer){
		for(int i=0;i<manProposer.length-1;i++){
			if((manProposer[i][manProposer.length-2])==0)
				return i;
		}
		return -1;
	}
	
	

}

