package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1182_부분수열의합 {
	static int[] arr;
	static int S, answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		S = Integer.parseInt(token.nextToken());
		arr = new int[N];
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			makeCombination(i, 0, new int[i], 0);
		}
		System.out.println(answer);
	}

	static void makeCombination(int r, int current, int[] temp, int start) {
		if (r == current) {
//			System.out.println(Arrays.toString(temp));
			int sum = 0;
			for (int i = 0; i < temp.length; i++) {
				sum += temp[i];
			}
			if (sum == S) {
				answer++;
			}
		} else {
			for (int i = start; i < arr.length; i++) {
				temp[current] = arr[i];
				makeCombination(r, current + 1, temp, i + 1);
			}
		}
	}

}
