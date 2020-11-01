package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjon_1932_정수삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < str.length; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		int max = Integer.MIN_VALUE;

		for (int r = 1; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				if (c == 0) {
					arr[r][c] += arr[r - 1][c];
				} else if (c == r) {
					arr[r][c] += arr[r - 1][c - 1];
				} else {
					arr[r][c] += Math.max(arr[r - 1][c - 1], arr[r - 1][c]);
				}
				max = Math.max(arr[r][c], max);
			}

		}
		System.out.println(max);
	}

}
