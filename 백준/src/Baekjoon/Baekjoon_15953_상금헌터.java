package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15953_상금헌터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int[] awardA = { 500, 300, 200, 50, 30, 10 };
		int[] arrA = { 1, 2, 3, 4, 5, 6 };
		int[] awardB = { 512, 256, 128, 64, 32 };
		int[] arrB = { 1, 2, 4, 8, 16 };

		int T = Integer.parseInt(token.nextToken());
		for (int t = 0; t < T; t++) {
			int result = 0;
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			if (a == 0 && b == 0) {
				result = 0;
			} else if (a == 0) {
				result = getWon(b, arrB, awardB);
			} else if (b == 0) {
				result = getWon(a, arrA, awardA);
			} else {
				result = getWon(a, arrA, awardA) + getWon(b, arrB, awardB);
			}
			System.out.println(result * 10000);
		}
	}

	public static int getWon(int d, int[] arr, int[] award) {
		int result = 0;
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			temp += arr[i];
			if (temp >= d) {
				result = award[i];
				break;
			}
		}
		return result;
	}
}
