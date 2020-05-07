package Baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_17135_캐슬디펜스 {
	static int[][] arr;
	static int[] searchR = { 1, 0, 0 };
	static int[] searchC = { 0, -1, 1 };
	static int R, C, attackLimit;
	static int catchEnemyNum = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		attackLimit = sc.nextInt();
		arr = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		makeCombination(3, new int[3], 0, 0);
	}

	public static void makeCombination(int r, int[] temp, int current, int start) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			for (int i = start; i < arr[0].length; i++) {
				temp[current] = i + 1;
				makeCombination(r, temp, current + 1, i + 1);
			}
		}
	}

	public static void bfsQueue(List<Point> Archer) {
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < Archer.size(); i++) {
			queue.offer(Archer.get(i));
		}
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			for (int i = 0; i < attackLimit; i++) {
				for (int s = 0; s < searchC.length; s++) {
					int nr = top.r + searchR[s];
					int nc = top.c + searchC[s];
					if (isIn(nr, nc) && arr[nr][nc] == 1) {
						queue.add(new Point(nr, nc));
						catchEnemyNum++;
						break;
					}
				}
			}
		}

	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
}
