package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2146_다리만들기 {
	static int N, result = Integer.MAX_VALUE;
	static Queue<Point> queue = new LinkedList<>();
	static int[][] map;
	static int Idx;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		List<Point> islandList = new ArrayList<>();
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		Idx = 2;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					bfs(r, c);
					Idx++;
				}
			}
		}
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] != 0) {
					result = Math.min(result, bfsBridge(r, c, map[r][c]));
				}
			}
		}
		System.out.println(result+1);
	}

	private static int bfsBridge(int r, int c, int idx) {
		queue.clear();
		queue.offer(new Point(r, c));
		boolean[][] visited = new boolean[N][N];
		visited[r][c] = true;
		int cnt = -2;
		while (!queue.isEmpty()) {
			int size = queue.size();

			cnt++;
			for (int i = 0; i < size; i++) {
				Point top = queue.poll();

				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (isIn(nr, nc) && map[nr][nc] != 0 && map[nr][nc] != idx) {
						return cnt;
					}
					if (isIn(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
						queue.offer(new Point(nr, nc));
						visited[nr][nc] = true;
					}
				}
			}
		}
		return Integer.MAX_VALUE;

	}

	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		boolean[][] visited = new boolean[N][N];
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			map[top.r][top.c] = Idx;
			for (int s = 0; s < search.length; s++) {
				int nr = top.r + search[s][0];
				int nc = top.c + search[s][1];
				if (isIn(nr, nc) && map[nr][nc] == 1 &&!visited[nr][nc]) {
					queue.offer(new Point(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
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
