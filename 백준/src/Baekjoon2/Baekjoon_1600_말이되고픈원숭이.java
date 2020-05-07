package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1600_말이되고픈원숭이 {
	static int K, R, C, Min = Integer.MAX_VALUE;
	static int[][] arr;
	static int[][] horseSearch = { { 1, 2 }, { 2, 1 }, { 1, -2 }, { 2, -1 }, { -1, 2 }, { -2, 1 }, { -1, -2 },
			{ -2, -1 } };
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		C = Integer.parseInt(token.nextToken());
		R = Integer.parseInt(token.nextToken());
		arr = new int[R][C];
		for (int r = 0; r < R; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		bfsQueue(new Point(0, 0, 0));
	}

	static void bfsQueue(Point start) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[R][C][31];
		queue.offer(start);
		int count = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for (int i = 0; i < size; i++) {
				Point top = queue.poll();
				if (visited[top.r][top.c][top.horseCount]) {
					continue;
				}
				visited[top.r][top.c][top.horseCount] = true;
				if (top.r == R - 1 && top.c == C - 1) {
					System.out.println(count);
					return;
				}
				if (top.horseCount < K) {
					for (int s = 0; s < horseSearch.length; s++) {
						int nr = top.r + horseSearch[s][0];
						int nc = top.c + horseSearch[s][1];
						int nh = top.horseCount + 1;
						if (isIn(nr, nc) && arr[nr][nc] != 1 && !visited[nr][nc][nh]) {
							queue.offer(new Point(nr, nc, nh));
						}
					}
				}
				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];

					if (isIn(nr, nc) && arr[nr][nc] != 1 && !visited[nr][nc][top.horseCount]) {
						queue.offer(new Point(nr, nc, top.horseCount));
					}
				}
			}
		}
		System.out.println(-1);
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static class Point {
		int r, c, horseCount;

		public Point(int r, int c, int horseCount) {
			this.r = r;
			this.c = c;
			this.horseCount = horseCount;
		}

	}
}
