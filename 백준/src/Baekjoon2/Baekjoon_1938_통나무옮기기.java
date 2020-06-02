package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baekjoon_1938_통나무옮기기 {
	static int N, MIN = Integer.MAX_VALUE;
	static char[][] arr;
	static List<Point> B = new ArrayList<>();
	static List<Point> E = new ArrayList<>();
	static int[][] roundSearch = { { -1, -1 }, { -1, 1 }, { -1, 0 }, { 1, -1 }, { 1, 1 }, { 1, 0 }, { 0, -1 },
			{ 0, 1 } };
	static int[][][] visited;
	static Point result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new char[N][N];
		visited = new int[N][N][2];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				arr[r][c] = str.charAt(c);
				if (arr[r][c] == 'B') {
					B.add(new Point(r, c));
				}
				if (arr[r][c] == 'E') {
					E.add(new Point(r, c));
				}
			}
		}
		if (E.get(0).r == E.get(1).r) {
			result = new Point(E.get(1).r, E.get(1).c, 0);
		} else {
			result = new Point(E.get(1).r, E.get(1).c, 1);

		}
		bfs();
	}

	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		int dir = -1;
		if (B.get(0).r == B.get(1).r) {
			dir = 0;
		} else {
			dir = 1;
		}
		int cnt = -1;
		queue.offer(new Point(B.get(1).r, B.get(1).c, dir));
		visited[B.get(1).r][B.get(1).c][dir] = cnt;
		while (!queue.isEmpty()) {
			cnt++;
			int size = queue.size();
			for (int q = 0; q < size; q++) {
				Point top = queue.poll();
				if (top.r == result.r && top.c == result.c && top.dir == result.dir) {
					System.out.println(cnt);
					return;
				}
				if (top.dir == 0) {
					boolean upOk = true;
					for (int s = 0; s < 3; s++) {
						int nr = top.r + roundSearch[s][0];
						int nc = top.c + roundSearch[s][1];
						if (isIn(nr, nc) && arr[nr][nc] != '1') {

						} else {
							upOk = false;
							break;
						}
					}
					if (upOk) {
						int nr = top.r - 1;
						int nc = top.c;
						if (visited[nr][nc][top.dir] == 0) {
							visited[nr][nc][top.dir] = 1;
							queue.offer(new Point(nr, nc, top.dir));
						}
					}

					boolean downOk = true;
					for (int s = 3; s < 6; s++) {
						int nr = top.r + roundSearch[s][0];
						int nc = top.c + roundSearch[s][1];
						if (isIn(nr, nc) && arr[nr][nc] != '1') {

						} else {
							downOk = false;
							break;
						}
					}
					if (downOk) {
						int nr = top.r + 1;
						int nc = top.c;
						if (visited[nr][nc][top.dir] == 0) {
							visited[nr][nc][top.dir] = 1;
							queue.offer(new Point(nr, nc, top.dir));
						}
					}

					if (isIn(top.r, top.c - 2) && arr[top.r][top.c - 2] != '1') {
						if (visited[top.r][top.c - 1][top.dir] == 0) {
							visited[top.r][top.c - 1][top.dir] = 1;
							queue.offer(new Point(top.r, top.c - 1, top.dir));
						}
					}
					if (isIn(top.r, top.c + 2) && arr[top.r][top.c + 2] != '1') {
						if (visited[top.r][top.c + 1][top.dir] == 0) {
							visited[top.r][top.c + 1][top.dir] = 1;
							queue.offer(new Point(top.r, top.c + 1, top.dir));
						}
					}
				} else {
					boolean leftOk = true;
					for (int s = 0; s < roundSearch.length; s += 3) {
						int nr = top.r + roundSearch[s][0];
						int nc = top.c + roundSearch[s][1];
						if (isIn(nr, nc) && arr[nr][nc] != '1') {

						} else {
							leftOk = false;
							break;
						}
					}
					if (leftOk) {
						int nr = top.r;
						int nc = top.c - 1;
						if (visited[nr][nc][top.dir] == 0) {
							visited[nr][nc][top.dir] = 1;
							queue.offer(new Point(nr, nc, top.dir));
						}
					}

					boolean rightOk = true;
					for (int s = 1; s < roundSearch.length; s += 3) {
						int nr = top.r + roundSearch[s][0];
						int nc = top.c + roundSearch[s][1];
						if (isIn(nr, nc) && arr[nr][nc] != '1') {

						} else {
							rightOk = false;
							break;
						}
					}
					if (rightOk) {
						int nr = top.r;
						int nc = top.c + 1;
						if (visited[nr][nc][top.dir] == 0) {
							visited[nr][nc][top.dir] = 1;
							queue.offer(new Point(nr, nc, top.dir));
						}
					}

					if (isIn(top.r - 2, top.c) && arr[top.r - 2][top.c] != '1') {
						if (visited[top.r - 1][top.c][top.dir] == 0) {
							visited[top.r - 1][top.c][top.dir] = 1;
							queue.offer(new Point(top.r - 1, top.c, top.dir));
						}
					}
					if (isIn(top.r + 2, top.c) && arr[top.r + 2][top.c] != '1') {
						if (visited[top.r + 1][top.c][top.dir] == 0) {
							visited[top.r + 1][top.c][top.dir] = 1;
							queue.offer(new Point(top.r + 1, top.c, top.dir));
						}
					}
				}

				boolean isRoundOk = true;
				for (int s = 0; s < roundSearch.length; s++) {
					int nr = top.r + roundSearch[s][0];
					int nc = top.c + roundSearch[s][1];
					if (isIn(nr, nc) && arr[nr][nc] != '1') {

					} else {
						isRoundOk = false;
						break;
					}
				}
				if (top.dir == 0) {
					if (isRoundOk && visited[top.r][top.c][1] == 0) {
						visited[top.r][top.c][1] = 1;
						queue.offer(new Point(top.r, top.c, 1));
					}
				} else {
					if (isRoundOk && visited[top.r][top.c][0] == 0) {
						visited[top.r][top.c][0] = 1;
						queue.offer(new Point(top.r, top.c, 0));
					}
				}
			}
		}
		System.out.println(0);
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	static class Point {
		int r, c, dir;

		public Point(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

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
