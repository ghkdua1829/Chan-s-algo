package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_7562_나이트의이동 {
	static Point start, end;
	static int l;
	static int[][] search = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 } };
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			count = 0;
			l = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
			token = new StringTokenizer(br.readLine());
			end = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));

			bfsQueue();
			System.out.println(count);
		}
	}

	static void bfsQueue() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		boolean[][] visited = new boolean[l][l];
		visited[start.r][start.c] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {

				Point top = queue.poll();

				if (top.r == end.r && top.c == end.c) {
					return;
				}
				
				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (isIn(nr, nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.offer(new Point(nr, nc));
					}
				}
			}
			count++;
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < l && c < l;
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
