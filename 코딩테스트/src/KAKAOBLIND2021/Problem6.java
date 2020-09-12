package KAKAOBLIND2021;

public class Problem6 {

	public static void main(String[] args) {

	}

	static public int solution(int[][] board, int r, int c) {
		int answer = 0;
		int count = 0;
		for (int rr = 0; rr < board.length; rr++) {
			for (int cc = 0; cc < board[0].length; cc++) {
				if (board[rr][cc] != 0) {
					count++;
				}
			}
		}
		Point[] card = new Point[count];
		for(int i=0;i<count;i++) {
			card[i]
		}
		int[][][] visited = new int[4][4][(int) Math.pow(2, count)];
		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				for (int cc = 0; cc < (int) Math.pow(2, count); cc++) {
					visited[a][b][cc] = Integer.MAX_VALUE;
				}
			}
		}
		

		return answer;
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
