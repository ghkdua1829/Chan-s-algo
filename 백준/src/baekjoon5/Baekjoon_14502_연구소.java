package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_14502_연구소 {
	static List<Point> list;
	static int[][] board;
	static int[][] search = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int R, C;
	static int maxResult= 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		board = new int[R][C];
		list = new ArrayList<>();

		for (int r = 0; r < R; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				board[r][c] = Integer.parseInt(token.nextToken());
				if (board[r][c] == 0) {
					list.add(new Point(r, c));
				}
			}
		}
		makeCombination(3, 0, new Point[3], 0);
		System.out.println(maxResult);

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static void makeCombination(int r, int current, Point[] temp, int start) {
		if (r == current) {
			int[][] copy = new int[R][C];

			Queue<Point> queue = new LinkedList<Point>();
			boolean[][] visited = new boolean[R][C];

			for (int rr = 0; rr < R; rr++) {
				for (int cc = 0; cc < C; cc++) {
					copy[rr][cc] = board[rr][cc];
					if (copy[rr][cc] == 2) {
						queue.offer(new Point(rr, cc));
						visited[rr][cc] = true;
					}
				}
			}
			for (int i = 0; i < temp.length; i++) {
				copy[temp[i].r][temp[i].c] = 1;
			}
			while (!queue.isEmpty()) {
				Point top = queue.poll();

				for (int s = 0; s < search.length; s++) {
					int nextR = top.r + search[s][0];
					int nextC = top.c + search[s][1];
					if (isIn(nextR, nextC) && !visited[nextR][nextC] && copy[nextR][nextC] == 0) {
						copy[nextR][nextC] = 2;
						queue.offer(new Point(nextR, nextC));
						visited[nextR][nextC] = true;
					}
				}
			}
			int cnt = 0;
			for (int rr = 0; rr < R; rr++) {
				for (int cc = 0; cc < C; cc++) {
					if (copy[rr][cc] == 0) {
						cnt++;
					}
				}
			}

			maxResult = Math.max(cnt, maxResult);

		} else {
			for (int i = start; i < list.size(); i++) {
				temp[current] = list.get(i);
				makeCombination(r, current + 1, temp, i + 1);
			}
		}
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
