package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_6603_로또 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(token.nextToken());
			if (n == 0) {
				break;
			}
			arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(token.nextToken());
			}
			makeCombination(6, new int[6], 0, 0);
			System.out.println();
		}

	}

	static void makeCombination(int r, int[] temp, int current, int start) {
		if (r == current) {
			StringBuilder sb = new StringBuilder();
			for (int i : temp) {
				sb.append(i + " ");
			}
			System.out.println(sb.toString());
		} else {
			for (int i = start; i < arr.length; i++) {
				temp[current] = arr[i];
				makeCombination(r, temp, current + 1, i + 1);
			}
		}
	}

}
