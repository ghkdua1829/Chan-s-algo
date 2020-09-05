package kakao_인턴코테;

import java.util.Arrays;

public class problem4 {
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] copyboard;
	static int finalResult = Integer.MAX_VALUE;
	static int[][] nowMoney;

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } };
//		int[][] board = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 0, 0 } };
		solution(board);
	}

	static public int solution(int[][] board) {
		copyboard = new int[board.length][board[0].length];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				copyboard[r][c] = board[r][c];
			}
		}
		int answer = 0;
		boolean[][] visited = new boolean[board.length][board[0].length];
		nowMoney = new int[board.length][board[0].length];
		for (int r = 0; r < nowMoney.length; r++) {
			for (int c = 0; c < nowMoney[0].length; c++) {
				nowMoney[r][c] = Integer.MAX_VALUE;
			}
		}
		visited[0][0] = true;
		nowMoney[0][0] = 0;
		dfs(new Point(0, 0, -1, 0, 0), visited);
		answer = finalResult;
		System.out.println(answer);
		return answer;
	}

	private static void dfs(Point point, boolean[][] visited) {
		if (point.r == copyboard.length - 1 && point.c == copyboard[0].length - 1) {
			int result = 500 * point.corner + 100 * point.straight;

			if (finalResult > result) {
				nowMoney[point.r][point.c] = result;
				finalResult = result;
			}
		} else {
			for (int s = 0; s < search.length; s++) {
				int nr = point.r + search[s][0];
				int nc = point.c + search[s][1];

				if (isIn(nr, nc) && copyboard[nr][nc] == 0 && !visited[nr][nc]
						&& (nowMoney[nr][nc] >= 500 * point.corner + 100 * point.straight)) {
					int tempDir = point.dir;
					int tempR = point.r;
					int tempC = point.c;
					int tempStraight = point.straight;
					int tempCorner = point.corner;

					if (point.dir != -1) {
						if (point.dir != s) {
							point.corner++;
						}
					}
					point.dir = s;
					point.straight++;
					point.r = nr;
					point.c = nc;
					if (nowMoney[nr][nc] > 500 * point.corner + 100 * point.straight) {
						nowMoney[nr][nc] = 500 * point.corner + 100 * point.straight;

					}
					visited[nr][nc] = true;

					dfs(point, visited);

					visited[nr][nc] = false;

					point.dir = tempDir;
					point.straight = tempStraight;
					point.corner = tempCorner;
					point.r = tempR;
					point.c = tempC;
				}

			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < copyboard.length && c < copyboard[0].length;
	}

	static class Point {
		int r, c, dir, straight, corner;

		public Point(int r, int c, int dir, int straight, int corner) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.straight = straight;
			this.corner = corner;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", dir=" + dir + ", straight=" + straight + ", corner=" + corner
					+ "]";
		}

	}
}
