package level2;

import java.util.LinkedList;
import java.util.Queue;

import level2.카카오프렌즈컬러링북.Point;

public class 카카오프렌즈컬러링북 {
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int R, C;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		R = m;
		C = n;
		boolean[][] visited = new boolean[m][n];
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (!visited[r][c] && picture[r][c] != 0) {
					int num = picture[r][c];
					numberOfArea++;
					Queue<Point> queue = new LinkedList<>();
					queue.offer(new Point(r, c));
					visited[r][c] = true;
					int size = 1;
					while (!queue.isEmpty()) {
						Point top = queue.poll();
						for (int s = 0; s < search.length; s++) {
							int nr = top.r + search[s][0];
							int nc = top.c + search[s][1];
							if (isIn(nr, nc) && !visited[nr][nc] && picture[nr][nc] == num) {
								visited[nr][nc] = true;
								queue.offer(new Point(nr, nc));
								size++;
							}
						}
					}
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
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
