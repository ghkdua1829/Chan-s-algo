package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_1012_유기농배추 {
	static int rSize, cSize;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int result = 0;
			StringTokenizer token = new StringTokenizer(br.readLine());
			rSize = Integer.parseInt(token.nextToken());
			cSize = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
			arr = new int[rSize][cSize];
			boolean[][] visited = new boolean[rSize][cSize];

			for (int i = 0; i < K; i++) {
				token = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(token.nextToken());
				int c = Integer.parseInt(token.nextToken());
				arr[r][c] = 1;
			}
			for (int r = 0; r < rSize; r++) {
				for (int c = 0; c < cSize; c++) {
					if (arr[r][c] == 1) {
						result++;
						dfsStack(new Point(r, c), visited);
					}
				}

			}
			System.out.println(result);
		}
	}

	private static void dfsStack(Point point, boolean[][] visited) {
		Stack<Point> stack = new Stack<>();
		stack.push(point);
		while (!stack.isEmpty()) {
			Point top = stack.pop();
			if (visited[top.r][top.c]) {
				continue;
			}
			
			visited[top.r][top.c] = true;
			arr[top.r][top.c] = 0;

			for (int s = 0; s < search.length; s++) {
				int nr = top.r + search[s][0];
				int nc = top.c + search[s][1];
				if (isIn(nr, nc) && arr[nr][nc] == 1) {
					stack.push(new Point(nr, nc));
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && c < cSize && r < rSize;
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
