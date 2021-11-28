package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2667_단지번호붙이기 {
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				int num = str.charAt(c) - '0';
				board[r][c] = num;
			}
		}
		int count = 0;
		List<Integer> list =new ArrayList<>();
		boolean[][] visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int cnt = 0;
				if (!visited[r][c] && board[r][c] != 0) {
					count++;
					Queue<Point> queue = new LinkedList<>();
					queue.offer(new Point(r, c));
					visited[r][c] = true;
					while (!queue.isEmpty()) {
						cnt++;
						Point top = queue.poll();
						for (int d = 0; d < dir.length; d++) {
							int nextR = top.r + dir[d][0];
							int nextC = top.c + dir[d][1];
							if (isIn(nextR, nextC) && !visited[nextR][nextC] && board[nextR][nextC] != 0) {
								visited[nextR][nextC] = true;
								queue.offer(new Point(nextR, nextC));
							}
						}
					}
					list.add(cnt);
				}
			}
		}
		System.out.println(count);
		Collections.sort(list);
		for(int i:list) {
			System.out.println(i);
		}

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
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
