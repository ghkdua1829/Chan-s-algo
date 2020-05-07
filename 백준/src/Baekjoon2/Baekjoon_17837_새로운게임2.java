package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_17837_새로운게임2 {
	static int N, K;
	static int[][] board;
	static List<Point>[][] dotsList;
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());

		dotsList = new List[N][N];

		board = new int[N][N];
		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(token.nextToken());
				dotsList[r][c] = new ArrayList<>();
			}
		}
		for (int i = 0; i < K; i++) {
			token = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(token.nextToken()) - 1;
			int c = Integer.parseInt(token.nextToken()) - 1;
			int dir = Integer.parseInt(token.nextToken()) - 1;
			dotsList[r][c].add(new Point(i, dir));
		}

		int turn = 0;

		while (true) {

		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	static class Point {
		int num, dir;

		public Point(int num, int dir) {
			super();
			this.num = num;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Point [num=" + num + ", dir=" + dir + "]";
		}

	}
}
