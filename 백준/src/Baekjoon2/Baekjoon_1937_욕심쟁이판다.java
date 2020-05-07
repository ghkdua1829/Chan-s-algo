package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1937_욕심쟁이판다 {
	static int max = Integer.MIN_VALUE;
	static int n;
	static int[][] search = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][] copy = new int[n][n];

		for (int r = 0; r < n; r++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int c = 0; c < n; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
				copy[r][c] = arr[r][c];
			}
		}
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				bfsQueue(new Point(r, c, arr[r][c]), copy);
			}
		}

		System.out.println(max);
	}

	static void bfsQueue(Point start, int[][] copy) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		int temp = 0;
		queue.offer(start);
		while (!queue.isEmpty()) {
			temp++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point top = queue.poll();
				if (visited[top.r][top.c]) {
					continue;
				}
				visited[top.r][top.c] = true;
				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (isIn(nr, nc) && copy[nr][nc] < top.before && !visited[nr][nc]) {
						queue.offer(new Point(nr, nc, copy[nr][nc]));
					}
				}

			}
		}

		if (max < temp) {
			max = temp;
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < n;
	}

	static class Point {
		int r, c, before;

		public Point(int r, int c, int before) {
			super();
			this.r = r;
			this.c = c;
			this.before = before;
		}

	}

}
