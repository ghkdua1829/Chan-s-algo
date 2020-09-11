package level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import level3.블록이동하기.Point;

public class 블록이동하기 {
	static int[][] copyBoard;
	static int n;
	static int[][] search = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int[][][][] visited;

	public static void main(String[] args) {

		int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		solution(board);
	}

	static public int solution(int[][] board) {
		int answer = 0;
		n = board.length;
		copyBoard = new int[n][n];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				copyBoard[r][c] = board[r][c];
			}
		}
		bfsQueue(new Point(0, 0), new Point(0, 1));
		answer = Math.min(visited[n - 2][n - 1][n - 1][n - 1], visited[n - 1][n - 2][n - 1][n - 1]);
//		System.out.println(answer);
		return answer;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < copyBoard.length && c < copyBoard[0].length;
	}

	static void bfsQueue(Point left, Point right) {

		Queue<Point[]> queue = new LinkedList<>();
		Point[] start = { left, right };
		start = sortPoint(start);
		queue.offer(start);
		visited = new int[n][n][n][n];
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				for (int c = 0; c < n; c++) {
					for (int d = 0; d < n; d++) {
						visited[a][b][c][d] = Integer.MAX_VALUE;
					}
				}
			}
		}
		visited[start[0].r][start[0].c][start[1].r][start[1].c] = 0;
		while (!queue.isEmpty()) {
			Point[] now = queue.poll();
			now = sortPoint(now);
//			if (now[0].r == n - 1 && now[0].c == n - 1 && now[1].r == n - 1 && now[1].c == n - 1) {
//
//			}

			for (int s = 0; s < search.length; s++) {
				int nLr = now[0].r + search[s][0];
				int nLc = now[0].c + search[s][1];
				int nRr = now[1].r + search[s][0];
				int nRc = now[1].c + search[s][1];
				if (isIn(nLr, nLc) && isIn(nRr, nRc) && copyBoard[nLr][nLc] != 1 && copyBoard[nRr][nRc] != 1
						&& visited[nLr][nLc][nRr][nRc] >= visited[now[0].r][now[0].c][now[1].r][now[1].c] + 1) {
					visited[nLr][nLc][nRr][nRc] = visited[now[0].r][now[0].c][now[1].r][now[1].c] + 1;
					Point[] next = { new Point(nLr, nLc), new Point(nRr, nRc) };
					queue.offer(next);
				}
			}

			// 오른쪽 밑으로 회전
			if (now[1].r == now[0].r && isIn(now[1].r + 1, now[1].c) && copyBoard[now[1].r + 1][now[1].c] != 1
					&& isIn(now[0].r + 1, now[0].c) && copyBoard[now[0].r + 1][now[0].c] != 1
					&& visited[now[1].r][now[1].c][now[1].r
							+ 1][now[1].c] >= visited[now[0].r][now[0].c][now[1].r][now[1].c] + 1) {
				visited[now[1].r][now[1].c][now[1].r + 1][now[1].c] = visited[now[0].r][now[0].c][now[1].r][now[1].c]
						+ 1;
				Point[] next = { new Point(now[1].r, now[1].c), new Point(now[1].r + 1, now[1].c) };
				queue.offer(next);
			}

			// 오른쪽 위로 회전
			if (now[1].r == now[0].r && isIn(now[1].r - 1, now[1].c) && copyBoard[now[1].r - 1][now[1].c] != 1
					&& isIn(now[0].r - 1, now[0].c) && copyBoard[now[0].r - 1][now[0].c] != 1 && visited[now[1].r
							- 1][now[1].c][now[1].r][now[1].c] >= visited[now[0].r][now[0].c][now[1].r][now[1].c] + 1) {
				visited[now[1].r - 1][now[1].c][now[1].r][now[1].c] = visited[now[0].r][now[0].c][now[1].r][now[1].c]
						+ 1;
				Point[] next = { new Point(now[1].r, now[1].c), new Point(now[1].r - 1, now[1].c) };
				queue.offer(next);
			}

			// 왼쪽 밑으로 회전
			if (now[1].r == now[0].r && isIn(now[0].r + 1, now[0].c) && copyBoard[now[0].r + 1][now[0].c] != 1
					&& isIn(now[1].r + 1, now[1].c) && copyBoard[now[1].r + 1][now[1].c] != 1
					&& visited[now[0].r][now[0].c][now[0].r
							+ 1][now[0].c] >= visited[now[0].r][now[0].c][now[1].r][now[1].c] + 1) {
				visited[now[0].r][now[0].c][now[0].r + 1][now[0].c] = visited[now[0].r][now[0].c][now[1].r][now[1].c]
						+ 1;
				Point[] next = { new Point(now[0].r, now[0].c), new Point(now[0].r + 1, now[0].c) };
				queue.offer(next);
			}

			// 왼쪽 위로 회전
			if (now[1].r == now[0].r && isIn(now[0].r - 1, now[0].c) && copyBoard[now[0].r - 1][now[0].c] != 1
					&& isIn(now[1].r - 1, now[1].c) && copyBoard[now[1].r - 1][now[1].c] != 1 && visited[now[0].r
							- 1][now[0].c][now[0].r][now[0].c] >= visited[now[0].r][now[0].c][now[1].r][now[1].c] + 1) {
				visited[now[0].r - 1][now[0].c][now[0].r][now[0].c] = visited[now[0].r][now[0].c][now[1].r][now[1].c]
						+ 1;
				Point[] next = { new Point(now[0].r, now[0].c), new Point(now[0].r - 1, now[0].c) };
				queue.offer(next);
			}

			// 오른쪽 위로 회전
			if (now[1].c == now[0].c && isIn(now[0].r, now[0].c + 1) && copyBoard[now[0].r][now[0].c + 1] != 1
					&& isIn(now[1].r, now[1].c + 1) && copyBoard[now[1].r][now[1].c + 1] != 1
					&& visited[now[0].r][now[0].c][now[0].r][now[0].c
							+ 1] >= visited[now[0].r][now[0].c][now[1].r][now[1].c] + 1) {
				visited[now[0].r][now[0].c][now[0].r][now[0].c + 1] = visited[now[0].r][now[0].c][now[1].r][now[1].c]
						+ 1;
				Point[] next = { new Point(now[0].r, now[0].c), new Point(now[0].r, now[0].c + 1) };
				queue.offer(next);
			}
			// 왼쪽 위로 회전
			if (now[1].c == now[0].c && isIn(now[0].r, now[0].c - 1) && copyBoard[now[0].r][now[0].c - 1] != 1
					&& isIn(now[1].r, now[1].c - 1) && copyBoard[now[1].r][now[1].c - 1] != 1
					&& visited[now[0].r][now[0].c
							- 1][now[0].r][now[0].c] >= visited[now[0].r][now[0].c][now[1].r][now[1].c] + 1) {
				visited[now[0].r][now[0].c - 1][now[0].r][now[0].c] = visited[now[0].r][now[0].c][now[1].r][now[1].c]
						+ 1;
				Point[] next = { new Point(now[0].r, now[0].c), new Point(now[0].r, now[0].c - 1) };
				queue.offer(next);
			}

			// 왼쪽 아래로 회전
			if (now[1].c == now[0].c && isIn(now[1].r, now[1].c - 1) && copyBoard[now[1].r][now[1].c - 1] != 1
					&& isIn(now[0].r, now[0].c - 1) && copyBoard[now[0].r][now[0].c - 1] != 1
					&& visited[now[1].r][now[1].c
							- 1][now[1].r][now[1].c] >= visited[now[0].r][now[0].c][now[1].r][now[1].c] + 1) {
				visited[now[1].r][now[1].c - 1][now[1].r][now[1].c] = visited[now[0].r][now[0].c][now[1].r][now[1].c]
						+ 1;
				Point[] next = { new Point(now[1].r, now[1].c), new Point(now[1].r, now[1].c - 1) };
				queue.offer(next);
			}
			// 오른쪽 아래로 회전
			if (now[1].c == now[0].c && isIn(now[1].r, now[1].c + 1) && copyBoard[now[1].r][now[1].c + 1] != 1
					&& isIn(now[0].r, now[0].c + 1) && copyBoard[now[0].r][now[0].c + 1] != 1
					&& visited[now[1].r][now[1].c][now[1].r][now[1].c
							+ 1] >= visited[now[0].r][now[0].c][now[1].r][now[1].c] + 1) {
				visited[now[1].r][now[1].c][now[1].r][now[1].c + 1] = visited[now[0].r][now[0].c][now[1].r][now[1].c]
						+ 1;
				Point[] next = { new Point(now[1].r, now[1].c), new Point(now[1].r, now[1].c + 1) };
				queue.offer(next);
			}
		}

	}

	static Point[] sortPoint(Point[] target) {
		Arrays.sort(target, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.r > o2.r) {
					return 1;
				} else if (o1.r < o2.r) {
					return -1;
				} else {
					if (o1.c > o2.c) {
						return 1;
					} else {
						return -1;
					}
				}

			}
		});
		return target;
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
