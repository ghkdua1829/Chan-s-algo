package 코드챌린지;

import java.util.Arrays;

public class Problem2 {
	static int[][] search = { { 1, 0 }, { 0, 1 }, { -1, -1 } };
	static int[][] board;

	public static void main(String[] args) {
		solution(4);
	}

	static public int[] solution(int n) {
		int[] answer = new int[n * (n + 1) / 2];
		board = new int[n][n];
		Point point = new Point(0, 0);
		int num = 1;
		int searchIdx = 0;
		for (int i = 0; i < n; i++) {
			while (true) {
				if (isIn(point.r, point.c) && board[point.r][point.c] == 0) {
					board[point.r][point.c] = num++;
					point.r += search[searchIdx][0];
					point.c += search[searchIdx][1];
				} else {
					point.r -= search[searchIdx][0];
					point.c -= search[searchIdx][1];
					searchIdx = (searchIdx + 1) % 3;
					point.r += search[searchIdx][0];
					point.c += search[searchIdx][1];
					break;
				}
			}
		}
		int idx = 0;
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] != 0) {
					answer[idx++] = board[r][c];
				}
			}
		}
//		for (int[] arr : board) {
//			System.out.println(Arrays.toString(arr));
//		}
		return answer;
	}

	static boolean isIn(int r, int c) {
		return r < board.length && c < board[0].length && r >= 0 && c >= 0;
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
