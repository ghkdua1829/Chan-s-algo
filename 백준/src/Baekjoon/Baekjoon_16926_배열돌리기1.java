package Baekjoon;

import java.util.Scanner;

public class Baekjoon_16926_배열돌리기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sizeR = sc.nextInt();
		int sizeC = sc.nextInt();
		int spinNum = sc.nextInt();
		int[][] arr = new int[sizeR + 1][sizeC + 1];
		for (int r = 1; r <= sizeR; r++) {
			for (int c = 1; c <= sizeC; c++) {
				arr[r][c] = sc.nextInt();
				System.out.print(arr[r][c]);
			}
			System.out.println();
		}
		int[][] result = new int[sizeR + 1][sizeC + 1];
		for (int r = 1; r <= sizeR; r++) {
			for (int c = 1; c <= sizeC; c++) {
				
			}
		}

	}

}
