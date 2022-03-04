package level2;

import java.util.*;

public class 거리두기확인하기 {

	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int R, C;

	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		Arrays.fill(answer, 1);
		R = places.length;
		C = places[0].length;

		for (int i = 0; i < R; i++) {
			String[][] board = new String[5][5];
			boolean isOk = true;
			for (int j = 0; j < C; j++) {
				String str = places[i][j];
				for (int c = 0; c < C; c++) {
					board[j][c] = String.valueOf(str.charAt(c));
				}
			}
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (board[r][c].equals("P")) {
						isOk = bfs(r, c, board);
						if (!isOk) {

							answer[i] = 0;
							r = R;
							c = C;
						}
					}
				}
			}
		}
		return answer;
	}

	static boolean bfs(int r, int c, String[][] board) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		boolean[][] visited = new boolean[5][5];
		visited[r][c] = true;
		int count = 0;
		while (count < 2) {
			count++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point top = queue.poll();
				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (isIn(nr, nc) && !visited[nr][nc]) {
						if (board[nr][nc].equals("P")) {
							// System.out.println(top.r+","+top.c);
							// System.out.println(nr+","+nc);

							return false;
						} else if (board[nr][nc].equals("O")) {
							queue.offer(new Point(nr, nc));
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
		return true;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
