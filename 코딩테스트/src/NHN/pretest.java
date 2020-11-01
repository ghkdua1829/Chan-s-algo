package NHN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class pretest {
	static int[][] board;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		int sizeOfMatrix =6;
		int[][] matrix= {{0,0,1,1,1,1},{0,0,1,1,1,1},{0,0,1,1,1,1},{0,0,1,1,1,1},{0,0,1,1,1,1},{0,0,1,1,1,1}};
		solution(sizeOfMatrix, matrix);
	}

	private static void solution(int sizeOfMatrix, int[][] matrix) throws NumberFormatException, IOException {
		// TODO: 이곳에 코드를 작성하세요.
		board = new int[sizeOfMatrix][sizeOfMatrix];
		for (int r = 0; r < sizeOfMatrix; r++) {
			for (int c = 0; c < sizeOfMatrix; c++) {
				board[r][c] = matrix[r][c];
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int r = 0; r < sizeOfMatrix; r++) {
			for (int c = 0; c < sizeOfMatrix; c++) {
				if (board[r][c] == 1) {
					list.add(bfsQueue(new Point(r, c)));
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int i : list) {
			System.out.print(i + " ");
		}
	}

	static int bfsQueue(Point start) {
		Queue<Point> queue = new LinkedList<pretest.Point>();
		int count = 1;
		queue.offer(start);
		boolean[][] visited = new boolean[board.length][board.length];
		visited[start.r][start.c] = true;
		board[start.r][start.c] = 0;
		while (!queue.isEmpty()) {
			Point top = queue.poll();

			for (int s = 0; s < search.length; s++) {
				int nr = top.r + search[s][0];
				int nc = top.c + search[s][1];
				if ( isIn(nr, nc) &&!visited[nr][nc] && board[nr][nc] == 1) {
					visited[nr][nc] = true;
					count++;
					board[nr][nc] = 0;
					queue.offer(new Point(nr, nc));
				}
			}
		}
		return count;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c > 0 && r < board.length && c < board.length;
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
