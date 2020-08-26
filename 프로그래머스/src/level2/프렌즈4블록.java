package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class 프렌즈4블록 {

	static char[][] backBoard;
	static int result = 0;

	public static void main(String[] args) {
		String[] board = { "ABCD", "BACE", "BCDD", "BCDD" };
		System.out.println(solution(4, 4, board));
	}

	static public int solution(int m, int n, String[] board) {
		backBoard = new char[m][n];

		for (int r = 0; r < board.length; r++) {
			String str = board[r];
			for (int c = 0; c < str.length(); c++) {
				char character = str.charAt(c);
				backBoard[r][c] = character;
			}
		}
		while (broom()) {
			downBoard();
		}

		for (int r = 0; r < backBoard.length; r++) {
			for (int c = 0; c < backBoard[0].length; c++) {
				if (backBoard[r][c] == '-') {
					result++;
				}
			}

		}
//		for(char[] c:backBoard) {
//			System.out.println(Arrays.toString(c));
//		}

		int answer = result;
		return answer;
	}

	static boolean broom() {
		boolean token = false;
		Set<Point> set = new HashSet<>();
		for (int r = 0; r < backBoard.length - 1; r++) {
			for (int c = 0; c < backBoard[0].length - 1; c++) {
				char alpha = backBoard[r][c];
				if (backBoard[r + 1][c] == alpha && backBoard[r][c + 1] == alpha && backBoard[r + 1][c + 1] == alpha
						&& backBoard[r][c] != '-') {
					set.add(new Point(r, c));
					set.add(new Point(r + 1, c));
					set.add(new Point(r, c + 1));
					set.add(new Point(r + 1, c + 1));
					token = true;
				}
			}
		}
		Iterator<Point> it = set.iterator();
		while (it.hasNext()) {
			Point next = it.next();
			backBoard[next.r][next.c] = '-';
		}

		return token;
	}

	static void downBoard() {
		char[][] copy = new char[backBoard.length][backBoard[0].length];
		for (int r = 0; r < backBoard.length; r++) {
			for (int c = 0; c < backBoard[0].length; c++) {
				copy[r][c] = '-';
			}

		}
		for (int c = 0; c < backBoard[0].length; c++) {
			int rr = backBoard.length - 1;
			for (int r = backBoard.length-1; r >=0; r--) {
				if (backBoard[r][c] != '-') {
					copy[rr--][c] = backBoard[r][c];
				}
			}
		}
		for (int r = 0; r < backBoard.length; r++) {
			for (int c = 0; c < backBoard[0].length; c++) {
				backBoard[r][c] = copy[r][c];
			}

		}
	}

	static class Point {
		int r, c;

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
