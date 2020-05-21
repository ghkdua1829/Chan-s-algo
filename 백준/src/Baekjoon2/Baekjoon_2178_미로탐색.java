package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2178_미로탐색 {
	static int N, M;
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
		System.out.println(bfs(new Point(0, 0)));

	}

	static int bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		boolean[][] visited = new boolean[N][M];
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for (int i = 0; i < size; i++) {
				Point top = queue.poll();
				if (top.r == N - 1 && top.c == M - 1) {
					return count;
				}
				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];

					if (isIn(nr, nc) && !visited[nr][nc] && arr[nr][nc] != 0) {
						visited[nr][nc] = true;
						queue.offer(new Point(nr, nc));
					}
				}
			}
		}
		return 0;

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
