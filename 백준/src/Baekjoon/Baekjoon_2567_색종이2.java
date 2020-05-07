package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2567_색종이2 {
	static int[] searchR = { 0, -1, 1, 0 };
	static int[] searchC = { -1, 0, 0, 1 };
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[][] arr = new int[101][101];
		for (int i = 0; i < count; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int r = y; r < y + 10; r++) {
				for (int c = x; c < x + 10; c++) {
					arr[r][c] = 1;
				}
			}
		}
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if (arr[r][c] == 1) {
					for(int s=0;s<searchR.length;s++) {
						if(arr[r+searchR[s]][c+searchC[s]]==0) {
							result++;
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}
