package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14500_테트로미노 {
	static int R, C;
	static int[][] arr;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int max = Integer.MIN_VALUE;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		arr = new int[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				visited[r][c] = true;
				bfs(new Point(r, c), 0, 0);
				fuck(new Point(r, c));
				visited[r][c] = false;

			}
		}
		System.out.println(max);

	}

	static void bfs(Point start, int sum, int current) {
		sum += arr[start.r][start.c];
		if (current == 3) {
			max = Math.max(max, sum);
			return;
		} else {
			for (int s = 0; s < search.length; s++) {
				int nr = start.r + search[s][0];
				int nc = start.c + search[s][1];
				if (isIn(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					bfs(new Point(nr, nc), sum, current + 1);
					visited[nr][nc] = false;
				}
			}
		}
	}

	static void fuck(Point start) {
		int r = start.r;
		int c = start.c;
		int sum = arr[r][c];
		if (r == 0 && (c != 0 && c != C - 1)) {
			max = Math.max(sum + arr[r][c + 1] + arr[r][c - 1] + arr[r + 1][c], max);
		} else if (r == R - 1 && (c != 0 && c != C - 1)) {
			max = Math.max(sum + arr[r - 1][c] + arr[r][c - 1] + arr[r][c + 1], max);
		} else if (c == 0 && (r != 0 && r != R - 1)) {
			max = Math.max(sum + arr[r][c + 1] + arr[r - 1][c] + arr[r + 1][c], max);
		} else if (c == C - 1 && (r != 0 && r != R - 1)) {
			max = Math.max(sum + arr[r][c - 1] + arr[r - 1][c] + arr[r + 1][c], max);
		} else if (r == 0 && c == 0 || r == R - 1 && c == C - 1 || r == R - 1 && c == 0 || r == 0 && c == C - 1) {

		} else {
			max = Math.max(sum + arr[r][c + 1] + arr[r][c - 1] + arr[r + 1][c], max);
			max = Math.max(sum + arr[r - 1][c] + arr[r][c - 1] + arr[r][c + 1], max);
			max = Math.max(sum + arr[r][c + 1] + arr[r - 1][c] + arr[r + 1][c], max);
			max = Math.max(sum + arr[r][c - 1] + arr[r - 1][c] + arr[r + 1][c], max);
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static class Point {
		int r, c;

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
