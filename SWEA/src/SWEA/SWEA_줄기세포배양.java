package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_줄기세포배양 {

	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(token.nextToken());
		for (int tc = 1; tc <= TC; tc++) {
			token = new StringTokenizer(br.readLine());

			boolean[][] visited = new boolean[1001][1001];
			int[][] arr = new int[1001][1001];
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());

			Queue<Point> queue = new LinkedList<>();
			for (int r = 500; r < 500 + N; r++) {
				token = new StringTokenizer(br.readLine());
				for (int c = 500; c < 500 + N; c++) {
					visited[r][c] = true;
					queue.offer(new Point(r, c, Integer.parseInt(token.nextToken())));
				}
			}
			System.out.println("#" + tc + " ");
		}
	}

	static class P {
		int r, c;

		public P(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "P [r=" + r + ", c=" + c + "]";
		}

	}

	static class Point {
		int r, c, life;

		public Point(int r, int c, int life) {
			super();
			this.r = r;
			this.c = c;
			this.life = life;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", life=" + life + "]";
		}

	}
}
