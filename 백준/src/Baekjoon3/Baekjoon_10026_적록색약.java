package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_10026_적록색약 {
	static boolean[][] visited, visited2;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N, resultA, resultB;
	static char[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				arr[r][c] = str.charAt(c);
			}
		}
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) {
					bfsFine(new Point(r, c), arr[r][c]);
				}
				if(!visited2[r][c]) {
					bfsNotFine(new Point(r, c), arr[r][c]);
				}
			}
		}
		System.out.println(resultA+" "+resultB);
	}

	static void bfsFine(Point start, char giho) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.r][start.c] = true;
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			for (int s = 0; s < search.length; s++) {
				int nr = top.r + search[s][0];
				int nc = top.c + search[s][1];
				if (isIn(nr, nc) && !visited[nr][nc] && arr[nr][nc] == giho) {
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc));
				}
			}
		}
		resultA++;
	}

	static void bfsNotFine(Point start, char giho) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		visited2[start.r][start.c] = true;
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			for (int s = 0; s < search.length; s++) {
				int nr = top.r + search[s][0];
				int nc = top.c + search[s][1];
				if (isIn(nr, nc) && !visited2[nr][nc]) {
					if (giho == 'R' || giho == 'G') {
						if (arr[nr][nc] == 'B') {

						} else {
							visited2[nr][nc] = true;
							queue.offer(new Point(nr, nc));
						}
					} else {
						if (arr[nr][nc] == 'B') {
							visited2[nr][nc] = true;
							queue.offer(new Point(nr, nc));
						}
					}
				}
			}
		}
		resultB++;
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
	}
}
