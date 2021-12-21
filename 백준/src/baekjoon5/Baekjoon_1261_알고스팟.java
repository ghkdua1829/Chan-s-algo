package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1261_알고스팟 {

	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		M = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		int[][] board = new int[N][M];
		int[][] dist = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				board[r][c] = str.charAt(c) - '0';
				dist[r][c] = Integer.MAX_VALUE;
			}
		}
		
		int result = Integer.MAX_VALUE;

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 0));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			if (top.r == N - 1 && top.c == M - 1) {
				result = Math.min(result, top.cnt);
			}
			for (int s = 0; s < search.length; s++) {
				int nr = top.r + search[s][0];
				int nc = top.c + search[s][1];
				int num = 0;
				if (isIn(nr, nc)) {
					if (board[nr][nc] == 1) {
						num = 1;
					}
					if (dist[nr][nc] > top.cnt + num) {
						dist[nr][nc] = top.cnt + num;
						visited[nr][nc] = true;
						queue.offer(new Point(nr, nc, dist[nr][nc]));
					}
				}
			}
		}

		System.out.println(result);
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

}
