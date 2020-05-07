package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_3085_사탕게임 {
	static int size, result = Integer.MIN_VALUE;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine(), " ");

		size = Integer.parseInt(tokens.nextToken());
		arr = new char[size][size];
		for (int r = 0; r < size; r++) {
			tokens = new StringTokenizer(in.readLine(), "");
			String str = tokens.nextToken();
			for (int c = 0; c < size; c++) {
				arr[r][c] = str.charAt(c);
			}
		}

		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size - 1; c++) {
				swap(r, c, r, c + 1);
				int a = findCandy(arr);
				if (a > result) {
					result = a;
				}
				swap(r, c, r, c + 1);
			}
		}

		for (int c = 0; c < size; c++) {
			for (int r = 0; r < size - 1; r++) {
				swap(r, c, r + 1, c);
				int a = findCandy(arr);
				if (a > result) {
					result = a;
				}
				swap(r, c, r + 1, c);
			}
		}
		System.out.println(result);
	}

	public static boolean isIn(int r, int c) {
		return r < size && c < size && r >= 0 && c >= 0;
	}

	public static void swap(int r1, int c1, int r2, int c2) {
		char temp = arr[r1][c1];
		arr[r1][c1] = arr[r2][c2];
		arr[r2][c2] = temp;

	}
	
	
	public static int findCandy(char[][] candy) {
		int max = Integer.MIN_VALUE;
		for (int r = 0; r < candy.length; r++) {
			char before = candy[r][0];
			int temp = 1;
			for (int c = 1; c < candy.length; c++) {
				if (before == candy[r][c]) {
					temp++;
					if (temp > max) {
						max = temp;
					}
				} else {
					temp = 1;
					before = candy[r][c];
				}
			}
			if (temp > max) {
				max = temp;
			}
			
		}

		for (int c = 0; c < candy.length; c++) {
			char before = candy[0][c];
			int temp = 1;
			for (int r = 1; r < candy.length; r++) {
				if (before == candy[r][c]) {
					temp++;
					if (temp > max) {
						max = temp;
					}
				} else {
					temp = 1;
					before = candy[r][c];
				}
			}
			if (temp > max) {
				max = temp;
			}
		}
		return max;
	}
}
