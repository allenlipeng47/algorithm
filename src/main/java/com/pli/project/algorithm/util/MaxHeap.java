package com.pli.project.algorithm.util;

import java.util.Arrays;

public class MaxHeap {
	
	int[] heap = new int[1];
	
	public MaxHeap(){
		heap[0] = 0;
	}
	
	public void insert(int value){
		heap = Arrays.copyOf(heap, heap.length+1);
		heap[heap.length-1] = value;
		heap[0]++;
		for(int i=heap[0]/2;i>=1;i--){
			
		}
	}
	
	//������iλ��
	public void heapAdjust(int[] heap, int pos){
		if(heap==null||pos*2>heap[0]){	//��Ϊ�գ������λ�ò���ȷ
			return;
		}
		if(heap[pos]<=heap[pos*2]&&(heap[0]==pos*2||heap[pos]<=heap[pos*2+1])){	//��ǰpos������Сֵ������Ҫ����
			return;
		}
		int minPos = (heap[0]==pos*2)?pos*2:heap[pos*2]<heap[pos*2+1]?pos*2:pos*2+1;	//posλ�õ�ֵ������С����Ҫ����
		arrayExchange(heap, pos, minPos);
		heapAdjust(heap, minPos);
	}
	
	//��array�����У�����pos1, pos2��ֵ
	public void arrayExchange(int[] array, int pos1, int pos2){
		if(array==null||pos1>array.length-1||pos2>array.length-1){
			return;
		}
		int tmp = array[pos1];	array[pos1] = array[pos2]; array[pos2] = tmp;
		return;
	}
	
	public void printArray(int[] array){
		if(array==null){
			return;
		}
		for(int i=1;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	

}
