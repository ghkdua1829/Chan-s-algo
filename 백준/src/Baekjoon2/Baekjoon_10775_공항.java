package Baekjoon2;

import java.util.Scanner;

public class Baekjoon_10775_공항 {
	static int[] root;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int G = sc.nextInt();
		int P = sc.nextInt();
		root = new int[G + 1];
		int result = 0;
		for (int i = 1; i <= G; i++) {
			root[i] = i;
		}
		for (int tc = 0; tc < P; tc++) {
			int temp = sc.nextInt();
			int doking = find(temp);
			if (doking != 0) {
				union(doking, doking - 1);
				result++;
			} else {
				break;
			}
		}
		System.out.println(result);

	}

	static int find(int s) {
		if (root[s] == s) {
			return s;
		} else {
			return root[s] = find(root[s]);
		}
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		root[x] = y;
	}
}
