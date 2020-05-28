package Baekjoon2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class practice {
	static int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {
		bfs(new Point(2, 2));
	}

	static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<practice.Point>();
		queue.offer(start);
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		visited[0][0] = true;
		int time = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			time++;
			for (int i = 0; i < size; i++) {
				Point top = queue.poll();
				if (arr[top.r][top.c] == 9) {
					System.out.println(time);
					return;
				}
				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (isIn(nr, nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.offer(new Point(nr, nc));

					}
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < arr.length && c < arr[0].length;
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
