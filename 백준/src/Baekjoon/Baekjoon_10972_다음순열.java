package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_10972_다음순열 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine());
		int num = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(in.readLine(), " ");
		arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		nextPermutation();
	}

	public static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void nextPermutation() {
		int i;
		for (i = arr.length - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				break;
			}
		}
		if(i<0) {
			System.out.println(-1);
			return;
		}
		int j;
		for (j = arr.length - 1; j >= i; j--) {
			if (arr[j] > arr[i]) {
				break;
			}
		}
		swap(i, j);
		for (int a = i + 1, b = arr.length-1; a < b; a++, b--) {
			swap(a,b);
		}
		for(int s : arr) {
			System.out.print(s+" ");
		}
	}
}
