package level3;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {
	static int[][] search = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int R, C;
	static int[][] nowMoney;
	static int finalResultMoney = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } };
		solution(board);
	}

	static public int solution(int[][] board) {
		R = board.length;
		C = board[0].length;
		nowMoney = new int[board.length][board[0].length];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				nowMoney[r][c] = Integer.MAX_VALUE;
			}
		}
		nowMoney[0][0] = 0;
		bfsQueue(new Point(0, 0, -1, 0, 0), board);
		int answer = finalResultMoney;
		return answer;
	}

	static void bfsQueue(Point start, int[][] copyBoard) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			Point nowPoint = queue.poll();
			if (nowPoint.r == R - 1 && nowPoint.c == C - 1) {
				if (100 * nowPoint.straight + 500 * nowPoint.corner < finalResultMoney) {
					finalResultMoney = 100 * nowPoint.straight + 500 * nowPoint.corner;
				}
			}

			for (int s = 0; s < search.length; s++) {
				int nr = nowPoint.r + search[s][0];
				int nc = nowPoint.c + search[s][1];
				Point nextPoint = new Point(nr, nc, s, nowPoint.straight, nowPoint.corner);
				if (nowPoint.dir == -1) {
					nextPoint.straight++;
				} else {
					if (nowPoint.dir != s) {
						nextPoint.corner++;
					}
					nextPoint.straight++;
				}
				if (isIn(nr, nc) && copyBoard[nr][nc] == 0
						&& nowMoney[nr][nc] >= 100 * nextPoint.straight + 500 * nextPoint.corner) {
					nowMoney[nextPoint.r][nextPoint.c] = 100 * nextPoint.straight + 500 * nextPoint.corner;
					queue.offer(nextPoint);
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
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
