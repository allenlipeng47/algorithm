package com.pli.project.algorithm.exercise2014.weeklychallenge1;

/*
 * Given a string, sort its chars by their number of 
 * appearance in descending order. e.g. input: abcbaa, output: aaabbc.
 */
public class DescendPrint2 {

	/*
	 * Median of median quicksort on charCount[]
	 */
	public static void quickSortCharCount(CharCount[] charCount, int lo, int hi) {
		int i = lo;
		int j = hi;
		int pivot = findKthCharCount(charCount, lo, hi, (hi - lo + 2) >> 1);
		while (i <= j) {
			while (charCount[i].count > charCount[pivot].count) {
				i++;
			}
			while (charCount[j].count < charCount[pivot].count) {
				j--;
			}
			if (i <= j) {
				CharCount tmp = charCount[i];
				charCount[i] = charCount[j];
				charCount[j] = tmp;
				i++;
				j--;
			}
		}
		if (lo < j)
			quickSortCharCount(charCount, lo, j);
		if (i < hi)
			quickSortCharCount(charCount, i, hi);
	}

	/*
	 * Find the kth element in charCount[start,...,end]
	 */
	public static int findKthCharCount(CharCount[] charCount, int start,
			int end, int k) {
		CharCount tmp = null;
		if (end - start < 5) {
			// Bubble sort arr[start,...,end] for k times, the arr[start] is the
			// median
			for (int count = 0; count < k; count++, start++) {
				for (int j = end; j > start; j--) {
					if (charCount[j - 1].count > charCount[j].count) {
						tmp = charCount[j - 1];
						charCount[j - 1] = charCount[j];
						charCount[j] = tmp;
					}
				}
			}
			start--;
			return start;
		}
		int groupSize = (end - start + 1) / 5;
		int subStart = 0, subEnd = 0;
		for (int i = 0; i < groupSize; i++) {
			subStart = start + i * 5;
			subEnd = start + i * 5 + 4;
			subEnd = (subEnd > end) ? end : subEnd;
			int groupMedian = findKthCharCount(charCount, subStart, subEnd,
					(subEnd - subStart + 2) >> 1);
			tmp = charCount[start + i];
			charCount[start + i] = charCount[groupMedian];
			charCount[groupMedian] = tmp;
		}
		return findKthCharCount(charCount, start, start + groupSize - 1,
				(groupSize + 1) >> 1);
	}

	public static void descendPrint3(char[] chs) {
		final int MAX_CHAR_SIZE = 65535;
		// Calculate count of each char
		CharCount[] charCount = new CharCount[MAX_CHAR_SIZE];
		for (int i = 0; i < MAX_CHAR_SIZE; i++) {
			charCount[i] = new CharCount((char) i, 0);
		}
		for (int i = 0; i < chs.length; i++) {
			charCount[chs[i]].count++;
		}
		// It is believed that there are many 0 count in charCount[].
		// Move the char with 0 count to the right side.
		int start = 0, end = MAX_CHAR_SIZE - 1;
		while (start < end) {
			while (charCount[start].count != 0 && start < end) {
				start++;
			}
			while (charCount[end].count == 0 && start < end) {
				charCount[end] = null;
				end--;
			}
			if (start < end) {
				charCount[start] = charCount[end];
				charCount[end] = null;
				start++;
				end--;
			}
		}
		// Do median-of-median quicksort to charCount[0,...,start-1]
		quickSortCharCount(charCount, 0, start - 1);
		for (int i = 0; i < start; i++) {
			for (int j = 0; j < charCount[i].count; j++) {
				System.out.print(charCount[i].ch);
			}
		}
	}

	public static void main(String[] args) {
		String str = "abcccbbaaa";
		char[] chs = str.toCharArray();
		descendPrint3(chs);
		System.out.println();
		System.out.println(Integer.MAX_VALUE);
	}
}

class CharCount {
	char ch;
	int count;

	public CharCount(char ch, int count) {
		this.ch = ch;
		this.count = count;
	}
}