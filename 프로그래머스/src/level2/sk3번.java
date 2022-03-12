package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class sk3번 {
	static int[][] search = { { 1, 0 }, { 0, 1 } };
	static int[][] board;

	public static void main(String[] args) {
		Point[] arr = new Point[3];
		board = new int[3][3];
		System.out.println(bfs());

	}

	public static int solution(int width, int height, int[][] diagonals) {
		int answer = 0;
		board = new int[width + 1][height + 1];
		answer = bfs() * diagonals.length;

		return answer;
	}

	static int bfs() {
		Queue<Point> pq = new LinkedList();
		pq.offer(new Point(0, 0));
		int answer = 0;
		while (!pq.isEmpty()) {
			Point top = pq.poll();

			if (top.r == board.length - 1 && top.c == board[0].length - 1) {
				answer = (answer + 1) % 10000019;
				continue;
			}
			for (int s = 0; s < search.length; s++) {
				int nr = top.r + search[s][0];
				int nc = top.c + search[s][1];
				if (isIn(nr, nc)) {
					pq.offer(new Point(nr, nc));
				}
			}
		}
		return answer;

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < board.length && c < board[0].length;
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
