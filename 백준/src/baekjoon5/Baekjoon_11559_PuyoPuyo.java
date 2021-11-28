package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baekjoon_11559_PuyoPuyo {
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] board = new char[12][6];

		for (int r = 0; r < board.length; r++) {
			String str = br.readLine();
			for (int c = 0; c < board[0].length; c++) {
				board[r][c] = str.charAt(c);
			}
		}

		int cnt = 0;

		while (true) {
			boolean bb = bomb(board);
			if (!bb) {
				break;
			}
			down(board);
			cnt++;

		}

			System.out.println(cnt);

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < 12 && c < 6;
	}

	static boolean bomb(char[][] board) {
		int bombCnt = 0;
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] != '.') {
					Queue<Point> queue = new LinkedList<>();
					boolean[][] visited = new boolean[12][6];
					visited[r][c] = true;
					char alpha = board[r][c];
					List<Point> list = new ArrayList<>();
					queue.offer(new Point(r, c));
					while (!queue.isEmpty()) {
						Point top = queue.poll();
						list.add(top);
						for (int s = 0; s < search.length; s++) {
							int nr = top.r + search[s][0];
							int nc = top.c + search[s][1];
							if (isIn(nr, nc) && !visited[nr][nc] && board[nr][nc] == alpha) {
								queue.offer(new Point(nr, nc));
								visited[nr][nc] = true;
							}
						}
					}
					if (list.size() >= 4) {
						for (Point p : list) {
							board[p.r][p.c] = '.';
						}
						bombCnt++;
					}
				}
			}
		}
		if (bombCnt > 0) {
			return true;
		} else {
			return false;
		}
	}

	static void down(char[][] board) {
		for (int c = 0; c < board[0].length; c++) {
			int bottomPoint = board.length - 1;
			for (int r = board.length - 1; r >= 0; r--) {
				char nowPoint = board[r][c];
				if (nowPoint != '.') {
					if (bottomPoint != r) {
						board[bottomPoint][c] = nowPoint;
						board[r][c] = '.';
					}
					bottomPoint--;
				}
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

	}
}
