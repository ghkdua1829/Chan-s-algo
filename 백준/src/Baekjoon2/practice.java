package Baekjoon2;

import java.util.Arrays;

public class practice {
	static char[] arr = { '+', '-' };

	public static void main(String[] args) {
		makePermutation(2, new char[5], 0, new boolean[5]);
	}

	private static void makeCombination(int r, int[] temp, int current, int start) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {	
			for (int i = start; i < arr.length; i++) {
				temp[current] = arr[i];
				makeCombination(r, temp, current + 1, i + 1);
			}
		}
	}
	
	private static void makePermutation(int r, char[] temp, int current, boolean[] visited) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			for (int i = 0; i < 2; i++) {
				if (!visited[i]) {
					visited[i] = true;
					makePermutation(r, temp, current +1, visited);
					visited[i] = false;
				}
			}
		}
	}
}
