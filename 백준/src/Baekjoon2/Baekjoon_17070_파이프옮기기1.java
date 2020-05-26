package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_17070_파이프옮기기1 {
	static int[][] arr;
	static int N, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		dfs(new Point(0, 1, 1));
		System.out.println(cnt);
	}

	static void dfs(Point start) {
		if (start.r == N - 1 && start.c == N - 1) {
			cnt++;
			return;
		} else {
			switch (start.dir) {
			case 1:
				if (isIn(start.r, start.c + 1) && arr[start.r][start.c + 1] != 1) {
					dfs(new Point(start.r, start.c + 1, 1));
				}
				if (isIn(start.r + 1, start.c + 1) && arr[start.r + 1][start.c + 1] != 1
						&& arr[start.r][start.c + 1] != 1 && arr[start.r + 1][start.c] != 1) {
					dfs(new Point(start.r + 1, start.c + 1, 2));
				}
				break;
			case 2:
				if (isIn(start.r, start.c + 1) && arr[start.r][start.c + 1] != 1) {
					dfs(new Point(start.r, start.c + 1, 1));
				}
				if (isIn(start.r + 1, start.c + 1) && arr[start.r + 1][start.c + 1] != 1
						&& arr[start.r][start.c + 1] != 1 && arr[start.r + 1][start.c] != 1) {
					dfs(new Point(start.r + 1, start.c + 1, 2));
				}
				if (isIn(start.r + 1, start.c) && arr[start.r + 1][start.c] != 1) {
					dfs(new Point(start.r + 1, start.c, 3));
				}

				break;
			case 3:
				if (isIn(start.r + 1, start.c + 1) && arr[start.r + 1][start.c + 1] != 1
						&& arr[start.r][start.c + 1] != 1 && arr[start.r + 1][start.c] != 1) {
					dfs(new Point(start.r + 1, start.c + 1, 2));
				}
				if (isIn(start.r + 1, start.c) && arr[start.r + 1][start.c] != 1) {
					dfs(new Point(start.r + 1, start.c, 3));
				}
				break;
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	static class Point {
		int r, c, dir;

		public Point(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

	}

}
