package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2638_치즈 {
	static int[][] board;
	static int N, M;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		board = new int[N][M];
		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				board[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		int answer = 0;
		while (true) {
			answer++;

			Queue<Point> queue = new LinkedList<>();
			queue.offer(new Point(0, 0));
			boolean[][] visited = new boolean[N][M];
			visited[0][0] = true;
			board[0][0] = -1;
			while (!queue.isEmpty()) {
				Point top = queue.poll();
				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (isIn(nr, nc) && !visited[nr][nc] && board[nr][nc] != 1) {
						visited[nr][nc] = true;
						board[nr][nc] = -1;
						queue.offer(new Point(nr, nc));
					}
				}
			}
//			for(int[] arr:board) {
//				System.out.println(Arrays.toString(arr));
//			}

			List<Point> list = new ArrayList<>();
			for (int r = 1; r < N - 1; r++) {
				for (int c = 1; c < M - 1; c++) {
					if (board[r][c] == 1) {
						int cnt = 0;
						for (int s = 0; s < search.length; s++) {
							int nr = r + search[s][0];
							int nc = c + search[s][1];
							if (board[nr][nc] == -1) {
								cnt++;
							}
						}
						if (cnt >= 2) {
							list.add(new Point(r, c));
						}
					}
				}
			}
			for (Point p : list) {
				board[p.r][p.c] = -1;
			}
			int nam = 0;
			for (int r = 1; r < N - 1; r++) {
				for (int c = 1; c < M - 1; c++) {
					if (board[r][c] == 1) {
						nam++;
					}
				}
			}
			if (nam == 0) {
				break;
			}
		}
		System.out.println(answer);
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
