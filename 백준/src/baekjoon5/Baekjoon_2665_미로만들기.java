package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2665_미로만들기 {
	static int n, INF = 12345678,result;
	static int[][] board;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		for (int r = 0; r < n; r++) {
			String str = br.readLine();
			for (int c = 0; c < n; c++) {
				board[r][c] = str.charAt(c) - '0';
			}
		}
		bfs();
		System.out.println(result);
	}

	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 0));
		int[][] visited = new int[n][n];
		for (int r = 0; r < n; r++) {
			Arrays.fill(visited[r], INF);
		}
		result = INF;
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			if (top.r == n - 1 && top.c == n - 1) {
				result = Math.min(result, top.blackCnt);
			}
			
			for (int s = 0; s < search.length; s++) {
				int nr = top.r + search[s][0];
				int nc = top.c + search[s][1];
				if (isIn(nr, nc)) {
					if (board[nr][nc] == 0) { // 다음 것이 검은 벽이라면
						if (visited[nr][nc] > top.blackCnt + 1) {
							visited[nr][nc] = top.blackCnt + 1;
							queue.offer(new Point(nr, nc, visited[nr][nc]));
						}
					} else {
						if (visited[nr][nc] > top.blackCnt) {
							visited[nr][nc] = top.blackCnt;
							queue.offer(new Point(nr, nc, visited[nr][nc]));
						}
					}
				}
			}
		}
	}

	static class Point {
		int r, c, blackCnt;

		public Point(int r, int c, int blackCnt) {
			super();
			this.r = r;
			this.c = c;
			this.blackCnt = blackCnt;
		}

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < n;
	}
}
