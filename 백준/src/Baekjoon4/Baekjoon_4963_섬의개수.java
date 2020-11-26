package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_4963_섬의개수 {
	static int[][] search = { { 1, 0 }, { 1, -1 }, { 1, 1 }, { 0, -1 }, { 0, 1 }, { -1, 0 }, { -1, -1 }, { -1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 0;; t++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(token.nextToken());
			int h = Integer.parseInt(token.nextToken());
			if (w == 0 && h == 0) {
				break;
			}
			int[][] board = new int[h][w];
			boolean[][] visited = new boolean[h][w];
			for (int r = 0; r < h; r++) {
				token = new StringTokenizer(br.readLine());
				for (int c = 0; c < w; c++) {
					board[r][c] = Integer.parseInt(token.nextToken());
				}
			}
			int cnt= 0;
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (!visited[r][c] && board[r][c] ==1) {
						cnt++;
						Stack<Point> stack = new Stack<>();
						stack.push(new Point(r, c));
						visited[r][c] = true;
						while (!stack.isEmpty()) {
							Point top = stack.pop();
							for (int s = 0; s < search.length; s++) {
								int nr = top.r + search[s][0];
								int nc = top.c + search[s][1];
								if (isIn(w, h, nr, nc) && !visited[nr][nc] && board[nr][nc]==1) {
									visited[nr][nc] = true;
									stack.push(new Point(nr, nc));
								}
							}
						}
					}
				}
			}
			sb.append(cnt+"\n");

		}
		System.out.println(sb.toString());

	}

	static boolean isIn(int w, int h, int r, int c) {
		return r >= 0 && c >= 0 && r < h && c < w;
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
