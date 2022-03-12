package level2;

public class sk2번 {
	static int[][] search = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) {
		solution(5, false);
	}

	public static int[][] solution(int n, boolean clockwise) {
		int[][] board = new int[n][n];

		Point p1 = new Point(0, 0, 0);
		Point p2 = new Point(0, n - 1, 1);
		Point p3 = new Point(n - 1, n - 1, 2);
		Point p4 = new Point(n - 1, 0, 3);
		int idx = 1;
		int maxIdx = 0;
		if (n % 2 == 1) {
			// 홀수이면
			maxIdx = n * n / 4 + 1;
		} else {
			maxIdx = n * n / 4;
		}
		while (idx <= maxIdx) {
			board[p1.r][p1.c] = idx;
			board[p2.r][p2.c] = idx;
			board[p3.r][p3.c] = idx;
			board[p4.r][p4.c] = idx;

			if (board[p1.r + search[p1.dir][0]][p1.c + search[p1.dir][1]] != 0) {
				p1.dir = (p1.dir + 1) % 4;
				p2.dir = (p2.dir + 1) % 4;
				p3.dir = (p3.dir + 1) % 4;
				p4.dir = (p4.dir + 1) % 4;
			}
			idx++;

			p1.r += search[p1.dir][0];
			p1.c += search[p1.dir][1];
			p2.r += search[p2.dir][0];
			p2.c += search[p2.dir][1];
			p3.r += search[p3.dir][0];
			p3.c += search[p3.dir][1];
			p4.r += search[p4.dir][0];
			p4.c += search[p4.dir][1];
		}
		
		if(!clockwise) {
			reverse(n, board);
		}

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				System.out.print(board[r][c]);
			}
			System.out.println();
		}

		return board;
	}

	static void reverse(int n,int[][] board) {
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if(c>r) {
					int temp = board[r][c];
					board[r][c] = board[c][r];
					board[c][r] = temp;
				}
			}
		}
	}

	static class Point {
		int r, c, dir;

		public Point(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

	}

}
