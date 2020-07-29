package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_3109_빵집 {
	static int R, C, result;
	static char[][] board;
	static int[][] search = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		board = new char[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				board[r][c] = str.charAt(c);
				if (board[r][c] == 'x') {
					visited[r][c] = true;
				}
			}
		}

		for (int r = 0; r < R; r++) {
			if (dfs(new Point(r, 0))) {
				result++;
			}
		}
		System.out.println(result);

	}

	static boolean dfs(Point before) {
		for (int s = 0; s < search.length; s++) {
			int nr = before.r + search[s][0];
			int nc = before.c + search[s][1];
			if (nc == C - 1) {
				return true;
			}

			if (isIn(nr, nc) && !visited[nr][nc]) {
				visited[nr][nc] = true;
				if (dfs(new Point(nr, nc))) {
					return true;
				}
			}
		}
		return false;
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
