package App개발자챌린지;

import java.util.Stack;

public class P1 {
	static int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static int[][] copyBoard = new int[15][15];
	static int answer;

	public static void main(String[] args) {
		int[][] board = { 
				{ 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 1, 2, 0, 2, 0, 1, 1, 0, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 1, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		System.out.println(solution(board));
	}

	static public int solution(int[][] board) {
		answer = 0;
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				copyBoard[r][c] = board[r][c];
			}
		}
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] != 0) {

					for (int s = 0; s < 8; s++) {
						int backr = r - dirs[s][0];
						int backc = c - dirs[s][1];
						int pcnt = 0;
						while (isIn(backr, backc)) {
							if (copyBoard[backr][backc] == copyBoard[r][c]) {
								pcnt++;
								backr -= dirs[s][0];
								backc -= dirs[s][1];
							} else {
								break;
							}
						}
						dfs(new Point(r, c, pcnt), s);
					}
				}
			}
		}
		return answer;
	}

	static void dfs(Point p, int dir) {
		int nr = p.r + dirs[dir][0];
		int nc = p.c + dirs[dir][1];

		if (isIn(nr, nc)) {
			if (copyBoard[nr][nc] == copyBoard[p.r][p.c]) {
				dfs(new Point(nr, nc, p.cnt + 1), dir);
			}else {
				if (p.cnt == 4) {
					answer = copyBoard[p.r][p.c];
				}
//				System.out.println(dir + ":" + p.cnt);
				return;
				
			}
		}
		
		return;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < 15 && c < 15;
	}

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}
}
