package Baekjoon;

import java.util.Scanner;

public class Baekjoon_5585_거스름돈 {
	private static int[] coins = { 500, 100, 50, 10, 5, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = 1000 - sc.nextInt();
		int count = 0;
		for (int i = 0; i < coins.length; i++) {
			while (target >= coins[i]) {
				target -= coins[i];
				count++;
			}
		}
		System.out.println(count);

	}
}
