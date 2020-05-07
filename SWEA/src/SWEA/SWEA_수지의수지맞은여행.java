package SWEA;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_수지의수지맞은여행 {
	static int R, C, MAX;
	static boolean[] visited;
	static int[] searchR = { 1, -1, 0, 0 };
	static int[] searchC = { 0, 0, 1, -1 };
	static char[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int TC = 1; TC <= tc; TC++) {
			R = sc.nextInt();
			C = sc.nextInt();
			arr = new char[R][C];
			for (int r = 0; r < R; r++) {
				String str = sc.next();
				for (int c = 0; c < C; c++) {
					arr[r][c] = str.charAt(c);
				}
			}
			MAX = 1;
			visited = new boolean[27];
			visited[arr[0][0] - 'A'] = true;

			dfsStack(0, 0, 1);
			System.out.println("#" + TC + " " + MAX);

		}
	}

	public static void dfsStack(int r, int c, int current) {
		if (current > MAX) {
			MAX = current;
		}
		if (MAX == R * C) {
			return;
		}
		for (int i = 0; i < searchR.length; i++) {
			int nr = r + searchR[i];
			int nc = c + searchC[i];
			if (isIn(nr, nc) && !visited[arr[nr][nc] - 'A']) {
				visited[arr[nr][nc] - 'A'] = true;
				dfsStack(nr, nc, current + 1);
				visited[arr[nr][nc] - 'A'] = false;
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static class Point {
		int r, c, sum;

		public Point(int r, int c, int sum) {
			super();
			this.r = r;
			this.c = c;
			this.sum = sum;
		}

	}
}
