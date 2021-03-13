package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_16948_데스나이트 {
	static int[][] search = { { -2, -1 }, { -2, 1 }, { 0, -2 }, { 0, 2 }, { 2, -1 }, { 2, 1 } };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer token = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(token.nextToken());
		int c1 = Integer.parseInt(token.nextToken());
		int r2 = Integer.parseInt(token.nextToken());
		int c2 = Integer.parseInt(token.nextToken());

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r1, c1));
		boolean[][] visited = new boolean[N][N];
		visited[r1][c1] = true;
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for (int i = 0; i < size; i++) {
				Point top = queue.poll();
				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (isIn(nr, nc) && !visited[nr][nc]) {
						if (nr == r2 && nc == c2) {
							System.out.println(count);
							return;
						}
						queue.offer(new Point(nr, nc));
						visited[nr][nc] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	static class Point {
		int r, c;

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
