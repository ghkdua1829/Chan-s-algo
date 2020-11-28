package nhnGodo;

import java.util.*;

public class Problem3 {
	static int[] arr;
	static int minMinus = 654321;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("aaaaabbc", 1));
	}

	static public int solution(String s, int n) {
		int[] alpha = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 'a';
			alpha[c]++;
		}
		int size = 0;
		for (int i : alpha) {
			if (i != 0) {
				size++;
			}
		}
		arr = new int[size];
		int index = 0;
		for (int i : alpha) {
			if (i != 0) {
				arr[index++] = i;
			}
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int max = arr[arr.length - 1];
		int min = arr[0];
		int firstMin = 0;
		if (max - min > n) {
			firstMin = max - min - n;
		} else {
			return 0;
		}
		int tempIdx = 0;
		int secondMin = 654321;
		for (int i = 0; i < n; i++) {
			secondMin = Math.min((max-(n-i)) - arr[tempIdx], firstMin);
			arr[tempIdx]--;
//			secondMin = Math.min(max - arr[tempIdx], secondMin);

			if (arr[tempIdx] == 0) {
				if (i == n - 1) {
					secondMin = Math.min((max-(n-i)) - arr[tempIdx+1], firstMin);
				}
				tempIdx++;
				if (tempIdx == arr.length - 1) {
					break;
				}
			}
		}
		int result = Math.min(firstMin, secondMin);
		return result;

	}

}
