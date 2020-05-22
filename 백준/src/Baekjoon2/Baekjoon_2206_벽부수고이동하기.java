package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2206_벽부수고이동하기 {
	static int N, M, min = Integer.MAX_VALUE;
	static int[][] arr;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		arr = new int[N][M];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				arr[r][c] = str.charAt(c) - '0';
			}
		}
		bfs(new Point(0, 0, 0, 0));

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min + 1);
		}
	}

	static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		boolean[][][] visited = new boolean[N][M][2];
		visited[start.r][start.c][0] = true;
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			if (top.r == N - 1 && top.c == M - 1) {
				min = Math.min(top.cnt, min);
				return;
			}
			for (int s = 0; s < search.length; s++) {
				int nr = top.r + search[s][0];
				int nc = top.c + search[s][1];
				if (isIn(nr, nc)) {
					if (top.breakCnt == 1) {
						if (!visited[nr][nc][top.breakCnt] && arr[nr][nc] == 0) {
							queue.offer(new Point(nr, nc, top.cnt + 1, top.breakCnt));
							visited[nr][nc][1] = true;
						}
					} else {
						if (arr[nr][nc] == 1) {
							if (!visited[nr][nc][1]) {
								queue.offer(new Point(nr, nc, top.cnt + 1, 1));
								visited[nr][nc][1] = true;
							}
						}else {
							if(!visited[nr][nc][0]) {
								queue.offer(new Point(nr, nc, top.cnt+1, 0));
								visited[nr][nc][0]= true;
							}
						}
					}
				}
			}
		}
		return;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	static class Point {
		int r, c, cnt;
		int breakCnt;

		public Point(int r, int c, int cnt, int breakCnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.breakCnt = breakCnt;
		}

	}
}
