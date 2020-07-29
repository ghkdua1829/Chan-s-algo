package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_15683_감시 {
	static int R, C, result;
	static int[][] board;
	static int[][] dir = { { 1 }, { 1, 3 }, { 1, 2 }, { 1, 2, 3 }, { 1, 2, 3, 4 } };
	static int[][] search = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int CCTVCNT;
	static List<Point> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		board = new int[R][C];
		list = new ArrayList<>();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (board[r][c] != 0) {
					list.add(new Point(r, c, board[r][c]));
				}
			}
		}
		CCTVCNT = list.size();
		solve(0);
	}

	static void solve(int current) {
		if (CCTVCNT == current) {
			int temp = 0;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (board[r][c] == 0) {
						temp++;
					}
				}
			}
			result = Math.min(result, temp);
		} else {
			int num = list.get(current).num;
			switch (num) {
			case 1:
				for (int s = 0; s < search.length; s++) {
					int cnt = 1;
					while (true) {
						int nr = list.get(current).r + cnt * search[s][0];
						int nc = list.get(current).c + cnt * search[s][1];
						if (!isIn(nr, nc) && board[nr][nc] == 6) {
							break;
						}
						board[nr][nc] = 7;
						cnt++;
					}
					solve(current++);
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
		}

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;

	}

	static class Point {
		int r, c, num;

		public Point(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", num=" + num + "]";
		}

	}

}
