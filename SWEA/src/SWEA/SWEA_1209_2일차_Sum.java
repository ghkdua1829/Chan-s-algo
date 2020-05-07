package SWEA;

import java.util.Scanner;

public class SWEA_1209_2일차_Sum {
	static int[][] arr = new int[100][100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt(); // 번호 버림
			arr = new int[100][100];
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			int max = Integer.MIN_VALUE;
			int sum = 0;
			// 가로 더하기 구하기
			for (int r = 0; r < 100; r++) {
				sum = 0;
				for (int c = 0; c < 100; c++) {
					sum += arr[r][c];
				}
				if (sum > max) {
					max = sum;
				}
			}
			int sum1 = 0;
			int sum2 = 0;
			// 세로 더하기 구하기
			for (int c = 0; c < 100; c++) {
				sum = 0;
				for (int r = 0; r < 100; r++) {
					sum += arr[r][c];
					if (r == c) {
						sum1 += arr[r][c];
					}
					if (r + c == 99) {
						sum2 += arr[r][c];
					}
				}
				if (sum > max) {
					max = sum;
				}
			}

			sum = (int) Math.max(sum1, sum2);
			if (sum > max) {
				max = sum;
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}
