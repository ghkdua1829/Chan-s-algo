package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_7569_토마토 {

	static int C, R, H;
	static int[][][] board;
	static int[][] search = { { 0, 0, -1 }, { 0, 0, 1 }, { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 } };

	static Queue<Point> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		C = Integer.parseInt(token.nextToken());
		R = Integer.parseInt(token.nextToken());
		H = Integer.parseInt(token.nextToken());

		board = new int[H][R][C];
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < R; r++) {
				token = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					board[h][r][c] = Integer.parseInt(token.nextToken());
					if (board[h][r][c] == 1) {
						queue.offer(new Point(h, r, c));
					}
				}
			}
		}
		int time = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point top = queue.poll();
				for (int s = 0; s < search.length; s++) {
					int nh = top.h + search[s][2];
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (isIn(nh, nr, nc) && board[nh][nr][nc] == 0) {
						queue.offer(new Point(nh, nr, nc));
						board[nh][nr][nc] = 1;
					}
				}
			}
			time++;
		}
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(board[h][r][c]==0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(time);

	}

	static boolean isIn(int h, int r, int c) {
		return h >= 0 && r >= 0 && c >= 0 && h < H && r < R && c < C;
	}

	static class Point {
		int h, r, c;

		public Point(int h, int r, int c) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [h=" + h + ", r=" + r + ", c=" + c + "]";
		}

	}

}
