package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.TimeoutException;

public class Baekjoon_2194_유닛이동시키기 {
	static int N, M, A, B, K;
	static List<Point> list = new ArrayList<>();
	static int[][] search = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
	static int result;
	static int[][] board;
	static int endR, endC;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		A = Integer.parseInt(token.nextToken());
		B = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		board = new int[N][M];
		for (int i = 0; i < K; i++) {
			token = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(token.nextToken())-1;
			int c = Integer.parseInt(token.nextToken())-1;
			board[r][c] = -1;
		}
		token = new StringTokenizer(br.readLine());
		int startR = Integer.parseInt(token.nextToken()) - 1;
		int startC = Integer.parseInt(token.nextToken()) - 1;

		token = new StringTokenizer(br.readLine());
		endR = Integer.parseInt(token.nextToken()) - 1;
		endC = Integer.parseInt(token.nextToken()) - 1;

		if (N < A && M < B) {
			System.out.println(-1);
		} else {
			bfsQueue(new Point(startR, startC));
			System.out.println(result);
		}

	}

	static void bfsQueue(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		result = -1;
		boolean[][] visited = new boolean[N][M];
		while (!queue.isEmpty()) {
			result++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point top = queue.poll();
				if (top.r == endR && top.c == endC) {
					return;
				}
				if (visited[top.r][top.c]) {
					continue;
				}
				visited[top.r][top.c] = true;

				for (int s = 0; s < search.length; s++) {
					boolean token = false;
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (isIn(nr, nc)) {
						if (!visited[nr][nc]) {
							for (int r = 0; r < A; r++) {
								for (int c = 0; c < B; c++) {
									if (isIn(nr + r, nc + c)) {
										if (board[nr + r][nc + c] == -1) {
											token = true;
											r = A;
											c = B;
										}

									}else {
										
										token = true;
										r = A;
										c = B;
									}
								}
							}
						}
						if (!token) {
							queue.offer(new Point(nr, nc));
						}
					}
				}
			}
		}
		result = -1;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}
}
