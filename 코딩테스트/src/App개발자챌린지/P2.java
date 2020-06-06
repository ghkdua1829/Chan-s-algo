package App개발자챌린지;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P2 {
	static int[][] board = new int[2001][2001];
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] roundSearch = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) {
		String[] moves = { "U", "U", "R", "D", "L", "L", "L", "U", "R", "D", "D", "D", "L", "U", "R", "R", "R", "D",
				"L", "U" };
		System.out.println(solution(moves));
	}

	static public int solution(String[] moves) {
		int answer = 0;
		Point start = new Point(1000, 1000);
		board[start.r][start.c] = 1;
		for (int i = 0; i < moves.length; i++) {
			int dir = -1;
			switch (moves[i]) {
			case "U":
				dir = 0;
				break;
			case "D":
				dir = 1;
				break;
			case "R":
				dir = 2;
				break;
			case "L":
				dir = 3;
				break;
			}
			for (int m = 0; m < 2; m++) {
				start.r += dirs[dir][0];
				start.c += dirs[dir][1];
				board[start.r][start.c] = 1;
			}
		}
		bfsBlack(new Point(0, 0));
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] == 0) {
					boolean token = true;
					for(int s=0;s<roundSearch.length;s++) {
						int nr = r + roundSearch[s][0];
						int nc = c + roundSearch[s][1];
						if(board[nr][nc]!=1) {
							token=false;
							break;
						}
						if(token==false) {
							break;
						}
					}
					if(token) {
						answer++;
					}
				}
			}
		}
		return answer;
	}

	static void bfsBlack(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		board[start.r][start.c] = -1;
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			for (int s = 0; s < dirs.length; s++) {
				int nr = top.r + dirs[s][0];
				int nc = top.c + dirs[s][1];
				if (isIn(nr, nc)) {
					if (board[nr][nc] == 0) {
						board[nr][nc] = 4;
						queue.offer(new Point(nr, nc));
					}
				}
			}
		}
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

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

}
