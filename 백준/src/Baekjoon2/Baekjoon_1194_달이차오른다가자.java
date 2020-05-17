package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1194_달이차오른다가자 {
	static int R, C;
	static char[][] arr;
	static boolean[][][] visited;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		arr = new char[R][C];
		Point start = new Point(0, 0, 0);
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				arr[r][c] = str.charAt(c);
				if (arr[r][c] == '0') {
					start = new Point(r, c, 0);
				}
			}
		}

		visited = new boolean[R][C][1 << 6];
		System.out.println(bfs(start));
	}

	private static int bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.r][start.c][start.key] = true;
		int time = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point top = queue.poll();

				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					int key = top.key;

					if (isIn(nr, nc) && arr[nr][nc] != '#') {
						if (arr[nr][nc] == '1') {
							return time;
						}

						if (arr[nr][nc] <= 'f' && arr[nr][nc] >= 'a') {
							key = key | (1 << arr[nr][nc] - 'a');
						}
						if (arr[nr][nc] <= 'F' && arr[nr][nc] >= 'A') {
							if ((key & (1 << arr[nr][nc] - 'A')) == 0) {
								continue;
							}
						}
						if (visited[nr][nc][key]) {
							continue;
						}
						visited[nr][nc][key] = true;
						queue.offer(new Point(nr, nc, key));

					}
				}
			}
			time++;
		}
		return -1;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static class Point {
		int r, c, key;

		public Point(int r, int c, int key) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", key=" + key + "]";
		}

	}
}
