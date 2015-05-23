package com.pli.project.algorithm.exercise2014;

/*
 * �ö�����ǰk�����ֵ
 */
public class TopK {
	
	public static void main(String[] args) {
		int[] array = {5, 13,10,12,15,11, 8,23, 40, 16, 83, 23, 31, 73, 59, 25, 75};
		findTopK(array, 5);
	}
	
	public static void findTopK(int[] array, int k){
		int[] heap = new int[k+1];
		heap[0] = k;
		for(int i=0;i<array.length;i++){
			heapPut(heap, array[i]);
		}
		printArray(heap);
	}
	
	/*
	 * С���ѣ���value����heap�ĵ�pos��λ����
	 */
	public static void heapPut(int[] heap, int value){
		if(heap==null){
			return;
		}
		if(value>heap[1]){
			heap[1] = value;
			heapAdjust(heap, 1);
		}
	}
	
	//������iλ��
	public static void heapAdjust(int[] heap, int pos){
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
	public static void arrayExchange(int[] array, int pos1, int pos2){
		if(array==null||pos1>array.length-1||pos2>array.length-1){
			return;
		}
		int tmp = array[pos1];	array[pos1] = array[pos2]; array[pos2] = tmp;
		return;
	}
	
	public static void printArray(int[] array){
		if(array==null){
			return;
		}
		for(int i=1;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

}
