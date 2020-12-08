package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_16918_봄버맨 {
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		int N = Integer.parseInt(token.nextToken());
		int time = 0;
		Bomb[][] board = new Bomb[R][C];
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				boolean isBomb = (str.charAt(c) == 'O') ? true : false;
				board[r][c] = new Bomb(isBomb);
			}
		}
		if (N == 1) {
			System.out.println(buildString(board));
			return;
		}
		// 다음 1초 동안 봄버맨은 아무것도 하지 않는다.
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (board[r][c].isBomb) {
					board[r][c].time--;
					if (board[r][c].time == 0) {
						board[r][c].isBomb = false;
					}
				}
			}
		}
		time++;

		if (N == 2) {
			System.out.println(buildString(board));
			return;
		}
		while (time < N) {
			// 다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다. 즉, 모든 칸은 폭탄을 가지고 있게 된다. 폭탄은 모두 동시에
			// 설치했다고 가정한다.

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (!board[r][c].isBomb) {
						board[r][c] = new Bomb(true);
					} else {
						board[r][c].time--;
					}
				}
			}
			// 1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다.
			List<Point> list = new ArrayList<>();
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (board[r][c].time == 0 && board[r][c].isBomb) {
						list.add(new Point(r, c));
					}
				}
			}
			for (Point b : list) {
				board[b.r][b.c].isBomb = false;
				board[b.r][b.c].time = 0;
				for (int s = 0; s < search.length; s++) {
					int nr = b.r + search[s][0];
					int nc = b.c + search[s][1];
					if (isIn(nr, nc)) {
						board[nr][nc].isBomb = false;
						board[nr][nc].time = 0;
					}
				}
			}
			time++;
			if (time >= N) {
				break;
			}
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (board[r][c].isBomb) {
						board[r][c].time--;
					}
				}
			}
			// 1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다.
			list = new ArrayList<>();
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (board[r][c].time == 0 && board[r][c].isBomb) {
						list.add(new Point(r, c));
					}
				}
			}
			for (Point b : list) {
				board[b.r][b.c].isBomb = false;
				board[b.r][b.c].time = 0;
				for (int s = 0; s < search.length; s++) {
					int nr = b.r + search[s][0];
					int nc = b.c + search[s][1];
					if (isIn(nr, nc)) {
						board[nr][nc].isBomb = false;
						board[nr][nc].time = 0;
					}
				}
			}
			time++;
		}
		System.out.println(buildString(board));

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static String buildString(Bomb[][] board) {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				char bomb = (board[r][c].isBomb ? 'O' : '.');
				if (board[r][c].time == 0) {
					bomb = '.';
				}
				sb.append(bomb);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static class Bomb {
		boolean isBomb;
		int time;

		public Bomb(boolean isBomb) {
			super();
			this.isBomb = isBomb;
			if (isBomb) {
				this.time = 3;
			} else {
				this.time = 0;
			}
		}

		@Override
		public String toString() {
			return "Bomb [isBomb=" + isBomb + ", time=" + time + "]";
		}

	}

}
