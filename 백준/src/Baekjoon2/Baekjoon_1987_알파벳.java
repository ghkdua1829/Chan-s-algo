package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1987_알파벳 {
	static int R, C, result = Integer.MIN_VALUE;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		arr = new char[R][C];
		boolean[] visited = new boolean[26];
		boolean[][] visitedAlpha = new boolean[R][C];
		visitedAlpha[0][0] = true;
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				arr[r][c] = str.charAt(c);
			}
		}
		visited[(int) (arr[0][0]) - 65] = true;
		bfsQueue(new Point(0, 0), visited, visitedAlpha, 1);
		System.out.println(result);
	}

	static void bfsQueue(Point top, boolean[] visitedAlpht, boolean[][] visited, int count) {
		if (result < count) {
			result = count;
		}
		for (int s = 0; s < search.length; s++) {
			int nr = top.r + search[s][0];
			int nc = top.c + search[s][1];
			if (isIn(nr, nc) && !visited[nr][nc] && !visitedAlpht[(int) (arr[nr][nc] - 65)]) {
				visited[nr][nc] = true;
				visitedAlpht[(int) (arr[nr][nc]) - 65] = true;
				bfsQueue(new Point(nr, nc), visitedAlpht, visited, count + 1);
				visited[nr][nc] = false;
				visitedAlpht[(int) (arr[nr][nc]) - 65] = false;
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
