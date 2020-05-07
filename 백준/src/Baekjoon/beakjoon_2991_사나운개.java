package Baekjoon;

import java.util.Scanner;

public class beakjoon_2991_사나운개 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int[] result = new int[1000];
		for (int i = 1; i < 1000; i++) {
			int dog = 0;
			if (i % (A + B) <= A && i % (A + B) != 0) {
				dog++;
			}
			if (i % (C + D) <= C && i % (C + D) != 0) {
				dog++;
			}
			result[i] = dog;
		}
		int u = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(result[u]);
		System.out.println(result[m]);
		System.out.println(result[n]);
	}

}
